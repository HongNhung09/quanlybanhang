
package quanlybanhang;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class HoaDon {
    private String MaHD;
    private String MaKH;
    private String TenKH;
    private String TenNV;
    private String NgayLap;
    private String DCgiaohang;

    public HoaDon() {
    }

    public HoaDon(String MaHD, String MaKH, String TenKH, String TenNV, String NgayLap, String DCgiaohang) {
        this.MaHD = MaHD;
        this.MaKH = MaKH;
        this.TenKH = TenKH;
        this.TenNV = TenNV;
        this.NgayLap = NgayLap;
        this.DCgiaohang = DCgiaohang;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public String getNgayLap() {
        return NgayLap;
    }

    public void setNgayLap(String NgayLap) {
        this.NgayLap = NgayLap;
    }

    public String getDCgiaohang() {
        return DCgiaohang;
    }

    public void setDCgiaohang(String DCgiaohang) {
        this.DCgiaohang = DCgiaohang;
    }

    @Override
    public String toString() {
        return "HoaDon{" + "MaHD=" + MaHD + ", MaKH=" + MaKH + ", TenKH=" + TenKH + ", TenNV=" + TenNV + ", NgayLap=" + NgayLap + ", DCgiaohang=" + DCgiaohang + '}';
    }
    
   
}



