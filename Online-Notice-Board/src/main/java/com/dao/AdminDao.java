package com.dao;
import java.util.*;

import com.beans.Admin;
import com.beans.Student;

import java.sql.*;

public class AdminDao {

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/data1", "root", "Mysql");

		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

	public static int save(Admin e) {
		int status = 0;
		try {
			Connection con = AdminDao.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into table2(name,email,password,mobile,city) values (?,?,?,?,?)");

			ps.setString(1, e.getName());
			ps.setString(2, e.getEmail());
			ps.setString(3, e.getPassword());
			ps.setString(4, e.getMobile());
			ps.setString(5, e.getCity());
			status = ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return status;

	}

	public static List<Admin> getAllAdmins() {
		List<Admin> list = new ArrayList<Admin>();

		try {
			Connection con = StudentDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from table2");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Admin e = new Admin();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setEmail(rs.getString(3));
				e.setPassword(rs.getString(4));
				e.setMobile(rs.getString(5));
				e.setCity(rs.getString(6));
			
				list.add(e);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public  Admin checkLogin1(String email, String password) throws SQLException, ClassNotFoundException {
		String jdbcURL = "jdbc:mysql://localhost:3306/data1";
		String dbUser = "root";
		String dbPassword = "Mysql";

		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
		String sql = "SELECT * FROM table2 WHERE email = ? and password = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, email);
        statement.setString(2, password);
 
        ResultSet result = statement.executeQuery();
 
        Admin user = null;
 
        if (result.next()) {
            user = new Admin();
            user.setName(result.getString("name"));
            user.setEmail(email);
        }
 
        connection.close();
 
        return user;
    }


	public static int deleteUser(int id)
	{
		int status=0;
		try {
			Connection con=AdminDao.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from table2 where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}


}