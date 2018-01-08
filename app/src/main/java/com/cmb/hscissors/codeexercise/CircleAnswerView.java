package com.cmb.hscissors.codeexercise;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by hscissors on 1/7/18.
 */

public class CircleAnswerView extends ConstraintLayout {

    private TextView positiveTextView;
    private TextView negativeTextView;

    public CircleAnswerView(Context context) {
        super(context);
        init(context, null, -1);
    }

    public CircleAnswerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, -1);
    }

    public CircleAnswerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr){
        inflate(getContext(), R.layout.circle_answer_contraint_layout, this);
    }
}
