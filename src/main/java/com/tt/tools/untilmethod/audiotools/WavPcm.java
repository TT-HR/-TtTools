package com.tt.tools.untilmethod.audiotools;

import groovy.util.logging.Slf4j;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author admin
 */
@Slf4j
@Component
public class WavPcm {
    /**
     * wav格式转pcm格式
     * */
    public static String WavToPcmFilePath(String wavFile){
        try {
            byte[] buffer= new byte[1024];
            //wav 和pcm的区别就是wav在pcm的前面多了44字节
            byte[] preBuffer= new byte[44];
            int readByte = 0;
            FileInputStream fis = new FileInputStream(wavFile);
            String new_audio = wavFile.substring(0,wavFile.lastIndexOf(".")+1)+"pcm";
            FileOutputStream fos = new FileOutputStream(new_audio);
            //提出44位的wav前缀
            if (fis.read(preBuffer)==-1) {
                return null;
            }
            //复制pcm内容
            while((readByte = fis.read(buffer)) != -1) {
                fos.write(buffer,0,readByte);
            }
            fos.flush();
            fos.close();
            fis.close();
            return new_audio;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
