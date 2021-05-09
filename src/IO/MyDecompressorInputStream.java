package IO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;

public class MyDecompressorInputStream extends InputStream {
    InputStream outputStream;
    public MyDecompressorInputStream(InputStream inputStream){
        this.outputStream=inputStream;
    }

    public int read(byte[] compressedBytes) throws IOException {
        outputStream.read(compressedBytes);
        String str="";

        LinkedList<Byte> tempLinkedList = new LinkedList<>();
        int count=0;
        int sumTo8=compressedBytes.length%8;

        for (byte tempByte : compressedBytes) {
            if (count==compressedBytes.length/8) break;
            int result = tempByte & 0xff;
            str=(Integer.toBinaryString(result));

            byte flag ;
            for (int i=0;i<str.length();i++){

                if(Reverse(str).charAt(i)=='0'){
                    flag=0;
                }
                else{
                    flag=1;
                }
                tempLinkedList.add(flag);
            }
            for(int j=0;j<8-str.length();j++){
                flag=0;
                tempLinkedList.add(flag);
            }
            str="";
            count++;
        }

        if (sumTo8!=0){
           int result2= compressedBytes[count]& 0xff;
            str=(Integer.toBinaryString(result2));

            byte flag ;

            for (int i=0;i<str.length();i++){

                if(Reverse(str).charAt(i)=='0'){
                    flag=0;
                }
                else{
                    flag=1;
                }
                tempLinkedList.add(flag);
            }
            for(int j=0;j<sumTo8-str.length();j++){
                flag=0;
                tempLinkedList.add(flag);
            }
        }
        int runUntil=tempLinkedList.size();



        for (int i = 0; i < runUntil; i++) {
            compressedBytes[i] = tempLinkedList.pollFirst(); //Makeing compressedBytes to UncompressedBytes
        }
        return 0;
    }

    @Override
    public int read() throws IOException {
        return 0;
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