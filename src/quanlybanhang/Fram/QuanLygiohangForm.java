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
public class QuanLygiohangForm extends javax.swing.JFrame {
    final String header1 []={ "Tên SP","Màu sắc"," Kích cỡ","giá","số lượng"};
    final DefaultTableModel tb1 = new DefaultTableModel(header1,0);
    
     final String header2 []={ "Tên KH","SDT","Địa chỉ","Tên SP","Kích cỡ","Màu sắc","HT thanh toán"};
    final DefaultTableModel tb2 = new DefaultTableModel(header2,0);
    
    ConnectToSQLServer cn = new ConnectToSQLServer();
    Connection conn;
    private boolean flase;
    /**
     * Creates new form QuanLygiohangForm
     */
    public QuanLygiohangForm() {
         initComponents();
       setLocationRelativeTo(null);
       LoatBang_GHang();
         LoatBang_DHang();
    }
    
   public void LoatBang_GHang(){
        try {
            conn = cn.getConnection();
            String sql = "SELECT *FROM GioHang " //order by makh desc
                    + "";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            tb1.setRowCount(0);
            while (rs.next()) {
               Object personObject[] = {
                    rs.getString("tensp"),
                    rs.getString("mausac"),
                    rs.getInt("kichco"),
                    rs.getFloat("gia"),
                    rs.getInt("soluong"),
                  
                };
                tb1.addRow(personObject);
                jTable_dssp1.setModel(tb1);
            }
            
           st.close();
           rs.close();
           conn.close();
        } catch (Exception e) {
        }
      /*  jTable_dssp1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
           @Override
            public void valueChanged(ListSelectionEvent e) {
               if (jTable_dssp1.getSelectedRow()>=0){
                   
                   jTextField_mausac1.setText(jTable_dssp1.getValueAt(jTable_dssp1.getSelectedRow(), 0)+"");
                   jTextField_kichco1.setText(jTable_dssp1.getValueAt(jTable_dssp1.getSelectedRow(), 1)+"");
                   jTextField_gia1.setText(jTable_dssp1.getValueAt(jTable_dssp1.getSelectedRow(), 2)+"");
                   jTextField_sl1.setText(jTable_dssp1.getValueAt(jTable_dssp1.getSelectedRow(), 3)+"");
                  
               }
            }
        });*/
    }
// Hàm này xẽ xóa trắng sau khi thêm sửa xóa
    private void Xoatrang_GH(){
         jTextField_tenSP.setText("");
        jTextField_mausac1.setText("");
        jTextField_kichco1.setText("");
       jTextField_gia1.setText("");
        jTextField_sl1.setText("");
        
        LoatBang_GHang();
       jTextField_mausac1.setEnabled(true);
  
    }
    
    public void LoatBang_DHang(){
        try {
            conn = cn.getConnection();
            String sql = "SELECT *FROM DatHang " //order by makh desc
                    + "";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            tb2.setRowCount(0);
            while (rs.next()) {
               Object personObject[] = {
                    rs.getString("tenkh"),
                    rs.getString("sdt"),
                    rs.getString("diachi"),
                    rs.getString("tensp"),
                    rs.getInt("kichco"),
                    rs.getString("mausac"),
                   rs.getString("htthanhtoan"),
                };
                tb2.addRow(personObject);
                jTable_dsdonhang.setModel(tb2);
            }
            
           st.close();
           rs.close();
           conn.close();
        } catch (Exception e) {
        }
      /*  jTable_dssp1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
           @Override
            public void valueChanged(ListSelectionEvent e) {
               if (jTable_dssp1.getSelectedRow()>=0){
                   
                   jTextField_mausac1.setText(jTable_dssp1.getValueAt(jTable_dssp1.getSelectedRow(), 0)+"");
                   jTextField_kichco1.setText(jTable_dssp1.getValueAt(jTable_dssp1.getSelectedRow(), 1)+"");
                   jTextField_gia1.setText(jTable_dssp1.getValueAt(jTable_dssp1.getSelectedRow(), 2)+"");
                   jTextField_sl1.setText(jTable_dssp1.getValueAt(jTable_dssp1.getSelectedRow(), 3)+"");
                  
               }
            }
        });*/
    }
// Hàm này xẽ xóa trắng sau khi thêm sửa xóa
    private void Xoatrang_DH(){
        jTextField_Tenkh2.setText("");
        jTextField_sdt2.setText("");
        jTextField_diachi2.setText("");
        jTextField_tép2.setText("");
        jTextField_kc3.setText("");
       jTextField_ms2.setText("");
        jTextField_httt2.setText("");
        
        LoatBang_DHang();
       jTextField_Tenkh2.setEnabled(true);
       
       
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jTextField_mausac1 = new javax.swing.JTextField();
        jTextField_kichco1 = new javax.swing.JTextField();
        jTextField_gia1 = new javax.swing.JTextField();
        jButton_them1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_dssp1 = new javax.swing.JTable();
        jLabel25 = new javax.swing.JLabel();
        jTextField_sl1 = new javax.swing.JTextField();
        jTextField_tenSP = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jTextField_Tenkh2 = new javax.swing.JTextField();
        jTextField_diachi2 = new javax.swing.JTextField();
        jTextField_sdt2 = new javax.swing.JTextField();
        jTextField_tép2 = new javax.swing.JTextField();
        jTextField_ms2 = new javax.swing.JTextField();
        jButton_dh = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_dsdonhang = new javax.swing.JTable();
        jLabel29 = new javax.swing.JLabel();
        jTextField_httt2 = new javax.swing.JTextField();
        jTextField_kc3 = new javax.swing.JTextField();
        jButton_thoat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý giỏ hàng");

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));

        jLabel1.setBackground(new java.awt.Color(0, 153, 153));
        jLabel1.setFont(new java.awt.Font("Sitka Display", 1, 36)); // NOI18N
        jLabel1.setText("QUẢN LÝ GIỎ HÀNG");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(344, 344, 344)
                .addComponent(jLabel1)
                .addContainerGap(582, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Giỏ hàng"));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel16.setText("Tên sản phẩm:");

        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel18.setText("Màu sắc  :");

        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel19.setText("Kích cỡ :");

        jLabel20.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel20.setText("Giá:");

        jButton_them1.setBackground(new java.awt.Color(255, 153, 153));
        jButton_them1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton_them1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlybanhang/Fram/HinhAnh/themsp-25.png"))); // NOI18N
        jButton_them1.setText("Thêm ");
        jButton_them1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_them1ActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách sản phẩm"));

        jTable_dssp1.setBackground(new java.awt.Color(204, 204, 204));
        jTable_dssp1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTable_dssp1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Tên SP", "Màu sắc", "Kích cỡ", "Giá", "Số lượng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_dssp1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_dssp1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_dssp1);
        if (jTable_dssp1.getColumnModel().getColumnCount() > 0) {
            jTable_dssp1.getColumnModel().getColumn(0).setResizable(false);
            jTable_dssp1.getColumnModel().getColumn(1).setResizable(false);
            jTable_dssp1.getColumnModel().getColumn(2).setResizable(false);
            jTable_dssp1.getColumnModel().getColumn(3).setResizable(false);
            jTable_dssp1.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabel25.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel25.setText("Số lượng:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_tenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 2, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField_gia1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton_them1)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField_mausac1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(48, 48, 48)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_sl1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_kichco1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jTextField_tenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jTextField_kichco1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(jTextField_mausac1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jTextField_gia1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(jTextField_sl1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addComponent(jButton_them1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Đặt hàng"));

        jLabel21.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel21.setText("Tên khách hàng :");

        jLabel22.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel22.setText("Địa chỉ:");

        jLabel23.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel23.setText("SĐT :");

        jLabel24.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel24.setText("Kích cỡ :");

        jLabel26.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel26.setText("Tên sản phẩm:");

        jLabel27.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel27.setText("Màu sắc:");

        jButton_dh.setBackground(new java.awt.Color(255, 153, 153));
        jButton_dh.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton_dh.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\OneDrive\\Tài liệu\\NetBeansProjects\\QLBanHang\\src\\qlbanhang\\HinhAnh\\donhang-40.png")); // NOI18N
        jButton_dh.setText("Đặt hàng");
        jButton_dh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_dhActionPerformed(evt);
            }
        });

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách đơn hàng"));

        jTable_dsdonhang.setBackground(new java.awt.Color(204, 204, 204));
        jTable_dsdonhang.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTable_dsdonhang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Họ và tên", "SĐT", "Địa chỉ", "Tên SP", "kích cỡ", "Màu sắc", "HT thanh toán"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable_dsdonhang);
        if (jTable_dsdonhang.getColumnModel().getColumnCount() > 0) {
            jTable_dsdonhang.getColumnModel().getColumn(0).setResizable(false);
            jTable_dsdonhang.getColumnModel().getColumn(1).setResizable(false);
            jTable_dsdonhang.getColumnModel().getColumn(2).setResizable(false);
            jTable_dsdonhang.getColumnModel().getColumn(3).setResizable(false);
            jTable_dsdonhang.getColumnModel().getColumn(4).setResizable(false);
            jTable_dsdonhang.getColumnModel().getColumn(5).setResizable(false);
            jTable_dsdonhang.getColumnModel().getColumn(6).setResizable(false);
        }

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel29.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel29.setText("Hình thức thanh toán:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_httt2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_Tenkh2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(jLabel22)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField_diachi2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(45, 45, 45)
                                    .addComponent(jTextField_sdt2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_ms2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_tép2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton_dh)
                .addGap(275, 275, 275))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                    .addContainerGap(493, Short.MAX_VALUE)
                    .addComponent(jTextField_kc3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(58, 58, 58)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jTextField_Tenkh2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26)
                    .addComponent(jTextField_tép2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jTextField_sdt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(jTextField_ms2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_diachi2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addComponent(jTextField_httt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(jButton_dh, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(66, 66, 66)
                    .addComponent(jTextField_kc3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(511, Short.MAX_VALUE)))
        );

        jButton_thoat.setBackground(new java.awt.Color(255, 153, 153));
        jButton_thoat.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jButton_thoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlybanhang/Fram/HinhAnh/logout-icon-32.png"))); // NOI18N
        jButton_thoat.setText("Thoát");
        jButton_thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_thoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(jButton_thoat)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addComponent(jButton_thoat))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_them1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_them1ActionPerformed
       conn = cn.getConnection();
        try {
            if(jTextField_mausac1.getText().equals("") || jTextField_kichco1.getText().equals("")||jTextField_sl1.getText().equals("") ||jTextField_gia1.getText().equals("") ){
             JOptionPane.showMessageDialog(this,"Bạn Cần cập nhật đủ dữ liệu ");
             }else{

                   String sql = "INSERT INTO GioHang VALUES(?,?,?,?,?)";
                   PreparedStatement pst = conn.prepareStatement(sql);
                  String tensp=jTextField_sl1.getText();                
                   String mausac = jTextField_mausac1.getText();
                   String kichthuoc = jTextField_kichco1.getText();
                  String soluong = jTextField_sl1.getText();
                    try {
                        int bien = Integer.valueOf(soluong);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Số lượng phải nhập Bằng số ");
                        //ThongBao += "Số lượng phải nhập Bằng số" + "\n";
                    }

                   
                    String gia= jTextField_gia1.getText();
                    try {
                        int bien = Integer.valueOf(gia);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Giá  phải là số ");
                        //  ThongBao+="Giá Nhập Phải là số !\n";
                    }
                  
                   pst.setString(1, tensp);                   
                   pst.setString(2, mausac);
                   pst.setString(3, kichthuoc);
                   pst.setString(4, gia);
                   pst.setString(5, soluong);
               
                   int kq = pst.executeUpdate();
                   if(kq>0){
                       JOptionPane.showMessageDialog(this, "Thêm mới thành công !");
                       LoatBang_GHang();
                       Xoatrang_GH();
                           
                   }
                
            conn.close();
        }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_jButton_them1ActionPerformed

    private void jButton_dhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_dhActionPerformed
        // TODO add your handling code here:
        conn = cn.getConnection();
        try {
            if(jTextField_Tenkh2.getText().equals("") || jTextField_sdt2.getText().equals("")||jTextField_diachi2.getText().equals("") 
                    ||jTextField_tép2.getText().equals("") || jTextField_ms2.getText().equals("") || jTextField_httt2.getText().equals("") ){
             JOptionPane.showMessageDialog(this,"Bạn Cần cập nhật đủ dữ liệu ");
             }else{

                   String sql = "INSERT INTO DatHang VALUES(?,?,?,?,?,?,?)";
                   PreparedStatement pst = conn.prepareStatement(sql);
                       String tensp = jTextField_tép2.getText();        
                   String tenkh = jTextField_Tenkh2.getText();
                   String sdt = jTextField_sdt2.getText();
                   String diachi = jTextField_diachi2.getText();
                   String kichco = jTextField_kc3.getText();
                   String mausac = jTextField_ms2.getText();
                  String httt = jTextField_httt2.getText();
                    try {
                        int bien = Integer.valueOf(kichco);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "kích cỡ  phải nhập Bằng số ");
                        
                    }
                   pst.setString(1, tenkh);                   
                   pst.setString(2, sdt);
                   pst.setString(3, diachi);
                   pst.setString(4, tensp);
                   pst.setString(5, kichco);
                   pst.setString(6, mausac);
                   pst.setString(7, httt);
               
                   int kq = pst.executeUpdate();
                   if(kq>0){
                       JOptionPane.showMessageDialog(this, "Đặt hàng thành công !");
                       LoatBang_DHang();
                       Xoatrang_DH();
                           
                   }
                
            conn.close();
        }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_jButton_dhActionPerformed

    private void jTable_dssp1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_dssp1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable_dssp1MouseClicked

    private void jButton_thoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_thoatActionPerformed
        // TODO add your handling code here:
          jButton_thoat.setToolTipText("Click để thoát chương trình ");
        int selected = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn thoát chương"
            + " trình không", "Thông báo", JOptionPane.YES_NO_OPTION);
        if (selected == JOptionPane.YES_NO_OPTION) {
            this.dispose();

        }
    }//GEN-LAST:event_jButton_thoatActionPerformed

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
            java.util.logging.Logger.getLogger(QuanLygiohangForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLygiohangForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLygiohangForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLygiohangForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLygiohangForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_dh;
    private javax.swing.JButton jButton_them1;
    private javax.swing.JButton jButton_thoat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable_dsdonhang;
    private javax.swing.JTable jTable_dssp1;
    private javax.swing.JTextField jTextField_Tenkh2;
    private javax.swing.JTextField jTextField_diachi2;
    private javax.swing.JTextField jTextField_gia1;
    private javax.swing.JTextField jTextField_httt2;
    private javax.swing.JTextField jTextField_kc3;
    private javax.swing.JTextField jTextField_kichco1;
    private javax.swing.JTextField jTextField_mausac1;
    private javax.swing.JTextField jTextField_ms2;
    private javax.swing.JTextField jTextField_sdt2;
    private javax.swing.JTextField jTextField_sl1;
    private javax.swing.JTextField jTextField_tenSP;
    private javax.swing.JTextField jTextField_tép2;
    // End of variables declaration//GEN-END:variables
}
