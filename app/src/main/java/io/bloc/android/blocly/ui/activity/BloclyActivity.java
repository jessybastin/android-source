package io.bloc.android.blocly.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import io.bloc.android.blocly.BloclyApplication;
import io.bloc.android.blocly.R;

/**
 * Created by jayapriya on 01/03/15.
 */
public class BloclyActivity extends Activity{

    TextView textOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blocly);
       textOut = (TextView)findViewById(R.id.mod_text);
        textOut.setText(BloclyApplication.getSharedDataSource().getFeeds().get(0).getTitle());
                Toast.makeText(this,
                        BloclyApplication.getSharedDataSource().getFeeds().get(0).getTitle(),
                        Toast.LENGTH_LONG).show();
    }
}
