package Bank;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class Bank_Manage extends JFrame {
	//	private String colName[] = { "은행코드", "은행명", "주소","asd","asd"};
	//	private DefaultTableModel model = new DefaultTableModel(colName,0);
	//	private JTable table = new JTable(model);
	//	JScrollPane scrollPane = new JScrollPane(table);
	private JLabel state;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();
	private final Action action_2 = new SwingAction_2();

	Connection conn = null;
	Statement stmt = null;
	String table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bank_Manage frame = new Bank_Manage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		new Bank_Manage();
	}

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
///////////////////////// 관리 창 생성 ///////////////////////////
	public Bank_Manage() {
		DBconnect();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 375, 315);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(127, 52, 220, 21);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(127, 96, 220, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(127, 148, 220, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel = new JLabel("은행코드");
		lblNewLabel.setBounds(12, 55, 57, 15);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("은행이름");
		lblNewLabel_1.setBounds(12, 99, 57, 15);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("은행 주소");
		lblNewLabel_2.setBounds(12, 151, 57, 15);
		contentPane.add(lblNewLabel_2);

		JLabel label = new JLabel("광주은행 관리 프로그램");
		label.setBounds(103, 10, 159, 15);
		contentPane.add(label);

		JButton btnNewButton = new JButton("삽입");
		btnNewButton.setBounds(12, 249, 97, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Insert();
			}
		});
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("수정");
		btnNewButton_1.setAction(action_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Update();
			}
		});
		btnNewButton_1.setBounds(127, 249, 97, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("삭제");
		btnNewButton_2.setAction(action_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Delete();
			}
		});
		btnNewButton_2.setBounds(250, 249, 97, 23);
		contentPane.add(btnNewButton_2);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "삽입");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "수정");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private class SwingAction_2 extends AbstractAction {
		public SwingAction_2() {
			putValue(NAME, "삭제");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}

	public void Insert() {  //삽입문 
		try {
			Statement stmt = conn.createStatement();
			String SQL = "INSERT INTO BANK "  +  " VALUES('" + textField.getText() + "','" + textField_1.getText() + "', '" + textField_2.getText() + "')";
			stmt.executeUpdate(SQL);
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void Update() {	//수정 오류
		try {
			Statement stmt = conn.createStatement();
			String SQL = "update bank set b_code = '" + textField.getText() + "' where bname = '" + textField_1.getText() +"'"
					+  "and b_address = '" + textField_2.getText() + "'";
			stmt.executeUpdate(SQL);
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public void Delete() {  //은행코드만 입력해야지 삭제됨.
		try {
			Statement stmt = conn.createStatement();
			String SQL = "delete from bank where b_code = '" + textField.getText() + "'";

			stmt.executeUpdate(SQL);
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
