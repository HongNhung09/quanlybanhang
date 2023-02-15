
package quanlybanhang;

/**
 *
 * @author Admin
 */
public class KhachHang {
    private String MaKH;
    private String TenKH;
    private String Email;
    private int GioiTinh;
    private String SDT;
    private String Điachi;
    
    public KhachHang(String MaKH,String TenKH, String Email,int GioiTinh,String SDT, String Điachi){
        this.MaKH=MaKH;
        this.TenKH=TenKH;
        this.Email=Email;
        this.GioiTinh=GioiTinh;
        this.SDT=SDT;
        this.Điachi=Điachi;
    }
    
    public KhachHang(){
        
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

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    /*public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }*/

    public int getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(int GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getĐiachi() {
        return Điachi;
    }

    public void setĐiachi(String Điachi) {
        this.Điachi = Điachi;
    }
    
    @Override
    public String toString() {
        return "khachHang{" + "MaKH=" + MaKH + ", TenKH=" + TenKH + ", Email=" + Email+ ", GioiTinh=" + GioiTinh + ", SDT="+SDT+ ", Điachi="+Điachi+"}";
    }
}
