package ru.dmitry;

import ru.dmitry.client.EchoClient;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import static java.lang.Runtime.*;

/**
 * Chat client entry point
 *
 * Created by Created by Dmitry Kartsev on 23.10.2016.
 */
public class ClientStarter {

    public static final String SERVER_ADDRESS = "localhost";
    public static final int PORT = 5555;
    public static final String STR_CONNECTED = "Соединение установлено.";
    public static final String STR_CONNECTED_INST = "Для выхода из приложения и чата напишите QUIT.";
    public static final String STR_SEPARATOR = ">-----------------------------------------------------------------<";
    public static final String STR_ENTER_MSG = "ВВЕДИТЕ СООБЩЕНИЕ: ";
    public static final String STR_SYS_MSG = "Система: ";
    public static final String STR_SRV_CONNECT = "Пытаемся подключиться к серверу";
    public static final String STR_PORT = ", порт: ";
    public static final String STR_DISCONNECTED = "Отключились от сервера. Работа приложения завершена.";
    public static final String CMD_QUIT = "QUIT";

    public static void main(String args[]) {
        EchoClient client = new EchoClient(SERVER_ADDRESS, PORT);
        client.initConnection();
        System.out.println(STR_SYS_MSG + STR_CONNECTED_INST + "\n" + STR_SYS_MSG + STR_CONNECTED + "\n" + STR_SEPARATOR + "\n");
    }
}
