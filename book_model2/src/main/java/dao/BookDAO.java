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

import dto.BookDTO;

public class BookDAO {
	
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
//	static {
//		// 드라이버 로드
//		try {
//			Class.forName("oracle.jdbc.OracleDriver");		
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}		
//	}
//	
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
	
	// CRUD 메소드
	
	// R(Read) - 전체조회, 특정(pk) 조회, 제목 조회
	// 조회 메소드 작성하기
	// 리턴 타입 : List<~~~DTO> or ~~~DTO 
	// List<~~~DTO> : where 절 없는 경우, where 절이 pk 가 아니면
	// ~~~DTO : where 절이 pk 인 경우
	
	public List<BookDTO> getList(){
		List<BookDTO> list = new ArrayList<BookDTO>();
		
		try {
			con = getConnection();
			
			String sql = "SELECT * FROM BOOKTBL";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				BookDTO dto = new BookDTO();
				dto.setCode(rs.getInt("code"));
				dto.setTitle(rs.getString("title"));
				dto.setWriter(rs.getString("writer"));
				dto.setPrice(rs.getInt("price"));
				
				list.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return list;
	}
	
	
	// 전달인자 : ()에 무엇이 들어와야 하는가
	// 		=>	sql 구문의 ? 부분을 보고 결정
	public BookDTO getRow(int code) {
		
		BookDTO dto = null;
		try {
			con = getConnection();
			
			String sql = "SELECT  * FROM BOOKTBL WHERE code = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, code);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto = new BookDTO();				
				dto.setCode(rs.getInt("code"));
				dto.setTitle(rs.getString("title"));
				dto.setWriter(rs.getString("writer"));
				dto.setPrice(rs.getInt("price"));
				dto.setDescription(rs.getString("description"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return dto;
	}
	
	
//	// 특정 제목의 책 조회
//	public BookDTO getBook(String title) {
//		BookDTO dto = null;
//		
//		try {
//			con = getConnection();
//			
//			String sql = "SELECT * FROM BOOKTBL WHERE title LIKE '%?%'";
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, title);
//			rs = pstmt.executeQuery();
//			
//			if(rs.next()) {
//				dto = new BookDTO();				
//				dto.setCode(rs.getInt("code"));
//				dto.setTitle(rs.getString("title"));
//				dto.setWriter(rs.getString("writer"));
//				dto.setPrice(rs.getInt("price"));
//				
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			close(con, pstmt, rs);
//		}
//		return dto;
//	}
	
	
	// update - 수정
	public int update(BookDTO updateDto) {
		
		int updateRow = 0;
		
		try {
			con=getConnection();
			String sql="UPDATE BOOKTBL SET PRICE = ?, DESCRIPTION= ? WHERE code = ?";
			pstmt=con.prepareStatement(sql); 
			pstmt.setInt(1, updateDto.getPrice());
			pstmt.setString(2, updateDto.getDescription());;
			pstmt.setInt(3, updateDto.getCode());
			
			updateRow = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt);
		}				return updateRow;		
	}
	
	// delete - 삭제
	
	public int delete(int code) {

		int deleteRow = 0;
		
        try {
            con = getConnection();

            String sql = "DELETE FROM BOOKTBL WHERE code = ?";

            pstmt = con.prepareStatement(sql);
     
            pstmt.setInt(1, code);
            
            deleteRow = pstmt.executeUpdate();

          

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(con, pstmt);
        }
        return deleteRow;
    }
	
	
	public int insert(BookDTO insertDto) {
		
		int insertRow = 0;
		
		try {
			con = getConnection();
			
			String sql = "INSERT INTO BOOKTBL(code, title, writer, price, description) values(?,?,?,?,?)";
			
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, insertDto.getCode());
			pstmt.setString(2, insertDto.getTitle());
			pstmt.setString(3, insertDto.getWriter());
			pstmt.setInt(4, insertDto.getPrice());
			pstmt.setString(5, insertDto.getDescription());
			
			insertRow = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con, pstmt);
		}
		
		return insertRow;
		
	}
	
	
}
	
	
	
