package io.bloc.android.blocly.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;

import java.util.HashMap;
import java.util.Map;

import io.bloc.android.blocly.R;

/**
 * Created by jayapriya on 18/03/15.
 */
public class RobotoButton extends Button {

    private static Map<String, Typeface> sTypefaces = new HashMap<String, Typeface>();

    public RobotoButton(Context context){
        super(context);
    }

    public RobotoButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        extractButton(attrs);
    }

    public RobotoButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        extractButton(attrs);
    }

    void extractButton(AttributeSet attrs) {
// #5
        if (isInEditMode()) {
            return;
        }
        if (attrs == null) {
            return;
        }

        TypedArray typedArray = getContext().getTheme().obtainStyledAttributes(
                attrs, R.styleable.Roboto, 0, 0);

        // #7

        int robotoButtonIndex = typedArray.getInteger(R.styleable.RobotoButton_robotoButton, -1);
               // remove Roboto_robotoFont, -1);
// #8
        typedArray.recycle();
// #9
        String[] stringArray = getResources().getStringArray(R.array.roboto_button_file_names);
        if (robotoButtonIndex < 0 || robotoButtonIndex >= stringArray.length) {
            return;
        }
        String robotoFont = stringArray[robotoButtonIndex];
        Typeface robotoTypeface = null;
// #10
        if (sTypefaces.containsKey(robotoFont)) {
            robotoTypeface = sTypefaces.get(robotoFont);
        } else {
// #11
            robotoTypeface = Typeface.createFromAsset(getResources().getAssets(), "fonts/RobotoTTF/" + robotoFont);
            sTypefaces.put(robotoFont, robotoTypeface);
        }
// #12
        setTypeface(robotoTypeface);
    }

    }

