package kr.co.bit.boarddb2;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Search {
	private int no;
	private int readcount;
	private String titleSearch;
	private String sql;
	private String title;
	private String content;
	private String author;
	private PreparedStatement pstmt;
	private String nal;
	private ResultSet rs;
	
	public Search() {
		no=0; readcount=0;
		titleSearch=null; sql=null; title=null; content=null; author=null; pstmt=null; nal=null; rs=null;
	}
	
	public void setTitleSearch() throws IOException {
		System.out.println("====검색====");
		System.out.println("찾는 게시글 제목 입력");
		titleSearch = Register.br.readLine();		
		System.out.print("번호\t제목\t내용\t작성자\t날짜\t\t조회수\n");
	}
	
	public void boardSqlSearch() {
		sql = "SELECT NO,TITLE,CONTENT,AUTHOR,NAL,READCOUNT FROM BOARD WHERE TITLE=?";		
	}
	
	public void SearchExecuter() throws SQLException {
		pstmt = Register.conn.prepareStatement(sql);
		pstmt.setString(1, titleSearch);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			no = rs.getInt("no");
			title = rs.getString("title");
			content = rs.getString("content");
			author = rs.getString("author");
			nal = rs.getString("nal");
			readcount = rs.getInt("readcount");
			System.out.println(no+"\t"+title+"\t"+content+"\t"+author+"\t"+nal+"\t"+readcount+"\n");
		}		
	}
	
	public void searchProcess() throws SQLException,IOException {
		setTitleSearch();
		boardSqlSearch();
		SearchExecuter();
		pstmt.close();
		Register.conn.close();	
	}
}
