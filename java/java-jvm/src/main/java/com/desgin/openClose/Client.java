package com.desgin.openClose;

public class Client{

   public static void main(String[] args){
     ICourse course = new JavaCourse(1,"Java",100.00);
     System.out.println("书籍名字："+course.getName()+"书籍价格："+course.getPrice());
   }

}