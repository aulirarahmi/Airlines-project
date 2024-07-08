package Model;

import static javafx.collections.FXCollections.observableArrayList;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;


public class PemilikList {

    ObservableList <Kendaraan> pemilikList = observableArrayList(); 

    public PemilikList() {
        loadXML();
    }

    public ObservableList <Kendaraan> getPemilikList(){
        return pemilikList;
    }

    public void loadXML (){
        XStream xstream = new XStream(new StaxDriver());
        xstream.addPermission(AnyTypePermission.ANY);
        FileInputStream f = null;
        try{
            f = new FileInputStream("kendaraan_data.xml");
            int isi ;
            char c;
            String stringnya = "";

            while ((isi = f.read()) != -1 ){
                c = (char) isi;
                stringnya += c;
            }
            pemilikList = (ObservableList <Kendaraan> ) xstream.fromXML(stringnya);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally{
            if (f != null){
                try {
                    f.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
                
            }
        }

    }
    
}
