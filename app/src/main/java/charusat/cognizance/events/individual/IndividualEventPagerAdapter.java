package charusat.cognizance.events.individual;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.CardView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bluejamesbond.text.DocumentView;

import java.lang.reflect.Array;
import java.util.ArrayList;

import charusat.cognizance.R;
import charusat.cognizance.events.EventHolder;

/**
 * Created by Mit Patel on 8/18/2017.
 */

class IndividualEventPagerAdapter extends PagerAdapter
{

    Context mContext;
    LayoutInflater mLayoutInflater;
    private ArrayList<EventHolder> events;
    private int layout;

    public IndividualEventPagerAdapter(Context context, ArrayList<EventHolder> events, int layout)
    {
        mContext = context;
        this.events = events;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.layout = layout ;
    }

    @Override
    public int getCount() {
        return events.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((CardView) object);
    }

    private TextView title; //name
    private TextView one_line_description;
    private TextView date_time;
    private DocumentView detail_description;
    private TextView venue;
    private TextView rules;
    private TextView number_of_participants;
    private TextView fees;


    @Override
    public Object instantiateItem(ViewGroup container, int position)
    {
        View itemView = mLayoutInflater.inflate(layout, container, false);

        title = (TextView) itemView.findViewById(R.id.title);
        one_line_description = (TextView) itemView.findViewById(R.id.description_one_line);
        date_time = (TextView) itemView.findViewById(R.id.date_and_time);
        detail_description = (DocumentView) itemView.findViewById(R.id.detail_description);
        venue = (TextView) itemView.findViewById(R.id.venue_of_event);
        rules = (TextView) itemView.findViewById(R.id.rules);
        number_of_participants = (TextView) itemView.findViewById(R.id.number_of_participants);
        fees = (TextView) itemView.findViewById(R.id.fees);

        EventHolder event = events.get(position);

        title.setText(event.name);
        one_line_description.setText(Html.fromHtml(event.one_line_description));
        date_time.setText(event.date_time);
        detail_description.setText(Html.fromHtml(event.detail_description));
        venue.setText(event.venue);
        rules.setText(Html.fromHtml(event.rules));
        number_of_participants.setText(event.number_of_participants);
        fees.setText(Html.fromHtml(event.fees));



        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((CardView) object);
    }
}