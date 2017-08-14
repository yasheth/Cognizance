package charusat.cognizance.events.listview;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import charusat.cognizance.R;
import charusat.cognizance.helpers.events.GetEvents;

/**
 * Created by Yash on 8/14/2017.
 */

public class EventsListViewDepartmentFragment extends Fragment implements EventsAdapterDepartment.ItemClickListener
{
    String dept;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.events_listview_department, container, false);
    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        final RecyclerView rv = (RecyclerView) view.findViewById(R.id.recycler_view);

        rv.setLayoutManager(new LinearLayoutManager(getContext()));

        EventsAdapterDepartment adapter = new EventsAdapterDepartment(getContext(),GetEvents.get(dept));

        adapter.setClickListener(this);
        rv.setAdapter(adapter);


        getActivity().setTitle(GetEvents.getFullForm(dept));
    }
    public void setDept(String dept)
    {
        this.dept = dept;
    }

    @Override
    public void onItemClick(View view, int position)
    {

    }
}
