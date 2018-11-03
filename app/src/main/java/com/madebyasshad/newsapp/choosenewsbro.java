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
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardedVideoAd;

public class choosenewsbro extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private RewardedVideoAd mRewardedVideoAd;
    private AdView mAdView;

    TextView newsforapptopheadlineindia,newsforappbbcnewss,newsforappbbcsports,newsforappcbc,cnbc,newsforappespn,newsforappfoxnews,newsforappfoxsports,newsforappgooglenews,newsforappgooglenewssindia,newsforapphackernews,newsforappnbcnews,newsforappnewstwentyfour,newsforappnewscientist,newsforapptechcrunch,theeconomist,newsforappthenewyorktime,newsforappthetelgraph,timesofindia;

    Button searchforbtn;
    SearchView searchfortextedirtt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosenewsbro);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);




//    TextView ,,,
// ,,,,,
// ,,,
// ,,,,
// ,,,;
        searchfortextedirtt=findViewById(R.id.serchplease);
        searchforbtn=findViewById(R.id.searchpleasebutton);


        newsforapptopheadlineindia=findViewById(R.id.newsforapptopheadlineindia);
        newsforappbbcnewss=findViewById(R.id.newsforappbbcnewss);
        newsforappbbcsports=findViewById(R.id.newsforappbbcsports);
        newsforappcbc=findViewById(R.id.newsforappcbc);
        cnbc=findViewById(R.id.cnbc);
        newsforappespn=findViewById(R.id.newsforappespn);
        newsforappfoxnews=findViewById(R.id.newsforappfoxnews);
        newsforappfoxsports=findViewById(R.id.newsforappfoxsports);
        newsforappgooglenews=findViewById(R.id.newsforappgooglenews);
        newsforappgooglenewssindia=findViewById(R.id.newsforappgooglenewssindia);
        newsforapphackernews=findViewById(R.id.newsforapphackernews);
        newsforappnbcnews=findViewById(R.id.newsforappnbcnews);
        newsforappnewstwentyfour=findViewById(R.id.newsforappnewstwentyfour);
        newsforappnewscientist=findViewById(R.id.newsforappnewscientist);
        newsforapptechcrunch=findViewById(R.id.newsforapptechcrunch);
        theeconomist=findViewById(R.id.theeconomist);
        newsforappthenewyorktime=findViewById(R.id.newsforappthenewyorktime);
        newsforappthetelgraph=findViewById(R.id.newsforappthetelgraph);
        timesofindia=findViewById(R.id.timesofindia);






        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);




        MobileAds.initialize(getApplicationContext(),
                getString(R.string.admob_app_id));

        // Get reference to singleton RewardedVideoAd object
        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);


        // Load a reward based video ad
        mRewardedVideoAd.loadAd(getString(R.string.ad_unit_id), new AdRequest.Builder().build());



        newsforapptopheadlineindia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                i.putExtra("url","https://newsapi.org/v2/top-headlines?sources=google-news-in&apiKey=0bf33691eb6c439fa8bfe862bc6fe619");
                startActivity(i);
            }
        });












        newsforappbbcnewss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                i.putExtra("url","https://newsapi.org/v2/top-headlines?sources=bbc-news&apiKey=0bf33691eb6c439fa8bfe862bc6fe619");
                startActivity(i);
            }
        });










        newsforappbbcsports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                i.putExtra("url","https://newsapi.org/v2/top-headlines?sources=bbc-sport&apiKey=0bf33691eb6c439fa8bfe862bc6fe619");
                startActivity(i);
            }
        });










        newsforappcbc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                i.putExtra("url","https://newsapi.org/v2/top-headlines?sources=cbs-news&apiKey=0bf33691eb6c439fa8bfe862bc6fe619");
                startActivity(i);
            }
        });






        cnbc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                i.putExtra("url","https://newsapi.org/v2/top-headlines?sources=cnbc&apiKey=0bf33691eb6c439fa8bfe862bc6fe619");
                startActivity(i);
            }
        });










        newsforappespn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                i.putExtra("url","https://newsapi.org/v2/top-headlines?sources=espn&apiKey=0bf33691eb6c439fa8bfe862bc6fe619");
                startActivity(i);
            }
        });










        newsforappfoxsports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                i.putExtra("url","https://newsapi.org/v2/top-headlines?sources=fox-sports&apiKey=0bf33691eb6c439fa8bfe862bc6fe619");
                startActivity(i);
            }
        });










        newsforappfoxnews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                i.putExtra("url","https://newsapi.org/v2/top-headlines?sources=fox-news&apiKey=0bf33691eb6c439fa8bfe862bc6fe619");
                startActivity(i);
            }
        });








//https://newsapi.org/v2/top-headlines?sources=google-news&apiKey=0bf33691eb6c439fa8bfe862bc6fe619

        newsforappgooglenews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                i.putExtra("url","https://newsapi.org/v2/top-headlines?sources=google-news&apiKey=0bf33691eb6c439fa8bfe862bc6fe619");
                startActivity(i);
            }
        });











        newsforappgooglenewssindia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                i.putExtra("url","https://newsapi.org/v2/top-headlines?sources=google-news-in&apiKey=0bf33691eb6c439fa8bfe862bc6fe619");
                startActivity(i);
            }
        });










        newsforapphackernews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                i.putExtra("url","https://newsapi.org/v2/top-headlines?sources=hacker-news&apiKey=0bf33691eb6c439fa8bfe862bc6fe619");
                startActivity(i);
            }
        });










        newsforappnbcnews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                i.putExtra("url","https://newsapi.org/v2/top-headlines?sources=nbc-news&apiKey=0bf33691eb6c439fa8bfe862bc6fe619");
                startActivity(i);
            }
        });









        newsforappnewstwentyfour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                i.putExtra("url","https://newsapi.org/v2/top-headlines?sources=news24&apiKey=0bf33691eb6c439fa8bfe862bc6fe619");
                startActivity(i);
            }
        });






        newsforappnewscientist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                i.putExtra("url","https://newsapi.org/v2/top-headlines?sources=new-scientist&apiKey=0bf33691eb6c439fa8bfe862bc6fe619");
                startActivity(i);
            }
        });






        newsforapptechcrunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                i.putExtra("url","https://newsapi.org/v2/top-headlines?sources=techcrunch&apiKey=0bf33691eb6c439fa8bfe862bc6fe619");
                startActivity(i);
            }
        });




//     ,,,
// ,,,,,,
// ,
// ,,,,,
// ,,,;








        newsforappthenewyorktime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                i.putExtra("url","https://newsapi.org/v2/top-headlines?sources=the-new-york-times&apiKey=0bf33691eb6c439fa8bfe862bc6fe619");
                startActivity(i);
            }
        });






        newsforappthetelgraph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                i.putExtra("url","https://newsapi.org/v2/top-headlines?sources=the-telegraph&apiKey=0bf33691eb6c439fa8bfe862bc6fe619");
                startActivity(i);
            }
        });






        timesofindia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                i.putExtra("url","https://newsapi.org/v2/top-headlines?sources=the-times-of-india&apiKey=0bf33691eb6c439fa8bfe862bc6fe619");
                startActivity(i);
            }
        });











        theeconomist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                i.putExtra("url","https://newsapi.org/v2/top-headlines?sources=the-economist&apiKey=0bf33691eb6c439fa8bfe862bc6fe619");
                startActivity(i);
            }
        });

        searchforbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchtexed=searchfortextedirtt.getQuery().toString();
                if (searchtexed.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Please write Something", Toast.LENGTH_SHORT).show();

                }
                else
                {
                    Intent i=new Intent(getApplicationContext(),MainActivity.class);
                    //https://newsapi.org/v2/everything?q=bitcoin&apiKey=0bf33691eb6c439fa8bfe862bc6fe619
                    String baseurl="https://newsapi.org/v2/everything?q=";
                    String apikey="&apiKey=0bf33691eb6c439fa8bfe862bc6fe619";
                    String myurl=baseurl+searchtexed+apikey;
                    i.putExtra("url",myurl);
                    startActivity(i);



                }
            }
        });














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

        } else if (id == R.id.nav_contactus) {
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
        }

        else if(id==R.id.privacypolicy)
        {
            //privacypolicy
            showprivacy();
        }

        else if (id == R.id.ourotherapp) {


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
            Toast.makeText(getApplicationContext(),"Bad Network Connection",Toast.LENGTH_SHORT).show();
        }
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