package com.tt.tools.untils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author TT
 */
@Data
@ApiModel(value = "响应消息体")
public class UnifiedResponse<T> {
    @ApiModelProperty(value = "响应吗")
    private Integer code;
    @ApiModelProperty(value = "响应消息")
    private String message;
    @ApiModelProperty(value = "响应数据")
    private T data;

    public UnifiedResponse(T data){
        this.data = data;
    }

    public UnifiedResponse(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public UnifiedResponse(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    public UnifiedResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
