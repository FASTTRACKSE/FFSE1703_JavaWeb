package fasttrackse.ffse1703.fbms.controller.quantridanhgia;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fasttrackse.ffse1703.fbms.entity.quantridanhgia.DanhGiaBanThan;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.DanhGiaNhanVien;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.LichDanhGia;
import fasttrackse.ffse1703.fbms.entity.security.ChucDanh;
import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;
import fasttrackse.ffse1703.fbms.entity.security.PhongBan;
import fasttrackse.ffse1703.fbms.entity.security.UserAccount;
import fasttrackse.ffse1703.fbms.service.quantridanhgia.NhanVienService;
import fasttrackse.ffse1703.fbms.service.security.UserAccountService;

@Controller
@RequestMapping("/quantridanhgia/nhanvien")
public class NhanVienController {

	public NhanVienService nhanVienService;

	public UserAccountService accountService;

	@Autowired
	@Qualifier(value = "userAccountServiceImpl")
	public void setAccountService(UserAccountService accountService) {
		this.accountService = accountService;
	}

	@Autowired
	@Qualifier(value = "nhanVienServiceImpl")
	public void setNhanVienService(NhanVienService nhanVienService) {
		this.nhanVienService = nhanVienService;
	}

	@RequestMapping(value = "/**")
	public String redirectPage(Model model, HttpSession session) {
		String page = "redirect:/quantridanhgia/nhanvien/danhgiabanthan";
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth instanceof AnonymousAuthenticationToken) {
			page = "redirect:/login";
		} else {
			UserAccount user = accountService.loadUserByUsername(auth.getName());
			HoSoNhanVien hoSo = user.getNhanVien();
			ChucDanh chucDanh = hoSo.getChucDanh();
			PhongBan phongBan = hoSo.getPhongBan();
			session.setAttribute("chucDanh", chucDanh);
			session.setAttribute("nhanVien", hoSo);
			session.setAttribute("phongBan", phongBan);
		}
		return page;
	}

	@RequestMapping(value = { "/danhgiabanthan" })
	public String getDanhGiaBanThan(Model model, HttpSession session) {
		HoSoNhanVien nhanVien = (HoSoNhanVien) session.getAttribute("nhanVien");
		model.addAttribute("danhGia", nhanVienService.getDanhGiaBanThan(nhanVien).get(0));
		return "QuanTriDanhGia/nhanvien/danhgiabanthan";
	}

	@RequestMapping("/danhgiabanthan/add")
	public String createDanhGiaBanThan(Model model, HttpSession session) {
		HoSoNhanVien nhanVien = (HoSoNhanVien) session.getAttribute("nhanVien");
		PhongBan phongBan = (PhongBan) session.getAttribute("phongBan");
		LichDanhGia lich = nhanVienService.getLichDanhGiaActive(phongBan.getMaPhongBan());
		DanhGiaBanThan danhGia = new DanhGiaBanThan();
		danhGia.setKyDanhGia(lich.getKyDanhGia());
		danhGia.setPhongBan(phongBan);
		danhGia.setNhanVien(nhanVien);
		model.addAttribute("command", danhGia);
		return "QuanTriDanhGia/nhanvien/formdanhgiabanthan";
	}

	@RequestMapping("/danhgiabanthan/edit")
	public String editDanhGiaBanThan(Model model, HttpSession session) {
		HoSoNhanVien nhanVien = (HoSoNhanVien) session.getAttribute("nhanVien");
		DanhGiaBanThan danhGia = new DanhGiaBanThan();
		if (nhanVienService.getDanhGiaBanThan(nhanVien).size() < 1) {
			return "redirect:/quantridanhgia/nhanvien/add";
		} else {
			danhGia = nhanVienService.getDanhGiaBanThan(nhanVien).get(0);
			model.addAttribute("command", danhGia);
		}
		return "QuanTriDanhGia/nhanvien/formdanhgiabanthan";
	}

	@RequestMapping(value = "/danhgiabanthan/submit", method = RequestMethod.POST)
	public String submitDanhGiaBanThan(Model model, @ModelAttribute("command") @Valid DanhGiaBanThan danhGia, BindingResult result) {
		if (result.hasErrors()) {
			return "QuanTriDanhGia/nhanvien/formdanhgiabanthan";
		}
		if (danhGia.getId() == 0) {
			nhanVienService.insertDanhGiaBanThan(danhGia);
		} else {
			nhanVienService.updateDanhGiaBanThan(danhGia);
		}
		return "redirect:/quantridanhgia/nhanvien";
	}

	@RequestMapping(value = { "/danhgianhanvien" })
	public String getListDanhGiaNhanVien(Model model, HttpSession session) {
		HoSoNhanVien nhanVien = (HoSoNhanVien) session.getAttribute("nhanVien");
		List<DanhGiaNhanVien> list = nhanVienService.getListDanhGiaNhanVien(nhanVien.getMaNhanVien());
		model.addAttribute("listDanhGiaNhanVien", list);
		return "QuanTriDanhGia/nhanvien/danhgianhanvien";
	}

	@RequestMapping(value = { "/danhgianhanvien/create" })
	public String createListDanhGiaNhanVien(Model model, HttpSession session) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserAccount user = accountService.loadUserByUsername(auth.getName());
		HoSoNhanVien hoSo = user.getNhanVien();
		PhongBan phongBan = hoSo.getPhongBan();
		LichDanhGia lich = nhanVienService.getLichDanhGiaActive(phongBan.getMaPhongBan());
		List<HoSoNhanVien> listNhanVien = nhanVienService.getListNhanVienPhongBan(phongBan.getMaPhongBan());
		List<DanhGiaNhanVien> list = new ArrayList<>();
		for (int i = 0; i < listNhanVien.size(); i++) {
			int start = 0;
			if (listNhanVien.get(i).getMaNhanVien() == hoSo.getMaNhanVien()) {
				start = i + 1;
				List<HoSoNhanVien> listNhanVienLimit = nhanVienService.getListNhanVienLimit(start,
						phongBan.getMaPhongBan());
				for (HoSoNhanVien x : listNhanVienLimit) {
					DanhGiaNhanVien danhGia = new DanhGiaNhanVien();
					danhGia.setKyDanhGia(lich.getKyDanhGia());
					danhGia.setPhongBan(phongBan);
					danhGia.setNhanVienDanhGia(hoSo.getMaNhanVien());
					danhGia.setNhanVien(x);
					list.add(danhGia);
				}
				break;
			}
		}
		nhanVienService.createDanhGiaNhanVien(list);
		return "redirect:/quantridanhgia/nhanvien/danhgianhanvien";
	}

	@RequestMapping("/danhgianhanvien/add/{nhanvien}/{id}")
	public String createDanhGiaNhanVien(Model model, @PathVariable("id") int id,
			@PathVariable("nhanvien") int nhanVien) {
		HoSoNhanVien hoSo = nhanVienService.getHoSoNhanVien(nhanVien);
		model.addAttribute("danhGia", nhanVienService.getDanhGiaBanThan(hoSo).get(0));
		model.addAttribute("command", nhanVienService.getDanhGiaNhanVien(id));
		return "QuanTriDanhGia/nhanvien/formdanhgianhanvien";
	}

	@RequestMapping(value = "/danhgianhanvien/submit", method = RequestMethod.POST)
	public String submitDanhGiaNhanVien(Model model, @ModelAttribute("command") @Valid DanhGiaNhanVien danhGia, BindingResult result) {
		if (result.hasErrors()) {
			HoSoNhanVien hoSo = danhGia.getNhanVien();
			model.addAttribute("danhGia", nhanVienService.getDanhGiaBanThan(hoSo).get(0));
			return "QuanTriDanhGia/nhanvien/formdanhgianhanvien";
		}
		nhanVienService.updateDanhGiaNhanVien(danhGia);
		return "redirect:/quantridanhgia/nhanvien/danhgianhanvien";
	}

	@RequestMapping("/nhanviendanhgia")
	public String getListNhanVienDanhGia(Model model, HttpSession session) {
		HoSoNhanVien nhanVien = (HoSoNhanVien) session.getAttribute("nhanVien");
		model.addAttribute("listDanhGia", nhanVienService.getListNhanVienDanhGia(nhanVien.getMaNhanVien()));
		return "QuanTriDanhGia/nhanvien/nhanviendanhgia";
	}

	@RequestMapping("/nhanviendanhgia/view/{id}")
	public String viewNhanVienDanhGia(Model model, @PathVariable int id) {
		model.addAttribute("danhGia", nhanVienService.getNhanVienDanhGia(id));
		return "QuanTriDanhGia/nhanvien/viewnhanviendanhgia";
	}

	@RequestMapping("/danhgiacuatruongphong")
	public String viewDanhGiaCuaTruognPhong(Model model, HttpSession session) {
		HoSoNhanVien nhanVien = (HoSoNhanVien) session.getAttribute("nhanVien");
		model.addAttribute("danhGia", nhanVienService.getDanhGiaCuaTruongPhong(nhanVien.getMaNhanVien()));
		return "QuanTriDanhGia/nhanvien/danhgiacuatruongphong";
	}
}
