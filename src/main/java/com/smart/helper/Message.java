package com.smart.helper;

import java.util.ArrayList;
import java.util.List;

public class Message {
	
	private String type;
	private List<String> content =new ArrayList<String>();  
	public Message(List<String> content,String type) {
		super();
		this.type = type;
		this.content = content;
	}
	public List<String> getContent() {
		return content;
	}
	public void setContent(List<String> content) {
		this.content = content;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
