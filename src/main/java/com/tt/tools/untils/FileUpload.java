package com.tt.tools.untils;

import com.tt.tools.enums.Constants;
import com.tt.tools.service.UploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

/**
 * @author TT
 */
public class FileUpload {
    private static final Logger log = LoggerFactory.getLogger(FileUpload.class);

    @Autowired
    UploadService uploadService;
    /**
     * 单文件上传
     * */
    public String fileUpload(MultipartFile file){
        if (file.isEmpty()){
            log.info("失败,文件为空");
            return "error";
        }
        // 获取文件名
        String fileName = UUID.randomUUID().toString();

        // 获取文件的后缀名
        //String suffixName = fileName.substring(fileName.lastIndexOf("."));

        // 文件路径
        String filePath = uploadService.upPath(Constants.UPLOAD);

        // 完整文件路径
        File dest = new File(filePath + fileName);

        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            log.info("上传成功");
        } catch (IOException e) {
            log.info("上传失败",e);
            e.printStackTrace();
        }
        return "success";
    }

}
