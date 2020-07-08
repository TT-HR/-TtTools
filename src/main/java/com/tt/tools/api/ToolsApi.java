package com.tt.tools.api;

import com.tt.tools.entity.EncryptedEntity;
import com.tt.tools.entity.untilvo.StringListVO;
import com.tt.tools.mapper.EncryptedMapper;
import com.tt.tools.untilmethod.encrypto.JasyptUntil;
import com.tt.tools.untils.UnifiedResponse;
import groovy.util.logging.Slf4j;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
    @Resource
    private EncryptedMapper encryptedMapper;

    @ApiOperation("使用Jasypt加密")
    @PostMapping("post/getJasypt")
    public UnifiedResponse getJasypt(@RequestBody StringListVO stringListVO){
        //加密
        List encrypto = jasyptUntil.encrypto(stringListVO.getString(), stringListVO.getList());
        log.info("加密后数据成功");
        //保存加密后数据
        EncryptedEntity encryptedEntity = new EncryptedEntity();
        encryptedEntity.setSalt(stringListVO.getString());
        encryptedEntity.setBeforeData(stringListVO.getList().toString());
        encryptedEntity.setAfterData(encrypto.toString());
        encryptedMapper.save(encryptedEntity);
        log.info("保存加密后数据成功");
        return new UnifiedResponse(200,"加密成功",encrypto);
    }
}