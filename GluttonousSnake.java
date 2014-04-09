import java.awt.Color; 
import java.awt.Graphics; 
import java.awt.Toolkit; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.awt.event.InputEvent; 
import java.awt.event.KeyEvent; 
import java.awt.event.KeyListener; 

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class GluttonousSnake extends JFrame implements ActionListener, KeyListener,Runnable { 
private static final long serialVersionUID = 1L;
private JMenuBar menuBar; 
private JMenu youXiMenu,nanDuMenu,fenShuMenu,guanYuMenu; 
private JMenuItem kaiShiYouXi,exitItem,zuoZheItem,fenShuItem; 
private JCheckBoxMenuItem cJianDan,cPuTong,cKunNan; 
private int length = 6; 
private Toolkit toolkit; 
private int i,x,y,z,objectX,objectY,object=0,growth=0,time;//bojectX,Y

private int m[]=new int[50]; 
private int n[]=new int[50]; 
private Thread she = null; 
private int life=0; 
private int foods = 0; 
private int fenshu=0; 
 

public void run(){  
  time=500; 
  for(i=0;i<=length-1;i++) 
  { 
	m[i]=90-i*10;n[i]=60; 
  } 
  
  x=m[0]; 
  y=n[0]; 
  z=4; 

  while(she!=null) 
  { 
	   check(); 
	   try 
	   { 
			Thread.sleep(time); 
	   } 
	   catch(Exception ee) 
	   { 
			System.out.println(z+""); 
	   } 
  } 
} 

public class GluttonousSnake() { 
	public static void main(String args[]) { 
		  new GluttonousSnake(); 
		  setVisible(true); 
		  menuBar = new JMenuBar(); 
		  toolkit=getToolkit(); 
		 
		  youXiMenu = new JMenu("��Ϸ"); 
		  kaiShiYouXi = new JMenuItem("��ʼ��Ϸ"); 
		  exitItem = new JMenuItem("�˳���Ϸ"); 
		 
		  nanDuMenu = new JMenu("���ѳ̶�"); 
		  cJianDan = new JCheckBoxMenuItem("��"); 
		  cPuTong = new JCheckBoxMenuItem("��ͨ"); 
		  cKunNan = new JCheckBoxMenuItem("����"); 
		 
		  fenShuMenu = new JMenu("��������"); 
		  fenShuItem = new JMenuItem("��߼�¼"); 

		  guanYuMenu = new JMenu("����"); 
		  zuoZheItem = new JMenuItem("��������"); 
		 
		  guanYuMenu.add(zuoZheItem); 

		  nanDuMenu.add(cJianDan); 
		  nanDuMenu.add(cPuTong); 
		  nanDuMenu.add(cKunNan); 

		  fenShuMenu.add(fenShuItem); 
		  youXiMenu.add(kaiShiYouXi); 
		  youXiMenu.add(exitItem); 
		  menuBar.add(youXiMenu); 
		  menuBar.add(nanDuMenu); 
		  menuBar.add(fenShuMenu); 
		  menuBar.add(guanYuMenu); 
		  zuoZheItem.addActionListener(this); 
		  kaiShiYouXi.addActionListener(this); 
		  exitItem.addActionListener(this); 
		  addKeyListener(this); 
		  fenShuItem.addActionListener(this); 
		  KeyStroke keyOpen = KeyStroke.getKeyStroke('O',InputEvent.CTRL_DOWN_MASK); 
		  kaiShiYouXi.setAccelerator(keyOpen); 
		  KeyStroke keyExit = KeyStroke.getKeyStroke('X',InputEvent.CTRL_DOWN_MASK); 
		  exitItem.setAccelerator(keyExit); 
		  setJMenuBar(menuBar); 
		  setTitle("̰����"); 
		  setResizable(false); 
		  setBounds(300,200,400,400); 
		  validate(); 
		  setDefaultCloseOperation(EXIT_ON_CLOSE);   
	} 

	public void actionPerformed(ActionEvent e){ 
		  if(e.getSource()==kaiShiYouXi) 
		  { 
			   length = 6; 
			   life = 0; 
			   foods = 0; 
			   if(she==null) 
			   { 
					she=new Thread(this); 
					she.start(); 
			   } 
			   else if(she!=null) 
			   { 
					she=null; 
					she= new Thread(this); 
					she.start(); 
			   } 
		  } 
		  if(e.getSource()==exitItem) 
		  { 
			System.exit(0); 
		  } 
		  if(e.getSource()==zuoZheItem) 
		  { 
			JOptionPane.showMessageDialog(this, "steven made"+"\n\n"+"\n"); 
		  } 
		  if(e.getSource()==fenShuItem) 
		  { 
			JOptionPane.showMessageDialog(this,"��߼�¼Ϊ"+fenshu+"");  
		  } 
	} 

	public void check(){ 
		  isDead(); 
		  if(she!=null) 
		  { 
			   if(growth==0) 
			   { 
					reform(); //�õ�ʳ�� 
			   } 
			   else 
			   { 
					upgrowth(); //����ʳ�� 
			   } 
			   if(x==objectX&&y==objectY) 
			   { 
					object=0; 
					growth=1; 
					toolkit.beep(); 
			   } 
			   if(object==0) 
			   { 
					object=1; 
					objectX=(int)Math.floor(Math.random()*39)*10; 
					objectY=(int)Math.floor(Math.random()*29)*10+50; 
			   } 
			   this.repaint(); //�ػ� 
		  } 
	} 

	void isDead() 
	{ 
		  //�ж���Ϸ�Ƿ�����ķ��� 
		  if(z==4) 
		  { 
		   x=x+10; 
		  } 
		  else if(z==3) 
			 { 
				x=x-10; 
			 } 
		  else if(z==2) 
			 { 
				y=y+10; 
			 } 
		  else if(z==1) 
			 { 
				y=y-10; 
			 } 
		  if(x<0||x>390||y<50||y>390) 
		  { 
			she=null; 
		  } 
		  for(i=1;i<length;i++) 
		  { 
			   if(m[i]==x&&n[i]==y) 
			   { 
					she=null; 
			   } 
		  }  
	} 

	public void upgrowth() 
	{  
		  //���߳Ե�����ʱ�ķ��� 
		  if(length<50) 
		  { 
			length++; 
		  }  
		  growth--; 
		  time=time-10; 
		  reform(); 
		  life+=100; 
		  if(fenshu<life) 
		  { 
			fenshu = life; 
		  } 
		  foods++; 
	} 

	public void reform() 
	{ 
		  for(i=length-1;i>0;i--) 
		  { 
			   m[i]=m[i-1]; 
			   n[i]=n[i-1]; 
		  } 
		  if(z==4) 
		  { 
			m[0]=m[0]+10; 
		  } 
		  if(z==3) 
		  { 
			m[0]=m[0]-10; 
		  } 
		  if(z==2) 
		  { 
			n[0]=n[0]+10; 
		  } 
		  if(z==1) 
		  { 
			n[0]=n[0]-10; 
		  } 
	} 

	public void keyPressed(KeyEvent e) 
	{ 
		  if(she!=null) 
		  { 
			   if(e.getKeyCode()==KeyEvent.VK_UP) 
			   { 
					if(z!=2) 
					{ 
						 z=1; 
						 check(); 
					} 
				} 
		   }
		   else if(e.getKeyCode()==KeyEvent.VK_DOWN) 
		   { 
				if(z!=1) 
				{ 
					 z=2; 
					 check(); 
				} 
		   } 
		   else if(e.getKeyCode()==KeyEvent.VK_LEFT) 
		   { 
				if(z!=4) 
				{ 
					 z=3; 
					 check(); 
				} 
		   } 
		   else if(e.getKeyCode()==KeyEvent.VK_RIGHT) 
		   { 
				if(z!=3) 
				{ 
					 z=4; 
					 check(); 
				} 
		   } 
		  } 
	} 
	public void keyReleased(KeyEvent e) 
	{ 
	  
	} 
	public void keyTyped(KeyEvent e) 
	{ 
	  
	} 
	public void paint(Graphics g)  { 
		  g.setColor(Color.DARK_GRAY); //���ñ��� 
		  g.fillRect(0,50,400,400); 
		  g.setColor(Color.pink); 
		  for(i=0;i<=length-1;i++) 
		  { 
			 g.fillRect(m[i],n[i],10,10); 
		  } 
		  g.setColor(Color.green); //�ߵ�ʳ�� 
		  g.fillRect(objectX,objectY,10,10); 
		  g.setColor(Color.white); 
		  g.drawString("��ǰ      ����"+this.life,6,60); 
		  g.drawString("��ǰ�ѳ�ʳ����"+this.foods,6,72);  
	}

}