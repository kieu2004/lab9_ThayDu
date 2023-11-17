package task2;

public class ChuongSach {
	private String tieuDe;
	private int soTrang;

	public ChuongSach(String tieuDe, int soTrang) {
		this.tieuDe = tieuDe;
		this.soTrang = soTrang;
	}

	public boolean isMorePage(ChuongSach other) {
		return this.soTrang > other.soTrang ;
	}

	@Override
	public String toString() {
		return "ChuongSach [tieuDe=" + tieuDe + ", soTrang=" + soTrang + "]";
	}

	
}
