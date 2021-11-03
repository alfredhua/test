package com.desgin.template;

/**
 * 定义模板的基类
 */
public abstract class ITemplate {

    /**
     * 模板执行方法,设定执行顺序
     */
    public final void execute(){
        this.first();
        this.second();
        this.three();
    }

    abstract void first();
    abstract void second();
    abstract void three();
}
