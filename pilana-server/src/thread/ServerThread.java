/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import util.PropertyReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dudat
 */
public class ServerThread extends Thread {

    private final ServerSocket serverSocket;
    private List<ClientThread> clients;

    public ServerThread() throws IOException {
        this.serverSocket = new ServerSocket(Integer.valueOf(PropertyReader.getInstance().getProperty("port")));
        clients = new ArrayList<>();
    }

    @Override
    public void run() {
        System.out.println("Server is started successfully, listening on port: " + serverSocket.getLocalPort());

        while (!serverSocket.isClosed()) {
            try {
                Socket newClient = serverSocket.accept();
                
                ClientThread clientThread = new ClientThread(newClient);

                clientThread.start();
                clients.add(clientThread);

                System.out.println("New client is connected: " + newClient.getLocalAddress());
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }
}
