package com.example.emailapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.sql.*;
import java.time.LocalDate;

public class EnvoyerEmailController {
    public int userid;
    Connection conn = null;

    public EnvoyerEmailController() {
        conn = SingletonConnection.getConnection();
    }
    @FXML
    private TextArea contenu;

    @FXML
    private TextField envoyea;

    @FXML
    private Button envoyerbtn;

    @FXML
    private TextField objet;

    @FXML
    void onClickbtn(ActionEvent event) throws SQLException {
        if (this.isInputValid()) {
            ResultSet rs = null;
            try {
                rs = conn.createStatement().executeQuery("select idU from users where email='"+envoyea.getText()+"'");
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
                    PreparedStatement x = (PreparedStatement) conn.prepareStatement("insert into Emails(objet,contenu,date,envoyea,envoyepar) values(?,?,?,?,?)");
                    x.setString(1, objet.getText());
                    x.setString(2, contenu.getText());
                    x.setDate(3, Date.valueOf(LocalDate.now()));
                    x.setInt(4, rs.getInt("idU"));
                    x.setInt(5, userid);
                    x.execute();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }
    private boolean isInputValid() {
        if (this.envoyea.getText().isEmpty() || this.objet.getText().isEmpty() || this.contenu.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Input error!");
            alert.setHeaderText(null);
            alert.setContentText("Les champs ne doivent pas etre vide!");
            alert.show();
            return false;
        }
        return true;
    }

}
