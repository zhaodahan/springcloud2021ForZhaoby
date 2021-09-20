package com.atiguigu.springCloud.entities;

import java.io.Serializable;
import lombok.Data;

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