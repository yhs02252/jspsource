package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.BoardDTO;

public class BoardDAO {

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
	
	
	public List<BoardDTO> getList(){
		
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		
		try {
			
			con = getConnection();
			
			String sql = "SELECT BNO,NAME,TITLE,READCNT,REGDATE FROM BOARD ORDER BY BNO ASC";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setBno(rs.getInt("bno"));
				dto.setName(rs.getString("name"));
				dto.setTitle(rs.getString("title"));
				dto.setReadcnt(rs.getInt("readcnt"));
				dto.setRegdate(rs.getDate("regdate"));		
				
				list.add(dto);
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con, pstmt, rs);
		}
		return list;
	}
	
	public BoardDTO read(int bno) {
		
		BoardDTO dto = null;
		try {
			
			con = getConnection();
			
			String sql = "SELECT * FROM BOARD WHERE BNO = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				dto = new BoardDTO();
				dto.setBno(rs.getInt("bno"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setAttach(rs.getString("attach"));
				dto.setName(rs.getString("name"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con, pstmt, rs);
		}
		return dto;
	}
	
	
//	public Boolean update(BoardDTO updateDto) {
	public int update(BoardDTO updateDto) {
		
		int updateRow = 0;
		
		try {
			
			con = getConnection();
			String sql = "UPDATE BOARD SET TITLE = ?, CONTENT = ? WHERE BNO = ? AND PASSWORD = ?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, updateDto.getTitle());
			pstmt.setString(2, updateDto.getContent());
			pstmt.setInt(3, updateDto.getBno());
			pstmt.setString(4, updateDto.getPassword());
			
			updateRow=pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con, pstmt);
		}
		
		return updateRow;
		
	}
	
	public int delete(int bno) {
		
		int deleteRow
		
		try {
			
			con = getConnection();
			String sql = ""
			pstmt=con.prepareStatement(sql);
			pstmt.setString(0, sql);
			
			if () {
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con, pstmt);
		}
		
		return ;
		
	}
	
	public int create(BoardDTO updateDto) {
		
		Boolean 
		
		try {
			
			con = getConnection();
			String sql = ""
			pstmt=con.prepareStatement(sql);
			pstmt.setString(0, sql);
			
			if () {
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(con, pstmt);
		}
		
		return ;
		
	}
	
	
}
