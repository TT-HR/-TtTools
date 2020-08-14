package com.tt.tools.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tt.tools.entity.EncryptedEntity;
import com.tt.tools.entity.vo.EncryptedVO;
import com.tt.tools.mapper.EncryptedMapper;
import com.tt.tools.service.EncryptedService;
import com.tt.tools.untilmethod.encrypto.JasyptUntil;
import com.tt.tools.untils.UnifiedResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


/**
 * @author admin
 */
@Service
public class EncryptedServiceImpl extends ServiceImpl<EncryptedMapper, EncryptedEntity> implements EncryptedService {
    private static final Logger log = LoggerFactory.getLogger(EncryptedServiceImpl.class);
    @Autowired
    private JasyptUntil jasyptUntil;
    @Resource
    private EncryptedMapper encryptedMapper;

    @Override
    public UnifiedResponse saveAndJasypt(EncryptedVO encryptedVO) {
        //加密
        List encrypto = jasyptUntil.encrypto(encryptedVO.getSalt(), encryptedVO.getData());
        if (encrypto.size()==0){
            return new UnifiedResponse(500,"数据不存在");
        }
        log.info("加密数据成功");
        //保存加密后数据
        EncryptedEntity encryptedEntity = new EncryptedEntity();
        encryptedEntity.setSalt(encryptedVO.getSalt());
        encryptedEntity.setBeforeData(encryptedVO.getData().toString());
        encryptedEntity.setAfterData(encrypto.toString());
        encryptedEntity.setEncryptedDate(new Date());
        saveOrUpdate(encryptedEntity);

        return new UnifiedResponse(200,"加密成功",encrypto);
    }

}
