package com.talent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

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

			sql = "insert into member(mb_id,mb_pw,mb_pic) values(?,?,?)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, dto.getMbId());
			pstmt.setString(2, dto.getMbPw());
			pstmt.setString(3, dto.getMbPic());

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
	
	public int deleteMember(String mbId){
		
		PreparedStatement pstmt = null;
		
		String sql;
		int result = 0;
		
		try {
			
			sql = "delete member where mb_id=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mbId);
			
			result = pstmt.executeUpdate();
			
			pstmt.close();
			
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return result;
		
	}
	
	//프로필사진업로드(update)
	public int updateMember(String mbPic,String mbId){
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			
			sql = "update member set mb_pic=? where mb_id=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mbPic);
			pstmt.setString(2, mbId);
			
			result = pstmt.executeUpdate();
			
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return result;
		
	}

	public int updateMember(MemberDTO dto){

		int result = 0;
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			
			sql = "update member set mb_nickName=?,mb_about=? where mb_id=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getMbNickName());
			pstmt.setString(2, dto.getMbAbout());
			pstmt.setString(3, dto.getMbId());
			
			result = pstmt.executeUpdate();
			
			pstmt.close();
			
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		
		return result;	
	}

	
	public int updateMember(String mbId,String changeMbPw1,String changeMbPw2){
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			
			sql = "update member set mb_pw=? where mb_id=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, changeMbPw1);
			pstmt.setString(2, mbId);
			
			
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

	// board ���̺� insert
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

	// �Խ��� ��� (��з��� ���)
	public List<BoardDTO> list(int start, int end) {

		List<BoardDTO> lists = new ArrayList<BoardDTO>();
		BoardDTO dto = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		try {
			sql = "select C.cg_category1,B.mb_nickName,A.br_num,A.mb_id,A.cg_num,A.br_subject, ";
			sql += "A.br_mainphoto,A.br_morephoto,A.br_content,A.br_options,A.br_price,A.br_date ";
			sql += "from board A, member B, category C where A.mb_id=B.mb_id and A.cg_num>=? and A.cg_num<=? and A.cg_num=C.cg_num order by A.br_num desc";
			
			/*sql = "select B.mb_nickName,A.br_num,A.mb_id,A.cg_num,A.br_subject, ";
			sql += "A.br_mainphoto,A.br_morephoto,A.br_content,A.br_options,A.br_price,A.br_date ";
			sql += "from board A,member B where A.mb_id=B.mb_id and cg_num>=? and cg_num<=? order by A.br_num desc";*/
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, start);
			pstmt.setInt(2, end);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				dto = new BoardDTO();
				dto.setCgCategory1(rs.getString("cg_category1"));
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
	
	
	
	// �Խ��� ��� (�Һз��� ���)
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
	
	

	// board �Խ��� �Ѱ� select
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

	// board �Խ��� ������ ����
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

	// board�Խ��� ����
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

	// cgNum���� ��з� �Һз� select
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

	
	
	
	
	//ī�װ� �ҷ�����
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

		List<CommentsDTO> lists = new ArrayList<CommentsDTO>();
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
	
	
	
	
	//GDetail 관련재능
	public List<BoardDTO> getReadRelation(int start,int end){
		
		List<BoardDTO> lists = new ArrayList<BoardDTO>();
		BoardDTO dto = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		try {
			sql = "select br_num,br_subject,br_mainphoto from board ";
			sql+= "where cg_num>=? and cg_num<=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			while(rs.next()){
				dto = new BoardDTO();
				dto.setBrNum(rs.getInt("br_num"));
				dto.setBrSubject(rs.getString("br_subject"));
				dto.setBrMainPhoto(rs.getString("br_mainphoto"));
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


































