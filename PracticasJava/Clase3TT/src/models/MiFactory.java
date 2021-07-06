package models;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class MiFactory {

    public static Sorter getInstance(String objName) throws Exception {

        // create a reader object on the properties file
        FileReader reader = new FileReader("src/properties/" + objName);
        // create properties object
        Properties p = new Properties();
        //Properties p = new Properties();
        //p.load(SorterFactory.class.getResourceAsStream("/SorterFactory.properties"));
        //Hay que mover a carpeta a resources a mismo nivel que src, hacer el "Mark directoryu as... resources"
        // Add a wrapper around reader object
        p.load(reader);
        // Get name of the
        String sorter = p.getProperty("sorter");
        System.out.println(sorter);
        return (Sorter) Class.forName(sorter).getDeclaredConstructor().newInstance();
    }
}
