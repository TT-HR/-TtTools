package com.tt.tools.entity.file;

import lombok.Data;

/**
 * @author TT
 */
@Data
public class FileUploadInfoEntity {
    private int id;
    private String fileName;
    private String uuidFileName;
    private Double fileSize;
    private int status;


}
