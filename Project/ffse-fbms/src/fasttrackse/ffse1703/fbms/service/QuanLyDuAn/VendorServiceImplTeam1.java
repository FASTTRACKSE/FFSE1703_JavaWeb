package fasttrackse.ffse1703.fbms.service.QuanLyDuAn;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1703.fbms.dao.QuanLyDuAn.VendorDao;
import fasttrackse.ffse1703.fbms.entity.QuanLyDuAn.VendorTeam1;
@Service
public class VendorServiceImplTeam1 implements VendorServiceTeam1{
	@Autowired
	private VendorDao vendorDao;

	@Override
	@Transactional
	public List<VendorTeam1> getAll() {
		 return this.vendorDao.getAll();
	}

	@Override
	@Transactional
	public void addNew(VendorTeam1 vd) {
		this.vendorDao.addNew(vd);
	}

	@Override
	@Transactional
	public void update(VendorTeam1 vd) {
		this.vendorDao.update(vd);
	}

	@Override
	@Transactional
	public void delete(String maVendor) {
		this.vendorDao.delete(maVendor);
	}

	@Override
	@Transactional
	public VendorTeam1 getById(String maVendor) {
		return this.vendorDao.getById(maVendor);
	}

	@Override
	@Transactional
	public void setIsDelete(String maVendor) {
		this.vendorDao.setIsDelete(maVendor);
		
	}

}