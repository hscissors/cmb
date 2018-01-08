package com.cmb.hscissors.codeexercise.features.profile;

import android.animation.Animator;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
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
    private ConstraintLayout loading;

    @Override
    public void addProfile(TeamMember teamMember) {
        ProfileView profile;
        if(container.getChildCount() == 2){
            profile = (ProfileView) container.getChildAt(1);
            profile.bindData(teamMember);
        } else {
            profile = (ProfileView) getLayoutInflater().inflate(R.layout.contraint_layout_profile_view, container, false);
            profile.bindData(teamMember);

            container.addView(profile);
        }
    }

    @Override
    public void swapCurrentProfile() {
        ProfileView currentProfile = (ProfileView) container.getChildAt(0);
        ProfileView nextProfile = (ProfileView) container.getChildAt(1);

        currentProfile.animate()
                .alpha(0.0f)
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                        nextProfile.bringToFront();
                        currentProfile.setAlpha(1f);

                        presenter.onSwapProfile();
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                });
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
