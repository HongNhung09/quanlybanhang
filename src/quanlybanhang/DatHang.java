/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlybanhang;

/**
 *
 * @author Admin
 */
public class DatHang {
    private String TenKH;
    private String SDT;
    private String DiaChi;
    private String TenSP;
    private int KichCo;
    private String Mausac;
    private String HTthanhtoan;

    public DatHang() {
    }

    public DatHang(String TenKH, String SDT, String DiaChi, String TenSP, int KichCo, String Mausac, String HTthanhtoan) {
        this.TenKH = TenKH;
        this.SDT = SDT;
        this.DiaChi = DiaChi;
        this.TenSP = TenSP;
        this.KichCo = KichCo;
        this.Mausac = Mausac;
        this.HTthanhtoan = HTthanhtoan;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public int getKichCo() {
        return KichCo;
    }

    public void setKichCo(int KichCo) {
        this.KichCo = KichCo;
    }

    public String getMausac() {
        return Mausac;
    }

    public void setMausac(String Mausac) {
        this.Mausac = Mausac;
    }

    public String getHTthanhtoan() {
        return HTthanhtoan;
    }

    public void setHTthanhtoan(String HTthanhtoan) {
        this.HTthanhtoan = HTthanhtoan;
    }

    @Override
    public String toString() {
        return "DatHang{" + "TenKH=" + TenKH + ", SDT=" + SDT + ", DiaChi=" + DiaChi + ", TenSP=" + TenSP + ", KichCo=" + KichCo + ", Mausac=" + Mausac + ", HTthanhtoan=" + HTthanhtoan + '}';
    }

    
    
}
