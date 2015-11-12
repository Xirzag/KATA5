package kata5;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class KATA5 {

    
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {
        String nameFile = "C:\\Users\\usuario\\Desktop\\KATA5\\KATA5\\kata5.db";
        ArrayList<String> read = MailListReader.readFromDb(nameFile);
        /*for(String elem : read) {
            System.out.println(elem);
        }*/
        
        Histogram <String> histogram = MailHistogramBuilder.build(read);
        
        new HistogramDisplay(histogram).execute();
        
    }

}
