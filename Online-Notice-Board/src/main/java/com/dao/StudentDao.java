package com.dao;
import java.util.*;

import com.beans.Admin;
import com.beans.Student;


import java.sql.*;

public class StudentDao {

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

	public static int save(Student e) {
		int status = 0;
		try {
			Connection con = StudentDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("insert into table1(name,email,password,mobile,city) values (?,?,?,?,?)");

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

	public static List<Student> getAllStudents() {
		List<Student> list = new ArrayList<Student>();

		try {
			Connection con = StudentDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from table1");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Student e = new Student();
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


	public  Student checkLogin(String email, String password) throws SQLException, ClassNotFoundException {
		String jdbcURL = "jdbc:mysql://localhost:3306/data1";
		String dbUser = "root";
		String dbPassword = "Mysql";

		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
		String sql = "SELECT * FROM table1 WHERE email = ? and password = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, email);
        statement.setString(2, password);
 
        ResultSet result = statement.executeQuery();
 
        Student user = null;
 
        if (result.next()) {
            user = new Student();
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
			Connection con=StudentDao.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from table1 where id=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public static Student getstudById(int id) {
		Student stud=new Student();
		try {
			Connection con=StudentDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from table1 where id=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if (rs.next()) {
				stud.setId(rs.getInt("id"));
				stud.setName(rs.getString("name"));
				stud.setEmail(rs.getString("email"));
				stud.setPassword(rs.getString("password"));
				stud.setMobile(rs.getString("mobile"));
				stud.setCity(rs.getString("city"));
				
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stud;
	}

	
	public static int UpdateStudent(Student stud)
	{
		int status=0;
		try {
			Connection con=StudentDao.getConnection();
			PreparedStatement ps=con.prepareStatement("update table1 set name=?,email=?,password=?,mobile=?,city=?  where id=?");
			ps.setString(1,stud.getName());
			ps.setString(2,stud.getEmail());
			ps.setString(3,stud.getPassword());
			ps.setString(4,stud.getMobile());
			ps.setString(5,stud.getCity());
			ps.setInt(6,stud.getId());
			status=ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}