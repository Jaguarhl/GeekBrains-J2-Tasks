package ru.dmitry.client;

import ru.dmitry.ClientStarter;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Echo chat client class
 *
 * Created by Dmitry Kartsev on 23.10.2016.
 */
public class EchoClient {

    static private Socket socket;
    static private PrintWriter output;
    static private Scanner inputStream;

    private String host;
    private int port;

    public EchoClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void initConnection() {
        System.out.println(ClientStarter.STR_SYS_MSG + ClientStarter.STR_SRV_CONNECT + " " + this.host + ClientStarter.STR_PORT + this.port);
        try {
            socket = new Socket(host, port);
            output = new PrintWriter(socket.getOutputStream());
            inputStream = new Scanner(socket.getInputStream());
            new Thread((Runnable) new ServerHandler(socket, this)).start();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String msg) {
        if(output != null) {
            output.println(msg);
            output.flush();
        }
    }

    public static void onClose() {
        try {
            output.println(ClientStarter.CMD_QUIT); // sending exit message to server
            output.flush();
            if (socket != null) socket.close();
            if (output != null) output.close();
            if (inputStream != null) inputStream.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
