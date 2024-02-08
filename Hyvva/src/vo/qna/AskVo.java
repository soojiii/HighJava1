package vo.qna;

public class AskVo {
	
	// ASK 테이블
	private int ask_board_no;			//문의게시판 번호
	private String user_id;				//사용자아이디
	private String ask_board_title;		//문의게시판 제목
	private String ask_board_comment;	//문의게시판 내용
	private String ask_board_date;		//문의게시판 날짜
	
	// MEMBER 테이블 
	private String nick_name;			//닉네임
	
	public String getNick_name() {
		return nick_name;
	}
	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}
	public int getAsk_board_no() {
		return ask_board_no;
	}
	public void setAsk_board_no(int ask_board_no) {
		this.ask_board_no = ask_board_no;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getAsk_board_title() {
		return ask_board_title;
	}
	public void setAsk_board_title(String ask_board_title) {
		this.ask_board_title = ask_board_title;
	}
	public String getAsk_board_comment() {
		return ask_board_comment;
	}
	public void setAsk_board_comment(String ask_board_comment) {
		this.ask_board_comment = ask_board_comment;
	}
	public String getAsk_board_date() {
		return ask_board_date;
	}
	public void setAsk_board_date(String ask_board_date) {
		this.ask_board_date = ask_board_date;
	}
	
	
}
