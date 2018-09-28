package fasttrackse.ffse1703.fbms.controller.quanlynhansutt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import fasttrackse.ffse1703.fbms.service.mvpquanliduan.NhiemVuServiceImpl;
import fasttrackse.ffse1703.fbms.service.quanlynhansutt.QuanLyHoSoServiceTT;

@Controller
@RequestMapping("/quanlynhansutt/kinh_Nghiem/")
public class ThongTinKinhNghiemTTController {
  
	@Autowired
	private NhiemVuServiceImpl nhiemVuServiceImpl;
	
	@Autowired 
	private QuanLyHoSoServiceTT quanLyHoSoServiceTT;

	public void setNhiemVuServiceImpl(NhiemVuServiceImpl nhiemVuServiceImpl) {
		this.nhiemVuServiceImpl = nhiemVuServiceImpl;
	}

	public void setQuanLyHoSoServiceTT(QuanLyHoSoServiceTT quanLyHoSoServiceTT) {
		this.quanLyHoSoServiceTT = quanLyHoSoServiceTT;
	}
	
	// Show an employee's family information
		@RequestMapping("/viewOneKinhNghiem/{maNhanVien}")
		public String viewOneGiaDinh(@PathVariable int maNhanVien, Model model) {
			model.addAttribute("viewOne", this.nhiemVuServiceImpl.getByID(maNhanVien));
			model.addAttribute("maNhanVien", maNhanVien);
			return "QuanLyNhanSuTT/ThongTinKinhNghiem/viewOneKinhNghiem";
		}
}