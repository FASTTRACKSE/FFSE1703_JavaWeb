package SinhVienAss4.entity;

public class GiangVien {
public String hoTen,email;

public String getHoTen() {
	return hoTen;
}

public void setHoTen(String hoTen) {
	this.hoTen = hoTen;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}
public GiangVien(String hoTen, String email) {
	super();
	this.hoTen = hoTen;
	this.email = email;
}
public String thongTinGiangVien() {
	return hoTen + " - " + email;

}
}
