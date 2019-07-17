import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class Calculator extends Frame implements WindowListener {
	private Button[] btn;
	private Panel[] p;
	private Label upL, downL;
	private String[] btnName;

	public void init(){	
		upL = new Label(""); // 식
		downL = new Label(""); // 입력 숫자
		btn = new Button[18];
		p = new Panel[8];
		btnName = new String[]{"BackSpace","C","7","8","9","/","4","5","6","*","1","2","3","-","-",".","0","=","*"};
		
		this.setResizable(false); // 윈도우 크기 고정

		// 패널배열객체생성
		for (int i = 0; i < p.length; i++) { 
			p[i] = new Panel(); 
		}
		
		// 패널 레이아웃
		p[0].setBackground(new Color(200,200,200));
		p[0].setLayout(new GridLayout(7,1,5,5));
		//p[1].setLayout(new GridLayout(1,1,5,5));
		//p[2].setLayout(new GridLayout(1,1,5,5));
		p[3].setLayout(new GridLayout(1,2,5,5));
		p[4].setLayout(new GridLayout(1,4,5,5));
		p[5].setLayout(new GridLayout(1,4,5,5));
		p[6].setLayout(new GridLayout(1,4,5,5));
		p[7].setLayout(new GridLayout(1,4,5,5));

		// 라벨
		upL.setBackground(new Color(223,234,255));
		upL.setPreferredSize(new Dimension(280,35));
		downL.setBackground(new Color(223,234,255));
		downL.setPreferredSize(new Dimension(280,35));
		
		// 버튼배열객체생성
		for (int i = 0; i < btn.length; i++) {
			btn[i] = new Button(btnName[i]);
		}
		
		// 작은패널 <- 버튼/라벨
		p[1].add(upL);
		p[2].add(downL);
		p[3].add(btn[0]);
		p[3].add(btn[1]);
		int n = 2;
		for (int i = 4; i <= p.length-1; i++) {
			for (int j = n; j <= n+3; j++) {
				p[i].add(btn[j]);
			}
			n+=4;
		}
		
		// 전체패널
		add(p[0]); 	
		
		// 전체패널 <-작은패널
		for(int i = 1; i<=7; i++) 
			p[0].add(p[i]);
		
		// window
		setTitle("계산기");
		setBounds(800,250,300,400);
		setBackground(new Color(100,100,100));
		setVisible(true);
		
		// event
		this.addWindowListener(this);
	}
	
	// windowListener
	public void	windowActivated(WindowEvent e){}

	public void	windowClosed(WindowEvent e){}

	public void	windowClosing(WindowEvent e){ System.exit(0); }

	public void	windowDeactivated(WindowEvent e){}

	public void	windowDeiconified(WindowEvent e){}

	public void	windowIconified(WindowEvent e){}

	public void	windowOpened(WindowEvent e){}

	// main
	public static void main(String[] args) {
		new Calculator().init();
	}
}