package charusat.cognizance.home;


import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.net.URL;
import java.util.Vector;

import charusat.cognizance.R;
import charusat.cognizance.VideoAdapter;
import charusat.cognizance.VideoAdapter2;
import charusat.cognizance.YoutubeVideo;
import charusat.cognizance.YoutubeVideo2;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    //RECYCLER VIEW FIELD
    RecyclerView recyclerView,recyclerView2;


    //VECTOR FOR VIDEO URLS
    Vector<YoutubeVideo> youtubeVideos = new Vector<>();
    Vector<YoutubeVideo2> youtubeVideos2 = new Vector<>();




    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //Load Videos of Youtube

        View v = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        //Load video List
        youtubeVideos.add( new YoutubeVideo("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/tvIu6sjQwls\" frameborder=\"0\" allowfullscreen></iframe>"));

        recyclerView2 = (RecyclerView) v.findViewById(R.id.recyclerView2);
        recyclerView2.setHasFixedSize(true);
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext()));
        youtubeVideos2.add( new YoutubeVideo2("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/tT_IwZftGx8\" frameborder=\"0\" allowfullscreen></iframe>") );

        VideoAdapter videoAdapter = new VideoAdapter(youtubeVideos);
        VideoAdapter2 videoAdapter2 = new VideoAdapter2(youtubeVideos2);
        recyclerView.setAdapter(videoAdapter);
        recyclerView2.setAdapter(videoAdapter2);

        //Twitter button implementation
        Button twittbutton = (Button) v.findViewById(R.id.twitt);
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
        Button sharebutton = (Button) v.findViewById(R.id.shareapp);
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
        Button ratebutton = (Button) v.findViewById(R.id.rate);
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


         return v;
        //getActivity().setTitle("COGNIZANCE");
       // return inflater.inflate(R.layout.fragment_home, container, false);
    }

}
