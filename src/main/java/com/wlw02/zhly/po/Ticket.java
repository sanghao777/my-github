package com.wlw02.zhly.po;

import java.io.Serializable;

public class Ticket implements Serializable  {
    /**
	 * 
	 */
	private static final long serialVersionUID = -8621886608792376580L;

	private String tId;

    private String tName;

    private String tUser;

    private String tDate;

    private String tPrice;

    private String tRange;

    private String spId;

    private String uId;

    public String gettId() {
        return tId;
    }

    public void settId(String tId) {
        this.tId = tId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public String gettUser() {
        return tUser;
    }

    public void settUser(String tUser) {
        this.tUser = tUser;
    }

    public String gettDate() {
        return tDate;
    }

    public void settDate(String tDate) {
        this.tDate = tDate;
    }

    public String gettPrice() {
        return tPrice;
    }

    public void settPrice(String tPrice) {
        this.tPrice = tPrice;
    }

    public String gettRange() {
        return tRange;
    }

    public void settRange(String tRange) {
        this.tRange = tRange;
    }

    public String getSpId() {
        return spId;
    }

    public void setSpId(String spId) {
        this.spId = spId;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }
}