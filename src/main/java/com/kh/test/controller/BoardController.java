package com.kh.test.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kh.test.model.service.BoardService;
import com.kh.test.model.vo.Board;

@RestController
@CrossOrigin
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/boards")
	public ResponseEntity<ArrayList<Board>> selectBoardList() {
		
		ArrayList<Board> list = (ArrayList)boardService.selectBoardList();
		
		return ResponseEntity.status(HttpStatus.OK)
							 .body(list);
	}
	
	@GetMapping("/boards/{id}")
	public ResponseEntity<Board> selectBoard(@PathVariable("id") int boardNo) {
		
		Board b = boardService.selectBoard(boardNo);
		
		b.setCount(b.getCount() + 1);
		
		boardService.increaseBoard(b);
		
		return ResponseEntity.status(HttpStatus.OK)
							 .body(b);
	}
	
	@PostMapping("/boards")
	public ResponseEntity<String> insertBoard(@RequestBody Board b) {
		
		Board insertB = boardService.insertBoard(b);
		
		String result = (insertB != null) ? "success" : "fail";
		
		return ResponseEntity.status(HttpStatus.OK)
							 .body(result);
	}
	
	@DeleteMapping("/boards/{id}")
	public ResponseEntity<String> deleteBoard(@PathVariable("id") int boardNo) {
		
		boardService.deleteBoard(boardNo);
		
		boolean isTrue = boardService.existsById(boardNo);
		
		String result = !isTrue ? "success" : "fail";
		
		return ResponseEntity.status(HttpStatus.OK)
							 .body(result);
	}
	
}