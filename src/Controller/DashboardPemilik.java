package Controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import Model.Kendaraan;
import Model.PemilikList;
import Model.Kendaraan;
import Model.Kendaraan;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import static javafx.collections.FXCollections.observableArrayList;

public class DashboardPemilik implements Initializable {

    @FXML
    private Button promoButton;

    @FXML
    private TextField HargaSewa;

    @FXML
    private TextField jenisKendaraan;

    @FXML
    private TextField namaPemilik;

    @FXML
    private TextField platKendaraan;

    @FXML
    private TableView<Kendaraan> tableView;

    @FXML
    private TableColumn<Kendaraan, String> namaPemilikColumn;

    @FXML
    private TableColumn<Kendaraan, String> jenisKendaraanColumn;

    @FXML
    private TableColumn<Kendaraan, String> platKendaraanColumn;

    @FXML
    private TableColumn<Kendaraan, Integer> hargaSewaColumn;

    private PemilikList pemilikList = new PemilikList();
    private ObservableList<Kendaraan> data = observableArrayList();

    cobafungsi opensceene = new cobafungsi();

    @FXML
    public void LogOut(MouseEvent event) throws IOException{
        opensceene.getStageGambar(event, "/View/FXMLLogin.fxml" );
    }


    @FXML
    private void handleButtonTambahAction(ActionEvent event) {
        try {
            String namaPemilikText = namaPemilik.getText();
            String jenisKendaraanText = jenisKendaraan.getText();
            String platKendaraanText = platKendaraan.getText();
            int hargaSewa = Integer.parseInt(HargaSewa.getText());

            savePemilikDataToXML(namaPemilikText, jenisKendaraanText, platKendaraanText, hargaSewa);
            tableView.setItems(data);
            tableView.refresh();
            for(int i = 0; i < data.size(); i++) {
                System.out.println(data.get(i).pemilikKendaraan);
            }

            clearFields();
        } catch (NumberFormatException e) {
            // Handle invalid number format
            System.out.println("Invalid number format for harga sewa.");
        }
    }

    @FXML
    private void handleButtonEditAction(ActionEvent event) {
        Kendaraan selected = tableView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            selected.setPemilikKendaraan(namaPemilik.getText());
            selected.setJenis(jenisKendaraan.getText());
            selected.setPlatNomor(platKendaraan.getText());
            selected.setHargaSewa(Integer.parseInt(HargaSewa.getText()));
            tableView.refresh();
            updateXMLData(data);
            clearFields();
        }
    }

    @FXML
    private void handleButtonHapusAction(ActionEvent event) {
        Kendaraan selected = tableView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            data.remove(selected);
            tableView.setItems(data);
            updateXMLData(data);
            clearFields();
        }
    }

    private void clearFields() {
        namaPemilik.clear();
        jenisKendaraan.clear();
        platKendaraan.clear();
        HargaSewa.clear();

   
    }

    private void savePemilikDataToXML(String pemilikKendaraan, String jenis, String platNomor, int hargaSewa) {
         XStream xstream = new XStream(new StaxDriver());
         data = pemilikList.getPemilikList();
         data.add(new Kendaraan(pemilikKendaraan, jenis, platNomor, hargaSewa));

         String xml = xstream.toXML(data);

         FileOutputStream COBA = null;
         try{
            COBA = new FileOutputStream("kendaraan_data.xml");
            byte[] bytes = xml.getBytes("UTF-8");
            COBA.write(bytes);
         }catch (Exception e){
            System.out.println("Perhatian: " + e.getMessage());
         }finally{
            if (COBA != null){
                try{
                    COBA.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
         }
    }

    private void updateXMLData(ObservableList<Kendaraan> data) {
        XStream xstream = new XStream(new StaxDriver());

        String xml = xstream.toXML(data);

        FileOutputStream COBA = null;
        try{
           COBA = new FileOutputStream("kendaraan_data.xml");
           byte[] bytes = xml.getBytes("UTF-8");
           COBA.write(bytes);
        }catch (Exception e){
           System.out.println("Perhatian: " + e.getMessage());
        }finally{
           if (COBA != null){
               try{
                   COBA.close();
               }catch (IOException e){
                   e.printStackTrace();
               }
           }
        }
   }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            pemilikList.loadXML();
            data = pemilikList.getPemilikList();
            namaPemilikColumn.setCellValueFactory(new PropertyValueFactory<>("pemilikKendaraan"));
            jenisKendaraanColumn.setCellValueFactory(new PropertyValueFactory<>("jenis"));
            platKendaraanColumn.setCellValueFactory(new PropertyValueFactory<>("platNomor"));
            hargaSewaColumn.setCellValueFactory(new PropertyValueFactory<>("hargaSewa"));

            tableView.setEditable(true);

            namaPemilikColumn.setCellFactory(TextFieldTableCell.forTableColumn());
            namaPemilikColumn.setOnEditCommit(event -> {
                Kendaraan kendaraan = event.getTableView().getItems().get(event.getTablePosition().getRow());
                kendaraan.setPemilikKendaraan(event.getNewValue());
            });

            jenisKendaraanColumn.setCellFactory(TextFieldTableCell.forTableColumn());
            jenisKendaraanColumn.setOnEditCommit(event -> {
                Kendaraan kendaraan = event.getTableView().getItems().get(event.getTablePosition().getRow());
                kendaraan.setJenis(event.getNewValue());
            });

            platKendaraanColumn.setCellFactory(TextFieldTableCell.forTableColumn());
            platKendaraanColumn.setOnEditCommit(event -> {
                Kendaraan kendaraan = event.getTableView().getItems().get(event.getTablePosition().getRow());
                kendaraan.setPlatNomor(event.getNewValue());
            });

            // Custom cell factory to handle Integer inputs
            hargaSewaColumn.setCellFactory(TextFieldTableCell.forTableColumn(new javafx.util.converter.IntegerStringConverter()));
            hargaSewaColumn.setOnEditCommit(event -> {
                Kendaraan kendaraan = event.getTableView().getItems().get(event.getTablePosition().getRow());
                kendaraan.setHargaSewa(event.getNewValue());
            });


            tableView.setItems(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
