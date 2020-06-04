package com.tt.tools.service;

import com.tt.tools.entity.UseUrlEntity;

import java.util.List;

/**
 * @author admin
 */
public interface UseUrlService {
    /**
     * select useUrl service
     * @return pojo UseUrlEntity
     * */
    List<UseUrlEntity> getUseUrl();
}
