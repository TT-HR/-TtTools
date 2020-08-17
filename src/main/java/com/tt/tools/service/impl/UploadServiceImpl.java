package com.tt.tools.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tt.tools.entity.file.FileUploadInfoEntity;
import com.tt.tools.mapper.UploadMapper;
import com.tt.tools.service.UploadService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author admin
 */
@Service
public class UploadServiceImpl extends ServiceImpl<UploadMapper,FileUploadInfoEntity> implements UploadService {
    @Resource
    UploadMapper uploadMapper;

    @Override
    public String upPath(String module) {
        return uploadMapper.getPath(module);
    }

    @Override
    public void saveUpload(FileUploadInfoEntity fileUploadInfoEntity) {
        save(fileUploadInfoEntity);
    }
}
