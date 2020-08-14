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

    @Override
    public List saveAndJasypt(EncryptedVO encryptedVO) {
        //加密
        List encrypto = jasyptUntil.encrypto(encryptedVO.getSalt(), encryptedVO.getData());
        if (encrypto.size()==0){
            log.info("加密后的值为空");
            return null;
        }
        log.info("加密数据成功");
        //保存加密后数据
        EncryptedEntity encryptedEntity = new EncryptedEntity();
        encryptedEntity.setSalt(encryptedVO.getSalt());
        encryptedEntity.setBeforeData(encryptedVO.getData().toString());
        encryptedEntity.setAfterData(encrypto.toString());
        encryptedEntity.setEncryptedDate(new Date());
        saveOrUpdate(encryptedEntity);

        return encrypto;
    }

}
