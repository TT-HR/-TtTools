package com.tt.tools.response;

import com.tt.tools.enums.ResponseEnum;
import com.tt.tools.untils.UnifiedResponse;

/**
 * @author admin
 * 返回体
 */
public class BaseService<T> {
    public UnifiedResponse<T> success(T data){
        return new UnifiedResponse<>(ResponseEnum.SUCCESS.CODE,ResponseEnum.SUCCESS.message,data);
    }

    public UnifiedResponse<T> success(){
        return new UnifiedResponse<>(ResponseEnum.SUCCESS.CODE,ResponseEnum.SUCCESS.message);
    }

    public UnifiedResponse<T> error(T data){
        return new UnifiedResponse<>(ResponseEnum.ERROR.CODE,ResponseEnum.ERROR.message,data);
    }

    public UnifiedResponse<T> error(){
        return new UnifiedResponse<>(ResponseEnum.ERROR.CODE,ResponseEnum.ERROR.message);
    }
    public UnifiedResponse<T> error(int code,String msg){
        return new UnifiedResponse<>(code,msg);
    }
}
