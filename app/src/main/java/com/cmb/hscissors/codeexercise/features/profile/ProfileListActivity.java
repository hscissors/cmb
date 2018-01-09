package com.cmb.hscissors.codeexercise.features.profile;

import android.animation.Animator;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.cmb.hscissors.codeexercise.R;
import com.cmb.hscissors.codeexercise.data.TeamMember;

/**
 * Created by hscissors on 1/7/18.
 */

public class ProfileListActivity extends Activity implements ProfileListView {

    private ProfileListPresenter presenter;
    private FrameLayout container;
    private View loading;
    private View approve;
    private View reject;

    @Override
    public void addProfile(TeamMember teamMember) {
        ProfileView profile;
        if (container.getChildCount() == 1) {
            profile = (ProfileView) container.getChildAt(0);
            profile.bindData(teamMember);
        } else {
            profile = new ProfileView(this);
            profile.bindData(teamMember);

            container.addView(profile);
        }

        profile.setApproveButtonListener(view -> presenter.onProfilePositive(teamMember));
        profile.setRejectButtonListener(view -> presenter.onProfileNegative(teamMember));
    }

    @Override
    public void showApprove() {
        approve.setVisibility(View.VISIBLE);
        approve.animate()
                .setDuration(1000)
                .alpha(0f)
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                        approve.setVisibility(View.GONE);
                        approve.setAlpha(1f);
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                })
                .start();
    }

    @Override
    public void showReject() {
        reject.setVisibility(View.VISIBLE);
        reject.animate()
                .setDuration(1000)
                .alpha(0f)
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                        reject.setVisibility(View.GONE);
                        reject.setAlpha(1f);
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                })
                .start();
    }

    @Override
    public void showContent() {
        container.setVisibility(View.VISIBLE);
        loading.setVisibility(View.GONE);
    }

    @Override
    public void showLoading() {
        container.setVisibility(View.GONE);
        loading.setVisibility(View.VISIBLE);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        setContentView(R.layout.frame_layout_profile_list_activity);

        container = findViewById(R.id.profile_list_activity_container);
        loading = findViewById(R.id.profile_list_activity_loading);
        approve = findViewById(R.id.profile_list_activity_approved);
        reject = findViewById(R.id.profile_list_activity_rejected);

        if (presenter == null) {
            presenter = new ProfileListPresenter();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        presenter.attachView(this);
        presenter.init();
    }

    @Override
    protected void onPause() {
        super.onPause();

        presenter.detachView();
    }
}
