package Model;

public class Kendaraan {

    public String pemilikKendaraan;
    String jenis;
    String platNomor;
    int hargaSewa;
    
    public String getPemilikKendaraan() {
        return pemilikKendaraan;
    }
    public void setPemilikKendaraan(String pemilikKendaraan) {
        this.pemilikKendaraan = pemilikKendaraan;
    }
    public String getJenis() {
        return jenis;
    }
    public void setJenis(String jenis) {
        this.jenis = jenis;
    }
    public String getPlatNomor() {
        return platNomor;
    }
    public void setPlatNomor(String platNomor) {
        this.platNomor = platNomor;
    }
    public int getHargaSewa() {
        return hargaSewa;
    }
    public Kendaraan(String pemilikKendaraan, String jenis, String platNomor, int hargaSewa) {
        this.pemilikKendaraan = pemilikKendaraan;
        this.jenis = jenis;
        this.platNomor = platNomor;
        this.hargaSewa = hargaSewa;
    }
    public void setHargaSewa(int hargaSewa) {
        this.hargaSewa = hargaSewa;
    }
    
}
