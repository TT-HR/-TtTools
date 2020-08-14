package com.tt.tools.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tt.tools.entity.EncryptedEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author admin
 */
@Mapper
public interface EncryptedMapper extends BaseMapper<EncryptedEntity> {
}
