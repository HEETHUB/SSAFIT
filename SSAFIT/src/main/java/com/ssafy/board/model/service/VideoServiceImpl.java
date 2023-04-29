package com.ssafy.board.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ssafy.board.model.dao.VideoDao;
import com.ssafy.board.model.dto.SearchCondition;
import com.ssafy.board.model.dto.Video;

public class VideoServiceImpl implements VideoService {
	
	@Autowired
	private VideoDao videoDao;
	
	@Override
	public List<Video> getVideoList() {
		System.out.println("모든 영상을 가져왔습니다.");
		return videoDao.selectAll();
	}

	@Override
	public List<Video> getVideoList(String part) {
		System.out.println(part+"부위에 해당하는 영상들을 가져왔습니다.");
		return videoDao.selectPart(part);
	}

	@Override
	public List<Video> search(SearchCondition condition) {
		System.out.println("검색 조건에 맞는 영상들을 검색합니다.");
		return videoDao.search(condition);
	}

	@Override
	public Video getVideo(int videoId) {
		System.out.println(videoId+"에 해당하는 영상을 가져옵니다.");
		return videoDao.selectOne(videoId);
	}

}
