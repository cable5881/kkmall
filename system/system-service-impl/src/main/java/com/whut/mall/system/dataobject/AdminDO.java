package com.whut.mall.system.dataobject;

import com.baomidou.mybatisplus.annotation.TableName;
import com.whut.mall.common.framework.dataobject.DeletableDO;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 管理员实体
 */
@TableName(value = "admin")
@Data
@Accessors(chain = true)
public class AdminDO extends DeletableDO {

    //id
    private Integer id;

    //用户名
    private String username;

    //密码
    private String password;

    // 昵称
    private String nickname;

    //状态
    private Integer status;

}
