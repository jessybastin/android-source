package io.bloc.android.blocly.ui.activity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import io.bloc.android.blocly.R;
import io.bloc.android.blocly.api.model.RssFeed;
import io.bloc.android.blocly.ui.adapter.ItemAdapter;
import io.bloc.android.blocly.ui.adapter.NavigationDrawerAdapter;

/**
 * Created by jayapriya on 01/03/15.
 */
public class BloclyActivity extends ActionBarActivity implements NavigationDrawerAdapter.NavigationDrawerAdapterDelegate{

    //TextView textOut;
    private ItemAdapter itemAdapter;
    private ActionBarDrawerToggle drawerToggle;
    private DrawerLayout drawerLayout;
    private NavigationDrawerAdapter navigationDrawerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blocly);

        Toolbar toolbar = (Toolbar) findViewById(R.id.tb_activity_blocly);
        setSupportActionBar(toolbar);


        itemAdapter = new ItemAdapter();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_activity_blocly);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(itemAdapter);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        drawerLayout = (DrawerLayout) findViewById(R.id.dl_activity_blocly);

        drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,0,0);
        drawerLayout.setDrawerListener(drawerToggle);

        navigationDrawerAdapter = new NavigationDrawerAdapter();
        navigationDrawerAdapter.setDelegate(this);
        RecyclerView navigationRecyclerView = (RecyclerView) findViewById(R.id.rv_nav_activity_blocly);
        navigationRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        navigationRecyclerView.setItemAnimator(new DefaultItemAnimator());
        navigationRecyclerView.setAdapter(navigationDrawerAdapter);
    }
    //@override

    protected void onPostCreate(Bundle savedInstance){
        super.onPostCreate(savedInstance);
        drawerToggle.syncState();
    }

    //@override
    public void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    //@override
    public boolean onOptionsItemSelected(MenuItem item){
        if (drawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //override
    public void didSelectNavigationOption(NavigationDrawerAdapter adapter,NavigationDrawerAdapter.NavigationOption navigationOption){
        drawerLayout.closeDrawers();
        Toast.makeText(this, " Show the "+ navigationOption.name(), Toast.LENGTH_SHORT).show();
    }

    //override


    //Override
    public void didSelectFeed(NavigationDrawerAdapter adapter, RssFeed rssfeed) {
        drawerLayout.closeDrawers();
        Toast.makeText(this,"Show Rss Item from "+ rssfeed.getTitle(),Toast.LENGTH_SHORT).show();
    }

    //override

    public void onClick(View v){
        BloclyActivity bloclyActivity = (BloclyActivity) v.getContext();
        DrawerLayout drawerLayout = (DrawerLayout) bloclyActivity.findViewById(R.id.dl_activity_blocly);
        drawerLayout.closeDrawers();
    }
}
