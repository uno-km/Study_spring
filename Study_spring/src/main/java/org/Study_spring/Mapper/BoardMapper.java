package org.Study_spring.Mapper;

import java.util.List;

import org.Study_spring.domain.BoardVO;
import org.apache.ibatis.annotations.Select;

public interface BoardMapper {
	@Select("select * from tbl_board where bno > 0")
	public List<BoardVO> getList();

}
