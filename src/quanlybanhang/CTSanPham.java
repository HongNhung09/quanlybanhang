/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlybanhang;

/**
 *
 * @author Admin
 */
public class CTSanPham {
    private String MaSP;
    private String TenSP;
    private int Soluong;
    private float Giaban;
    private float Gianhap;
  

    public CTSanPham() {
    }

    public CTSanPham(String MaSP, String TenSP, int Soluong, float Giaban, float Gianhap) {
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.Soluong = Soluong;
        this.Giaban = Giaban;
        this.Gianhap = Gianhap;
       
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

    public int getSoluong() {
        return Soluong;
    }

    public void setSoluong(int Soluong) {
        this.Soluong = Soluong;
    }

    public float getGiaban() {
        return Giaban;
    }

    public void setGiaban(float Giaban) {
        this.Giaban = Giaban;
    }

    public float getGianhap() {
        return Gianhap;
    }

    public void setGianhap(float Gianhap) {
        this.Gianhap = Gianhap;
    }

  
     @Override
    public String toString() {
        return "CTSanPham{"+" MaSP=" +MaSP+ ", TenSP=" +TenSP + ", Soluong = "+Soluong+", Gianhap = "+ Gianhap+", Giaban= "+Giaban+"}";
        }
  
}
