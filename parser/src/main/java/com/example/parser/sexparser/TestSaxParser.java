package com.example.parser.sexparser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class TestSaxParser 
{
	public static void main(String[] args) throws FileNotFoundException 
	{
		
		File xmlFile = new File("D:/Vishal/JAVA-Wok/Spring-XMl-Parser/parser/sample.xml");
		
		
		UsersXmlParser parser = new UsersXmlParser();
		
		ArrayList<User> users = parser.parseXml(new FileInputStream(xmlFile));
		
		System.out.println(users);
	}
}
