package com.example.emailapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;

public class SignUpController {
    Connection conn = null;

    public SignUpController() {
        conn = SingletonConnection.getConnection();
    }
    @FXML
    private TextField emailInput;

    @FXML
    private Label link;

    @FXML
    private TextField nominput;

    @FXML
    private TextField passwordInput;

    @FXML
    private Button signupbtn;

    @FXML
    void onPress(ActionEvent event) {
        try {
            PreparedStatement x = (PreparedStatement) conn.prepareStatement("insert into users(nomcomplet,email,mdp) values(?,?,?)");
            x.setString(1, nominput.getText());
            x.setString(2, emailInput.getText());
            x.setString(3, passwordInput.getText());
            x.execute();
            Stage stage=new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("sign-in.fxml"));
            Parent root = loader.load();
            stage.setTitle("Connexion");
            Scene scene = new Scene(root);
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
            Stage stage1 = (Stage) signupbtn.getScene().getWindow();
            stage1.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    @FXML
    void onPressLink(MouseEvent event) throws IOException {
        Stage stage=new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sign-in.fxml"));
        Parent root = loader.load();
        stage.setTitle("Connexion");
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        Stage stage1 = (Stage) signupbtn.getScene().getWindow();
        stage1.close();
    }
}
