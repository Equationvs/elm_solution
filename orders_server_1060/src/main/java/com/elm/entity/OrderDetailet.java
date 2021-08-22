package com.elm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailet {
    @TableId(type= IdType.ID_WORKER)
    private Long odId; //订单明细编号
    private Long orderId; //订单编号
    private Long foodId;
    private Integer quantity;
}
