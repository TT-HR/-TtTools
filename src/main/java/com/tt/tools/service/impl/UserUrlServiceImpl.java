package com.tt.tools.service.impl;

import com.tt.tools.entity.UseUrlEntity;
import com.tt.tools.mapper.UseUrlMapper;
import com.tt.tools.service.UseUrlService;
import groovy.util.logging.Slf4j;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author admin
 */
@Service
@Slf4j
@AllArgsConstructor
public class UserUrlServiceImpl implements UseUrlService {
    @Autowired
    private UseUrlMapper useUrlMapper;
    @Override
    public List<UseUrlEntity> getUseUrl() {
        return useUrlMapper.getUseUrl();
    }
}
