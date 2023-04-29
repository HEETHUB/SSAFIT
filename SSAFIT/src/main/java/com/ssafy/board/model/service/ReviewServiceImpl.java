package com.ssafy.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ssafy.board.model.dao.ReviewDao;
import com.ssafy.board.model.dto.Review;

public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
	private ReviewDao reviewDao;
	
	@Override
	public List<Review> getReviews(int videoId) {
		System.out.println(videoId+"에 등록된 리뷰들을 가져옵니다.");
		return reviewDao.selectAll(videoId);
	}

	@Override
	public Review getReview(int reviewId) {
		System.out.println(reviewId+"에 해당하는 리뷰를 가져옵니다.");
		return reviewDao.selectOne(reviewId);
	}

	@Override
	public void writeReview(Review review) {
		System.out.println("새로운 리뷰를 작성합니다.");
		reviewDao.insertReview(review);
	}

	@Override
	public void removeReview(int reviewId) {
		System.out.println(reviewId+"에 해당하는 리뷰를 삭제합니다.");
		reviewDao.deleteReview(reviewId);
	}

	@Override
	public void modifyReview(Review review) {
		System.out.println(review.getReviewId()+"에 해당하는 리뷰를 수정합니다.");
		reviewDao.updateReview(review);
	}

}
