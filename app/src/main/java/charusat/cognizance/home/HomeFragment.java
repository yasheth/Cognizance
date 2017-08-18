package charusat.cognizance.home;


import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;

import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

import java.util.Vector;

import charusat.cognizance.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    //RECYCLER VIEW FIELDS
    RecyclerView recyclerView,recyclerView2;


    //VECTOR FOR VIDEO URLS
    WebView webView, webView2;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //Load Videos of Youtube

        View v = inflater.inflate(R.layout.fragment_home, container, false);

        webView = (WebView) v.findViewById(R.id.webVideoView);
        webView2 = (WebView) v.findViewById(R.id.webVideoView2);

        String html1 = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/tvIu6sjQwls\" frameborder=\"0\" allowfullscreen></iframe>";
        String html2 = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/tT_IwZftGx8\" frameborder=\"0\" allowfullscreen></iframe>";

        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient() {});

        webView2.getSettings().setJavaScriptEnabled(true);
        webView2.setWebChromeClient(new WebChromeClient() {});

        webView.loadData(html1, "text/html", "utf-8");
        webView2.loadData(html2, "text/html", "utf-8");


        //SLIDE SHOW
        CustomPagerAdapter mCustomPagerAdapter = new CustomPagerAdapter(getContext());
        ViewPager mViewPager = (ViewPager) v.findViewById(R.id.pager);
        mViewPager.setAdapter(mCustomPagerAdapter);

        DotsIndicator dotsIndicator = (DotsIndicator) v.findViewById(R.id.dots_indicator);
        dotsIndicator.setViewPager(mViewPager);

        /*TabLayout tabLayout = (TabLayout) v.findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(mViewPager, true);*/

        //Twitter button implementation
        ImageButton twittbutton = (ImageButton) v.findViewById(R.id.twitter);
        twittbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://twitter.com/search?q=%23cognizance17&src=typd";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        //Share app button implementation
        ImageButton sharebutton = (ImageButton) v.findViewById(R.id.share);
        sharebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "Here is the share content body";
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));
            }
        });

        //Rate app button implement
        ImageButton ratebutton = (ImageButton) v.findViewById(R.id.rate);
        ratebutton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Code for Gujarat Board Practicle
                String url = "https://play.google.com/store/apps/details?id=com.yash.gujarat.board&hl=en";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);


                //Original code for Cognizance app
                /*Uri uri = Uri.parse("market://details?id=" + getContext().getPackageName());
                Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                // To count with Play market backstack, After pressing back button,
                // to taken back to our application, we need to add following flags to intent.
                goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                        Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                        Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                try {
                    startActivity(goToMarket);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            //Below link is for open our app in playstore
                             Uri.parse("http://play.google.com/store/apps/details?id=" + getContext().getPackageName())));
                }*/
            }
        });

        getActivity().setTitle("COGNIZANCE");
         return v;

       // return inflater.inflate(R.layout.fragment_home, container, false);
    }

}
