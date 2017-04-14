package com.akhilagarwal96.vitfreshers;

public class DataProviderExchange {

    public DataProviderExchange(String t_name, String t_room, String t_phone, String t_desc){

        this.setT_name(t_name);
        this.setT_room(t_room);
        this.setT_phone(t_phone);
        this.setT_desc(t_desc);

    }

    private String t_name,t_room,t_phone,t_desc;

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public String getT_room() {
        return t_room;
    }

    public void setT_room(String t_room) {
        this.t_room = t_room;
    }

    public String getT_phone() {
        return t_phone;
    }

    public void setT_phone(String t_phone) {
        this.t_phone = t_phone;
    }

    public String getT_desc() {
        return t_desc;
    }

    public void setT_desc(String t_desc) {
        this.t_desc = t_desc;
    }
}