/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package t12308a0.fx.crud;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class SerSellController implements Initializable {

    @FXML
    private TableView<ser_Sell> tvSerSell;
    @FXML
    private TableColumn<ser_Sell, Integer> colSerSell_idss;
    @FXML
    private TableColumn<ser_Sell, Integer> colSerSell_idc;
    @FXML
    private TableColumn<ser_Sell, String> colSerSell_name;
    @FXML
    private TableColumn<ser_Sell, Integer> colSerSell_price;
    @FXML
    private TableColumn<ser_Sell, ImageView> colSerSell_img;
    @FXML
    private TableColumn<ser_Sell, Integer> colSerSell_qoh;
    @FXML
    private TextField txtSerSell_idc;
    @FXML
    private TextField txtSerSell_name;
    @FXML
    private TextField txtSerSell_price;
    @FXML
    private TextField txtSerSell_idss;
    @FXML
    private TextField txtSerSell_qoh;
    @FXML
    private Button btnAdd_Sersell;
    @FXML
    private Button btnUpdate_Sersell;
    @FXML
    private Button btnDelete_Sersell;
    @FXML
    private TextField txtSerSell_img;

    @FXML
    private ImageView imgView_Sersell;
    @FXML
    private Button btnChangeImage_Sersell;

    //fields declared by dev Binh
    private final String IMAGE_DIR = "E:/APTECH/HK2/2.3.JP2/Code/FX-CRUD/src/main/resources/imgs/";

    private String selectImageName;
    private String selectImageURL;
    private Path from, to;
    File selectedFile;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TAO DOI TUONG
        showProducts();
    }

    public ObservableList getItem() {

        //tao ds chứa các item , để hiển thị thì phải dùng ObservableList
        ObservableList<ser_Sell> list = FXCollections.observableArrayList();

        //tao doi tuong để connect db
        ConnectDB con = new ConnectDB();
        Connection cn = con.getConnect();

        //viet lenh sql
        String sql = "SELECT * FROM ser_rent";

        //thuc thi
        Statement st;
        ResultSet rs;

        try {
            st = cn.createStatement();
            rs = st.executeQuery(sql);

            ser_Sell item = new ser_Sell();

            while (rs.next()) {
                int idss = rs.getInt("idsr");
                int idc = rs.getInt("idc");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                String img = rs.getString("img");
                int qoh = rs.getInt("qoh");

                //bắt buộc bắt đầu bằng file:/..... audio , media cũng vậy
                //vô properties của hình để copy đường dẫn đến thư mục
                //chú ý dấu xuyệt
                Image image = new Image("file:/" + IMAGE_DIR + img);
                System.out.println(IMAGE_DIR + img);
                ImageView imgView = new ImageView(image);
                
                //Nên cài đặt kích thước ảnh ở bước này
                imgView.setFitHeight(50);
                imgView.setFitWidth(100);

                //tao doi tuong
                item = new ser_Sell(idss, idc, name, price, imgView, qoh);

                list.add(item);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SerSellController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void showProducts() {
        ObservableList<ser_Sell> SerSellList = getItem();

        //show ds ra tableview
        colSerSell_idss.setCellValueFactory(new PropertyValueFactory<>("idss"));
        colSerSell_idc.setCellValueFactory(new PropertyValueFactory<>("idc"));
        colSerSell_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        colSerSell_price.setCellValueFactory(new PropertyValueFactory<>("price"));
        colSerSell_img.setCellValueFactory(new PropertyValueFactory<>("img"));
        colSerSell_qoh.setCellValueFactory(new PropertyValueFactory<>("qoh"));

        tvSerSell.setItems(SerSellList);
    }

    @FXML
    private void addItem_Sersell(ActionEvent event) {
        int idc = Integer.parseInt(txtSerSell_idc.getText());
        String name = txtSerSell_name.getText();
        int price = Integer.parseInt(txtSerSell_price.getText());
//        String img = txtSerSell_img.getText();
        int qoh = Integer.parseInt(txtSerSell_qoh.getText());

        String sql = "INSERT INTO ser_rent VALUES(" + idc + ", N'" + name + "'," + price + ",'" + selectImageName + "'," + qoh + ")";

        executeSQL(sql);
    }

    private void executeSQL(String query) {
        ConnectDB con = new ConnectDB();
        Connection cn = con.getConnect();

        Statement st;

        try {
            st = cn.createStatement();
            st.executeUpdate(query);
            showProducts();
            reset();
            System.out.println("add Thanh cong");
        } catch (SQLException ex) {
            System.out.println("Loi: " + ex.getMessage());
        }

    }

    @FXML
    private void OnSelectProduct_Sersell(MouseEvent event) {

        ser_Sell item = tvSerSell.getSelectionModel().getSelectedItem();
        txtSerSell_idss.setText("" + item.getIdss());
        txtSerSell_idc.setText("" + item.getIdc());
        txtSerSell_name.setText(item.getName());
        txtSerSell_price.setText("" + item.getPrice());
        txtSerSell_qoh.setText("" + item.getQoh());

        ImageView img = item.getImg();

        Image image = img.getImage();
        imgView_Sersell.setImage(image);
    }

    @FXML
    private void UpdateItem_Sersell(ActionEvent event) {
        int idss = Integer.parseInt(txtSerSell_idss.getText());
        int idc = Integer.parseInt(txtSerSell_idc.getText());
        String name = txtSerSell_name.getText();
        int price = Integer.parseInt(txtSerSell_price.getText());
        String img = txtSerSell_img.getText();
        int qoh = Integer.parseInt(txtSerSell_qoh.getText());

        String sql = "UPDATE ser_rent SET idc = " + idc + ", name = N'" + name + "', price = " + price + ", img = '" + selectImageName + "', qoh = " + qoh + "WHERE idsr = " + idss;

        executeSQL(sql);
        showProducts();

    }

    @FXML
    private void deleteItem_SerSel(ActionEvent event) {
        int idss = Integer.parseInt(txtSerSell_idss.getText());
        String sql = "DELETE ser_rent WHERE idsr = " + idss;

        Alert alert;
        alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Information Message");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure delete Product?");
        alert.showAndWait();

        executeSQL(sql);

    }

    private void reset() {
        txtSerSell_idss.setText("");
        txtSerSell_idc.setText("");
        txtSerSell_name.setText("");
        txtSerSell_price.setText("");
//        txtSerSell_img.setText("");
        txtSerSell_qoh.setText("");
    }

    @FXML
    private void selectImage(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
                new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"));
        selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
//            System.out.println(selectedFile);
//            System.out.println(selectedFile.toURI().toString());

            selectImageURL = selectedFile.toURI().toString();

            selectImageName = selectedFile.getName();

            //copy file anh da chon e foldre duong dan anh IMAGE_DIR 
            from = Paths.get(selectedFile.toURI());
            to = Paths.get(IMAGE_DIR + selectImageName);

            CopyOption options = StandardCopyOption.REPLACE_EXISTING;

            try {
                Files.copy(from, to, options);
            } catch (IOException ex) {
                Logger.getLogger(SerSellController.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("Error: cannot copy " + ex.getMessage());
            }

            if (event.getSource() == btnChangeImage_Sersell) { //cô tách ra 2 button
                imgView_Sersell.setImage(new Image(selectImageURL));
            }
//            else if (event.getSource() == btnChangeImage_Sersell) {//cô tách ra 2 button còn mình chỉ dùng 1
//                imgView_Sersell.setImage(new Image(selectImageURL));
//
//            }
        }
    }

}
