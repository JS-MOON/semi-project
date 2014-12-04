package com.talent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TalentDAO {

	private Connection conn;

	public TalentDAO(Connection conn) {
		this.conn = conn;
	}

	// 회원 가입
	public int insertData(MemberDTO dto) {

		int result = 0;
		String sql;
		PreparedStatement pstmt = null;

		try {

			sql = "insert into member(mb_id,mb_pw";
			sql += ") values(?,?)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getMbId());
			pstmt.setString(2, dto.getMbPw());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return result;

	}

	// 한사람의 데이타 선택
	public MemberDTO selectData(String mbId) {

		MemberDTO dto = null;
		String sql;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			sql = "select mb_id,mb_pw,mb_tel,mb_nickName from member where mb_id=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, mbId);

			rs = pstmt.executeQuery();

			if (rs.next()) {

				dto = new MemberDTO();

				dto.setMbId(rs.getString("mb_id"));
				dto.setMbPw(rs.getString("mb_pw"));
				dto.setMbTel(rs.getString("mb_tel"));
				dto.setMbNickName(rs.getString("mb_nickName"));

			}
			
			rs.close();
			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return dto;
	}

	// 전체 데이타 출력
	public List<TalentDTO> getList() {

		List<TalentDTO> lists = new ArrayList<TalentDTO>();

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {

			sql = "select mb_id,mb_pw,mb_nickName,mb_tel,mb_pic,mb_about from member";

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				TalentDTO dto = new TalentDTO();

				dto.setMb_id(rs.getString("mb_id"));
				dto.setMb_pw(rs.getString("mb_pw"));
				dto.setMb_nickName(rs.getString("mb_nickName"));
				dto.setMb_tel(rs.getString("mb_tel"));
				dto.setMb_pic(rs.getString("mb_pic"));
				dto.setMb_about(rs.getString("mb_about"));

				lists.add(dto);

			}
			pstmt.close();
			rs.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return lists;

	}

	public String login(String mb_id) {

		String mb_pw_r = "";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {

			sql = "select mb_pw from member where mb_id= ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, mb_id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				mb_pw_r = rs.getString("mb_pw");

			}

			rs.close();
			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return mb_pw_r;
	}

	// 회원 정보 수정

	public int updateMember(TalentDTO dto) {

		PreparedStatement pstmt = null;
		String sql;
		int result = 0;

		try {

			sql = "update member set mb_pw=?,mb_tel=?,mb_pic=?,mb_about=?,mb_nickName=? where mb_id=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getMb_pw());
			pstmt.setString(2, dto.getMb_tel());
			pstmt.setString(3, dto.getMb_pic());
			pstmt.setString(4, dto.getMb_about());
			pstmt.setString(5, dto.getMb_nickName());
			pstmt.setString(6, dto.getMb_id());

			result = pstmt.executeUpdate();

			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;
	}

	public MemberDTO getReadMember(String mbId) {

		MemberDTO dto = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {

			sql = "select mb_id,mb_pw,mb_nickName,mb_tel,mb_pic,mb_about from member ";
			sql += "where mb_id=?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, mbId);

			rs = pstmt.executeQuery();

			if (rs.next()) {

				dto = new MemberDTO();

				dto.setMbId(rs.getString("mb_id"));
				dto.setMbPw(rs.getString("mb_pw"));
				dto.setMbNickName(rs.getString("mb_nickName"));
				dto.setMbTel(rs.getString("mb_tel"));
				dto.setMbPic(rs.getString("mb_pic"));
				dto.setMbAbout(rs.getString("mb_about"));

			}

			pstmt.close();
			rs.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return dto;
		
		
	}
	
	public int deleteMember(String mb_id){
		
		PreparedStatement pstmt = null;
		
		String sql;
		int result = 0;
		
		try {
			
			sql = "delete member where mb_id=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mb_id);
			
			result = pstmt.executeUpdate();
			
			pstmt.close();
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return result;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int getMaxNum() {

		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		try {
			sql = "select nvl(max(br_num),0) from board";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
			}
			rs.close();
			pstmt.close();

		} catch (Exception e) {
			e.toString();
		}
		return result;

	}

	// board 테이블 insert
	public int BoardInsert(BoardDTO dto) {

		int result = 0;
		PreparedStatement pstmt = null;
		String sql;

		try {
			sql = "insert into board(br_num,mb_id,cg_num,br_subject, ";
			sql += "br_mainphoto,br_morephoto,br_content,br_options,br_price,br_date) ";
			sql += "values (?,?,?,?,?,?,?,?,?,sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getBrNum());
			pstmt.setString(2, dto.getMbId());
			pstmt.setInt(3, dto.getCgNum());
			pstmt.setString(4, dto.getBrSubject());
			pstmt.setString(5, dto.getBrMainPhoto());
			pstmt.setString(6, dto.getBrMorePhoto());
			pstmt.setString(7, dto.getBrContent());
			pstmt.setString(8, dto.getBrOptions());
			pstmt.setInt(9, dto.getBrPrice());

			result = pstmt.executeUpdate();

			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;

	}

	// 게시판 출력 (대분류로 출력)
	public List<BoardDTO> list(int start, int end) {

		List<BoardDTO> lists = new ArrayList<BoardDTO>();
		BoardDTO dto = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		try {
			sql = "select B.mb_nickName,A.br_num,A.mb_id,A.cg_num,A.br_subject, ";
			sql += "A.br_mainphoto,A.br_morephoto,A.br_content,A.br_options,A.br_price,A.br_date ";
			sql += "from board A,member B where A.mb_id=B.mb_id and cg_num>=? and cg_num<=? order by A.br_num desc";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, start);
			pstmt.setInt(2, end);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				dto = new BoardDTO();
				dto.setMbNickName(rs.getString("mb_nickName"));
				dto.setBrNum(rs.getInt("br_num"));
				dto.setMbId(rs.getString("mb_id"));
				dto.setCgNum(rs.getInt("cg_num"));
				dto.setBrSubject(rs.getString("br_subject"));
				dto.setBrMainPhoto(rs.getString("br_mainphoto"));
				dto.setBrMorePhoto(rs.getString("br_morephoto"));
				dto.setBrContent(rs.getString("br_content"));
				dto.setBrOptions(rs.getString("br_options"));
				dto.setBrPrice(rs.getInt("br_price"));
				dto.setBrDate(rs.getString("br_date"));
				lists.add(dto);

			}
			rs.close();
			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return lists;
	}
	
	
	
	// 게시판 출력 (소분류로 출력)
		public List<BoardDTO> list(int cgNum) {

			List<BoardDTO> lists = new ArrayList<BoardDTO>();
			BoardDTO dto = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql;
			try {
				sql = "select B.mb_nickName,A.br_num,A.mb_id,A.cg_num,A.br_subject, ";
				sql += "A.br_mainphoto,A.br_morephoto,A.br_content,A.br_options,A.br_price,A.br_date ";
				sql += "from board A,member B where A.mb_id=B.mb_id and cg_num=? order by A.br_num desc";
				pstmt = conn.prepareStatement(sql);

				pstmt.setInt(1, cgNum);
				

				rs = pstmt.executeQuery();

				while (rs.next()) {

					dto = new BoardDTO();
					dto.setMbNickName(rs.getString("mb_nickName"));
					dto.setBrNum(rs.getInt("br_num"));
					dto.setMbId(rs.getString("mb_id"));
					dto.setCgNum(rs.getInt("cg_num"));
					dto.setBrSubject(rs.getString("br_subject"));
					dto.setBrMainPhoto(rs.getString("br_mainphoto"));
					dto.setBrMorePhoto(rs.getString("br_morephoto"));
					dto.setBrContent(rs.getString("br_content"));
					dto.setBrOptions(rs.getString("br_options"));
					dto.setBrPrice(rs.getInt("br_price"));
					dto.setBrDate(rs.getString("br_date"));
					lists.add(dto);

				}
				rs.close();
				pstmt.close();

			} catch (Exception e) {
				System.out.println(e.toString());
			}
			return lists;
		}
	
	

	// board 게시판 한개 select
	public BoardDTO getReadData(int brNum) {

		BoardDTO dto = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		try {
			sql = "select br_num,mb_id,cg_num,br_subject, ";
			sql += "br_mainphoto,br_morephoto,br_content,br_options,br_price,br_date ";
			sql += "from board where br_num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, brNum);
			rs = pstmt.executeQuery();
			if (rs.next()) {

				dto = new BoardDTO();
				dto.setBrNum(rs.getInt("br_num"));
				dto.setMbId(rs.getString("mb_id"));
				dto.setCgNum(rs.getInt("cg_num"));
				dto.setBrSubject(rs.getString("br_subject"));
				dto.setBrMainPhoto(rs.getString("br_mainphoto"));
				dto.setBrMorePhoto(rs.getString("br_morephoto"));
				dto.setBrContent(rs.getString("br_content"));
				dto.setBrOptions(rs.getString("br_options"));
				dto.setBrPrice(rs.getInt("br_price"));
				dto.setBrDate(rs.getString("br_date"));

			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return dto;

	}

	// board 게시판 데이터 삭제
	public int boardDelete(int brNum) {

		int result = 0;
		PreparedStatement pstmt = null;
		String sql;
		try {
			sql = "delete from board where br_Num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, brNum);
			result = pstmt.executeUpdate();

			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

		return result;
	}

	// board게시판 수정
	public int boardUpdate(BoardDTO dto) {

		int result = 0;
		PreparedStatement pstmt = null;
		String sql;
		try {
			sql = "update board set br_subject=?, br_mainphoto=?, br_morephoto=?, ";
			sql += "br_content=?, br_options=?, br_price=? ";
			sql += "where br_num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getBrSubject());
			pstmt.setString(2, dto.getBrMainPhoto());
			pstmt.setString(3, dto.getBrMorePhoto());
			pstmt.setString(4, dto.getBrContent());
			pstmt.setString(5, dto.getBrOptions());
			pstmt.setInt(6, dto.getBrPrice());
			pstmt.setInt(7, dto.getBrNum());
			result = pstmt.executeUpdate();

			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;

	}

	// cgNum으로 대분류 소분류 select
	public CategoryDTO getReadCategory(int cgNum) {

		CategoryDTO dto = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		try {
			sql = "select cg_category1,cg_category2 from category where cg_num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cgNum);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dto = new CategoryDTO();
				dto.setCgCategory1(rs.getString("cg_category1"));
				dto.setCgCategory2(rs.getString("cg_category2"));
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return dto;

	}

	
	
	
	
	//카테고리 불러오기
	public List<CategoryDTO> getReadCategory(int start,int end){
		
		List<CategoryDTO> lists = new ArrayList<CategoryDTO>();
		CategoryDTO dto = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		try {
			sql = "select cg_num,cg_category1,cg_category2 from category where cg_num>=? and cg_num<=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				dto = new CategoryDTO();
				dto.setCgNum(rs.getInt("cg_num"));
				dto.setCgCategory1(rs.getString("cg_category1"));
				dto.setCgCategory2(rs.getString("cg_category2"));
				
				lists.add(dto);
			}
			rs.close();
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return lists;
		
	}
	
	
	
	
	
	
	
	//////////////////////////////////////////////////////////////////////////
	// maxnum(cm_num)
	public int cmMaxNum() {

		int maxNum = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {

			sql = "select nvl(max(cm_num),0) from comments";

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				maxNum = rs.getInt(1);
			}

			pstmt.close();
			rs.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return maxNum;

	}

	public int cmInsert(CommentsDTO dto) {

		int result = 0;
		PreparedStatement pstmt = null;
		String sql;

		try {

			sql = "insert into comments(cm_num,br_num,cm_content,cm_nickName,cm_date,cm_rating) ";
			sql += "values(?,?,?,?,sysdate,?)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, dto.getCmNum());
			pstmt.setInt(2, dto.getBrNum());
			pstmt.setString(3, dto.getCmContent());
			pstmt.setString(4, dto.getCmNickName());
			pstmt.setInt(5, dto.getCmRating());

			result = pstmt.executeUpdate();

			pstmt.close();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;

	}

	// comments
	public List<CommentsDTO> cmList(int brNum) {

		List<CommentsDTO> lists = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;

		try {

			sql = "select cm_num,br_num,cm_content,cm_nickName,cm_date,cm_rating ";
			sql += "from comments where br_num=?";

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, brNum);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				CommentsDTO dto = new CommentsDTO();

				dto.setCmNum(rs.getInt("cm_num"));
				dto.setBrNum(rs.getInt("br_num"));
				dto.setCmContent(rs.getString("cm_content"));
				dto.setCmNickName(rs.getString("cm_nickName"));
				dto.setCmDate(rs.getDate("cm_date"));
				dto.setCmRating(rs.getInt("cm_rating"));

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


































