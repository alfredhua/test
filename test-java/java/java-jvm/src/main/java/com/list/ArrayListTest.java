package com.list;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {


    public static void main(String[] args) {
        List<Integer> arrayList=new ArrayList<>();
        //添加
        arrayList.add(1);
        //获取
        arrayList.get(0);
        //移除
        arrayList.remove(0);
        //是否包含
        arrayList.contains(1);
    }
}
