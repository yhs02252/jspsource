package service;

import java.util.List;

import dto.BoardDTO;
import dto.SearchDTO;

// CRUD 호출

public interface BoardService {
	
	public List<BoardDTO> listAll(SearchDTO searchDTO);
	
	public BoardDTO getRow(int bno);
	
	public boolean update(BoardDTO updateDto);
	
	public boolean delete(BoardDTO deleteDto);
	
	public boolean create(BoardDTO insertDto);
	
	public boolean cntUp(int bno);
	
	public boolean reply(BoardDTO replyDto);
	
	public int totalNum();
}
