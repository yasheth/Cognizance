package charusat.cognizance.events.individual;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import charusat.cognizance.R;
import charusat.cognizance.events.listview.EventsAdapterDepartment;
import charusat.cognizance.events.listview.EventsListViewDepartmentFragment;
import charusat.cognizance.helpers.events.GetEvents;

/**
 * Created by Yash on 8/15/2017.
 */

public class EventsIndividualFragment extends EventsListViewDepartmentFragment
{
    public int starting_position=0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.events_individual_parent, container, false);
    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState)
    {
        final RecyclerView rv = (RecyclerView) view.findViewById(R.id.recycler_view);

        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 1);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rv.setLayoutManager(layoutManager);

        SnapHelper helper = new LinearSnapHelper();
        helper.attachToRecyclerView(rv);

        ALEH = GetEvents.get(dept);
        EventsAdapterDepartment adapter = new EventsAdapterDepartment(getContext(),ALEH, R.layout.events_individual_child_material);

        adapter.setClickListener(this);
        rv.setAdapter(adapter);
        rv.scrollToPosition(starting_position);

        //getActivity().setTitle();
    }
    @Override
    public void onItemClick(View view, int position)
    {

    }

    /*class SnappingGridLayoutManager extends GridLayoutManager {

        public SnappingGridLayoutManager(Context context, int spanCount) {
            super(context, spanCount);
        }

        @Override
        public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state,
                                           int position) {
            RecyclerView.SmoothScroller smoothScroller = new TopSnappedSmoothScroller(recyclerView.getContext());
            smoothScroller.setTargetPosition(position);
            startSmoothScroll(smoothScroller);
        }

        private class TopSnappedSmoothScroller extends LinearSmoothScroller {
            public TopSnappedSmoothScroller(Context context) {
                super(context);

            }

            @Override
            public PointF computeScrollVectorForPosition(int targetPosition) {
                return SnappingGridLayoutManager.this
                        .computeScrollVectorForPosition(targetPosition);
            }

            @Override
            protected int getVerticalSnapPreference() {
                return SNAP_TO_START;
            }
        }
    }*/

}