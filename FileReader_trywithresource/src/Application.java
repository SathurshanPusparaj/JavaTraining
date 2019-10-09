import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        FileWriterImpl fileWriterImpl = new FileWriterImpl();
        fileWriterImpl.write();

        Filereaderimpl fileReaderimpl = new Filereaderimpl();
        fileReaderimpl.read();
    }
}
