package com.cmb.hscissors.codeexercise;

/**
 * Created by hscissors on 1/7/18.
 * <p>
 * NOTE: A more robust app would generalize the patterns below as an architecture for the app.
 * Using an MVP pattern for this small of an app is overkill and was done just for
 * demonstration purposes.
 */

public class ProfileListPresenter<T extends ProfileListView> {

    private T view;

    public void attachView(T view) {
        this.view = view;
    }

    public void init() {
        if(view != null){
            view.showLoading();
        }


    }

    private void onSuccess() {

    }

    private void onError(String error) {
        view.showError(error);
    }

    public void onProfilePositive(TeamMember teamMember) {

    }

    public void onProfileNegative(TeamMember teamMember) {

    }
}
