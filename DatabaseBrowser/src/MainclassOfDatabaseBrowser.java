import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JComboBox;

public class MainclassOfDatabaseBrowser 
{
    public static void main(String[] args)
    {
        DatabaseBrowser dbb = new  DatabaseBrowser();
        dbb.gui1();
 
    }
}
