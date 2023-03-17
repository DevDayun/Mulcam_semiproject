package a.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import a.dao.impl.FreePostDaoImpl;
import a.dto.FreePostDto;
import a.util.PdsUtil;
import a.dto.BbsImgVO;
import a.dto.BbsParam;
import a.dto.FpdImgDto;

@Service
public class FreePostServiceImpl {

    @Autowired
    private FreePostDaoImpl freePostDAO;

    public List<FreePostDto> bbslist(BbsParam param) {
        return freePostDAO.bbslist(param);
    }

    public int getAllBbs(BbsParam param) {
        return freePostDAO.getAllBbs(param);
    }
    

	// 사진이 없다면.
	public boolean writeBbs(FreePostDto dto) {
		int n = freePostDAO.writeBbs(dto);
		return n>0?true:false;
	}
	
    
    /*
	public boolean writeImg(List<BbsImgVO> bbsImglist) {
		int n = freePostDAO.writeImg(bbsImglist);
		return n>0?true:false;
	}
	*/
    
	// 사진이 있다면.
	public boolean writeBbs(FreePostDto dto, List<BbsImgVO> bbsImglist) {
		int n = freePostDAO.writeBbs(dto, bbsImglist);
		return n>0?true:false;
	}

    // 게시물 번호에 해당하는 게시물과 첫번째 이미지 정보 가져오기
    public String getFreePost(int bbs_seq) {
        return freePostDAO.getFreePostFirstImage(bbs_seq);
    }


    // 게시물 상세보기
    public FpdImgDto getBbs(int bbs_seq) {
        return freePostDAO.getBbs(bbs_seq);
    }



    // 게시물 수정하기
    public void updateFreePost(FreePostDto freePost) {
    	freePostDAO.updateFreePost(freePost);
    }

    // 게시물 삭제하기
    public void deleteFreePost(int postId) {
    	freePostDAO.deleteFreePost(postId);
    }

    // 게시물의 첫 번째 이미지 경로 가져오기
    public String getFreePostFirstImagePath(int postId) {
        return freePostDAO.getFreePostFirstImage(postId);
    }












}