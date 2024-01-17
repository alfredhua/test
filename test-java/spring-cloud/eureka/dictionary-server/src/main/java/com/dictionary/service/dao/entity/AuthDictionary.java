package com.dictionary.service.dao.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author hua
 */
@Data
public class AuthDictionary {

    private Integer id;
    private String value;
    private String href;
    private String comment;
    private Integer parent_id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime create_time;

}
