package com.elm.entity;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @TableId(type = IdType.ID_WORKER)
    private Long orderId;
    private String userId;
    private Long businessId;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date orderDate;
    private Double orderTotal;
    private Integer daId;
    private Integer orderState;
}
