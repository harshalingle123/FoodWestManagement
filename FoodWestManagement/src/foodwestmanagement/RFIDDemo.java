package foodwestmanagement;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import java.util.*;

class  PreHandler
{
    int rfidno;
    
    PreHandler(int no)
    {
       rfidno=no;
       manageData();
    }
   
    void manageData()
    {
        
        try
        {
           Class.forName("com.mysql.jdbc.Driver");
         
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost/MessInfo", "root","harshal123");
         
           PreparedStatement pre=con.prepareStatement("select rfidno from userInfo");
           PreparedStatement mpre=con.prepareStatement("update MPresent set present=? where rfid_no=?");
           PreparedStatement npre=con.prepareStatement("update NPresent set present=? where rfid_no=?");
           
           
           ResultSet rs=pre.executeQuery();
           int status=0;
           while(rs.next())
           {      
               
                 if(rfidno==rs.getInt(1))
                 {
                    status=1;
                 }
           }
           
           PreparedStatement mprec=con.prepareStatement("select * from MPresent");
           PreparedStatement nprec=con.prepareStatement("select * from NPresent");
           
           PreparedStatement wp=con.prepareStatement("select * from Wastage where rfid_no=?");
           
           ResultSet mrsc=mprec.executeQuery();
           ResultSet nrsc=nprec.executeQuery();
           
           if(status==1)
           {
              
               Calendar c= Calendar.getInstance();
        
               if(c.get(Calendar.AM_PM)==Calendar.AM)
               {     
                   System.out.println("morning");
                   npre.setInt(1,1);
                   npre.setInt(2,rfidno);
                   npre.executeUpdate();
                   
                  
                   
                   while(mrsc.next())
                   {
                       if(mrsc.getInt(2)==0)
                       {
            
                           try
                           {
                           
                           int rfid=mrsc.getInt(1);
                           
                           
                           
                           wp.setInt(1,rfid);
                           ResultSet wpr=wp.executeQuery();
           
                           int abs=0;
                               abs=wpr.getInt(3);
                           
                           
                           abs++;
                           
                           
                           PreparedStatement upre=con.prepareStatement("update Wastage set absent_pen=? where rfid_no=?");
                           upre.setInt(1, abs);
                           upre.setInt(2, rfid);
                           
                           upre.executeUpdate();
                           }
                           catch(SQLException e)
                           {
                                
                           }
                       }
                   }
                        
                   mpre.setInt(1,0);
                   mpre.setInt(2,rfidno);
                   mpre.executeUpdate();
               }
               if(c.get(Calendar.AM_PM)==Calendar.PM)
               {
                   
                   
                   System.out.println("night");
                   mpre.setInt(1,1);
                   mpre.setInt(2,rfidno);
                   mpre.executeUpdate();
                   
                  
                
                    
                   while(nrsc.next())
                   {                 
                       
                       if(nrsc.getInt(2)==0)
                       {
                           
                           
                           
                           
                                                  
                           int abs = 0;
                           try
                           
                           {
                           
                               
                               int rfid=nrsc.getInt(1);
                               wp.setInt(1,rfid);
                               ResultSet wpr=wp.executeQuery();
                           
                           abs=wpr.getInt(3);
                            
                           
                                abs++;
                           
                           System.out.println(rfid);
                           PreparedStatement upre=con.prepareStatement("update Wastage set absent_pen=? where rfid_no=?");
                           upre.setInt(1, abs);
                           upre.setInt(2, rfid);
                           
                           upre.executeUpdate();
                           
                           }
                           catch(SQLException e)
                           {
                         
 
                           }
                           
                       }
                   }
                   
                   npre.setInt(1,0);
                   npre.setInt(2,rfidno);
                   npre.executeUpdate();
               }
         
           }
           else
           {
              JOptionPane.showMessageDialog(null,"Unauthorize!!!!!!!!!!!");
           }
             
            
        }
        catch(SQLException e)
        {
          JOptionPane.showMessageDialog(null,e);
        }
        catch(Exception e)
        {
          JOptionPane.showMessageDialog(null,e); 
        }
        
        
        
    }
}

class Hardware
{
    int rfidno,wastage;
    public Hardware(int rfid,int wast)
    {
        rfidno=rfid;
        wastage=wast;
        
        
        managedata();

    }
    
    public void managedata()
    {
       try
       {
            Class.forName("com.mysql.jdbc.Driver");
           
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/MessInfo","root","harshal123");
            
            PreparedStatement pre=con.prepareStatement("select rfidno from userInfo");
            ResultSet rs=pre.executeQuery();
            
            
            int status=0;
           
            while(rs.next())
            {      
               
                 if(rfidno==rs.getInt(1))
                 {
                    status=1;
                 }
            }
           
           DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	   Date date = new Date();
           String crdate=dateFormat.format(date);
           
           try
           {
               PreparedStatement crpre=con.prepareStatement("insert into WastageRecord(day) values (?)");
               crpre.setString(1, crdate);
               crpre.executeUpdate();
           }
           catch(SQLException e)
           {
           
           }
            
           if(status==1)
           {
              PreparedStatement spre=con.prepareStatement("select * from WastageRecord where day=?");
              spre.setString(1, crdate);
              ResultSet srs=spre.executeQuery();
              
              srs.first();
              Calendar c= Calendar.getInstance();
               
              if(c.get(Calendar.AM_PM)==Calendar.AM)
              {
                  int stud_west_m=srs.getInt(2);
                  System.out.println(stud_west_m);
                  System.out.println(wastage);
                  stud_west_m= stud_west_m+wastage;
                  
                  PreparedStatement mpre=con.prepareStatement("update WastageRecord set swm=? where day=?");
                  mpre.setInt(1,stud_west_m);
                  mpre.setString(2,crdate);
                  mpre.executeUpdate();
              }
              
              if(c.get(Calendar.AM_PM)==Calendar.PM)
              {
                  int stud_west_n=srs.getInt(3);
                  stud_west_n=stud_west_n+wastage;
                  
                  
                    PreparedStatement npre=con.prepareStatement("update WastageRecord set swn=? where day=?");
                  npre.setInt(1,stud_west_n);
                  npre.setString(2,crdate);
                  npre.executeUpdate();

              }
              
              
              PreparedStatement wpre=con.prepareStatement("select * from Wastage where rfid_no=?");
              wpre.setInt(1,rfidno);
              ResultSet wrs=wpre.executeQuery();
              
              wrs.first();
             
              int wcount=wrs.getInt(4);
               
            
              if(wastage >= 50)
              {
                wcount++;  
                PreparedStatement wupre=con.prepareStatement("update Wastage set wast_pen=? where rfid_no=?");
                wupre.setInt(1, wcount);
                wupre.setInt(2, rfidno);

                wupre.executeUpdate();
                        
              }
              
              
              
              
              
           }
           
           else
           {
             JOptionPane.showMessageDialog(null,"Please Swipe The Correct Card!!!!!!!!!!");
           }
 

       } 
       catch(SQLException e)
       {
           JOptionPane.showMessageDialog(null,e);
       }
       catch(Exception e)
       {
           JOptionPane.showMessageDialog(null,e);
       }
    }
}

class PreviesPresent 
{
    int rfidno;
    
    PreviesPresent(int rfid)
    {
        rfidno=rfid;
        manage();
                
    
    }
    
    public void manage()
    {
           try
          {
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost/MessInfo","root","harshal123");
            PreparedStatement pre=con.prepareStatement("select rfidno from userInfo");
            ResultSet rs=pre.executeQuery();
            
          
            PreparedStatement mpre=con.prepareStatement("select * from MPresent where rfid_no=?");
            PreparedStatement npre=con.prepareStatement("select * from NPresent where rfid_no=?");
           
            
            
            int status=0;
           
            while(rs.next())
            {      
               
                 if(rfidno==rs.getInt(1))
                 {
                    status=1;
                 }
            }
           
           DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	   Date date = new Date();
           String crdate=dateFormat.format(date);
            
           if(status==1)
           {
               Calendar c= Calendar.getInstance();
               
               if(c.get(Calendar.AM_PM)==Calendar.AM)
               { 
                   
                        npre.setInt(1,rfidno);
         
                        ResultSet nrs=npre.executeQuery();
                        
                        nrs.first();
                        
                        if(nrs.getInt(2)==1)
                        {
                             JOptionPane.showMessageDialog(null,"user Prsent");
                        }
                        else
                        {
                             JOptionPane.showMessageDialog(null,"user Absent");
                        }
                        
          
                        
               }
               
               if(c.get(Calendar.AM_PM)==Calendar.PM)
               {
                       mpre.setInt(1,rfidno);
                       ResultSet mrs=mpre.executeQuery();
                       
                       mrs.first();
                        
                        if(mrs.getInt(2)==1)
                        {
                           JOptionPane.showMessageDialog(null,"user Present");
                        }
                        else
                        {
                           JOptionPane.showMessageDialog(null,"user Absent");
                        }
                        
               }
           }
           
           else
           {
              JOptionPane.showMessageDialog(null,"user unauthorize");
           }
         
        }
        catch(SQLException e)
        {
           JOptionPane.showMessageDialog(null,e);
        }
        catch(Exception e)
        {
           JOptionPane.showMessageDialog(null,e);
        }
    }
}

class RFIDDemo
{
    public static void main(String args[])throws Exception
    { 
        FileReader fr=new FileReader(("/home/code/Desktop/mess/RFID Number/rfidno.txt"));
       BufferedReader br=new BufferedReader(fr);
       
        FileReader fr1=new FileReader(("/home/code/Desktop/mess/RFID Number/west.txt"));
        BufferedReader br1=new BufferedReader(fr1);
        
        int rfidno1=Integer.parseInt(br1.readLine());
        int west=Integer.parseInt(br1.readLine());
 
      
        Hardware har=new Hardware(rfidno1,west);
        String msg="",st="";
     
      
      
         while((msg=br.readLine())!= null)
         {
            st=st+msg;
         }
     
         int rfid=Integer.parseInt(st);
     
         PreHandler pre=new PreHandler(rfid);
     
     PreviesPresent pp=new PreviesPresent(rfid);
    //FileWriter fw=new FileWriter(("/home/code/Desktop/mess/RFID Number/rfidno.txt"));
    //FileWriter fw=new FileWriter(("/home/code/Desktop/mess/RFID Number/west.txt"));

   
    }
}


