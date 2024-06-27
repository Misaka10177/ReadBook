package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    @FXML
    public TextField serverIP;
    public TextField inPort;
    public TextField inText;


    InetAddress addr;
    Socket socket;
    BufferedReader cin;
    PrintStream cout;
    public void initialize(){

    }
    @FXML
    public void connect() throws IOException {
        InetAddress addr = InetAddress.getByName(serverIP.getText());
        int port = Integer.parseInt(inPort.getText());
        System.out.println(serverIP.getText()+"xxx"+port);
        Socket socket = new Socket(addr, port);
        cin = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        cout = new PrintStream(socket.getOutputStream());
    }
    public void send() throws IOException {
        String txt = inText.getText();
        cout.println(txt);
        inText.setText("");
    }
}
