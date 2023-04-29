package com.ssafy.board.model.service;

import java.util.*;

import com.ssafy.board.model.dto.SearchCondition;
import com.ssafy.board.model.dto.Video;

public interface VideoService {
	// 영상 전체 조회
	public List<Video> getVideoList();
	
	// 운동 부위별 영상 조회 
	public List<Video> getVideoList(String part);
	
	// videoId에 해당하는 영상 검색
	public Video getVideo(int videoId);
	
	// 검색 기능 
	public List<Video> search(SearchCondition condition); 
}
