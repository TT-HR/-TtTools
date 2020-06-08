package com.tt.tools.service;


import com.tt.tools.untils.UnifiedResponse;

/**
 * @author admin
 */
public interface SamplingService {

    /**
     * getAudioData()方法获取音频详情
     * @return UnifiedResponse返回体
     * @param filePath 文件地址
     * */
    UnifiedResponse getAudioData(String filePath);



}
