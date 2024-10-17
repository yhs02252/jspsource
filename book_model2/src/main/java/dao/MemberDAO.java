package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import dto.ChangeDTO;
import dto.MemberDTO;

// ~~~DAO : DB 서버와 연동해서 DB 작업 담당하는 클래스
// 1. 드라이버 로드
// 2. 커넥션(DB서버) 얻기
// 3. 커넥션을 통해 CRUD(insert, read, update, delete) 작업 실행

// Statement : SQL 의 DDL, DML 실행할 때 사용 (정적 SQL 문 실행 시 사용 - DELETE usertbl WHERE id=1)
//			   동적 SQL 구문 사용 시 SQL injection(DB 서버 공격)이 발생할 수 있음
// PreparedStatement : Statement 와 기능 동일 (주로 동적 SQL 문 실행 시 사용 - DELETE usertbl WHERE id=?)
// 					   ? 로 값을 넣기 때문에 편리성, 보안성이 좋다

// ResultSet : SELECT 결과가 담기는 객체

public class MemberDAO {
	
    private Connection con;
    private PreparedStatement pstmt;
    private ResultSet rs;

//	static {
//		try {
//			Class.forName("oracle.jdbc.OracleDriver");			
//		} catch (ClassNotFoundException e) {
//			 e.printStackTrace();
//		}
//	}
	
//	연결 문자열 => DriverManager
		public Connection getConnection(){
			Context initContext;
			try {
				initContext = new InitialContext();
				Context envContext  = (Context)initContext.lookup("java:/comp/env");
				DataSource ds = (DataSource)envContext.lookup("jdbc/oracle");
				con = ds.getConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return con;
		}
	
	// 자원해제
    public void close(Connection con, PreparedStatement pstmt) {
        try {
            if(pstmt!=null)pstmt.close();
            if(con!=null)con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
	public void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(con!=null)con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// CRUD 메소드 작성
	public MemberDTO islogin(MemberDTO dto) {
		
		MemberDTO loginDto = null;
		
		try {
			
			con=getConnection();
			String sql = "SELECT * FROM MEMBERTBL WHERE USERID=? AND PASSWORD=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, dto.getUserid());
			pstmt.setString(2, dto.getPassword());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				loginDto = new MemberDTO();
				loginDto.setUserid(rs.getString("userid"));
				loginDto.setName(rs.getString("name"));
				loginDto.setPassword(rs.getString("password"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		
		return loginDto;
		
	}
	
	public int insert(MemberDTO dto) {
		
		int insertRow = 0;
		
		try {
			con=getConnection();
			String sql="INSERT INTO MEMBERTBL(userid,name,password) values(?, ?, ?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, dto.getUserid());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getPassword());
			
			insertRow = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		
		return insertRow;
	}
	
	
	// 아이디 중복 판별
	public boolean dupId(String userid) {
		
		try {
			
			con=getConnection();
			String sql = "SELECT * FROM MEMBERTBL WHERE USERID=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		
		return true;
		
	}
	
	
	public int update(ChangeDTO dto) {
		int updateRow = 0;
		try {
			con= getConnection();
			
			String sql="UPDATE MEMBERTBL SET PASSWORD=? WHERE USERID=? AND PASSWORD=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, dto.getChangePassword());
			pstmt.setString(2, dto.getUserid());
			pstmt.setString(3, dto.getCurrentPassword());
			
			updateRow = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con, pstmt);
		}
		return updateRow;
	}
	
	
	
	
	
	
	
	
	
	
	
}
