package fasttrackse.entity;

import org.springframework.stereotype.Component;

@Component
public class MonToan implements MonHoc {
	public String mangSachDiHoc() {
		return "Mang sách Toán đi học";
	}
}
