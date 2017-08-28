package charusat.cognizance.events.listview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ScaleGestureDetectorCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import charusat.cognizance.Activity_Main;
import charusat.cognizance.R;
import charusat.cognizance.events.EventHolder;
import charusat.cognizance.events.individual.EventsIndividualFragment;
import charusat.cognizance.helpers.events.GetEvents;

/**
 * Created by Yash on 8/14/2017.
 */

public class EventsListViewDepartmentFragment extends Fragment implements EventsAdapterDepartment.ItemClickListener
{
    public static String dept;
    public ArrayList<EventHolder> ALEH;
    EventsAdapterDepartment adapter;

    public ArrayList<EventHolder> getArrayList()
    {
        ALEH = GetEvents.get(dept);
        return ALEH;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.events_department_listview_parent, container, false);
    }

   /* public ArrayList<EventHolder> getArrayList()
    {
        ALEH = GetEvents.get(dept);

        return ALEH;
    }*/

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        final RecyclerView rv = (RecyclerView) view.findViewById(R.id.recycler_view);

        rv.setLayoutManager(new LinearLayoutManager(getContext()));


        adapter = new EventsAdapterDepartment(getContext(), getArrayList(), R.layout.events_department_listview_child_material);

        setUpFireBaseOnChange();

        adapter.setClickListener(this);
        rv.setAdapter(adapter);

        //String fullform = GetEvents.getFullForm(dept);
        //Set Department Full Form.
        //getActivity().setTitle(GetEvents.getFullForm(dept));
    }

    public void setUpFireBaseOnChange()
    {
        GetEvents.EventOnChangeListener onChangeListener= new GetEvents.EventOnChangeListener()
        {
            @Override
            public void onChange()
            {
                ALEH.clear();
                ALEH.addAll(GetEvents.get(dept));
                adapter.notifyDataSetChanged();
                //Log.i("Onccc", "OnChange in Depart ListView");
            }
        };

        new GetEvents(onChangeListener);
    }

    public void setDept(String dept)
    {
        EventsListViewDepartmentFragment.dept = dept;
        //Log.i("DEPT set", dept);
    }

    @Override
    public void onItemClick(View view, int position)
    {
        try
        {
            EventHolder eh = ALEH.get(position);
            EventsIndividualFragment eif = new EventsIndividualFragment();
            eif.setDept(dept);
            eif.starting_position = position;
            Activity_Main am = (Activity_Main) getActivity();
            am.setFragment(eif);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
