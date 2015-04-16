package com.learning;


public class InnerClass extends Enclosing.Inner3{
    public InnerClass(Enclosing en) {
    	en.super();
    }
	
	public static void main(String[] args){
		Enclosing b = new Enclosing();
		Enclosing.Inner2 inner2 = b.new Inner2();
		b.f();
	}
}


class Enclosing {
	public Enclosing(){
		Inner1 c = new Inner1();
	    class ClassInMethod {
			public ClassInMethod() {
				System.out.println("ClassInMethod");
			}
		};
		//ClassInMethod test = new ClassInMethod();
	}
	
	public void f() {
		Inner1 f = new Inner1() {
			private int a;
			{
				//instance initialization
				a = 100;
				System.out.println("initialization");
			}
		};
	}
	
	private class Inner1{
		
	}
	
	protected class Inner2{
		public Inner2() {
			System.out.println("inner2");
		}
	}
	
	class Inner3 extends Inner2 {
		
	}
}