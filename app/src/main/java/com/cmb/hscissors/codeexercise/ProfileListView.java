package com.cmb.hscissors.codeexercise;

/**
 * Created by hscissors on 1/7/18.
 */

interface ProfileListView {
    void addProfile(TeamMember teamMember);

    void showContent();

    void showLoading();

    void showError(String error);

    void showEmpty();
}
