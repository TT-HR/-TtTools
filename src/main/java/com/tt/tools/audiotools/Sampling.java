package com.tt.tools.audiotools;

import com.tt.tools.response.BaseService;
import com.tt.tools.untils.BeanUntil;
import com.tt.tools.untils.UnifiedResponse;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.id3.AbstractID3v2Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;

/**
 * @author admin
 */
public class Sampling extends BaseService {
    private MP3File mp3File;
    private final int START=6;
    private static final Logger log = LoggerFactory.getLogger(Sampling.class);

    private UnifiedResponse getHead(String mp3Path) {
        try {
            mp3File = new MP3File(mp3Path);
            MP3AudioHeader header = mp3File.getMP3AudioHeader();
            Map<String,Object> map = new HashMap<>();
            map.put("时长",header.getTrackLength());
            map.put("比特率",header.getBitRate());
            map.put("音轨长度",header.getTrackLength());
            map.put("格式",header.getFormat());
            map.put("声道",header.getChannels());
            map.put("采样率",header.getSampleRate());
            map.put("MPEG",header.getMpegLayer());
            map.put("MP3起始字节",header.getMp3StartByte());
            map.put("精确的音轨长度",header.getPreciseTrackLength());
            return success(map);
        } catch (Exception e) {
            log.info("获取音频参数失败："+e);
        }
        return error();
    }
    private UnifiedResponse getContent() {
        try {
            System.out.println("----------------Loading...Content-----------------");
            AbstractID3v2Tag id3v2tag=  mp3File.getID3v2Tag();
            Map<String,Object> map = new HashMap<>();
            String songName=new String(id3v2tag.frameMap.get("TIT2").toString().getBytes("ISO-8859-1"),"GB2312");
            String singer=new String(id3v2tag.frameMap.get("TPE1").toString().getBytes("ISO-8859-1"),"GB2312");
            String author=new String(id3v2tag.frameMap.get("TALB").toString().getBytes("ISO-8859-1"),"GB2312");
            map.put("歌名",songName.substring(START, songName.length()-3));
            map.put("歌手",singer.substring(START,singer.length()-3));
            map.put("专辑名",author.substring(START,author.length()-3));
            return success(map);
        } catch (Exception e) {
            log.info("获取音频参数失败:"+e);
        }
        return error();
    }


    /**
     * 获取音频的采样率
     *         File f = new File("XXX.wav");
     *         RandomAccessFile rdf = null;
     *         rdf = new RandomAccessFile(f,"r");
     *         toInt(read(rdf, 4, 4)); // 声音尺寸
     *         
     *         toShort(read(rdf, 20, 2)); // 音频格式 1 = PCM
     *         
     *         toShort(read(rdf, 22, 2)); // 1 单声道 2 双声道
     *         
     *         toInt(read(rdf, 24, 4));  // 采样率、音频采样级别 8000 = 8KHz
     *         
     *         toInt(read(rdf, 28, 4));  // 每秒波形的数据量
     *         
     *         toShort(read(rdf, 32, 2));  // 采样帧的大小
     *         
     *         StoShort(read(rdf, 34, 2));  // 采样位数
     * */
    public static int toInt(byte[] b) {
        return (((b[3] & 0xff) << 24) + ((b[2] & 0xff) << 16) + ((b[1] & 0xff) << 8) + ((b[0] & 0xff) << 0));

        //return ((b[3] << 24) + (b[2] << 16) + (b[1] << 8) + (b[0] << 0));
    }

    public static short toShort(byte[] b) {
        return (short) ((b[1] << 8) + (b[0] << 0));
    }


    public static byte[] read(RandomAccessFile rdf, int pos, int length) throws IOException {
        rdf.seek(pos);
        byte result[] = new byte[length];
        for (int i = 0; i < length; i++) {
            result[i] = rdf.readByte();
        }
        return result;
    }
}
