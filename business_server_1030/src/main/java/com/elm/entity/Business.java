package com.elm.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Business {
    @TableId(type = IdType.ID_WORKER)
    private Long businessId;
    private String businessName;
    private String businessAddress;
    private String businessExplain;
    private String businessImg;
    private Integer orderTypeId;  //类别
    private Double starPrice;
    private Double deliveryPrice;  //运费
    private String remarks;

    @TableField(exist = false)
    private List<Food> foodList;    //商家发布的食品信息列表
}
