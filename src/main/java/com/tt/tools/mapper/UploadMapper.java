package com.tt.tools.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tt.tools.entity.file.FileUploadInfoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


/**
 * @author admin
 */
@Mapper
public interface UploadMapper extends BaseMapper<FileUploadInfoEntity> {
    /**
     * getPath() 获取path的mapper方法
     * @return map类型
     * @param module 模块类型
     * */
    @Select("select path from tools_path where 1=1 and module = #{module}")
    String getPath(@Param("module") String module);
}
