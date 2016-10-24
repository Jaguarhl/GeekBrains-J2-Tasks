package ru.dmitry.client;

import ru.dmitry.ClientStarter;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import static ru.dmitry.client.EchoClient.*;

/**
 * Server listener thread
 *
 * Created by Dmitry Kartsev on 23.10.2016.
 */
public class ServerHandler implements Runnable {
    private Socket socket;
    private PrintWriter output;
    private Scanner inputStream;
    private EchoClient client;
    private Scanner sc = new Scanner(System.in); // creating scanner

    public ServerHandler(Socket sock, EchoClient echoClient) throws IOException {
        this.socket = sock;
        this.client = echoClient;

        try {
            output = new PrintWriter(socket.getOutputStream());
            inputStream = new Scanner(socket.getInputStream());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        String message;
        while(true) {
            if(inputStream.hasNext()) {
                message = inputStream.nextLine();
                System.out.println(message);
            }

            System.out.print(ClientStarter.STR_ENTER_MSG);
            message = sc.nextLine();
            client.sendMessage(message);
            // if client came out
            if (message.equalsIgnoreCase(ClientStarter.CMD_QUIT)) break;
        }
        System.out.println(ClientStarter.STR_DISCONNECTED);
        client.onClose();
    }
}
