package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.model.Login;
//import com.model.Login;
import com.model.Register;

public class DBApplication {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public Connection myConnection(){
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "Newuser123");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public int saveData(List<Register> ls) {
		int i=0;
		Register u = null;
		con = myConnection();
		try {
			Iterator<Register> itr = ls.iterator();
			while(itr.hasNext())
			{
				u = itr.next();
				ps = con.prepareStatement("insert into member1 values(?,?,?,?,?,?,?,?)");
				ps.setString(1, u.getFname());
				ps.setString(2, u.getUname());
				ps.setString(3, u.getPassword());
				ps.setString(4, u.getGender());
				ps.setString(5, u.getEmail());
				ps.setLong(6, u.getPhone());
				ps.setString(7, u.getSubject());
				ps.setLong(8, u.getBalance());
				i = ps.executeUpdate();
			}
			}
		catch (Exception e) {
			System.out.println(e);
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return i;
	}
	
	public List<Register> getAllData()
	{
		List<Register> lst=new LinkedList<Register>();
		con=myConnection();
		try
		{
		Statement s=
					con.createStatement
					(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_READ_ONLY);
			rs=s.executeQuery("select * from member1");
			while(rs.next())
			{
				Register u=new Register();
				u.setFname(rs.getString("fname"));
				u.setUname(rs.getString("uname"));
				u.setPassword(rs.getString("password"));
				u.setGender(rs.getString("gender"));
				u.setEmail(rs.getString("email"));
				u.setPhone(rs.getLong("phone"));
				u.setSubject(rs.getString("subject"));
				u.setBalance(rs.getLong("balance"));
				lst.add(u);
				System.out.println("cnt");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return lst;
	}

	public boolean validateData(List<Login> lst) {
		myConnection();
		List<Register> ls=getAllData();
		boolean b=false;
		for(Register u:ls)
		{
			if(lst.get(0).getUname().equals(u.getUname()) && lst.get(0).getPassword().equals(u.getPassword()))
				{
					b=true;
					break;
				}
		}
		return b;
	}
	
	public List<Register> getUser(Register u){
		List<Register> lst = new ArrayList<Register>();
		try {
			con = myConnection();
			ps = con.prepareStatement("select * from member1 where uname=?");
			ps.setString(1, u.getUname());
			rs = ps.executeQuery();
			while(rs.next())
			{
				u.setFname(rs.getString("fname"));
				u.setUname(rs.getString("uname"));
				u.setPassword(rs.getString("password"));
				u.setGender(rs.getString("gender"));
				u.setEmail(rs.getString("email"));
				u.setPhone(rs.getLong("phone"));
				u.setSubject(rs.getString("subject"));
				u.setBalance(rs.getLong("balance"));
				lst.add(u);
				System.out.println("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lst;	
	}
}
