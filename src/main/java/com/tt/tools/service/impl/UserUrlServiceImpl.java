package com.tt.tools.service.impl;

import com.tt.tools.entity.UseUrlEntity;
import com.tt.tools.mapper.UseUrlMapper;
import com.tt.tools.response.BaseService;
import com.tt.tools.service.UseUrlService;
import com.tt.tools.untils.UnifiedResponse;
import groovy.util.logging.Slf4j;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author admin
 */
@Service
@Slf4j
@AllArgsConstructor
public class UserUrlServiceImpl extends BaseService implements UseUrlService {
    private static final Logger log = LoggerFactory.getLogger(UserUrlServiceImpl.class);

    @Autowired
    private UseUrlMapper useUrlMapper;

    @Override
    public UnifiedResponse getUseUrl() {
        try {
            List<UseUrlEntity> useUrl = useUrlMapper.getUseUrl();
            return success(useUrl);
        }catch (Exception e){
            log.info("查询错误:"+e);
            return error();
        }
    }
}
