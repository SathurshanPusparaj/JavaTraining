import java.io.FileWriter;
import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        FileWriterImpl fileWriterImpl = new FileWriterImpl();
        fileWriterImpl.write();

        FileReaderImpl fileReaderimpl = new FileReaderImpl();
        fileReaderimpl.read();
    }
}
