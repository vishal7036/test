 package com.example.parser.sexparser;

import java.io.InputStream;
import java.util.ArrayList;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class UsersXmlParser 
{
	public ArrayList<User> parseXml(InputStream in)
	{
		
		ArrayList<User> users = new ArrayList<User>();
		try 
		{
			
			UserParserHandler handler = new UserParserHandler();
			
			XMLReader parser = XMLReaderFactory.createXMLReader();
			parser.setContentHandler(handler);

			InputSource source = new InputSource(in);
			
			parser.parse(source);
			
			users = handler.getUsers();

		} catch (Exception e) {
			e.printStackTrace();
		} 
		return users;
	}
}
