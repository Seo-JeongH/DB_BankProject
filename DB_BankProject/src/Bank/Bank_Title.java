package Bank;

import Loan.Loan;
import Staff.Staff;
import Account.Account;
import Customer.Customer;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class Bank_Title extends JFrame implements ActionListener {
	private Connection conn = null;
	private JLabel state;
	// Table Header Name
	private String colName[] = { "은행코드", "은행명", "주소","asd","asd"};
//	private String colName2[] = { "은행코드", "지점코드", "지점명", "주소"};
//	private String colName3[] = { "사원번호","직원명", "직급", "은행코드", "지점코드" };
//	private String colName4[] = { "주민등록번호", "고객명", "순서번호", "전화번호","주소" };
//	private String colName5[] = { "계좌번호", "잔액", "계좌종류", "체크카드" };
//	private String colName6[] = { "대출상품번호", "대출가능금액", "대출상품명"};
	// Table Data list (Header data, adding row)
	private DefaultTableModel model = new DefaultTableModel(0,5);
	// Create Table
	private JTable table = new JTable(model);
	private String row[] = new String[9];
	ImageIcon imageicon = new ImageIcon("bank_mid.jpg");
	private final Action action = new SwingAction_1();
	JLabel label = new JLabel(imageicon);
	JButton bt1;
	JButton bt2;
	JButton bt3;
	JButton bt4;
	JButton bt5;
	JButton bt6;
	JButton btnNewButton_1;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private final Action action_1 = new SwingAction();
	private final Action action_2 = new SwingAction_2();
	private final Action action_3 = new SwingAction_3();
	private final Action action_4 = new SwingAction_4();
	private final Action action_5 = new SwingAction_5();
	private final Action action_6 = new SwingAction_6();
	// JFrame 생성자
	public Bank_Title() {
		setTitle("광주은행");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 하단부연결및출력버튼컴포넌트옹패널
		JPanel Btn_panel = new JPanel();
		Btn_panel.setBounds(1274, 15, 10, 413);
		JPanel panel = new JPanel();
		panel.setBounds(0, 15, 271, 100);
		JPanel s_panel = new JPanel();
		s_panel.setBounds(0, 428, 1284, 33);
		Btn_panel.setLayout(new FlowLayout());
		panel.setLayout(new FlowLayout());
		// 패널에버튼부착
		panel.add(label);
		s_panel.setLayout(null);
		getContentPane().setLayout(null);
		//버튼이벤트리스너(액션리스너)
		//DB 연결부
		//DB 연결사용자함수호출
		//버튼이벤트리스너(액션리스너)
		//DB 읽는부
		//DB 상태출력용라벨
		state = new JLabel();
		state.setBounds(10, 125, 128, 33);
		state.setText("Oracle DB 연동테스트");
		//JFrame에배치관리자를활용한각자의위치부착
		getContentPane().add(state);
		//JScrollPane : 화면에넘어갈경우스크롤바가생김
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(276, 15, 555, 403);
		getContentPane().add(scrollPane);
//		add(new JScrollPane(table2), BorderLayout.CENTER);
		getContentPane().add(Btn_panel);
		getContentPane().add(panel);
		getContentPane().add(s_panel);
		try {
			// DB 연결
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "seo", "1234");
			state.setText("성공적연결");
			bt1 = new JButton("은행");
			bt1.setBounds(10, 168, 97, 23);
			getContentPane().add(bt1);
			bt2 = new JButton("은행지점");
			bt2.setBounds(10, 201, 97, 23);
			getContentPane().add(bt2);
			bt3 = new JButton("창구직원");
			bt3.setBounds(10, 234, 97, 23);
			getContentPane().add(bt3);
			bt4 = new JButton("고객");
			bt4.setBounds(10, 267, 97, 23);
			getContentPane().add(bt4);
			bt5 = new JButton("계좌");
			bt5.setBounds(10, 300, 97, 23);
			getContentPane().add(bt5);
			bt6 = new JButton("대출");
			bt6.setBounds(10, 333, 97, 23);
			getContentPane().add(bt6);
			
			JButton btnNewButton = new JButton("New button");
			btnNewButton.setBounds(276, 428, 97, 23);
			getContentPane().add(btnNewButton);
			
			btnNewButton_1 = new JButton("관리");
			btnNewButton_1.setBounds(119, 168, 97, 23);
			getContentPane().add(btnNewButton_1);
			btnNewButton_1.setAction(action);
			
			button = new JButton("관리");
			button.setAction(action_6);
			button.setBounds(119, 201, 97, 23);
			getContentPane().add(button);
			
			button_1 = new JButton("관리");
			button_1.setAction(action_2);
			button_1.setBounds(119, 234, 97, 23);
			getContentPane().add(button_1);
			
			button_2 = new JButton("관리");
			button_2.setAction(action_3);
			button_2.setBounds(119, 267, 97, 23);
			getContentPane().add(button_2);
			
			button_3 = new JButton("관리");
			button_3.setAction(action_4);
			button_3.setBounds(119, 300, 97, 23);
			getContentPane().add(button_3);
			
			button_4 = new JButton("관리");
			button_4.setAction(action_5);
			button_4.setBounds(119, 333, 97, 23);
			getContentPane().add(button_4);
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent a) {
					new Bank_Manage();
				}
			});
			btnNewButton_1.addActionListener(this);
			
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent a) {
					new Staff();
				}
			});
			button_1.addActionListener(this);
			
			button_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent a) {
					new Customer();
				}
			});
			button_2.addActionListener(this);
			
			button_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent a) {
					new Account();
				}
			});
			button_3.addActionListener(this);
			
			button_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent a) {
					new Loan();
				}
			});
			button_4.addActionListener(this);
			
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent a) {
					new Bank_Branch();
				}
			});
			button.addActionListener(this);
			
			bt6.addActionListener(this);
			bt5.addActionListener(this);
			bt4.addActionListener(this);
			bt3.addActionListener(this);
			bt2.addActionListener(this);
			bt1.addActionListener(this);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			state.setText("DB 연결실패" + e.toString());
		} catch (SQLException e) {
			e.printStackTrace();
			state.setText("DB 연결실패" + e.toString());
		}

		setSize(859, 500);
		setVisible(true);
	}
///////////////////////// 버튼에 기능 추가용 ///////////////////////////
	@Override
	public void actionPerformed(ActionEvent a) {
		if(a.getSource() == bt1) {
			try {
				// Quary
				Statement stmt = conn.createStatement();
				ResultSet rset = stmt.executeQuery("select * from bank");
				
				while (rset.next()) {
					// row 값읽기
					for (int i = 1; i < 4; i++) {
						row[i - 1] = rset.getString(i);
					}
					System.out.println();
					// JTable에출력
					model.addRow(row);
				}
				state.setText("DB 읽기성공");
			} catch (SQLException e) {
				e.printStackTrace();
				state.setText("DB 읽기실패" + e.toString());
			}
		}
		else if(a.getSource() == bt2) {
			try {
				// Quary
				Statement sec = conn.createStatement();
				ResultSet rset2 = sec.executeQuery("select * from bank_branch");
				while (rset2.next()) {
					// row 값읽기
					for (int i = 1; i < 5; i++) {
						row[i - 1] = rset2.getString(i);
					}
					System.out.println();
					// JTable에출력
					model.addRow(row);
				}
				state.setText("DB 읽기성공");
			} catch (SQLException e) {
				e.printStackTrace();
				state.setText("DB 읽기실패" + e.toString());
			}
		}
		else if(a.getSource() == bt3) {
			try {
				// Quary
				Statement sec = conn.createStatement();
				ResultSet rset2 = sec.executeQuery("select * from staff");
				while (rset2.next()) {
					// row 값읽기
					for (int i = 1; i < 6; i++) {
						row[i - 1] = rset2.getString(i);
					}
					System.out.println();
					// JTable에출력
					model.addRow(row);
				}
				state.setText("DB 읽기성공");
			} catch (SQLException e) {
				e.printStackTrace();
				state.setText("DB 읽기실패" + e.toString());
			}
		}
		else if(a.getSource() == bt4) {
			try {
				// Quary
				Statement sec = conn.createStatement();
				ResultSet rset2 = sec.executeQuery("select * from customer");
				while (rset2.next()) {
					// row 값읽기
					for (int i = 1; i < 4; i++) {
						row[i - 1] = rset2.getString(i);
					}
					System.out.println();
					// JTable에출력
					model.addRow(row);
				}
				state.setText("DB 읽기성공");
			} catch (SQLException e) {
				e.printStackTrace();
				state.setText("DB 읽기실패" + e.toString());
			}
		}
		else if(a.getSource() == bt5) {
			try {
				// Quary
				Statement sec = conn.createStatement();
				ResultSet rset2 = sec.executeQuery("select * from account");
				while (rset2.next()) {
					// row 값읽기
					for (int i = 1; i < 5; i++) {
						row[i - 1] = rset2.getString(i);
					}
					System.out.println();
					// JTable에출력
					model.addRow(row);
				}
				state.setText("DB 읽기성공");
			} catch (SQLException e) {
				e.printStackTrace();
				state.setText("DB 읽기실패" + e.toString());
			}
		}
		else if(a.getSource() == bt6) {
			try {
				// Quary
				Statement sec = conn.createStatement();
				ResultSet rset2 = sec.executeQuery("select * from loan");
				while (rset2.next()) {
					// row 값읽기
					for (int i = 1; i < 4; i++) {
						row[i - 1] = rset2.getString(i);
					}
					System.out.println();
					// JTable에출력
					model.addRow(row);
				}
				state.setText("DB 읽기성공");
			} catch (SQLException e) {
				e.printStackTrace();
				state.setText("DB 읽기실패" + e.toString());
			}
		}
//		else if(a.getSource() == btnNewButton_1) {
//			new Bank_Manage();
//		}
//		
			
	}
	
	public static void main(String[] args) {
		new Bank_Title();
	}
	
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "관리");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
//			new Bank_Manage();
		}
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "관리");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "관리");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_3 extends AbstractAction {
		public SwingAction_3() {
			putValue(NAME, "관리");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_4 extends AbstractAction {
		public SwingAction_4() {
			putValue(NAME, "관리");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_5 extends AbstractAction {
		public SwingAction_5() {
			putValue(NAME, "관리");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_6 extends AbstractAction {
		public SwingAction_6() {
			putValue(NAME, "관리");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}