package charusat.cognizance;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.TextView;

import org.w3c.dom.Text;

import charusat.cognizance.events.EventsFragment;
import charusat.cognizance.events.individual.EventsIndividualFragment;
import charusat.cognizance.events.listview.EventsListViewDepartmentFragment;
import charusat.cognizance.helpers.events.GetEvents;
import charusat.cognizance.home.HomeFragment;

import java.util.Vector;

public class Activity_Main extends AppCompatActivity
{
    TextView current_title;
    public Fragment cur_fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        current_title = (TextView) findViewById(R.id.current_title);
        GetEvents.c = getApplicationContext();
        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item)
                    {
                        Fragment selectedFragment = null;
                        switch (item.getItemId()) {
                            case R.id.menu_home:
                                selectedFragment = new HomeFragment();
                                break;
                            case R.id.menu_events:
                                selectedFragment = new EventsFragment();
                                break;
                            case R.id.menu_user:
                                selectedFragment = new UserFragment();
                                break;
                            case R.id.menu_query:
                                selectedFragment = new QueryFragment();
                                break;
                            case R.id.menu_team:
                                selectedFragment = new TeamFragment();
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
        cur_fragment = f;
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, f);
        transaction.commit();

    }
    @Override
    public void onBackPressed()
    {
        if(cur_fragment instanceof EventsIndividualFragment)
        {
            setFragment(new EventsListViewDepartmentFragment());
        }
        else if(cur_fragment instanceof EventsListViewDepartmentFragment)
        {
            setFragment(new EventsFragment());
        }
        else
        {
            super.onBackPressed();
        }
    }
}
