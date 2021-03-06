package student.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StudentDb {
	static ConnectDb myDB = new ConnectDb();
	private static Connection conn= myDB.getConnect("localhost", "student", "hainam", "123456");
	public static int addStudent(Student std) {
		try {
			String sql = "insert into studentlist (code, fullname, class, lp1,"
					+ "lp2,image) "
					+ " values (?, ?, ?, ?, ?,?)";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setString(1, std.getCode());
			stm.setString(2, std.getFullname());
			stm.setString(3, std.getClassStudent());
			stm.setFloat(4, std.getLp1());
			stm.setFloat(5, std.getLp2());	
			stm.setString(6, std.getImage());
			int i = stm.executeUpdate();						
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public static ArrayList<Student> getStudentList() {
		ArrayList<Student> arrStd = new ArrayList<>();
		try {
			String sql = "SELECT * " + 
					"FROM studentlist ORDER by id DESC "; 
			Statement stm = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				Student std = new Student();
				std.setCode(rs.getString("code"));
				std.setFullname(rs.getString("fullname"));
				std.setClassStudent(rs.getString("class"));
				std.setLp1(rs.getFloat("lp1"));
				std.setLp2(rs.getFloat("lp2"));	
				std.setImage(rs.getString("image"));
				arrStd.add(std);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrStd;
	}
	
	public static ArrayList<Student> searchCode(String code) {
		ArrayList<Student> arrStd = new ArrayList<>();
		try {
			String sql = "SELECT * FROM studentlist WHERE code = ? ORDER BY id DESC ";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setString(1, code);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Student std = new Student();
				std.setCode(rs.getString("code"));
				std.setFullname(rs.getString("fullname"));
				std.setClassStudent(rs.getString("class"));
				std.setLp1(rs.getFloat("lp1"));
				std.setLp2(rs.getFloat("lp2"));	
				std.setImage(rs.getString("image"));
				arrStd.add(std);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrStd;
	}
	
	public static int updateStudent(Student std) {
		try {
			String sql = "update studentlist set fullname = ?, class = ?, lp1 = ?, "
					+ "lp2 = ? where code = ?";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setString(1, std.getFullname());
			stm.setString(2, std.getClassStudent());
			stm.setFloat(3, std.getLp1());
			stm.setFloat(4, std.getLp2());	
			stm.setString(5, std.getCode());	
			return stm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public static int delStudent(String code) {
		try {
			String sql = "DELETE FROM studentlist where code = ?";
			PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sql);
			stm.setString(1, code);				
			return stm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public static int countStudent() {
		int count=-1;
		try {
			String sql = "SELECT COUNT(*) AS total FROM studentlist"; 
			Statement stm = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				count=rs.getInt("total");
			}
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public static ArrayList<Student> getStudentList(int id) {
		ArrayList<Student> arrStd = new ArrayList<>();
		try {
			String sql = "SELECT * " + 
					"FROM studentlist ORDER by id DESC limit "+(id-1)*3+",3 "; 
			Statement stm = (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				Student std = new Student();
				std.setCode(rs.getString("code"));
				std.setFullname(rs.getString("fullname"));
				std.setClassStudent(rs.getString("class"));
				std.setLp1(rs.getFloat("lp1"));
				std.setLp2(rs.getFloat("lp2"));					
				arrStd.add(std);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arrStd;
	}
	
	
}
