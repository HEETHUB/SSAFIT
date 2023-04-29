package com.ssafy.board.model.dto;

public class Review {
	private int videoId;
	private int reviewId;
	private String title;
	private String writer;
	private String content;
	private int viewCnt;
	
	public Review() {}

	public Review(int videoId, String title, String writer, String content, int viewCnt) {
		this.videoId = videoId;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.viewCnt = viewCnt;
	}

	public int getVideoId() {
		return videoId;
	}

	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}
	
	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
}
