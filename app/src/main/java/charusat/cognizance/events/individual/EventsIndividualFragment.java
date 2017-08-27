package charusat.cognizance.events.individual;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tbuonomo.viewpagerdotsindicator.DotsIndicator;

import java.util.ArrayList;

import charusat.cognizance.R;
import charusat.cognizance.events.EventHolder;
import charusat.cognizance.events.listview.EventsAdapterDepartment;
import charusat.cognizance.events.listview.EventsListViewDepartmentFragment;
import charusat.cognizance.helpers.events.GetEvents;

/**
 * Created by Yash on 8/15/2017.
 */

public class EventsIndividualFragment extends EventsListViewDepartmentFragment
{
    public int starting_position=0;
    IndividualEventPagerAdapter mCustomPagerAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.events_individual_parent, container, false);
    }

    public ArrayList<EventHolder> getal()
    {
        ALEH = GetEvents.get(dept);

        return ALEH;
    }
    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState)
    {

        fb();
        mCustomPagerAdapter = new IndividualEventPagerAdapter(getContext(), getal(), R.layout.events_individual_child_material);
        ViewPager mViewPager = (ViewPager) view.findViewById(R.id.pager);
        mViewPager.setAdapter(mCustomPagerAdapter);

        DotsIndicator dotsIndicator = (DotsIndicator) view.findViewById(R.id.dots_indicator);
        mViewPager.setCurrentItem(starting_position);

        dotsIndicator.setViewPager(mViewPager);

        /*
        final RecyclerView rv = (RecyclerView) view.findViewById(R.id.recycler_view);

        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 1);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rv.setLayoutManager(layoutManager);

        SnapHelper helper = new LinearSnapHelper();
        helper.attachToRecyclerView(rv);


        adapter.setClickListener(this);
        rv.setAdapter(adapter);
        rv.scrollToPosition(starting_position);*/

        //getActivity().setTitle();
    }

    public void fb()
    {
        GetEvents.EventOnChangeListener onChangeListener= new GetEvents.EventOnChangeListener()
        {
            @Override
            public void onChange()
            {
                ALEH.clear();
                ALEH.addAll(GetEvents.get(dept));
                mCustomPagerAdapter.notifyDataSetChanged();
                Log.i("Onccc", "OnChange in Individual ListView");
            }
        };

        new GetEvents(onChangeListener);

    }

    @Override
    public void onItemClick(View view, int position)
    {

    }

}