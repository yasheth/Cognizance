package charusat.cognizance;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import org.codechimp.apprater.AppRater;

import charusat.cognizance.events.EventsFragment;
import charusat.cognizance.events.individual.EventsIndividualFragment;
import charusat.cognizance.events.listview.EventsListViewDepartmentFragment;
import charusat.cognizance.helpers.events.GetEvents;
import charusat.cognizance.home.HomeFragment;

public class Activity_Main extends AppCompatActivity
{
    public Fragment cur_fragment;
    TextView current_title;


    HomeFragment homeFragment;
    EventsFragment eventsFragment;
    UserFragment userFragment;
    QueryFragment queryFragment;
    TeamFragment teamFragment;

    UserFragmentEvent userFragmentEvent;
    UserFragmentDetail userFragmentDetail;
    EventsListViewDepartmentFragment eventsListViewDepartmentFragment;
    EventsIndividualFragment eventsIndividualFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        GetEvents.c = getApplicationContext();
        GetEvents.start();
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        current_title = (TextView) findViewById(R.id.current_title);

        AppRater.setNumDaysForRemindLater(1);
        AppRater.setDontRemindButtonVisible(false);
        AppRater.app_launched(this);


        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener()
                {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item)
                    {
                        Fragment selectedFragment = null;
                        switch (item.getItemId())
                        {
                            case R.id.menu_home:
                                if(homeFragment==null) homeFragment = new HomeFragment();
                                selectedFragment = homeFragment;
                                break;
                            case R.id.menu_events:
                                if(eventsFragment==null) eventsFragment = new EventsFragment();
                                selectedFragment = eventsFragment;
                                break;
                            case R.id.menu_user:
                                if(userFragment==null) userFragment = new UserFragment();
                                selectedFragment = userFragment;
                                break;
                            case R.id.menu_query:
                                if(queryFragment==null) queryFragment = new QueryFragment();
                                selectedFragment = queryFragment;
                                break;
                            case R.id.menu_team:
                                if(teamFragment==null) teamFragment = new TeamFragment();
                                selectedFragment = teamFragment;
                                break;
                        }
                        setFragment(selectedFragment);
                        return true;
                    }
                });

        setFragment(new HomeFragment());
        //Manually displaying the first fragment - one time only
        //Used to select an item programmatically
        //bottomNavigationView.getMenu().getItem(2).setChecked(true);
    }

    @Override
    public void setTitle(CharSequence title)
    {
        super.setTitle(title);
        current_title.setText(title);
    }

    public void setFragment(Fragment f)
    {
        getSupportFragmentManager().popBackStack();
        /*if(cur_fragment!=null)
        cur_fragment.onDestroy();*/
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();


        if(f!=null)
        {
            transaction.replace(R.id.frame_layout, f);
            transaction.commit();
            cur_fragment = f;
        }



    }
    @Override
    public void onBackPressed()
    {
        if(cur_fragment instanceof UserFragmentDetail)
        {
            setFragment(new UserFragmentEvent());
        }
        else if(cur_fragment instanceof UserFragmentEvent)
        {
            if(userFragment==null) userFragment = new UserFragment();
            setFragment(userFragment);
        }
        else if(cur_fragment instanceof EventsIndividualFragment)
        {
            setFragment(new EventsListViewDepartmentFragment());
        }
        else if(cur_fragment instanceof EventsListViewDepartmentFragment)
        {
            if(eventsFragment==null) eventsFragment = new EventsFragment();
            setFragment(eventsFragment);
        }
        else
        {
            super.onBackPressed();
        }
    }
}
