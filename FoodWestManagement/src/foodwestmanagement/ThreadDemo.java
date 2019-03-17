package foodwestmanagement;
import foodwestmanagement.LoginUse;

class PassDemo extends Thread
{
   public void run()
   {
       LoginUse use=new LoginUse("User Login");  
       use.setVisible(true);
   }
}

class RederDemo extends Thread
{
   public void run()
   {
       
   }
}

class ThreadDemo
{
   public static void main(String args[])throws Exception
   {
         PassDemo t1=new PassDemo();
         RederDemo t2=new RederDemo();
       
           t1.start();
           t2.start();
         
   }
}
