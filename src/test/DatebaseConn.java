/**   
 * @Title: DatebaseConn.java 
 * @Package test 
 * @Description: TODO
 * @author wk 
 * @date Sep 14, 2017 11:02:34 AM 
 * @version V1.0   
 */
package test;

/**
 * @className:DatebaseConn.java
 * @author: wk
 * @date Sep 14, 2017 11:02:34 AM
 * @version:v1.0
 * @description:TODO
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.PreparedStatement;

public class DatebaseConn {

	public Connection ConnectionBuiler() {
		// 声明Connection对象
		Connection con;
		// 驱动程序名
		String driver = "com.mysql.jdbc.Driver";
		// URL指向要访问的数据库名mydata
		String url = "jdbc:mysql://192.168.0.107:3306/aizupai";
		// MySQL配置时的用户名
		String user = "root";
		// MySQL配置时的密码
		String password = "123456";
		// 遍历查询结果集
		try {
			// 加载驱动程序
			Class.forName(driver);
			// 1.getConnection()方法，连接MySQL数据库！！
			con = DriverManager.getConnection(url, user, password);
			if (!con.isClosed()) {
				System.out.println("Succeeded connecting to the Database!");
			}
			/*con.close();*/
			return con;
		} catch (ClassNotFoundException e) {
			// 数据库驱动类异常处理
			System.out.println("Sorry,can`t find the Driver!");
			e.printStackTrace();
		} catch (SQLException e) {
			// 数据库连接失败异常处理
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Map<String, Object> BuilMap(Map<String, Object> root) {
		DatebaseConn c = new DatebaseConn();
		Connection conn = c.ConnectionBuiler();
		String sql = "select * from zzzz";
		PreparedStatement stmt;
		try {
			stmt = (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			ResultSetMetaData data = rs.getMetaData();
			List<HashMap<String, Object>> attr_list = new ArrayList<HashMap<String, Object>>();   
			for (int i = 1; i <= data.getColumnCount(); i++) {	
				// 获得指定列的列名
				String columnName = data.getColumnName(i);
				// 对应数据类型的类
				String columnClassName = data.getColumnClassName(i);	
				System.out.println("获得列" + i + "的字段名称:" + columnName);
				System.out.println("获得列" + i + "对应数据类型的类:" + columnClassName);
				HashMap<String, Object> temp=new HashMap<String, Object>();
				temp.put("name", columnName);
				temp.put("typeClass", columnClassName);
		        String[] type = columnClassName.split("\\.");
		        temp.put("type", type[type.length-1]);
		        attr_list.add(temp);
		       
		        
			}
			 root.put("cols", attr_list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return root;
	}

}