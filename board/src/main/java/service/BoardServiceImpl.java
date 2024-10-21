package service;

import java.util.List;

import dao.BoardDAO;
import dto.BoardDTO;

public class BoardServiceImpl implements BoardService {
	
	private BoardDAO dao = new BoardDAO();

	@Override
	public List<BoardDTO> listAll() {
		// TODO Auto-generated method stub
		return dao.getList();
	}

	@Override
	public BoardDTO getRow(int bno) {
		// TODO Auto-generated method stub
		return dao.read(bno);
	}

	@Override
	public Boolean update(BoardDTO updateDto) {
		// TODO Auto-generated method stub
		return dao.update(updateDto)==1?true:false;
	}

	@Override
	public Boolean delete(int bno) {
		// TODO Auto-generated method stub
		return dao.delete(bno)==1?true:false;
	}

	@Override
	public Boolean create(BoardDTO insertDto) {
		// TODO Auto-generated method stub
		return dao.create(insertDto)==1?true:false;
	}

}
