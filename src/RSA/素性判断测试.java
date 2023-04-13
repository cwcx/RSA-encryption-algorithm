package RSA;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.awt.event.ActionEvent;

public class 素性判断测试 extends JFrame {

	private JPanel contentPane;
	private JTextField t1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					素性判断测试 frame = new 素性判断测试();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public 素性判断测试() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		t1 = new JTextField();
		t1.setFont(new Font("宋体", Font.PLAIN, 26));
		t1.setColumns(10);
		t1.setBounds(10, 10, 180, 30);
		contentPane.add(t1);
		
		JLabel res = new JLabel("");
		res.setOpaque(true);
		res.setFont(new Font("宋体", Font.PLAIN, 26));
		res.setBackground(Color.YELLOW);
		res.setBounds(10, 50, 280, 30);
		contentPane.add(res);
		
		JButton b1 = new JButton("\u5224\u65AD");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					BigInteger x=new BigInteger(t1.getText());
					if(x.compareTo(BigInteger.ZERO)>0) {
						if(function.f2(x)) {
							res.setText("很可能是素数");
						}else {
							res.setText("非素数");
						}
					}
					else {
						res.setText("请输入大于0的数");
					}
				} catch (Exception e2) {
					res.setText("error");
				}
				
			}
		});
		b1.setFont(new Font("宋体", Font.PLAIN, 26));
		b1.setBounds(200, 10, 90, 30);
		contentPane.add(b1);		
	}
}
