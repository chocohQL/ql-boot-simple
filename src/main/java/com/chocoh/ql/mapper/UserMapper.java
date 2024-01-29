package com.chocoh.ql.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chocoh.ql.domain.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author chocoh
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
