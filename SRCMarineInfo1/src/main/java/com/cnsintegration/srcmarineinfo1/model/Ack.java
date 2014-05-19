package com.cnsintegration.srcmarineinfo1.model;

/**
 * Created by jprioleau on 5/19/2014.
 */
public class Ack {

    public int id;
    public String ack;
    public String ack_name;
    public String ack_details;
    public String ack_link;

    public String getAck_icon() {
        return ack_icon;
    }

    public void setAck_icon(String ack_icon) {
        this.ack_icon = ack_icon;
    }

    public String ack_icon;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAck() {
        return ack;
    }

    public void setAck(String ack) {
        this.ack = ack;
    }

    public String getAck_name() {
        return ack_name;
    }

    public void setAck_name(String ack_name) {
        this.ack_name = ack_name;
    }

    public String getAck_details() {
        return ack_details;
    }

    public void setAck_details(String ack_details) {
        this.ack_details = ack_details;
    }

    public String getAck_link() {
        return ack_link;
    }

    public void setAck_link(String ack_link) {
        this.ack_link = ack_link;
    }
}
