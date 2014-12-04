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
	
	//프로필사진업로드(update)
	public int updateMember(String mbPic,String mbId){
		
		int result = 0;
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			
			System.out.println(mbPic);
			System.out.println(mbId);
			
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
	
	public int updateMember(String mbId,String mbPw){
	
		
		int result=0;
		
		return result;
	}
	
	

}


































