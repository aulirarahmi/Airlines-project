package Controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class PembayaranController {

    @FXML
    private Button BayarButton;

    @FXML
    private Button CancelPembayaranButton;

    @FXML
    private RadioButton DriverRadioButton;

    @FXML
    private ComboBox<String> MasaSewaComboBox;

    @FXML
    private ComboBox<String> MetodePembayaranComboBox;

    @FXML
    private ComboBox<String> PromoComboBox;

    @FXML
    private Label Total;

    @FXML
    private ImageView logoImageView;

    @FXML
    private ImageView logoImageView1;

    @FXML
    private BorderPane mainPane;

    @FXML
    private RadioButton withoutDriverRadioButton;

    private ToggleGroup driverToggleGroup;

    private double total = SharedModel.getInstance().getInitialPrice();
    private double discountRate = 0;
    private double totalHari = 1;

    @FXML
    public void initialize() {

        MasaSewaComboBox.getItems().clear();
        for (int i = 1; i <= 31; i++) {
            MasaSewaComboBox.getItems().add(i + " hari");
        }

        MasaSewaComboBox.setOnAction(event -> handleMasaSewa());

        MetodePembayaranComboBox.getItems().clear();
        MetodePembayaranComboBox.getItems().addAll("Cash", "Mobile Banking", "Credit");
        
        MetodePembayaranComboBox.setOnAction(event -> handleMetodePembayaranSelection());

        PromoComboBox.getItems().clear();
        PromoComboBox.getItems().addAll("Promo Dosen", "Promo Mahasiswa", "Promo Umum");
    
        PromoComboBox.setOnAction(event -> handlePromoSelection());

        BayarButton.setOnAction(event -> handlePayment());

        driverToggleGroup = new ToggleGroup();
        DriverRadioButton.setToggleGroup(driverToggleGroup);
        withoutDriverRadioButton.setToggleGroup(driverToggleGroup);
        CancelPembayaranButton.setOnAction(event -> handleCancelPembayaran());
    }

    private void handleMetodePembayaranSelection() {
        String selectedMethod = MetodePembayaranComboBox.getValue();
        if (selectedMethod != null) {
            switch (selectedMethod) {
                case "Cash":
                    handleCashPayment();
                    break;
                case "Mobile Banking":
                    handleMobileBankingPayment();
                    break;
                case "Credit":
                    handleCreditPayment();
                    break;
                default:
                    break;
            }
        }
    }

    private void handlePromoSelection() {
        String promoPilih = PromoComboBox.getValue();
        if (promoPilih != null) {
            switch (promoPilih) {
                case "Promo Dosen":
                    applyPromoDosen();
                    break;
                case "Promo Mahasiswa":
                    applyPromoMahasiswa();
                    break;
                case "Promo Umum":
                    applyPromoUmum();
                    break;
                default:
                    break;
            }
        }
    }

    private void handleCashPayment() {
        showAlert(AlertType.INFORMATION, "Metode Pembayaran", "CASH");
        // Add additional logic for cash payment if needed
    }

    private void handleMobileBankingPayment() {
        showAlert(AlertType.INFORMATION, "Metode pembayaran", "MOBILE BANKING");

    }

    private void handleCreditPayment() {
        showAlert(AlertType.INFORMATION, "Metode pembayaran", "CREDIT CARD");
    }

    private void applyPromoDosen() {
        showAlert(AlertType.INFORMATION, "Promo digunakan", "Kamu Memilih Promo Dosen");
        applyDiscount(0.40); // diskon 40%
    }

    private void applyPromoMahasiswa() {
        showAlert(AlertType.INFORMATION, "Promo digunakan", "Kamu Memilih Promo Mahasiswa");
        applyDiscount(0.15); // diskon 15%
    }

    private void applyPromoUmum() {
        showAlert(AlertType.INFORMATION, "Promo digunakan", "Kamu Memilih Promo Dosen");
        applyDiscount(0.10); // diskon 10%
    }

    private void applyDiscount(double discountRate) {
        try {
            this.discountRate = discountRate;
            this.total = (this.total * this.totalHari) - ((this.total * this.totalHari) * discountRate);

            Total.setText(formatCurrency(this.total));
        } catch (NumberFormatException e) {
            showAlert(AlertType.ERROR, "Input Error", "Invalid total amount entered.");
        }
    }

    private void handlePayment() {
        String selectedMethod = MetodePembayaranComboBox.getValue();
        if (selectedMethod == null) {
            showAlert(AlertType.ERROR, "Pembayaran Gagal", "Silahkan pilih metode pembayaran");
            return;
        }

        switch (selectedMethod) {
            case "Cash":
                processCashPayment();
                break;
            case "Mobile Banking":
                processMobileBankingPayment();
                break;
            case "Credit":
                processCreditPayment();
                break;
            default:
                showAlert(AlertType.ERROR, "Payment Error", "Invalid payment method selected.");
                break;
        }
    }

    private void processCashPayment() {
        showAlert(AlertType.INFORMATION, "Payment Successful", "Your cash payment has been processed successfully.");
    }

    private void processMobileBankingPayment() {
        showAlert(AlertType.INFORMATION, "Payment Successful", "Your mobile banking payment has been processed successfully.");
    }

    private void processCreditPayment() {
        showAlert(AlertType.INFORMATION, "Payment Successful", "Your credit payment has been processed successfully.");
    }

    private void showAlert(AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void handleMasaSewa() {
        String selectedMethod = MasaSewaComboBox.getValue().replace(" hari", "");
        this.totalHari = Double.parseDouble(selectedMethod);

        this.total = (this.total * this.totalHari) - ((this.total * this.totalHari) * discountRate);

        Total.setText(formatCurrency(this.total));
    }

    private void handleCancelPembayaran() {
        MasaSewaComboBox.setValue(null);
        MetodePembayaranComboBox.setValue(null);
        PromoComboBox.setValue(null);
        driverToggleGroup.selectToggle(null);
        Total.setText("0.00");

        showAlert(AlertType.INFORMATION, "Pembayaran Dibatalkan", "Pembayaran telah dibatalkan.");
        showHomePage(null);
    }

    private String formatCurrency(double amount) {
        int roundedAmount = (int) Math.round(amount);
        return "Rp " + roundedAmount;
    }

    @FXML
    private void  showHomePage(MouseEvent event) {
       try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/FXMLHome.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) CancelPembayaranButton.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   
 
}
