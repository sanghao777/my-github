package com.wlw02.zhly.po;

import java.io.Serializable;

public class Role  implements Serializable  {
    /**
	 * 
	 */
	private static final long serialVersionUID = -9181055476764794675L;

	private String rId;

    private String rName;

    private String rMemo;

    private String rPath;

    public String getrId() {
        return rId;
    }

    public void setrId(String rId) {
        this.rId = rId;
    }

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName;
    }

    public String getrMemo() {
        return rMemo;
    }

    public void setrMemo(String rMemo) {
        this.rMemo = rMemo;
    }

    public String getrPath() {
        return rPath;
    }

    public void setrPath(String rPath) {
        this.rPath = rPath;
    }
}