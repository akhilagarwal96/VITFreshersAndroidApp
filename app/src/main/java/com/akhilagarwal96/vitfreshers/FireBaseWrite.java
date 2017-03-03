package com.akhilagarwal96.vitfreshers;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Adm on 21-Dec-16.
 */
public class FireBaseWrite {

    public String name;
    public String room;
    public String phone;
    public String desc;
    public int starCount = 0;
    public Map<String, Boolean> stars = new HashMap<>();

    public FireBaseWrite() {
        // Default constructor required for calls to DataSnapshot.getValue(Post.class)
    }

    public FireBaseWrite(String name, String author, String title, String body) {
        this.name = name;
        this.room = author;
        this.phone = title;
        this.desc = body;
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("name", name);
        result.put("author", room);
        result.put("phone", phone);
        result.put("desc", desc);
        result.put("starCount", starCount);
        result.put("stars", stars);

        return result;
    }

}