package fasttrackse.ffse1703.fbms.entity.quanlynhansutt;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;

@Entity
@Table(name = "thanh_pho")
public class TinhThanhPhoTT implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ma_thanh_pho", unique = true, nullable = false, length = 30)
	@NotEmpty
	private String maThanhPho;

	@Column(name = "ten_thanh_pho", nullable = false, length = 255)
	@NotEmpty
	private String tenThanhPho;

	// bi-directional many-to-one association to HoSoNhanVien
	@OneToMany(mappedBy = "thanhPho")
	private List<HoSoNhanVien> hoSoNhanViens;

	public TinhThanhPhoTT() {
	}

	public String getMaThanhPho() {
		return maThanhPho;
	}

	public void setMaThanhPho(String maThanhPho) {
		this.maThanhPho = maThanhPho;
	}

	public String getTenThanhPho() {
		return tenThanhPho;
	}

	public void setTenThanhPho(String tenThanhPho) {
		this.tenThanhPho = tenThanhPho;
	}

	public List<HoSoNhanVien> getHoSoNhanViens() {
		return hoSoNhanViens;
	}

	public void setHoSoNhanViens(List<HoSoNhanVien> hoSoNhanViens) {
		this.hoSoNhanViens = hoSoNhanViens;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
