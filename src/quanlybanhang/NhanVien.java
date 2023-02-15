
package quanlybanhang;

import java.util.Date;

public class NhanVien {
    private String MaNV;
    private String TenNV;
    private String Ngaysinh;
    private String Email;
    private String Gioitinh;
    private String SDT;
    private String Diachi;

    public NhanVien() {
    }

    public NhanVien(String MaNV, String TenNV, String Ngaysinh, String Email, String Gioitinh, String SDT, String Diachi) {
        this.MaNV = MaNV;
        this.TenNV = TenNV;
        this.Ngaysinh = Ngaysinh;
        this.Email = Email;
        this.Gioitinh = Gioitinh;
        this.SDT = SDT;
        this.Diachi = Diachi;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public String getNgaysinh() {
        return Ngaysinh;
    }

    public void setNgaysinh(String Ngaysinh) {
        this.Ngaysinh = Ngaysinh;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getGioitinh() {
        return Gioitinh;
    }

    public void setGioitinh(String Gioitinh) {
        this.Gioitinh = Gioitinh;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getDiachi() {
        return Diachi;
    }

    public void setDiachi(String Diachi) {
        this.Diachi = Diachi;
    }

    @Override
    public String toString() {
        return "NhanVien{" + "MaNV=" + MaNV + ", TenNV=" + TenNV + ", Ngaysinh=" + Ngaysinh + ", Email=" + Email + ", Gioitinh=" + Gioitinh + ", SDT=" + SDT + ", Diachi=" + Diachi + '}';
    }
    
   
}
