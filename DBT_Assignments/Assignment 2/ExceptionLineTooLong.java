package com.sunbeam;

public class ExceptionLineTooLong extends Exception{
	String msg;
	public ExceptionLineTooLong() {
		// TODO Auto-generated constructor stub
	}
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String getMessage() {
	return msg + " is too long.";
	}
}
