package org.nandish.examples.MessengerOne.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.nandish.examples.MessengerOne.Model.Model;
import org.nandish.examples.MessengerOne.var.*;
import oracle.jdbc.OracleDriver;

public class Service 
{

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet res;
	
	LastAddedColumn lastAddedColumn = new LastAddedColumn();

	public Service() 
	{
		try 
		{
			DriverManager.registerDriver(new OracleDriver());
			con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","system","system");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public ArrayList<Model> getMessage(int id)
	{
		ArrayList <Model> messages = new ArrayList<>();
		try
		{
			pstmt = con.prepareStatement("SELECT * FROM MESSENGER WHERE KEY=?");
			pstmt.setInt(1,id);
			res = pstmt.executeQuery();
			
			while (res.next()==true)
			{
				int id1 = res.getInt(1);
				String m = res.getString(2);
				messages.add(new Model(id1,m));
				return messages;
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public Model sendMessage(Model m)
	{
		
		try
		{
			/*int index;
			pstmt = con.prepareStatement("SELECT COUNT(KEY) AS index FROM MESSENGER)");
			pstmt.executeQuery();
			res = pstmt.getResultSet();
			res.getInt(index);*/
			
			pstmt = con.prepareStatement("INSERT INTO MESSENGER VALUES(?,?)");
			String message =  m.getMessage();
			(lastAddedColumn.l)++;
			m.setId(lastAddedColumn.l);
			pstmt.setInt(1, lastAddedColumn.l);
			pstmt.setString(2, message);
			pstmt.executeUpdate();
			
		//	messages.add(new Model(id,message));
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return m;
	}
	
	public ArrayList<Model> getAllMessages()
	{
		ArrayList<Model> a = new ArrayList<>(); 
		try
		{
			pstmt = con.prepareStatement("SELECT * from MESSENGER");
			res = pstmt.executeQuery();
			while(res.next())
			{
				a.add(new Model(res.getInt(1),res.getString(2)));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return a;
	}
	
	public void deleteMessage(int id)
	{
		try
		{
			pstmt = con.prepareStatement("DELETE FROM MESSENGER WHERE KEY=?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
