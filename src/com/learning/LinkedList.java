package com.learning;

public class LinkedList {
	public static void main(String[] args) {
		Node head = new Node();
		Node next = head;
		for(int i = 0; i<10;i++) {
			Node node = new Node();
			node.mData = i;
			next.next = node;
			next = node;
		}
		head = head.next;
		while(head != null) {
			System.out.println(head.mData);
			head=head.next;
		}
	}
	
}

class Node {
	public int mData;
	public Node next;
}

class A {
	protected int function(int a, int b) {
		return 0;
	}
}

class B extends A {
	//can not reduce the visibility of super class
	//can not override into static function
	public int function(int a, long b) {
		return 1;
	}
}