/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import domain.Client;
import domain.Employee;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import transfer.RequestObject;
import transfer.ResponseObject;
import util.DResponseStatus;

/**
 *
 * @author Dudat
 */
public class ClientThread extends Thread {

    private final Socket socket;
    private final ObjectInputStream objectInputStream;
    private final ObjectOutputStream objectOutputStream;

    public ClientThread(Socket socket) throws IOException {
        this.socket = socket;
        objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectOutputStream.flush();
        objectInputStream = new ObjectInputStream(socket.getInputStream());
    }

    @Override
    public void run() {
        while (!socket.isClosed()) {
            try {
                RequestObject requestObject = (RequestObject) objectInputStream.readObject();
                ResponseObject responseObject = handleRequest(requestObject);

                objectOutputStream.writeObject(responseObject);

            } catch (IOException | ClassNotFoundException ex) {
                ResponseObject responseObject = new ResponseObject();
                responseObject.setStatus(DResponseStatus.ERROR);
                responseObject.setMessage(ex.getMessage());

                try {
                    objectOutputStream.writeObject(responseObject);
                } catch (IOException ex1) {
                    System.out.println(ex1.getMessage());
                }
            }
        }
    }

    public Socket getSocket() {
        return socket;
    }

    private ResponseObject handleRequest(RequestObject requestObject) {
        try {
            Object data = null;
            String msg = null;
            
            switch (requestObject.getOperation()) {
                case LOGIN:
                    data = bl.controller.Controller.getInstance().login((Employee) requestObject.getData()); 
                    msg = "Successfully logged in, user: " + data; break;
                case ADD_NEW_CLIENT:
                    data = bl.controller.Controller.getInstance().addNewClient((Client)requestObject.getData());
                    msg = "Successfully added new Client. Generated ID: " + ((Client)data).getId(); break;
                default:
                    throw new Exception("Invalid operation");
            }            
            return new ResponseObject(DResponseStatus.SUCCESS, msg, data);
        } catch (Exception ex) {
            return new ResponseObject(DResponseStatus.ERROR, ex.getMessage(), null);
        }
    }
}
