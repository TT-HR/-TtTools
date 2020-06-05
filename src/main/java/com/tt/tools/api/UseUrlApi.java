package com.tt.tools.api;

import com.alibaba.fastjson.JSON;
import com.tt.tools.entity.UseUrlEntity;
import com.tt.tools.service.UseUrlService;
import com.tt.tools.untils.UnifiedResponse;
import groovy.util.logging.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author admin
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("api/useUrl")
public class UseUrlApi {
    @Autowired
    private UseUrlService useUrlService;

    @PostMapping("get/getUseUrl")
    public UnifiedResponse getUserUrl(){
        return useUrlService.getUseUrl();
    }

}
