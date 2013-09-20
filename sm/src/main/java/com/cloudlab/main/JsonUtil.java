/**
 * 文件名：JsonUtil.java
 *
 * 版本信息： version 1.0
 * 日期：2013-9-15
 * Copyright by menuz
 */
package com.cloudlab.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;

import com.cloudlab.model.Datagrid;
import com.cloudlab.model.Student;

public class JsonUtil {
	public void test() {
		
	}
	
	public static void main(String[] args) {
		List<Student> users = new ArrayList<Student>();
		Student user = new Student("1", "2", "3", "4", 1);
		Student user1 = new Student("1", "2", "3", "4", 1);
		Student user2 = new Student("1", "2", "3", "4", 1);
		users.add(user); users.add(user1); users.add(user2);
		
		Datagrid datagrid = new Datagrid(3, users);
		
		
		JsonGenerator jsonGenerator = null;
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			jsonGenerator = objectMapper.getJsonFactory().createJsonGenerator(System.out, JsonEncoding.UTF8);
			
//			 jsonGenerator.writeObject(user);
//			 jsonGenerator.writeObject(user1);
//			 jsonGenerator.writeObject(user2);
			 // objectMapper.writeValue(System.out, bean);
			
			
			jsonGenerator.writeObject(datagrid);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}


