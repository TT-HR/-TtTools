package com.tt.tools.api;

import com.tt.tools.response.BaseService;
import com.tt.tools.service.SamplingService;
import com.tt.tools.untils.UnifiedResponse;
import groovy.util.logging.Slf4j;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author admin
 */
@Slf4j
@CrossOrigin
@RestController
@Api(value = "音频相关方法")
@RequestMapping("api/audio")
public class AudioApi extends BaseService {
    private static final Logger log = LoggerFactory.getLogger(AudioApi.class);
    @Autowired
    private SamplingService samplingService;

    @ApiOperation("解析音频参数")
    @PostMapping("post/getAudioData")
    public UnifiedResponse getAudioData(String fileName){
        return samplingService.getAudioData(fileName);
    }
}
