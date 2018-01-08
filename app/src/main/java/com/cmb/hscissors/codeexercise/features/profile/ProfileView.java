package com.cmb.hscissors.codeexercise.features.profile;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;

import com.cmb.hscissors.codeexercise.R;
import com.cmb.hscissors.codeexercise.data.TeamMember;
import com.squareup.picasso.Picasso;

/**
 * Created by hscissors on 1/7/18.
 */

public class ProfileView extends ConstraintLayout {
    private ImageView profileAvatarView;
    private TextView nameTextView;
    private TextView titleTextView;
    private TextView bioTextView;

    public ProfileView(Context context) {
        super(context);
    }

    public ProfileView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ProfileView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        profileAvatarView = findViewById(R.id.profile_view_avatar);
        nameTextView = findViewById(R.id.profile_view_name);
        titleTextView = findViewById(R.id.profile_view_title);
        bioTextView = findViewById(R.id.profile_view_bio);
    }

    public void bindData(TeamMember teamMember) {
        nameTextView.setText(teamMember.getFullName());
        titleTextView.setText(teamMember.getTitle());
        bioTextView.setText(teamMember.getBio());

        Picasso.with(getContext()).cancelRequest(profileAvatarView);

        Picasso.with(getContext())
                .load(teamMember.getAvatarUrl())
                .into(profileAvatarView);
    }


}
