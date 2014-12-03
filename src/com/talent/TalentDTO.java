package com.talent;

public class TalentDTO {
	
	//mainClass
	private int mc_num;
	private String mc_content;
	
	//subClass
	private int sc_num;
	private String sc_content;
	
	//board
	private int br_num;
	private String br_subject;
	private String br_date;
	private int br_count;
	private int br_totalPrice;
	
	//Comment
	private int cm_num;
	private String cm_content;
	private String cm_nickName;
	private String cm_date;
	private int cm_topnum;
	
	//HiStory	
	private int hs_num;
	private String hs_date;
	private int hs_pcPrice;
	private int	hs_sales;
	private int	hs_price;
	
	//toSell
	private int ts_num;
	private String ts_mainPhoto;
	private int ts_price;
	private String ts_options;
	private String ts_morePhoto;
	
	//Purchase
	private int pc_num;
	private int pc_price;
	private String pc_content;
	
	//member
	private String mb_id;
	private String mb_pw;
	private String mb_pic;
	private String mb_nickName;
	private String mb_tel;
	private String mb_about;
	
	public int getMc_num() {
		return mc_num;
	}
	public void setMc_num(int mc_num) {
		this.mc_num = mc_num;
	}
	public String getMc_content() {
		return mc_content;
	}
	public void setMc_content(String mc_content) {
		this.mc_content = mc_content;
	}
	public int getSc_num() {
		return sc_num;
	}
	public void setSc_num(int sc_num) {
		this.sc_num = sc_num;
	}
	public String getSc_content() {
		return sc_content;
	}
	public void setSc_content(String sc_content) {
		this.sc_content = sc_content;
	}
	public int getBr_num() {
		return br_num;
	}
	public void setBr_num(int br_num) {
		this.br_num = br_num;
	}
	public String getBr_subject() {
		return br_subject;
	}
	public void setBr_subject(String br_subject) {
		this.br_subject = br_subject;
	}
	public String getBr_date() {
		return br_date;
	}
	public void setBr_date(String br_date) {
		this.br_date = br_date;
	}
	public int getBr_count() {
		return br_count;
	}
	public void setBr_count(int br_count) {
		this.br_count = br_count;
	}
	public int getCm_num() {
		return cm_num;
	}
	public void setCm_num(int cm_num) {
		this.cm_num = cm_num;
	}
	public String getCm_content() {
		return cm_content;
	}
	public void setCm_content(String cm_content) {
		this.cm_content = cm_content;
	}
	public String getCm_nickName() {
		return cm_nickName;
	}
	public void setCm_nickName(String cm_nickName) {
		this.cm_nickName = cm_nickName;
	}
	public String getCm_date() {
		return cm_date;
	}
	public void setCm_date(String cm_date) {
		this.cm_date = cm_date;
	}
	public int getCm_topnum() {
		return cm_topnum;
	}
	public void setCm_topnum(int cm_topnum) {
		this.cm_topnum = cm_topnum;
	}
	public int getHs_num() {
		return hs_num;
	}
	public void setHs_num(int hs_num) {
		this.hs_num = hs_num;
	}
	public String getHs_date() {
		return hs_date;
	}
	public void setHs_date(String hs_date) {
		this.hs_date = hs_date;
	}
	public int getHs_pcPrice() {
		return hs_pcPrice;
	}
	public void setHs_pcPrice(int hs_pcPrice) {
		this.hs_pcPrice = hs_pcPrice;
	}
	public int getHs_sales() {
		return hs_sales;
	}
	public void setHs_sales(int hs_sales) {
		this.hs_sales = hs_sales;
	}
	public int getHs_price() {
		return hs_price;
	}
	public void setHs_price(int hs_price) {
		this.hs_price = hs_price;
	}
	public int getTs_num() {
		return ts_num;
	}
	public void setTs_num(int ts_num) {
		this.ts_num = ts_num;
	}
	public String getTs_mainPhoto() {
		return ts_mainPhoto;
	}
	public void setTs_mainPhoto(String ts_mainPhoto) {
		this.ts_mainPhoto = ts_mainPhoto;
	}
	public int getTs_price() {
		return ts_price;
	}
	public void setTs_price(int ts_price) {
		this.ts_price = ts_price;
	}
	public String getTs_options() {
		return ts_options;
	}
	public void setTs_options(String ts_options) {
		this.ts_options = ts_options;
	}
	public String getTs_morePhoto() {
		return ts_morePhoto;
	}
	public void setTs_morePhoto(String ts_morePhoto) {
		this.ts_morePhoto = ts_morePhoto;
	}
	public int getPc_num() {
		return pc_num;
	}
	public void setPc_num(int pc_num) {
		this.pc_num = pc_num;
	}
	public int getPc_price() {
		return pc_price;
	}
	public void setPc_price(int pc_price) {
		this.pc_price = pc_price;
	}
	public String getPc_content() {
		return pc_content;
	}
	public void setPc_content(String pc_content) {
		this.pc_content = pc_content;
	}
	public String getMb_id() {
		return mb_id;
	}
	public void setMb_id(String mb_id) {
		this.mb_id = mb_id;
	}
	public String getMb_pw() {
		return mb_pw;
	}
	public void setMb_pw(String mb_pw) {
		this.mb_pw = mb_pw;
	}
	public int getBr_totalPrice() {
		return br_totalPrice;
	}
	public void setBr_totalPrice(int br_totalPrice) {
		this.br_totalPrice = br_totalPrice;
	}
	public String getMb_pic() {
		return mb_pic;
	}
	public void setMb_pic(String mb_pic) {
		this.mb_pic = mb_pic;
	}
	public String getMb_nickName() {
		return mb_nickName;
	}
	public void setMb_nickName(String mb_nickName) {
		this.mb_nickName = mb_nickName;
	}
	public String getMb_tel() {
		return mb_tel;
	}
	public void setMb_tel(String mb_tel) {
		this.mb_tel = mb_tel;
	}
	public String getMb_about() {
		return mb_about;
	}
	public void setMb_about(String mb_about) {
		this.mb_about = mb_about;
	}
	

}
































