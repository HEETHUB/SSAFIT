package com.ssafy.board.model.dao;

import java.util.*;

import com.ssafy.board.model.dto.Review;

public interface ReviewDao {
	// videoId에 해당하는 영상에 등록된 리뷰 전부 가져오기
	public List<Review> selectAll(int videoId);
	
	// reviewId에 해당하는 리뷰 하나 가져오기
	public Review selectOne(int reviewId);
	
	// 리뷰 등록
	public void insertReview(Review review);
	
	// 리뷰 삭제
	public void deleteReview(int reviewId);
	
	// 리뷰 수정
	public void updateReview(Review review);
	
	// 리뷰 조회수 증가
	public void updateViewCnt(int reviewId);
}
