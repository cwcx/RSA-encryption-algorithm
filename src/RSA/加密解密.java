package RSA;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class 加密解密 extends JFrame {

	private JPanel contentPane;
	private JTextField ntext;
	private JTextField etext;
	private JTextField dtext;
	
	public JTextArea output1;
	public JTextArea output2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					加密解密 frame = new 加密解密();
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
	public 加密解密() {
		setTitle("\u52A0\u5BC6\u89E3\u5BC6");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 651);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Label1 = new JLabel("\u8BF7\u8F93\u5165\u8981\u52A0\u5BC6\u7684\u6587\u672C\uFF1A");
		Label1.setFont(new Font("宋体", Font.PLAIN, 20));
		Label1.setBounds(10, 10, 200, 26);
		contentPane.add(Label1);
		
		JLabel Label2 = new JLabel("\u52A0\u5BC6\u7ED3\u679C\uFF1A");
		Label2.setFont(new Font("宋体", Font.PLAIN, 20));
		Label2.setBounds(420, 10, 110, 26);
		contentPane.add(Label2);
		
		JLabel Label3 = new JLabel("\u8BF7\u8F93\u5165\u516C\u94A5n\uFF1A");
		Label3.setFont(new Font("宋体", Font.PLAIN, 20));
		Label3.setBounds(10, 256, 130, 26);
		contentPane.add(Label3);
		
		JLabel Label4 = new JLabel("\u8BF7\u8F93\u5165\u516C\u94A5e\uFF1A");
		Label4.setFont(new Font("宋体", Font.PLAIN, 20));
		Label4.setBounds(10, 292, 130, 26);
		contentPane.add(Label4);
		
		JLabel Label5 = new JLabel("\u8BF7\u8F93\u5165\u8981\u89E3\u5BC6\u7684\u6587\u672C\uFF1A");
		Label5.setFont(new Font("宋体", Font.PLAIN, 20));
		Label5.setBounds(10, 328, 200, 26);
		contentPane.add(Label5);
		
		JLabel Label6 = new JLabel("\u89E3\u5BC6\u7ED3\u679C\uFF1A");
		Label6.setFont(new Font("宋体", Font.PLAIN, 20));
		Label6.setBounds(420, 328, 110, 26);
		contentPane.add(Label6);
		
		JLabel Label7 = new JLabel("\u8BF7\u8F93\u5165\u79C1\u94A5d\uFF1A");
		Label7.setFont(new Font("宋体", Font.PLAIN, 20));
		Label7.setBounds(10, 574, 130, 26);
		contentPane.add(Label7);
		
		JTextArea input1 = new JTextArea();
		input1.setBounds(10, 46, 400, 200);
		contentPane.add(input1);		
		
		JTextArea input2 = new JTextArea();
		input2.setBounds(10, 364, 400, 200);
		contentPane.add(input2);
		
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(420, 46, 400, 200);
		contentPane.add(scrollPane1);
		
		output1 = new JTextArea();
		scrollPane1.setViewportView(output1);
		
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(420, 364, 400, 200);
		contentPane.add(scrollPane2);

		output2 = new JTextArea();
		scrollPane2.setViewportView(output2);
		
		ntext = new JTextField();
		ntext.setFont(new Font("宋体", Font.PLAIN, 20));
		ntext.setColumns(10);
		ntext.setBounds(150, 256, 260, 26);
		contentPane.add(ntext);
		
		etext = new JTextField();
		etext.setFont(new Font("宋体", Font.PLAIN, 20));
		etext.setColumns(10);
		etext.setBounds(150, 292, 260, 26);
		contentPane.add(etext);
		
		dtext = new JTextField();
		dtext.setFont(new Font("宋体", Font.PLAIN, 20));
		dtext.setColumns(10);
		dtext.setBounds(150, 574, 260, 26);
		contentPane.add(dtext);
		
		JButton b1 = new JButton("\u52A0\u5BC6");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String in1=input1.getText();
					BigInteger n=new BigInteger(ntext.getText());
					BigInteger ee=new BigInteger(etext.getText());
					output1.setText(function.f6(in1,ee,n).toString());
				} catch (Exception e2) {
					output1.setText("error");
				}
			}
		});
		b1.setFont(new Font("宋体", Font.PLAIN, 20));
		b1.setBounds(330, 10, 80, 26);
		contentPane.add(b1);
		
		JButton b2 = new JButton("\u89E3\u5BC6");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String in2=input2.getText();
					BigInteger n=new BigInteger(ntext.getText());
					BigInteger d=new BigInteger(dtext.getText());
					output2.setText(function.f7(in2,d,n));
				} catch (Exception e2) {
					output2.setText("error");
				}
			}
		});
		b2.setFont(new Font("宋体", Font.PLAIN, 20));
		b2.setBounds(330, 328, 80, 26);
		contentPane.add(b2);				
	}
}
