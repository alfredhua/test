package com;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(5);
        Set<Integer> set=new HashSet<>();
        for (int i=0;i<list.size();i++){
            if (set.contains(list.get(i))){
                list.remove(i);
            }
            set.add(list.get(i));
        }
//        for (int i=list.size()-1;i>=0;i--){
//            if (set.contains(list.get(i))){
//                list.remove(i);
//            }
//            set.add(list.get(i));
//        }
//
        System.out.println(list.toString());

    }


}
