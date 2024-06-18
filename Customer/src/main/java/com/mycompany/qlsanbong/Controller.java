package com.mycompany.qlsanbong;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class Controller implements Initializable {

    @FXML
    private TableView<Customer> tableView;

    @FXML
    private TableColumn<Customer, Integer> idCol;
    @FXML
    private TableColumn<Customer, Integer> pointCol;
    @FXML
    private TableColumn<Customer, String> nameCol;
    @FXML
    private TableColumn<Customer, String> phoneCol;

    @FXML
    private TextField idTxt;

    @FXML
    private TextField nameTxt;

    @FXML
    private TextField phoneTxt;

    @FXML
    private TextField pointTxt;

    private ObservableList<Customer> cusList;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cusList = FXCollections.observableArrayList(
                new Customer(1, "kh01", "0911111", 100),
                new Customer(2, "kh02", "0922222", 100)
        );
        idCol.setCellValueFactory(new PropertyValueFactory<Customer, Integer>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<Customer, String>("name"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<Customer, String>("phone"));
        pointCol.setCellValueFactory(new PropertyValueFactory<Customer, Integer>("point"));
        tableView.setItems(cusList);
    }

    @FXML
    public void add(ActionEvent e) {
        Customer cus = new Customer();
        cus.setId(Integer.parseInt(idTxt.getText().trim()));
        cus.setPoint(Integer.parseInt(pointTxt.getText().trim()));
        cus.setName(nameTxt.getText().trim());
        cus.setPhone(phoneTxt.getText().trim());
        cusList.add(cus);
    }
    

    @FXML
    public void delete(ActionEvent e) {
        Customer cus = tableView.getSelectionModel().getSelectedItem();
        cusList.remove(cus);
    }

//    @FXML
    public void detail(ActionEvent e) throws IOException {
        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("detailcus.fxml"));

        Parent cusViewParent = loader.load();
        Scene scene = new Scene(cusViewParent);

        DetailcusController controller = loader.getController();
        Customer selected = tableView.getSelectionModel().getSelectedItem();
        controller.setCus(selected);

        stage.setScene(scene);
        App.setRoot("detailcus");
        //stage.show(); Không viết show cũng show được

    }
    
    //=====tai sao khong set root duoc?
//   @FXML
//    public void detail(ActionEvent e) throws IOException {
//        FXMLLoader loader = new FXMLLoader();
//        DetailcusController controller = loader.getController();
//        Customer selected = tableView.getSelectionModel().getSelectedItem();
//        controller.setCus(selected);
//        App.setRoot("detailcus");
//    }
    
    //hỏi cô cách click dòng nào thì nó hiện ra label dòng đó.

}
