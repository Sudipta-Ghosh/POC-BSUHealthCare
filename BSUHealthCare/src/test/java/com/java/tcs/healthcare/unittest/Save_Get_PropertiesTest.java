package com.java.tcs.healthcare.unittest;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import com.java.tcs.healthcare.properties.ReadProperties;
import com.java.tcs.healthcare.properties.SaveProperies;

public class Save_Get_PropertiesTest {

	@Test
	public void saveProperiestest() {
		try {
			assertEquals("Properties Save Successfuly",SaveProperies.saveProperties("abc1", "adsd"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void getProperiestest() {
		try {
			System.out.println("1=="+ReadProperties.getAllProperties());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
