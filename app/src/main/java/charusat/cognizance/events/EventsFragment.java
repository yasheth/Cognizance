package charusat.cognizance.events;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatDelegate;
import android.util.Log;
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

import charusat.cognizance.Activity_Main;
import charusat.cognizance.R;
import charusat.cognizance.events.listview.EventsListViewDepartmentFragment;


/**
 * Created by Yash on 8/10/2017.
 */

public class EventsFragment extends Fragment implements LinearLayout.OnClickListener
{
    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

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

        final NestedScrollView transitionsContainer = (NestedScrollView) view.findViewById(R.id.content_main);

        /*transitionsContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fm =  getActivity().getSupportFragmentManager().beginTransaction();

                Fragment f = new EventsInsideFragment();

                fm.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right);
                fm.replace(R.id.content_frame, f);
                ((MainActivity)getActivity()).setFragment(f);

                fm.commit();


            }
        });*/

        final LinearLayout ll_ce = (LinearLayout) view.findViewById(R.id.onclick_ce);
        final LinearLayout ll_it = (LinearLayout) view.findViewById(R.id.onclick_it);
        final LinearLayout ll_ec = (LinearLayout) view.findViewById(R.id.onclick_ec);
        final LinearLayout ll_ee = (LinearLayout) view.findViewById(R.id.onclick_electrical);
        final LinearLayout ll_me= (LinearLayout) view.findViewById(R.id.onclick_mechanical);
        final LinearLayout ll_cl = (LinearLayout) view.findViewById(R.id.onclick_civil);
        final LinearLayout ll_nt = (LinearLayout) view.findViewById(R.id.onclick_nontech);
        final LinearLayout ll_gl = (LinearLayout) view.findViewById(R.id.onclick_guestlectures);

        ll_ce.setOnClickListener(this);
        ll_it.setOnClickListener(this);
        ll_ec.setOnClickListener(this);
        ll_ee.setOnClickListener(this);
        ll_me.setOnClickListener(this);
        ll_cl.setOnClickListener(this);
        ll_nt.setOnClickListener(this);
        ll_gl.setOnClickListener(this);


        final ImageView iv_comp = (ImageView) view.findViewById(R.id.imageview_ce);
        final ImageView iv_it   = (ImageView) view.findViewById(R.id.imageview_it);
        final ImageView iv_ec   = (ImageView) view.findViewById(R.id.imageview_ec);
        final ImageView iv_ee   = (ImageView) view.findViewById(R.id.imageview_ee);
        final ImageView iv_me   = (ImageView) view.findViewById(R.id.imageview_me);
        final ImageView iv_cl   = (ImageView) view.findViewById(R.id.imageview_cl);
        final ImageView iv_nt   = (ImageView) view.findViewById(R.id.imageview_nt);
        final ImageView iv_gl   = (ImageView) view.findViewById(R.id.imageview_gl);


        Handler handler = new Handler();

        handler.postDelayed(new Runnable()
        {
            TransitionSet set = new TransitionSet()
                    //.addTransition(new Scale(0.0f))
                    .addTransition(new Fade(0))
                    .setInterpolator(new LinearInterpolator());

            void ppp(int drawable, final ImageView into)
            {
                Picasso.with(getContext()).load(drawable).into(into, new Callback() {
                    @Override
                    public void onSuccess() {
                        animate(into);
                    }
                    @Override
                    public void onError() {
                        Log.wtf("Error loading Image", "Error");
                    }
                });

            }
            @Override
            public void run()
            {
                ppp(R.drawable.computer, iv_comp);
                ppp(R.drawable.computer, iv_it);
                ppp(R.drawable.computer, iv_ec);
                ppp(R.drawable.computer, iv_ee);
                ppp(R.drawable.computer, iv_me);
                ppp(R.drawable.computer, iv_cl);
                ppp(R.drawable.computer, iv_nt);
                ppp(R.drawable.computer, iv_gl);
            }
            void animate(ImageView iv)
            {
                TransitionManager.beginDelayedTransition(transitionsContainer, set);
                iv.setVisibility(View.VISIBLE);
            }
        }, 0);

        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("EVENTS");
    }

    @Override
    public void onClick(View v)
    {
        Activity_Main am = (Activity_Main) getActivity();

        EventsListViewDepartmentFragment ff = new EventsListViewDepartmentFragment();

        //Intent i = new Intent();
        //i.setClass(getContext(), EventsListViewDepartmentFragment.class);

        String dep = "";

        switch (v.getId())
        {
            case R.id.onclick_ce:
                dep = "ce";
                break;
            case R.id.onclick_it:
                dep = "it";
                break;
            case R.id.onclick_mechanical:
                dep = "me";
                break;
            case R.id.onclick_electrical:
                dep = "ee";
                break;
            case R.id.onclick_civil:
                dep = "cl";
                break;
            case R.id.onclick_ec:
                dep = "ec";
                break;
            case R.id.onclick_nontech:
                dep = "nt";
                break;
            case R.id.onclick_guestlectures:
                dep = "gl";
                break;
        }
        ff.setDept(dep);
        am.setFragment(ff);

        //i.putExtra("department", dep);
        //startActivity(i);
    }
}
