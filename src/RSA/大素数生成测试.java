package RSA;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class 大素数生成测试 extends JFrame {

	private JPanel contentPane;
	private JTextField ntext;

	public JTextArea output;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					大素数生成测试 frame = new 大素数生成测试();
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
	public 大素数生成测试() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ntext = new JTextField();
		ntext.setFont(new Font("宋体", Font.PLAIN, 20));
		ntext.setColumns(10);
		ntext.setBounds(140, 10, 70, 26);
		contentPane.add(ntext);
		
		JLabel Label1 = new JLabel("\u8BF7\u8F93\u5165\u4F4D\u6570\uFF1A");
		Label1.setFont(new Font("宋体", Font.PLAIN, 20));
		Label1.setBounds(10, 10, 120, 26);
		contentPane.add(Label1);
		
		JButton btnNewButton = new JButton("\u751F\u6210");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int n=Integer.parseInt(ntext.getText());
					output.setText(function.f4(n).toString());
				} catch (Exception e2) {
					output.append("error\n");
				}
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton.setBounds(220, 10, 80, 26);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 46, 416, 217);
		contentPane.add(scrollPane);
		
		output = new JTextArea();
		scrollPane.setViewportView(output);
	}
}
