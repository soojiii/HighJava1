package kr.or.ddit.webMemberFile.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.webMember.util.MybatisUtil;
import kr.or.ddit.webMember.vo.FileInfoVO;

public class WebMemberFileDaoImpl implements IWebMemberFileDao {

	private static WebMemberFileDaoImpl dao;
	
	private WebMemberFileDaoImpl() { }
	
	public static WebMemberFileDaoImpl getInstance() {
		if(dao==null) dao = new WebMemberFileDaoImpl();
		return dao;
	}
	
	@Override
	public int insertFileinfo(FileInfoVO fileVo) {
		int cnt = 0;
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			cnt = session.insert("fileinfo.insertFileinfo", fileVo);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(cnt>0) session.commit();
			if(session!=null) session.close();
		}
		
		return cnt;
	}

	@Override
	public List<FileInfoVO> getAllFileinfo() {
		List<FileInfoVO> fileList = null;   
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			fileList = session.selectList("fileinfo.getAllFileinfo");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
		
		return fileList;
	}

	@Override
	public FileInfoVO getFileinfo(int fileNo) {
		FileInfoVO fileVo = null;  
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			fileVo = session.selectOne("fileinfo.getFileinfo", fileNo);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null) session.close();
		}
		
		return fileVo;
	}

}
