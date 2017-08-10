package charusat.cognizance.events;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import charusat.cognizance.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class EventsInsideFragment extends Fragment implements EventsAdapter.ItemClickListener{


    RecyclerView recyclerView;

    private ArrayList<EventHolder> events;

    EventsAdapter eda;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.events_dep, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        getEvents();

        super.onViewCreated(view, savedInstanceState);

        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Events");

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        eda = new EventsAdapter(getContext(), events);

        LinearLayoutManager layoutManager = new GridLayoutManager(getContext(), 1);

        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        SnapHelper helper = new LinearSnapHelper();
        helper.attachToRecyclerView(recyclerView);

        eda.setClickListener(this);
        recyclerView.setAdapter(eda);

        recyclerView.setLayoutManager(layoutManager);

    }

    private void getEvents()
    {
        events = new ArrayList<>();

        String s = "Event Description- This event will be organised by Charusat's CSPIT CE Department. This is just a sample text to demonstrate how the event description will look like. Thank you for reading this. If you have coem this far for reading this, I surely did a good job.";

        for (int i = 0; i < 10; i++)
        {
            EventHolder eh = new EventHolder();
            eh.setName("Name " + i);
            eh.setDesctiption(s + "  " + i);

            events.add(eh);

        }
    }

    @Override
    public void onItemClick(View view, int position)
    {
        Log.i("TAG", "You clicked number " + eda.getItem(position) + ", which is at cell position " + position);
    }

}
