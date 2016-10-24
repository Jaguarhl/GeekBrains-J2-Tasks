package ru.dmitry.server;

import ru.dmitry.ServerStarter;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/**
 * Client listener thread
 *
 * Created by Created by Dmitry Kartsev on 23.10.2016.
 */
public class ClientHandler implements Runnable {

    private Socket socket;
    private PrintWriter output;
    private Scanner inputStream;

    public ClientHandler(Socket socket) throws IOException {
        try {
            this.socket = socket;
            output = new PrintWriter(socket.getOutputStream());
            inputStream = new Scanner(socket.getInputStream());
            System.out.println(ServerStarter.STR_WELCOME);
            output.println(ServerStarter.STR_WELCOME);
            output.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while(true) {
            if(inputStream != null) {
                if(inputStream.hasNext()) {
                    // getting timestamp for current message
                    String timeStamp = new SimpleDateFormat(ServerStarter.FORMAT_TIME, Locale.US).format(new Date());
                    String message = inputStream.nextLine();
                    System.out.println(message);
                    // if client came out
                    if (message.equalsIgnoreCase(ServerStarter.CMD_QUIT)) break;
                    else if (message.equalsIgnoreCase(ServerStarter.CMD_TIME)) { // or he want to know current time
                        output.println(timeStamp);
                    }
                    else {
                        output.println(ServerStarter.STR_ECHO + timeStamp + message);
                    }
                    output.flush();
                }
            }
        }

        try {
            System.out.println(ServerStarter.STR_CLIENT_DISCONNECTED);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
