package com.example.emailapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class SignInController {
    Connection conn = null;

    public SignInController() {
        conn = SingletonConnection.getConnection();
    }

    @FXML
    private TextField emailInput;

    @FXML
    private TextField passwordInput;

    @FXML
    private Button signinbtn;

    @FXML
    void onPress(ActionEvent event) {
        ResultSet rs = null;
        try {
            rs = conn.createStatement().executeQuery("select * from users where email='"+emailInput.getText()+"' and mdp='"+passwordInput.getText()+"'");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        while (true) {
            try {
                if (!rs.next()) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                Stage stage=new Stage();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("email-view.fxml"));
                Parent root = loader.load();
                EmailController controller = loader.getController();
                controller.setUserid(rs.getInt("idU"));
                stage.setTitle("Envoyer Email");
                Scene scene = new Scene(root);
                stage.setResizable(false);
                stage.setScene(scene);
                stage.show();
                Stage stage1 = (Stage) signinbtn.getScene().getWindow();
                stage1.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    @FXML
    void onPressLink(MouseEvent event) throws IOException {
        Stage stage=new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sign-up.fxml"));
        Parent root = loader.load();
        stage.setTitle("Creation compte");
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        Stage stage1 = (Stage) signinbtn.getScene().getWindow();
        stage1.close();
    }
}
