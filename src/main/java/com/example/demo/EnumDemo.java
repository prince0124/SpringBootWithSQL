package com.example.demo;

public enum EnumDemo {

	ADD,MUL,DIV,SUB;
	      
	  public int cal(int a,int b)
	  {
		  switch(this) {
		  case ADD:
			  return a+b;
		  case MUL:
			  return a*b;
		  case DIV:
			  return a/b;
		  case SUB:
			  return a-b;
		  default:
			  throw new AssertionError("Unknown Property :"+this);
			  
		  }
		
		  
	  }
}
