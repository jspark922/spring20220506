package org.zerock.service.ex03;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.ex02.BoardDto;
import org.zerock.mapper.ex03.Ex03Mapper;
import org.zerock.mapper.ex03.Ex04Mapper;

@Service
public class Ex05Service {

	@Autowired
	private Ex03Mapper mapper;
	@Autowired
	private Ex04Mapper replyMapper;
	
	public String getCustomerNameById(int id) {
		return mapper.selectCustomerNameById(id);
	}

	public String getEmployeeFirstNameByID(int id) {
		return mapper.selectEmployeeFirstNameById(id);
	}


	public List<BoardDto> listBoard() {
		return mapper.selectBoard();
	}

	public BoardDto getBoardBody(int id) {
		return mapper.selectBoardBody(id);
	}

	public boolean updateBoard(BoardDto board) {
		int cnt = mapper.updateBoard(board);
		
		return cnt == 1;
	}
	
	@Transactional
	public boolean removeBoardById(int id) {
		// 댓글 지우기
		replyMapper.deleteReplyByBoard(id);
		
		// 게시물 지우기
		int cnt = mapper.deleteBoard(id);
		// TODO Auto-generated method stub
		return cnt == 1;
	}

	public boolean addBoard(BoardDto board) {
		board.setInserted(LocalDateTime.now());
		
		int cnt = mapper.insertBoard(board);
		
		return cnt == 1;
	}
	
}
