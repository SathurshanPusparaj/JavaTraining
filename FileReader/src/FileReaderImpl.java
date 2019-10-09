import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderImpl {

    public void read() throws IOException {
        FileReader fileReader = new FileReader("/home/user/Documents/JavaTraining/FileReader/src/text.txt");
        BufferedReader bfr = new BufferedReader(fileReader);

        String currentline;
        while((currentline = bfr.readLine())!=null){
            System.out.println(currentline);
        }
        bfr.close();
    }
}
