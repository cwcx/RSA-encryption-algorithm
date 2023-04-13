package RSA;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.awt.event.ActionEvent;

public class 求逆元测试 extends JFrame {

	private JPanel contentPane;
	private JTextField etext;
	private JTextField ntext;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					求逆元测试 frame = new 求逆元测试();
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
	public 求逆元测试() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		etext = new JTextField();
		etext.setFont(new Font("宋体", Font.PLAIN, 20));
		etext.setColumns(10);
		etext.setBounds(10, 10, 70, 26);
		contentPane.add(etext);
		
		JLabel Label0 = new JLabel("*");
		Label0.setFont(new Font("宋体", Font.PLAIN, 20));
		Label0.setBounds(90, 10, 30, 26);
		contentPane.add(Label0);
		
		JLabel res = new JLabel("");
		res.setOpaque(true);
		res.setFont(new Font("宋体", Font.PLAIN, 20));
		res.setBackground(Color.YELLOW);
		res.setBounds(110, 10, 292, 26);
		contentPane.add(res);
		
		JLabel Label1 = new JLabel("mod");
		Label1.setFont(new Font("宋体", Font.PLAIN, 20));
		Label1.setBounds(10, 46, 40, 26);
		contentPane.add(Label1);
		
		ntext = new JTextField();
		ntext.setFont(new Font("宋体", Font.PLAIN, 20));
		ntext.setColumns(10);
		ntext.setBounds(60, 46, 70, 26);
		contentPane.add(ntext);
		
		JLabel Label2 = new JLabel("=");
		Label2.setFont(new Font("宋体", Font.PLAIN, 20));
		Label2.setBounds(140, 46, 30, 26);
		contentPane.add(Label2);
		
		JLabel Label3 = new JLabel("1");
		Label3.setFont(new Font("宋体", Font.PLAIN, 20));
		Label3.setBounds(158, 46, 40, 26);
		contentPane.add(Label3);
		
		JButton btnNewButton = new JButton("\u8BA1\u7B97");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					BigInteger ee=new BigInteger(etext.getText());
					BigInteger n=new BigInteger(ntext.getText());
					if(ee.compareTo(BigInteger.ZERO)>0 && n.compareTo(BigInteger.ZERO)>0) {
						res.setText(function.f3(ee, n).toString());
					}else {
						res.setText("请输入大于0的数");
					}
				} catch (Exception e2) {
					res.setText("error");
				}
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton.setBounds(180, 46, 80, 26);
		contentPane.add(btnNewButton);
	}
}
