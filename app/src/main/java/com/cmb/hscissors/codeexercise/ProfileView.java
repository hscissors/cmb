package com.cmb.hscissors.codeexercise;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by hscissors on 1/7/18.
 */

public class ProfileView extends ConstraintLayout {
    private ImageView profileImageView;
    private TextView titleTextView;
    private TextView firstNameTextView;
    private TextView lastNameTextView;
    private TextView bioTextView;

    public ProfileView(Context context) {
        super(context);
    }

    public ProfileView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ProfileView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void bindData(TeamMember teamMember) {
        //do some binding
    }


}
