package com.madebyasshad.newsapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

import static com.madebyasshad.newsapp.MainActivity.extra_url;

public class wewbviewintent extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AdView mAdView;
    private RewardedVideoAd mRewardedVideoAd;
    private InterstitialAd interstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wewbviewintent);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        Intent i = getIntent();
        String webadress = i.getStringExtra(extra_url);
        WebView browser = findViewById(R.id.webvieww);
        browser.setWebViewClient(new WebViewClient());
        browser.loadUrl(webadress);




        MobileAds.initialize(getApplicationContext(),
                getString(R.string.admob_app_id));

        // Get reference to singleton RewardedVideoAd object
        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);


        // Load a reward based video ad
        mRewardedVideoAd.loadAd(getString(R.string.ad_unit_id), new AdRequest.Builder().build());

        mRewardedVideoAd.setRewardedVideoAdListener(new RewardedVideoAdListener() {
            @Override
            public void onRewardedVideoAdLoaded() {

            }

            @Override
            public void onRewardedVideoAdOpened() {

            }

            @Override
            public void onRewardedVideoStarted() {

            }

            @Override
            public void onRewardedVideoAdClosed() {
                mRewardedVideoAd.loadAd(getString(R.string.ad_unit_id), new AdRequest.Builder().build());


            }

            @Override
            public void onRewarded(RewardItem rewardItem) {

//                Toast.makeText(wewbviewintent.this, "Tha", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRewardedVideoAdLeftApplication() {

            }

            @Override
            public void onRewardedVideoAdFailedToLoad(int i) {
                showinterstailad();

            }
        });
        interstitialAd=new InterstitialAd(this);
        interstitialAd.setAdUnitId(getString(R.string.interstial_ad_unit));


        loadinterstialad();

        interstitialAd.setAdListener(new AdListener()
        {
            @Override
            public void onAdClosed() {
                super.onAdClosed();
                loadinterstialad();
            }

            @Override
            public void onAdFailedToLoad(int i) {
                super.onAdFailedToLoad(i);
                showRewardedVideo();
            }
        });



    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
            showinterstailad();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

         if (id == R.id.mexit) {
//            Toast.makeText(getApplicationContext(), "PLEASE COME AGAIN", Toast.LENGTH_SHORT).show();

             showRewardedVideo();

             moveTaskToBack(true);
            return true;

        }


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_suggest) {
            try {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:" + "ashadnasim123@gmail.com"));
                intent.putExtra(Intent.EXTRA_SUBJECT, "Suggestions");
                intent.putExtra(Intent.EXTRA_TEXT, "");
                startActivity(intent);

            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "Please try after sometime", Toast.LENGTH_SHORT).show();
            }

        }
        else if(id==R.id.privacypolicy)
        {
            //privacypolicy
            showprivacy();
        }
        else if (id == R.id.nav_contactus) {
            try {

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:" + "ashadnasim123@gmail.com"));
                intent.putExtra(Intent.EXTRA_SUBJECT, "Contact");
                intent.putExtra(Intent.EXTRA_TEXT, "");
                startActivity(intent);
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "Please try after sometime", Toast.LENGTH_SHORT).show();

            }


        } else if (id == R.id.nav_share) {


            //whtsapp
            try {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, Uri.parse("Wow !\n" + "I am really enjoying this NEWS App and think you might like it too.Its Awesome and mind blowing  \n") + "http://play.google.com/store/apps/details?id=" + this.getPackageName());
                Intent ic = Intent.createChooser(intent, "Want to share with");
                startActivity(ic);
            } catch (Exception e) {


                Toast.makeText(getApplicationContext(), "Something wentss wrong ", Toast.LENGTH_SHORT).show();
            }


        } else if (id == R.id.rate) {
            try {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + this.getPackageName())));
            } catch (android.content.ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + this.getPackageName())));
            }
        } else if (id == R.id.ourotherapp) {


            try {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/developer?id=Ashad")));
            } catch (android.content.ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/developer?id=Ashad")));
            }

        } else if (id == R.id.weatherapp) {


            try {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.superoriginal.rootashadnasim.myweatherapp")));
            } catch (android.content.ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.superoriginal.rootashadnasim.myweatherapp")));
            }

        } else if (id == R.id.techfacts) {


            try {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=generalknowledge.app.all.ashad")));
            } catch (android.content.ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=generalknowledge.app.all.ashad")));
            }

        } else if (id == R.id.aboutus) {
            showinterstailad();
            Intent i = new Intent(getApplicationContext(), aboutuss.class);
            startActivity(i);

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void showRewardedVideo() {
        if (mRewardedVideoAd.isLoaded()) {
            mRewardedVideoAd.show();
        }
        else
        {
            showinterstailad();
//            Toast.makeText(getApplicationContext(),"Bad Network Connection",Toast.LENGTH_SHORT).show();
        }
    }


    private void loadinterstialad()
    {
        AdRequest adRequest=new AdRequest.Builder().build();
        interstitialAd.loadAd(adRequest);
    }
    private void showinterstailad()
    {
        if (!interstitialAd.isLoaded()){
//            showRewardedVideo();
        }
        interstitialAd.show();
    }



    private  void showprivacy()
    {

        WebView wb=new WebView(this);
        wb.loadUrl("https://sites.google.com/view/news-app/home");

        AlertDialog.Builder alert=new AlertDialog.Builder(this);

        alert.setView(wb)
                .setTitle("Loading...")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        alert.show();



    }
}