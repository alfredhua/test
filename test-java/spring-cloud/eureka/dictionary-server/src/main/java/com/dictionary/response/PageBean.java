package com.dictionary.response;

import lombok.Data;

import java.util.List;

/**
 * @author hua
 * @param <T>
 */
@Data
public class PageBean<T>  {

    private int page=0;
    private int total;
    private int page_size=10;
    private List<T> list;
    private int off_set;

}
