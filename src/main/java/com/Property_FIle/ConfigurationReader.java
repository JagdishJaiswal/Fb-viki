package com.Property_FIle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

	private Properties p;

	public ConfigurationReader() throws IOException {
		File f = new File(
				"C:\\Users\\VIGNESH S\\eclipse-workspace\\FACEBOOK_PROJECT\\src\\main\\java\\com\\Property_FIle\\FaceBook.properties");
		FileInputStream fi = new FileInputStream(f);
		p = new Properties();
		p.load(fi);
	}

	public String getBrowser() {
		String browser = p.getProperty("browser");
		return browser;
	}

	public String getUrl() {
		String url = p.getProperty("url");
		return url;

	}

	public String getUsername() {
		String username = p.getProperty("username");
		return username;
	}

	public String getPassword() {
		String password = p.getProperty("password");
		return password;
	}
}
