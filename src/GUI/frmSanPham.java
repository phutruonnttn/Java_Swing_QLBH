/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import OBJ.SanPham;
import Utils.ValidateData;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class frmSanPham extends javax.swing.JPanel implements java.beans.Customizer {

    private Object bean;
    private DefaultTableModel defaultTableModel;
    ValidateData validate = new ValidateData();
    SanPham sp = new SanPham();
    ArrayList<SanPham> listSP = new ArrayList<>();
    NumberFormat formatter = new DecimalFormat("###,###");

    /**
     * Creates new customizer frmNhanVien
     */
    public frmSanPham() {
        initComponents();
        //setSize(856, 577);
        lbl_hello.setText("Xin chào, " + frmLogin.nameLogin + " !");
        loadFile();
        getData(listSP);
       

    }

    public void setObject(Object bean) {
        this.bean = bean;
    }

    public void loadFile() {
        try {
            BufferedReader br = null;
            FileReader fr = null;
            listSP = new ArrayList<>(); //lưu ý
            fr = new FileReader("sanpham.txt");
            br = new BufferedReader(fr);
            String s = null;
            try {
                while ((s = br.readLine()) != null) {
                    //Cắt chuỗi:
                    String arr[] = s.split("\t");
                    //Khởi tạo
                    SanPham sp = new SanPham();
                    sp.setMaSP(arr[0]);
                    sp.setTen(arr[1]);
                    sp.setDonViTinh(arr[2]);
                    sp.setTenNSX(arr[3]);
                    sp.setGiaNhap(arr[4]);
                    sp.setGiaBan(arr[5]);
                    sp.setSoLuong(Integer.parseInt(arr[6]));
                    listSP.add(sp);
                }
            } catch (IOException ex) {
                Logger.getLogger(frmSanPham.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(frmSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void saveFile() {
        try {
            BufferedWriter bw = null; //Khởi tạo
            FileWriter fw = null; //Khởi tạo
            String data = ""; //Tạo một string data bằng rỗng.
            for (int i = 0; i < listSP.size(); i++) {
                String row = ""; //tạo hàng rỗng
                row = row + listSP.get(i).getMaSP() + "\t";
                row = row + listSP.get(i).getTen() + "\t";
                row = row + listSP.get(i).getDonViTinh() + "\t";
                row = row + listSP.get(i).getTenNSX() + "\t";
                row = row + listSP.get(i).getGiaNhap() + "\t";
                row = row + listSP.get(i).getGiaBan() + "\t";
                row = row + listSP.get(i).getSoLuong() + "\n";
                data += row;
            }
            fw = new FileWriter("sanpham.txt");
            bw = new BufferedWriter(fw);
            bw.write(data);
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(frmSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void getData(ArrayList<SanPham> listSP) {
        defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("Mã SP");
        defaultTableModel.addColumn("Tên SP");
        defaultTableModel.addColumn("Đơn vị tính");
        defaultTableModel.addColumn("Tên NSX");
        defaultTableModel.addColumn("Giá bán");
        defaultTableModel.addColumn("Giá nhập");
        defaultTableModel.addColumn("Số lượng");

        for (SanPham obj : listSP) {
            Vector vector = new Vector();
            vector.add(obj.getMaSP());
            vector.add(obj.getTen());
            vector.add(obj.getDonViTinh());
            vector.add(obj.getTenNSX());
            vector.add(formatter.format(Double.parseDouble(obj.getGiaBan())));
            vector.add(formatter.format(Double.parseDouble(obj.getGiaNhap())));
            vector.add(formatter.format(obj.getSoLuong()));
            defaultTableModel.addRow(vector);
        }
        table_Data_SP.setModel(defaultTableModel);
    }

    public boolean checkMaSP(String maSP) {
        for (int i = 0; i < listSP.size(); i++) {
            if (maSP.equals(listSP.get(i).getMaSP())) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the FormEditor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_Data_SP = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btn_search = new javax.swing.JButton();
        txt_search = new javax.swing.JTextField();
        btn_thoat = new javax.swing.JButton();
        btn_them = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        lbl_MaNV2 = new javax.swing.JLabel();
        lbl_hoVaTen1 = new javax.swing.JLabel();
        lbl_gioiTinh1 = new javax.swing.JLabel();
        lbl_email1 = new javax.swing.JLabel();
        lbl_soDienThoai1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_maSP = new javax.swing.JTextField();
        txt_donViTinh = new javax.swing.JTextField();
        txt_giaNhap = new javax.swing.JTextField();
        txt_tenSP = new javax.swing.JTextField();
        txt_soLuong = new javax.swing.JTextField();
        txt_tenNSX = new javax.swing.JTextField();
        txt_giaBan = new javax.swing.JTextField();
        txt_hello = new javax.swing.JLabel();
        lbl_hello = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 140, 18));
        setForeground(new java.awt.Color(0, 51, 204));
        setPreferredSize(new java.awt.Dimension(1059, 680));
        setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 115, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("QUẢN LÝ SẢN PHẨM");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Zent Coding School");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 365, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(254, 254, 254))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        add(jPanel1);
        jPanel1.setBounds(0, 0, 1040, 40);

        table_Data_SP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table_Data_SP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_Data_SPMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_Data_SP);

        add(jScrollPane2);
        jScrollPane2.setBounds(0, 340, 1020, 180);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1040, 10));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1040, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        add(jPanel2);
        jPanel2.setBounds(0, 40, 1040, 10);

        jPanel3.setBackground(new java.awt.Color(255, 255, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TÌM KIẾM", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 1, 13), new java.awt.Color(0, 153, 255))); // NOI18N

        btn_search.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btn_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Search-icon.png"))); // NOI18N
        btn_search.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_search, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_search, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_search))
                .addGap(99, 99, 99))
        );

        add(jPanel3);
        jPanel3.setBounds(690, 90, 320, 80);

        btn_thoat.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        btn_thoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Users-Exit-icon.png"))); // NOI18N
        btn_thoat.setText("Thoát");
        btn_thoat.setBorder(null);
        btn_thoat.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thoatActionPerformed(evt);
            }
        });
        add(btn_thoat);
        btn_thoat.setBounds(880, 230, 120, 40);

        btn_them.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        btn_them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user-add-icon.png"))); // NOI18N
        btn_them.setText("Thêm");
        btn_them.setBorder(null);
        btn_them.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });
        add(btn_them);
        btn_them.setBounds(700, 180, 120, 40);

        btn_sua.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        btn_sua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit-icon.png"))); // NOI18N
        btn_sua.setText("Sửa");
        btn_sua.setBorder(null);
        btn_sua.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });
        add(btn_sua);
        btn_sua.setBounds(700, 230, 120, 40);

        btn_xoa.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        btn_xoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Close-icon.png"))); // NOI18N
        btn_xoa.setText("Xóa");
        btn_xoa.setBorder(null);
        btn_xoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });
        add(btn_xoa);
        btn_xoa.setBounds(880, 180, 120, 40);

        jPanel4.setBackground(new java.awt.Color(255, 255, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "THÔNG TIN SẢN PHẨM", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 1, 13), new java.awt.Color(0, 153, 255))); // NOI18N

        lbl_MaNV2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_MaNV2.setForeground(new java.awt.Color(0, 51, 204));
        lbl_MaNV2.setText("Mã Sản Phẩm");

        lbl_hoVaTen1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_hoVaTen1.setForeground(new java.awt.Color(0, 51, 204));
        lbl_hoVaTen1.setText("Tên SP");

        lbl_gioiTinh1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_gioiTinh1.setForeground(new java.awt.Color(0, 51, 204));
        lbl_gioiTinh1.setText("Tên NSX");

        lbl_email1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_email1.setForeground(new java.awt.Color(0, 51, 204));
        lbl_email1.setText("Đơn vị tính");

        lbl_soDienThoai1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_soDienThoai1.setForeground(new java.awt.Color(0, 51, 204));
        lbl_soDienThoai1.setText("Giá nhập");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 51, 204));
        jLabel7.setText("Số lượng ");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 51, 204));
        jLabel8.setText("Giá bán");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_email1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_MaNV2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_maSP, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(txt_donViTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(txt_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(lbl_soDienThoai1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_giaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_hoVaTen1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_gioiTinh1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_tenSP, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                    .addComponent(txt_tenNSX)
                    .addComponent(txt_giaBan))
                .addContainerGap(8, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_maSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_MaNV2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_hoVaTen1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_gioiTinh1)
                    .addComponent(lbl_email1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_donViTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tenNSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_soDienThoai1)
                    .addComponent(txt_giaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_giaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        add(jPanel4);
        jPanel4.setBounds(30, 90, 580, 210);

        txt_hello.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txt_hello.setForeground(new java.awt.Color(255, 255, 255));
        add(txt_hello);
        txt_hello.setBounds(810, 60, 200, 0);

        lbl_hello.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        lbl_hello.setForeground(new java.awt.Color(255, 255, 255));
        lbl_hello.setText("Xin chào ...");
        add(lbl_hello);
        lbl_hello.setBounds(40, 60, 570, 17);

        jLabel2.setBackground(new java.awt.Color(255, 255, 205));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/blur.jpg"))); // NOI18N
        add(jLabel2);
        jLabel2.setBounds(-160, 0, 1190, 560);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed

        if (txt_maSP.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Mã sản phẩm không được để trống !");
        } else if (checkMaSP(txt_maSP.getText())) {
            JOptionPane.showMessageDialog(this, "Mã đã tồn tại. Vui lòng nhập mã khác");
        } else {
            SanPham sp = new SanPham();
            sp.setMaSP(txt_maSP.getText());
            int dem = 0;
            if (txt_tenSP.getText().equals("")) {
                dem++;
                JOptionPane.showMessageDialog(this, "Tên sản phẩm không được để trống !");
                return;
            } else {
                sp.setTen(txt_tenSP.getText());
            }
            if (txt_tenNSX.getText().equals("")) {
                dem++;
                JOptionPane.showMessageDialog(this, "Tên NSX không được để trống !");
                return;
            } else {
                sp.setTenNSX(txt_tenNSX.getText());
            }
            if (txt_donViTinh.getText().equals("")) {
                dem++;
                JOptionPane.showMessageDialog(this, "Đơn vị tính không được để trống !");
                return;
            } else {
                sp.setDonViTinh(txt_donViTinh.getText());
            }
            try {
                if (txt_giaNhap.getText().equals("")) {
                    dem++;
                    JOptionPane.showMessageDialog(this, "Giá nhập không được để trống !");
                    return;
                } else if (Integer.parseInt(txt_giaNhap.getText()) <= 0) {
                    dem++;
                    JOptionPane.showMessageDialog(this, "Giá nhập phải lớn hơn 0 !");
                    return;
                } else {
                    sp.setGiaNhap(txt_giaNhap.getText());
                }
            } catch (Exception e) {
                dem++;
                JOptionPane.showMessageDialog(this, "Giá nhập không được chứa chữ !");
                return;
            }
            try {
                if (txt_giaBan.getText().equals("")) {
                    dem++;
                    JOptionPane.showMessageDialog(this, "Giá bán không được để trống !");
                    return;
                } else if (Integer.parseInt(txt_giaBan.getText()) <= 0) {
                    dem++;
                    JOptionPane.showMessageDialog(this, "Giá bán phải lớn hơn 0 !");
                    return;
                } else {
                    sp.setGiaBan(txt_giaBan.getText());
                }
            } catch (Exception e) {
                dem++;
                JOptionPane.showMessageDialog(this, "Giá bán không được chứa chữ !");
                return;
            }
            try {
                if (txt_soLuong.getText().equals("")) {
                    dem++;
                    JOptionPane.showMessageDialog(this, "Số lượng không được để trống !");
                    return;
                } else if (Integer.parseInt(txt_soLuong.getText()) <= 0) {
                    dem++;
                    JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0 !");
                    return;
                } else {
                    sp.setSoLuong(Integer.parseInt(txt_soLuong.getText()));
                }
            } catch (Exception e) {
                dem++;
                JOptionPane.showMessageDialog(this, "Số lượng không được chứa chữ !");
                return;
            }

            if (dem == 0) {
                listSP.add(sp);
                saveFile();
                getData(listSP);
                reset();
                JOptionPane.showMessageDialog(this, "Thêm mới thành công !");
            } else {
                JOptionPane.showMessageDialog(this, "Thêm mới thất bại !");
            }
        }


    }//GEN-LAST:event_btn_themActionPerformed
    public void reset() {
        txt_donViTinh.setText("");
        txt_maSP.setText("");
        txt_tenSP.setText("");
        txt_soLuong.setText("");
        txt_giaNhap.setText("");
        txt_giaBan.setText("");
        txt_tenNSX.setText("");
        btn_them.setEnabled(true);
        btn_sua.setEnabled(true);
        btn_xoa.setEnabled(true);
        txt_maSP.setEnabled(true);
        txt_soLuong.setEnabled(true);
        getData(listSP);
    }
    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed

        int dem = 0;
        if (txt_tenSP.getText().equals("")) {
            dem++;
            JOptionPane.showMessageDialog(this, "Tên sản phẩm không được để trống !");
            return;
        } else {
            sp.setTen(txt_tenSP.getText());
        }
        if (txt_tenNSX.getText().equals("")) {
            dem++;
            JOptionPane.showMessageDialog(this, "Tên NSX không được để trống !");
            return;
        } else {
            sp.setTenNSX(txt_tenNSX.getText());
        }
        if (txt_donViTinh.getText().equals("")) {
            dem++;
            JOptionPane.showMessageDialog(this, "Đơn vị tính không được để trống !");
            return;
        } else {
            sp.setDonViTinh(txt_donViTinh.getText());
        }
        try {
            if (txt_giaNhap.getText().equals("")) {
                dem++;
                JOptionPane.showMessageDialog(this, "Giá nhập không được để trống !");
                return;
            } else if (Integer.parseInt(txt_giaNhap.getText()) <= 0) {
                dem++;
                JOptionPane.showMessageDialog(this, "Giá nhập phải lớn hơn 0 !");
                return;
            } else {
                sp.setGiaNhap(txt_giaNhap.getText());
            }
        } catch (Exception e) {
            dem++;
            JOptionPane.showMessageDialog(this, "Giá nhập không được chứa chữ !");
            return;
        }
        try {
            if (txt_giaBan.getText().equals("")) {
                dem++;
                JOptionPane.showMessageDialog(this, "Giá bán không được để trống !");
                return;
            } else if (Integer.parseInt(txt_giaBan.getText()) <= 0) {
                dem++;
                JOptionPane.showMessageDialog(this, "Giá bán phải lớn hơn 0 !");
                return;
            } else {
                sp.setGiaBan(txt_giaBan.getText());
            }
        } catch (Exception e) {
            dem++;
            JOptionPane.showMessageDialog(this, "Giá bán không được chứa chữ !");
            return;
        }
        try {
            if (txt_soLuong.getText().equals("")) {
                dem++;
                JOptionPane.showMessageDialog(this, "Số lượng không được để trống !");
                return;
            } else if (Integer.parseInt(txt_soLuong.getText()) <= 0) {
                dem++;
                JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0 !");
                return;
            } else {
                sp.setSoLuong(Integer.parseInt(txt_soLuong.getText()));
            }
        } catch (Exception e) {
            dem++;
            JOptionPane.showMessageDialog(this, "Số lượng không được chứa chữ !");
            return;
        }
        if (dem == 0) {
            listSP.set(index, sp);
            saveFile();
            getData(listSP);
            reset();
            JOptionPane.showMessageDialog(this, "Cập nhật thành công !");
        } else {
            JOptionPane.showMessageDialog(this, "Cập nhật thất bại !");

        }
    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        Integer confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn xóa không?", "Xóa", 2);
        if (confirm == JOptionPane.YES_OPTION) {
            if (listSP.remove(sp)) {
                saveFile();
                getData(listSP);
                reset();
                JOptionPane.showMessageDialog(this, "Xóa thành công sản phẩm " + sp.getTen());
            } else {
                JOptionPane.showMessageDialog(this, "Xóa sản phẩm thất bại!");
            }
        }
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void btn_thoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thoatActionPerformed
        reset();
    }//GEN-LAST:event_btn_thoatActionPerformed

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        String tuKhoa = txt_search.getText();
        if (tuKhoa.equals("")) {
            getData(listSP);
        } else {
            ArrayList<SanPham> listSearch = new ArrayList<>();
            for (int i = 0; i < listSP.size(); i++) {
                if (listSP.get(i).getMaSP().contains(tuKhoa) || listSP.get(i).getTen().contains(tuKhoa) || listSP.get(i).getTenNSX().contains(tuKhoa)) {
                    listSearch.add(listSP.get(i));
                }
            }
            getData(listSearch);
        }
    }//GEN-LAST:event_btn_searchActionPerformed
    int index;
    private void table_Data_SPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_Data_SPMouseClicked
        // TODO add your handling code here:
        int row = table_Data_SP.getSelectedRow();
        String masp = table_Data_SP.getValueAt(row, 0).toString();
        for (int i = 0; i < listSP.size(); i++) {
            if (masp.equals(listSP.get(i).getMaSP())) {
                sp = listSP.get(i);
                index = i;
                break;
            }
        }
        btn_them.setEnabled(false);
        txt_maSP.setEnabled(false);

        txt_maSP.setText(sp.getMaSP());
        txt_tenSP.setText(sp.getTen());
        txt_donViTinh.setText(sp.getDonViTinh());
        txt_giaNhap.setText(sp.getGiaNhap());
        txt_giaBan.setText(sp.getGiaBan());
        txt_soLuong.setText(String.valueOf(sp.getSoLuong()));
        txt_tenNSX.setText(sp.getTenNSX());
    }//GEN-LAST:event_table_Data_SPMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_search;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_thoat;
    private javax.swing.JButton btn_xoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_MaNV2;
    private javax.swing.JLabel lbl_email1;
    private javax.swing.JLabel lbl_gioiTinh1;
    private javax.swing.JLabel lbl_hello;
    private javax.swing.JLabel lbl_hoVaTen1;
    private javax.swing.JLabel lbl_soDienThoai1;
    private javax.swing.JTable table_Data_SP;
    private javax.swing.JTextField txt_donViTinh;
    private javax.swing.JTextField txt_giaBan;
    private javax.swing.JTextField txt_giaNhap;
    private javax.swing.JLabel txt_hello;
    private javax.swing.JTextField txt_maSP;
    private javax.swing.JTextField txt_search;
    private javax.swing.JTextField txt_soLuong;
    private javax.swing.JTextField txt_tenNSX;
    private javax.swing.JTextField txt_tenSP;
    // End of variables declaration//GEN-END:variables
}
