package com.tt.tools.api;

import com.tt.tools.service.UseUrlService;
import com.tt.tools.untils.UnifiedResponse;
import groovy.util.logging.Slf4j;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author admin
 */
@Slf4j
@CrossOrigin
@RestController
@Api(value = "useUrl表相关方法")
@RequestMapping("api/useUrl")
public class UseUrlApi {
    private static final Logger log = LoggerFactory.getLogger(UseUrlApi.class);
    @Autowired
    private UseUrlService useUrlService;


    @ApiOperation("获取url")
    @PostMapping("post/getUseUrl")
    public UnifiedResponse getUserUrl(){
        return useUrlService.getUseUrl();
    }

}
