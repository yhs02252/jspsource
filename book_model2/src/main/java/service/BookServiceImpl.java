package service;

import java.util.List;

import dao.BookDAO;
import dto.BookDTO;

public class BookServiceImpl implements BookService {
	
	private BookDAO dao = new BookDAO(); 

	@Override
	public List<BookDTO> list(String keyword) {
		return dao.getList(keyword);
	}

	@Override
	public BookDTO read(int code) {
		// TODO Auto-generated method stub
		return dao.getRow(code);
	}

	@Override
	public boolean update(BookDTO updateDto) {
		// TODO Auto-generated method stub
		return dao.update(updateDto)==1?true:false;
	}

	@Override
	public boolean insert(BookDTO insertDto) {
		// TODO Auto-generated method stub
		return dao.insert(insertDto)==1?true:false;
	}

	@Override
	public boolean delete(int code) {
		// TODO Auto-generated method stub
		return dao.delete(code)==1?true:false;
	}

}
