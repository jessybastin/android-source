package io.bloc.android.blocly.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import io.bloc.android.blocly.R;
import io.bloc.android.blocly.ui.adapter.ItemAdapter;

/**
 * Created by jayapriya on 01/03/15.
 */
public class BloclyActivity extends Activity{

    //TextView textOut;
    private ItemAdapter itemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blocly);
       //textOut = (TextView)findViewById(R.id.mod_text);
       // textOut.setText(BloclyApplication.getSharedDataSource().getFeeds().get(0).getTitle());
              //  Toast.makeText(this,
                //        BloclyApplication.getSharedDataSource().getFeeds().get(0).getTitle(),
                  //      Toast.LENGTH_LONG).show();

        itemAdapter = new ItemAdapter();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_activity_blocly);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(itemAdapter);


    }
}
