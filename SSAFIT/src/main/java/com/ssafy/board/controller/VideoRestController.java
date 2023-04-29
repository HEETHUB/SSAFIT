 package com.ssafy.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.model.dto.Video;
import com.ssafy.board.model.dto.SearchCondition;
import com.ssafy.board.model.service.VideoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("api/video")
@Api(tags = "비디오 컨트롤러")
@CrossOrigin("*")
public class VideoRestController {
	
	@Autowired
	private VideoService videoService;
	
	//1. 영상 목록 가져오기
	@ApiOperation(value="영상 조회", notes = "검색 조건도 넣으면 같이 가져옴")
	@GetMapping("/board")
	public ResponseEntity<?> list(SearchCondition condition){
		List<Video> list = videoService.search(condition); 
		
		if(list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Video>>(list, HttpStatus.OK);
	}
	//2. 상세보기
	@GetMapping("/board/{id}")
	public ResponseEntity<Video> detail(@PathVariable int id){
		Video video = videoService.getVideo(id);
		//만약 사용자가 잘못 보냈다... 처리를 해라 board라고 하는게 null이면 무엇인가 처리를 해봐라잉
		return new ResponseEntity<Video>(video, HttpStatus.OK);
	}
	

}
