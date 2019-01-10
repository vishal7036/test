 package com.example.parser.sexparser;

import java.util.ArrayList;
import java.util.Stack;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class UserParserHandler extends DefaultHandler
{
	 
    private ArrayList<User> userList = new ArrayList<User>();
    
   
    private Stack<String> elementStack = new Stack<String>(); 
    private Stack<User> objectStack = new Stack<User>();

    public void startDocument() throws SAXException
    {
    }

    public void endDocument() throws SAXException
    {
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
    {
        this.elementStack.push(qName);

        if ("user".equals(qName))
        {
        	User user = new User();
            
            if(attributes != null && attributes.getLength() == 1)
            {
            	user.setId(Integer.parseInt(attributes.getValue(0)));
            }
            this.objectStack.push(user);
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException
    {	
    	 this.elementStack.pop();

        if ("user".equals(qName))
        {
            User object = this.objectStack.pop();
            this.userList.add(object);
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException
    {
        String value = new String(ch, start, length).trim();

        if (value.length() == 0)
        {
            return; // ignore white space
        }
        
        if ("firstName".equals(currentElement()))
        {
            User user = (User) this.objectStack.peek();
            user.setFirstName(value);
        }
        else if ("lastName".equals(currentElement()))
        {
            User user = (User) this.objectStack.peek();
            user.setLastName(value);
        }
    }
    
    private String currentElement()
    {
        return this.elementStack.peek();
    }
    
    public ArrayList<User> getUsers()
    {
    	return userList;
    }
}
