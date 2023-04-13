package RSA;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.awt.event.ActionEvent;

public class 模运算测试 extends JFrame {

	private JPanel contentPane;
	private JTextField textField0;
	private JTextField textField1;
	private JTextField textField2;
	private JLabel Label2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					模运算测试 frame = new 模运算测试();
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
	public 模运算测试() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField0 = new JTextField();
		textField0.setFont(new Font("宋体", Font.PLAIN, 20));
		textField0.setBounds(10, 10, 70, 26);
		contentPane.add(textField0);
		textField0.setColumns(10);
		
		textField1 = new JTextField();
		textField1.setFont(new Font("宋体", Font.PLAIN, 20));
		textField1.setBounds(113, 10, 70, 26);
		contentPane.add(textField1);
		textField1.setColumns(10);
		
		textField2 = new JTextField();
		textField2.setFont(new Font("宋体", Font.PLAIN, 20));
		textField2.setBounds(232, 10, 70, 26);
		contentPane.add(textField2);
		textField2.setColumns(10);
		
		JLabel Label0 = new JLabel("^");
		Label0.setFont(new Font("宋体", Font.PLAIN, 30));
		Label0.setBounds(90, 10, 58, 50);
		contentPane.add(Label0);
		
		JLabel Label1 = new JLabel("mod");
		Label1.setFont(new Font("宋体", Font.PLAIN, 20));
		Label1.setBounds(193, 10, 40, 26);
		contentPane.add(Label1);
		
		Label2 = new JLabel("=");
		Label2.setFont(new Font("宋体", Font.PLAIN, 20));
		Label2.setBounds(312, 10, 30, 26);
		contentPane.add(Label2);
		
		JLabel Label3 = new JLabel("");
		Label3.setOpaque(true);
		Label3.setBackground(Color.YELLOW);
		Label3.setFont(new Font("宋体", Font.PLAIN, 20));
		Label3.setBounds(113, 46, 292, 26);
		contentPane.add(Label3);
		
		JButton btnNewButton = new JButton("\u8BA1\u7B97");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					BigInteger x=new BigInteger(textField0.getText());
					BigInteger y=new BigInteger(textField1.getText());
					BigInteger z=new BigInteger(textField2.getText());
					if(x.compareTo(BigInteger.ZERO)>0 && y.compareTo(BigInteger.ZERO)>0 && z.compareTo(BigInteger.ZERO)>0) {
						Label3.setText(function.mod(x,y,z).toString());
					}else {
						Label3.setText("请输入大于0的数");
					}
				} catch (Exception e2) {
					Label3.setText("error");
				}
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton.setBounds(10, 46, 80, 26);
		contentPane.add(btnNewButton);		
	}
}
