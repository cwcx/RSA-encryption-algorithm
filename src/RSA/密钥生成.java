package RSA;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.awt.event.ActionEvent;

public class 密钥生成 extends JFrame {

	private JPanel contentPane;
	private JTextField ptext;
	private JTextField qtext;
	
	public JTextArea output1;
	private JTextField ntext;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					密钥生成 frame = new 密钥生成();
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
	public 密钥生成() {
		setTitle("\u5BC6\u94A5\u751F\u6210");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Label1 = new JLabel("\u8BF7\u8F93\u5165\u751F\u6210\u7D20\u6570\u4F4D\u6570\uFF1A");
		Label1.setFont(new Font("宋体", Font.PLAIN, 20));
		Label1.setBounds(10, 10, 200, 26);
		contentPane.add(Label1);
		
		JLabel Label2 = new JLabel("\u8BF7\u8F93\u5165\u7B2C\u4E00\u4E2A\u7D20\u6570\uFF1A");
		Label2.setFont(new Font("宋体", Font.PLAIN, 20));
		Label2.setBounds(320, 10, 180, 26);
		contentPane.add(Label2);
		
		JLabel Label3 = new JLabel("\u8BF7\u8F93\u5165\u7B2C\u4E8C\u4E2A\u7D20\u6570\uFF1A");
		Label3.setFont(new Font("宋体", Font.PLAIN, 20));
		Label3.setBounds(320, 82, 180, 26);
		contentPane.add(Label3);
		
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(10, 82, 300, 200);
		contentPane.add(scrollPane1);
		
		output1 = new JTextArea();
		scrollPane1.setViewportView(output1);
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(320, 190, 406, 200);
		contentPane.add(scrollPane2);
		
		JTextArea output2 = new JTextArea();
		scrollPane2.setViewportView(output2);
		
		ptext = new JTextField();
		ptext.setFont(new Font("宋体", Font.PLAIN, 20));
		ptext.setColumns(10);
		ptext.setBounds(320, 46, 406, 26);
		contentPane.add(ptext);
		
		qtext = new JTextField();
		qtext.setFont(new Font("宋体", Font.PLAIN, 20));
		qtext.setColumns(10);
		qtext.setBounds(320, 118, 406, 26);
		contentPane.add(qtext);
		
		ntext = new JTextField();
		ntext.setFont(new Font("宋体", Font.PLAIN, 20));
		ntext.setColumns(10);
		ntext.setBounds(10, 46, 70, 26);
		contentPane.add(ntext);
		
		JButton b1 = new JButton("\u751F\u6210");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int n=Integer.parseInt(ntext.getText());
					output1.setText(function.f4(n).toString());
				} catch (Exception e2) {
					output1.append("error\n");
				}
			}
		});
		b1.setFont(new Font("宋体", Font.PLAIN, 20));
		b1.setBounds(90, 46, 80, 26);
		contentPane.add(b1);

		
		JButton b2 = new JButton("\u751F\u6210");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					BigInteger p=new BigInteger(ptext.getText());
					BigInteger q=new BigInteger(qtext.getText());
					BigInteger []k=function.f5(p, q);
					output2.setText("kpub=("+k[0].toString()+"，"+k[1].toString()+")；\nkpr="+k[2].toString());
				} catch (Exception e2) {
					output2.setText("error");
				}
			}
		});
		b2.setFont(new Font("宋体", Font.PLAIN, 20));
		b2.setBounds(481, 154, 80, 26);
		contentPane.add(b2);
		
	}
}
