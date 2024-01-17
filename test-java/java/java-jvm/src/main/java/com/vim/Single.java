package com.vim;

import java.io.Serializable;

public class Single implements  Serializable{


    private  Object readResolve(){
        return null;
    }


}
