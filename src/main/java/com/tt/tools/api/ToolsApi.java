package com.tt.tools.api;

import com.tt.tools.entity.vo.EncryptedVO;
import com.tt.tools.response.BaseService;
import com.tt.tools.service.EncryptedService;
import com.tt.tools.untils.UnifiedResponse;
import groovy.util.logging.Slf4j;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author admin
 */
@Slf4j
@CrossOrigin
@RestController
@Api(value = "tools相关方法")
@RequestMapping("api/useUrl")
public class ToolsApi extends BaseService {
    private static final Logger log = LoggerFactory.getLogger(UseUrlApi.class);
    @Resource
    private EncryptedService encryptedService;

    @ApiOperation("使用Jasypt加密")
    @PostMapping("post/getJasypt")
    public UnifiedResponse getJasypt(@RequestBody EncryptedVO encryptedVO){
        try {

            UnifiedResponse unifiedResponse = encryptedService.saveAndJasypt(encryptedVO);
            log.info("保存加密后数据成功");
            return new UnifiedResponse(200,"加密成功",unifiedResponse);
        } catch (Exception e){
            log.error("getJasypt error",e);
            return error(200,"error"+e);
        }

    }
}
