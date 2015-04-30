package util.test.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

public class DbConnection {
    private static BasicDataSource dataSource = null;
    /**
     * ��ʼ�����ݿ����ӳ�
     */
    public static void init() 
    {
    	if (dataSource != null)
        {
            try
            {
                dataSource.close();
            } catch (Exception e)
            {
                e.printStackTrace();
            }
            dataSource = null;
        }
        //ʹ��Properties���������ݿ����ӳ���Ϣ
        try {
            Properties p = new Properties();
            p.setProperty("driverClassName", "com.mysql.jdbc.Driver");
            p.setProperty("url", "jdbc:mysql://localhost:3306/zhinan?useUnicode=true&characterEncoding=UTF-8");
            p.setProperty("username", "root");
            p.setProperty("password", "123");
            p.setProperty("maxActive", "30");
            p.setProperty("maxIdle", "10");
            p.setProperty("maxWait", "1000");
           //��ָ����Ϣ��������Դ
            dataSource = (BasicDataSource) BasicDataSourceFactory.createDataSource(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * �����ӳ��л�ȡ����
     * @return
     * @throws SQLException
     */
    public static synchronized Connection getConnection() throws  SQLException {
        if (dataSource == null) {
            init();
        }
        Connection conn = null;
        if (dataSource != null) {
            conn = dataSource.getConnection();
        }
        return conn;
    }
}
