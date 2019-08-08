/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import OBJ.NhanVien;
import Utils.ValidateData;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import static java.util.Collections.list;
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
public class frmNhanVien extends javax.swing.JPanel implements java.beans.Customizer {

    private Object bean;
    private DefaultTableModel defaultTableModel;
    ValidateData validate = new ValidateData();
    NhanVien nv = new NhanVien();
    ArrayList<NhanVien> listNV = new ArrayList<>();

    /**
     * Creates new customizer frmNhanVien
     */
    public frmNhanVien() {
        initComponents();
        //setSize(856, 577);
        lbl_hello.setText("Xin chào, " + frmLogin.nameLogin + " !");
        loadFile();
        getData(listNV);

    }

    public void setObject(Object bean) {
        this.bean = bean;
    }

    public void loadFile() {
        try {
            BufferedReader br = null;
            FileReader fr = null;
            listNV = new ArrayList<>(); //lưu ý
            fr = new FileReader("nhanvien.txt");
            br = new BufferedReader(fr);
            String s = null;
            try {
                while ((s = br.readLine()) != null) {
                    //Cắt chuỗi:
                    String arr[] = s.split("\t");
                    //Khởi tạo
                    NhanVien nv = new NhanVien();
                    nv.setMaNhanVien(arr[0]);
                    nv.setHoTen(arr[1]);
                    nv.setSoDienThoai(arr[2]);
                    nv.setEmail(arr[3]);
                    nv.setMatKhau(arr[4]);
                    nv.setNhom(Integer.parseInt(arr[5]));
                    nv.setGioiTinh(arr[6]);
                    nv.setTrangThai(Integer.parseInt(arr[7]));
                    listNV.add(nv);
                }
            } catch (IOException ex) {
                Logger.getLogger(frmNhanVien.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(frmNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void saveFile() {

        try {
            BufferedWriter bw = null; //Khởi tạo
            FileWriter fw = null; //Khởi tạo
            String data = ""; //Tạo một string data bằng rỗng.
            for (int i = 0; i < listNV.size(); i++) {
                String row = ""; //tạo hàng rỗng
                row = row + listNV.get(i).getMaNhanVien() + "\t";
                row = row + listNV.get(i).getHoTen() + "\t";
                row = row + listNV.get(i).getSoDienThoai() + "\t";
                row = row + listNV.get(i).getEmail() + "\t";
                row = row + listNV.get(i).getMatKhau() + "\t";
                row = row + listNV.get(i).getNhom() + "\t";
                row = row + listNV.get(i).getGioiTinh() + "\t";
                row = row + listNV.get(i).getTrangThai() + "\n";
                data += row;
            }
            fw = new FileWriter("nhanvien.txt");
            bw = new BufferedWriter(fw);
            bw.write(data);
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(frmNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void getData(ArrayList<NhanVien> listNV) {
        defaultTableModel = new DefaultTableModel();
        defaultTableModel.addColumn("Mã NV");
        defaultTableModel.addColumn("Họ tên NV");
        defaultTableModel.addColumn("Giới tính");
        defaultTableModel.addColumn("Email");
        defaultTableModel.addColumn("SĐT");
        defaultTableModel.addColumn("Nhóm");
        defaultTableModel.addColumn("Trạng Thái");

        for (NhanVien obj : listNV) {
            Vector vector = new Vector();
            vector.add(obj.getMaNhanVien());
            vector.add(obj.getHoTen());
            vector.add(obj.getGioiTinh());
            vector.add(obj.getEmail());
            vector.add(obj.getSoDienThoai());
            vector.add(obj.getNhom() == 1 ? "Quản lý" : "Nhân viên");
            vector.add(obj.getTrangThai() == 1 ? "Hoạt động" : "Đã khóa");
            defaultTableModel.addRow(vector);
        }
        table_Data_NV.setModel(defaultTableModel);
    }

    public boolean checkMaNV(String maNV) {
        for (int i = 0; i < listNV.size(); i++) {
            if (maNV.equals(listNV.get(i).getMaNhanVien())) {
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
        jPasswordField1 = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_Data_NV = new javax.swing.JTable();
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
        txt_nhomNhanVien1 = new javax.swing.JLabel();
        txt_nhom = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txt_trangThai = new javax.swing.JComboBox<>();
        txt_maNV = new javax.swing.JTextField();
        txt_gioiTinh = new javax.swing.JComboBox<>();
        txt_email = new javax.swing.JTextField();
        txt_soDienThoai = new javax.swing.JTextField();
        txt_matKhau = new javax.swing.JPasswordField();
        txt_hoTen = new javax.swing.JTextField();
        txt_hello = new javax.swing.JLabel();
        lbl_hello = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jPasswordField1.setText("jPasswordField1");

        setBackground(new java.awt.Color(255, 140, 18));
        setForeground(new java.awt.Color(0, 51, 204));
        setPreferredSize(new java.awt.Dimension(1059, 680));
        setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 115, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("QUẢN LÝ NHÂN VIÊN");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 358, Short.MAX_VALUE)
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

        table_Data_NV.setModel(new javax.swing.table.DefaultTableModel(
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
        table_Data_NV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_Data_NVMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_Data_NV);

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
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "THÔNG TIN NHÂN VIÊN\n", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 1, 13), new java.awt.Color(0, 153, 255))); // NOI18N

        lbl_MaNV2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_MaNV2.setForeground(new java.awt.Color(0, 51, 204));
        lbl_MaNV2.setText("Mã Nhân Viên");

        lbl_hoVaTen1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_hoVaTen1.setForeground(new java.awt.Color(0, 51, 204));
        lbl_hoVaTen1.setText("Họ và tên");

        lbl_gioiTinh1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_gioiTinh1.setForeground(new java.awt.Color(0, 51, 204));
        lbl_gioiTinh1.setText("Giới tính");

        lbl_email1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_email1.setForeground(new java.awt.Color(0, 51, 204));
        lbl_email1.setText("Email");

        lbl_soDienThoai1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_soDienThoai1.setForeground(new java.awt.Color(0, 51, 204));
        lbl_soDienThoai1.setText("SĐT");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 51, 204));
        jLabel7.setText("Mật khẩu");

        txt_nhomNhanVien1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_nhomNhanVien1.setForeground(new java.awt.Color(0, 51, 204));
        txt_nhomNhanVien1.setText("Nhóm NV");

        txt_nhom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quản lý", "Nhân Viên" }));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 51, 204));
        jLabel8.setText("Trạng Thái");

        txt_trangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Deactive" }));
        txt_trangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_trangThaiActionPerformed(evt);
            }
        });

        txt_gioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));
        txt_gioiTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_gioiTinhActionPerformed(evt);
            }
        });

        txt_matKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_matKhauActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(lbl_soDienThoai1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_soDienThoai))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbl_MaNV2)
                                .addComponent(txt_nhomNhanVien1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txt_maNV, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(txt_nhom, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_matKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_hoVaTen1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_gioiTinh1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_email1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_email)
                    .addComponent(txt_gioiTinh, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_trangThai, 0, 155, Short.MAX_VALUE)
                    .addComponent(txt_hoTen))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_maNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_MaNV2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_hoVaTen1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_hoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nhom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nhomNhanVien1)
                    .addComponent(lbl_gioiTinh1)
                    .addComponent(txt_gioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_soDienThoai1)
                    .addComponent(txt_soDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_email1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_trangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_matKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        txt_nhomNhanVien1.getAccessibleContext().setAccessibleName("Địa chỉ");

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
        lbl_hello.setBounds(40, 60, 470, 16);

        jLabel2.setBackground(new java.awt.Color(255, 255, 205));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/blur.jpg"))); // NOI18N
        add(jLabel2);
        jLabel2.setBounds(-160, 0, 1190, 560);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        String maNV =  txt_maNV.getText();
        String tenNV = txt_hoTen.getText();
        String email = txt_email.getText();
        String sdt = txt_soDienThoai.getText();
        String matKhau = txt_matKhau.getText();
        String gioiTinh = "";
        if(txt_gioiTinh.getSelectedItem().equals("Nam")){
            gioiTinh = "Nam";
        }else if(txt_gioiTinh.getSelectedItem().equals("Nữ")){
            gioiTinh = "Nữ";
        }else{
            gioiTinh = "Khác";
        }
        int nhom = 0;
        if(txt_nhom.getSelectedItem().toString().equals("Quản lý")){
            nhom = 1;
        }else{
            nhom = 0;
        }
        int trangThai = 0;
        if(txt_trangThai.getSelectedItem().toString().equals("Active")){
            trangThai = 1;
        }else{
            trangThai = 0;
        }
        if(maNV.equals("")){
            JOptionPane.showMessageDialog(this, "Mã nhân viên không được để trống !");
            return;
        }else{
            NhanVien nv = new NhanVien();
            nv.setMaNhanVien(maNV);
            nv.setEmail(email);
            nv.setGioiTinh(gioiTinh);
            nv.setHoTen(tenNV);
            nv.setSoDienThoai(sdt);
            nv.setNhom(nhom);
            nv.setTrangThai(trangThai);
            nv.setMatKhau(validate.md5(matKhau));
            listNV.add(nv);
            saveFile();
            getData(listNV);
            JOptionPane.showMessageDialog(this, "Thêm nhân viên thành công !");
            reset();
        }
        
        
    }//GEN-LAST:event_btn_themActionPerformed
    public void reset() {
        txt_email.setText("");
        txt_maNV.setText("");
        txt_hoTen.setText("");
        txt_matKhau.setText("");
        txt_soDienThoai.setText("");
        txt_trangThai.setSelectedIndex(0);
        txt_nhom.setSelectedIndex(0);
        txt_gioiTinh.setSelectedIndex(0);
        btn_them.setEnabled(true);
        btn_sua.setEnabled(true);
        btn_xoa.setEnabled(true);
        txt_maNV.setEnabled(true);
        txt_matKhau.setEnabled(true);
        getData(listNV);
    }
    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed

        String tenNV = txt_hoTen.getText();
        String email = txt_email.getText();
        String sdt = txt_soDienThoai.getText();
        String matKhau = txt_matKhau.getText();
        String gioiTinh = "";
        if(txt_gioiTinh.getSelectedItem().equals("Nam")){
            gioiTinh = "Nam";
        }else if(txt_gioiTinh.getSelectedItem().equals("Nữ")){
            gioiTinh = "Nữ";
        }else{
            gioiTinh = "Khác";
        }
        int nhom = 0;
        if(txt_nhom.getSelectedItem().toString().equals("Quản lý")){
            nhom = 1;
        }else{
            nhom = 0;
        }
        int trangThai = 0;
        if(txt_trangThai.getSelectedItem().toString().equals("Active")){
            trangThai = 1;
        }else{
            trangThai = 0;
        }
        nv.setEmail(email);
        nv.setGioiTinh(gioiTinh);
        nv.setHoTen(tenNV);
        nv.setSoDienThoai(sdt);
        nv.setNhom(nhom);
        nv.setTrangThai(trangThai);
        nv.setMatKhau(validate.md5(matKhau));
        listNV.set(index, nv);
        saveFile();
        getData(listNV);
        JOptionPane.showMessageDialog(this, "Chỉnh sửa thành công !");
        reset();
    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        Integer confirm = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa không ?", "Xóa", 2);
        if(confirm== JOptionPane.YES_OPTION){
            if(listNV.remove(nv)){
                saveFile();
                getData(listNV);
                JOptionPane.showMessageDialog(this,"Xóa thành công nhân viên "+nv.getHoTen());
            }else{
                JOptionPane.showMessageDialog(this, "Xóa thất bại");
            }
        }
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void btn_thoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thoatActionPerformed
        reset();
    }//GEN-LAST:event_btn_thoatActionPerformed

    private void txt_matKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_matKhauActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_matKhauActionPerformed

    private void txt_gioiTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_gioiTinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_gioiTinhActionPerformed

    private void txt_trangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_trangThaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_trangThaiActionPerformed

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        String tuKhoa = txt_search.getText();
        if(tuKhoa.equals("")){
            getData(listNV);
        }else{
            ArrayList<NhanVien> listResult = new ArrayList<>();
            for (int i = 0; i < listNV.size(); i++) {
                if(listNV.get(i).getHoTen().contains(tuKhoa) || listNV.get(i).getEmail().contains(tuKhoa)){
                    listResult.add(listNV.get(i));
                }
            }
            getData(listResult);
        }
    }//GEN-LAST:event_btn_searchActionPerformed
    int index;
    private void table_Data_NVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_Data_NVMouseClicked
        int row = table_Data_NV.getSelectedRow();
        String maNV = table_Data_NV.getValueAt(row, 0).toString();
        for (int i = 0; i < listNV.size(); i++) {
            if(maNV.equalsIgnoreCase(listNV.get(i).getMaNhanVien())){
                nv = listNV.get(i);
                index = i;
                break;
            }
        }
        txt_maNV.setEnabled(false);
        txt_maNV.setText(nv.getMaNhanVien());
        txt_hoTen.setText(nv.getHoTen());
        txt_email.setText(nv.getEmail());
        txt_soDienThoai.setText(nv.getSoDienThoai());
        txt_matKhau.setText(nv.getMatKhau());
        txt_matKhau.setEnabled(false);
        if(nv.getGioiTinh().equals("Nam")){
            txt_gioiTinh.setSelectedItem("Nam");
        }else if(nv.getGioiTinh().equals("Nữ")){
            txt_gioiTinh.setSelectedItem("Nữ");
        }else{
            txt_gioiTinh.setSelectedItem("Khác");
        }
        if(nv.getNhom() == 1){
            txt_nhom.setSelectedItem("Quản lý");
        }else{
            txt_nhom.setSelectedItem("Nhân viên");
        }
        if(nv.getTrangThai()== 1){
            txt_trangThai.setSelectedItem("Active");
        }else{
            txt_trangThai.setSelectedItem("Deactive");
        }
        btn_them.setEnabled(false);
        
        
    }//GEN-LAST:event_table_Data_NVMouseClicked


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
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_MaNV2;
    private javax.swing.JLabel lbl_email1;
    private javax.swing.JLabel lbl_gioiTinh1;
    private javax.swing.JLabel lbl_hello;
    private javax.swing.JLabel lbl_hoVaTen1;
    private javax.swing.JLabel lbl_soDienThoai1;
    private javax.swing.JTable table_Data_NV;
    private javax.swing.JTextField txt_email;
    private javax.swing.JComboBox<String> txt_gioiTinh;
    private javax.swing.JLabel txt_hello;
    private javax.swing.JTextField txt_hoTen;
    private javax.swing.JTextField txt_maNV;
    private javax.swing.JPasswordField txt_matKhau;
    private javax.swing.JComboBox<String> txt_nhom;
    private javax.swing.JLabel txt_nhomNhanVien1;
    private javax.swing.JTextField txt_search;
    private javax.swing.JTextField txt_soDienThoai;
    private javax.swing.JComboBox<String> txt_trangThai;
    // End of variables declaration//GEN-END:variables
}
