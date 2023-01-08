package com.example.emailapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EmailController implements Initializable {
    Connection conn = null;

    public EmailController() {
        conn = SingletonConnection.getConnection();
    }
    public int userid;
    @FXML
    private Text contenu;
    @FXML
    private Button envoyerbtn;

    @FXML
    private Label envoyepar;
    @FXML
    private Label date;
    @FXML
    private TableView<Email> tab;
    @FXML
    private TableColumn<Email, String> emailcol;
    @FXML
    private Label objet;
    ObservableList<Email> list = FXCollections.observableArrayList();


    @FXML
    void OnSet(MouseEvent event) {
        objet.setText(String.valueOf(tab.getSelectionModel().getSelectedItem().getObjet()));
        contenu.setText(String.valueOf(tab.getSelectionModel().getSelectedItem().getContenu()));
        envoyepar.setText("Envoye par : " + String.valueOf(tab.getSelectionModel().getSelectedItem().getEnvoyepar()));
        date.setText(String.valueOf(tab.getSelectionModel().getSelectedItem().getDate()));
    }
    void setUserid(int id){
        this.userid=id;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    void onClickbtn(ActionEvent event) throws IOException {
        Stage stage=new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("envoyer-email.fxml"));
        Parent root = loader.load();
        EnvoyerEmailController controller = loader.getController();
        controller.userid=userid;
        stage.setTitle("Envoyer Email");
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void onRefreshbtn(ActionEvent event) {
        list.clear();
        ResultSet rs = null;
        try {
            rs = conn.createStatement().executeQuery("select idE,objet,contenu,date,nomcomplet from emails e,users u where e.envoyepar=u.idU and e.envoyea="+userid);
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
                list.add(new Email(rs.getInt("idE"), rs.getString("objet"), rs.getString("contenu"), rs.getString("nomcomplet"), rs.getDate("date")));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        emailcol.setCellValueFactory(new PropertyValueFactory<>("objet"));
        tab.setItems(list);
    }
}
