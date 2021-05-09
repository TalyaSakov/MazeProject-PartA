package IO;

import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedList;

public class MyCompressorOutputStream extends OutputStream {
    OutputStream outputStream;


    public MyCompressorOutputStream(OutputStream outputStream) {
        this.outputStream=outputStream;
    }

    @Override
    public void write(int b) throws IOException {
        outputStream.write(b);

    }

    public void write(byte[] unCompressedBytes) throws IOException {
        LinkedList<Byte> tempLinkedList = new LinkedList<>();
        int runningIndex = 0; //the running index on the unCompressedBytes array
        int countEight=0;
        StringBuilder str= new StringBuilder();

        while (runningIndex < unCompressedBytes.length) {
            while(countEight<8 && runningIndex<unCompressedBytes.length) {
                str.append(unCompressedBytes[runningIndex]);
                runningIndex++;
                countEight++;
            }
            if (countEight<8){
          //

                for(int i=0;i<8-countEight;i++){
                    str.append(0);
                }


            }

            byte val = (byte)Integer.parseInt(Reverse(str.toString()), 2);
            tempLinkedList.add(val);
            str= new StringBuilder();
            countEight=0;

        }

        byte [] compressedBytes= new byte[tempLinkedList.size()];
        for(int i=0;i<compressedBytes.length;i++){
            compressedBytes[i]=tempLinkedList.get(i);
        }
        outputStream.write(compressedBytes);
    }

    /**
     * @param str
     * @return the input str reversed
     */
    public String Reverse(String str){
        String rev="";
        for (int i=str.length()-1;i>=0;i--){
            rev+=str.charAt(i);
        }
        return rev;
    }



}






