package org.nandish.examples.MessengerOne.Model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Model 
{
	private int id;
	private String message;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public Model(int id, String message) {
		super();
		this.id = id;
		this.message = message;
	}
	
	public Model() {
		super();
	}
	
	
	
	

}
