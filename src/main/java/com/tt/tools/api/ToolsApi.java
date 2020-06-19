package com.tt.tools.api;

import com.tt.tools.entity.untilvo.StringListVO;
import com.tt.tools.untilmethod.encrypto.JasyptUntil;
import com.tt.tools.untils.UnifiedResponse;
import groovy.util.logging.Slf4j;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author admin
 */
@Slf4j
@CrossOrigin
@RestController
@Api(value = "tools相关方法")
@RequestMapping("api/useUrl")
public class ToolsApi{
    private static final Logger log = LoggerFactory.getLogger(UseUrlApi.class);
    @Autowired
    private JasyptUntil jasyptUntil;

    @ApiOperation("使用Jasypt加密")
    @PostMapping("post/getJasypt")
    public UnifiedResponse getJasypt(@RequestBody StringListVO stringListVO){
        //保存加密前数据

        log.info("保存加密前数据成功");
        //加密
        List encrypto = jasyptUntil.encrypto(stringListVO.getString(), stringListVO.getList());
        log.info("加密后数据成功");
        //保存加密后数据

        log.info("保存加密后数据成功");
        return new UnifiedResponse(200,"加密成功",encrypto);
    }
}
