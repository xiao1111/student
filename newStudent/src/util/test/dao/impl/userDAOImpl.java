package util.test.dao.impl;

import java.sql.*;
import util.test.bean.user;
import util.test.dao.userDAO;
import util.test.db.DbConnection;

public class userDAOImpl implements userDAO {

	@Override
	public String yz1(user user) {
		Connection con = null;
		ResultSet a= null;
		String c="0";
		String sql = "select * from user where username=? and password=?";	
		try {
			con = DbConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			a=ps.executeQuery();
			while (a.next()){
				c = a.getString(1);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("查询身份语句问题"); 
		}
		return c;
	}
	

	@Override
	public int yz2(user user) {
		Connection con = null;
		ResultSet a= null;
		int c = 0;
		String sql = "select * from user where username=?";
		try
		{
			con = DbConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getUsername1());
			a=ps.executeQuery();
			if (a.next()){
				c = 1;
			}
			else if(!user.getPassword1().equals(user.getPassword2())){
			}
			else{
				String sql1 = "insert into user values(?,?,?,?,?)";
				PreparedStatement ps1 = con.prepareStatement(sql1);
				ps1.setString(1, user.getUsername1());
				ps1.setString(2, user.getPassword1());
				ps1.setString(3, user.getMail());
				ps1.setString(4, user.getMmq());
				ps1.setString(5, user.getMma());
				ps1.executeUpdate();
			}
			con.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
			System.err.println("数据库语句问题"); 
		}
		return c;
	}
	
	
	@Override
	public int yz3(user user) {
		Connection con = null;
		ResultSet a= null,b = null;
		int c = -1;
		String sql = "select * from user where username=?";
		try
		{
			con = DbConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			a=ps.executeQuery();
			if (!a.next()){
				c = 0;
			}
			else{
				String sql1 = "select mmq,mma from user where username=?";
				PreparedStatement ps1 = con.prepareStatement(sql1);
				ps1.setString(1, user.getUsername());
				b=ps1.executeQuery();
				b.next();
				if(user.getMmq().equals(b.getString("mmq"))&&user.getMma().equals(b.getString("mma"))){c = 2;}
				else{c = 1;}
			}
			con.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
			System.err.println("数据库语句问题"); 
		}
		return c;
	}
	
	
	@Override
	public void yz4(user user) {
		Connection con = null;
		ResultSet a= null;
		String c="0";
		String sql = "update user set password=? where username=?";	
		try {
			con = DbConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getPassword1());
			ps.setString(2, user.getUsername());
			ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("数据库语句问题"); 
		}
	}
	
	public void xm1(user user) {
		Connection con = null;
		ResultSet a= null;
		String c="0";
		String sql = "update user set password=? where username=?";	
		try {
			con = DbConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getPassword());
			ps.setString(2, user.getUsername());
			ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("数据库语句问题"); 
		}
	}
	
	public void addmessage(user user) {
		Connection con = null;
		try {		
				String sql = "insert into message values(?,?)";
				con = DbConnection.getConnection();
				PreparedStatement ps1 = con.prepareStatement(sql);
				ps1.setString(1, user.getMessage());
				ps1.setString(2, user.getTime());
				ps1.executeUpdate();
				con.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
			System.err.println("数据库语句问题"); 
		}
	}
}
