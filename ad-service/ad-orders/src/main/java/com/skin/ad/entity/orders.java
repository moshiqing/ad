package com.skin.ad.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class orders {

    @TableId(type = IdType.AUTO)
    private int id;

    private String name;
}
