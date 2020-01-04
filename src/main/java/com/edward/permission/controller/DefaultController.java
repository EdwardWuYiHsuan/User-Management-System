package com.edward.permission.controller;

import java.util.UUID;

import com.edward.permission.exception.ApiException;
import com.edward.permission.response.DefaultResponse;
import com.edward.permission.response.Result;

public abstract class DefaultController {

	public DefaultResponse renderErrorResponse(Throwable causeEx)
	{
		String logCode = UUID.randomUUID().toString().split("-")[0];
		
//		System.out.printf("[API]\tLog Code: %s,\tError: %s\n", logCode, causeEx.getMessage());
//		System.out.println(ExceptionUtils.getStackTrace(causeEx));
		
		if ((causeEx instanceof ApiException) == false) {
			String convertMsg = String.format("Internal Server Error, Please seek Admin to find root cause in log by log-code '%s'", logCode);
			causeEx = new Throwable(convertMsg, causeEx);
		}
		
		return new DefaultResponse(Result.error, causeEx);
	}
	
}
