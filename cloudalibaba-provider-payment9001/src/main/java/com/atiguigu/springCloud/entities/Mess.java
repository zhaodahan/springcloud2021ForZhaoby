package com.atiguigu.springCloud.entities;

import lombok.Data;

import java.io.Serializable;

/**
 * mess
 * @author 
 */
@Data
public class Mess implements Serializable {
    private Integer id;

    private Integer len;

    private static final long serialVersionUID = 1L;
}