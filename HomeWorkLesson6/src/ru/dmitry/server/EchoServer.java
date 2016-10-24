package ru.dmitry.server;

import ru.dmitry.ServerStarter;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Echo Server main class
 *
 * Created by Created by Dmitry Kartsev on 23.10.2016.
 */
public class EchoServer {

    ServerSocket serverSocket = null; // server
    Socket socket = null; // socket

    public EchoServer(int sNumber) {
        try {
            serverSocket = new ServerSocket(sNumber);
            System.out.println(ServerStarter.STR_SRV_STARTED_AT + sNumber);
            while(true) {
                socket = serverSocket.accept();
                if(socket != null) {
                    System.out.println(ServerStarter.STR_CLIENT_CONNECTED);
                    new Thread((Runnable) new ClientHandler(socket)).start();
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                serverSocket.close();
                System.out.println(ServerStarter.STR_SRV_STOP);
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
