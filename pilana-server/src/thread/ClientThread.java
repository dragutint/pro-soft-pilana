/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import bl.dao.util.ConnectionFactory;
import domain.Client;
import domain.Employee;
import domain.Invoice;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
                    Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Socket getSocket() {
        return socket;
    }

    private ResponseObject handleRequest(RequestObject requestObject) throws SQLException {
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
                case FIND_CLIENTS:
                    data = bl.controller.Controller.getInstance().findClients();
                    msg = "Successfully found all clients."; break;
                case EDIT_CLIENT:
                    bl.controller.Controller.getInstance().editClient((Client)requestObject.getData());
                    msg = "Successfully edited client"; break;
                case DELETE_CLIENT:
                    bl.controller.Controller.getInstance().deleteClient((Client)requestObject.getData());
                    msg = "Successfully deleted client"; break;
                case FIND_WOOD_PRODUCTS:
                    data = bl.controller.Controller.getInstance().findWoodProducts();
                    msg = "Successfully found all wood products"; break;
                case NEW_INVOICE:
                    data = (Invoice) bl.controller.Controller.getInstance().newInvoice((Invoice)requestObject.getData());
                    msg = "Successfully saved new invoice, invoice id: " + ((Invoice)data).getId(); break;
                default:
                    throw new Exception("Invalid operation");
            }            
            return new ResponseObject(DResponseStatus.SUCCESS, msg, data);
        } catch (Exception ex) {
            ConnectionFactory.getInstance().getConnection().rollback();
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseObject(DResponseStatus.ERROR, ex.getMessage(), null);
        }
    }
}
