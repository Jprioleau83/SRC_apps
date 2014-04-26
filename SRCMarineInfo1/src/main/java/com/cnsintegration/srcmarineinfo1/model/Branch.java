package com.cnsintegration.srcmarineinfo1.model;

/**
 * Created by jprioleau on 4/26/2014.
 */
public class Branch {

    private int Branch_ID;
    private String Branch_NAME;
    private String Branch_ICON;

    public int getBranch_ID() {
        return Branch_ID;
    }

    public void setBranch_ID(int branch_ID) {
        Branch_ID = branch_ID;
    }

    public String getBranch_NAME() {
        return Branch_NAME;
    }

    public void setBranch_NAME(String branch_NAME) {
        Branch_NAME = branch_NAME;
    }

    public String getBranch_ICON() {
        return Branch_ICON;
    }

    public void setBranch_ICON(String branch_ICON) {
        Branch_ICON = branch_ICON;
    }
}
