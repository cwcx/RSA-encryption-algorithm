package RSA;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.awt.event.ActionEvent;

public class ���ز��� extends JFrame {

	private JPanel contentPane;
	private JTextField xtext;
	private JTextField ytext;
	private JButton btnButton;
	private JLabel res;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					���ز��� frame = new ���ز���();
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
	public ���ز���() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel x = new JLabel("\u7B2C\u4E00\u4E2A\u6570");
		x.setFont(new Font("����", Font.PLAIN, 26));
		x.setBounds(10, 10, 120, 30);
		contentPane.add(x);
		
		JLabel y = new JLabel("\u7B2C\u4E8C\u4E2A\u6570");
		y.setFont(new Font("����", Font.PLAIN, 26));
		y.setBounds(10, 50, 120, 30);
		contentPane.add(y);
		
		xtext = new JTextField();
		xtext.setFont(new Font("����", Font.PLAIN, 26));
		xtext.setBounds(140, 10, 66, 30);
		contentPane.add(xtext);
		xtext.setColumns(10);
		
		ytext = new JTextField();
		ytext.setFont(new Font("����", Font.PLAIN, 26));
		ytext.setColumns(10);
		ytext.setBounds(140, 50, 66, 30);
		contentPane.add(ytext);
		
		btnButton = new JButton("\u6D4B\u8BD5");
		btnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					BigInteger x=new BigInteger(xtext.getText());
					BigInteger y=new BigInteger(ytext.getText());
					if(x.compareTo(BigInteger.ONE)>0 && y.compareTo(BigInteger.ONE)>0) {
						if(x.equals(y)) {
							res.setText("������������ͬ����");
						}else {
							if(function.f1(x,y)) {
								res.setText("����");
							}else {
								res.setText("�ǻ���");
							}
						}
					}else {
						res.setText("���������1����");
					}
				} catch (Exception e2) {
					res.setText("error");
				}
			}
		});
		btnButton.setFont(new Font("����", Font.PLAIN, 26));
		btnButton.setBounds(216, 10, 90, 30);
		contentPane.add(btnButton);
		
		res = new JLabel("");
		res.setBackground(Color.YELLOW);
		res.setOpaque(true);
		res.setFont(new Font("����", Font.PLAIN, 26));
		res.setBounds(10, 90, 296, 30);
		contentPane.add(res);
	}
}
