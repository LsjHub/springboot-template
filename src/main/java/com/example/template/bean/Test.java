package com.example.template.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@TableName(value = "test")
@Data
public class Test implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 扩展字段1
     */
    private String updateExtend1;

    /**
     * 扩展字段2
     */
    private String updateExtend2;

    /**
     * 扩展字段3
     */
    private String updateExtend3;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
