/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package quanlybanhang.Fram;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import quanlybanhang.ConnectToSQLServer;

/**
 *
 * @author Admin
 */
public class HoaDonForm extends javax.swing.JFrame {
    final String header1[] = {"Mã HD", "Mã NV", "Mã KH", "Tên KH", "Ngày Lập", "Địa Chỉ","Tổng tiền "};
    final DefaultTableModel tb1 = new DefaultTableModel(header1, 0);

    final String header2[] = {"Mã HD", "Mã SP", "Tên SP", "giá bán", "Số lượng "};
    final DefaultTableModel tb2 = new DefaultTableModel(header2, 0);

    ConnectToSQLServer cn = new ConnectToSQLServer();
    Connection conn;
    private boolean flase;

    /**
     * Creates new form HoaDonForm
     */
    public HoaDonForm() {
        initComponents();
        setLocationRelativeTo(null);// hiển thị form ra giữa màn hình
        LoatBang_HD();
        LoatBang_CTHD();
       
    }

    public void LoatBang_HD(){
        try {
            conn = cn.getConnection();
            String sql = "SELECT *FROM  HoaDon order by mahd desc"
                    + "";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            tb1.setRowCount(0);
            while (rs.next()) {
               Object personObject[] = {
                   rs.getString("mahd"),
                   rs.getString("manv"),
                   rs.getString("makh"),
                   rs.getString("tenkh"),
                   rs.getString("ngaylap"),
                   rs.getString("dcgiaohang"),
                   rs.getInt("tongtien")
                };
                tb1.addRow(personObject);
                jTable_dsHD.setModel(tb1);
            }
            
           st.close();
           rs.close();
           conn.close();
        } catch (Exception e) {
        }
      jTable_dsHD.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
               if (jTable_dsHD.getSelectedRow()>=0){
                   jTextField_mahd.setText(jTable_dsHD.getValueAt(jTable_dsHD.getSelectedRow(), 0)+"");
                   jTextField_manv.setText(jTable_dsHD.getValueAt(jTable_dsHD.getSelectedRow(), 1)+"");
                   jTextField_makh.setText(jTable_dsHD.getValueAt(jTable_dsHD.getSelectedRow(), 2)+"");
                   jTextField_tenkh.setText(jTable_dsHD.getValueAt(jTable_dsHD.getSelectedRow(), 3)+"");
                   jTextField_ngaylap.setText(jTable_dsHD.getValueAt(jTable_dsHD.getSelectedRow(), 4)+"");
                   jTextField_dcgh.setText(jTable_dsHD.getValueAt(jTable_dsHD.getSelectedRow(), 5)+"");
                    jTextField_Tongtien.setText(jTable_dsHD.getValueAt(jTable_dsHD.getSelectedRow(), 6)+"");
               }
            }
        });
    }
    
    public void LoatBang_CTHD(){
        try {
            conn = cn.getConnection();
            String sql = "SELECT *FROM  CTHoaDon"//order by mahd desc
                    + "";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            tb2.setRowCount(0);
            while (rs.next()) {
               Object personObject[] = {
                    rs.getString("mahd"),
                    rs.getString("masp"),
                    rs.getString("tensp"),
                    rs.getFloat("giaban"),
                    rs.getInt("soluong")
                };
                tb2.addRow(personObject);
                jTable_dsCTHD.setModel(tb2);
            }
            
           st.close();
           rs.close();
           conn.close();
        } catch (Exception e) {
        }
        jTable_dsCTHD.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
               if (jTable_dsCTHD.getSelectedRow()>=0){
                  jTextField_mahd2.setText(jTable_dsCTHD.getValueAt(jTable_dsCTHD.getSelectedRow(), 0)+"");
                   jTextField_masp2.setText(jTable_dsCTHD.getValueAt(jTable_dsCTHD.getSelectedRow(), 1)+"");
                   jTextField_Tensp2.setText(jTable_dsCTHD.getValueAt(jTable_dsCTHD.getSelectedRow(), 2)+"");
                   jTextField_gia2.setText(jTable_dsCTHD.getValueAt(jTable_dsCTHD.getSelectedRow(), 3)+"");
                   jTextField_sl2.setText(jTable_dsCTHD.getValueAt(jTable_dsCTHD.getSelectedRow(), 4)+"");
                   
               }
            }
        });
    }
// Hàm này xẽ xóa trắng sau khi thêm sửa xóa
    private void Xoatrang_HD(){
        jTextField_mahd.setText("");
        jTextField_manv.setText("");
        jTextField_makh.setText("");
       jTextField_tenkh.setText("");
        jTextField_ngaylap.setText("");
        jTextField_dcgh.setText("");
         jTextField_Tongtien.setText("");
        LoatBang_HD();
        jTextField_mahd.setEnabled(true);
       
    }
   
// Hàm này xẽ xóa trắng sau khi thêm sửa xóa
    private void Xoatrang_CTHD(){
        jTextField_mahd2.setText("");
        jTextField_masp2.setText("");
       jTextField_Tensp2.setText("");
       jTextField_gia2.setText("");
        jTextField_sl2.setText("");
        LoatBang_CTHD();
        jTextField_mahd2.setEnabled(true);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel11 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel_ngaylap = new javax.swing.JLabel();
        jLabel_tenkh = new javax.swing.JLabel();
        jTextField_ngaylap = new javax.swing.JTextField();
        jLabel_makh = new javax.swing.JLabel();
        jLabel_mahd = new javax.swing.JLabel();
        jTextField_manv = new javax.swing.JTextField();
        jButton13 = new javax.swing.JButton();
        jTextField_makh = new javax.swing.JTextField();
        jTextField_tenkh = new javax.swing.JTextField();
        jLabel_dcgh = new javax.swing.JLabel();
        jTextField_dcgh = new javax.swing.JTextField();
        jLabel_manv = new javax.swing.JLabel();
        jTextField_mahd = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jButton_themHD = new javax.swing.JButton();
        jButton_xoahd = new javax.swing.JButton();
        jButton_suahd = new javax.swing.JButton();
        jButton_Reset = new javax.swing.JButton();
        jLabel_ngaylap1 = new javax.swing.JLabel();
        jTextField_Tongtien = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel_SL = new javax.swing.JLabel();
        jTextField_gia2 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField_sl2 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jTextField_masp2 = new javax.swing.JTextField();
        jTextField_mahd2 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jButton_themCTHD = new javax.swing.JButton();
        jButton_XoaCTHD = new javax.swing.JButton();
        jButton_Reset2 = new javax.swing.JButton();
        jTextField_Tensp2 = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_dsCTHD = new javax.swing.JTable();
        jButton_TimKiemCTHD = new javax.swing.JButton();
        jTextField_mahd3 = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jButton_thoathd = new javax.swing.JButton();
        jButton_TimKiem = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_dsHD = new javax.swing.JTable();
        jTextField_manv1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("QUẢN LÝ HÓA ĐƠN");

        jPanel11.setBackground(new java.awt.Color(0, 204, 204));

        jPanel10.setBackground(new java.awt.Color(204, 204, 204));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nhập thông tin hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18))); // NOI18N
        jPanel10.setToolTipText("QUẢN LÝ KHÁCH HÀNG");

        jLabel_ngaylap.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel_ngaylap.setText("Ngày lập:");

        jLabel_tenkh.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel_tenkh.setText("Tên KH :");

        jTextField_ngaylap.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel_makh.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel_makh.setText("Mã KH :");

        jLabel_mahd.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel_mahd.setText("Mã HĐ :");

        jTextField_manv.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jButton13.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton13.setText("Thêm");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTextField_makh.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jTextField_tenkh.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel_dcgh.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel_dcgh.setText("Địa chỉ giao hàng");

        jTextField_dcgh.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel_manv.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel_manv.setText("Mã NV :");

        jTextField_mahd.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18))); // NOI18N

        jButton_themHD.setBackground(new java.awt.Color(255, 153, 153));
        jButton_themHD.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton_themHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlybanhang/Fram/HinhAnh/themkhachhang-25.png"))); // NOI18N
        jButton_themHD.setText("Thêm HĐ");
        jButton_themHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_themHDActionPerformed(evt);
            }
        });

        jButton_xoahd.setBackground(new java.awt.Color(255, 153, 153));
        jButton_xoahd.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton_xoahd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlybanhang/Fram/HinhAnh/xoa-25.png"))); // NOI18N
        jButton_xoahd.setText("Xóa HĐ");
        jButton_xoahd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_xoahdActionPerformed(evt);
            }
        });

        jButton_suahd.setBackground(new java.awt.Color(255, 153, 153));
        jButton_suahd.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton_suahd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlybanhang/Fram/HinhAnh/sua-25.png"))); // NOI18N
        jButton_suahd.setText("Sửa HĐ");
        jButton_suahd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_suahdActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton_xoahd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_themHD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_Reset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButton_suahd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jButton_themHD, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jButton_suahd, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButton_xoahd, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButton_Reset, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel_ngaylap1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel_ngaylap1.setText("Tổng tiền: ");

        jTextField_Tongtien.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_manv)
                            .addComponent(jLabel_mahd)
                            .addComponent(jLabel_ngaylap)
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel_makh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel_tenkh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel_dcgh))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel_ngaylap1)))
                .addGap(49, 49, 49)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jTextField_Tongtien, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField_makh, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField_tenkh, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField_manv, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField_mahd, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jTextField_ngaylap, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField_dcgh, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58))))
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                    .addContainerGap(429, Short.MAX_VALUE)
                    .addComponent(jButton13)
                    .addGap(116, 116, 116)))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jTextField_mahd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField_manv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel_mahd)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel_manv)))
                .addGap(26, 26, 26)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_makh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_makh))
                .addGap(29, 29, 29)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_tenkh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_tenkh))
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel_ngaylap))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jTextField_ngaylap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jTextField_dcgh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel_dcgh)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_ngaylap1)
                    .addComponent(jTextField_Tongtien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel10Layout.createSequentialGroup()
                    .addGap(69, 69, 69)
                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(297, Short.MAX_VALUE)))
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi tiết hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel8.setText("Tên Sản phẩm :");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel9.setText("Giá bán :");

        jLabel_SL.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel_SL.setText("Số lượng:");

        jTextField_gia2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel12.setText("(VNĐ)");

        jTextField_sl2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel17.setText("Mã HĐ :");

        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel18.setText("Mã SP :");

        jTextField_masp2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jTextField_mahd2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextField_mahd2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_mahd2ActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18))); // NOI18N

        jButton_themCTHD.setBackground(new java.awt.Color(255, 153, 153));
        jButton_themCTHD.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton_themCTHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlybanhang/Fram/HinhAnh/themkhachhang-25.png"))); // NOI18N
        jButton_themCTHD.setText("Thêm");
        jButton_themCTHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_themCTHDActionPerformed(evt);
            }
        });

        jButton_XoaCTHD.setBackground(new java.awt.Color(255, 153, 153));
        jButton_XoaCTHD.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton_XoaCTHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlybanhang/Fram/HinhAnh/xoa-25.png"))); // NOI18N
        jButton_XoaCTHD.setText("Xóa");
        jButton_XoaCTHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_XoaCTHDActionPerformed(evt);
            }
        });

        jButton_Reset2.setBackground(new java.awt.Color(255, 153, 153));
        jButton_Reset2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton_Reset2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\OneDrive\\Tài liệu\\NetBeansProjects\\QLBanHang\\src\\qlbanhang\\HinhAnh\\refresh-25.png")); // NOI18N
        jButton_Reset2.setText("Reset");
        jButton_Reset2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Reset2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton_Reset2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_XoaCTHD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_themCTHD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton_themCTHD, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jButton_XoaCTHD, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(jButton_Reset2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTextField_Tensp2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jPanel9.setBackground(new java.awt.Color(204, 204, 204));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18))); // NOI18N

        jTable_dsCTHD.setBackground(new java.awt.Color(204, 204, 204));
        jTable_dsCTHD.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTable_dsCTHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã HĐ", "Tên SP", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_dsCTHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_dsCTHDMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable_dsCTHD);
        if (jTable_dsCTHD.getColumnModel().getColumnCount() > 0) {
            jTable_dsCTHD.getColumnModel().getColumn(0).setResizable(false);
            jTable_dsCTHD.getColumnModel().getColumn(1).setResizable(false);
            jTable_dsCTHD.getColumnModel().getColumn(2).setResizable(false);
            jTable_dsCTHD.getColumnModel().getColumn(3).setResizable(false);
            jTable_dsCTHD.getColumnModel().getColumn(5).setResizable(false);
        }

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton_TimKiemCTHD.setBackground(new java.awt.Color(255, 153, 153));
        jButton_TimKiemCTHD.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton_TimKiemCTHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlybanhang/Fram/HinhAnh/search-icon-32.png"))); // NOI18N
        jButton_TimKiemCTHD.setText("Tìm kiếm");
        jButton_TimKiemCTHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_TimKiemCTHDActionPerformed(evt);
            }
        });

        jTextField_mahd3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextField_mahd3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_mahd3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel_SL)
                        .addGap(82, 82, 82)
                        .addComponent(jTextField_sl2))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(86, 86, 86)
                        .addComponent(jTextField_gia2))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(24, 24, 24)
                        .addComponent(jTextField_Tensp2))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel17))
                        .addGap(89, 89, 89)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jTextField_mahd2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jTextField_masp2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addGap(104, 104, 104)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(jTextField_mahd3, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jButton_TimKiemCTHD))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(jTextField_mahd2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(jTextField_masp2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jTextField_Tensp2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_gia2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_sl2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_SL))
                        .addGap(117, 117, 117))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton_TimKiemCTHD, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_mahd3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        jPanel13.setBackground(new java.awt.Color(153, 255, 255));

        jLabel16.setBackground(new java.awt.Color(0, 153, 153));
        jLabel16.setFont(new java.awt.Font("Sitka Display", 1, 48)); // NOI18N
        jLabel16.setText("QUẢN LÝ HÓA ĐƠN");

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlybanhang/Fram/HinhAnh/document.png"))); // NOI18N

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addGap(417, 417, 417)
                .addComponent(jLabel19)
                .addGap(44, 44, 44)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        jButton_thoathd.setBackground(new java.awt.Color(255, 153, 153));
        jButton_thoathd.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jButton_thoathd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlybanhang/Fram/HinhAnh/logout-icon-32.png"))); // NOI18N
        jButton_thoathd.setText("Thoát");
        jButton_thoathd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_thoathdActionPerformed(evt);
            }
        });

        jButton_TimKiem.setBackground(new java.awt.Color(255, 153, 153));
        jButton_TimKiem.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton_TimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlybanhang/Fram/HinhAnh/search-icon-32.png"))); // NOI18N
        jButton_TimKiem.setText("Tìm kiếm");
        jButton_TimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_TimKiemActionPerformed(evt);
            }
        });

        jPanel8.setBackground(new java.awt.Color(204, 204, 204));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18))); // NOI18N

        jTable_dsHD.setBackground(new java.awt.Color(204, 204, 204));
        jTable_dsHD.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTable_dsHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã HD", "Mã  NV", "Mã KH", "Tên KH ", "Ngày Lập", "DC_giao_hàng", "Tổng tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_dsHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_dsHDMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_dsHD);
        if (jTable_dsHD.getColumnModel().getColumnCount() > 0) {
            jTable_dsHD.getColumnModel().getColumn(0).setResizable(false);
            jTable_dsHD.getColumnModel().getColumn(1).setResizable(false);
            jTable_dsHD.getColumnModel().getColumn(2).setResizable(false);
            jTable_dsHD.getColumnModel().getColumn(3).setResizable(false);
            jTable_dsHD.getColumnModel().getColumn(4).setResizable(false);
            jTable_dsHD.getColumnModel().getColumn(5).setResizable(false);
            jTable_dsHD.getColumnModel().getColumn(6).setResizable(false);
        }

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jTextField_manv1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jButton_TimKiem)
                        .addGap(55, 55, 55)
                        .addComponent(jTextField_manv1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(730, 730, 730))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(534, 534, 534)
                        .addComponent(jButton_thoathd, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_thoathd, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_manv1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 1567, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_themHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_themHDActionPerformed
        // TODO add your handling code here:
         conn = cn.getConnection();
        try {
            if(jTextField_mahd.getText().equals("") || jTextField_manv.getText().equals("")||jTextField_makh.getText().equals("") ||jTextField_tenkh.getText().equals("") 
                    ||jTextField_ngaylap.getText().equals("") || jTextField_dcgh.getText().equals("") ||jTextField_Tongtien.getText().equals("") ){
             JOptionPane.showMessageDialog(this,"Bạn Cần cập nhật đủ dữ liệu ");
             }else{
                StringBuffer sb = new StringBuffer();
                String SQL_check_pk="SELECT MaHD FROM HoaDon WHERE MaHD = '"+jTextField_mahd.getText()+"'";
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(SQL_check_pk);
                if(rs.next()){
                    sb.append("Mã khách hàng đã bị trùng");
                }
                if(sb.length()>0){ //Nếu if kia đúng nó xẽ thêm vào sb 1 đoạn String , kiểm tra độ dài chuỗi này nếu lớn hơn 0 tức là có thông báo thì 
                    JOptionPane.showConfirmDialog(this,sb.toString());
                    rs.close();
                }else{
                   String sql = "INSERT INTO HoaDon VALUES(?,?,?,?,?,?,?)";
                   PreparedStatement pst = conn.prepareStatement(sql);
                   String mahd = jTextField_mahd.getText();                   
                   String manv = jTextField_manv.getText();
                   String makh = jTextField_makh.getText();
                   String tenkh = jTextField_tenkh.getText();
                   String ngaylap = jTextField_ngaylap.getText();
                   String diachi = jTextField_dcgh.getText();
                   String tongtien = jTextField_Tongtien.getText();
                   pst.setString(1, mahd);                   
                   pst.setString(2, manv);
                   pst.setString(3, makh);
                   pst.setString(4, tenkh);
                   pst.setString(5, ngaylap);
                   pst.setString(6, diachi);
                   pst.setString(7, tongtien);
                   int kq = pst.executeUpdate();
                   if(kq>0){
                       JOptionPane.showMessageDialog(this, "Thêm mới thành công !");
                       LoatBang_HD();
                       Xoatrang_HD();
                           
                   }
                }
            conn.close();
        }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_jButton_themHDActionPerformed

    private void jButton_thoathdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_thoathdActionPerformed
        // TODO add your handling code here:
          jButton_thoathd.setToolTipText("Click để thoát chương trình ");
        int selected = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn thoát chương"
            + " trình không", "Thông báo", JOptionPane.YES_NO_OPTION);
        if (selected == JOptionPane.YES_NO_OPTION) {
            this.dispose();

        }
    }//GEN-LAST:event_jButton_thoathdActionPerformed

    private void jButton_TimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_TimKiemActionPerformed
        // TODO add your handling code here:
           conn = cn.getConnection();
         try {
              if( jTextField_manv1.getText().equals("")){
             JOptionPane.showMessageDialog(this,"Nhập Mã nhân viên cần tìm kiếm ");
             }else{
            String sql = "SELECT *FROM HoaDon where MaNV like '%"+jTextField_manv1.getText()+"%' order by mahd desc";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            tb1.setRowCount(0);
            while (rs.next()) {
               Object personObject[] = {
                 rs.getString("mahd"),
                    rs.getString("manv"),
                    rs.getString("makh"),
                    rs.getString("tenkh"),
                    rs.getString("ngaylap"),
                    rs.getString("dcgiaohang"),
                    rs.getString("tongtien")
                };
                tb1.addRow(personObject);
                jTable_dsHD.setModel(tb1);
                
              }
             rs.close();
           conn.close();
            }
          
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton_TimKiemActionPerformed

    private void jButton_xoahdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_xoahdActionPerformed

         conn=cn.getConnection();
        try {
            // Tạo một đối tượng để thực hiện công việc
             String query = "DELETE FROM HoaDon WHERE MaHD = '" + jTextField_mahd.getText() + "'";
            Statement st = conn.createStatement();
            int chk = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn xóa chứ !","Thông báo",JOptionPane.YES_NO_OPTION);
            if(chk==JOptionPane.YES_NO_OPTION){
                st.executeUpdate(query);
                Xoatrang_HD();
                JOptionPane.showMessageDialog(this, "Xóa thành công !");
            }
        } catch (Exception ex) {

            ex.printStackTrace();
        }
        
    }//GEN-LAST:event_jButton_xoahdActionPerformed

    private void jButton_themCTHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_themCTHDActionPerformed
        // TODO add your handling code here:
        conn = cn.getConnection();
        try {
            if (jTextField_mahd2.getText().equals("") || jTextField_masp2.getText().equals("") || jTextField_Tensp2.getText().equals("")
                    || jTextField_sl2.getText().equals("") || jTextField_gia2.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Bạn Cần cập nhật đủ dữ liệu ");
            } else {

                /*
                Nếu trên đã oke rồi thì bãy lỗi trùng khóa chính
                 */
                StringBuffer sb = new StringBuffer();
                String SQL_check_pk = "SELECT MaHD FROM CTHoaDon WHERE MaHD = '" + jTextField_mahd2.getText() + "'";
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(SQL_check_pk);
                if (rs.next()) {
                    sb.append("Mã hóa đơn  đã bị trùng");
                }
                if (sb.length() > 0) { //Nếu if kia đúng nó xẽ thêm vào sb 1 đoạn String , kiểm tra độ dài chuỗi này nếu lớn hơn 0 tức là có thông báo thì 
                    JOptionPane.showConfirmDialog(this, sb.toString());
                    rs.close();
                } else {
                    String sql = "INSERT INTO CTHoaDon VALUES(?,?,?,?,?)";
                    PreparedStatement pst = conn.prepareStatement(sql);
                    String mahd = jTextField_mahd2.getText();
                    String masp = jTextField_masp2.getText();
                    String tensp = jTextField_Tensp2.getText();
                    // XUử lý số lượng (chưa lmf dc )
                    String soluong = jTextField_sl2.getText();
                    try {
                        int bien = Integer.valueOf(soluong);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Số lượng phải nhập Bằng số ");
                        //ThongBao += "Số lượng phải nhập Bằng số" + "\n";
                    }

                    String giaban = jTextField_gia2.getText();
                    try {
                        int bien = Integer.valueOf(giaban);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Giá bán phải là số");
                        //ThongBao+="Giá Bán Phải là số !\n";
                    }

                    pst.setString(1, mahd);
                    pst.setString(2, masp);
                    pst.setString(3, tensp);
                    pst.setString(4, giaban);
                    pst.setString(5, soluong);

                    int kq = pst.executeUpdate();
                    if (kq > 0) {
                        JOptionPane.showMessageDialog(this, "Thêm mới thành công !");
                        LoatBang_CTHD();
                        Xoatrang_CTHD();
                    }
                }
                conn.close();
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_jButton_themCTHDActionPerformed

    private void jButton_XoaCTHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_XoaCTHDActionPerformed
        // TODO add your handling code here:
         conn=cn.getConnection();
        try {
            // Tạo một đối tượng để thực hiện công việc
             String query = "DELETE FROM CTHoaDon WHERE MaHD = '" + jTextField_mahd2.getText() + "'";
            Statement st = conn.createStatement();
            int chk = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn xóa chứ !","Thông báo",JOptionPane.YES_NO_OPTION);
            if(chk==JOptionPane.YES_NO_OPTION){
                st.executeUpdate(query);
                Xoatrang_CTHD();
                JOptionPane.showMessageDialog(this, "Xóa thành công !");
            }
        } catch (Exception ex) {

            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton_XoaCTHDActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton_suahdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_suahdActionPerformed
        conn = cn.getConnection();
        try {
           
            if(jTextField_mahd.getText().equals("") || jTextField_manv.getText().equals("")||jTextField_makh.getText().equals("") ||jTextField_tenkh.getText().equals("") 
                    ||jTextField_ngaylap.getText().equals("") || jTextField_dcgh.getText().equals("") || jTextField_Tongtien.getText().equals("")) {
             JOptionPane.showMessageDialog(this,"Bạn Cần cập nhật đủ dữ liệu ");
             }else{
                String sql = "UPDATE HoaDon SET manv =?, makh=?, tenkh=?, ngaylap=?, dcgiaohang=?, tongtien= ? where mahd=?";
                         
              //1        2          3      4         5            6 => vi tri
                PreparedStatement pst = conn.prepareStatement(sql);
                   String mahd = jTextField_mahd.getText();                   
                   String manv = jTextField_manv.getText();
                   String makh = jTextField_makh.getText();
                   String tenkh = jTextField_tenkh.getText();
                   String ngaylap = jTextField_ngaylap.getText();
                   String diachi = jTextField_dcgh.getText();
                   String tongtien = jTextField_Tongtien.getText();
                   
                   pst.setString(7, mahd);                   
                   pst.setString(1, manv);
                   pst.setString(2, makh);
                   pst.setString(3, tenkh);
                   pst.setString(4, ngaylap);
                   pst.setString(5, diachi);
                    pst.setString(6, tongtien);
                   int kq = pst.executeUpdate();
                    if(kq>0){
                    JOptionPane.showMessageDialog(this, "Cập nhật thành công !");
                    Xoatrang_HD();
                 }
             }
             
            conn.close();
        
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
                                   
    }//GEN-LAST:event_jButton_suahdActionPerformed

    private void jButton_ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ResetActionPerformed
        // TODO add your handling code here:
        jTextField_mahd.setText("");
        jTextField_manv.setText("");
        jTextField_makh.setText("");
        jTextField_tenkh.setText("");
        jTextField_ngaylap.setText("");
        jTextField_dcgh.setText("");
        jTextField_Tongtien.setText("");
    }//GEN-LAST:event_jButton_ResetActionPerformed

    private void jTextField_mahd2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_mahd2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_mahd2ActionPerformed

    private void jButton_TimKiemCTHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_TimKiemCTHDActionPerformed
        // TODO add your handling code here:
          conn = cn.getConnection();
         try {
              if( jTextField_mahd3.getText().equals("")){
             JOptionPane.showMessageDialog(this,"Nhập Mã hóa đơn cần tìm kiếm ");
             }else{
            String sql = "SELECT *FROM CTHoaDon where MaHD like '%"+jTextField_mahd3.getText()+"%' order by mahd desc";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            tb2.setRowCount(0);
            while (rs.next()) {
               Object personObject[] = {
                 rs.getString("mahd"),
                    rs.getString("masp"),
                    rs.getString("tensp"),
                    rs.getString("giaban"),
                    rs.getString("soluong")
                };
                tb2.addRow(personObject);
                jTable_dsCTHD.setModel(tb2);
                
              }
             rs.close();
           conn.close();
            }
          
        } catch (Exception e) {
        }
       
    }//GEN-LAST:event_jButton_TimKiemCTHDActionPerformed

    private void jButton_Reset2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Reset2ActionPerformed
        // TODO add your handling code here:
        jTextField_mahd2.setText("");
        jTextField_masp2.setText("");
        jTextField_sl2.setText("");
        jTextField_gia2.setText("");
        jTextField_Tensp2.setText("");
    }//GEN-LAST:event_jButton_Reset2ActionPerformed

    private void jTable_dsCTHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_dsCTHDMouseClicked
        // TODO add your handling code here:
        int x = jTable_dsCTHD.getSelectedRow();
        if(x>=0){
            jTextField_mahd2.setText(jTable_dsCTHD.getValueAt(x, 0)+"");
            jTextField_masp2.setText(jTable_dsCTHD.getValueAt(x, 1)+"");
            jTextField_sl2.setText(jTable_dsCTHD.getValueAt(x, 4)+"");
            jTextField_gia2.setText(jTable_dsCTHD.getValueAt(x, 3)+"");            
 
            jTextField_mahd.setEnabled(flase);
        }
    }//GEN-LAST:event_jTable_dsCTHDMouseClicked

    private void jTable_dsHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_dsHDMouseClicked
        // TODO add your handling code here:
        int x = jTable_dsHD.getSelectedRow();
        if (x >= 0) {
            jTextField_mahd.setText(jTable_dsHD.getValueAt(x, 0) + "");
            jTextField_manv.setText(jTable_dsHD.getValueAt(x, 1) + "");
            jTextField_makh.setText(jTable_dsHD.getValueAt(x, 2) + "");
            jTextField_tenkh.setText(jTable_dsHD.getValueAt(x, 3) + "");
            jTextField_ngaylap.setText(jTable_dsHD.getValueAt(x, 4) + "");
            jTextField_dcgh.setText(jTable_dsHD.getValueAt(x, 5) + "");
            jTextField_Tongtien.setText(jTable_dsHD.getValueAt(x, 6) + "");
            jTextField_mahd.setEnabled(flase);
        }
    }//GEN-LAST:event_jTable_dsHDMouseClicked

    private void jTextField_mahd3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_mahd3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_mahd3ActionPerformed

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
            java.util.logging.Logger.getLogger(HoaDonForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HoaDonForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HoaDonForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HoaDonForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HoaDonForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton_Reset;
    private javax.swing.JButton jButton_Reset2;
    private javax.swing.JButton jButton_TimKiem;
    private javax.swing.JButton jButton_TimKiemCTHD;
    private javax.swing.JButton jButton_XoaCTHD;
    private javax.swing.JButton jButton_suahd;
    private javax.swing.JButton jButton_themCTHD;
    private javax.swing.JButton jButton_themHD;
    private javax.swing.JButton jButton_thoathd;
    private javax.swing.JButton jButton_xoahd;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_SL;
    private javax.swing.JLabel jLabel_dcgh;
    private javax.swing.JLabel jLabel_mahd;
    private javax.swing.JLabel jLabel_makh;
    private javax.swing.JLabel jLabel_manv;
    private javax.swing.JLabel jLabel_ngaylap;
    private javax.swing.JLabel jLabel_ngaylap1;
    private javax.swing.JLabel jLabel_tenkh;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_dsCTHD;
    private javax.swing.JTable jTable_dsHD;
    private javax.swing.JTextField jTextField_Tensp2;
    private javax.swing.JTextField jTextField_Tongtien;
    private javax.swing.JTextField jTextField_dcgh;
    private javax.swing.JTextField jTextField_gia2;
    private javax.swing.JTextField jTextField_mahd;
    private javax.swing.JTextField jTextField_mahd2;
    private javax.swing.JTextField jTextField_mahd3;
    private javax.swing.JTextField jTextField_makh;
    private javax.swing.JTextField jTextField_manv;
    private javax.swing.JTextField jTextField_manv1;
    private javax.swing.JTextField jTextField_masp2;
    private javax.swing.JTextField jTextField_ngaylap;
    private javax.swing.JTextField jTextField_sl2;
    private javax.swing.JTextField jTextField_tenkh;
    // End of variables declaration//GEN-END:variables
}
