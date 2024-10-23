package service;

import java.util.List;

import dao.BoardDAO;
import dto.BoardDTO;
import dto.SearchDTO;

public class BoardServiceImpl implements BoardService {
	
	private BoardDAO dao = new BoardDAO();

	@Override
	public List<BoardDTO> listAll(SearchDTO searchDTO) {
		// TODO Auto-generated method stub
		return dao.getList(searchDTO);
	}

	@Override
	public BoardDTO getRow(int bno) {
		// TODO Auto-generated method stub
		return dao.read(bno);
	}

	@Override
	public boolean update(BoardDTO updateDto) {
		// TODO Auto-generated method stub
		return dao.update(updateDto)==1?true:false;
	}

	@Override
	public boolean delete(BoardDTO deleteDto) {
		// TODO Auto-generated method stub
		return dao.delete(deleteDto)==1?true:false;
	}

	@Override
	public boolean create(BoardDTO insertDto) {
		// TODO Auto-generated method stub
		return dao.create(insertDto)==1?true:false;
	}

	@Override
	public boolean cntUp(int bno) {
		// TODO Auto-generated method stub
		return dao.readCntUp(bno)==1?true:false;
	}

	@Override
	public boolean reply(BoardDTO replyDto) {
		// TODO Auto-generated method stub
		return dao.reply(replyDto)==1?true:false;
	}

	@Override
	public int totalNum() {
		// TODO Auto-generated method stub
		return dao.totalRows();
	}

	
}
