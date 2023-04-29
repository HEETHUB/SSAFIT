package com.ssafy.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.model.dto.Review;
import com.ssafy.board.model.service.ReviewService;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("api/review")
@Api(tags = "리뷰 컨트롤러")
@CrossOrigin("*")
public class ReviewRestController {
	
	@Autowired
	private ReviewService reviewService;
	
	// 1. 리뷰 등록
	@PostMapping("/review")
	public ResponseEntity<Review> write(Review review){
		reviewService.writeReview(review);
		return new ResponseEntity<Review>(review, HttpStatus.CREATED);
	}
	
	// 2. 리뷰 삭제
	@DeleteMapping("/review/{id}")
	public ResponseEntity<Void> delete(@PathVariable int id){
		reviewService.removeReview(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	// 5. 리뷰 수정
	@ApiIgnore
	@PutMapping("/review") //JSON형태의 데이터로 요청을 보내보자
	public ResponseEntity<Void> update(@RequestBody Review review){
		reviewService.modifyReview(review);
		//얘도 마찬가지 이죠 옥헤이?
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
