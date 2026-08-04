package com.kh.test.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.test.model.dao.BoardDao;
import com.kh.test.model.vo.Board;

import jakarta.transaction.Transactional;

@Service
public class BoardService {
	
	@Autowired
	private BoardDao boardDao;
	
	public List<Board> selectBoardList() {
		
		return boardDao.findAll();
	}
	
	public Board selectBoard(int boardNo) {
		
		return boardDao.findById(boardNo).orElse(null);
	}
	
	@Transactional
	public Board insertBoard(Board b) {
		
		return boardDao.save(b);
	}
	
	@Transactional
	public void deleteBoard(int boardNo) {
		
		boardDao.deleteById(boardNo);
	}

	public boolean existsById(int boardNo) {
		
		return boardDao.existsById(boardNo);
	}

	@Transactional
	public void increaseBoard(Board b) {
		
		boardDao.save(b);
	}
	
}