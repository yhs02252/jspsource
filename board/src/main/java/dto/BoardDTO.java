package dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
// @Data == @Getter @Setter @EqualsAndHashCode @toString @NoArgsConstructor
import lombok.NoArgsConstructor;


@Data@NoArgsConstructor@AllArgsConstructor
public class BoardDTO {

	private int bno;
	private String name;
	private String password;
	private String title;
	private String content;
	private String attach;
	private int reRef;
	private int reLev;
	private int reSeq;
	private int readcnt;
	private Date regdate;
}
