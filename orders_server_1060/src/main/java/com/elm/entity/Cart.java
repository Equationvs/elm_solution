package com.elm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {

    @TableId(type = IdType.ID_WORKER)
    private Long cartId;
    private Long foodId;
    private Long businessId;
    private String userId;
    private Integer quantity;

    @TableField(exist = false)
    private Food food;
    @TableField(exist = true)
    private Business business;

}
