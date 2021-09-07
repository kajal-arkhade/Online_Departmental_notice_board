package com.dao;
import java.util.*;

import com.beans.Notice;


import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

public class NoticeDao {

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

	public static int save(Notice e) {
		int status = 0;
		try {
			Connection con = NoticeDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("insert into table3(date,subject,notice) values (?,?,?)");

			ps.setString(1, e.getDate());
			ps.setString(2, e.getSubject());
			ps.setString(3, e.getNotice());
			status = ps.executeUpdate();

			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return status;

	}

	public static List<Notice> getAllNotices() {
		List<Notice> list = new ArrayList<Notice>();

		try {
			Connection con = StudentDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from table3");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Notice e = new Notice();
				e.setId(rs.getInt(1));
				e.setDate(rs.getString(2));
				e.setSubject(rs.getString(3));
				e.setNotice(rs.getString(4));
				
				list.add(e);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}