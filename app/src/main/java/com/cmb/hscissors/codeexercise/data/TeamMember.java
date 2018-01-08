package com.cmb.hscissors.codeexercise.data;

import android.support.annotation.Nullable;
import android.text.TextUtils;

/**
 * Created by hscissors on 1/7/18.
 */

public class TeamMember {
    private String id;
    private String avatar;
    private String bio;
    private String title;
    private String firstName;
    private String lastName;

    public Long getId() {
        return !TextUtils.isEmpty(id) ? Long.parseLong(id) : -1L;
    }

    @Nullable
    public String getAvatarUrl() {
        return avatar;
    }

    public String getBio() {
        return bio;
    }

    public String getTitle() {
        return title;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return !TextUtils.isEmpty(lastName) ? firstName : firstName + " " + lastName;
    }
}
