import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterImpl {

    public void write() throws IOException {
        FileWriter fileWriter = new FileWriter("/home/user/Documents/JavaTraining/FileReader/src/text.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        for(int i=1;i<=10;i++) {
            String s =String.valueOf(i)+"\n";
            bufferedWriter.write(s);
        }
        bufferedWriter.close();
    }
}
