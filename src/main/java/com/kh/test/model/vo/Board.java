package com.kh.test.model.vo;

import java.time.LocalDateTime;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="BOARD")

@DynamicInsert
@DynamicUpdate

@NoArgsConstructor
@Setter
@Getter
@ToString
public class Board {

	@Id
	@Column(name="BOARD_NO")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int boardNo;
	
	@Column(name="BOARD_TITLE", length=255, nullable=false)
	private String boardTitle;
	
	@Column(name="BOARD_CONTENT", length=255, nullable=false)
	private String boardContent;
	
	@Column(name="CREATE_DATE", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private LocalDateTime createDate;
	
	@Column(name="COUNT", columnDefinition="INT DEFAULT 0")
	private int count;
	
}