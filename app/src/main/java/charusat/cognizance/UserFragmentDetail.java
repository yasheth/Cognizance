package charusat.cognizance;

import android.util.Log;

import java.util.ArrayList;

import charusat.cognizance.events.EventHolder;
import charusat.cognizance.events.individual.EventsIndividualFragment;

/**
 * Created by Harsh Shah on 27/08/2017.
 */

public class UserFragmentDetail extends EventsIndividualFragment
{
    static public ArrayList<EventHolder> aaaa;
    @Override
    public void fb()
    {
        //Do nothing. Suddenly.
    }
    @Override
    public ArrayList<EventHolder> getal()
    {
        for (EventHolder eee: aaaa)
        {
            //Log.i("ABC", eee.one_line_description);

        }
        return aaaa;
    }
}
