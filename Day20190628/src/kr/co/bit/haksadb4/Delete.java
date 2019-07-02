package kr.co.bit.haksadb4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Delete {
	private int protocol;
	private int cnt;
	private String irumDelete;
	private PreparedStatement pstmt;
	private String sql;
	private Connection conn;
	
	public Delete() {
		protocol=0; cnt=0;
		irumDelete=null; pstmt=null; sql=null;
	}
	
	public void deleteProcess() {
		System.out.println("========����=========");
		System.out.println("1.�л����� 2.�������� 3.�����ڻ���");
		protocol = Register.input.nextInt();
		System.out.println("�̸�");
		irumDelete = Register.input.next();
		if(protocol==1) {//�л�����
			try {
				conn = Register.getConnection();
				sql = "DELETE FROM STUDENT WHERE IRUM=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, irumDelete);
				cnt = pstmt.executeUpdate();
				if(cnt==0) {
					System.out.println("��������");
				}else {
					System.out.println(cnt+ "�� ���� �Ϸ�");
					pstmt.close();
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}//�л�����
		else if(protocol==2) {//��������
			try {
				conn = Register.getConnection();
				sql = "DELETE FROM PROFESSOR WHERE IRUM=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, irumDelete);
				cnt = pstmt.executeUpdate();
				if(cnt==0) {
					System.out.println("��������");
				}else {
					System.out.println(cnt+ "�� ���� �Ϸ�");
					pstmt.close();
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}//��������
		else if(protocol==3) {//�����ڻ���
			try {
				conn = Register.getConnection();
				sql = "DELETE FROM MANAGER WHERE IRUM=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, irumDelete);
				cnt = pstmt.executeUpdate();
				if(cnt==0) {
					System.out.println("��������");
				}else {
					System.out.println(cnt+ "�� ���� �Ϸ�");
					pstmt.close();
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}//�����ڻ���
	}
}