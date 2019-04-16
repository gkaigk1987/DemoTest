package com.gk.jwt;

import java.util.UUID;

public class Constants {
	
	public static final String JWT_ID = UUID.randomUUID().toString();
	
	public static final String JWT_SECRET = "gk_test_jwt";
	
	public static final int JWT_TTL = 60 * 60 * 1000;	//1个小时

}
