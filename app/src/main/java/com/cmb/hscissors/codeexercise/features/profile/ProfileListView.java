package com.cmb.hscissors.codeexercise.features.profile;

import com.cmb.hscissors.codeexercise.data.TeamMember;

/**
 * Created by hscissors on 1/7/18.
 */

interface ProfileListView {
    void addProfile(TeamMember teamMember);

    void swapCurrentProfile();

    void showContent();

    void showLoading();

    void showError(String error);
}
