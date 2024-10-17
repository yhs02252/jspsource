package service;

import dao.MemberDAO;
import dto.MemberDTO;

public class MemberServiceImpl implements MemberService {
	// ServiceImpl ==> DAO 호출 역할
	
	
	MemberDAO dao = new MemberDAO();

	@Override
	public int create(MemberDTO memberDto) {
		// TODO Auto-generated method stub
		return dao.create(memberDto);
	}

	@Override
	public MemberDTO read(MemberDTO memberDto) {
		// TODO Auto-generated method stub
		return dao.read(memberDto);
	}

	@Override
	public int update(MemberDTO memberDto) {
		// TODO Auto-generated method stub
		return dao.update(memberDto);
	}

	@Override
	public int delete(MemberDTO memberDto) {
		// TODO Auto-generated method stub
		return dao.delete(memberDto);
	}

}
