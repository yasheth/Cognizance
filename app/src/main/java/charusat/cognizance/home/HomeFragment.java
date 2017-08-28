package charusat.cognizance.home;


import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

import java.util.Timer;
import java.util.TimerTask;

import charusat.cognizance.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    //RECYCLER VIEW FIELDS
    RecyclerView recyclerView,recyclerView2;
    ImageView Par;
    ImageView c, c1;
    //VECTOR FOR VIDEO URLS
    WebView webView, webView1;

    public HomeFragment()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        // Inflate the layout for this fragment
        //Load Videos of Youtube

        Par = (ImageView) v.findViewById(R.id.iv_paroma);
        Picasso.with(getContext()).load(R.drawable.paroma).into(Par);

        c = (ImageView) v.findViewById(R.id.iv_cognizance);
        Picasso.with(getContext()).load(R.drawable.cognizancemain).into(c);

        c = (ImageView) v.findViewById(R.id.iv_cognizance1);
        Picasso.with(getContext()).load(R.drawable.h1).into(c);

        c = (ImageView) v.findViewById(R.id.iv_cognizance2);
        Picasso.with(getContext()).load(R.drawable.cognizance2).into(c);

        ConnectivityManager connec = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connec != null && (
                (connec.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) ||
                        (connec.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED))) {

            //You are connected, do something online.
            webView = (WebView) v.findViewById(R.id.webVideoView);
            webView1 = (WebView) v.findViewById(R.id.webVideoView1);

            webView.setVisibility(View.VISIBLE);
            webView1.setVisibility(View.VISIBLE);
            String html = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/tvIu6sjQwls\" frameborder=\"0\" allowfullscreen></iframe>";
            String html1 = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/0RoNxhYn404\" frameborder=\"0\" allowfullscreen></iframe>";

            webView.getSettings().setJavaScriptEnabled(true);
            webView.setWebChromeClient(new WebChromeClient() {
            });
            webView1.getSettings().setJavaScriptEnabled(true);
            webView1.setWebChromeClient(new WebChromeClient() {
            });

            webView.loadData(html, "text/html", "utf-8");
            webView1.loadData(html1, "text/html", "utf-8");


        } else if (connec != null && (
                (connec.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.DISCONNECTED) ||
                        (connec.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.DISCONNECTED))) {

            //Not connected.
            //Toast.makeText(getActivity().getApplicationContext(), "You must be connected to the internet to view Video", Toast.LENGTH_LONG).show();
            ImageView iv = (ImageView) v.findViewById(R.id.video_TV);
            ImageView iv1 = (ImageView) v.findViewById(R.id.video_TV1);
            iv.setVisibility(View.VISIBLE);
            iv1.setVisibility(View.VISIBLE);
        }



        setUpPager(v);


        ImageButton fbbutton = (ImageButton) v.findViewById(R.id.fb);
        fbbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.facebook.com/czCHARUSAT/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        ImageButton webbutton = (ImageButton) v.findViewById(R.id.web);
        webbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://www.cognizance17.com/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        ImageButton instabutton = (ImageButton) v.findViewById(R.id.insta);
        instabutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://www.instagram.com/cognizance_charusat/";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        /*TabLayout tabLayout = (TabLayout) v.findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(mViewPager, true);*/

        //Twitter button implementation
//        ImageView tweetbutton = (ImageView) v.findViewById(R.id.twitter);
//        tweetbutton
//                .setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String url = "https://twitter.com/search?q=%23cognizance17&src=typd";
//
//                Intent i = new Intent(Intent.ACTION_VIEW);
//                i.setData(Uri.parse(url));
//                startActivity(i);
//            }
//        });


        //Share app button implementation
//        ImageButton sharebutton = (ImageButton) v.findViewById(R.id.share);
//        sharebutton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
//                sharingIntent.setType("text/plain");
//                String shareBody = "Cognizance The Techfest of CHARUSAT. Download now from ";
//                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
//                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
//                startActivity(Intent.createChooser(sharingIntent, "Share via"));
//            }
//        });

        //Rate app button implement
//        ImageButton ratebutton = (ImageButton) v.findViewById(R.id.rate);
//        ratebutton.setOnClickListener( new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //Code for Gujarat Board Practicle
//                String url = "https://play.google.com/store/apps/details?id=com.yash.gujarat.board&hl=en";
//
//                Intent i = new Intent(Intent.ACTION_VIEW);
//                i.setData(Uri.parse(url));
//                startActivity(i);
//
//
//                //Original code for Cognizance app
//                /*Uri uri = Uri.parse("market://details?id=" + getContext().getPackageName());
//                Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
//                // To count with Play market backstack, After pressing back button,
//                // to taken back to our application, we need to add following flags to intent.
//                goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
//                        Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
//                        Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
//                try {
//                    startActivity(goToMarket);
//                } catch (ActivityNotFoundException e) {
//                    startActivity(new Intent(Intent.ACTION_VIEW,
//                            //Below link is for open our app in playstore
//                             Uri.parse("http://play.google.com/store/apps/details?id=" + getContext().getPackageName())));
//                }*/
//            }
//        });

        getActivity().setTitle("COGNIZANCE");
         return v;

       // return inflater.inflate(R.layout.fragment_home, container, false);
    }

    public void setUpPager(View v)
    {
        //SLIDE SHOW
        CustomPagerAdapter mCustomPagerAdapter = new CustomPagerAdapter(getContext());
        final ViewPager mViewPager = (ViewPager) v.findViewById(R.id.pager);
        mViewPager.setAdapter(mCustomPagerAdapter);

        DotsIndicator dotsIndicator = (DotsIndicator) v.findViewById(R.id.dots_indicator);
        dotsIndicator.setViewPager(mViewPager);

        Timer timer;
        final long DELAY_MS = 500;//delay in milliseconds before task is to be executed
        final long PERIOD_MS = 5000; // time in milliseconds between successive task executions.*/


        //After setting the adapter use the timer */
        final Handler handler = new Handler();
        final int NUM_PAGES = mCustomPagerAdapter.getCount();
        Log.i("NUM_PAGES", "" +NUM_PAGES);
        final int[] currentPage = {0};

        final Runnable Update = new Runnable()
        {

            public void run()
            {
                Log.i("Inside run", "true");
                Log.i("Current Page" , "" + currentPage[0]);
                if (currentPage[0] == NUM_PAGES)
                {
                    currentPage[0] = 0;
                }

                mViewPager.setCurrentItem(currentPage[0]++, true);
            }
        };

        timer = new Timer(); // This will create a new Thread
        timer.schedule(new TimerTask() { // task to be scheduled

            @Override
            public void run() {
                handler.post(Update);
            }
        }, DELAY_MS, PERIOD_MS);

    }

    public void setUpWebView()
    {
        /*final String offlineMessageHtml = "DEFINE THIS";
        final String timeoutMessageHtml = "DEFINE THIS";

        WebView browser = (WebView) findViewById(R.id.webview);
        browser.setNetworkAvailable(isConnected);
        browser.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (isConnected) {
                    // return false to let the WebView handle the URL
                    return false;
                } else {
                    // show the proper "not connected" message
                    view.loadData(offlineMessageHtml, "text/html", "utf-8");
                    // return true if the host application wants to leave the current
                    // WebView and handle the url itself
                    return true;
                }
            }
            @Override
            public void onReceivedError (WebView view, int errorCode,
                                         String description, String failingUrl) {
                if (errorCode == ERROR_TIMEOUT) {
                    view.stopLoading();  // may not be needed
                    view.loadData(timeoutMessageHtml, "text/html", "utf-8");
                }
            }
        });*/
        /*webView.setWebViewClient(new WebViewClient()
        {
            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error)
            {

                super.onReceivedError(view, request, error);
            }
        });*/


    }

}
