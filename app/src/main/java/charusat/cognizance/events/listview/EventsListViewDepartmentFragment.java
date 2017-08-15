package charusat.cognizance.events.listview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.events_department_listview_parent, container, false);
    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        final RecyclerView rv = (RecyclerView) view.findViewById(R.id.recycler_view);

        rv.setLayoutManager(new LinearLayoutManager(getContext()));

        ALEH = GetEvents.get(dept);
        EventsAdapterDepartment adapter = new EventsAdapterDepartment(getContext(), ALEH, R.layout.events_department_listview_child_material);

        adapter.setClickListener(this);
        rv.setAdapter(adapter);

        getActivity().setTitle(GetEvents.getFullForm(dept));
    }
    public void setDept(String dept)
    {
        EventsListViewDepartmentFragment.dept = dept;
        Log.i("DEPT set", dept);

    }

    @Override
    public void onItemClick(View view, int position)
    {
        EventHolder eh = ALEH.get(position);
        EventsIndividualFragment eif = new EventsIndividualFragment();
        eif.setDept(dept);
        eif.starting_position = position;
        Activity_Main am = (Activity_Main) getActivity();
        am.setFragment(eif);
    }
}
