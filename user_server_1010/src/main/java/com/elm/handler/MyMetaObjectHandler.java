package com.elm.handler;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        //设置逻辑删除字段 默认值是0
        this.setFieldValByName("userTag",0,metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {

    }
}
