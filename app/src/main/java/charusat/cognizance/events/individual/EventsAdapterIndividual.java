package charusat.cognizance.events.individual;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import charusat.cognizance.R;
import charusat.cognizance.events.EventHolder;
import charusat.cognizance.events.listview.EventsAdapterDepartment;

/**
 * Created by Yash on 8/15/2017.
 */

public class EventsAdapterIndividual extends RecyclerView.Adapter<EventsAdapterIndividual.ViewHolder>
{

    private ArrayList<EventHolder> events;
    private LayoutInflater mInflater;
    public EventsAdapterIndividual.ItemClickListener mClickListener;
    int layout;


    // data is passed into the constructor
    public EventsAdapterIndividual(Context context, ArrayList<EventHolder> events, int layout)
    {
        this.mInflater = LayoutInflater.from(context);
        this.events = events;
        this.layout = layout;
    }

    // inflates the cell layout from xml when needed
    @Override
    public EventsAdapterIndividual.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = mInflater.inflate(layout, parent, false);
        EventsAdapterIndividual.ViewHolder viewHolder = new EventsAdapterIndividual.ViewHolder(view);
        return viewHolder;
    }

    // binds the data to the textview in each cell
    @Override
    public void onBindViewHolder(EventsAdapterIndividual.ViewHolder holder, int position)
    {
        EventHolder event = events.get(position);

        holder.title.setText(event.name);
        holder.one_line_description.setText(event.one_line_description);
        holder.date_time.setText(event.date_time);
        holder.detail_description.setText(event.detail_description);
        holder.venue.setText(event.venue);
        holder.rules.setText(event.rules);
        holder.number_of_participants.setText(event.number_of_participants);
        holder.fees.setText(event.fees);

        //holder.myTextView.setText(animal);
    }

    // total number of cells
    @Override
    public int getItemCount()
    {
        return events.size();
    }

    // stores and recycles views as they are scrolled off screen
    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        private TextView title; //name
        private TextView one_line_description;
        private TextView date_time;
        private TextView detail_description;
        private TextView venue;
        private TextView rules;
        private TextView number_of_participants;
        private TextView fees;


        //public String name;
        //public String dept;
        //public String one_line_description;
        //public String detail_description;
        //public String date_time;
        //public String venue;
        //public String rules;
        //public String number_of_participants;
        //public String fees;

        //private CardView cv;

        private ViewHolder(View itemView)
        {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            one_line_description = (TextView) itemView.findViewById(R.id.description_one_line);
            date_time = (TextView) itemView.findViewById(R.id.date_and_time);
            detail_description = (TextView) itemView.findViewById(R.id.detail_description);
            venue = (TextView) itemView.findViewById(R.id.venue_of_event);
            rules = (TextView) itemView.findViewById(R.id.rules);
            number_of_participants = (TextView) itemView.findViewById(R.id.number_of_participants);
            fees = (TextView) itemView.findViewById(R.id.fees);


            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    EventHolder getItem(int id)
    {
        return events.get(id);
    }

    // allows clicks events_individual_parent to be caught
    public void setClickListener(EventsAdapterIndividual.ItemClickListener itemClickListener)
    {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events_individual_parent
    interface ItemClickListener
    {
        void onItemClick(View view, int position);
    }
}
