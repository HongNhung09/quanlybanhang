
package quanlybanhang;


import java.util.Date;

/**
 *
 * @author Admin
 */
public class SanPham {
    private String MaSP;
    private String TenSP;
    private String NgayNhap;
    private String Tinhtrang;

    public SanPham(String MaSP, String TenSP, String NgayNhap, String Tinhtrang) {
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.NgayNhap = NgayNhap;
        this.Tinhtrang = Tinhtrang;
    }
  
    public SanPham(){
        
    }

    public String getNgayNhap() {
        return NgayNhap;
    }

    public void setNgayNhap(String NgayNhap) {
        this.NgayNhap = NgayNhap;
    }

 
    public String getTinhtrang() {
        return Tinhtrang;
    }

    public void setTinhtrang(String Tinhtrang) {
        this.Tinhtrang = Tinhtrang;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }
    
    
   @Override
    public String toString() {
        return "SanPham{"+" MaSP=" +MaSP+ ", TenSP=" +TenSP + ", NgayNhap = "+NgayNhap+", Tinhtrang = "+ Tinhtrang+"}";
        }
    
}
