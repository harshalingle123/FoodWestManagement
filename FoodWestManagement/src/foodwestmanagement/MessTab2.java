/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodwestmanagement;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.text.*;
/**
 *
 * @author code
 */
public class MessTab2 extends javax.swing.JFrame {

    /**
     * Creates new form MessTab2
     */
    public String icomp;
    public String cmpdish[];
    int id;
    
    public MessTab2() {
        initComponents();
        ShowData();
        CheckBoxDemo();
        UCombo();
        ShowWeek();
        ComboRefresh();
        showIngredence();
        varInit();
        waste();
        wastss();

    }
   
    public void varInit()
    {
         icomp="";
         cmpdish=new String[10];
         id=0;
    }
    
    public void showIngredence()
    {
       iitem.setModel(new DefaultTableModel(null,new String[]{"Item","Ingredence"}));
       qitem.setModel(new DefaultTableModel(null,new String[]{"Ingredence","Quntity"}));
       
        
        DefaultTableModel item=(DefaultTableModel)iitem.getModel();
        DefaultTableModel quntity=(DefaultTableModel)qitem.getModel();
        
             
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/MessInfo","root","harshal123");
            
            PreparedStatement pre1=con.prepareStatement("select * from ingItem");
            PreparedStatement pre2=con.prepareStatement("select * from ingQuntity");
            
            
            ResultSet rs1=pre1.executeQuery();
            ResultSet rs2=pre2.executeQuery();
                 

            ResultSetMetaData rsmd=rs1.getMetaData();
             
            int count=rsmd.getColumnCount();
            String intplus="";
            while(rs1.next())
            {
                 for(int i=2; i<=count; i++)
                 {
                     if(!rs1.wasNull())
                     {
                      intplus=intplus+rs1.getString(i)+",";
                     }
                 }
                 
                 item.addRow(new Object[]{rs1.getString(1), intplus});
                 intplus="";
            }
            
            while(rs2.next())
            {
                quntity.addRow(new Object[]{rs2.getString(1), rs2.getInt(2)});
            }
            
            
              
            
             
              
            
            
              pre1.execute();
              pre2.execute();
             
             con.close();
            
           
           
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(this,e);
        }
        
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,e);
        }
    }
    
    public void ComboRefresh()
    {
         try
         {
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/MessInfo","root","harshal123");
            
            
          
            
            PreparedStatement pre2=con.prepareStatement("select * from ingItem");
            
            ResultSet rs=pre2.executeQuery();
            citem.removeAllItems();
            while(rs.next())
            {
               citem.addItem(rs.getString(1));
            }
            con.close();
            
          
         }
         catch(SQLException e)
         {
                   JOptionPane.showMessageDialog(this, e);      
         }
         catch(Exception e)
         {
                   JOptionPane.showMessageDialog(this, e);  
         }

    }
 
    
    public void UCombo()
    {
        citem.removeAllItems();
          
       
       try
       {
          Class.forName("com.mysql.jdbc.Driver");
          
          Connection con=DriverManager.getConnection("jdbc:mysql://localhost/MessInfo","root","harshal123");
          
          PreparedStatement pre1=con.prepareStatement("select * from ingItem");
          PreparedStatement pre2=con.prepareStatement("select * from ingQuntity");
          
          ResultSet rs1=pre1.executeQuery();
          ResultSet rs2=pre2.executeQuery();
      
          lanch.removeAllItems();
          brekfast.removeAllItems();
          
          while(rs1.next())
          {
               lanch.addItem(rs1.getString(1));
          }
          
          while(rs2.next())
          {
              brekfast.addItem(rs2.getString(1));
          }
          
          pre1.execute();
          pre2.execute();
          
          con.close();
       }
       catch(SQLException e)
       {
          JOptionPane.showMessageDialog(this, e);
       }
       catch(Exception e)
       {
          JOptionPane.showMessageDialog(this,e);
       }
    }
      
    public void CheckBoxDemo()
    {
        day.removeAllItems();
        day.addItem("Sunday");
        day.addItem("Monday");
        day.addItem("Tuesday");
        day.addItem("Wednesday");
        day.addItem("Thursday");
        day.addItem("Friday");
        day.addItem("Saturday");
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        rno = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        rfid = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        studqun = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jPanel19 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        qun = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        wasteT = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        owest = new javax.swing.JTable();
        jButton14 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tl = new javax.swing.JTextField();
        td = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel8 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        week = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        day = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lanch = new javax.swing.JComboBox<>();
        brekfast = new javax.swing.JComboBox<>();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        btsumbit = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        rollno = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        rfidno = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel15 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        eitem = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        citem = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        ting = new javax.swing.JTextField();
        tqun = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        iitem = new javax.swing.JTable();
        jButton7 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        qitem = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        stud_present = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        jLabel1.setText("Roll Number:");

        jLabel2.setText("RFID Number:");

        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(rfid, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rno, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(510, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(rno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(rfid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(jButton1)
                .addContainerGap(333, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setText("Number Of Student:");

        studqun.setEnabled(false);
        studqun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studqunActionPerformed(evt);
            }
        });

        jButton4.setText("Refresh");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Menu", "Ingridients and their quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(studqun, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 463, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addGap(26, 26, 26))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(studqun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addGap(48, 48, 48)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(454, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Quantity", jPanel3);

        jLabel5.setText("Enter the staff waste:");

        qun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qunActionPerformed(evt);
            }
        });

        jButton6.setText("Delete all data from the Table");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton13.setText("Submit");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(qun, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jButton6))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(282, 282, 282)
                        .addComponent(jButton13)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(qun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6))
                .addGap(38, 38, 38)
                .addComponent(jButton13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Enter Wastage", jPanel19);

        jLabel6.setText("Penalty");

        jLabel7.setText("Overall Wastage");

        wasteT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "RFID Number", "Student Name", "Absent Penalty", "Wastage Penalty"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(wasteT);

        owest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Days", "Student Lunch Wastage", "Student Dinner Wastage", "Staff LunchWastage", "Staff Dinner Wastage"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(owest);

        jButton14.setText("Refresh");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jLabel8.setText("Total Wastage in Lunch:");

        jLabel9.setText("Total Wastage in Dinner:");

        tl.setEnabled(false);

        td.setEnabled(false);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton14)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 31, Short.MAX_VALUE))
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(263, 263, 263)
                        .addComponent(jLabel7))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel18Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(1, 1, 1)
                                .addComponent(td))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel18Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(3, 3, 3)
                                .addComponent(tl, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(44, 44, 44)
                .addComponent(jButton14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(tl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(td, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );

        jTabbedPane5.addTab("Show Wastage", jPanel18);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jTabbedPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 818, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 62, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jTabbedPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 287, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Waste Management ", jPanel4);

        week.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Day", "Morning", "Night"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(week);

        jButton5.setText("Refresh");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 804, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton5)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Week", jPanel10);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane3)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Show Food", jPanel8);

        day.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, day, org.jdesktop.beansbinding.ObjectProperty.create(), day, org.jdesktop.beansbinding.BeanProperty.create("elements"));
        bindingGroup.addBinding(binding);

        day.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayActionPerformed(evt);
            }
        });

        jLabel4.setText("Lunch:");

        jLabel11.setText("Dinner:");

        lanch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        brekfast.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton11.setText("Add");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setText("Add");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(day, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jLabel4)
                .addGap(36, 36, 36)
                .addComponent(lanch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jLabel11)
                .addGap(26, 26, 26)
                .addComponent(brekfast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(122, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel11)
                    .addComponent(lanch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(brekfast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11)
                    .addComponent(jButton12))
                .addContainerGap(355, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Enter Food", jPanel7);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(177, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Food Storage", jPanel5);

        btsumbit.setText("Submit");
        btsumbit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsumbitActionPerformed(evt);
            }
        });

        jLabel14.setText("Roll Number: ");

        jLabel15.setText("RFID Number:");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15))
                        .addGap(57, 57, 57)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(rollno)
                            .addComponent(rfidno, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(btsumbit)))
                .addContainerGap(548, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(rollno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(rfidno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btsumbit)
                .addContainerGap(485, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("User Registeration", jPanel14);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 880, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 641, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Other", jPanel6);

        jLabel16.setText("Enter Item:");

        jButton8.setText("Add");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        citem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel19.setText("Ingredients:");

        jButton9.setText("Submit");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel18.setText("Quntity");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(citem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(eitem, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17)
                        .addGap(26, 26, 26)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(102, 102, 102))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ting, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                        .addComponent(jLabel18)
                        .addGap(18, 18, 18)))
                .addComponent(tqun, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(jButton9)
                .addContainerGap(155, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(eitem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8))
                .addGap(33, 33, 33)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(citem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(ting, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tqun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(jButton9))
                .addContainerGap(489, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Food Quntity Storage", jPanel15);

        jLabel20.setText("Item");

        jLabel21.setText("Ingredient");

        iitem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Ingredence"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(iitem);
        if (iitem.getColumnModel().getColumnCount() > 0) {
            iitem.getColumnModel().getColumn(0).setResizable(false);
            iitem.getColumnModel().getColumn(1).setResizable(false);
        }

        jButton7.setText("Refresh");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        qitem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ingredient", "Quntity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(qitem);
        if (qitem.getColumnModel().getColumnCount() > 0) {
            qitem.getColumnModel().getColumn(0).setResizable(false);
            qitem.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(jLabel20)
                        .addGap(312, 312, 312)
                        .addComponent(jLabel21))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(328, 328, 328)
                        .addComponent(jButton7)))
                .addContainerGap(332, Short.MAX_VALUE))
            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                    .addContainerGap(384, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(122, 122, 122)))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jButton7)
                .addContainerGap(378, Short.MAX_VALUE))
            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel16Layout.createSequentialGroup()
                    .addGap(53, 53, 53)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(441, Short.MAX_VALUE)))
        );

        jTabbedPane4.addTab("Food Quntity Display", jPanel16);

        jTabbedPane1.addTab("Food Quantity", jTabbedPane4);

        stud_present.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Rool No", "Name", "RFID No", "Mobile Number", "Email ID"
            }
        ));
        jScrollPane1.setViewportView(stud_present);

        jButton2.setText("Refresh");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Clear");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 156, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton3)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(530, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Number Of Present Student", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addGap(63, 63, 63))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try
        {
            Class.forName("com.mysql.jdbc.Driver");

            Connection con1=DriverManager.getConnection("jdbc:mysql://localhost/mess","root","harshal123");
            Connection con2=DriverManager.getConnection("jdbc:mysql://localhost/MessInfo"+"?useSSL=false","root","harshal123");
            

            PreparedStatement pre1=con1.prepareStatement("select * from Student");
            String qur="insert into userInfo (rollno,name, RFIDNO)"+"values(?,?,?)";

            PreparedStatement pre2=con2.prepareStatement(qur,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            
            
            PreparedStatement pre3=con2.prepareStatement("select * from userInfo");
            
            ResultSet rs=pre1.executeQuery();
            ResultSet rs2=pre3.executeQuery();
            System.out.println(rs2.toString());
            int status=0,check=0;
            while(rs.next() )
            {
                if(rs2.getRow()==0)
                {
                 if(rs.getInt(1)==Integer.parseInt(rno.getText()))
                {
                    pre2.setInt(1,rs.getInt(1));
                    pre2.setString(2,rs.getString("name"));
                    pre2.setInt(3,Integer.parseInt(rfid.getText()));
                    pre2.execute();
                    JOptionPane.showMessageDialog(this,"Suceesful Registeration!!!!!!!!");
                    status=0;
                    check=1;
                    break;
                }
                else
                {
                    status=1;
                }
                
                   
                }
                else
                { 
                    while(rs2.next())
                    {   
                          if(rs.getInt(1)==Integer.parseInt(rno.getText()) && Integer.parseInt(rno.getText())== rs2.getInt(1))
                           {     
                                       status=0;
                                       check=1;
                                       break;
                            }     
                            else
                            {
                                    status=1;
                            }
                
                  }
               }
                        
          
                   
            }

            if(status==0)
            {
                JOptionPane.showMessageDialog(this,"Student Unauthorize!!!!!!!!!!! ");
            }
            
            if(check ==0)
            {
                    pre2.setInt(1,rs.getInt(1));
                    pre2.setString(2,rs.getString("name"));
                    pre2.setInt(3,Integer.parseInt(rfid.getText()));
                    pre2.execute();
                    JOptionPane.showMessageDialog(this,"Suceesful Registeration!!!!!!!!");
 
            }



            con1.close();
            con2.close();

        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(this,e);
        }

        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,"Please Enter The Valid UserName And Password!!!!!!!!!!!!!");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        stud_present.setModel(new DefaultTableModel(null,new String[]{"Roll No","Name","RFID","Mobile Number","Email ID"}));
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        stud_present.setModel(new DefaultTableModel(null,new String[]{"Roll No","Name","RFID","Mobile Number","Email ID"}));
        ShowData();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        iitem.setModel(new DefaultTableModel(null,new String[]{"Item","Ingredence"}));
        qitem.setModel(new DefaultTableModel(null,new String[]{"Ingredence","Quntity"}));

        DefaultTableModel item=(DefaultTableModel)iitem.getModel();
        DefaultTableModel quntity=(DefaultTableModel)qitem.getModel();

        try
        {
            Class.forName("com.mysql.jdbc.Driver");

            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/MessInfo","root","harshal123");

            PreparedStatement pre1=con.prepareStatement("select * from ingItem");
            PreparedStatement pre2=con.prepareStatement("select * from ingQuntity");

            ResultSet rs1=pre1.executeQuery();
            ResultSet rs2=pre2.executeQuery();

            ResultSetMetaData rsmd=rs1.getMetaData();

            int count=rsmd.getColumnCount();
            String intplus="";
            while(rs1.next())
            {
                for(int i=2; i<=count; i++)
                {
                    if(rs1.getString(i) != null)
                    {
                        intplus=intplus+rs1.getString(i)+",";
                    }
                }

                item.addRow(new Object[]{rs1.getString(1), intplus});
                intplus="";
            }

            while(rs2.next())
            {
                quntity.addRow(new Object[]{rs2.getString(1), rs2.getInt(2)});
            }

            pre1.execute();
            pre2.execute();

            con.close();

        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(this,e);
        }

        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,e);
        }

    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        String ing=ting.getText();
        int qun=Integer.parseInt(tqun.getText());

        String sitem=(String)citem.getSelectedItem();

        try
        {
            Class.forName("com.mysql.jdbc.Driver");

            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/MessInfo","root","harshal123");

            PreparedStatement pre=con.prepareStatement("Insert Into ingQuntity values(?,?)");
            Statement stm=con.createStatement();

            PreparedStatement cpre=con.prepareStatement("select * from ingItem where item=?");
            cpre.setString(1, sitem);

            ResultSet rs2=cpre.executeQuery();
            ResultSetMetaData rsmd=rs2.getMetaData();

            int count=rsmd.getColumnCount();

            rs2.first();
            int ncount=0,i,status=0;

            for(i=2; i<=count; i++)
            {
                if(ing.equals(rs2.getString(i)))
                {
                    status=1;

                }

            }

            for (i=2; i<=count; i++)
            {

                if(rs2.wasNull() && status==0  )
                {

                    PreparedStatement exeup=con.prepareStatement("update ingItem set item"+i+"=? where item=?");
                    exeup.setString(1,ing);
                    exeup.setString(2,sitem);
                    exeup.executeUpdate();
                    ncount=1;
                    break;
                    //System.out.println("ResultSet");
                }

            }

            if(ncount==0 && status==0)
            {
                stm.execute("alter table ingItem add item"+i+" varchar(50)");
                PreparedStatement exeup=con.prepareStatement("update ingItem set item"+i+"=? where item=?");
                exeup.setString(1,ing);
                exeup.setString(2,sitem);
                exeup.executeUpdate();

            }

            //            stm.execute("alter table ingItem add item1 varchar(50)");

            pre.setString(1, ing);
            pre.setInt(2,qun);

            pre.execute();

            pre.close();

            JOptionPane.showMessageDialog(this, "Save Succesful");

        }

        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(this, e);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed

        String it=eitem.getText();

        try
        {
            Class.forName("com.mysql.jdbc.Driver");

            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/MessInfo","root","harshal123");

            PreparedStatement pre=con.prepareStatement("insert into ingItem(item) values (?)");

            pre.setString(1, it);

            pre.executeUpdate();

            PreparedStatement pre2=con.prepareStatement("select * from ingItem");

            ResultSet rs=pre2.executeQuery();
            citem.removeAllItems();
            while(rs.next())
            {
                citem.addItem(rs.getString(1));
            }
            con.close();

            JOptionPane.showMessageDialog(this, "Item Addeed Successful");
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(this, e);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, e);
        }

    }//GEN-LAST:event_jButton8ActionPerformed

    private void btsumbitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsumbitActionPerformed
        
        
        
                try
           {
            Class.forName("com.mysql.jdbc.Driver");

            Connection con1=DriverManager.getConnection("jdbc:mysql://localhost/mess","root","harshal123");
            Connection con2=DriverManager.getConnection("jdbc:mysql://localhost/MessInfo"+"?useSSL=false","root","harshal123");

            PreparedStatement pre1=con1.prepareStatement("select * from Student");
            String qur="insert into userInfo (rollno,name, RFIDNO)"+"values(?,?,?)";

              PreparedStatement mpre=con2.prepareStatement("insert into MPresent (rfid_no) values(?)");
              PreparedStatement npre=con2.prepareStatement("insert into NPresent (rfid_no) values(?)");
              
              PreparedStatement wpre=con2.prepareStatement("insert into Wastage (rfid_no ,Name) values(?,?)");
              
              
            
            
          
            
            
            PreparedStatement pre2=con2.prepareStatement(qur,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

            PreparedStatement pre3=con2.prepareStatement("select * from userInfo");

            ResultSet rs=pre1.executeQuery();
            ResultSet rs2=pre3.executeQuery();

            int status=0,check=0,count=0;
            while(rs.next() )
            {
                if(rs.getInt(1)==Integer.parseInt(rollno.getText()))
                {
                   System.out.println("aUTHORIZE");

                    status=1;

                    break;

                }

            }
            try
            {
                while(rs2.next())
                {
                    count=rs2.getRow();

                }
            }
            catch(SQLException e)
            {

            }

            System.out.println(count);

            if(count==0 && status==1)
            {
                pre2.setInt(1,rs.getInt(1));
                pre2.setString(2,rs.getString("name"));
                pre2.setInt(3,Integer.parseInt(rfidno.getText()));
                pre2.execute();
                
                mpre.setInt(1, Integer.parseInt(rfidno.getText()));
                mpre.execute();
                
                npre.setInt(1, Integer.parseInt(rfidno.getText()));
                npre.execute();
                
               
               wpre.setInt(1, Integer.parseInt(rfidno.getText()));
               wpre.setString(2, rs.getString("name"));
               wpre.executeUpdate();
                
                System.out.println("row database 0");

                JOptionPane.showMessageDialog(this,"Suceesful Registeration!!!!!!!!");

            }
            rs2.beforeFirst();
            while(rs2.next())
            {
                if(rs2.getInt(1)==Integer.parseInt(rollno.getText()))
                {
                    check=1;
             
                }
            }

            if(check==1)
            JOptionPane.showMessageDialog(this,"Student Already Exist!!!!!!!!");

           
            rs2.beforeFirst();
           
            if(count !=0 && status==1 && check==0 )
            {
                System.out.println("INSIDE");

                while(rs2.next())
                {  
                    pre2.setInt(1,rs.getInt(1));
                    pre2.setString(2,rs.getString("name"));
                    pre2.setInt(3,Integer.parseInt(rfidno.getText()));
                    pre2.execute();
                
                    mpre.setInt(1, Integer.parseInt(rfidno.getText()));
                    mpre.execute();
                    
                    npre.setInt(1, Integer.parseInt(rfidno.getText()));
                    npre.execute();
                
               
                    wpre.setInt(1, Integer.parseInt(rfidno.getText()));
                    wpre.setString(2, rs.getString("name"));
                    wpre.execute();
               
                    JOptionPane.showMessageDialog(this,"Suceesful Registeration!!!!!!!!");

                }
            }

            if(status==0)
            JOptionPane.showMessageDialog(this,"Student Unauthorized!!!!!!!");

            con1.close();
            con2.close();

        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(this,e);
        }

        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,"Please Enter The Roll Number and RFID Number!!!!!!!!!!!!!");
        }
    }//GEN-LAST:event_btsumbitActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        String day1=(String)day.getSelectedItem();
        String lanch1=(String)brekfast.getSelectedItem();

        try
        {
            Class.forName("com.mysql.jdbc.Driver");

            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/MessInfo","root","harshal123");

            PreparedStatement pre =con.prepareStatement("update DayFood set night=? where day=?");
            PreparedStatement pre1=con.prepareStatement("select * from night where day=?");
            pre1.setString(1,day1);
            Statement stm=con.createStatement();
            ResultSet rs=pre1.executeQuery();
            ResultSetMetaData rsm=rs.getMetaData();

            int count =rsm.getColumnCount();

            rs.first();

            int ncount=0,i,status=0;
            String cmsg="";

            for(i=2; i<=count; i++)
            {
                if(lanch1.equals(rs.getString(i)))
                {
                    status=1;

                }

            }

            for(i=2; i<=count; i++)
            {
                cmsg=cmsg+rs.getString(i)+",";
            }

            pre.setString(1,cmsg);
            pre.setString(2,day1);
            pre.executeUpdate();

            for (i=2; i<=count; i++)
            {

                if(rs.wasNull() && status==0  )
                {

                    PreparedStatement exeup=con.prepareStatement("update night set item"+i+"=? where day=?");
                    exeup.setString(1,lanch1);
                    exeup.setString(2,day1);
                    exeup.executeUpdate();
                    ncount=1;

                    break;
                    //System.out.println("ResultSet");
                }

            }

            if(ncount==0 && status==0)
            {
                stm.execute("alter table  night add item"+i+" varchar(50)");
                PreparedStatement exeup=con.prepareStatement("update night set item"+i+"=? where day=?");
                exeup.setString(1,lanch1);
                exeup.setString(2,day1);
                exeup.executeUpdate();

            }

            //            stm.execute("alter table ingItem add item1 varchar(50)");

            con.close();

            if(status==1)
            {
                JOptionPane.showMessageDialog(this, "Item Already Exist!!!!!!!");
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Item Added Successfully!!!!!!!");
            }

        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(this,e);
        }

        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,e);
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        String day1=(String)day.getSelectedItem();
        String lanch1=(String)lanch.getSelectedItem();

        try
        {
            Class.forName("com.mysql.jdbc.Driver");

            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/MessInfo","root","harshal123");

            PreparedStatement pre =con.prepareStatement("update DayFood set mornning=? where day=?");
            PreparedStatement pre1=con.prepareStatement("select * from morning where day=?");
            pre1.setString(1,day1);
            Statement stm=con.createStatement();
            ResultSet rs=pre1.executeQuery();
            ResultSetMetaData rsm=rs.getMetaData();

            int count =rsm.getColumnCount();

            rs.first();

            int ncount=0,i,status=0;
            String cmsg="";

            for(i=2; i<=count; i++)
            {
                if(lanch1.equals(rs.getString(i)))
                {
                    status=1;

                }

            }

            for(i=2; i<=count; i++)
            {
                cmsg=cmsg+rs.getString(i)+",";
            }

            pre.setString(1,cmsg);
            pre.setString(2,day1);
            pre.executeUpdate();

            for (i=2; i<=count; i++)
            {

                if(rs.wasNull() && status==0  )
                {

                    PreparedStatement exeup=con.prepareStatement("update morning set item"+i+"=? where day=?");
                    exeup.setString(1,lanch1);
                    exeup.setString(2,day1);
                    exeup.executeUpdate();
                    ncount=1;

                    break;
                    //System.out.println("ResultSet");
                }

            }

            if(ncount==0 && status==0)
            {
                stm.execute("alter table  morning add item"+i+" varchar(50)");
                PreparedStatement exeup=con.prepareStatement("update morning set item"+i+"=? where day=?");
                exeup.setString(1,lanch1);
                exeup.setString(2,day1);
                exeup.executeUpdate();

            }

            //            stm.execute("alter table ingItem add item1 varchar(50)");

            con.close();

            if(status==1)
            {
                JOptionPane.showMessageDialog(this, "Item Already Exist!!!!!!!");
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Item Added Successfully!!!!!!!");
            }

        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(this,e);
        }

        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,e);
        }

    }//GEN-LAST:event_jButton11ActionPerformed

    private void dayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dayActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        week.setModel(new DefaultTableModel(null,new String[]{"Day","Morning","Night"}));
        ShowWeek();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

      public void waste()
    {
      wasteT.setModel(new DefaultTableModel(null,new String[]{"RFID Number","Name Of The Student","Absent Penalty","Wastage Penalty" }));
      DefaultTableModel w=(DefaultTableModel)wasteT.getModel();
      
      try
      {
          Class.forName("com.mysql.jdbc.Driver");
          Connection con=DriverManager.getConnection("jdbc:mysql://localhost/MessInfo","root","harshal123");
          
          PreparedStatement pre=con.prepareStatement("select * from Wastage ");
          ResultSet rs=pre.executeQuery();
          
          while(rs.next())
          {
               w.addRow(new Object[]{rs.getInt(1), rs.getString(2),rs.getInt(3),rs.getLong(4)});
          }
      }
      catch(SQLException e)
      {
          JOptionPane.showMessageDialog(this,e);
      }
      catch(Exception e)
      {
          JOptionPane.showMessageDialog(this,e);
      }
    }
        
    public void wastss()
    {
      owest.setModel(new DefaultTableModel(null,new String[]{"Day","Student West Morning","Student West Night","Staff West Morning","Staff West Night" }));
      DefaultTableModel wo=(DefaultTableModel)owest.getModel();
      
        
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/MessInfo","root","harshal123");
            PreparedStatement pre=con.prepareStatement("select * from WastageRecord");
            
            ResultSet rs=pre.executeQuery();
            
            while(rs.next())
            {
                wo.addRow(new Object[]{rs.getString(1), rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getInt(5)});
            }
            
            pre.execute();
            
            con.close();
            
        }
        catch(SQLException e)
        {
           JOptionPane.showMessageDialog(this,e);
        }
        catch(Exception e)
        {
           JOptionPane.showMessageDialog(this,e);
        }
    }
    
    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
          waste();
          wastss();
          
          try
          {
              Class.forName("com.mysql.jdbc.Driver");
              Connection con=DriverManager.getConnection("jdbc:mysql://localhost/MessInfo","root","harshal123");
              
           DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	   Date date = new Date();
           String crdate=dateFormat.format(date);

              
              PreparedStatement pre=con.prepareStatement("select * from WastageRecord where day=?");
              pre.setString(1,crdate);
              ResultSet rs=pre.executeQuery();
              
              rs.first();
               
              int twl=rs.getInt(2)+rs.getInt(4);
              int twd=rs.getInt(3)+rs.getInt(5);
              
              
              System.out.println("harshal");
              tl.setText(""+twl);
              td.setText(""+twd);
              
              pre.execute();
              con.close();
              
          }
          catch(SQLException e)
          {
           JOptionPane.showMessageDialog(this,e);   
          }
          catch(Exception e)
          {
              JOptionPane.showMessageDialog(this,e);   
          }

    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        int qun1=Integer.parseInt(qun.getText());
            
           DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
       	   Date date = new Date();
           String crdate=dateFormat.format(date);
          
      try{     
           Calendar c= Calendar.getInstance();
      
            Class.forName("com.mysql.jdbc.Driver");
           
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/MessInfo","root","harshal123");
 
           if(c.get(Calendar.AM_PM)==Calendar.AM)
           {
                  PreparedStatement mpre=con.prepareStatement("update WastageRecord set stm=? where day=?");
                  mpre.setInt(1,qun1);
                  mpre.setString(2,crdate);
                  mpre.executeUpdate();
        
           }
           
           if(c.get(Calendar.AM_PM)==Calendar.PM)
           {
                  PreparedStatement npre=con.prepareStatement("update WastageRecord set stn=? where day=?");
                  npre.setInt(1,qun1);
                  npre.setString(2,crdate);
                  npre.executeUpdate();
        
           }
           
           JOptionPane.showMessageDialog(this,"Save Suceessful");
           
       }
      
      catch(SQLException e)
      {
       JOptionPane.showMessageDialog(this,e);
      }
      catch(Exception e)
      {
       JOptionPane.showMessageDialog(this,e);
      }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void qunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qunActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_qunActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
try
          {
             Class.forName("com.mysql.jdbc.Driver");
             
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost/MessInfo","root","harshal123");
             
             PreparedStatement pre=con.prepareStatement("delete from  WastageRecord");
             
             pre.executeUpdate();
             
             con.close();
             
             JOptionPane.showMessageDialog(this,"Deleted Successful");
          }
          catch(SQLException e)
          {
             JOptionPane.showMessageDialog(this,e);   
          }
          catch(Exception e)
          {
             JOptionPane.showMessageDialog(this,e);
          }
                 
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
                try
                {
                  Class.forName("com.mysql.jdbc.Driver");
         
                   Connection con=DriverManager.getConnection("jdbc:mysql://localhost/MessInfo", "root","harshal123");
         
                   PreparedStatement mprec=con.prepareStatement("select * from MPresent");
                   PreparedStatement nprec=con.prepareStatement("select * from NPresent");
            
              Calendar c= Calendar.getInstance();
               
              if(c.get(Calendar.AM_PM)==Calendar.AM)
              {
                  ResultSet nrs=nprec.executeQuery();
                  int ncount=0;
                  
                  while(nrs.next())
                  {
                      if(nrs.getInt(2)==1)
                      {
                          ncount++;
                      }
                  }
                    
                    studqun.setText(""+ncount);
                  
                    PreparedStatement item=con.prepareStatement("select * from morning where day=?");
                    Date now = new Date();
 
                    SimpleDateFormat simpleDateformat = new SimpleDateFormat("EEEE");
                    String day=simpleDateformat.format(now);
                    
                    
                    
                    
        
                    
                    
                 
                  
              }
              
               
              if(c.get(Calendar.AM_PM)==Calendar.PM)
              {
                  ResultSet mrs=mprec.executeQuery();
                  int mcount=0;
                  
                  while(mrs.next())
                  {
                      if(mrs.getInt(2)==1)
                      {
                          mcount++;
                      }
                  }
                  studqun.setText(""+mcount);
                  
              }
             
                   
            
                }
                catch(SQLException e)
                {
                    
                }
                catch(Exception e)
                {
                    
                }
        
                        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void studqunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studqunActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studqunActionPerformed
    public void ShowData()
    {
        DefaultTableModel model=(DefaultTableModel)stud_present.getModel();
        
         try
        {
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/MessInfo","root","harshal123");
            
            PreparedStatement pre=con.prepareStatement("  select rollno,name,RFIDNO,mobileno,emailid from userInfo,Authentication where userInfo.rollno=Authentication.rollno2");
            
            
            ResultSet rs=pre.executeQuery();
            
            
            
           
            while(rs.next()){
                model.addRow(new Object[]{rs.getInt(1), rs.getString(2),rs.getInt(3),rs.getLong(4),rs.getString(5)});
            }
            
              
            
             
              
            
            
              pre.execute();
             
             con.close();
            
           
           
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(this,e);
        }
        
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,e);
        }
       
    }
    
        public void ShowWeek()
    {
        DefaultTableModel model=(DefaultTableModel)week.getModel();
        
         try
        {
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/MessInfo","root","harshal123");
            
            PreparedStatement pre=con.prepareStatement("select * from DayFood");
            
            
            ResultSet rs=pre.executeQuery();
            
                
            
           
            while(rs.next())
            {   
                    model.addRow(new Object[]{rs.getString(1), rs.getString(2),rs.getString(3)});
            }
            
              
            
             
              
            
            
              pre.execute();
             
             con.close();
            
           
           
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(this,e);
        }
        
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this,e);
        }
       
    }
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
            java.util.logging.Logger.getLogger(MessTab2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MessTab2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MessTab2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MessTab2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MessTab2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> brekfast;
    private javax.swing.JButton btsumbit;
    private javax.swing.JComboBox<String> citem;
    private javax.swing.JComboBox<String> day;
    private javax.swing.JTextField eitem;
    private javax.swing.JTable iitem;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> lanch;
    private javax.swing.JTable owest;
    private javax.swing.JTable qitem;
    private javax.swing.JTextField qun;
    private javax.swing.JTextField rfid;
    private javax.swing.JTextField rfidno;
    private javax.swing.JTextField rno;
    private javax.swing.JTextField rollno;
    private javax.swing.JTable stud_present;
    private javax.swing.JTextField studqun;
    private javax.swing.JTextField td;
    private javax.swing.JTextField ting;
    private javax.swing.JTextField tl;
    private javax.swing.JTextField tqun;
    private javax.swing.JTable wasteT;
    private javax.swing.JTable week;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
