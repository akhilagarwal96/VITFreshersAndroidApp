package com.akhilagarwal96.vitfreshers;

/**
 * Created by Adm on 02-Apr-17.
 */

public class DataProviderExchg {

    public DataProviderExchg(StringBuffer t_name, StringBuffer t_room, StringBuffer t_phone, StringBuffer t_desc){

        this.setT_name(t_name);
        this.setT_room(t_room);
        this.setT_phone(t_phone);
        this.setT_desc(t_desc);

    }

    private StringBuffer t_name,t_room,t_phone,t_desc;

    public StringBuffer getT_name() {
        return t_name;
    }

    public void setT_name(StringBuffer t_name) {
        this.t_name = t_name;
    }

    public StringBuffer getT_room() {
        return t_room;
    }

    public void setT_room(StringBuffer t_room) {
        this.t_room = t_room;
    }

    public StringBuffer getT_phone() {
        return t_phone;
    }

    public void setT_phone(StringBuffer t_phone) {
        this.t_phone = t_phone;
    }

    public StringBuffer getT_desc() {
        return t_desc;
    }

    public void setT_desc(StringBuffer t_desc) {
        this.t_desc = t_desc;
    }
}
