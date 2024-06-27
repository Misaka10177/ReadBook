package com.example.demo;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Timer;
import java.util.Vector;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class HelloController {
    @FXML
    public TextField inPort;
    @FXML
    public VBox container;


    public void initialize() throws IOException {
        Text zz = new Text("zz");
        container.getChildren().add(zz);
    }
    ServerSocket server;
    Socket socket;
    BufferedReader cin;
    PrintStream cout;
    public void start() throws IOException, InterruptedException {

        server = new ServerSocket(Integer.parseInt(inPort.getText()));
        if (server != null){
            new Thread(()->{
                try {
                    socket = server.accept();
                    cin = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    cout = new PrintStream(socket.getOutputStream());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                        String txt = "";
                        while (true){
                            try {
                                txt = cin.readLine();
                                Text text = new Text(txt);
                                Platform.runLater(()->{
                                    container.getChildren().add(text);
                                });
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }).start();
        }else {
            System.out.println("null");
        }

//        Runnable run = ()->{
//            String txt = "";
//            try {
//                txt = cin.readLine();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//            Text text = new Text(txt);
//            txt="";
//            container.getChildren().add(text);
//        };
//        Timer timer = new Timer();
//        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
//        service.scheduleAtFixedRate(run,0,1, TimeUnit.SECONDS);

    }
    @FXML
    public void begin() throws IOException, InterruptedException {
        start();
    }

}
class newThread extends Thread{
    public void run(){

        System.out.println("ppp");
    }
}