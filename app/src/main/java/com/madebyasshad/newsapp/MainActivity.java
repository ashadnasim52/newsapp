package com.madebyasshad.newsapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardedVideoAd;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, com.madebyasshad.newsapp.adapteritem.Onitemclicklistner {

    private AdView mAdView;
    private RewardedVideoAd mRewardedVideoAd;


    String url;
    public static final String extra_url="null";
    private RecyclerView mrecyclerview;
    private adapteritem adapteritem;
    private ArrayList<itemcalss> itemcalsses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        itemcalsses=new ArrayList<>();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        mrecyclerview=findViewById(R.id.recycler_view);
        mrecyclerview.setHasFixedSize(true);
        mrecyclerview.setLayoutManager(new LinearLayoutManager(this));



        parsejson();








        MobileAds.initialize(getApplicationContext(),
                getString(R.string.admob_app_id));

        // Get reference to singleton RewardedVideoAd object
        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);


        // Load a reward based video ad
        mRewardedVideoAd.loadAd(getString(R.string.ad_unit_id), new AdRequest.Builder().build());






    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
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
        if (id == R.id.action_settings) {
            Intent i=new Intent(getApplicationContext(),MainActivity.class).putExtra("url",url);
            startActivity(i);
            finish();
        }
        else if (id==R.id.mexit)
        {
            Toast.makeText(getApplicationContext(), "PLEASE COME AGAIN", Toast.LENGTH_SHORT).show();
            moveTaskToBack(true);
            return true;

        }
        else if (id==R.id.support)
        {
            showRewardedVideo();
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
                Intent intent = new Intent (Intent.ACTION_VIEW , Uri.parse("mailto:" + "ashadnasim123@gmail.com"));
                intent.putExtra(Intent.EXTRA_SUBJECT, "Suggestions");
                intent.putExtra(Intent.EXTRA_TEXT, "");
                startActivity(intent);

            }
            catch (Exception e)
            {
                Toast.makeText(getApplicationContext(),"Please try after sometime",Toast.LENGTH_SHORT).show();
            }

        }



        else if (id == R.id.nav_contactus) {
            try{

                Intent intent = new Intent (Intent.ACTION_VIEW , Uri.parse("mailto:" + "ashadnasim123@gmail.com"));
                intent.putExtra(Intent.EXTRA_SUBJECT, "Contact");
                intent.putExtra(Intent.EXTRA_TEXT, "");
                startActivity(intent);
            }
            catch (Exception e)
            {
                Toast.makeText(getApplicationContext(),"Please try after sometime",Toast.LENGTH_SHORT).show();

            }



        }  else if (id == R.id.nav_share) {


            //whtsapp
            try
            {
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT,Uri.parse("Wow !\n" +
                        "I am really enjoying this NEWS App and think you might like it too.Its Awesome and mind blowing  \n") + "http://play.google.com/store/apps/details?id="+this.getPackageName());
                Intent ic=Intent.createChooser(intent,"Want to share with");
                startActivity(ic);
            }
            catch (Exception e)
            {


                Toast.makeText(getApplicationContext(),"Something wentss wrong ",Toast.LENGTH_SHORT).show();
            }



        }

        else if (id==R.id.rate)
        {
            try {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id="+this.getPackageName()
                )));
            }
            catch (android.content.ActivityNotFoundException e)
            {
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("http://play.google.com/store/apps/details?id="+this.getPackageName())));
            }
        }
        else if (id==R.id.ourotherapp)
        {


            try {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/developer?id=Ashad")));
            }
            catch (android.content.ActivityNotFoundException e)
            {
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/apps/developer?id=Ashad")));
            }

        }
        else if (id==R.id.weatherapp)
        {


            try {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=com.superoriginal.rootashadnasim.myweatherapp")));
            }
            catch (android.content.ActivityNotFoundException e)
            {
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/apps/details?id=com.superoriginal.rootashadnasim.myweatherapp")));
            }

        }
        else if (id==R.id.techfacts)
        {


            try {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=generalknowledge.app.all.ashad")));
            }
            catch (android.content.ActivityNotFoundException e)
            {
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/apps/details?id=generalknowledge.app.all.ashad")));
            }

        }
        else if (id==R.id.aboutus)
        {
            Intent i=new Intent(getApplicationContext(),aboutuss.class);
            startActivity(i);

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }





    private void parsejson()
    {
        Intent in=getIntent();
        url=in.getStringExtra("url");
        //0bf33691eb6c439fa8bfe862bc6fe619
        //https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=API_KEY
//https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=0bf33691eb6c439fa8bfe862bc6fe619
        //https://newsapi.org/v2/everything?q=anime&sortBy=publishedAt&apiKey=0bf33691eb6c439fa8bfe862bc6fe619

        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.i("response","is"+response);
                try {
                    JSONArray jsonArray=response.getJSONArray("articles");
                    for (int i=0;i<jsonArray.length();i++)
                    {
                        JSONObject jsonObje=jsonArray.getJSONObject(i);
                        String author=jsonObje.getString("author");
                        String title=jsonObje.getString("title");
                        String description=jsonObje.getString("description");
                        String urltocontent=jsonObje.getString("url");
                        String urlofimage=jsonObje.getString("urlToImage");
                        String publishedat=jsonObje.getString("publishedAt");
                        Log.i("author","is "+description);
                        Log.i("author","is "+urltocontent);


                        itemcalsses.add(new itemcalss(title,description,urltocontent,urlofimage,publishedat,author));
                    }
                    // myAdapter = new mAdapter(getApplicationContext(), mylistofitem);
                    //                                mRecyclerView.setAdapter(myAdapter);
                    adapteritem=new adapteritem(itemcalsses,getApplicationContext());
                    mrecyclerview.setAdapter(adapteritem);
                    adapteritem.setonitemclicklistner(MainActivity.this);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //TODO show dailog or something
            }
        });
        mysingleton.getInstance(getApplicationContext()).addToRequestque(jsonObjectRequest);

    }


    @Override
    public void onitemclick(int position) {
        Intent i=new Intent(getApplicationContext(),wewbviewintent.class);
        itemcalss clickeditem=itemcalsses.get(position);
        i.putExtra(extra_url,clickeditem.getUrltocontent());
        startActivity(i);
    }







    public void showRewardedVideo() {
        if (mRewardedVideoAd.isLoaded()) {
            mRewardedVideoAd.show();
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Bad Network Connection",Toast.LENGTH_SHORT).show();
        }
    }


}
