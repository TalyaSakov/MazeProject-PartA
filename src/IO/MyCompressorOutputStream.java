package IO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class MyCompressorOutputStream extends OutputStream {
    OutputStream outputStream;

    public MyCompressorOutputStream(FileOutputStream fileOutputStream) {
    }

    @Override
    public void write(int b) throws IOException {

    }

    public void write(byte[] unCompressedBytes) throws IOException {



    }

}
