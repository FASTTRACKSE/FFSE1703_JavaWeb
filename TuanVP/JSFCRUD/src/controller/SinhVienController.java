package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import bean.*;
import dao.*;

@ManagedBean(name = "studentController")
@SessionScoped
public class SinhVienController {
	private String admin;
	private int pageCurrent, pageTotal, pageLimit, pageStart;
	private ArrayList<SinhVienBean> listSinhVien;
	private Locale locale;
	private SinhVienDAO studentDAO = new SinhVienDAO();

	public SinhVienController() throws SQLException, IOException {
		listSinhVien = new ArrayList<SinhVienBean>();
		this.pageCurrent = 1;
		this.pageTotal = 1;
		this.pageStart = 1;
		this.pageLimit = 3;
		this.locale = new Locale("vi");
		loadStudent();
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public void changeLanguage(String language) {
		locale = new Locale(language);
		FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
	}

	public void countStudent() throws SQLException {
		int totalStudent = studentDAO.rowCount();
		pageTotal = (int) Math.ceil( (double) totalStudent / (double) pageLimit);
		if (pageCurrent > pageTotal) {
			pageCurrent = pageTotal;
		}
	}

	public void firstPage() throws SQLException {
		pageCurrent = 1;
		loadStudent();
	}

	public void prevPage() throws SQLException {
		if (pageCurrent > 1) {
			pageCurrent -= 1;
		}
		loadStudent();
	}

	public void nextPage() throws SQLException {
		if (pageCurrent < pageTotal) {
			pageCurrent += 1;
		}
		loadStudent();
	}

	public void lastPage() throws SQLException {
		pageCurrent = pageTotal;
		loadStudent();
	}

	public void goToPage(int page) throws SQLException {
		if (page < 1) {
			pageCurrent = 1;
		} else if (page > pageTotal) {
			pageCurrent = pageTotal;
		} else {
			pageCurrent = page;
		}
		loadStudent();
	}

	public int getPageCurrent() {
		return pageCurrent;
	}

	public void setPageCurrent(int pageCurrent) {
		this.pageCurrent = pageCurrent;
	}

	public int getPageTotal() {
		return pageTotal;
	}

	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}

	public int getPageLimit() {
		return pageLimit;
	}

	public void setPageLimit(int pageLimit) {
		this.pageLimit = pageLimit;
	}

	public int getPageStart() {
		return pageStart;
	}

	public void setPageStart(int pageStart) {
		this.pageStart = pageStart;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public void loadStudent() throws SQLException {
		listSinhVien.clear();
		countStudent();
		pageStart = (pageCurrent - 1) * pageLimit;
		listSinhVien = studentDAO.listSinhVien(pageStart, pageLimit);
	}

	public ArrayList<SinhVienBean> getListSinhVien() {
		return listSinhVien;
	}

	public void setListSinhVien(ArrayList<SinhVienBean> listSinhVien) {
		this.listSinhVien = listSinhVien;
	}

	public String adminLogin(AdminBean adBean) {
		String page = "";
		if (adBean.getAdmin().equals("admin") && adBean.getPassword().equals("123456")) {
			admin = adBean.getAdmin();
			page = "index.xhtml?faces-redirect=true";
		}
		return page;

	}

	public String logout() {
		admin = null;
		return "login.xhtml?faces-redirect=true";
	}

	public String insertSinhVien(SinhVienBean sv) throws SQLException {
		studentDAO.insertSinhVien(sv);
		countStudent();
		pageCurrent = pageTotal;
		loadStudent();
		return "index.xhtml?faces-redirect=true";
	}

	public String editSinhVien(int id) throws SQLException {
		Map<String, Object> sessionObj = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		SinhVienBean sv = new SinhVienBean(id);
		SinhVienBean extSV = studentDAO.getSinhVien(sv);
		sessionObj.put("extSV", extSV);
		return "FormUpdate.xhtml?faces-redirect=true";
	}

	public String updateSinhVien(SinhVienBean sv) throws SQLException {
		studentDAO.updateSinhVien(sv);
		loadStudent();
		return "index.xhtml?faces-redirect=true";
	}

	public void deleteSinhVien(int id) throws SQLException {
		studentDAO.deleteSinhVien(id);
		loadStudent();
	}

	public void validateEmail(FacesContext fc, UIComponent uc, Object value) throws ValidatorException {
		Pattern pt = Pattern.compile("[\\w\\.-]*[a-zA-Z0-9_]@[\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]");
		Matcher mc = pt.matcher(value.toString());
		if (!mc.matches()) {
			FacesMessage msg = new FacesMessage("Vui lòng nhập đúng định dạng email!!~_~");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}

	}

	public void validatePhone(FacesContext fc, UIComponent uc, Object value) throws ValidatorException {
		Pattern pt = Pattern.compile("(\\+84|0084|0)[0-9]{9,10}");
		Matcher mc = pt.matcher(value.toString());
		if (!mc.matches()) {
			FacesMessage msg = new FacesMessage("Số điện thoại phải có từ 10 đến 11 số!!~_~");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}

	}

}
