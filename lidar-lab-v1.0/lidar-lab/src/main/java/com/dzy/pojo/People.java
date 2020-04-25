package com.dzy.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class People implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String picture;
    private String name;
    private String detail;
    private String type;
}
