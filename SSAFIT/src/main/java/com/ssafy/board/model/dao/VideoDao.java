package com.ssafy.board.model.dao;

import java.util.*;

import com.ssafy.board.model.dto.Video;

public interface VideoDao {
	// 전체 영상 가져오기
	public List<Video> selectAll();
	
	// videoId에 해당하는 영상 하나 가져오기
	public Video selectOne(int videoId);

	// 해당 운동부위에 해당하는 영상 전체 가져오기
	public List<Video> selectPart(String part);
}
