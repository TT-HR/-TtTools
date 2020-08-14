package com.tt.tools.entity.vo;

import lombok.Data;

import java.util.List;

/**
 * @author admin
 */
@Data
public class EncryptedVO {
    private String salt;

    private List<String> data;
}
