package GUI;
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import Entity.*;
import EntityList.*;

public class Login extends JFrame implements ActionListener{
    JLabel userNameLable, userPassLabel;
    JTextField userName;
    JPasswordField password;
    JButton btnLogin;
	
	JPanel panel;
	
    Font font = new Font("cambria", Font.PLAIN, 30);
	
	EmployeeList emplist;
	CustomerList cuslist;
	RoomList roomlist;
	
    public Login(EmployeeList emplist, CustomerList cuslist, RoomList roomlist) {
        super("Login");
		
		this.emplist = emplist; 
		this.cuslist = cuslist; 
		this.roomlist = roomlist;
		
        this.setSize(1200, 700);
        this.setLocation(150, 70);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		panel = new JPanel();
		panel.setBounds(0,0,1200,700);
		
		panel.setOpaque(false);
		panel.setLayout(null);
		this.add(panel);
		ImageIcon image = new ImageIcon("Resources/Login1.png");
		
		//label
		JLabel background = new JLabel();
		background.setBounds(0,0,1200,700);
		background.setIcon(image);
		this.add(background);
		
        userNameLable = new JLabel("User Name");
        userNameLable.setBounds(750, 210, 200, 40);
        userNameLable.setFont(font);
		userNameLable.setForeground(new Color(0,0,0));
        this.add(userNameLable);
		
        userName = new JTextField("Admin");
        userName.setBounds(920, 215, 200, 30);
        userName.setFont(font);
        this.add(userName);
		
        userPassLabel = new JLabel("Password");
        userPassLabel.setBounds(750, 280, 200, 40);
        userPassLabel.setFont(font);
		userPassLabel.setForeground(new Color(0,0,0));
        this.add(userPassLabel);
		
        password = new JPasswordField("admin");
        password.setBounds(920, 285, 200, 30);
		password.setEchoChar('*');
        password.setFont(font);
        this.add(password);

		//button
        btnLogin = new JButton("Login");
        btnLogin.setBounds(880, 350, 150, 50);
        btnLogin.setFont(font);
		btnLogin.setBackground(new Color(74, 28, 33));
		btnLogin.setForeground(new Color(255,255,255));
        btnLogin.addActionListener(this);
        this.add(btnLogin);
		
		panel.add(userNameLable);
		panel.add(userPassLabel);
		panel.add(userName);
		panel.add(password);
		panel.add(btnLogin);
		
        this.setVisible(true);

    }

	//action
    public void actionPerformed(ActionEvent e) {
        if (btnLogin == e.getSource()) {
			
            String name = userName.getText();
            String pass = String.valueOf(password.getPassword());

            if (name.equals("Admin") && pass.equals("admin")) {
				
				
				Dashboard dashboard = new Dashboard(emplist, cuslist, roomlist);
				
                userName.setText("");
                password.setText("");
                this.setVisible(false);
            } 
			else {
                JOptionPane.showMessageDialog(this, "Invalid User Name or Password", "Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
