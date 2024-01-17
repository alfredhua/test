package com.test.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @auth guozhenhua
 * @date 2019/08/29
 */
@Getter
@Setter
public class Account implements Serializable {

  private Integer id;

  private String user_id;

  private Double amount;
  /**
   * 创建时间
   */
  private LocalDateTime create_time;

  /**
   * 更新时间
   */
  private LocalDateTime update_time;

  /**
   * 是否删除,0:未删除,1删除
   */

  private Short del;

}
