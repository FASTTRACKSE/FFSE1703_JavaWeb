package com.jsf.crud;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.jsf.crud.db.operation.DatabaseOperation;

import pagination.Pagination;

@ManagedBean @RequestScoped
public class StudentBean {

	private int id;  
	private String name;  
	private String email;  
	private String lop;  
	private String date;  
	private String phone;
	private String gender;  
	private String address;

	public ArrayList studentsListFromDB;

	public int getId() {
		return id;	
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
	public String getLop() {
		return lop;
	}

	public void setLop(String lop) {
		this.lop = lop;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	@ManagedProperty(value = "#{data}")
	private DatabaseOperation studentDao;

	@ManagedProperty(value = "#{pagination}")
	private Pagination pagination;

	@PostConstruct
	public void init() {
		try {
			int countRecords = studentDao.count();
			pagination.setStudentList(countRecords);
			setStudentList();
		} catch (Exception e) {

		}
		// studentsListFromDB = DatabaseOperation.getStudentsListFromDB();
	}

	public ArrayList<StudentBean> getStudentsListFromDB() {
		return studentsListFromDB;
	}

	public DatabaseOperation getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(DatabaseOperation studentDao) {
		this.studentDao = studentDao;
	}

	public void next() {
		pagination.next();
		setStudentList();
	}

	public void prev() {
		pagination.prev();
		setStudentList();
	}

	public void firstPage() {
		pagination.firstPage();
		setStudentList();
	}

	public void lastPage() {
		pagination.lastPage();
		setStudentList();
	}

	public void setStudentList() {
		this.studentsListFromDB = studentDao.getRecords(pagination.getFromIndex(), pagination.getRecords());
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public ArrayList studentsList() {
		return studentsListFromDB;
	}
	
	public String saveStudentDetails(StudentBean newStudentObj) {
		return DatabaseOperation.saveStudentDetailsInDB(newStudentObj);
	}
	
	public String editStudentRecord(int studentId) {
		return DatabaseOperation.editStudentRecordInDB(studentId);
	}
	
	public String updateStudentDetails(StudentBean updateStudentObj) {
		return DatabaseOperation.updateStudentDetailsInDB(updateStudentObj);
	}
	
	public String deleteStudentRecord(int studentId) {
		return DatabaseOperation.deleteStudentRecordInDB(studentId);
	}
}