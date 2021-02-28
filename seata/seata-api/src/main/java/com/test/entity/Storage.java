package com.test.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author guozhenhua
 * @date 2021/02/28
 */

@Getter
@Setter
public class Storage implements Serializable {

    private Integer id;

    private String commodityCode;

    private String name;

    private Integer count;

}
