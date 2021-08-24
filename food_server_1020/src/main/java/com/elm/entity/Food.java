package com.elm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Food {
    @TableId(type = IdType.ID_WORKER)
    private Long foodId;
    private String foodName;
    private String foodExplain;
    private String foodImg;
    private double foodPrice;
    private Long businessId;
    private String remarks;
}










