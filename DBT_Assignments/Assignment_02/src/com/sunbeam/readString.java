package com.sunbeam;

import java.util.Scanner;

public class readString {
	String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) throws ExceptionLineTooLong {
		if(msg.length() > 80)
			throw new ExceptionLineTooLong();
		this.msg = msg;
	}
	
	

}
