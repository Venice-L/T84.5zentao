package com.first.utils;

import junit.framework.Assert;

//断言封装
public class AssertUtils {
    //1.整型数相等断言
	protected static Log log=new Log(AssertUtils.class);
	public void checkIntNum(int actual,int expected,String...com){
	try{	
		Assert.assertEquals(actual, expected);
	}catch(AssertionError e){
		log.error("断言失败");
		Assert.fail("断言失败");
	}
 }
	//2.字符串相等断言
	public void CheckString(String actual,String expected,String...com){
		Assert.assertEquals(actual, expected);
 }
	//3.字符串包含断言
	public void checkStringContains(String actual,String expected,String...com){
		Assert.assertEquals(true, actual.contains(expected));
 }
	//4.非空断言
	public void checkNotNull(Object actual,String...com){
		Assert.assertNotNull(actual);
 }
	//5....	
}