package com.talent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TalentDAO {

	private Connection conn;

	public TalentDAO (Connection conn){
		this.conn = conn;
	}

	public List<BoardDTO> list(){

		List<BoardDTO> lists = new ArrayList<BoardDTO>();
		BoardDTO dto = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		try {
			sql = "select a.br_num, a.br_subject, a.br_date, b.ts_price, b.ts_mainphoto ";
			sql+= "from board a, tosell b where a.ts_num = b.ts_num";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				dto = new BoardDTO();

				System.out.println(rs.getString("ts_mainphoto"));
				lists.add(dto);
			}
			rs.close();
			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return lists;
	}



}
