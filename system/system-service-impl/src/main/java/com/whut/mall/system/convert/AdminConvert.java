package com.whut.mall.system.convert;

import com.whut.mall.system.api.bo.admin.AdminAuthenticationBO;
import com.whut.mall.system.dataobject.AdminDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AdminConvert {

    AdminConvert INSTANCE = Mappers.getMapper(AdminConvert.class);

    @Mappings({})
    AdminAuthenticationBO convert2(AdminDO admin);
}
