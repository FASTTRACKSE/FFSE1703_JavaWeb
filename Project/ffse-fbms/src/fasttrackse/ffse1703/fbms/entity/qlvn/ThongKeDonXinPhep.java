package fasttrackse.ffse1703.fbms.entity.qlvn;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;

@Entity
@Table(name = "thong_ke_don_xin_phep")
public class ThongKeDonXinPhep implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

//	@ManyToMany(targetEntity = HoSoNhanVien.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinTable(name = "ngay_nghi", inverseJoinColumns = { @JoinColumn(name = "ma_nhan_vien", 
//	referencedColumnName = "ma_nhan_vien", nullable = true, updatable = true,insertable=true) })
//	private HoSoNhanVien maNhanVien;
	
	@ManyToOne
	@JoinColumn(name = "ma_nhan_vien")
	private HoSoNhanVien maNhanVien;

	@Column(name = "ngay_bat_dau")
	private Date ngayBatDau;

	@Column(name = "ngay_ket_thuc")
	private Date ngayKetThuc;

	@Column(name = "so_ngay_nghi")
	private int soNgayNghi;

	@ManyToOne
	@JoinColumn(name = "ly_do")
	private LyDoXinNghi lyDo;

	@Column(name = "ghi_chu")
	@NotEmpty()
	@Size(max=255)
	private String ghiChu;

	@Column(name = "ghi_chu_truong_phong")
	private String ghiChuTruongPhong;

	@ManyToOne
	@JoinColumn(name = "trang_thai")
	private TrangThai trangThai;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public HoSoNhanVien getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(HoSoNhanVien maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public Date getNgayBatDau() {
		return ngayBatDau;
	}

	public void setNgayBatDau(Date ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}

	public Date getNgayKetThuc() {
		return ngayKetThuc;
	}

	public void setNgayKetThuc(Date ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}

	public int getSoNgayNghi() {
		return soNgayNghi;
	}

	public void setSoNgayNghi(int soNgayNghi) {
		this.soNgayNghi = soNgayNghi;
	}

	public LyDoXinNghi getLyDo() {
		return lyDo;
	}

	public void setLyDo(LyDoXinNghi lyDo) {
		this.lyDo = lyDo;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public String getGhiChuTruongPhong() {
		return ghiChuTruongPhong;
	}
	
	public void setGhiChuTruongPhong(String ghiChuTruongPhong) {
		this.ghiChuTruongPhong = ghiChuTruongPhong;
	}

	public TrangThai getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(TrangThai trangThai) {
		this.trangThai = trangThai;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
	
}
