/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package quanlybanhang.Fram;

import java.awt.Color;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import quanlybanhang.ConnectToSQLServer;

/**
 *
 * @author Admin
 */
public class SanphamForm extends javax.swing.JFrame {

    final String header1[] = {"MaSP", "TenSP", "NgayNhap", "Tinhtrang"};
    final DefaultTableModel tb1 = new DefaultTableModel(header1, 0);

    final String header2[] = {"MaSP", "TenSP", "Soluong", "Gianhap", "Giaban"};
    final DefaultTableModel tb2 = new DefaultTableModel(header2, 0);

    ConnectToSQLServer cn = new ConnectToSQLServer();
    Connection conn;
    private boolean flase;

    /**
     * Creates new form SanphamForm
     */
    public SanphamForm() {
        initComponents();
        setLocationRelativeTo(null);// hiển thị form ra giữa màn hình
        LoatBang_SP();
        //   automa_SP();
        LoatBang_CTSP();
        //automa_CTSP();
    }

    /* public void automa_SP() {
        String sql = "SELECT TOP 1 masp FROM SanPham ORDER BY masp DESC";
        conn = cn.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String rnno = rs.getString("masp");
                int co = rnno.length();
                String txt = rnno.substring(0, 2);
                String num = rnno.substring(2, co);
                int n = Integer.parseInt(num);
                n++;
                String snum = Integer.toString(n);
                String ftxt = "";
                if(n<10){
                    ftxt = txt +"0"+ snum;
                }else if(n>=10 && n<100){
                    txt = txt + snum;
                }
                
                jTextField_masp1.setText(ftxt);
                jTextField_masp1.setEnabled(false);                
            } else {
            }
        } catch (Exception e) {
            System.out.println("SV: " + e.toString());
        }
    }*/

    public void LoatBang_SP() {
        try {
            conn = cn.getConnection();
            String sql = "SELECT *FROM SanPham order by masp desc"
                    + "";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            tb1.setRowCount(0);
            while (rs.next()) {
                Object personObject[] = {
                    rs.getString("masp"),
                    rs.getString("tensp"),
                    rs.getString("ngaynhap"),
                    rs.getString("tinhtrang"),};
                tb1.addRow(personObject);
                jTable_dssp.setModel(tb1);
            }

            st.close();
            rs.close();
            conn.close();
        } catch (Exception e) {
        }
        jTable_dssp.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (jTable_dssp.getSelectedRow() >= 0) {
                    jTextField_masp1.setText(jTable_dssp.getValueAt(jTable_dssp.getSelectedRow(), 0) + "");
                    jTextField_tensp1.setText(jTable_dssp.getValueAt(jTable_dssp.getSelectedRow(), 1) + "");
                    jTextField_ngaynhap1.setText(jTable_dssp.getValueAt(jTable_dssp.getSelectedRow(), 2) + "");
                    jTextField_TT1.setText(jTable_dssp.getValueAt(jTable_dssp.getSelectedRow(), 3) + "");
                }
            }
        });
    }
// Hàm này xẽ xóa trắng sau khi thêm sửa xóa

    private void Xoatrang_SP() {
        jTextField_masp1.setText("");
        jTextField_tensp1.setText("");
        jTextField_ngaynhap1.setText("");
        jTextField_TT1.setText("");

        LoatBang_SP();
        jTextField_masp1.setEnabled(true);
        //sau khi them thanh cong thi tu load ma moi luon
        //  automa_SP();
    }

    /// CHI TIẾT SẢN PHẨM 
    /* public void automa_CTSP() {
        String sql = "SELECT TOP 1 masp FROM CTSanPham ORDER BY masp DESC";
        conn = cn.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String rnno = rs.getString("masp");
                int co = rnno.length();
                String txt = rnno.substring(0, 2);
                String num = rnno.substring(2, co);
                int n = Integer.parseInt(num);
                n++;
                String snum = Integer.toString(n);
                String ftxt = "";
                if(n<10){
                    ftxt = txt +"0"+ snum;
                }else if(n>=10 && n<100){
                    txt = txt + snum;
                }
                
                jTextField_MaSP.setText(ftxt);
                jTextField_MaSP.setEnabled(false);                
            } else {
            }
        } catch (Exception e) {
            System.out.println("SV: " + e.toString());
        }
    }*/
    public void LoatBang_CTSP() {
        try {
            conn = cn.getConnection();
            String sql = "SELECT *FROM CTSanPham order by masp desc"
                    + "";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            tb2.setRowCount(0);
            while (rs.next()) {
                Object personObject[] = {
                    rs.getString("masp"),
                    rs.getString("tensp"),
                    rs.getInt("soluong"),
                    rs.getFloat("gianhap"),
                    rs.getFloat("giaban"),};
                tb2.addRow(personObject);
                jTable_DSsanpham2.setModel(tb2);
            }

            st.close();
            rs.close();
            conn.close();
        } catch (Exception e) {
        }
        jTable_DSsanpham2.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (jTable_DSsanpham2.getSelectedRow() >= 0) {
                    jTextField_MaSP.setText(jTable_DSsanpham2.getValueAt(jTable_DSsanpham2.getSelectedRow(), 0) + "");
                    jTextField_TenSP.setText(jTable_DSsanpham2.getValueAt(jTable_DSsanpham2.getSelectedRow(), 1) + "");
                    jTextField_SLuong.setText(jTable_DSsanpham2.getValueAt(jTable_DSsanpham2.getSelectedRow(), 2) + "");
                    jTextField_Gianhap.setText(jTable_DSsanpham2.getValueAt(jTable_DSsanpham2.getSelectedRow(), 3) + "");
                    jTextField_Giaban.setText(jTable_DSsanpham2.getValueAt(jTable_DSsanpham2.getSelectedRow(), 4) + "");

                }
            }
        });
    }
// Hàm này xẽ xóa trắng sau khi thêm sửa xóa

    private void Xoatrang_CTSP() {
        jTextField_MaSP.setText("");
        jTextField_TenSP.setText("");
        jTextField_SLuong.setText("");
        jTextField_Gianhap.setText("");
        jTextField_Giaban.setText("");

        LoatBang_CTSP();
        jTextField_MaSP.setEnabled(true);
        //sau khi them thanh cong thi tu load ma moi luon
        // automa_CTSP();
    }

    /*public void loatbang2(){
        try {
            conn=cn.getConnection();
             String sql = "SELECT *FROM CTSanPham";
              Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            tb2.setRowCount(0);
            while (rs.next()) {
               Object[] obj = {
                   rs.getString("MaSP"),
                   rs.getString("TenSP"),
                   rs.getInt("Soluong"),
                   rs.getFloat("Giaban"),
                   rs.getFloat("Gianhap"),
                   rs.getString("ThanhTien"),
               };
               tb2.addRow(obj);
               jTable_DSsanpham2.setModel(tb2);
            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }*/
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_dssp = new javax.swing.JTable();
        jTextField_tksanpham = new javax.swing.JTextField();
        jButton_timkiem = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel_MaSP = new javax.swing.JLabel();
        jLabel_Tensp = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_DSsanpham2 = new javax.swing.JTable();
        jLabel_Soluong = new javax.swing.JLabel();
        jTextField_SLuong = new javax.swing.JTextField();
        jLabel_Giaban = new javax.swing.JLabel();
        jTextField_Giaban = new javax.swing.JTextField();
        jTextField_MaSP = new javax.swing.JTextField();
        jLabel_Gianhap = new javax.swing.JLabel();
        jTextField_Gianhap = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jButton_ThemCTSP = new javax.swing.JButton();
        jButton_XoaCTSP = new javax.swing.JButton();
        jButton_Reset1 = new javax.swing.JButton();
        jLabel_Giaban1 = new javax.swing.JLabel();
        jTextField_TenSP = new javax.swing.JTextField();
        jButton_timkiem2 = new javax.swing.JButton();
        jTextField_TkCTsanpham = new javax.swing.JTextField();
        jButton_Thoat = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel_tensp = new javax.swing.JLabel();
        jLabel_masp = new javax.swing.JLabel();
        jLabel_ngaynhap1 = new javax.swing.JLabel();
        jTextField_ngaynhap1 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jTextField_masp1 = new javax.swing.JTextField();
        jTextField_tensp1 = new javax.swing.JTextField();
        jLabel_mahd1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton_them = new javax.swing.JButton();
        jButton_xoa = new javax.swing.JButton();
        jButton_Reset = new javax.swing.JButton();
        jButton_sua = new javax.swing.JButton();
        jTextField_TT1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("QUẢN LÝ SẢN PHẨM");

        jPanel2.setBackground(new java.awt.Color(153, 255, 255));

        jLabel1.setBackground(new java.awt.Color(0, 153, 153));
        jLabel1.setFont(new java.awt.Font("Sitka Display", 1, 48)); // NOI18N
        jLabel1.setText("QUẢN LÝ SẢN PHẨM");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlybanhang/Fram/HinhAnh/clipboard.png"))); // NOI18N
        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(507, 507, 507)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(0, 204, 204));

        jPanel9.setBackground(new java.awt.Color(0, 204, 204));

        jPanel10.setBackground(new java.awt.Color(204, 204, 204));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách TT sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18))); // NOI18N
        jPanel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel10MouseClicked(evt);
            }
        });

        jTable_dssp.setBackground(new java.awt.Color(204, 204, 204));
        jTable_dssp.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTable_dssp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã SP", "Tên SP", "Ngày Nhập", "Tình trạng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_dssp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_dsspMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_dssp);
        if (jTable_dssp.getColumnModel().getColumnCount() > 0) {
            jTable_dssp.getColumnModel().getColumn(0).setResizable(false);
            jTable_dssp.getColumnModel().getColumn(1).setResizable(false);
            jTable_dssp.getColumnModel().getColumn(2).setResizable(false);
            jTable_dssp.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jTextField_tksanpham.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jButton_timkiem.setBackground(new java.awt.Color(255, 153, 153));
        jButton_timkiem.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton_timkiem.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\OneDrive\\Tài liệu\\NetBeansProjects\\QLBanHang\\src\\qlbanhang\\HinhAnh\\search-icon-32.png")); // NOI18N
        jButton_timkiem.setText("Tìm kiếm");
        jButton_timkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_timkiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(jButton_timkiem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField_tksanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_tksanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(204, 204, 204));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi tiết Sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18))); // NOI18N

        jLabel_MaSP.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel_MaSP.setText("Mã SP :");

        jLabel_Tensp.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel_Tensp.setText("Tên SP :");

        jPanel11.setBackground(new java.awt.Color(204, 204, 204));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách CTsản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18))); // NOI18N

        jTable_DSsanpham2.setBackground(new java.awt.Color(204, 204, 204));
        jTable_DSsanpham2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTable_DSsanpham2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã SP", "Tên SP", "Số lượng", "Giá nhập", "Giá bán", "Tổng tiền (Nhập SP)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_DSsanpham2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_DSsanpham2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable_DSsanpham2);
        if (jTable_DSsanpham2.getColumnModel().getColumnCount() > 0) {
            jTable_DSsanpham2.getColumnModel().getColumn(0).setResizable(false);
            jTable_DSsanpham2.getColumnModel().getColumn(1).setResizable(false);
            jTable_DSsanpham2.getColumnModel().getColumn(2).setResizable(false);
            jTable_DSsanpham2.getColumnModel().getColumn(3).setResizable(false);
            jTable_DSsanpham2.getColumnModel().getColumn(4).setResizable(false);
            jTable_DSsanpham2.getColumnModel().getColumn(5).setResizable(false);
        }

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 781, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(122, 122, 122))
        );

        jLabel_Soluong.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel_Soluong.setText("Số lượng :");

        jTextField_SLuong.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel_Giaban.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel_Giaban.setText("Giá bán :");

        jTextField_Giaban.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jTextField_MaSP.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel_Gianhap.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel_Gianhap.setText("Giá nhập :");

        jTextField_Gianhap.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18))); // NOI18N

        jButton_ThemCTSP.setBackground(new java.awt.Color(255, 153, 153));
        jButton_ThemCTSP.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton_ThemCTSP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlybanhang/Fram/HinhAnh/themkhachhang-25.png"))); // NOI18N
        jButton_ThemCTSP.setText("Thêm");
        jButton_ThemCTSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ThemCTSPActionPerformed(evt);
            }
        });

        jButton_XoaCTSP.setBackground(new java.awt.Color(255, 153, 153));
        jButton_XoaCTSP.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton_XoaCTSP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlybanhang/Fram/HinhAnh/xoa-25.png"))); // NOI18N
        jButton_XoaCTSP.setText("Xóa");
        jButton_XoaCTSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_XoaCTSPActionPerformed(evt);
            }
        });

        jButton_Reset1.setBackground(new java.awt.Color(255, 153, 153));
        jButton_Reset1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton_Reset1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\OneDrive\\Tài liệu\\NetBeansProjects\\QLBanHang\\src\\qlbanhang\\HinhAnh\\refresh-25.png")); // NOI18N
        jButton_Reset1.setText("Reset");
        jButton_Reset1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Reset1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_XoaCTSP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_ThemCTSP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                    .addComponent(jButton_Reset1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton_ThemCTSP, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jButton_XoaCTSP, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jButton_Reset1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel_Giaban1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel_Giaban1.setText("Tổng tiền :");

        jTextField_TenSP.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jButton_timkiem2.setBackground(new java.awt.Color(255, 153, 153));
        jButton_timkiem2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton_timkiem2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\OneDrive\\Tài liệu\\NetBeansProjects\\QLBanHang\\src\\qlbanhang\\HinhAnh\\search-icon-32.png")); // NOI18N
        jButton_timkiem2.setText("Tìm kiếm");
        jButton_timkiem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_timkiem2ActionPerformed(evt);
            }
        });

        jTextField_TkCTsanpham.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel_Tensp)
                                            .addComponent(jLabel_MaSP))
                                        .addGap(41, 41, 41))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel_Giaban1)
                                        .addGap(19, 19, 19)))
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(jPanel8Layout.createSequentialGroup()
                                                .addGap(5, 5, 5)
                                                .addComponent(jTextField_MaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(89, 89, 89))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                                .addComponent(jTextField_TenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel_Soluong)
                                            .addComponent(jLabel_Gianhap)))
                                    .addComponent(jLabel_Giaban))
                                .addGap(47, 47, 47)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField_SLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField_Gianhap, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField_Giaban, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jButton_timkiem2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(jTextField_TkCTsanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(82, 82, 82)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField_Gianhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel_Gianhap)
                                    .addComponent(jLabel_Tensp)))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel_MaSP)
                                    .addComponent(jTextField_MaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel_Soluong)
                                    .addComponent(jTextField_SLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField_TenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_Giaban)
                            .addComponent(jTextField_Giaban, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(jLabel_Giaban1)
                        .addGap(44, 44, 44)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton_timkiem2)
                            .addComponent(jTextField_TkCTsanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        jButton_Thoat.setBackground(new java.awt.Color(255, 153, 153));
        jButton_Thoat.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jButton_Thoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlybanhang/Fram/HinhAnh/logout-icon-32.png"))); // NOI18N
        jButton_Thoat.setText("Thoát");
        jButton_Thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ThoatActionPerformed(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(204, 204, 204));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nhập thông tin sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18))); // NOI18N
        jPanel7.setToolTipText("QUẢN LÝ KHÁCH HÀNG");

        jLabel_tensp.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel_tensp.setText("Tên SP :");

        jLabel_masp.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel_masp.setText("Mã SP :");

        jLabel_ngaynhap1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel_ngaynhap1.setText("Ngày nhập :");

        jTextField_ngaynhap1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jButton6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton6.setText("Thêm");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jTextField_masp1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jTextField_tensp1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel_mahd1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel_mahd1.setText("Tình trạng :");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18))); // NOI18N

        jButton_them.setBackground(new java.awt.Color(255, 153, 153));
        jButton_them.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton_them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlybanhang/Fram/HinhAnh/themkhachhang-25.png"))); // NOI18N
        jButton_them.setText("Thêm SP");
        jButton_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_themActionPerformed(evt);
            }
        });

        jButton_xoa.setBackground(new java.awt.Color(255, 153, 153));
        jButton_xoa.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton_xoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlybanhang/Fram/HinhAnh/xoa-25.png"))); // NOI18N
        jButton_xoa.setText("Xóa SP");
        jButton_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_xoaActionPerformed(evt);
            }
        });

        jButton_Reset.setBackground(new java.awt.Color(255, 153, 153));
        jButton_Reset.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton_Reset.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\OneDrive\\Tài liệu\\NetBeansProjects\\QLBanHang\\src\\qlbanhang\\HinhAnh\\refresh-25.png")); // NOI18N
        jButton_Reset.setText("Reset");
        jButton_Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ResetActionPerformed(evt);
            }
        });

        jButton_sua.setBackground(new java.awt.Color(255, 153, 153));
        jButton_sua.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton_sua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlybanhang/Fram/HinhAnh/sua-25.png"))); // NOI18N
        jButton_sua.setText("Sửa SP");
        jButton_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_suaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_Reset, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton_them)
                        .addGap(167, 167, 167)
                        .addComponent(jButton_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(115, 115, 115))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_them, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Reset, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        jTextField_TT1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel_masp, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_masp1))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel_tensp)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_tensp1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_ngaynhap1)
                            .addComponent(jLabel_mahd1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField_ngaynhap1, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(jTextField_TT1))
                        .addGap(17, 17, 17))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(36, 36, 36))))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                    .addContainerGap(439, Short.MAX_VALUE)
                    .addComponent(jButton6)
                    .addGap(116, 116, 116)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_ngaynhap1)
                    .addComponent(jTextField_ngaynhap1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_masp)
                    .addComponent(jTextField_masp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_tensp)
                    .addComponent(jTextField_tensp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_mahd1)
                    .addComponent(jTextField_TT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(69, 69, 69)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(268, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(685, 685, 685)
                        .addComponent(jButton_Thoat, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_Thoat, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton_XoaCTSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_XoaCTSPActionPerformed
        // TODO add your handling code here:
        conn = cn.getConnection();
        try {
            // Tạo một đối tượng để thực hiện công việc
            String query = "DELETE FROM CTSanPham WHERE MaSP = '" + jTextField_MaSP.getText() + "'";
            Statement st = conn.createStatement();
            int chk = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn xóa chứ !", "Thông báo", JOptionPane.YES_NO_OPTION);
            if (chk == JOptionPane.YES_NO_OPTION) {
                st.executeUpdate(query);
                Xoatrang_CTSP();
                JOptionPane.showMessageDialog(this, "Xóa thành công !");
            }
        } catch (Exception ex) {

            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton_XoaCTSPActionPerformed


    private void jButton_ThemCTSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ThemCTSPActionPerformed
        // TODO add your handling code here:
        conn = cn.getConnection();
        try {

            if (jTextField_MaSP.getText().equals("") || jTextField_TenSP.getText().equals("") || jTextField_SLuong.getText().equals("")
                    || jTextField_Gianhap.getText().equals("") || jTextField_Giaban.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Bạn Cần cập nhật đủ dữ liệu ");
                /*
            Đây là bẫy lỗi nhập thiếu dữ liệu
            cái đầu tiên là mã khách hàngvà tiếp theo lần lượt như bên CSDL
            Nếu như nó trống thì đưa ra thông báo ,ở sự kiện nút thêm
                 */
            } else {
                /*
                Nếu trên đã oke rồi thì bãy lỗi trùng khóa chính
                 */
                StringBuffer sb = new StringBuffer();
                String SQL_check_pk = "SELECT MaSP FROM CTSanPham WHERE MaSP = '" + jTextField_MaSP.getText() + "'";
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(SQL_check_pk);
                if (rs.next()) {
                    sb.append("Mã Sản phẩm  đã bị trùng");
                }
                if (sb.length() > 0) { //Nếu if kia đúng nó xẽ thêm vào sb 1 đoạn String , kiểm tra độ dài chuỗi này nếu lớn hơn 0 tức là có thông báo thì 
                    JOptionPane.showConfirmDialog(this, sb.toString());
                    rs.close();
                } else {
                    /*
                    Nếu không thì 
                    thêm thì sẽ có 3 cách 
                    cách đơn giản nhất là 
                     */

                    String sql = "INSERT INTO CTSanPham VALUES(?,?,?,?,?)";
                    //6 dau ? tuong duong 6 bien vo dinh
                    // lan luot la 1 2 3 4 5 6
                    // tuong ung vi tri 1 la makh, vitri 2 la tenkh, 3 4 5 6 tuong tu
                    //  float gianhap=0,giaban=0;
                    // int soluong=0;

                    PreparedStatement pst = conn.prepareStatement(sql);
                    String masp = jTextField_MaSP.getText();
                    String tensp = jTextField_TenSP.getText();
                    String soluong = jTextField_SLuong.getText();
                    try {
                        int bien = Integer.valueOf(soluong);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Số lượng phải nhập Bằng số ");
                        //ThongBao += "Số lượng phải nhập Bằng số" + "\n";
                    }

                    String gianhap = jTextField_Gianhap.getText();
                    String giaban = jTextField_Giaban.getText();
                    try {
                        int bien = Integer.valueOf(gianhap);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Giá nhập phải là số ");
                        //  ThongBao+="Giá Nhập Phải là số !\n";
                    }
                    try {
                        int bien = Integer.valueOf(giaban);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Giá bán phải là số");
                        //ThongBao+="Giá Bán Phải là số !\n";
                    }
                    try {
                        if (Integer.valueOf(gianhap) > Integer.valueOf(giaban)) {
                            jLabel_Giaban.setForeground(Color.red);
                            JOptionPane.showMessageDialog(this, "Nhập giá bán sản phẩm phải lớn hơn giá nhập vào  ");
                            //ThongBao += "Nhập Giá Bán Phải Lớn Hơn Giá Nhập \n";
                        }
                    } catch (Exception e) {
                    }

                    pst.setString(1, masp);
                    pst.setString(2, tensp);
                    pst.setString(3, soluong);
                    pst.setString(4, gianhap);
                    pst.setString(5, giaban);

                    int kq = pst.executeUpdate();
                    if (kq > 0) {
                        JOptionPane.showMessageDialog(this, "Thêm mới thành công !");
                        LoatBang_CTSP();
                        Xoatrang_CTSP();

                    }
                }
                conn.close();
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_jButton_ThemCTSPActionPerformed

    private void jButton_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_xoaActionPerformed
        // TODO add your handling code here:
        conn = cn.getConnection();
        try {
            // Tạo một đối tượng để thực hiện công việc
            String query = "DELETE FROM SanPham WHERE MaSP = '" + jTextField_masp1.getText() + "'";
            Statement st = conn.createStatement();
            int chk = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn xóa chứ !", "Thông báo", JOptionPane.YES_NO_OPTION);
            if (chk == JOptionPane.YES_NO_OPTION) {
                st.executeUpdate(query);
                Xoatrang_SP();
                JOptionPane.showMessageDialog(this, "Xóa thành công !");
            }
        } catch (Exception ex) {

            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton_xoaActionPerformed

    private void jButton_timkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_timkiemActionPerformed
        // TODO add your handling code here:
        conn = cn.getConnection();
        try {
            if (jTextField_tksanpham.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Nhập Tên sản phẩm cần tìm kiếm ");
            } else {
                String sql = "SELECT *FROM SanPham where TenSP like '%" + jTextField_tksanpham.getText() + "%' order by maSP desc";
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                tb1.setRowCount(0);
                while (rs.next()) {
                    Object personObject[] = {
                        rs.getString("maSP"),
                        rs.getString("tenSP"),
                        rs.getString("ngaynhap"),
                        rs.getString("tinhtrang"),};
                    tb1.addRow(personObject);
                    jTable_dssp.setModel(tb1);

                }
                rs.close();
                conn.close();
            }

        } catch (Exception e) {
        }

    }//GEN-LAST:event_jButton_timkiemActionPerformed

    private void jButton_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_themActionPerformed
        // TODO add your handling code here:
        conn = cn.getConnection();
        try {

            if (jTextField_masp1.getText().equals("") || jTextField_tensp1.getText().equals("") || jTextField_ngaynhap1.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Bạn Cần cập nhật đủ dữ liệu ");
                /*
            Đây là bẫy lỗi nhập thiếu dữ liệu
            cái đầu tiên là mã khách hàngvà tiếp theo lần lượt như bên CSDL
            Nếu như nó trống thì đưa ra thông báo ,ở sự kiện nút thêm
                 */
            } else {
                /*
                Nếu trên đã oke rồi thì bãy lỗi trùng khóa chính
                 */
                StringBuffer sb = new StringBuffer();
                String SQL_check_pk = "SELECT MaSP FROM SanPham WHERE MaSP = '" + jTextField_masp1.getText() + "'";
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(SQL_check_pk);
                if (rs.next()) {
                    sb.append("Mã Sản phẩm  đã bị trùng");
                }
                if (sb.length() > 0) { //Nếu if kia đúng nó xẽ thêm vào sb 1 đoạn String , kiểm tra độ dài chuỗi này nếu lớn hơn 0 tức là có thông báo thì 
                    JOptionPane.showConfirmDialog(this, sb.toString());
                    rs.close();
                } else {
                    /*
                    Nếu không thì 
                    thêm thì sẽ có 3 cách 
                    cách đơn giản nhất là 
                     */

                    String sql = "INSERT INTO SanPham VALUES(?,?,?,?)";
                    //6 dau ? tuong duong 6 bien vo dinh
                    // lan luot la 1 2 3 4 5 6
                    // tuong ung vi tri 1 la makh, vitri 2 la tenkh, 3 4 5 6 tuong tu

                    PreparedStatement pst = conn.prepareStatement(sql);
                    String masp = jTextField_masp1.getText();
                    String hoten = jTextField_tensp1.getText();
                    String ngaynhap = jTextField_ngaynhap1.getText();

                    String tinhtrang = jTextField_TT1.getText();
                    pst.setString(1, masp);
                    pst.setString(2, hoten);
                    pst.setString(3, ngaynhap);
                    pst.setString(4, tinhtrang);

                    int kq = pst.executeUpdate();
                    if (kq > 0) {
                        JOptionPane.showMessageDialog(this, "Thêm mới thành công !");
                        LoatBang_SP();
                        Xoatrang_SP();

                    }
                }
                conn.close();
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }//GEN-LAST:event_jButton_themActionPerformed

    private void jButton_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_suaActionPerformed
        // TODO add your handling code here:
        conn = cn.getConnection();
        try {

            if (jTextField_masp1.getText().equals("") || jTextField_tensp1.getText().equals("") || jTextField_ngaynhap1.getText().equals("") ||  jTextField_TT1.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Bạn Cần cập nhật đủ dữ liệu ");
            } else {
                String sql = "UPDATE SanPham SET TenSP =?, NgayNhap=?, Tinhtrang=? where MaSP=?";

                //1        2          3                   4        => vi tri
                PreparedStatement pst = conn.prepareStatement(sql);
                String MaSP = jTextField_masp1.getText();
                String TenSP = jTextField_tensp1.getText();
                String ngaynhap = jTextField_ngaynhap1.getText();
                String tinhtrang = jTextField_TT1.getText();
                pst.setString(4, MaSP);   // vi tri cua dau hoi cham                 
                pst.setString(1, TenSP);
                pst.setString(2, ngaynhap);
                pst.setString(3, tinhtrang);

                int kq = pst.executeUpdate();
                if (kq > 0) {
                    JOptionPane.showMessageDialog(this, "Cập nhật thành công !");
                    Xoatrang_SP();
                }
            }

            conn.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_jButton_suaActionPerformed

    private void jButton_ThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ThoatActionPerformed
        // TODO add your handling code here:
        jButton_Thoat.setToolTipText("Click để thoát chương trình ");
        int selected = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn thoát chương"
                + " trình không", "Thông báo", JOptionPane.YES_NO_OPTION);
        if (selected == JOptionPane.YES_NO_OPTION) {
            this.dispose();

        }
    }//GEN-LAST:event_jButton_ThoatActionPerformed

    private void jTable_dsspMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_dsspMouseClicked
        // TODO add your handling code here:
        int x = jTable_dssp.getSelectedRow();
        if (x >= 0) {
            jTextField_masp1.setText(jTable_dssp.getValueAt(x, 0) + "");
            jTextField_tensp1.setText(jTable_dssp.getValueAt(x, 1) + "");
            jTextField_ngaynhap1.setText(jTable_dssp.getValueAt(x, 2) + "");
            jTextField_TT1.setText(jTable_dssp.getValueAt(x, 3) + "");
            jTable_dssp.setEnabled(flase);
        }
    }//GEN-LAST:event_jTable_dsspMouseClicked

    private void jButton_ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ResetActionPerformed
        // TODO add your handling code here:
        jTextField_masp1.setText("");
        jTextField_tensp1.setText("");
        jTextField_ngaynhap1.setText("");
        jTextField_TT1.setText("");
        jTextField_tksanpham.setText("");
    }//GEN-LAST:event_jButton_ResetActionPerformed

    private void jButton_Reset1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Reset1ActionPerformed
        // TODO add your handling code here:
        jTextField_MaSP.setText("");
        jTextField_TenSP.setText("");
        jTextField_SLuong.setText("");
        jTextField_Gianhap.setText("");
        jTextField_Giaban.setText("");
        jTextField_TkCTsanpham.setText("");
        
    }//GEN-LAST:event_jButton_Reset1ActionPerformed

    private void jTable_DSsanpham2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_DSsanpham2MouseClicked
        // TODO add your handling code here:
        int x = jTable_DSsanpham2.getSelectedRow();
        if (x >= 0) {
            jTextField_MaSP.setText(jTable_DSsanpham2.getValueAt(x, 0) + "");
            jTextField_TenSP.setText(jTable_DSsanpham2.getValueAt(x, 1) + "");
            jTextField_SLuong.setText(jTable_DSsanpham2.getValueAt(x, 2) + "");
            jTextField_Gianhap.setText(jTable_DSsanpham2.getValueAt(x, 3) + "");
            jTextField_Giaban.setText(jTable_DSsanpham2.getValueAt(x, 4) + "");

            jTable_DSsanpham2.setEnabled(flase);
        }
    }//GEN-LAST:event_jTable_DSsanpham2MouseClicked

    private void jButton_timkiem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_timkiem2ActionPerformed
        // TODO add your handling code here:
        conn = cn.getConnection();
         try {
              if( jTextField_TkCTsanpham.getText().equals("")){
             JOptionPane.showMessageDialog(this,"Nhập Tên sản phẩm cần tìm kiếm ");
             }else{
           String sql = "SELECT *FROM CTSanPham where TenSP like '%" + jTextField_TkCTsanpham.getText() + "%' order by maSP desc";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            tb2.setRowCount(0);
            while (rs.next()) {
               Object personObject[] = {
                 
                    rs.getString("MaSP"),
                    rs.getString("TenSP"),
                    rs.getString("Soluong"),
                    rs.getString("Gianhap"),
                    rs.getString("Giaban"),};
                
                tb2.addRow(personObject);
                jTable_DSsanpham2.setModel(tb2);
                
              }
             rs.close();
           conn.close();
            }
          
        } catch (Exception e) {
        }
      
    }//GEN-LAST:event_jButton_timkiem2ActionPerformed

    private void jPanel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jPanel10MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SanphamForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SanphamForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SanphamForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SanphamForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SanphamForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton_Reset;
    private javax.swing.JButton jButton_Reset1;
    private javax.swing.JButton jButton_ThemCTSP;
    private javax.swing.JButton jButton_Thoat;
    private javax.swing.JButton jButton_XoaCTSP;
    private javax.swing.JButton jButton_sua;
    private javax.swing.JButton jButton_them;
    private javax.swing.JButton jButton_timkiem;
    private javax.swing.JButton jButton_timkiem2;
    private javax.swing.JButton jButton_xoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel_Giaban;
    private javax.swing.JLabel jLabel_Giaban1;
    private javax.swing.JLabel jLabel_Gianhap;
    private javax.swing.JLabel jLabel_MaSP;
    private javax.swing.JLabel jLabel_Soluong;
    private javax.swing.JLabel jLabel_Tensp;
    private javax.swing.JLabel jLabel_mahd1;
    private javax.swing.JLabel jLabel_masp;
    private javax.swing.JLabel jLabel_ngaynhap1;
    private javax.swing.JLabel jLabel_tensp;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_DSsanpham2;
    private javax.swing.JTable jTable_dssp;
    private javax.swing.JTextField jTextField_Giaban;
    private javax.swing.JTextField jTextField_Gianhap;
    private javax.swing.JTextField jTextField_MaSP;
    private javax.swing.JTextField jTextField_SLuong;
    private javax.swing.JTextField jTextField_TT1;
    private javax.swing.JTextField jTextField_TenSP;
    private javax.swing.JTextField jTextField_TkCTsanpham;
    private javax.swing.JTextField jTextField_masp1;
    private javax.swing.JTextField jTextField_ngaynhap1;
    private javax.swing.JTextField jTextField_tensp1;
    private javax.swing.JTextField jTextField_tksanpham;
    // End of variables declaration//GEN-END:variables
}
