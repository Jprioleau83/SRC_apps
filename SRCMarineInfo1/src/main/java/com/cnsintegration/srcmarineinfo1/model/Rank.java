package com.cnsintegration.srcmarineinfo1.model;

/**
 * Created by jprioleau on 4/25/14.
 */
public class Rank {








    private int rank_ID;
    private String Rank_SHORT;
    private String Rank_NAME;
    private String Rank_ICON;


    private String Rank_PAY;

    private String Rank_TYPE;
    private String Rank_DETAILS;
    private String Rank_LINK;

    private int Rank_Branch;

    public long getId() {
        return rank_ID;
    }

    public void setId(int id) {
        this.rank_ID = id;
    }

    public String getShortName() {
        return this.Rank_SHORT;
    }

    public void setShortName(String name) {
        this.Rank_SHORT = name;
    }
    public String getName() {
        return this.Rank_NAME;
    }

    public void setName(String name) {
        this.Rank_NAME = name;
    }

    public String getIcon() {
        return this.Rank_ICON;
    }

    public void setIcon(String name) {
        this.Rank_ICON = name;
    }

    public String getRank_PAY() {
        return Rank_PAY;
    }

    public void setRank_PAY(String rank_PAY) {
        Rank_PAY = rank_PAY;
    }

    public String getRank_TYPE() {
        return Rank_TYPE;
    }

    public void setRank_TYPE(String rank_TYPE) {
        Rank_TYPE = rank_TYPE;
    }

    public String getRank_DETAILS() {
        return Rank_DETAILS;
    }

    public void setRank_DETAILS(String rank_DETAILS) {
        Rank_DETAILS = rank_DETAILS;
    }

    public String getRank_LINK() {
        return Rank_LINK;
    }

    public void setRank_LINK(String rank_LINK) {
        Rank_LINK = rank_LINK;
    }

    public int getRank_Branch() {
        return Rank_Branch;
    }

    public void setRank_Branch(int rank_Branch) {
        Rank_Branch = rank_Branch;
    }
}
