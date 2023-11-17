package task2;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		
		ChuongSach chuongSach1=new ChuongSach("Chương 1", 20);
		ChuongSach chuongSach2=new ChuongSach("Chương 2", 10);
		ChuongSach chuongSach3=new ChuongSach("Chương 3", 15);
		
		List<ChuongSach> dsChuongSach=new ArrayList<>();
		dsChuongSach.add(chuongSach1);
		dsChuongSach.add(chuongSach2);
		
		List<ChuongSach> dsChuongSach_other=new ArrayList<>();
		dsChuongSach_other.add(chuongSach3);
		dsChuongSach_other.add(chuongSach2);
		
		SachThamKhao stk=new SachThamKhao("Tham khao 1", 33, 2022, "Van A", 320, "The thao", dsChuongSach);
		SachThamKhao stk_other=new SachThamKhao("Tham khao 2", 33, 2022, "Van A", 320, "Giao duc", dsChuongSach_other);
		TapChi tapChi1=new TapChi("Tap chi 1", 50, 2011, "Van B", 380, "tuoi tre");
		TapChi tapChi2=new TapChi("Tap chi 1", 50, 2015, "Van B", 120, "tuoi tre");
		
       List<AnPham> listAnPham= new ArrayList<>();
       listAnPham.add(stk);
       listAnPham.add(stk_other);
       listAnPham.add(tapChi1);
       listAnPham.add(tapChi2);
       
       DanhMucAnPham dsAnPham= new DanhMucAnPham(listAnPham);
       
       //Phương thức xác định loại của ấn phẩm
       System.out.println(stk.loaiAnPham());
       System.out.println(tapChi2.loaiAnPham());
       
       //phương thức kiểm tra ấn phẩm có phải là tạp chí và có thời gian xuất bản cách 
       // 10 năm so với năm 2021 không.
       System.out.println(stk.coPhaiTapChiVaXuatBan10Nam());
       System.out.println(tapChi1.coPhaiTapChiVaXuatBan10Nam());
       System.out.println(tapChi2.coPhaiTapChiVaXuatBan10Nam());
       
       System.out.println();
       
       //Phương thức kiểm tra 2 ấn phẩm có cùng loại và cùng tác giả hay không
       System.out.println(stk.coCungLoaiVaCungTacGia(tapChi2));
       System.out.println(tapChi1.coCungLoaiVaCungTacGia(tapChi2));
       
       //Phương thức tính tổng tiền của tất cả các ấn phẩm trong nhà sách
       System.out.println("Tong tien cac an pham: "+dsAnPham.tongTien());
       
       //Phương thức tìm quyển sách tham khảo có chương sách nhiều trang nhất
       SachThamKhao sachThamKhao= dsAnPham.timSachThamKhaoNhieuTrang();
       System.out.println("Sách tham khảo có nhiều trang nhất: "+sachThamKhao);
		
       //Phương thức tìm xem trong danh sách các ấn phẩm có chứa một tạp chí có tên cho trước hay không
       System.out.println("Ấn phẩm có chứa một tạp chí có tên cho trước: "+dsAnPham.coChuaTapChiTheoTen("tuoi tre"));
 	
	  //Phương thức lấy ra danh sách các tạp chí được xuất bản vào 1 năm cho trước
       System.out.println(dsAnPham.layTapChiXuatBanTheoNam(2022));
       System.out.println(dsAnPham.layTapChiXuatBanTheoNam(2011));
       System.out.println(dsAnPham.layTapChiXuatBanTheoNam(2015));
       
      //Phương thức sắp xếp ấn phẩm tăng dần theo tiêu đề và giảm dần theo năm xuất bản
       System.out.println("Ds An Pham chưa sắp xếp: "+dsAnPham);
       dsAnPham.sapXepTangTieuDe_GiamNamXuatBan();
       System.out.println("Ds An Pham sau khi sắp xếp: "+dsAnPham);
       
      // Phương thức thống kê số lượng ấn phẩm theo năm xuất bản
       System.out.println("thống kê: "+dsAnPham.thongKeDanhSachAnPhamTheoNamXuatBan());
       System.out.println(dsAnPham.thongKeSoLuongAnPhamTheoNamXuatBan());
	}
}
