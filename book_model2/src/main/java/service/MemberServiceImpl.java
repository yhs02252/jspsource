package service;

import dao.MemberDAO;
import dto.ChangeDTO;
import dto.MemberDTO;

public class MemberServiceImpl implements MemberService {
	
	private MemberDAO dao = new MemberDAO();

	@Override
	public MemberDTO login(MemberDTO dto) {
		// TODO Auto-generated method stub
		return dao.islogin(dto);
	}

	@Override
	public boolean join(MemberDTO dto) {
		// TODO Auto-generated method stub
		return dao.insert(dto)==1?true:false;
	}

	@Override
	public boolean duplicatedId(String userid) {
		// TODO Auto-generated method stub
		return dao.dupId(userid);
	}

	@Override
	public boolean changePassword(ChangeDTO changeDto) {
		return dao.update(changeDto)==1?true:false;
	}

}
