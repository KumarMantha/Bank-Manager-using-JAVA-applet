 import java.applet.*;
 import java.util.*;
 import java.awt.*;
 import java.awt.event.*; 
 import java.applet.*;
 import java.awt.Label;
 import java.awt.Font;
 import java.util.Random;

 
 public class EventApplet extends Applet implements ActionListener
 {
	Image img1,img2;
	Button b1,b2,b3,b5;
	TextField tf1,tf2,tf3,tf4,tf5;
	Label l,l1,l2,l3,l4,l5,l6;
	double bal=0.0;
	int cap; 
	String s1;
	Random r = new Random(); 
	int rc = r.nextInt(4);
	public void init()
	{
       
        
		
	img1= getImage(getDocumentBase(),"PIIT.png");
	
	if(rc == 0)
	{
		img2= getImage(getDocumentBase(),"captcha.png");
		cap= 51515;
	}
	else if(rc==1) 
	{
		img2= getImage(getDocumentBase(),"captcha2.jpg");
		cap= 8760;
	}
	else if(rc==2)
	{
		img2= getImage(getDocumentBase(),"captcha3.jpg");
		cap= 1234;
	}
	else if(rc==3)
	{
		img2= getImage(getDocumentBase(),"captcha4.png");
		cap= 34523;
	}
	setBackground(Color.lightGray);
		
	s1 ="Date:" +new java.util.Date();
		 
		
	tf1 = new TextField();
	tf1.setBounds(30,150,200,20);
	
	tf2 = new TextField();
	tf2.setBounds(30,60,200,20);
	
	tf3 = new TextField();
	tf3.setBounds(30,105,200,20);
	
	tf4 = new TextField();
	tf4.setBounds(30,400,200,20);
	
	tf5 = new TextField();
	tf5.setBounds(30,345,200,20);
	
	l=new Label("WELCOME CUSTOMER");
	l.setBounds(100,20,1000,20);
	
	l1=new Label("Enter Name");
	l1.setBounds(20,40,200,20);
	
	l2=new Label("Enter Account Number");
	l2.setBounds(20,85,200,20);
	
	l3=new Label("Enter Current Balance");
	l3.setBounds(20,125,200,30);
	
	l4=new Label("Enter Amount to be Deposited/Withdrawn");
	l4.setBounds(20,375,300,20);
	
    l5=new Label("Fill the CAPTCHA for further transactions");
	l5.setBounds(20,255,300,20);
	
	l6=new Label("");
	l6.setBounds(400,550,500,20);
		
	b1=new Button("Deposit Money");
	b1.setBounds(20,450,100,50);
	
	b2=new Button("Withdraw Money");
	b2.setBounds(150,450,100,50);
	
	b3=new Button("OK");
	b3.setBounds(85,200,100,50);
	
	
	b5=new Button("RESET");
	b5.setBounds(85,570,100,50);
	
	
	add(b1);
	add(b2);
	add(b3);
	add(tf1);
	add(tf2);
	add(l);
	add(l1);
	add(l2);
	add(l3);
	add(tf3);
	add(l4);
	add(tf4);
	add(b5);
	add(l5);
	add(tf5);
	add(l6);
	b3.addActionListener(this);
	b2.addActionListener(this);
	b1.addActionListener(this);
	setLayout(null);
    b5.addActionListener(this);
     Font myFont = new Font("Serif",Font.BOLD,25);
     l6.setFont(myFont);
     Font mFont = new Font("Serif",Font.BOLD,15);
		       l.setFont(myFont);
          l1.setFont(mFont);
          l2.setFont(mFont);
          l3.setFont(mFont);
          l4.setFont(mFont);
          l5.setFont(mFont); 
          
	}
	
	public void actionPerformed(ActionEvent e)
	{		
		double amt;
		if(e.getSource()==b3)
		{
			l1.setText("Name:"+ tf2.getText());
			l2.setText("AccNo:"+ tf3.getText());
			bal = Double.parseDouble(tf1.getText());
			l6.setText("Balance is Rs. "+ tf1.getText());
			l3.setText("");
			tf4.setText("");
			tf1.setText("");
			tf1.setEnabled(false);
		}  
	
			if(	Double.parseDouble(tf5.getText())== cap)
			{
				l5.setText("");
				repaint();
					if(e.getSource()== b1)
					{
						bal = bal + Double.parseDouble(tf4.getText());
						l6.setText("Current Balance is Rs."+bal+"   THANK YOU");
					}
					
					if(e.getSource()== b2)
					{			
						amt =  Double.parseDouble(tf4.getText());
						if(amt > bal)
						{
							l6.setText("Cannot Withdraw...Insufficient Balance");
						}
						else
						{
							bal = bal - Double.parseDouble(tf4.getText());
							l6.setText("Current Balance is Rs."+bal+" THANK YOU");
						}
					}
			}
			else
			{
				l5.setText("Wrong captcha..TRY AGAIN");
				tf5.setText("");
				repaint();
			}
					
	    if (e.getSource() == b5)
	    {
			 tf1.setText("");
			 tf2.setText("");
			 tf3.setText(""); 
			 tf4.setText("");
			 tf5.setText("");
			 l.setText("Welcome Customer");
			 l1.setText("Enter Name");
			 l2.setText("Enter Account Number");
			 l3.setText("Enter Current Balance");
			 l5.setText("Fill the CAPTCHA for further transactions");
			 l6.setText("");
			 tf1.setEnabled(true);
	    }
	    repaint(); 
	             
	}
	   
	
	
		public void paint(Graphics g)
		{
			g.drawImage(img1,400,40,this);
			g.drawImage(img2,20,280,this);
			
		    g.drawString(s1,750,650);

		}
		 public void destroy()     
		{
			s1 = null;
		}
	}
/*
<applet code="EventApplet.class" width ="1000" height="650">
</applet>
*/
 

