package com.mercury.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	public ConfigReader(){
		
		SetupConfig();
	}
	
	Properties objPro;
	FileInputStream objFIS;
	
	public void SetupConfig()
	{
		File objFile = new File(".//Configuaration//config.property");
	
		try {
			objFIS = new FileInputStream(objFile);
			objPro = new Properties();
			objPro.load(objFIS);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
	}
	
	public String getApplicationURL()
	{
		
		return objPro.getProperty("ApplicationURL");
	}
	


}
