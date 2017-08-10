package charusat.cognizance.events;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatDelegate;
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
import com.transitionseverywhere.extra.Scale;

import charusat.cognizance.R;


/**
 * Created by Yash on 8/10/2017.
 */

public class EventsFragment extends Fragment
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

        final ImageView iv_comp = (ImageView) view.findViewById(R.id.imageview_ce);
        final ImageView iv_it   = (ImageView) view.findViewById(R.id.imageview_it);
        final ImageView iv_ec   = (ImageView) view.findViewById(R.id.imageview_ec);
        final ImageView iv_ee   = (ImageView) view.findViewById(R.id.imageview_ee);
        final ImageView iv_me   = (ImageView) view.findViewById(R.id.imageview_me);
        final ImageView iv_cl   = (ImageView) view.findViewById(R.id.imageview_cl);

        Handler handler = new Handler();


        handler.postDelayed(new Runnable()
        {
            TransitionSet set = new TransitionSet()
                    .addTransition(new Scale(0.0f))
                    .addTransition(new Fade())
                    .setInterpolator(new LinearInterpolator());

            @Override
            public void run()
            {

                Picasso.with(getContext()).load(R.drawable.computer).into(iv_comp, new Callback() {
                    @Override
                    public void onSuccess() {

                        animate(iv_comp);
                    }
                    @Override
                    public void onError() {

                    }
                });

                Picasso.with(getContext()).load(R.drawable.computer).into(iv_it, new Callback() {
                    @Override
                    public void onSuccess() {
                        animate(iv_it);
                    }

                    @Override
                    public void onError() {

                    }
                });
                Picasso.with(getContext()).load(R.drawable.computer).into(iv_ec, new Callback() {
                    @Override
                    public void onSuccess() {
                        animate(iv_ec);
                    }

                    @Override
                    public void onError() {

                    }
                });
                Picasso.with(getContext()).load(R.drawable.computer).into(iv_ee, new Callback() {
                    @Override
                    public void onSuccess() {
                        animate(iv_ee);
                    }

                    @Override
                    public void onError() {

                    }
                });
                Picasso.with(getContext()).load(R.drawable.computer).into(iv_me, new Callback() {
                    @Override
                    public void onSuccess() {
                        animate(iv_me);
                    }

                    @Override
                    public void onError() {

                    }
                });
                Picasso.with(getContext()).load(R.drawable.computer).into(iv_cl, new Callback() {
                    @Override
                    public void onSuccess() {
                        animate(iv_cl);
                    }

                    @Override
                    public void onError() {

                    }
                });


            }
            public void animate(ImageView iv)
            {

                TransitionManager.beginDelayedTransition(transitionsContainer, set);
                iv.setVisibility(View.VISIBLE);

            }
        }, 150);


        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Events");


    }
}
