package Bank;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JTable;

//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.FormSpecs;
//import com.jgoodies.forms.layout.RowSpec;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SpringLayout;
import java.awt.GridLayout;
import java.awt.Image;

//import net.miginfocom.swing.MigLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class Bank_Main extends JFrame {
	private JTextField textField, textField_1;
	private Connection conn = null;
	private JLabel state;
	private PreparedStatement pstmt;
	private ResultSet rs;	
	ImageIcon imageicon = new ImageIcon("bank_mid.jpg");
	Image img = imageicon.getImage();
	private final Action action = new SwingAction();
	
	 String id = null;
	 
	 Statement stmt = null;
	    String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 오라클 포트번호1521/@이후에는 IP주소
	    String sql = null;
	    Properties info = null;
	    Connection cnn = null;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bank_Main frame = new Bank_Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
///////////////////////// 로그인창 ///////////////////////////
	public Bank_Main() {
		DBconnect();
		setTitle("광주은행");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 200);
		getContentPane().setLayout(null);
		
		JLabel imgLabel = new JLabel();
		imgLabel.setIcon(imageicon);
		imgLabel.setBounds(12, 10, 200, 51);
		getContentPane().add(imgLabel);
		
		JButton btnNewButton = new JButton("확인");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login(textField.getText(), textField_1.getText());
				new Bank_Title();
			}
		});
		btnNewButton.setAction(action);
		btnNewButton.setBounds(175, 128, 97, 23);
		getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(156, 101, 116, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("사원번호 입력 :");
		lblNewLabel.setBounds(53, 104, 91, 15);
		getContentPane().add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(156, 70, 116, 21);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("성명 :");
		lblNewLabel_1.setBounds(103, 71, 41, 15);
		getContentPane().add(lblNewLabel_1);
	}
	
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "확인");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
//			login(textField.getText(), textField_1.getText());
		}
	}
///////////////////////// DB연결 ///////////////////////////
	public void DBconnect() {
		state = new JLabel();
		state.setText("Oracle DB 연동확인");
		
		try {
			// DB 연결
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "seo", "1234");
			state.setText("성공적연결");
		} catch (ClassNotFoundException e) {
			//		- 8 -
			e.printStackTrace();
			state.setText("DB 연결실패" + e.toString());
		} catch (SQLException e) {
			e.printStackTrace();
			state.setText("DB 연결실패" + e.toString());
		}
		setVisible(true);
	}
///////////////////////// 로그인 함수 ///////////////////////////
	 public int login(String s_name, String s_num) {
	        String SQL = "Select s_num From staff where s_name = ?";
	        //실제 SQL에서 작동하게 할 명령문 입력
	        try {
	            pstmt = conn.prepareStatement(SQL);
	            pstmt.setString(1, s_name);
	            //인젝션해킹등을 방지하기 위한 기법 ?에 ID값을 받은 후 사용.
	            rs = pstmt.executeQuery();
	            if(rs.next()) {
	                if(rs.getString(1).equals(s_num)) {
	                	System.out.println("성공");
	                    return 1; // 로그인 성공
	                } else 
	                	System.out.println("실패했습니다.");
	                    return 0; // 비밀번호 불일치
	            }
	            return -1; //아이디가 없음
	        }catch(Exception e) {
	            e.printStackTrace();    // 예외처리
	        }
	        return -2; // 데이터베이스 오류
	    }
	
	
}
