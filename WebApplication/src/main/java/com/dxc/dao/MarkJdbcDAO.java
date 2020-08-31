package com.dxc.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dxc.beans.Mark;
import com.dxc.util.ConnectionManager;

public class MarkJdbcDAO extends JdbcDAO implements DAO<Mark> {

	public MarkJdbcDAO() throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean save(Mark e) throws Exception {
		boolean res = false;
		PreparedStatement pstmt = con.prepareStatement("INSERT INTO mark VALUES(?,?,?,?,?)");
		pstmt.setInt(1, e.getId());
		pstmt.setString(2, e.getName());
		pstmt.setInt(3, e.getSub1());
		pstmt.setInt(4, e.getSub2());
		pstmt.setInt(5, e.getSub3());
		pstmt.setInt(6, e.getTotal());
		
		if(1== pstmt.executeUpdate()) {
			res = true;
		}
		
		return res;
	}

	@Override
	public boolean edit(Mark e) throws Exception {
    boolean res = false;
		PreparedStatement pstmt = con.prepareStatement("UPDATE mark SET name=?, sub1=?,sub2=?,sub3=?,total=? WHERE id = ?");
		pstmt.setString(1, e.getName());
		pstmt.setInt(3, e.getSub1());
		pstmt.setInt(4, e.getSub2());
		pstmt.setInt(5, e.getSub3());
		pstmt.setInt(6, e.getTotal());	
		pstmt.setInt(4, e.getId());
		
		if(1 == pstmt.executeUpdate()) {
			res = true;
		}
		
		return res;
	}

	@Override
	public boolean delete(int id) throws Exception {
    boolean res = false;
		
		PreparedStatement pstmt = con.prepareStatement("DELETE FROM mark WHERE id = ?");
		pstmt.setInt(1, id);
		if(1== pstmt.executeUpdate()) {
			res = true;
		}
		
		return res;
	}

	@Override
	public Mark find(int id) throws Exception {
    Mark mark = null;
		
		try {
			Connection con = ConnectionManager.getConnection();
			con.commit();
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM mark WHERE id = ?");
			
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				String name = rs.getString(2);
				int sub1 = rs.getInt(3);
				int sub2 = rs.getInt(4);
				int sub3 = rs.getInt(5);
				int total = rs.getInt(6);
			
				mark = new Mark(id, name,sub1,sub2,sub3,total);
			}
		}
		finally {
			con.close();
		}
		
		return mark;
	}

	@Override
	public List<Mark> findAll() throws Exception {
		ArrayList<Mark> marks = new ArrayList<>();
		try {
			Connection con = ConnectionManager.getConnection();
			con.commit();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM mark");
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int sub1 = rs.getInt("sub1");
				int sub2 = rs.getInt("sub2");
				int sub3 = rs.getInt("sub3");
				int total = rs.getInt("total");
				
				Mark mark = new Mark(id, name, sub1,sub2,sub3,total);
				marks.add(mark);
			}
		}
		finally {
			con.close();
		}
		
		
		return marks;
	}

}
