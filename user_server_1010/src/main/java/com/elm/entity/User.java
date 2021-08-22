package com.elm.entity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @TableId(type = IdType.ID_WORKER_STR)
    private String userId;
    private String password;
    private String userName;
    private Integer userSex;
    private String userImg;
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer userTag;
}
