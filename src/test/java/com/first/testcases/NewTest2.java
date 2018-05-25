package com.first.testcases;

import org.testng.annotations.Test;

import com.first.utils.AssertUtils;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class NewTest2 {
	AssertUtils assertUtils=null;
  @BeforeTest
	  public void setUp() {
	  assertUtils=new AssertUtils();
	  }
  @Test
  public void f1() {
	  //Assert.assertEquals(2, 1);//断言异常
	  assertUtils.checkIntNum(2, 1);
  }
  @Test
  public void f2() {
	//Assert.assertEquals(1, 1);
	  assertUtils.checkIntNum(1, 1);
  }

  @AfterTest
  public void tearDome() {	  
  };

}
