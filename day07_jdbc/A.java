package day07;

import java.sql.*;

class A {
	Connection con;
	Statement stmt;

    String url = "jdbc:oracle:thin:@127.0.0.1:1521:JAVA";
	String usr = "JDBC";
	String pwd = "JAVA";
	A(){
		//(1) ����̹� �ε� 
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("(1) ����̹� �ε� ����");
		}catch(ClassNotFoundException cnfe){
			System.out.println("����̹� �ε� ����");
		}
		//(2) DB�� ���� 
		try{
			con = DriverManager.getConnection(url, usr, pwd);
			System.out.println("(2) DB�� ���� ����");
		}catch(SQLException se){
			System.out.println("DB�� ���� ����");
		}
		//(3) Statement ���� 
		try {
			stmt = con.createStatement();
			System.out.println("(3) stmt�� ���� ����");
		}catch(SQLException se) {
			System.out.println("(3) stmt�� ���� ����");
		}
		
		//createT();
		//dropT();
		createTnoExist();
		
		//insertD(10, "ȫ�浿", "01012341234");
		//insertD(20, "������", "01012341235");
		//insertD(30, "�̼���", "01012341236");
		
		//updateD(20, "�ڰ���", "11122223333");
		
		deleteD(30);
	}
	
	String tname = "JDBCT";
	void createT() {
		String sql = "create table "+tname
				+"(NO number(2) primary key, NAME varchar2(10), PHONE varchar2(11), RDATE date)";
		//(4) Statement ����
		try {
			stmt.execute(sql);
			System.out.println("(4) "+tname+"���̺� ���� ����");
		}catch(SQLException se) {
			System.out.println("(4) "+tname+"���̺� ���� ���� se:"+se);
		}
	}
    void dropT() {
    	String sql = "drop table "+tname;
    	//(4) Statement ����
		try {
			stmt.execute(sql);
			System.out.println("(4) "+tname+"���̺� ���� ����");
		}catch(SQLException se) {
			System.out.println("(4) "+tname+"���̺� ���� ����");
		}
    }
    void createTnoExist() {
    	ResultSet rs = null;
    	String sql = "select TABLE_NAME from user_tables where TABLE_NAME='"+tname+"'";
    	//(4) Statement ����
    	try {
    		rs = stmt.executeQuery(sql);
    		boolean flag = rs.next();
    		if(!flag) createT();
    	}catch(SQLException se) {
    	}finally {
    		try {
    			rs.close();
    		}catch(SQLException se) {}
    	}
    }
    void insertD(int no, String name, String phone) {
    	String sql = "insert into "+tname+" values("+no+", '"+name+"', '"+phone+"', SYSDATE)";
    	//(4) Statement ����
    	try {
    		int i = stmt.executeUpdate(sql);
    		if(i>0) System.out.println(i+"���� ���� �Է� �Ϸ�");
    		else System.out.println("�Է� ����");
    	}catch(SQLException se) {
    		System.out.println("�Է� ���� se:"+ se);
    	}
    }
    void updateD(int no, String name, String phone) {
    	String sql = "update "+tname+" set name='"+name+"', phone='"+phone+"' where NO="+no;
    	//(4) Statement ����
    	try {
    		int i = stmt.executeUpdate(sql);
    		if(i>0) System.out.println(i+"���� ���� ���� �Ϸ�");
    		else System.out.println("���� ����");
    	}catch(SQLException se) {
    		System.out.println("���� ���� se:"+ se);
    	}
    }
    void deleteD(int no) {
    	String sql = "delete from "+tname+" where NO="+no;
    	//(4) Statement ����
    	try {
    		int i = stmt.executeUpdate(sql);
    		if(i>0) System.out.println(i+"���� ���� ���� �Ϸ�");
    		else System.out.println("���� ����");
    	}catch(SQLException se) {
    		System.out.println("���� ���� se:"+ se);
    	}
    }
    
	public static void main(String[] args) {
		A a = new A();
	}
}
