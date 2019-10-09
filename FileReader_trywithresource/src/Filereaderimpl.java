import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Filereaderimpl {
    public void read() throws IOException {
        FileReader fileReader = new FileReader("/home/user/Documents/JavaTraining/FileReader_trywithresource/src/text.txt");
        try(BufferedReader bfr = new BufferedReader(fileReader)){
            String currentline;
            while((currentline = bfr.readLine())!=null){
                System.out.println(currentline);
            }
        }catch(IOException exc){
            System.out.println(exc.toString());
        }
    }
}
