//package fasttrackse.ffse1703.fbms.service.TranDuc.quanlytailieu;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import fasttrackse.ffse1703.fbms.dao.TranDuc.quanlytailieu.DanhMucDao;
//import fasttrackse.ffse1703.fbms.entity.TranDuc.quanlytailieu.DanhMuc;
//
//@Service
//public class DanhMucServiceImpl implements DanhMucService {
//	@Autowired
//	private DanhMucDao daoDM;
//
//	@Override
//	public List<DanhMuc> listAllDanhMuc() {
//		return daoDM.listAllDanhMuc();
//	}
//
//	@Override
//	public void addDM(DanhMuc dm) {
//		daoDM.addDM(dm);
//	}
//
//	@Override
//	public void updateDM(DanhMuc dm) {
//		daoDM.updateDM(dm);
//	}
//
//	@Override
//	public void deleteDM(DanhMuc dm) {
//		daoDM.deleteDM(dm);
//	}
//
//	@Override
//	public DanhMuc getDMbyID(int id) {
//		return daoDM.getDMbyID(id);
//	}
//
//	@Override
//	public List<DanhMuc> listAllDanhMuc(int start, int limit) {
//		return daoDM.listAllDanhMuc(start, limit);
//	}
//
//	@Override
//	public String getRecordTotal() {
//		return daoDM.getRecordTotal();
//	}
//
//	@Override
//	public String getRecordFiltered(String sql) {
//		return daoDM.getRecordFiltered(sql);
//	}
//}