package com.whut.mall.system.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.whut.mall.system.dataobject.AdminDO;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper extends BaseMapper<AdminDO> {
    default AdminDO selctByUsername(@Param("username") String username){
        return selectOne(new QueryWrapper<AdminDO>().eq("username",username));
    }
}
