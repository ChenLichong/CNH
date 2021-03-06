package gun;

import java.awt.*;
import java.lang.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class myCalculator extends JFrame implements ActionListener {//本类实现Action事件监听器接口
	int flag = 0;
	double x, y, z, m, k;  //运算所需操作数
	String s = new String("");//运算所需操作数
	JPanel p1, p2, p3;//三个键盘
	JLabel label;
	JTextField text;
	JButton bpoint, bclean, badd, bsbb, bmul, bdiv, beq, bbracket1, bbracket2, bdiscount, bfacevalue, bdays, bBDY, bMMY, bBEY, bprice1, bprice2, basset, bliability, brevenue, bexpense, bequity,
	bdepre, bcost, bresidual, blife, bPED, bquantity, bquantity1, bquantity2, bIED, bincome1, bincome2, bcurrent, binventory, bquick, bEPS, bNIM, bsales, bWCP, bMR, bmaxprice,
	bsalesvolume, bprofit, bcontribution;
	JButton[] b = new JButton[30];
	
	public myCalculator() { //构造方法，设计界面
		super("My Calculator");//创建窗体
		setLayout(new FlowLayout());  //设置整个程序的界面布局为流式
		/*在构造方法中进行界面设计*/
		p1 = new JPanel();//文本框所在的panel
		p2 = new JPanel();//数字按钮所在的panel
		p3 = new JPanel();//运算符所在的panel	  
		p1.setLayout(new FlowLayout()); //文本框面板
		p2.setLayout(new GridLayout(9,2));  //设置数字键面板
		p3.setLayout(new GridLayout(9,4)); //设置计算符面板
		label = new JLabel("简易财经计算器");
		text = new JTextField(12);//显示计算过程和结果的文本框
		bclean = new JButton("清除");//清空文本框的按钮
		add(label);
		this.setVisible(true);
		
		/*把文本框和清空按钮加在第一个panel上*/
		p1.add(text);
		p1.add(bclean);
		bclean.addActionListener(this);
               
		
		/*把所有数字按钮和"."及"="和基本运算符加在第二个panel上*/
		for (int i = 0; i < 10; i ++) {
			b[i] = new JButton(   Integer.toString(i)   );
			p2.add(b[i]);
			b[i].addActionListener(this);  //为数字按钮b[i]注册监听器
		}
		bpoint = new JButton("   .   ");//小数点按钮
		beq = new JButton("   =   ");//等号按钮
		badd = new JButton("   +   ");//加法按钮
		bsbb = new JButton("   -   ");//减法按钮
		bmul = new JButton("   *   ");//乘法按钮
		bdiv = new JButton("   /   ");//除法按钮
		bbracket1 = new JButton("   我是   ");//为了键盘结构设置的无意义按钮
		bbracket2 = new JButton("   装饰   ");//为了键盘结构设置的无意义按钮
		p2.add(bpoint);
		p2.add(beq);
		p2.add(badd);
		p2.add(bsbb);
		p2.add(bmul);
		p2.add(bdiv);
		p2.add(bbracket1);
		p2.add(bbracket2);
		bpoint.addActionListener(this);
		beq.addActionListener(this);
		badd.addActionListener(this);
		bsbb.addActionListener(this);    
	    bmul.addActionListener(this);
		bdiv.addActionListener(this);
		bbracket1.addActionListener(this);
		bbracket2.addActionListener(this);             
      	/*把财经运算符号按钮加在第三个panel上*/
      	basset = new JButton("Asset");//资产按钮
      	bBDY = new JButton("BDY");//BDY按钮
      	bBEY = new JButton("BEY");//BEY按钮
      	bcost = new JButton("Cost");//销货成本按钮
      	bcurrent = new JButton("Current");//流动比率按钮
      	bcontribution = new JButton("Contribution");//贡献值按钮
		bdays = new JButton("Days");//Day to maturity按钮
		bdiscount = new JButton("Dis");//Discount按钮
		bdepre = new JButton("Depre");//折旧按钮
		bexpense = new JButton("Expense");//支出按钮
		bequity = new JButton("Equi");//权益按钮
		bEPS = new JButton("EPS");//EPS按钮
		bfacevalue = new JButton("Face");//Face value按钮
		bIED = new JButton("IED");//IED按钮
		bincome1 = new JButton("Income1");//个人收入按钮
		bincome2 = new JButton("Income2");//个人收入按钮
		binventory = new JButton("Inventory");//库存按钮
		bliability = new JButton("Liabi");//负债按钮
		blife = new JButton("Life");//使用周期按钮
		bMMY = new JButton("MMY");//MMY按钮
		bMR = new JButton("MR");//边际收入按钮
		bmaxprice = new JButton("MPrice");//预期最大价格按钮
		bNIM = new JButton("NIM");//净利差按钮
		bprice1 = new JButton("Price1");//价格按钮
		bprice2 = new JButton("Price2");//价格按钮
		bPED = new JButton("PED");//PED按钮
		bprofit = new JButton("Profit");//利润按钮
		bquantity = new JButton("Quantity");//数量按钮
		bquantity1 = new JButton("Quantity1");//数量按钮
		bquantity2 = new JButton("Quantity2");//数量按钮
		bquick = new JButton("Quick");//速动比率按钮
		brevenue = new JButton("Reve");//收入按钮
		bresidual = new JButton("Residual");//残值按钮
		bsales = new JButton("Sales");//销售成本按钮
		bsalesvolume = new JButton("SalesV");//运营资金周期按钮
        bWCP = new JButton("WCP");//运营资金周期按钮
		
		
		
		p3.add(basset);
		p3.add(bBDY);
		p3.add(bBEY);
		p3.add(bcost);
		p3.add(bcurrent);
		p3.add(bcontribution);	
		p3.add(bdiscount);
		p3.add(bdays);
		p3.add(bdepre);
		p3.add(bexpense);
		p3.add(bequity);
		p3.add(bEPS);
		p3.add(bfacevalue);
		p3.add(binventory);
		p3.add(bincome1);	 
		p3.add(bincome2);
		p3.add(bIED);
		p3.add(bliability);
		p3.add(blife);
		p3.add(bMMY);
		p3.add(bMR);
		p3.add(bmaxprice);
		p3.add(bNIM);
		p3.add(bprice1);
		p3.add(bprice2);
		p3.add(bPED);
		p3.add(bprofit);
		p3.add(bquantity);
		p3.add(bquantity1);
		p3.add(bquantity2);
		p3.add(bquick);	
		p3.add(brevenue);
		p3.add(bresidual);
		p3.add(bsales);
		p3.add(bsalesvolume);
		p3.add(bWCP);
		
		
		
		
				 	 	 	 	
	 	
	 	

		/*为运算符按钮注册监听器*/
		badd.addActionListener(this);
		bsbb.addActionListener(this);
		bmul.addActionListener(this);
		bdiv.addActionListener(this);
		bdiscount.addActionListener(this);
		bfacevalue.addActionListener(this);
		bdays.addActionListener(this);
		bBDY.addActionListener(this);
		bMMY.addActionListener(this);
		bBEY.addActionListener(this);
		basset.addActionListener(this);
		bprice1.addActionListener(this);
		bprice2.addActionListener(this);
		bliability.addActionListener(this);
		brevenue.addActionListener(this);
		bexpense.addActionListener(this);
		bequity.addActionListener(this);
		bdepre.addActionListener(this);
		bcost.addActionListener(this);
		bresidual.addActionListener(this);
		blife.addActionListener(this);
		bPED.addActionListener(this);
		bquantity.addActionListener(this);
		bquantity1.addActionListener(this);
		bquantity2.addActionListener(this);
		bIED.addActionListener(this);
		bincome1.addActionListener(this);
		bincome2.addActionListener(this);
		bcurrent.addActionListener(this);
		binventory.addActionListener(this);
		bquick.addActionListener(this);
		bEPS.addActionListener(this);
		bNIM.addActionListener(this);
		bsales.addActionListener(this);
		bWCP.addActionListener(this);
		bMR.addActionListener(this);
		bmaxprice.addActionListener(this);
		bsalesvolume.addActionListener(this);
		bprofit.addActionListener(this);
		bcontribution.addActionListener(this);
		add(p1);
		add(p2);
		add(p3);
		add(new JLabel(""));
	}           
      /*构造方法结束，界面设计结束*/
	
public void actionPerformed(ActionEvent e) {   //所有按钮的action事件监听器
	    
	/*如果按下数字或者是小数点按钮，则记下该数,并在文本框中显示*/
 	for (int i = 0; i < 10; i ++) {
        if (e.getSource() == b[i] || e.getSource() == bpoint){ //判断按下的是否为数字按钮或小数点按钮
        	s = s + e.getActionCommand();//把输入的数字组合起来,并保存到s
        	text.setText(s);
        	break;
        }
 	}
	
	/*判断运算符号按钮，并作上标记 */
     	if (e.getSource() == badd){ // +号
            x = Double.parseDouble(s);//保存第一个操作数到x 
            flag = 1 ;//运算符标记
            text.setText("+");
            s="";
        }
     	if (e.getSource() == bsbb){// -号
            x = Double.parseDouble(s);
            flag = 2;
            text.setText("-");
            s="";
        }
        if (e.getSource() == bmul){// *号
            x = Double.parseDouble(s);
            flag = 3;
            text.setText("*");
            s="";
        }
        if (e.getSource() == bdiv){// /号
            x = Double.parseDouble(s);
            flag = 4;
            text.setText("/");
            s="";
        }
       
        if (e.getSource() == bfacevalue){ // 面值
            x = Double.parseDouble(s);//保存操作数到x
            flag = 5; 
            text.setText("Face");
            s="";
            
        }
        if (e.getSource() == bdays){ // 到期时间
            y = Double.parseDouble(s);//保存操作数到y
            flag = 5; 
            text.setText("Days");
            s="";
            
        }
        if (e.getSource() == bprice1){ // 期初价格
            x = Double.parseDouble(s);//保存操作数到x
            flag = 5; 
            text.setText("Price1");
            s="";
            
        }
        if (e.getSource() == brevenue){ // 收入
            x = Double.parseDouble(s);//保存操作数到x
            flag = 6; 
            text.setText("Reve");
            s="";
            
        }
        
        if (e.getSource() == bexpense){ // 支出
            y = Double.parseDouble(s);//保存操作数到y
            flag = 6; 
            text.setText("Expense");
            s="";
            
        }
        if (e.getSource() == basset){ // 资产
            x = Double.parseDouble(s);//保存操作数到x
            flag = 6; 
            text.setText("Asset");
            s="";
            
        }
        if (e.getSource() == bresidual){ // 残值
            x = Double.parseDouble(s);//保存操作数到x
            flag = 7; 
            text.setText("Residual");
            s="";
            
        }
        if (e.getSource() == blife){ // 使用周期
            y = Double.parseDouble(s);//保存操作数到y
            flag = 7; 
            text.setText("Life");
            s="";
            
        }
        if (e.getSource() == bquantity1){ // 期初数量
            x = Double.parseDouble(s);//保存操作数到x
            flag = 8; 
            text.setText("Quantity1");
            s="";
            
        }
        if (e.getSource() == bquantity2){ // 期末数量
            z = Double.parseDouble(s);//保存操作数到z
            flag = 8; 
            text.setText("Quantity2");
            s="";
            
        }
        if (e.getSource() == bquantity){ // 数量
            m = Double.parseDouble(s);//保存操作数到m
            flag = 8; 
            text.setText("Quantity");
            s="";
            
        }
        if (e.getSource() == bprice2){ // 期末价格
            y = Double.parseDouble(s);//保存操作数到y
            flag = 8; 
            text.setText("Price2");
            s="";
            
        }
        if (e.getSource() == bmaxprice){ // 预期最大价格
            k = Double.parseDouble(s);//保存操作数到k
            flag = 8; 
            text.setText("MPrice");
            s="";
            
        }
        if (e.getSource() == bincome1){ // 期初收入
            x = Double.parseDouble(s);//保存操作数到x
            flag = 8; 
            text.setText("Income1");
            s="";
            
        }
        if (e.getSource() == bincome2){ // 期末收入
            y = Double.parseDouble(s);//保存操作数到y
            flag = 8; 
            text.setText("Income2");
            s="";
            
        }
         if (e.getSource() == bliability){ // 负债
            x = Double.parseDouble(s);//保存操作数到x
            flag = 9; 
            text.setText("Liabi");
            s="";
            
        }
        if (e.getSource() == bsales){ // 销售成本
            y = Double.parseDouble(s);//保存操作数到y
            flag = 9; 
            text.setText("Sales");
            s="";
            
        }
        if (e.getSource() == binventory){ // 库存
            y = Double.parseDouble(s);//保存操作数到y
            flag = 9; 
            text.setText("Inventory");
            s="";
            
        }
        if (e.getSource() == bequity){ // 权益
            x = Double.parseDouble(s);//保存操作数到x
            flag = 10; 
            text.setText("Equi");
            s="";
            
        }
        if (e.getSource() == bcost){ // 支出
            x = Double.parseDouble(s);//保存操作数到x
            flag = 11; 
            text.setText("Cost");
            s="";
            
        }
        if (e.getSource() == bcontribution){ // 贡献
            y = Double.parseDouble(s);//保存操作数到y
            flag = 11; 
            text.setText("Contribution");
            s="";
            
        }
        if (e.getSource() == bclean){//清空文本框
            text.setText("");
            s="";
            flag = 0;
        }

        /*若是=号，则进行运算*/
        if(e.getSource() == beq) {
        	switch (flag) {
        		case 1:{ //加法运算算法
        			x = Double.parseDouble(s) + x; //s保存操作数，令x=s+x;
        			String s = String.valueOf(x);//将Double转换为string
        			text.setText(s);
        			break;
        		}
        		case 2:{  //减法运算算法
        			x = x - Double.parseDouble(s); //s保存操作数，令x=x-s;
        			String s = String.valueOf(x);//将Double转换为string
        			text.setText(s);
        			break;
        		}
        		case 3:{    //乘法运算
        			x = Double.parseDouble(s) * x; //s保存操作数，令x=s*x;
        			String s = String.valueOf(x);//将Double转换为string
        			text.setText(s);
        			break;
        		}  
				case 4:{     //除法运算
					if(Double.parseDouble(s) == 0) {
						text.setText("除数不能为0!");
						break;
					}
	                x = x / Double.parseDouble(s);
	                String s = String.valueOf(x);
	                text.setText(s);
	                break;
                }
           }
           
   
           s="";
        }
        if(e.getSource() == bBDY) {
        	switch (flag) {
        		case 5:{ //银行贴现率计算
        			x = (x/y)*(360/ Double.parseDouble(s)); //s保存操作数;
        			String s = String.valueOf(x);//将Double转换为string
        			text.setText(s);
        			break;
        		}
        	}
        s="";
      }
      if(e.getSource() == bMMY) {
        	switch (flag) {
        		case 5:{ //货币市场收益率计算
        			x = (x/y)*(360/ Double.parseDouble(s)); //s保存操作数;
        			String s = String.valueOf(x);//将Double转换为string
        			text.setText(s);
        			break;
        		}
        	}
        s="";
      }
      if(e.getSource() == bBEY) {
        	switch (flag) {
        		case 5:{ //债券等价收益率
        			x = (x/y)*(365/ Double.parseDouble(s)); //s保存操作数;
        			String s = String.valueOf(x);//将Double转换为string
        			text.setText(s);
        			break;
        		}
        	}
        s="";
      }
      if(e.getSource() == basset) {
        	switch (flag) {
        		case 6:{ //资产运算
        			x = x+y-Double.parseDouble(s); //s保存操作数;
        			String s = String.valueOf(x);//将Double转换为string
        			text.setText(s);
        			break;
        		}
        	}
        s="";
      }
      if(e.getSource() == bequity) {
        	switch (flag) {
        		case 6:{ //权益运算
        			x = y-Double.parseDouble(s); //s保存操作数;
        			String s = String.valueOf(x);//将Double转换为string
        			text.setText(s);
        			break;
        		}
        	}
        s="";
      }
       if(e.getSource() == bdepre) {
        	switch (flag) {
        		case 7:{ //折旧计算
        			x =(x- y)/Double.parseDouble(s); //s保存操作数;
        			String s = String.valueOf(x);//将Double转换为string
        			text.setText(s);
        			break;
        		}
        	}
        s="";
      }
      if(e.getSource() == bPED) {
        	switch (flag) {
        		case 8:{ //需求价格弹性计算
        			x =(z- x)/(y-Double.parseDouble(s)); //s保存操作数;
        			String s = String.valueOf(x);//将Double转换为string
        			text.setText(s);
        			break;
        		}
        	}
        s="";
      }
      if(e.getSource() == bIED) {
        	switch (flag) {
        		case 8:{ //需求收入弹性计算
        			x =(z- x)/(y-Double.parseDouble(s)); //s保存操作数;
        			String s = String.valueOf(x);//将Double转换为string
        			text.setText(s);
        			break;
        		}
        	}
        s="";
      }
      if(e.getSource() == bcurrent) {
        	switch (flag) {
        		case 9:{ //流动比率计算
        			x =x/Double.parseDouble(s); //s保存操作数;
        			String s = String.valueOf(x);//将Double转换为string
        			text.setText(s);
        			break;
        		}
        	}
        s="";
      }
      if(e.getSource() == bquick) {
        	switch (flag) {
        		case 9:{ //速动比率计算
        			x =(y-x)/Double.parseDouble(s); //s保存操作数;
        			String s = String.valueOf(x);//将Double转换为string
        			text.setText(s);
        			break;
        		}
        	}
        s="";
      }
      if(e.getSource() == bEPS) {
        	switch (flag) {
        		case 10:{ //每股收益率计算
        			x =x/Double.parseDouble(s); //s保存操作数;
        			String s = String.valueOf(x);//将Double转换为string
        			text.setText(s);
        			break;
        		}
        	}
        s="";
      }
      if(e.getSource() == bNIM) {
        	switch (flag) {
        		case 6:{ //净利差计算
        			x =(y-x)/Double.parseDouble(s); //s保存操作数;
        			String s = String.valueOf(x);//将Double转换为string
        			text.setText(s);
        			break;
        		}
        	}
        s="";
      }
      if(e.getSource() == bWCP) {
        	switch (flag) {
        		case 9:{ //运营资金周期计算
        			x =(x-y)/Double.parseDouble(s)*365; //s保存操作数;
        			String s = String.valueOf(x);//将Double转换为string
        			text.setText(s);
        			break;
        		}
        	}
        s="";
      }
      if(e.getSource() == bMR) {
        	switch (flag) {
        		case 8:{ //边际收入计算
        			x =0-(2*(y-x)/(z-m))*k+Double.parseDouble(s); //s保存操作数;
        			String s = String.valueOf(x);//将Double转换为string
        			text.setText(s);
        			break;
        		}
        	}
        s="";
      }
      if(e.getSource() == bsalesvolume) {
        	switch (flag) {
        		case 11:{ //销售额计算
        			x =(x+y)/Double.parseDouble(s); //s保存操作数;
        			String s = String.valueOf(x);//将Double转换为string
        			text.setText(s);
        			break;
        		}
        	}
        s="";
      }
   
   
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}catch (Exception e) {};
		myCalculator cal = new myCalculator();
		cal.setVisible(true);
		cal.pack();
        cal.addWindowListener(new WindowAdapter() {
        	public void windowClosing(WindowEvent e) {
        		System.exit(0);
        	}
        });
	}
}

