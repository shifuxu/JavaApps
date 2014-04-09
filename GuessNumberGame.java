import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



class WindowButton extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int number;
	JTextField inputNumber;
	JLabel feedBack;
	JButton buttonGetNumber,buttonEnter;
	WindowButton(String s){
		super("������С��Ϸ");
		buttonGetNumber=new JButton("�õ�һ�������");
		feedBack=new JLabel("�޷�����Ϣ",JLabel.CENTER);
		feedBack.setBackground(Color.green);
		inputNumber=new JTextField("0",5);
		buttonEnter=new JButton("ȷ��");
		buttonEnter.addActionListener(this);
		buttonGetNumber.addActionListener(this);
		buttonGetNumber.addActionListener(this);
		Box boxH1=Box.createHorizontalBox();
		boxH1.add(new JLabel("��ȡ1-100֮����������"));
		boxH1.add(buttonGetNumber);
		Box boxH2=Box.createHorizontalBox();
		boxH2.add(new JLabel("�������Ĳ²�: "));
		boxH2.add(inputNumber);
		Box boxH3=Box.createHorizontalBox();
		boxH3.add(new JLabel("����ȷ����ť: "));
		boxH3.add(buttonEnter);
		Box boxH4=Box.createHorizontalBox();
		boxH4.add(new JLabel("������Ϣ: "));
		boxH4.add(feedBack);
		Box baseBox=Box.createVerticalBox();
		baseBox.add(boxH1);
		baseBox.add(boxH2);
		baseBox.add(boxH3);
		baseBox.add(boxH4);
		Container con=getContentPane();
		con.setLayout(new FlowLayout());
		con.add(baseBox);
		con.validate();
		setBounds(120,125,279,200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,150,150);
		setVisible(true);
		validate();
	}
		
		



public void actionPerformed(ActionEvent e){
	if(e.getSource()==buttonGetNumber){
		number=(int)(Math.random()*100)+1;
	}
	else if(e.getSource()==buttonEnter){
		int guess=0;
		try{
			guess=Integer.parseInt(inputNumber.getText());
			if(guess==number){
				JOptionPane.showMessageDialog(this,"�¶���"); 
			}
			else if(guess>number){
				JOptionPane.showMessageDialog(this,"�´���"); 
				inputNumber.setText(null);
			}
			else if(guess<number){
				JOptionPane.showMessageDialog(this,"��С��"); 
				inputNumber.setText(null);
			}
			
		}
		catch(NumberFormatException event){
			JOptionPane.showMessageDialog(this,"�����������ַ�"); 
		}
	}
	
}
}

public class ��������Ϸ {
	public static void main(String args[]){
		new WindowButton("������С��Ϸ");
	}

}
