package com.tt.tools.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tt.tools.entity.EncryptedEntity;
import com.tt.tools.entity.vo.EncryptedVO;
import com.tt.tools.untils.UnifiedResponse;

/**
 * @author admin
 */
public interface EncryptedService extends IService<EncryptedEntity> {

    /**
     * save Encrypted
     * @param encryptedVO EncryptedEntity的VO
     * */
    UnifiedResponse saveAndJasypt(EncryptedVO encryptedVO);
}
