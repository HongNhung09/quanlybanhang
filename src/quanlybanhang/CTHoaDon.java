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
public class CTHoaDon {
    private String MaHD;
    private String MaSP;
    private String TenSP;
    private Float giaban;
    private int soluong;

    public CTHoaDon() {
    }

    public CTHoaDon(String MaHD, String MaSP, String TenSP, Float giaban, int soluong) {
        this.MaHD = MaHD;
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.giaban = giaban;
        this.soluong = soluong;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
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

    public Float getGiaban() {
        return giaban;
    }

    public void setGiaban(Float giaban) {
        this.giaban = giaban;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    @Override
    public String toString() {
        return "CTHoaDon{" + "MaHD=" + MaHD + ", MaSP=" + MaSP + ", TenSP=" + TenSP + ", giaban=" + giaban + ", soluong=" + soluong + '}';
    }

    
    
}

