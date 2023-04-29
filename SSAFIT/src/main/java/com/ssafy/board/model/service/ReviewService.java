package com.ssafy.board.model.service;

import java.util.*;

import com.ssafy.board.model.dto.Review;

public interface ReviewService {
	// 해당 videoId에 등록된 모든 리뷰 조회 
	public List<Review> getReviews(int videoId);
	
	// 해당 reviewId로 등록된 리뷰 가져오기
	public Review getReview(int reviewId);
	
	// 리뷰 작성
	public void writeReview(Review review);
	
	// 리뷰 삭제
	public void removeReview(int reviewId);
	
	// 리뷰 수정
	public void modifyReview(Review review);
}
