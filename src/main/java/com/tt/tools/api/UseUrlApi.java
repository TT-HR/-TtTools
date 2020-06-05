package com.tt.tools.api;

import com.tt.tools.service.UseUrlService;
import com.tt.tools.untils.UnifiedResponse;
import groovy.util.logging.Slf4j;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
    @Autowired
    private UseUrlService useUrlService;

    @ApiOperation("获取url")
    @PostMapping("get/getUseUrl")
    public UnifiedResponse getUserUrl(){
        return useUrlService.getUseUrl();
    }

}
