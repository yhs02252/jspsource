package service;

import java.util.List;

import dto.BoardDTO;

// CRUD 호출

public interface BoardService {
	
	public List<BoardDTO> listAll();
	
	public BoardDTO getRow(int bno);
	
	public Boolean update(BoardDTO updateDto);
	
	public Boolean delete(int bno);
	
	public Boolean create(BoardDTO insertDto);
}