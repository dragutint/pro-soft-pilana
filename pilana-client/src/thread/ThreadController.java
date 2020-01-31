/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.JOptionPane;
import transfer.RequestObject;
import transfer.ResponseObject;
import util.DOperation;
import util.DResponseStatus;

/**
 *
 * @author Dudat
 */
public class ThreadController {

    private static ThreadController instance;
    private Socket socket;
    private final ObjectOutputStream objectOutputStream;
    private final ObjectInputStream objectInputStream;

    public static ThreadController getInstance() throws IOException {
        if (instance == null) {
            instance = new ThreadController();
        }
        return instance;
    }

    private ThreadController() throws IOException {
        socket = new Socket("localhost", 9050);
        objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectOutputStream.flush();
        objectInputStream = new ObjectInputStream(socket.getInputStream());        
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
    
    public void closeApp() {
        JOptionPane.showMessageDialog(null, "Error in connection.Check server and restart Application.");
        System.exit(0);
    }

    public ObjectOutputStream getObjectOutputStream() {
        return objectOutputStream;
    }

    public ObjectInputStream getObjectInputStream() {
        return objectInputStream;
    }
    
    public Object request(DOperation operation, Object object) throws IOException, ClassNotFoundException, Exception {
        RequestObject requestObject = new RequestObject();
        requestObject.setOperation(operation);
        requestObject.setData(object);

        objectOutputStream.writeObject(requestObject);
        objectOutputStream.flush();

        ResponseObject responseObject = (ResponseObject) objectInputStream.readObject();

        if (responseObject.getStatus() == DResponseStatus.SUCCESS) {
            return responseObject;
        } else {
            throw new Exception(responseObject.getMessage());
        }
    }
}
