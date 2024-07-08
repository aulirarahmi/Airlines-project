package Model;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;

public class UserList {
    
    ArrayList <User> userList = new ArrayList <>(); 

    public UserList() {
        loadXML();
    }

    public ArrayList <User> getUserLists(){
        return userList;
    }

    public void loadXML (){
        XStream xstream = new XStream(new StaxDriver());
        xstream.addPermission(AnyTypePermission.ANY);
        FileInputStream f = null;
        try{
            f = new FileInputStream("user_data.xml");
            int isi ;
            char c;
            String stringnya = "";

            while ((isi = f.read()) != -1 ){
                c = (char) isi;
                stringnya += c;
            }
            userList = (ArrayList <User> ) xstream.fromXML(stringnya);
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
