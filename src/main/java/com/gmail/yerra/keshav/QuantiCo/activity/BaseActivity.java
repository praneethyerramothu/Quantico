package com.gmail.yerra.keshav.QuantiCo.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.gmail.yerra.keshav.QuantiCo.R;

/**
 * Created by keshav on 15/2/2016.
 */
public abstract class BaseActivity extends ActionBarActivity {

    protected Activity mActivity;
    protected Context mContext;

    protected DrawerLayout mDrawerLayout;
    protected ActionBar mActionBar;
    protected Toolbar mToolbar;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivity = this;
        mContext = getApplicationContext();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

            w.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    protected void initDrawerLayout() {
        // TODO: in v1.0 action bar is not integrated
        //mDrawerLayout = (DrawerLayout) findViewById(R.id.my_drawer_layout);
        //mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
    }

    protected void initActionBar() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
        }

        mActionBar = getSupportActionBar();
    }

    protected void enableSetDisplayHomeAsUpEnabled() {
        if (mToolbar != null) {
            mActionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    protected void disableSetDisplayHomeAsUpEnabled() {
        if (mToolbar != null) {
            mActionBar.setDisplayHomeAsUpEnabled(false);
        }
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @SuppressLint("NewApi")
    protected void openNewActivity(final Class<?> cls,final boolean useDefaultAnimation,
                                   final boolean closeCurrentActivity) {
        try {
            startActivity(new Intent(mContext, cls));
            if (useDefaultAnimation) {
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
            if (closeCurrentActivity) {
                this.finish();
            }
        }catch (Exception e){
            Log.wtf("TAG", e.getMessage());
        }
    }
}
