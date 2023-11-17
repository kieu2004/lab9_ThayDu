package task2;

public class TapChi extends AnPham {
	private String ten;

	public TapChi(String tieuDe, int soTrang, int namXuatBan, String tacGia, int giaTien, String ten) {
		super(tieuDe, soTrang, namXuatBan, tacGia, giaTien);
		this.ten = ten;
	}
	
	@Override
	public String toString() {
		return super.toString()+" TapChi [ten=" + ten + "]";
	}

	@Override
	public String loaiAnPham() {
		return "Tạp Chí";
	}

	@Override
	public boolean coPhaiTapChiVaXuatBan10Nam() {
		if (2021 - this.getNamXuatBan() == 10) {
			return true;
		}
		return false;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public boolean giongTen(String ten) {
		return this.ten.equalsIgnoreCase(ten);
	}
	
	

}
