package com.edward.permission.enumeration;

public enum APICode {
	
	OK(0),
	InvalidParameter(101),
	AccessFailed(102),
	Other(999);
	
	
	private int code;
	APICode(int code) 
	{
		this.code = code;
	}
	
	public int getCode()
	{
		return code;
	}

}
