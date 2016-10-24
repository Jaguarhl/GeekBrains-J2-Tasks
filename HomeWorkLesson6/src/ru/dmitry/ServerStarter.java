package ru.dmitry;

import ru.dmitry.server.EchoServer;

/**
 * Echo server entry point
 *
 * Created by Dmitry Kartsev on 23.10.2016.
 */
public class ServerStarter {

    public static final String STR_WELCOME = "Добро пожаловать в чат!";
    public static final String STR_ECHO = "echo ";
    public static final String STR_CLIENT_DISCONNECTED = "Клиент отключился от сервера.";
    public static final String CMD_QUIT = "QUIT";
    public static final String CMD_TIME = "TIME";
    public static final String FORMAT_TIME = "MM/dd HH:mm: ";
    public static final String STR_SRV_STOP = "Работа сервера прекращена.";
    public static final String STR_CLIENT_CONNECTED = "К серверу подключился клиент.";
    public static final String STR_SRV_STARTED_AT = "Сервер запущен на сокете: ";

    public static final int S_NUMBER = 5555; // number of socket

    public static void main(String args[]) {
        EchoServer server = new EchoServer(S_NUMBER);
    }
}
