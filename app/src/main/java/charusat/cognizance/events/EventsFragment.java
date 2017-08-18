package charusat.cognizance.events;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.transitionseverywhere.Fade;
import com.transitionseverywhere.TransitionManager;
import com.transitionseverywhere.TransitionSet;

import java.util.ArrayList;

import charusat.cognizance.Activity_Main;
import charusat.cognizance.R;
import charusat.cognizance.events.listview.EventsListViewDepartmentFragment;
import charusat.cognizance.helpers.customview.PreCachingLayoutManager;
import charusat.cognizance.helpers.events.GetEvents;


/**
 * Created by Yash on 8/10/2017.
 */

public class EventsFragment extends Fragment/* implements LinearLayout.OnClickListener*/
{
    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    private RecyclerView recyclerView;
    ArrayList<DepartmentHolder> departments;
    private DepartmentAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_events, container, false);
    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState)
    {

        super.onViewCreated(view, savedInstanceState);

        //final NestedScrollView transitionsContainer = (NestedScrollView) view.findViewById(R.id.content_main);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        departments = GetEvents.getDepartments();

        adapter = new DepartmentAdapter(getContext(), departments, (Activity_Main) getActivity());

        adapter.setOnItemClickListener(new DepartmentAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View itemView, int position)
            {
                DepartmentHolder dh = departments.get(position);

                EventsListViewDepartmentFragment ff = new EventsListViewDepartmentFragment();
                ff.setDept(dh.sf);
                Log.i("DEPT", dh.sf);
                ((Activity_Main)getActivity()).setFragment(ff);

            }
        });
        //RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 2);

        PreCachingLayoutManager pc = new PreCachingLayoutManager(getContext(), 2);

        //recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setLayoutManager(pc);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        Handler handler = new Handler();

        handler.postDelayed(new Runnable()
        {
            @Override
            public void run()
            {

            }

        }, 0);

        //you can set the title for your toolbar here for different fragments different titles
        //getActivity().setTitle("EVENTS");
    }

    private int dpToPx(int dp)
    {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration
    {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }


    /*void animate(ImageView iv)
    {
        TransitionSet set = new TransitionSet()
                //.addTransition(new Scale(0.0f))
                .addTransition(new Fade(0))
                .setInterpolator(new LinearInterpolator());

        TransitionManager.beginDelayedTransition(transitionsContainer, set);
        iv.setVisibility(View.VISIBLE);
    }*/
    /*@Override
    public void onClick(View v)
    {
        Activity_Main am = (Activity_Main) getActivity();

        EventsListViewDepartmentFragment ff = new EventsListViewDepartmentFragment();

        //Intent i = new Intent();
        //i.setClass(getContext(), EventsListViewDepartmentFragment.class);

        //ff.setDept(dep);
        am.setFragment(ff);

        //i.putExtra("department", dep);
        //startActivity(i);
    }*/
}
