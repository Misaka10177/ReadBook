package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        server();
        client();

    }

    public static void main(String[] args) {
        launch();
    }
    public void server() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

    }
    public void client() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Client.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage1 = new Stage();
        stage1.setTitle("Hello!");
        stage1.setScene(scene);
        stage1.show();

    }
}