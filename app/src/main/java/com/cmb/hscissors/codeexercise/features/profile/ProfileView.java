package com.cmb.hscissors.codeexercise.features.profile;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.widget.Button;
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
    private Button approveButton;
    private Button rejectButton;

    public ProfileView(Context context) {
        super(context);
        init(context, null, -1);
    }

    public ProfileView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, -1);
    }

    public ProfileView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    public void init(Context context, AttributeSet attrs, int defStyleAttr) {
        inflate(getContext(), R.layout.contraint_layout_profile_view, this);

        profileAvatarView = findViewById(R.id.profile_view_avatar);
        nameTextView = findViewById(R.id.profile_view_name);
        titleTextView = findViewById(R.id.profile_view_title);
        bioTextView = findViewById(R.id.profile_view_bio);

        approveButton = findViewById(R.id.selector_positive);
        rejectButton = findViewById(R.id.selector_negative);
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

    public void setApproveButtonListener(OnClickListener listener) {
        approveButton.setOnClickListener(listener);
    }

    public void setRejectButtonListener(OnClickListener listener) {
        rejectButton.setOnClickListener(listener);
    }


}
