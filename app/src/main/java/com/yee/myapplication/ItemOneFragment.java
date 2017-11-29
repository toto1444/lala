package com.yee.myapplication;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.Toast;

public class ItemOneFragment extends Fragment {
    public static ItemOneFragment newInstance() {
        ItemOneFragment fragment = new ItemOneFragment();
        return fragment;
    }
    private boolean mIsFullscreen = false;
    final static boolean IsDebugging = false;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);//	private static final String TAG = "SVGViewerActivity";
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            Intent intent = getIntent();
            Uri data = intent.getData();
            //Log.v(TAG, "data=" + data);

            if (data != null && data.toString().indexOf("file") > -1) {
                WebView webview = (WebView) findViewById(R.id.webView1);
                webview.loadUrl(data.toString());
                webview.getSettings().setBuiltInZoomControls(true);
                webview.getSettings().setDisplayZoomControls(false);
                webview.getSettings().setUseWideViewPort(true);
                //webview.zoomOut();
            }

        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.activity_main, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle item selection
            switch (item.getItemId()) {
                case R.id.menu_zoom_fit:
                    toggleFullscreen();
                    return true;
            }
            if(IsDebugging)
                Log.v("svg viewer", "selected menu item about to return super");
            return super.onOptionsItemSelected(item);
        }

        @Override
        public void onBackPressed() {
            if(IsDebugging)
                Log.v("svg viewer", "onBackPressed");
            if (mIsFullscreen) {
                toggleFullscreen();
            } else {
                super.onBackPressed();
			/*
			// TODO think about implementing 'press back again to exit' here
			Intent intent = new Intent(Intent.ACTION_MAIN);
			intent.addCategory(Intent.CATEGORY_HOME);
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(intent);
			*/
            }
        }

        @SuppressLint("InlinedApi")
        private void toggleFullscreen()
        {
            if(IsDebugging)
                Log.v("svg viewer", "about to toggle fullscreen");
            ActionBar actionBar = getActionBar();
            if (!mIsFullscreen) {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH){
                    getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE);
                }
                actionBar.hide();
                if(IsDebugging)
                    Log.v("svg viewer", "set fullscreen");
                mIsFullscreen = true;
                Toast.makeText(getApplicationContext(), R.string.disable_fullscreen_toast, Toast.LENGTH_SHORT).show();
            } else {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                if(Build.VERSION.SDK_INT > Build.VERSION_CODES.ICE_CREAM_SANDWICH){
                    getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
                }
                actionBar.show();
                if(IsDebugging)
                    Log.v("svg viewer", "remove fullscreen");
                mIsFullscreen = false;
            }
        }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_menu_one, container, false);
    }
}