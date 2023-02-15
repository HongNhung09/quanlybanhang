/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package quanlybanhang.Fram;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicListUI;
import javax.swing.table.DefaultTableModel;
import jdk.nashorn.internal.runtime.regexp.joni.Config;
import quanlybanhang.ConnectToSQLServer;
import static quanlybanhang.ConnectToSQLServer.getConnection;
import quanlybanhang.KhachHang;


/**
 *
 * @author Admin
 */
public class KhachHangForm extends javax.swing.JFrame {

    final String header []={ "Mã KH","Tên KH","Email","Giới tính","SDT","Địa Chỉ"};
    final DefaultTableModel tb = new DefaultTableModel(header,0);
    ConnectToSQLServer cn = new ConnectToSQLServer();
    Connection conn;
    private boolean flase;
    /**
     * Creates new form NhanVienForm
     */
    public KhachHangForm() {
        initComponents();
         setLocationRelativeTo(null);// hiển thị form ra giữa màn hình
        LoatBang();
       // automakh();
       
    }
  /*  // HIỂN THỊ MÃ KHÁCH HÀNG TỰ ĐỘNG
    public void automakh() {
        String sql = "SELECT TOP 1 makh FROM khachhang ORDER BY makh DESC";
        conn = cn.getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                String rnno = rs.getString("makh");
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
                
                jTextFieldmakh.setText(ftxt);
                jTextFieldmakh.setEnabled(false);                
            } else {
            }
        } catch (Exception e) {
            System.out.println("SV: " + e.toString());
        }
    }*/
    
    public void LoatBang(){
        try {
            conn = cn.getConnection();
            String sql = "SELECT *FROM KhachHang order by makh desc"
                    + "";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            tb.setRowCount(0);
            while (rs.next()) {
               Object personObject[] = {
                    rs.getString("makh"),
                    rs.getString("tenkh"),
                    rs.getString("email"),
                    rs.getString("gioitinh"),
                    rs.getString("sdt"),
                    rs.getString("diachi")
                };
                tb.addRow(personObject);
                jTable_Khachhang.setModel(tb);
            }
            
           st.close();
           rs.close();
           conn.close();
        } catch (Exception e) {
        }
   
        jTable_Khachhang.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
               if (jTable_Khachhang.getSelectedRow()>=0){
                   jTextFieldmakh.setText(jTable_Khachhang.getValueAt(jTable_Khachhang.getSelectedRow(), 0)+"");
                   jTextField_tenkh.setText(jTable_Khachhang.getValueAt(jTable_Khachhang.getSelectedRow(), 1)+"");
                   jTextField_Email.setText(jTable_Khachhang.getValueAt(jTable_Khachhang.getSelectedRow(), 2)+"");
                   //jTextFieldmakh.setText(jTable_Khachhang.getValueAt(jTable_Khachhang.getSelectedRow(), 3)+"");
                   jTextField_SDT.setText(jTable_Khachhang.getValueAt(jTable_Khachhang.getSelectedRow(), 4)+"");
                   jTextField_DiaChi.setText(jTable_Khachhang.getValueAt(jTable_Khachhang.getSelectedRow(), 5)+"");
               }
            }
        });
    }
// Hàm này xẽ xóa trắng sau khi thêm sửa xóa
    private void Xoatrang(){
        jTextFieldmakh.setText("");
        jTextField_tenkh.setText("");
        jTextField_Email.setText("");
       // jTextFieldmakh.setText("");
        jTextField_SDT.setText("");
        jTextField_DiaChi.setText("");
        LoatBang();
        jTextFieldmakh.setEnabled(true);
        //sau khi them thanh cong thi tu load ma moi luon
       // automakh();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu1 = new java.awt.PopupMenu();
        jProgressBar1 = new javax.swing.JProgressBar();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel_TenKH = new javax.swing.JLabel();
        jTextField_tenkh = new javax.swing.JTextField();
        jLabel_Email = new javax.swing.JLabel();
        jLabel_sdt = new javax.swing.JLabel();
        jTextField_Email = new javax.swing.JTextField();
        jLabel_gioitinh = new javax.swing.JLabel();
        jLabel_diachi = new javax.swing.JLabel();
        jTextField_SDT = new javax.swing.JTextField();
        jLabel_makh = new javax.swing.JLabel();
        jTextFieldmakh = new javax.swing.JTextField();
        jRadioButton_Nam = new javax.swing.JRadioButton();
        jRadioButton_Nu = new javax.swing.JRadioButton();
        jButton4 = new javax.swing.JButton();
        jTextField_DiaChi = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jButton_Reset = new javax.swing.JButton();
        jButton_XoaKH = new javax.swing.JButton();
        jButton_suakh = new javax.swing.JButton();
        jButton_ThemKH = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Khachhang = new javax.swing.JTable();
        jButton_Thoat = new javax.swing.JButton();
        jButton_Timkiem = new javax.swing.JButton();
        jTextField_tenkh1 = new javax.swing.JTextField();

        popupMenu1.setEnabled(false);
        popupMenu1.setLabel("popupMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("QUẢN LÝ KHÁCH HÀNG");
        setBackground(new java.awt.Color(0, 153, 153));
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(153, 255, 255));

        jLabel1.setBackground(new java.awt.Color(0, 153, 153));
        jLabel1.setFont(new java.awt.Font("Sitka Display", 1, 36)); // NOI18N
        jLabel1.setText("QUẢN LÝ KHÁCH HÀNG");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlybanhang/Fram/HinhAnh/customer-service-man-like.png"))); // NOI18N
        jLabel8.setText("jLabel8");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(331, 331, 331)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))))
        );

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nhập thông tin khách hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 14))); // NOI18N
        jPanel3.setToolTipText("QUẢN LÝ KHÁCH HÀNG");

        jLabel_TenKH.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel_TenKH.setText("Tên KH :");

        jTextField_tenkh.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel_Email.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel_Email.setText("Email : ");

        jLabel_sdt.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel_sdt.setText("Số điện thoại :");

        jTextField_Email.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel_gioitinh.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel_gioitinh.setText("Giới tính:");

        jLabel_diachi.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel_diachi.setText("Địa chỉ :");

        jTextField_SDT.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTextField_SDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_SDTActionPerformed(evt);
            }
        });

        jLabel_makh.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel_makh.setText("Mã KH :");

        jTextFieldmakh.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        buttonGroup1.add(jRadioButton_Nam);
        jRadioButton_Nam.setText("Nam");
        jRadioButton_Nam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_NamActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton_Nu);
        jRadioButton_Nu.setSelected(true);
        jRadioButton_Nu.setText("Nữ");
        jRadioButton_Nu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_NuActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton4.setText("Thêm");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTextField_DiaChi.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chức năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18))); // NOI18N

        jButton_Reset.setBackground(new java.awt.Color(255, 153, 153));
        jButton_Reset.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton_Reset.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\OneDrive\\Tài liệu\\NetBeansProjects\\QLBanHang\\src\\qlbanhang\\HinhAnh\\refresh-25.png")); // NOI18N
        jButton_Reset.setText("Reset");
        jButton_Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ResetActionPerformed(evt);
            }
        });

        jButton_XoaKH.setBackground(new java.awt.Color(255, 153, 153));
        jButton_XoaKH.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton_XoaKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlybanhang/Fram/HinhAnh/xoa-25.png"))); // NOI18N
        jButton_XoaKH.setText("XóaKH");
        jButton_XoaKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_XoaKHActionPerformed(evt);
            }
        });

        jButton_suakh.setBackground(new java.awt.Color(255, 153, 153));
        jButton_suakh.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton_suakh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlybanhang/Fram/HinhAnh/sua-25.png"))); // NOI18N
        jButton_suakh.setText("SửaKH");
        jButton_suakh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_suakhActionPerformed(evt);
            }
        });

        jButton_ThemKH.setBackground(new java.awt.Color(255, 153, 153));
        jButton_ThemKH.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton_ThemKH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlybanhang/Fram/HinhAnh/themkhachhang-25.png"))); // NOI18N
        jButton_ThemKH.setText("ThêmKH");
        jButton_ThemKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ThemKHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton_Reset, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jButton_XoaKH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_suakh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton_ThemKH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jButton_ThemKH, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jButton_suakh, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(jButton_XoaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jButton_Reset, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel_sdt)
                        .addGap(23, 23, 23)
                        .addComponent(jTextField_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(137, 137, 137)
                                .addComponent(jTextField_Email))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_Email)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                    .addGap(1, 1, 1)
                                                    .addComponent(jLabel_makh)
                                                    .addGap(7, 7, 7))
                                                .addComponent(jLabel_gioitinh, javax.swing.GroupLayout.Alignment.LEADING))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel_TenKH)
                                                .addGap(7, 7, 7)))
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(45, 45, 45)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jTextFieldmakh, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jTextField_tenkh, javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jTextField_DiaChi)))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(65, 65, 65)
                                                .addComponent(jRadioButton_Nam)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jRadioButton_Nu, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(9, 9, 9))))
                                    .addComponent(jLabel_diachi, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(63, 63, 63)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(488, Short.MAX_VALUE)
                    .addComponent(jButton4)
                    .addGap(116, 116, 116)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jTextFieldmakh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel_makh)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel_TenKH)
                                    .addComponent(jTextField_tenkh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_DiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_diachi))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_Email)
                            .addComponent(jTextField_Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jRadioButton_Nam)
                                    .addComponent(jRadioButton_Nu)))
                            .addComponent(jLabel_gioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_sdt)
                            .addComponent(jTextField_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(216, 216, 216))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(69, 69, 69)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(495, Short.MAX_VALUE)))
        );

        jTable_Khachhang.setBackground(new java.awt.Color(204, 204, 204));
        jTable_Khachhang.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTable_Khachhang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã KH", "Họ và tên", "Email", "Giới tính", "SDT", "Địa chỉ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_Khachhang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_KhachhangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_Khachhang);

        jButton_Thoat.setBackground(new java.awt.Color(255, 153, 153));
        jButton_Thoat.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jButton_Thoat.setText("Thoát");
        jButton_Thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ThoatActionPerformed(evt);
            }
        });

        jButton_Timkiem.setBackground(new java.awt.Color(255, 153, 153));
        jButton_Timkiem.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton_Timkiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlybanhang/Fram/HinhAnh/search-icon-32.png"))); // NOI18N
        jButton_Timkiem.setText("Tìm kiếm");
        jButton_Timkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_TimkiemActionPerformed(evt);
            }
        });

        jTextField_tenkh1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
                        .addGap(57, 57, 57))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(jButton_Timkiem)
                        .addGap(44, 44, 44)
                        .addComponent(jTextField_tenkh1)
                        .addGap(213, 213, 213))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton_Thoat)
                .addGap(468, 468, 468))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton_Timkiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField_tenkh1))
                        .addGap(39, 39, 39)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(jButton_Thoat)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_SDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_SDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_SDTActionPerformed

    private void jRadioButton_NamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_NamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton_NamActionPerformed

    private void jRadioButton_NuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_NuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton_NuActionPerformed

    private void jButton_ThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ThoatActionPerformed
        // TODO add your handling code here:
         jButton_Thoat.setToolTipText("Click để thoát chương trình ");
        int selected = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn thoát chương"
            + " trình không", "Thông báo", JOptionPane.YES_NO_OPTION);
        if (selected == JOptionPane.YES_NO_OPTION) {
            this.dispose();

        }
    }//GEN-LAST:event_jButton_ThoatActionPerformed

    private void jButton_XoaKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_XoaKHActionPerformed
        // TODO add your handling code here:
        conn=cn.getConnection();
        try {
            // Tạo một đối tượng để thực hiện công việc
             String query = "DELETE FROM KhachHang WHERE MaKH = '" + jTextFieldmakh.getText() + "'";
            Statement st = conn.createStatement();
            int chk = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn xóa chứ !","Thông báo",JOptionPane.YES_NO_OPTION);
            if(chk==JOptionPane.YES_NO_OPTION){
                st.executeUpdate(query);
                Xoatrang();
                JOptionPane.showMessageDialog(this, "Xóa thành công !");
            }
        } catch (Exception ex) {

            ex.printStackTrace();
        }
        /*Connection con = getConnection();
        try {
            // Tạo một đối tượng để thực hiện công việc
            st = (Statement) con.createStatement();
            String query = "DELETE FROM KhachHang WHERE MaKH = '" + jTextFieldmakh.getText() + "'";
            st.executeUpdate(query);
            hienThiDanhSachKhachHang();

        } catch (Exception ex) {

            ex.printStackTrace();
        }*/
    }//GEN-LAST:event_jButton_XoaKHActionPerformed

    private void jButton_TimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_TimkiemActionPerformed
       
         conn = cn.getConnection();
         try {
              if( jTextField_tenkh1.getText().equals("")){
             JOptionPane.showMessageDialog(this,"Nhập Tên khách hàng cần tìm kiếm ");
             }else{
                  
             String sql = "SELECT *FROM KhachHang where TenKH like '%"+jTextField_tenkh1.getText()+"%' order by makh desc";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            tb.setRowCount(0);
            while (rs.next()) {
               Object personObject[] = {
                    rs.getString("makh"),
                    rs.getString("tenkh"),
                    rs.getString("email"),
                    rs.getString("gioitinh"),
                    rs.getString("sdt"),
                    rs.getString("diachi")
                };
                tb.addRow(personObject);
                jTable_Khachhang.setModel(tb);
                
              }
             rs.close();
           conn.close();
            }
          
        } catch (Exception e) {
        }
       
    }//GEN-LAST:event_jButton_TimkiemActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton_ThemKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ThemKHActionPerformed

        conn = cn.getConnection();
        try {
            if(jTextFieldmakh.getText().equals("") || jTextField_tenkh.getText().equals("")||jTextField_Email.getText().equals("") ||jTextField_SDT.getText().equals("") ||jTextField_DiaChi.getText().equals("")){
             JOptionPane.showMessageDialog(this,"Bạn Cần cập nhật đủ dữ liệu ");
             }else{
                StringBuffer sb = new StringBuffer();
                String SQL_check_pk="SELECT MaKH FROM KhachHang WHERE MaKH = '"+jTextFieldmakh.getText()+"'";
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(SQL_check_pk);
                if(rs.next()){
                    sb.append("Mã khách hàng đã bị trùng");
                }
                if(sb.length()>0){ //Nếu if kia đúng nó xẽ thêm vào sb 1 đoạn String , kiểm tra độ dài chuỗi này nếu lớn hơn 0 tức là có thông báo thì 
                    JOptionPane.showConfirmDialog(this,sb.toString());
                    rs.close();
                }else{
                   String sql = "INSERT INTO KhachHang VALUES(?,?,?,?,?,?)";
                   PreparedStatement pst = conn.prepareStatement(sql);
                   String makh = jTextFieldmakh.getText();                   
                   String hoten = jTextField_tenkh.getText();
                   String email = jTextField_Email.getText();
                   String sex = "";
                   if(jRadioButton_Nam.isSelected()){
                       sex = jRadioButton_Nam.getText();
                   }else{
                       sex = jRadioButton_Nu.getText();
                   }
                   String sdt = jTextField_SDT.getText();
                   String diachi = jTextField_DiaChi.getText();
                   pst.setString(1, makh);                   
                   pst.setString(2, hoten);
                   pst.setString(3, email);
                   pst.setString(4, sex);
                   pst.setString(5, sdt);
                   pst.setString(6, diachi);
                   int kq = pst.executeUpdate();
                   if(kq>0){
                       JOptionPane.showMessageDialog(this, "Thêm mới thành công !");
                       LoatBang();
                       Xoatrang();
                           
                   }
                }
            conn.close();
        }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_jButton_ThemKHActionPerformed

    private void jButton_suakhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_suakhActionPerformed
        // TODO add your handling code here:
         conn = cn.getConnection();
        try {
           
            if( jTextField_tenkh.getText().equals("")||jTextField_Email.getText().equals("") ||jTextField_SDT.getText().equals("") ||jTextField_DiaChi.getText().equals("")){
             JOptionPane.showMessageDialog(this,"Bạn Cần cập nhật đủ dữ liệu ");
             }else{
                String sql = "UPDATE KhachHang SET TenKH =?, email=?, gioitinh=?, sdt=?, diachi=? where makh=?";
                         
              //1        2          3      4         5            6 => vi tri
                PreparedStatement pst = conn.prepareStatement(sql);
                   String makh = jTextFieldmakh.getText();                   
                   String hoten = jTextField_tenkh.getText();
                   String email = jTextField_Email.getText();
                   String sex = "";
                   if(jRadioButton_Nam.isSelected()){
                       sex = jRadioButton_Nam.getText();
                   }else{
                       sex = jRadioButton_Nu.getText();
                   }
                   String sdt = jTextField_SDT.getText();
                   String diachi = jTextField_DiaChi.getText();
                   pst.setString(6, makh);   // vi tri cua dau hoi cham                 
                   pst.setString(1, hoten);
                   pst.setString(2, email);
                   pst.setString(3, sex);
                   pst.setString(4, sdt);
                   pst.setString(5, diachi);
                   int kq = pst.executeUpdate();
                    if(kq>0){
                    JOptionPane.showMessageDialog(this, "Cập nhật thành công !");
                    Xoatrang();
                 }
             }
             
            conn.close();
        
        } catch (Exception e) {
            System.out.println(e.toString());
        }
                                               
    }//GEN-LAST:event_jButton_suakhActionPerformed

    private void jButton_ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ResetActionPerformed
        // TODO add your handling code here:
        jTextFieldmakh.setText("");
        jTextField_tenkh.setText("");
        jTextField_Email.setText("");
        jTextField_DiaChi.setText("");
        jTextField_SDT.setText("");
        
    }//GEN-LAST:event_jButton_ResetActionPerformed

    private void jTable_KhachhangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_KhachhangMouseClicked
        // TODO add your handling code here:
        int x = jTable_Khachhang.getSelectedRow();
        if(x>=0){
            jTextFieldmakh.setText(jTable_Khachhang.getValueAt(x, 0)+"");
            jTextField_tenkh.setText(jTable_Khachhang.getValueAt(x, 1)+"");
            jTextField_Email.setText(jTable_Khachhang.getValueAt(x, 2)+"");
            if(jTable_Khachhang.getValueAt(x, 3).toString().equalsIgnoreCase("Nam")){
                jRadioButton_Nam.setSelected(true);
            }else{
                jRadioButton_Nu.setSelected(true);
            }
            jTextField_SDT.setText(jTable_Khachhang.getValueAt(x, 4)+"");
            jTextField_DiaChi.setText(jTable_Khachhang.getValueAt(x, 5)+"");
           
            jTextFieldmakh.setEnabled(flase);
        }
        /*String gioitinh= jTable_Khachhang.getValueAt(x, 3)+"";
          if (gioitinh.equals("Nam")) {
            jRadioButton_Nam.setSelected(true);
            jRadioButton_Nu.setSelected(false);
        } else {
             // jTable_Khachhang.setSelected(true);
             // jTable_Khachhang.setSelected(false);
        }*/
    }//GEN-LAST:event_jTable_KhachhangMouseClicked

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(KhachHangForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KhachHangForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KhachHangForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KhachHangForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KhachHangForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton_Reset;
    private javax.swing.JButton jButton_ThemKH;
    private javax.swing.JButton jButton_Thoat;
    private javax.swing.JButton jButton_Timkiem;
    private javax.swing.JButton jButton_XoaKH;
    private javax.swing.JButton jButton_suakh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel_Email;
    private javax.swing.JLabel jLabel_TenKH;
    private javax.swing.JLabel jLabel_diachi;
    private javax.swing.JLabel jLabel_gioitinh;
    private javax.swing.JLabel jLabel_makh;
    private javax.swing.JLabel jLabel_sdt;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JRadioButton jRadioButton_Nam;
    private javax.swing.JRadioButton jRadioButton_Nu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Khachhang;
    private javax.swing.JTextField jTextField_DiaChi;
    private javax.swing.JTextField jTextField_Email;
    private javax.swing.JTextField jTextField_SDT;
    private javax.swing.JTextField jTextField_tenkh;
    private javax.swing.JTextField jTextField_tenkh1;
    private javax.swing.JTextField jTextFieldmakh;
    private java.awt.PopupMenu popupMenu1;
    // End of variables declaration//GEN-END:variables
}
