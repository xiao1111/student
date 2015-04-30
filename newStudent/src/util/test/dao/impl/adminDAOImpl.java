package util.test.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.test.bean.news;
import util.test.dao.adminDAO;
import util.test.db.DbConnection;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class adminDAOImpl implements adminDAO{

	public void fbxw(news news){
		Date t = new Date();
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//������ʾ��ʽ
		String nowTime="";
		nowTime= df.format(t);
		Connection con = null;
		String sql = "insert into information values(?,?,?)";
		try {
			con = DbConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, news.getTitle());
			ps.setString(2, news.getContent());
			ps.setString(3, nowTime);
			ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("SQL�������,��������ʧ�ܣ�"); 
		}
	}
	
}
