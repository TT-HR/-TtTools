package com.tt.tools.mapper;

import com.tt.tools.entity.UseUrlEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author admin
 */
@Mapper
public interface UseUrlMapper {
    /**
     *查询useUrl表的数据
     * @return pojo UseUrlEntity
     * **/
    @Select("select * from use_url")
    List<UseUrlEntity> getUseUrl();
}
