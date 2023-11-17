package task2;

public abstract class AnPham {
	private String tieuDe;
	private int soTrang;
	private int namXuatBan;
	private String tacGia;
	private int giaTien;

	public AnPham(String tieuDe, int soTrang, int namXuatBan, String tacGia, int giaTien) {
		this.tieuDe = tieuDe;
		this.soTrang = soTrang;
		this.namXuatBan = namXuatBan;
		this.tacGia = tacGia;
		this.giaTien = giaTien;
	}
	
	@Override
	public String toString() {
		return "AnPham [tieuDe=" + tieuDe + ", soTrang=" + soTrang + ", namXuatBan=" + namXuatBan + ", tacGia=" + tacGia
				+ ", giaTien=" + giaTien + "]";
	}

	public abstract String loaiAnPham();
    public abstract boolean coPhaiTapChiVaXuatBan10Nam();
    
    public int getGiaTien() {
		return giaTien;
	}

	public boolean coCungLoaiVaCungTacGia(AnPham other) {
    	return this.loaiAnPham().equals(other.loaiAnPham()) && this.tacGia.equals(other.tacGia);
    }

	public int getNamXuatBan() {
		return namXuatBan;
	}

	public void setNamXuatBan(int namXuatBan) {
		this.namXuatBan = namXuatBan;
	}
    

	public String getTacGia() {
		return tacGia;
	}

	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}

	public void setGiaTien(int giaTien) {
		this.giaTien = giaTien;
	}

	public String getTieuDe() {
		return tieuDe;
	}

	public void setTieuDe(String tieuDe) {
		this.tieuDe = tieuDe;
	}
	
	

	
}
