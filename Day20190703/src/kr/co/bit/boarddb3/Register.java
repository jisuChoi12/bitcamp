package kr.co.bit.boarddb3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Register extends Board{
	private String nalnal;
	private Calendar calendar;
	private SimpleDateFormat sdf;
	private Date date;

	static {
		br = new BufferedReader(new InputStreamReader(System.in));
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Register(){
		nalnal=null;
	}
	
	public Connection getConnection() throws SQLException{
		conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "bitadmin", "dkdlxl");
		if(conn==null) {
			System.out.println("데이터베이스 연결 실패");
		} else {
			System.out.println("데이터베이스 연결 성공");
		}
		return conn;
	}
	
	public void setNo() throws IOException {
		System.out.println("====등록====");
		System.out.println("게시글 번호 입력");
		no = Integer.parseInt(br.readLine());
	}
	
	public void setTitleContent() throws IOException {
		System.out.println("제목|내용");
		titleContent = br.readLine();
	} 

	public void boardSqlRegister() {
		sql = "INSERT INTO BOARD(NO,TITLE,CONTENT,AUTHOR,NAL,READCOUNT) VALUES(?,?,?,?,?,?)"; 
	}
	
	public String setNal() {
		calendar = Calendar.getInstance();
		date = calendar.getTime();
		sdf = new SimpleDateFormat("yyy:MM:dd");
		return sdf.format(date);
	}

	public void boardSqlExecuter() throws SQLException{
		pstmt = conn.prepareStatement(sql); 
		pstmt.setInt(1,no);
		pstmt.setString(2, title);
		pstmt.setString(3, content);
		pstmt.setString(4, "최지수");
		nalnal = setNal();
		pstmt.setString(5, nalnal);
		pstmt.setInt(6, 0);
		cnt = pstmt.executeUpdate(); 
		System.out.println(cnt+"건의 게시글이 등록되었습니다.");
	}
	
	public void registerProcess() throws SQLException,IOException {
		getConnection();
		setNo();
		setTitleContent();
		titleContentProcess();
		boardSqlRegister();
		boardSqlExecuter();	
		closeAll();
	}
}
