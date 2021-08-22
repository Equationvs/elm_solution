package com.elm.handler;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        //设置订单的日期
        this.setFieldValByName("orderDate",new Date(),metaObject);
        //设置逻辑删除字段 默认值是0
        this.setFieldValByName("userTag",0,metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        //设置订单的日期
        this.setFieldValByName("orderDate",new Date(),metaObject);
    }
}
