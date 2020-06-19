package com.tt.tools.service.impl;

import com.tt.tools.untilmethod.audiotools.Sampling;
import com.tt.tools.response.BaseService;
import com.tt.tools.service.SamplingService;
import com.tt.tools.untils.UnifiedResponse;
import groovy.util.logging.Slf4j;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author admin
 */
@Slf4j
@Service
@AllArgsConstructor
public class SamplingServiceImpl extends BaseService implements SamplingService {
    private static final Logger log = LoggerFactory.getLogger(SamplingServiceImpl.class);

    private final Sampling sampling;

    @Override
    public UnifiedResponse getAudioData(String filePath) {
        try {
            Map<String, Object> fileHead = sampling.getHead(filePath);
            Map<String, Object> fileContent = sampling.getContent(filePath);
            List<Map<String, Object>> list = new ArrayList();
            list.add(fileHead);
            list.add(fileContent);
            return success(list);
        }catch (Exception e){
            log.info("getAudioData方法错误:"+e);
            return error();
        }
    }

}
