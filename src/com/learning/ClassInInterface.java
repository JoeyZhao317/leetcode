package com.learning;

public interface ClassInInterface {
    void howdy();
    class Test implements ClassInInterface {
    public void howdy(){
    	System.out.println("howdy111");
    }
     public static void main(String[] args) {
         new Test().howdy();
     }
    }
}