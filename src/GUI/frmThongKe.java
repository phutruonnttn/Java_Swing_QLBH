/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import OBJ.HoaDon;
import OBJ.NhanVien;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Date;
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
public class frmThongKe extends javax.swing.JPanel implements java.beans.Customizer {

    private Object bean;
    private DefaultTableModel defaultTableModel;
    ValidateData validate = new ValidateData();
    NhanVien nv = new NhanVien();
    ArrayList<HoaDon> listHD = new ArrayList<>();
    NumberFormat formatter = new DecimalFormat("###,###");
    /**
     * Creates new customizer frmNhanVien
     */
    public frmThongKe() {
        initComponents();
        //setSize(856, 577);
        lbl_hello.setText("Xin chào, " + frmLogin.nameLogin + " !");
        loadFile();
    }

    public void setObject(Object bean) {
        this.bean = bean;
    }

    public void loadFile() {
        try {
            BufferedReader br = null;
            FileReader fr = null;
            listHD = new ArrayList<>(); //lưu ý
            fr = new FileReader("hoadon.txt");
            br = new BufferedReader(fr);
            String s = null;
            try {
                while ((s = br.readLine()) != null) {
                    //Cắt chuỗi:
                    String arr[] = s.split("\t");
                    //Khởi tạo
                    HoaDon hd = new HoaDon();
                    hd.setMaHD(arr[0]);
                    hd.setMaNV(arr[1]);
                    hd.setMaKH(arr[2]);
                    hd.setMaSP(arr[3]);
                    hd.setSoLuong(Integer.parseInt(arr[4]));
                    hd.setDonGia(Double.parseDouble(arr[5]));
                    hd.setThanhTien(Double.parseDouble(arr[6]));
                    hd.setNgayBan(arr[7]);
                    listHD.add(hd);
                }
            } catch (IOException ex) {
                Logger.getLogger(frmThongKe.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(frmThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

  
    
    private void getData() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date date = Jdate.getDate();
        String date_str = sdf.format(date);
        //System.out.println(date_str);
        
        if (date_str.equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn phải nhập ngày muốn thống kê");
        } else {
            if (txt_maNV.getText().equals("")) {
                defaultTableModel = new DefaultTableModel();
                defaultTableModel.addColumn("Mã HD");
                defaultTableModel.addColumn("Tên Sản phẩm");
                defaultTableModel.addColumn("Số lượng");
                defaultTableModel.addColumn("Đơn giá");
                defaultTableModel.addColumn("Thành tiền");

                for (HoaDon obj : listHD) {
                    if (obj.getNgayBan().equals(date_str)) {
                        SanPham sp = getSP(obj.getMaSP());
                        Vector vector = new Vector();
                        vector.add(obj.getMaHD());
                        vector.add(sp.getTen());
                        vector.add(formatter.format(obj.getSoLuong()));
                        vector.add(formatter.format(Double.parseDouble(sp.getGiaBan())));
                        vector.add(formatter.format(obj.getThanhTien()));
                        defaultTableModel.addRow(vector);
                    }

                }
                table_Data_TK.setModel(defaultTableModel);
            } else {
               defaultTableModel = new DefaultTableModel();
                defaultTableModel.addColumn("Mã HD");
                defaultTableModel.addColumn("Tên Sản phẩm");
                defaultTableModel.addColumn("Số lượng");
                defaultTableModel.addColumn("Đơn giá");
                defaultTableModel.addColumn("Thành tiền");

                for (HoaDon obj : listHD) {
                    if (obj.getNgayBan().equals(date_str)&&obj.getMaNV().equals(txt_maNV)) {
                        SanPham sp = getSP(obj.getMaSP());
                        Vector vector = new Vector();
                        vector.add(obj.getMaHD());
                        vector.add(sp.getTen());
                        vector.add(formatter.format(obj.getSoLuong()));
                        vector.add(formatter.format(Double.parseDouble(sp.getGiaBan())));
                        vector.add(formatter.format(obj.getThanhTien()));
                        defaultTableModel.addRow(vector);
                    }

                }
                table_Data_TK.setModel(defaultTableModel);
            }
        }

    }
    public SanPham getSP(String maSP){
        frmSanPham frmSP = new frmSanPham();
        frmSP.loadFile();
        for (int i = 0; i < frmSP.listSP.size(); i++) {
            if(maSP.equals(frmSP.listSP.get(i).getMaSP())){
                return frmSP.listSP.get(i);
            }
        }
        return null;
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
        table_Data_TK = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lbl_MaNV2 = new javax.swing.JLabel();
        Jdate = new com.toedter.calendar.JDateChooser();
        lbl_MaNV3 = new javax.swing.JLabel();
        txt_maNV = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
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
        jLabel1.setText("BÁO CÁO THỐNG KÊ");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 367, Short.MAX_VALUE)
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

        table_Data_TK.setModel(new javax.swing.table.DefaultTableModel(
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
        table_Data_TK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_Data_TKMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_Data_TK);

        add(jScrollPane2);
        jScrollPane2.setBounds(0, 230, 1020, 290);

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

        jPanel4.setBackground(new java.awt.Color(255, 255, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 1, 13), new java.awt.Color(0, 153, 255))); // NOI18N

        lbl_MaNV2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_MaNV2.setForeground(new java.awt.Color(0, 51, 204));
        lbl_MaNV2.setText("Ngày tháng năm");

        lbl_MaNV3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_MaNV3.setForeground(new java.awt.Color(0, 51, 204));
        lbl_MaNV3.setText("Mã Nhân Viên");

        txt_maNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_maNVActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon/chart.png"))); // NOI18N
        jButton1.setText("Thống kê");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_MaNV2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Jdate, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(lbl_MaNV3)
                .addGap(18, 18, 18)
                .addComponent(txt_maNV, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jButton1)
                .addContainerGap(68, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Jdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_MaNV2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_MaNV3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_maNV, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        add(jPanel4);
        jPanel4.setBounds(110, 90, 810, 100);

        txt_hello.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txt_hello.setForeground(new java.awt.Color(255, 255, 255));
        add(txt_hello);
        txt_hello.setBounds(810, 60, 200, 0);

        lbl_hello.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        lbl_hello.setForeground(new java.awt.Color(255, 255, 255));
        lbl_hello.setText("Xin chào ...");
        add(lbl_hello);
        lbl_hello.setBounds(110, 60, 470, 16);

        jLabel2.setBackground(new java.awt.Color(255, 255, 205));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/blur.jpg"))); // NOI18N
        add(jLabel2);
        jLabel2.setBounds(-160, 0, 1190, 560);
    }// </editor-fold>//GEN-END:initComponents

    private void table_Data_TKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_Data_TKMouseClicked

    }//GEN-LAST:event_table_Data_TKMouseClicked

    private void txt_maNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_maNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_maNVActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       getData();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser Jdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_MaNV2;
    private javax.swing.JLabel lbl_MaNV3;
    private javax.swing.JLabel lbl_hello;
    private javax.swing.JTable table_Data_TK;
    private javax.swing.JLabel txt_hello;
    private javax.swing.JTextField txt_maNV;
    // End of variables declaration//GEN-END:variables
}
