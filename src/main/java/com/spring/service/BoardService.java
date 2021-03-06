
package com.spring.service;


import java.util.List;

import com.spring.domain.BoardVO;



public interface BoardService {
	public List<BoardVO> getBoard_Market() throws Exception;	

	public List<BoardVO> board_Market_List();

	public BoardVO board_market_read(int bno) ;

	public List<BoardVO> getBoard_Notice();

	public List<BoardVO> board_Notice_List();

	public BoardVO board_Notice_read(int bno);

}