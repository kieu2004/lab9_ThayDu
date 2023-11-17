package task2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DanhMucAnPham {
	private List<AnPham> dsAnPham;

	public DanhMucAnPham(List<AnPham> dsAnPham) {
		this.dsAnPham = dsAnPham;
	}

	@Override
	public String toString() {
		return "DanhMucAnPham [dsAnPham=" + dsAnPham + "]";
	}

	public int tongTien() {
		int tong = 0;
		for (AnPham anPham : dsAnPham) {
			tong += anPham.getGiaTien();
		}
		return tong;
	}

	public SachThamKhao timSachThamKhaoNhieuTrang() {
		SachThamKhao sachNhieuTrangNhat = null;
		ChuongSach cs_NhieuTrangNhat = null;

		for (AnPham anPham : dsAnPham) {
			if (anPham.loaiAnPham().equals("Sách Tham Khảo")) {
				SachThamKhao stk = (SachThamKhao) anPham;
				ChuongSach chuongNhieuTrangNhat = stk.chuongSachNhieuTrang();
				if (cs_NhieuTrangNhat == null || chuongNhieuTrangNhat.isMorePage(cs_NhieuTrangNhat)) {
					cs_NhieuTrangNhat = chuongNhieuTrangNhat;
					sachNhieuTrangNhat = stk;
				}
			}
		}
		return sachNhieuTrangNhat;
	}

	public boolean coChuaTapChiTheoTen(String ten) {
		for (AnPham anPham : dsAnPham) {
			if (anPham.loaiAnPham().equals("Tạp Chí")) {
				TapChi tc = (TapChi) anPham;
				if (tc.giongTen(ten)) {
					return true;
				}

			}

		}
		return false;
	}

	public List<TapChi> layTapChiXuatBanTheoNam(int year) {
		List<TapChi> dsTapChi = new ArrayList<>();

		for (AnPham anPham : dsAnPham) {
			if (anPham.loaiAnPham().equals("Tạp Chí")) {
				TapChi tapChi = (TapChi) anPham;
				if (tapChi.getNamXuatBan() == year) {
					if (!dsTapChi.contains(tapChi)) {
						dsTapChi.add(tapChi);
					}
				}
			}
		}
		return dsTapChi;
	}

	public void sapXepTangTieuDe_GiamNamXuatBan() {
		dsAnPham.sort(new Comparator<AnPham>() {

			@Override
			public int compare(AnPham o1, AnPham o2) {
				int result = o1.getTieuDe().compareTo(o2.getTieuDe());

				if (result == 0) {
					return o2.getNamXuatBan() - o1.getNamXuatBan();
				}
				return result;
			}

		});
	}

	public Map<Integer, List<AnPham>> thongKeDanhSachAnPhamTheoNamXuatBan() {
		Map<Integer, List<AnPham>> map = new HashMap<>();

		for (AnPham anPham : dsAnPham) {
			int key = anPham.getNamXuatBan();
			List<AnPham> values = new ArrayList<>();
			if (!map.containsKey(key)) {
				values.add(anPham);
			} else {
				values = map.get(key);
				if (!values.contains(anPham)) {
					values.add(anPham);
				}
			}

			map.put(key, values);

		}
		return map;
	}

	public String thongKeSoLuongAnPhamTheoNamXuatBan() {
		StringBuilder sb= new StringBuilder();
		
		Map<Integer, List<AnPham>> map = thongKeDanhSachAnPhamTheoNamXuatBan();
		int size=map.size();
		int count=0;
		for (Map.Entry<Integer, List<AnPham>> anPham : map.entrySet()) {
			int key= anPham.getKey();
			int soLuongAnPham=anPham.getValue().size();
			sb.append(key+":"+soLuongAnPham);
			if(++count < size) {
				sb.append(" , ");
			}

		}
		return sb.toString();
	}

}
