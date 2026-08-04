package com.kh.test.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kh.test.model.vo.Board;

public interface BoardDao extends JpaRepository<Board, Integer> {

}