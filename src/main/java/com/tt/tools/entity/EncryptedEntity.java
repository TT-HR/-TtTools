package com.tt.tools.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author admin
 */
@Data
@TableName(value = "encrypted")
public class EncryptedEntity {
    private int id;
    private String userCode;
    private String salt;
    private String beforeData;
    private String afterData;
    private Date encryptedDate;

}
