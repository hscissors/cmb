package com.cmb.hscissors.codeexercise.features.profile;

import com.cmb.hscissors.codeexercise.data.DataService;
import com.cmb.hscissors.codeexercise.data.TeamMember;

import java.util.ArrayList;

import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by hscissors on 1/7/18.
 * <p>
 * NOTE: A more robust app would generalize the patterns below as an architecture for the app.
 * Using an MVP pattern for this small of an app is overkill and was done just for
 * demonstration purposes.
 */

public class ProfileListPresenter {

    private ProfileListView view;
    private ArrayList<TeamMember> teamMembers;
    private int currentProfileIndex = 0;

    public void attachView(ProfileListView view) {
        this.view = view;
    }

    public void detachView() {
        this.view = null;
    }

    public void init() {
        if (view != null) {
            view.showLoading();
        }

        //This would not be a viable pattern with pagination, but for demo purposes works
        DataService.getInstance()
                .getTeamMembers()
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(throwable -> onError(throwable.getMessage()))
                .subscribe(teamMembers -> {
                    this.teamMembers = teamMembers;
                    onSuccess();
                });
    }

    private void onSuccess() {
        addNextProfile();

        view.showContent();
    }

    private void onError(String error) {
        if (error == null) {
            error = "";
        }

        view.showError(error);
    }

    public void onProfilePositive(TeamMember teamMember) {
        if (view == null) return;

        view.showApprove();
        addNextProfile();
    }

    public void onProfileNegative(TeamMember teamMember) {
        if (view == null) return;

        view.showReject();
        addNextProfile();
    }

    private void addNextProfile() {
        if (view == null) return;

        view.addProfile(teamMembers.get(currentProfileIndex));

        currentProfileIndex = currentProfileIndex >= teamMembers.size() - 1 ? 0 : currentProfileIndex + 1;
    }
}
