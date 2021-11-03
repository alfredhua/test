package com.desgin.stargy;

public class Context {
   private IStrategy strategy;
 
   public Context(IStrategy strategy){
      this.strategy = strategy;
   }
 
   public void executeStrategy(){
       strategy.pay();
   }
}