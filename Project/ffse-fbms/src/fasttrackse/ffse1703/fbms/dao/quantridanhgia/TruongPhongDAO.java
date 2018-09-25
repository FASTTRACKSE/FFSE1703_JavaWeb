package fasttrackse.ffse1703.fbms.dao.quantridanhgia;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.quantridanhgia.DanhGiaBanThan;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.TruongPhongDanhGia;

public interface TruongPhongDAO {

	public DanhGiaBanThan getNhanVienTuDanhGia(int id);

	public List<TruongPhongDanhGia> getListNhanVienPhongBan(String phongBan);

	public void insertDanhGiaNhanVien(TruongPhongDanhGia danhGia);

	public TruongPhongDanhGia getDanhGiaNhanVien(int id);

	public void updateDanhGiaNhanVien(TruongPhongDanhGia danhGia);

	public void deleteDanhGiaNhanVien(TruongPhongDanhGia danhGia);
}
