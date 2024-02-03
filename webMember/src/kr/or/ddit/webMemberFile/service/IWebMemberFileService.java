package kr.or.ddit.webMemberFile.service;

import java.util.List;

import kr.or.ddit.webMember.vo.FileInfoVO;

public interface IWebMemberFileService {
	public int insertFileinfo(FileInfoVO fVo);
	
	public List<FileInfoVO> getAllFileinfo();
	
	public FileInfoVO getFileinfo(int fileNo);
}
