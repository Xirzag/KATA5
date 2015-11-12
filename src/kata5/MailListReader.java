package kata5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MailListReader {
    
    public static ArrayList<String> readFromDb(String name) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
        
        ArrayList<String> mailList = new ArrayList<>();
        Class.forName("org.sqlite.JDBC");
        Connection c = DriverManager.getConnection("jdbc:sqlite:"+name);
        
        //For online
        //Class.forName("oracle.jdbc.driver.OracleDriver");
        //Connection c = DriverManager.getConnection("jdbc:oracle:thin:@10.22.143.90:1521:orcl","system","orcl");

        Statement stmt = c.createStatement();
  
        ResultSet rs = stmt.executeQuery("SELECT * FROM MAIL");
        String mail;
        while(rs.next()) {
            mail = rs.getString("MAIL");
            if(!mail.contains("@")) continue;
            mailList.add(mail);
        }

        rs.close();
        stmt.close();
        c.close();

        return mailList;
    }
        
    public static ArrayList<String> readFromFile(String name) throws FileNotFoundException, IOException {
        ArrayList<String> mailList = new ArrayList<>();
        
        BufferedReader fileRead = new BufferedReader(new FileReader(new File(name)));
        String mail;
        while((mail=fileRead.readLine())!= null) {
            if(!mail.contains("@")) continue;
            mailList.add(mail);
        }
        
        return mailList;
    }
    
}
