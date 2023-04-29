package com.ssafy.board.model.dto;

public class Video {
	private int videoId;
	private String channelName;
	private String title;
	private String url;
	private String videoImg;
	private int viewCnt;
	private String part;
	
	public Video() {}

	public Video(int videoId, String channelName, String title, String url, String videoImg, int viewCnt, String part) {
		this.videoId = videoId;
		this.channelName = channelName;
		this.title = title;
		this.url = url;
		this.videoImg = videoImg;
		this.viewCnt = viewCnt;
		this.part = part;
	}

	public int getVideoId() {
		return videoId;
	}

	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getVideoImg() {
		return videoImg;
	}

	public void setVideoImg(String videoImg) {
		this.videoImg = videoImg;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}
}
