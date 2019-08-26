package com.wlw02.zhly.po;

import java.io.Serializable;

public class Spot  implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -3068090948313522420L;

	private String spId;

    private String spName;

    private String spUserid;

    private String spDetial;

    private String spAddress;

    private String spPhone;

    private String ticketClass;

    private String ticketPrice;

    private String spImg;

    public String getSpId() {
        return spId;
    }

    public void setSpId(String spId) {
        this.spId = spId;
    }

    public String getSpName() {
        return spName;
    }

    public void setSpName(String spName) {
        this.spName = spName;
    }

    public String getSpUserid() {
        return spUserid;
    }

    public void setSpUserid(String spUserid) {
        this.spUserid = spUserid;
    }

    public String getSpDetial() {
        return spDetial;
    }

    public void setSpDetial(String spDetial) {
        this.spDetial = spDetial;
    }

    public String getSpAddress() {
        return spAddress;
    }

    public void setSpAddress(String spAddress) {
        this.spAddress = spAddress;
    }

    public String getSpPhone() {
        return spPhone;
    }

    public void setSpPhone(String spPhone) {
        this.spPhone = spPhone;
    }

    public String getTicketClass() {
        return ticketClass;
    }

    public void setTicketClass(String ticketClass) {
        this.ticketClass = ticketClass;
    }

    public String getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(String ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getSpImg() {
        return spImg;
    }

    public void setSpImg(String spImg) {
        this.spImg = spImg;
    }
}