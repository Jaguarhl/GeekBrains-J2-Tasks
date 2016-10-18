package com.dmitry.lesson4.homework;

import com.dmitry.lesson4.homework.view.MainChatWindow;

import javax.swing.*;

/**
 * Here we will create window for chat
 * @author Dmitry Kartsev
 * @version 0.9.7 18/10/2016
 */
public class App {
    private static String APP_NAME = "Окно для чата";
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                MainChatWindow mainChatEWindow = new MainChatWindow(APP_NAME);
                mainChatEWindow.preDisplay();
            }
        });
        //MainChatWindow mainChatWindow = new MainChatWindow(APP_NAME); // creating chat window
    }
}
