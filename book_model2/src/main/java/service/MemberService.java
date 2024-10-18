package service;

import dto.ChangeDTO;
import dto.MemberDTO;

public interface MemberService {
	
	public MemberDTO login(MemberDTO dto);
	
	public boolean join(MemberDTO dto);
	
	public boolean duplicatedId(String userid);
	
	public boolean changePassword(ChangeDTO changeDto);
}
