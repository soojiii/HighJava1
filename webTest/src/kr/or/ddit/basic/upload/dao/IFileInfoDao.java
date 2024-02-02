package kr.or.ddit.basic.upload.dao;

import java.util.List;

import kr.or.ddit.basic.upload.vo.FileInfoVO;

public interface IFileInfoDao {
	
	/**
	 * 
	 * @param FileVO
	 * @return
	 */
	public int insertFileinfo(FileInfoVO FileVo);
	
	/**
	 * 
	 * @return
	 */
	public List<FileInfoVO> getAllFileinfo();
	
	/**
	 * fileNo를 매개변수로 받아서 해당 파일 정보를 검색하여 찾은 파일 정보를 반환하는 메서드
	 * @param fileNo 검색할 파일 번호
	 * @return 검색된 데이터가 저장된 FileInfoVO객체
	 */
	public FileInfoVO getFileinfo(int fileNo);
	
	
}
