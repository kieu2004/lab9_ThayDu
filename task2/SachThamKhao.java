package task2;

import java.util.List;

public class SachThamKhao extends AnPham {
	private String linhVuc;
	private List<ChuongSach> dsChuongSach;

	public SachThamKhao(String tieuDe, int soTrang, int namXuatBan, String tacGia, int giaTien, String linhVuc,
			List<ChuongSach> dsChuongSach) {
		super(tieuDe, soTrang, namXuatBan, tacGia, giaTien);
		this.linhVuc = linhVuc;
		this.dsChuongSach = dsChuongSach;
	}
	
	public List<ChuongSach> getDsChuongSach() {
		return this.dsChuongSach;
	}
	
	@Override
	public String toString() {
		return super.toString()+" SachThamKhao [linhVuc=" + linhVuc + ", dsChuongSach=" + dsChuongSach + "]";
	}

	@Override
	public String loaiAnPham() {
		return "Sách Tham Khảo";
	}
	
	@Override
	public boolean coPhaiTapChiVaXuatBan10Nam() {
		return false;
	}

    public ChuongSach chuongSachNhieuTrang() {
    	if(dsChuongSach.isEmpty()) {
    		return null;
    	}
    	
		ChuongSach cs_NhieuTrangNhat= dsChuongSach.get(0);
        for (ChuongSach chuongSach : dsChuongSach) {
			if(chuongSach.isMorePage(cs_NhieuTrangNhat)) {
				cs_NhieuTrangNhat=chuongSach;
			}
		}
		return cs_NhieuTrangNhat;
    	
    }
	
}