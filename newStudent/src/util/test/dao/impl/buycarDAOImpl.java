package util.test.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.test.bean.buycar;
import util.test.bean.user;
import util.test.dao.buycarDAO;
import util.test.db.DbConnection;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class buycarDAOImpl implements buycarDAO{
	public void del(buycar buycar){
		Connection con = null;
		String sql = "delete from buycar where buycar_time=?";
		try {
			con = DbConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, buycar.getBuycar_time());
			ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("SQL语句问题"); 
		}
	}
	
	public void jz(buycar buycar){
		Connection con = null;
		ResultSet a= null;
		Date t = new Date();
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//设置显示格式
		String nowTime="";
		nowTime= df.format(t);
		String sql = "select * from buycar where buycar_time=?";
		String sql1 = "insert into userdd values(?,?,?,?,?,?,?)";
		try {
			con = DbConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, buycar.getBuycar_time());
			a=ps.executeQuery();
			a.last();
			String username = a.getString("username");
			String book_id = a.getString("book_id");
			int count = a.getInt("buy_count");
			
			PreparedStatement ps1 = con.prepareStatement(sql1);
			ps1.setString(1, username);
			ps1.setString(2, nowTime);
			ps1.setString(3, book_id);
			ps1.setInt(4, count);
			ps1.setString(5, buycar.getAddress());
			ps1.setString(6, buycar.getRemark());
			ps1.setInt(7, 0);
			ps1.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("SQL语句问题"); 
		}
		
	}
	
	public void add(buycar buycar){
		Connection con = null;
		ResultSet rs = null;
		try{
			String sql1 = "select * from buycar where username='"+buycar.getUsername()+"' and book_id='"+buycar.getBook_id()+"'";
			con = DbConnection.getConnection();
			PreparedStatement ps1 = con.prepareStatement(sql1);
			rs = ps1.executeQuery(sql1);
			if(rs.next()){
				String sql3 = "update buycar set buy_count="+(rs.getInt("buy_count")+Integer.parseInt(buycar.getBuy_count()))+" where username='"+rs.getString("username")+"' and book_id='"+rs.getString("book_id")+"'"; 
				PreparedStatement ps3 = con.prepareStatement(sql3);
				ps3.executeUpdate(sql3);
			}
			else{
				Date t = new Date();
				DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//设置显示格式
				String nowTime="";
				nowTime= df.format(t);
				String sql2 = "insert into buycar values('"+nowTime+"','"+buycar.getUsername()+"','"+buycar.getBook_id()+"',"+buycar.getBuy_count()+")";
				PreparedStatement ps2 = con.prepareStatement(sql2);
				ps2.executeUpdate(sql2);
			}
		}
		catch (SQLException e){
			e.printStackTrace();
			System.err.println("SQL语句问题"); 
		}
	}
	
	public void fh(buycar buycar){
		Connection con = null;
		try{
			String sql = "update book set book_count=book_count-"+buycar.getBuy_count()+" where book_id='"+buycar.getBook_id()+"'";
			String sql1 = "update userdd set result=1 where username='"+buycar.getUsername()+"' and book_id='"+buycar.getBook_id()+"'";
			con = DbConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			PreparedStatement ps1 = con.prepareStatement(sql1);
			ps.executeUpdate(sql);
			ps1.executeUpdate(sql1);
		}
		catch (SQLException e){
			e.printStackTrace();
			System.err.println("SQL语句问题"); 
		}
	}
	
	public void sh(buycar buycar){
		Connection con = null;
		try{
			String sql1 = "update userdd set result=2 where username='"+buycar.getUsername()+"' and book_id='"+buycar.getBook_id()+"'";
			con = DbConnection.getConnection();
			PreparedStatement ps1 = con.prepareStatement(sql1);
			ps1.executeUpdate(sql1);
		}
		catch (SQLException e){
			e.printStackTrace();
			System.err.println("SQL语句问题"); 
		}
	}
	
	public void del1(buycar buycar){
		Connection con = null;
		String sql = "delete from book where book_id=?";
		try {
			con = DbConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, buycar.getBook_id());
			ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("SQL语句问题"); 
		}
	}
	
	public void tj1(buycar buycar){
		Connection con = null;
		ResultSet a= null;
		String sql = "insert into book values(?,?,?,?,?,?,?,?)";
		try {
			con = DbConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, buycar.getBook_id());
			ps.setString(2, buycar.getBookname());
			ps.setString(3, buycar.getAuthor());
			ps.setString(4, buycar.getKind());
			ps.setString(5, buycar.getPrice());
			ps.setString(6, buycar.getBook_time());
			ps.setInt(7, buycar.getBook_count());
			ps.setString(8, buycar.getIntroduction());
			ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("SQL语句问题"); 
		}
	}
	
	public String ss(buycar buycar) {
		Connection con = null;
		ResultSet a= null;
		String c="0";
		String sql = "select * from book where bookname=? ";	
		try {
			con = DbConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, buycar.getBookname());
			a=ps.executeQuery();
			while (a.next()){
				c = a.getString("book_id");
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("查询身份语句问题"); 
		}
		return c;
	}
	
}
