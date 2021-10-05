package org.study.mapper;

import java.util.List;

import org.study.domain.BoardVO;
import org.study.domain.Criteria;

public interface BoardMapper {

	// @Select("select * from tbl_board where bno>0")
	public List<BoardVO> getList();

	public List<BoardVO> getListWithPaging(Criteria cri);

	public List<BoardVO> getListWithPaging2(Criteria cri);

	public void insert(BoardVO board);

	public void insertSelectKey(BoardVO board);

	public BoardVO read(Long bno);

	public int delete(Long bno);

	public int update(BoardVO board);
	
	public int getTotalCount(Criteria cri);
}
