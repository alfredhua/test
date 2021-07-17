package com.common;


/**
 * @author guozhenhua
 * @date 2021/07/12
 */
public class Test2 {

    private static volatile Test2 test2=null;

    private Test2(){
    }

    public static  Test2 getInstance(){
        if (test2==null){
            synchronized(Test2.class){
                if (test2==null){
                    test2=new Test2();
                }
            }
        }
        return test2;
    }

}
