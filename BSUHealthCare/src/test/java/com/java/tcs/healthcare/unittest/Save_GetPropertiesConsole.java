package com.java.tcs.healthcare.unittest;

import java.io.IOException;

import com.java.tcs.healthcare.properties.SaveProperies;

public class Save_GetPropertiesConsole {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			SaveProperies.saveProperties("key2", "value1");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
