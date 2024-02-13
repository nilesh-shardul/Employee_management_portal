package com.myproject.rest;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.myproject.dao.EmployeeDAO;

@Path("/employee")
public class EmployeeRestAPI {
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	
	public String addEmployee(String empData) throws ClassNotFoundException, SQLException, ParseException {
		
		System.out.println(empData + " input string from UI");
		
		JSONParser jp = new JSONParser();
		JSONObject jo1 = (JSONObject) jp.parse(empData);
		
		EmployeeDAO add = new EmployeeDAO();
		String msg = add.addInEmployee((String)jo1.get("firstname"),(String)jo1.get("lastname"),(String)jo1.get("email"));
		System.out.println(msg);
		
		return empData;
	}
}
