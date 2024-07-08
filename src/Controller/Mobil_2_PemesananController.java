package Controller;

public class Mobil_2_PemesananController extends PemesananController{

    @Override
    protected String getHomeFXML() {
        return "/View/FXMLhome.fxml";
    }

    @Override
    protected String getBackFXML() {
        return "/View/FXMLMobilPage.fxml";
    }

    @Override
    protected String getBookingFXML() {
        return "/View/FXMLPembayaran.fxml";
    }

}
