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

import com.ssafy.board.model.dto.Board;
import com.ssafy.board.model.dto.SearchCondition;
import com.ssafy.board.model.service.BoardService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/api")
@Api(tags = "게시판 컨트롤러")
@CrossOrigin("*")
public class BoardRestController {
	
	@Autowired
	private BoardService boardService;
	
	//1. 목록을 가져와보자~
	@ApiOperation(value="게시글 조회", notes = "검색 조건도 넣으면 같이 가져옴")
	@GetMapping("/board")
	public ResponseEntity<?> list(SearchCondition condition){
//		List<Board> list = boardService.getBoardList(); //단순히 전제 조회
		List<Board> list = boardService.search(condition); //검색 조건이 있으면 그걸로 조회
		
		if(list == null || list.size() == 0)
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Board>>(list, HttpStatus.OK);
	}
	//2. 상세보기
	@GetMapping("/board/{id}")
	public ResponseEntity<Board> detail(@PathVariable int id){
		Board board = boardService.readBoard(id);
		//만약 사용자가 잘못 보냈다... 처리를 해라 board라고 하는게 null이면 무엇인가 처리를 해봐라잉
		return new ResponseEntity<Board>(board, HttpStatus.OK);
	}
	
	//3. 등록
	@PostMapping("/board")
	public ResponseEntity<Board> write(Board board){
		boardService.writeBoard(board);
		//지금 우리의 게시글은 키가 절대로 중복이 되지 않는다. 그래서 무조건 등록은 될꺼임... 
		//가끔가다가 혹여나 여기말고 다른곳에서 문제가 발생해서 글이 등록되지 않았다... 
		//DB에 댕겨올때 테이블을 변경하는 작업이라면 무엇인가를 하나 돌려줌... 무엇? 테이블을 건드린 행의 개수가 반환이된다.
		//만약에 0이라면 이거 등록 안된거니까 등록 안됬어요 ㅠㅠ 하고 프론트에게 돌려주어야 겠다.
		//그게 아니라면 잘 등록이 된거니까... OK 보내도 가넝
		return new ResponseEntity<Board>(board, HttpStatus.CREATED);
	}
	
	//4. 삭제
	@DeleteMapping("/board/{id}")
	public ResponseEntity<Void> delete(@PathVariable int id){
		boardService.removeBoard(id);
		//이것도 마찬가지로 반환값이 1이상이어야 실제로 무엇인가 지워진거지 ... 그게 아니면 지워진건 아니다 
		//이상한 값을 넣어도 그냥 동작을 해버린다.. 그러니 쿼리문을 날리지 못하게 사전에 커팅 해야함.
		//그리고 권한이 있어야만 지우는 거지 지금과 같은 방식은 남의글도 마구잡이로 지울수 있다.
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	//5. 수정
	@ApiIgnore
	@PutMapping("/board") //JSON형태의 데이터로 요청을 보내보자
	public ResponseEntity<Void> update(@RequestBody Board board){
		boardService.modifyBoard(board);
		//얘도 마찬가지 이죠 옥헤이?
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
