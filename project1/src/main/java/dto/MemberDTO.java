package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString
public class MemberDTO {
	// membertbl 필드랑 일치
	
	private String userid;
	private String name;
	private String password;
	private int age;
	private String email;
	
	// 기본생성자, 인자를 모두 받는 생성자
	// getter, setter, tostring
}
