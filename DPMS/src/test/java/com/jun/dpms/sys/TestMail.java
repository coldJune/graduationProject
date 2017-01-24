package com.jun.dpms.sys;

import static org.junit.Assert.*;

import org.junit.Test;

import com.jun.dpms.util.SendMail;

public class TestMail {

	@Test
	public void test() {
		SendMail.send("785691557@qq.com", "TestMail");
	}

}
