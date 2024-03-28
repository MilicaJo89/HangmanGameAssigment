import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordReader {

    public static List<String> WordReader(String file) {

        List<String>words=new ArrayList<>();
        try {
            BufferedReader reader= new BufferedReader(new FileReader(file));
            String line;
            while ((line= reader.readLine()) !=null){
                String[] option =line.split(",");
                words.add(line);
            }
        }catch (IOException e) {
            System.out.println("Something went wrong");
        }
            return words;
    }
}