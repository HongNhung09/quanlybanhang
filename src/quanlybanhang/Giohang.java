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
public class Giohang {
    private String TenSP;
    private String Mausac;
    private int kichco;
    private float gia;
    private int soluong;

    public Giohang() {
    }

    public Giohang(String TenSP, String Mausac, int kichco, float gia, int soluong) {
        this.TenSP = TenSP;
        this.Mausac = Mausac;
        this.kichco = kichco;
        this.gia = gia;
        this.soluong = soluong;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public String getMausac() {
        return Mausac;
    }

    public void setMausac(String Mausac) {
        this.Mausac = Mausac;
    }

    public int getKichco() {
        return kichco;
    }

    public void setKichco(int kichco) {
        this.kichco = kichco;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    @Override
    public String toString() {
        return "Giohang{" + "TenSP=" + TenSP + ", Mausac=" + Mausac + ", kichco=" + kichco + ", gia=" + gia + ", soluong=" + soluong + '}';
    }
    
    
}
