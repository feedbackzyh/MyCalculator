package codes;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.math.BigDecimal;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class MyCalculator {
	 BigDecimal num1;
	int symbol=0;
	boolean numflag1=false;
	 BigDecimal num2;
	 BigDecimal num3;
	boolean dotflag=true;
	int dot;
	JTextField text=new JTextField(20);
	JPanel ptext=new JPanel();
	JButton bnum0 = new JButton("0"); 
	JButton bnum1 = new JButton("1"); 
	JButton bnum2 = new JButton("2"); 
	JButton bnum3 = new JButton("3"); 
	JButton bnum4 = new JButton("4"); 
	JButton bnum5 = new JButton("5"); 
	JButton bnum6 = new JButton("6");
	JButton bnum7 = new JButton("7"); 
	JButton bnum8 = new JButton("8"); 
	JButton bnum9 = new JButton("9");
	JButton bdot = new JButton(".");
	JButton badd = new JButton("+");
	JButton bsub = new JButton("-");
	JButton bmul = new JButton("*");
	JButton bdiv = new JButton("/");
	JButton bequ = new JButton("=");
	JButton bdel = new JButton("del");
	JButton bclear = new JButton("clear");
	JPanel pnum = new JPanel();
	JFrame jf=new JFrame("计算器");GridBagLayout gb=new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
	public void init(){	
		//数字按钮
		
		try{
			//设置使用Windows风格
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		pnum.setLayout(gb);
		gbc.fill=GridBagConstraints.BOTH;
		gbc.weightx=1;
		gbc.gridheight=1;
		addButton(pnum,bnum1);
		addButton(pnum,bnum2);
		addButton(pnum,bnum3);
		addButton(pnum,bdel);
		gbc.gridwidth=GridBagConstraints.REMAINDER;
		addButton(pnum,bclear);
		gbc.gridwidth=1;
		addButton(pnum,bnum4);
		addButton(pnum,bnum5);
		addButton(pnum,bnum6);
		addButton(pnum,badd);
		gbc.gridwidth=GridBagConstraints.REMAINDER;
		addButton(pnum,bsub);
		gbc.gridheight=1;
		gbc.gridwidth=1;
		addButton(pnum,bnum7);
		addButton(pnum,bnum8);
		addButton(pnum,bnum9);
		addButton(pnum,bmul);
		gbc.gridwidth=GridBagConstraints.REMAINDER;
		addButton(pnum,bdiv);
		gbc.gridwidth=2;
		addButton(pnum,bnum0);
		gbc.gridwidth=1;
		addButton(pnum,bdot);
		gbc.gridwidth=GridBagConstraints.REMAINDER;
		gbc.gridwidth=2;
		gbc.gridheight=2;
		addButton(pnum,bequ);
		//按钮监听器
		bnum0.addMouseListener(new myMouseListener());
		bnum1.addMouseListener(new myMouseListener());
		bnum2.addMouseListener(new myMouseListener());
		bnum3.addMouseListener(new myMouseListener());
		bnum4.addMouseListener(new myMouseListener());
		bnum5.addMouseListener(new myMouseListener());
		bnum6.addMouseListener(new myMouseListener());
		bnum7.addMouseListener(new myMouseListener());
		bnum8.addMouseListener(new myMouseListener());
		bnum9.addMouseListener(new myMouseListener());
		bdot.addMouseListener(new myMouseListener());
		badd.addMouseListener(new myMouseListener());
		bsub.addMouseListener(new myMouseListener());
		bmul.addMouseListener(new myMouseListener());
		bdiv.addMouseListener(new myMouseListener());
		bequ.addMouseListener(new myMouseListener());
		bdel.addMouseListener(new myMouseListener());
		bclear.addMouseListener(new myMouseListener());
		
		//显示框
		text.setEditable(false);//不能修来
		//右对齐
		text.setHorizontalAlignment(JTextField.RIGHT);
		text.setText("0");
		ptext.add(text);
		
		
		//窗口
		jf.setLayout(new BorderLayout());
		jf.add(ptext,BorderLayout.NORTH);
		jf.add(pnum,BorderLayout.CENTER);
		jf.setResizable(false);
		jf.pack();
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	private void addButton(JPanel jp,JButton jbutton){
		gb.setConstraints(jbutton, gbc);
		jp.add(jbutton);
	}
	public static void  main(String[] arg){
		new MyCalculator().init();
	}
	
	class myMouseListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO 自动生成的方法存根
			String num;
			String Btext=((JButton)arg0.getComponent()).getText();
			if(Btext=="0"||Btext=="1"||Btext=="2"||Btext=="3"||Btext=="4"||Btext=="5"||Btext=="6"||Btext=="7"||Btext=="8"||Btext=="9")
			{
				if(numflag1){
					num=text.getText();}
					else{num="";}
				text.setText(num+Btext);
				numflag1=true;
			}
			if(Btext=="."){
				if(dotflag)
				{num=text.getText();text.setText(num+Btext);
				dotflag=false;}
			}
			if(Btext=="+"){num1=new BigDecimal(text.getText());numflag1=false;symbol=1;dotflag=true;}
			if(Btext=="-"){num1=new BigDecimal(text.getText());numflag1=false;symbol=2;dotflag=true;}
			if(Btext=="*"){num1=new BigDecimal(text.getText());numflag1=false;symbol=3;dotflag=true;}
			if(Btext=="/"){num1=new BigDecimal(text.getText());numflag1=false;symbol=4;dotflag=true;}
			if(Btext=="="){
				num2=new BigDecimal(text.getText());
				numflag1=false;
				switch (symbol){
				case 1:num1=num1.add(num2);System.out.println(num1);break;
				case 2:num1=num1.subtract(num2);break;
				case 3:num1=num1.multiply(num2);break;
				case 4:num1=num1.divide(num2,6,BigDecimal.ROUND_HALF_EVEN);break;
				case 0:num1=new BigDecimal(text.getText());break;
				}
				symbol=0;
				text.setText(num1.toString());
				//num2=new BigDecimal(0);
				num1=new BigDecimal(0);
				dotflag=true;
			}
			if(Btext=="clear"){
				num2=new BigDecimal(0);
				num1=new BigDecimal(0);
				symbol=0;
				text.setText("0");
				numflag1=false;
				dotflag=true;
			}
			if(Btext=="del"){
				int len=text.getText().length();
				if(text.getText().substring(len-1, len).equals(".")){
					dotflag=true;
				}
				String a=text.getText().substring(0, len-1);
				text.setText(a);
			}
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO 自动生成的方法存根
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO 自动生成的方法存根
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO 自动生成的方法存根
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO 自动生成的方法存根
			
		}
		
	}
}
