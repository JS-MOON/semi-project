package com.talent;

import java.sql.Date;

/**
 * Created by JS on 2014-12-01.
 */
public class HistoryDTO {

    private int hsNum;
    private String mbId;
    private int brNum;
    private Date hsDate;
    private int hsBuyPrice;
    private int hsSellPrice;
	public int getHsNum() {
		return hsNum;
	}
	public void setHsNum(int hsNum) {
		this.hsNum = hsNum;
	}
	public String getMbId() {
		return mbId;
	}
	public void setMbId(String mbId) {
		this.mbId = mbId;
	}
	public int getBrNum() {
		return brNum;
	}
	public void setBrNum(int brNum) {
		this.brNum = brNum;
	}
	public Date getHsDate() {
		return hsDate;
	}
	public void setHsDate(Date hsDate) {
		this.hsDate = hsDate;
	}
	public int getHsBuyPrice() {
		return hsBuyPrice;
	}
	public void setHsBuyPrice(int hsBuyPrice) {
		this.hsBuyPrice = hsBuyPrice;
	}
	public int getHsSellPrice() {
		return hsSellPrice;
	}
	public void setHsSellPrice(int hsSellPrice) {
		this.hsSellPrice = hsSellPrice;
	}

    
}