package fasttrackse.ffse1703.fbms.controller.qlvn2;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import fasttrackse.ffse1703.fbms.entity.qlvn.LyDoXinNghi;
import fasttrackse.ffse1703.fbms.entity.qlvn.ThongKeDonXinPhep;
import fasttrackse.ffse1703.fbms.entity.qlvn.TrangThai;
import fasttrackse.ffse1703.fbms.entity.qlvn2.DonXinPhepEntity;
import fasttrackse.ffse1703.fbms.entity.qlvn2.LyDoEntity;
import fasttrackse.ffse1703.fbms.entity.qlvn2.TrangThaiEntity;
import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;
import fasttrackse.ffse1703.fbms.service.qlvn2.DonXinPhepService;
@Controller
@RequestMapping(value ="/QuanlyvangnghiDanhLT")
public class DonXinPhepController {
	@Autowired
	DonXinPhepService DonXinPhepService;
	
	@RequestMapping(value = {"/danhsachnhap003"}, method = RequestMethod.GET)
	public String danhsachnhap003(Model model ) {
		model.addAttribute("danhsachnhap003", DonXinPhepService.danhsachnhap003());
		return "QuanlyvangnghiDanhLT/danhsachnhap003";
    }
	
	@RequestMapping(value = {"/danhsachchoduyet003"}, method = RequestMethod.GET)
	public String danhsachchoduyet003(Model model ) {
		model.addAttribute("danhsachchoduyet003", DonXinPhepService.danhsachchoduyet003());
		return "QuanlyvangnghiDanhLT/danhsachchoduyet003";
    }
	@RequestMapping(value = {"/danhsachdaduyet003"}, method = RequestMethod.GET)
	public String danhsachdaduyet003(Model model ) {
		model.addAttribute("danhsachdaduyet003", DonXinPhepService.danhsachdaduyet003());
		return "QuanlyvangnghiDanhLT/danhsachdaduyet003";
    }
	@RequestMapping(value = {"/danhsachbituchoi003"}, method = RequestMethod.GET)
	public String danhsachbituchoi003(Model model ) {
		model.addAttribute("danhsachbituchoi003", DonXinPhepService.danhsachbituchoi003());
		return "QuanlyvangnghiDanhLT/danhsachbituchoi003";
    }
	@RequestMapping(value = "/donxinphep003", method = RequestMethod.GET)
	public String showForm(Model model) {
		model.addAttribute("donxinphep003", new DonXinPhepEntity());
		return "QuanlyvangnghiDanhLT/donxinphep003";
	}
	@ModelAttribute("lydo")
	public List<LyDoEntity> danhSachLyDo() {
		return this.DonXinPhepService.danhSachLyDo();
	}
	
	@ModelAttribute("trangthai")
	public List<TrangThaiEntity> danhSachTrangThai() {
		return this.DonXinPhepService.danhSachTrangThai();
	}
	
	@ModelAttribute("hoso")
	public List<HoSoNhanVien> danhSachHoSoNhanVien() {
		return this.DonXinPhepService.danhSachHoSo();
	}
	}

