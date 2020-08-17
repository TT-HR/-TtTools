package com.tt.tools.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tt.tools.entity.file.FileUploadInfoEntity;


/**
 * @author admin
 */
public interface UploadService extends IService<FileUploadInfoEntity> {
    /**
     * upPath() 用于获取存在数据库中的完整路径，方便维护
     * @return String类型
     * @param module 模块类型
     * */
    String upPath(String module);

    /**
     * saveUpload() 用于储存保存文件的参数和状态
     * @param fileUploadInfoEntity 实体
     * */
    void saveUpload(FileUploadInfoEntity fileUploadInfoEntity);
}
