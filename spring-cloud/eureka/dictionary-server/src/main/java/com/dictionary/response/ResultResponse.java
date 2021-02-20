package com.dictionary.response;

import lombok.Data;

@Data
public class ResultResponse {

    boolean isok=true;
     DefineError error=new DefineError("","");

    public ResultResponse() {
    }

    public ResultResponse(boolean isok, DefineError error) {
        this.isok = isok;
        this.error = error;
    }

    public static ResultResponse success() {
        return new ResultResponse(true,null);
    }

    public  static  ResultResponse error(String name,String msg){
        return new ResultResponse(false, new DefineError(name ,msg));
    }

    public static ResultResponse delError(){
        return new ResultResponse(false, new DefineError("del_error" ,"删除失败"));
    }

    public static ResultResponse editError(){
        return new ResultResponse(false, new DefineError("edit_error" ,"更新失败"));
    }

    public static ResultResponse saveError(){
        return new ResultResponse(false, new DefineError("save_error" ,"保存失败"));
    }


}
