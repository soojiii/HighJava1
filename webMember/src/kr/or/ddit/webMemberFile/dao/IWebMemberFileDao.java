package kr.or.ddit.webMemberFile.dao;

import java.util.List;

import kr.or.ddit.webMember.vo.FileInfoVO;

public interface IWebMemberFileDao {
	
	public int insertFileinfo(FileInfoVO fileVo);
	
	public List<FileInfoVO> getAllFileinfo();
	
	public FileInfoVO getFileinfo(int fileNo);
	
}
