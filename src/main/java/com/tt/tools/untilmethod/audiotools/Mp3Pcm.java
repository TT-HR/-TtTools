package com.tt.tools.untilmethod.audiotools;

import groovy.util.logging.Slf4j;
import javazoom.spi.mpeg.sampled.file.MpegAudioFileReader;
import org.springframework.stereotype.Component;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import java.io.File;
import java.io.IOException;

/**
 * @author admin
 */
@Slf4j
@Component
public class Mp3Pcm {

    /**
     * mp3转pcm格式
     * */
    public boolean convertMP3ToPcm(String mp3Filepath, String pcmFilepath) {
        try {
            // 获取文件的音频流，pcm的格式
            AudioInputStream audioInputStream = getPcmAudioInputStream(mp3Filepath);
            // 将音频转化为 pcm的格式保存下来
            AudioSystem.write(audioInputStream, AudioFileFormat.Type.WAVE, new File(pcmFilepath));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 获取文件的音频流
     *
     * @param mp3filepath
     * @return
     */
    private AudioInputStream getPcmAudioInputStream(String mp3filepath) {
        File mp3 = new File(mp3filepath);
        AudioInputStream audioInputStream = null;
        AudioFormat targetFormat = null;
        AudioInputStream in = null;
        try {

            // 读取音频文件的类
            MpegAudioFileReader mp = new MpegAudioFileReader();
            in = mp.getAudioInputStream(mp3);
            AudioFormat baseFormat = in.getFormat();

            // 设定输出格式为pcm格式的音频文件
            targetFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, baseFormat.getSampleRate(), 16,
                    baseFormat.getChannels(), baseFormat.getChannels() * 2, baseFormat.getSampleRate(), false);

            // 输出到音频
            audioInputStream = AudioSystem.getAudioInputStream(targetFormat, in);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return audioInputStream;
    }
}
