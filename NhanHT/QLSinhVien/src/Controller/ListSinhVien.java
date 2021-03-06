package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.QuanLiSinhVienModel;
import Model.QuanLiSinhVienSQL;

/**
 * Servlet implementation class ListSinhVien
 */
@WebServlet("/ListSinhVien/*")
public class ListSinhVien extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListSinhVien() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getPathInfo();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insert(request, response);
				break;
			case "/delete":
				delete(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				update(request, response);
				break;
			default:
				listSv(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listSv(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		ArrayList<QuanLiSinhVienModel> arrQLSinhVien = new ArrayList<>();
		// Phân trang
		int page = 1;
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		int start = (page - 1) * 4;
		int soLuongHienThi = 4;
		arrQLSinhVien = QuanLiSinhVienSQL.selectAll(start, soLuongHienThi);
		double countSv = QuanLiSinhVienSQL.countSv();
		double soTrang = countSv / soLuongHienThi;
		// đa ngôn ngữ
		String lang = request.getParameter("lang");
		if (request.getParameter("lang") == null) {
			lang = "Resource_vi_VN";
		}

		request.setAttribute("total", soTrang);
		request.setAttribute("listSv", arrQLSinhVien);
		request.setAttribute("lang", lang);
		

		RequestDispatcher dispatcher = request.getRequestDispatcher("/QuanLiSinhVien.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// đa ngôn ngữ
		String lang = request.getParameter("lang");
		if (request.getParameter("lang") == null) {
			lang = "Resource_vi_VN";
		}
		request.setAttribute("lang", lang);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/insert.jsp");
		dispatcher.forward(request, response);
	}

	private void insert(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String hoDem = request.getParameter("HoDem");
		String tenSv = request.getParameter("TenSv");
		String ngaySinh = request.getParameter("NgaySinh");
		String queQuan = request.getParameter("QueQuan");
		String gioiTinh = request.getParameter("GioiTinh");
		String lop = request.getParameter("Lop");
		double lp0 = Double.parseDouble(request.getParameter("LP0"));
		double lp1 = Double.parseDouble(request.getParameter("LP1"));

		QuanLiSinhVienModel sinhVien = new QuanLiSinhVienModel(id, hoDem, tenSv, ngaySinh, queQuan, gioiTinh, lop, lp0,
				lp1);
		QuanLiSinhVienSQL.insert(sinhVien);
		response.sendRedirect("list");
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		QuanLiSinhVienModel delete = new QuanLiSinhVienModel(id);
		QuanLiSinhVienSQL.delete(delete);
		response.sendRedirect("list");
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		// đa ngôn ngữ
		String lang = request.getParameter("lang");
		if (request.getParameter("lang") == null) {
			lang = "Resource_vi_VN";
		}

		int id = Integer.parseInt(request.getParameter("id"));
		QuanLiSinhVienModel existing = QuanLiSinhVienSQL.getSinhVien(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/update.jsp");

		request.setAttribute("sinhVien", existing);
		request.setAttribute("lang", lang);
		dispatcher.forward(request, response);
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String hoDem = request.getParameter("HoDem");
		String tenSv = request.getParameter("TenSv");
		String ngaySinh = request.getParameter("NgaySinh");
		String queQuan = request.getParameter("QueQuan");
		String gioiTinh = request.getParameter("GioiTinh");
		String lop = request.getParameter("Lop");
		double lp0 = Double.parseDouble(request.getParameter("LP0"));
		double lp1 = Double.parseDouble(request.getParameter("LP1"));

		QuanLiSinhVienModel update = new QuanLiSinhVienModel(id, hoDem, tenSv, ngaySinh, queQuan, gioiTinh, lop, lp0,
				lp1);
		QuanLiSinhVienSQL.update(update);
		response.sendRedirect("list");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
