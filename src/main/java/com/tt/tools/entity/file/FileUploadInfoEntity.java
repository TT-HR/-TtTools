package com.tt.tools.entity.file;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author TT
 */
@Data
@TableName(value = "file_upload_info")
public class FileUploadInfoEntity {
    private int id;
    private String userCode;
    private String fileName;
    private String filePath;
    private String uuidFileName;
    private Double fileSize;
    private int status;
    private Date upDate;
}
