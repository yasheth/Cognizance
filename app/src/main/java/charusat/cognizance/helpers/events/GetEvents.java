package charusat.cognizance.helpers.events;

import android.app.usage.UsageEvents;
import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import charusat.cognizance.R;
import charusat.cognizance.events.DepartmentHolder;
import charusat.cognizance.events.EventHolder;

/**
 * Created by Yash on 8/14/2017.
 */

public class GetEvents
{
    static ArrayList<EventHolder> AL;
    public static Context c;

    public static ArrayList<EventHolder> get(String dept)
    {
        if(AL==null) init();
        ArrayList<EventHolder> TEMP = new ArrayList<>();
        for (EventHolder eh: AL)
        {
            if(eh.dept.equals(dept)) TEMP.add(eh);
        }
        return TEMP;
    }
    public static String readJSONFromAsset()
    {
        String json = null;
        try
        {
            InputStream is = c.getAssets().open("events.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
            return null;
        }
        Log.i("JSON", json);
        return json;
    }
    public static void init()
    {
        AL = new ArrayList<>();

        try {
            String JSON = readJSONFromAsset();
            JSONArray ja = new JSONArray(JSON);

            for (int i = 0, size = ja.length(); i < size; i++)
            {
                JSONObject event = ja.getJSONObject(i);
                AL.add(new EventHolder(event));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    public static String getFullForm(String shortForm)
    {
        switch (shortForm)
        {
            case "ce" : return "Computer \nEngineering";
            case "it" : return "Information \nTechnology";
            case "ec" : return "Electronics and \nCommunication";
            case "me" : return "Mechanical \nEngineering";
            case "ee" : return "Electrical \nEngineering";
            case "cl" : return "Civil \nEngineering";
            case "nt" : return "Non-Tech \nEvents";
            case "gl" : return "Guest \nLectures";
        }
        return "Events";
    }

    public static ArrayList<DepartmentHolder> getDepartments()
    {
        ArrayList<DepartmentHolder> dh = new ArrayList<>();

        DepartmentHolder d = new DepartmentHolder();
        d.sf = "nt";
        d.dept = getFullForm(d.sf);
        d.drawable_id = R.drawable.nt1;
        dh.add(d);

        d = new DepartmentHolder();
        d.sf = "gl";
        d.dept = getFullForm(d.sf);
        d.drawable_id = R.drawable.gl1;
        dh.add(d);

         d = new DepartmentHolder();
        d.sf = "ce";
        d.dept = getFullForm(d.sf);
        d.drawable_id = R.drawable.ce1;
        dh.add(d);

        d = new DepartmentHolder();
        d.sf = "it";
        d.dept = getFullForm(d.sf);
        d.drawable_id = R.drawable.it1;
        dh.add(d);


        d = new DepartmentHolder();
        d.sf = "ec";
        d.dept = getFullForm(d.sf);
        d.drawable_id = R.drawable.ec1;
        dh.add(d);


        d = new DepartmentHolder();
        d.sf = "ee";
        d.dept = getFullForm(d.sf);
        d.drawable_id = R.drawable.ee1;
        dh.add(d);


        d = new DepartmentHolder();
        d.sf = "me";
        d.dept = getFullForm(d.sf);
        d.drawable_id = R.drawable.me1;
        dh.add(d);


        d = new DepartmentHolder();
        d.sf = "cl";
        d.dept = getFullForm(d.sf);
        d.drawable_id = R.drawable.cl1;
        dh.add(d);


        return dh;
    }
}
