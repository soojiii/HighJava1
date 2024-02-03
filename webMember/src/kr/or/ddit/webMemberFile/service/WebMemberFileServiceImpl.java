package kr.or.ddit.webMemberFile.service;

import java.util.List;

import kr.or.ddit.webMember.vo.FileInfoVO;
import kr.or.ddit.webMemberFile.dao.IWebMemberFileDao;
import kr.or.ddit.webMemberFile.dao.WebMemberFileDaoImpl;

public class WebMemberFileServiceImpl implements IWebMemberFileService {
	
	private IWebMemberFileDao dao;
	
	private static WebMemberFileServiceImpl service;
	
	private WebMemberFileServiceImpl() {
		dao = WebMemberFileDaoImpl.getInstance();
	}
	
	public static WebMemberFileServiceImpl getInstance() {
		if(service==null) service = new WebMemberFileServiceImpl();
		return service;
	}
	
	
	@Override
	public int insertFileinfo(FileInfoVO fVo) {
		return dao.insertFileinfo(fVo);
	}

	@Override
	public List<FileInfoVO> getAllFileinfo() {
		return dao.getAllFileinfo();
	}

	@Override
	public FileInfoVO getFileinfo(int fileNo) {
		return dao.getFileinfo(fileNo);
	}

}
