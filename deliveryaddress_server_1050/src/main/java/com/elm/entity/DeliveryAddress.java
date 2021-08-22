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
public class DeliveryAddress {
    @TableId(type = IdType.ID_WORKER)
    private Long daId;
    private String contactName;
    private Integer contactSex;
    private String contactTel;
    private String address;
    private String userId;

}
