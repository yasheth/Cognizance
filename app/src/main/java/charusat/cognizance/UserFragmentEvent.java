package charusat.cognizance;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import charusat.cognizance.events.EventHolder;
import charusat.cognizance.events.individual.EventsIndividualFragment;
import charusat.cognizance.events.listview.EventsListViewDepartmentFragment;

/**
 * Created by Harsh Shah on 27/08/2017.
 */

public class UserFragmentEvent extends EventsListViewDepartmentFragment
{
    static ArrayList<EventHolder> aaa;

    @Override
    public ArrayList<EventHolder> getArrayList()
    {
        return aaa;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.events_department_listview_parent, container, false);
        TextView tv = (TextView) v.findViewById(R.id.textAtTop);
        tv.setVisibility(View.VISIBLE);
        tv.setText("Registered Events");
        return v;
    }
    @Override
    public void onItemClick(View view, int position)
    {
        try
        {
            EventHolder eh = aaa.get(position);
            UserFragmentDetail eif = new UserFragmentDetail();
            eif.aaaa = aaa;
            eif.starting_position = position;
            Activity_Main am = (Activity_Main) getActivity();
            am.setFragment(eif);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    @Override
    public void setUpFireBaseOnChange()
    {
        //nothing
    }
}
