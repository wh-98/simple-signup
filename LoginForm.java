import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginForm extends JFrame {
	private int loginTimes = 0;  //登录次数
	private JTextField tfUserName;
	private JPasswordField pwdField;
	private JLabel labelLoginInfo;
	UserDAO dao;
	public LoginForm() {
		this.setBounds(500,200,350,250);
		setResizable(false);
		setTitle("\u957F\u6C5F\u5927\u5B66\u56FE\u4E66\u9986\u7BA1\u7406\u4FE1\u606F\u7CFB\u7EDF");
		getContentPane().setLayout(null);
		
		JLabel labelUserName = new JLabel("\u7528\u6237\u7F16\u53F7\uFF1A");
		labelUserName.setBounds(44, 30, 98, 21);
		getContentPane().add(labelUserName);
		
		tfUserName = new JTextField();
		tfUserName.setBounds(133, 27, 167, 27);
		getContentPane().add(tfUserName);
		tfUserName.setColumns(10);
		
		JLabel labelPassword = new JLabel("\u7528\u6237\u5BC6\u7801:");
		labelPassword.setBounds(44, 84, 81, 21);
		getContentPane().add(labelPassword);
		
		labelLoginInfo = new JLabel("\u767B\u5F55\u4FE1\u606F\uFF1A");
		labelLoginInfo.setForeground(Color.RED);
		labelLoginInfo.setBounds(44, 178, 256, 21);
		getContentPane().add(labelLoginInfo);
		
		JButton btnLogin = new JButton("\u767B\u5F55");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Vaildate();
			}
			
		});
				
		btnLogin.setBounds(64, 134, 98, 29);
		getContentPane().add(btnLogin);
		
		JButton btnClose = new JButton("\u9000\u51FA");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();  //关闭当前窗体
			}
		});
		btnClose.setBounds(192, 134, 98, 29);
		getContentPane().add(btnClose);
		
		pwdField = new JPasswordField();
		pwdField.setBounds(133, 81, 167, 27);
		getContentPane().add(pwdField);
	}
	public void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void Vaildate() {//用户名验证
		++loginTimes;
		dao=new UserDAO();
        String userId=tfUserName.getText().trim();
        String password=new String(pwdField.getPassword()).trim();
		String errorMsg = "";
		 if(dao.findUser(userId, password)==true) 
	        {
			 errorMsg = "登录成功";
	        }
	            
	        else 
	        {
	        	errorMsg = "登录失败";
	        }	
		
		if(errorMsg.length() > 0)
			labelLoginInfo.setText(errorMsg);
	}

}





