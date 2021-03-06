package charusat.cognizance.events;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bluejamesbond.text.DocumentView;

import java.util.ArrayList;

import charusat.cognizance.R;

/**
 * Created by Yash on 8/10/2017.
 */

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.ViewHolder>
{
    private ArrayList<EventHolder> events;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    int layout;


    // data is passed into the constructor
    public EventsAdapter(Context context, ArrayList<EventHolder> events, int layout)
    {
        this.mInflater = LayoutInflater.from(context);
        this.events = events;
        this.layout = layout;
    }

    // inflates the cell layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = mInflater.inflate(layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    // binds the data to the textview in each cell
    @Override
    public void onBindViewHolder(EventsAdapter.ViewHolder holder, int position)
    {
        EventHolder event = events.get(position);

        holder.title.setText(event.name);
        holder.desc.setText(event.one_line_description);

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
        private TextView title;
        private DocumentView desc;

        private ViewHolder(View itemView)
        {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            desc = (DocumentView) itemView.findViewById(R.id.description);
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
    void setClickListener(ItemClickListener itemClickListener)
    {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events_individual_parent
    interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
