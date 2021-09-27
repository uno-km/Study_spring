package org.study.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.study.domain.BoardVO;
import org.study.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class BoardServiceImp implements BoardService {

	private final BoardMapper mapper;

	@Override
	public void register(BoardVO board) {
		log.info("register ...." + board);
		mapper.insertSelectKey(board);
		// TODO Auto-generated method stub

	}

	@Override
	public BoardVO get(Long bno) {
		// TODO Auto-generated method stub
		log.info("get............. : " + bno);
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Long bno) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<BoardVO> getList() {
		// TODO Auto-generated method stub
		log.info("getList.............");
		return mapper.getList();
	}

}
