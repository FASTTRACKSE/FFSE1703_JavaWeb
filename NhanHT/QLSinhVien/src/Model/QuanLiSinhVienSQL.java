package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class QuanLiSinhVienSQL {
	static ArrayList<QuanLiSinhVienModel> arrQlSinhVien = new ArrayList<>();
	final static Connection conn = GetConnectDB.getConnect("localhost", "admin", "admin123", "123456");

	public static ArrayList<QuanLiSinhVienModel> selectAll(int start, int soLuongHienThi) {
		arrQlSinhVien.clear();
		try {
			Statement statement = conn.createStatement();
			ResultSet result = statement
					.executeQuery("select * from QLSinhVien LIMIT " + start + ", " + soLuongHienThi + "");
			while (result.next()) {
				int id = result.getInt("id");
				String hoDem = result.getString("HoDem");
				String tenSv = result.getString("Ten");
				String ngaySinh = result.getString("NgaySinh");
				String queQuan = result.getString("QueQuan");
				String gioiTinh = result.getString("GioiTinh");
				String lopSv = result.getString("Lop");
				double lp0 = result.getDouble("LP0");
				double lp1 = result.getDouble("LP1");

				QuanLiSinhVienModel quanLiSinhVienModel = new QuanLiSinhVienModel(id, hoDem, tenSv, ngaySinh, queQuan,
						gioiTinh, lopSv, lp0, lp1);
				arrQlSinhVien.add(quanLiSinhVienModel);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return arrQlSinhVien;
	}

	public static boolean insert(QuanLiSinhVienModel sinhVien) throws SQLException {
		String sql = "INSERT INTO QLSinhVien (id, HoDem, Ten, NgaySinh, QueQuan, GioiTinh, Lop,LP0,LP1) VALUES ( ?, ?, ?, ?,?,?,?,?,?)";

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, sinhVien.getId());
		statement.setString(2, sinhVien.getHoDem());
		statement.setString(3, sinhVien.getTen());
		statement.setString(4, sinhVien.getNgaySinh());
		statement.setString(5, sinhVien.getQueQuan());
		statement.setString(6, sinhVien.getGioiTinh());
		statement.setString(7, sinhVien.getLop());
		statement.setDouble(8, sinhVien.getLp0());
		statement.setDouble(9, sinhVien.getLp1());

		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		return rowInserted;
	}

	public static boolean delete(QuanLiSinhVienModel delete) throws SQLException {
		String sql = "DELETE FROM QLSinhVien where id = ?";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, delete.getId());

		boolean rowDeleted = statement.executeUpdate() > 0;
		statement.close();
		return rowDeleted;
	}

	public static boolean update(QuanLiSinhVienModel update) throws SQLException {
		String sql = "UPDATE QLSinhVien SET HoDem = ?, Ten = ?,NgaySinh = ?,QueQuan = ?, GioiTinh = ?,Lop = ?,LP0 = ?,LP1 = ?";
		sql += " WHERE id = ?";

		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, update.getHoDem());
		statement.setString(2, update.getTen());
		statement.setString(3, update.getNgaySinh());
		statement.setString(4, update.getQueQuan());
		statement.setString(5, update.getGioiTinh());
		statement.setString(6, update.getLop());
		statement.setDouble(7, update.getLp0());
		statement.setDouble(8, update.getLp1());
		statement.setInt(9, update.getId());

		boolean rowUpdated = statement.executeUpdate() > 0;
		statement.close();
		return rowUpdated;
	}

	public static QuanLiSinhVienModel getSinhVien(int idSv) throws SQLException {
		QuanLiSinhVienModel sv = null;
		String sql = "SELECT * FROM QLSinhVien WHERE id = ?";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, idSv);
		ResultSet resultSet = statement.executeQuery();

		if (resultSet.next()) {
			int id = resultSet.getInt("id");
			String hoDem = resultSet.getString("HoDem");
			String tenSv = resultSet.getString("Ten");
			String ngaySinh = resultSet.getString("NgaySinh");
			String queQuan = resultSet.getString("QueQuan");
			String gioiTinh = resultSet.getString("GioiTinh");
			String lopSv = resultSet.getString("Lop");
			double lp0 = resultSet.getDouble("LP0");
			double lp1 = resultSet.getDouble("LP1");

			sv = new QuanLiSinhVienModel(id, hoDem, tenSv, ngaySinh, queQuan, gioiTinh, lopSv, lp0, lp1);
		}

		resultSet.close();
		statement.close();

		return sv;
	}

	public static double countSv() throws SQLException {
		double total = 0;
		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery("SELECT COUNT(*) FROM QLSinhVien");
		while (result.next()) {
			total = result.getDouble("COUNT(*)");
		}
		return total;

	}
}
