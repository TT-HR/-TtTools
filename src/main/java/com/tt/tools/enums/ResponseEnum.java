package com.tt.tools.enums;

import lombok.AllArgsConstructor;

/**
 * @author admin
 */
@AllArgsConstructor
public enum  ResponseEnum {
    SUCCESS(200,"success"),
    ERROR(500,"error");
    public Integer CODE;
    public String message;
}
