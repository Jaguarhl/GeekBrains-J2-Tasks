package com.dmitry.lesson4.homework.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.*;

/*
 * Here we are working with chat window
 * @author Dmitry Kartsev
 * @version 0.9.8 18/10/2016 - added timestamp to chat message
*/

public class MainChatWindow {

    String      appName; // store appliction name
    MainChatWindow     mainChatEWindow;
    JFrame      newFrame    = new JFrame(appName);
    JButton     sendMessage;
    JTextField  messageBox;
    JTextArea   chatBox;
    JTextField  nicnameChooser;
    JFrame      chooseNic;

    final int X_SIZE = 800; // size of window in pixels by horizontal
    final int Y_SIZE = 650; // size of window in pixels by vertical
    final int CHARS_NEEDED = 3; // min chars in username

    // translation - buttons, elements, messages and etc.
    final String PICK_NIC = "Укажите своё имя:";
    final String ENTER_CHAT = "Войти в чат";
    final String SEND_MESSAGE = "Отправить";
    final String WELCOME_MSG = "Добро пожаловать в \"какой-то\" чат.\n" +
            "Для получения списка служебных команд отправьте \".help\" в чат\n";
    final String NO_MSG = "Имя пользователя не может состоять меньше чем из 3-х символов!";
    final String CLEAR_CHAT = "Чат очищен\n";
    final String HELP_CMDS = ".clear - очистка чата от сообщений\n";
    final String CLEAR_CMD = ".clear";
    final String HELP_CMD = ".help";

    String  username;

    public MainChatWindow(String appName) {
        this.appName = appName;
    }


    // here we display first window with user name question
    public void preDisplay() {
        newFrame.setVisible(false);
        chooseNic = new JFrame(appName);
        nicnameChooser = new JTextField(15);
        JLabel chooseUsernameLabel = new JLabel(PICK_NIC);
        JButton enterChat = new JButton(ENTER_CHAT);
        enterChat.addActionListener(new enterChatButtonListener());
        JPanel prePanel = new JPanel(new GridBagLayout());

        GridBagConstraints preRight = new GridBagConstraints();
        preRight.insets = new Insets(0, 0, 0, 10);
        preRight.anchor = GridBagConstraints.EAST;
        GridBagConstraints preLeft = new GridBagConstraints();
        preLeft.anchor = GridBagConstraints.WEST;
        preLeft.insets = new Insets(0, 10, 0, 10);
        // preRight.weightx = 2.0;
        preRight.fill = GridBagConstraints.HORIZONTAL;
        preRight.gridwidth = GridBagConstraints.REMAINDER;

        prePanel.add(chooseUsernameLabel, preLeft);
        prePanel.add(nicnameChooser, preRight);
        chooseNic.add(BorderLayout.CENTER, prePanel);
        chooseNic.add(BorderLayout.SOUTH, enterChat);
        chooseNic.getRootPane().setDefaultButton(enterChat);
        chooseNic.setSize(X_SIZE, Y_SIZE);
        chooseNic.setVisible(true);
    }

    // saving printed strings in file
    public void printToFile(String msg) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter("1.txt", true));
            pw.write(msg);
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // displaying main chat window
    public void display() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel southPanel = new JPanel();
        southPanel.setBackground(Color.BLUE);
        southPanel.setLayout(new GridBagLayout());

        messageBox = new JTextField(30);
        messageBox.requestFocusInWindow();

        sendMessage = new JButton(SEND_MESSAGE);
        sendMessage.addActionListener(new sendMessageButtonListener());

        chatBox = new JTextArea();
        chatBox.setEditable(false);
        chatBox.setFont(new Font("Serif", Font.PLAIN, 15));
        chatBox.setLineWrap(true);

        mainPanel.add(new JScrollPane(chatBox), BorderLayout.CENTER);

        GridBagConstraints left = new GridBagConstraints();
        left.anchor = GridBagConstraints.LINE_START;
        left.fill = GridBagConstraints.HORIZONTAL;
        left.weightx = 512.0D;
        left.weighty = 1.0D;

        GridBagConstraints right = new GridBagConstraints();
        right.insets = new Insets(0, 10, 0, 0);
        right.anchor = GridBagConstraints.LINE_END;
        right.fill = GridBagConstraints.NONE;
        right.weightx = 1.0D;
        right.weighty = 1.0D;

        southPanel.add(messageBox, left);
        southPanel.add(sendMessage, right);

        mainPanel.add(BorderLayout.SOUTH, southPanel);

        newFrame.add(mainPanel);
        newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newFrame.setBounds(150, 150, X_SIZE, Y_SIZE);
        newFrame.setSize(X_SIZE, Y_SIZE);
        newFrame.getRootPane().setDefaultButton(sendMessage);
        newFrame.setVisible(true);

        chatBox.setText(WELCOME_MSG);
    }

    class sendMessageButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            // getting timestamp for current message
            String timeStamp = new SimpleDateFormat("MM/dd HH:mm:", Locale.US).format(new Date());

            if (messageBox.getText().length() < 1) {
                // do nothing
            } else if (messageBox.getText().equals(CLEAR_CMD)) { // clear chat
                chatBox.setText(CLEAR_CHAT);
                messageBox.setText("");
            }else if (messageBox.getText().equals(HELP_CMD)) { // display help message
                chatBox.append(HELP_CMDS);
                messageBox.setText("");
            } else { // type user message in chat
                String message = timeStamp + " <" + username + ">:  " + messageBox.getText() + "\n";
                chatBox.append(message);
                printToFile(message);
                messageBox.setText("");
            }
            messageBox.requestFocusInWindow();
        }
    }

    class enterChatButtonListener implements ActionListener { // accepting user name
        public void actionPerformed(ActionEvent event) {
            username = nicnameChooser.getText();
            if (username.length() < CHARS_NEEDED) {
                System.out.println(NO_MSG);
            } else {
                chooseNic.setVisible(false);
                display();
            }
        }
    }
}