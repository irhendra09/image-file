package bni.co.id.imagefile.util;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.zip.Deflater;
import java.io.ByteArrayOutputStream;
import java.util.zip.Inflater;

@Slf4j
public class ImageUtils {

    public static byte[] compressImage(byte[] data){
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.setLevel(Deflater.BEST_COMPRESSION);
        deflater.finish();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] tmp = new byte[4*1024];
        while (!deflater.finished()){
            int count = deflater.deflate(tmp);
            outputStream.write(tmp, 0, count);
        }
        try {
            outputStream.close();
        }catch (IOException e){
            log.error(e.getMessage());
        }
        return outputStream.toByteArray();
    }

    public static byte[] decompressImage(byte[] data){
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] tmp = new byte[4*1024];
        try{
            while (!inflater.finished()){
                int count = inflater.inflate(tmp);
                outputStream.write(tmp, 0, count);
            }
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return outputStream.toByteArray();
    }
}
