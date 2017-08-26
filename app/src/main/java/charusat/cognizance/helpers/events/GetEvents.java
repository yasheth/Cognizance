package charusat.cognizance.helpers.events;

import android.content.Context;
import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

import charusat.cognizance.R;
import charusat.cognizance.events.DepartmentHolder;
import charusat.cognizance.events.EventHolder;

/**
 * Created by Yash on 8/14/2017.
 */

public class GetEvents
{
    public static Context c;
    static ArrayList<EventHolder> AL;


    static FirebaseDatabase database = FirebaseDatabase.getInstance();
    static DatabaseReference databaseReference = database.getReference().child("events_json");
    static {
        database.setPersistenceEnabled(true);
        databaseReference.keepSynced(true);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String s = dataSnapshot.getValue().toString();
                Log.wtf("H", s);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    public static ArrayList<EventHolder> get(String dept)
    {
        dept = dept.toLowerCase();

        if(AL==null) init();

        ArrayList<EventHolder> TEMP = new ArrayList<>();

        Log.i("Number", "" + AL.size());
        for (EventHolder eh: AL)
        {
            eh.dept = eh.dept.toLowerCase();
            if(eh.dept.equals(dept)) TEMP.add(eh);
        }
        return TEMP;
    }
    public static String readJSONFromFirebase(String ff)
    {
        String json = null;



        return json;
    }

    public static String readJSONFromAsset(String filename)
    {
        String json = null;
        try
        {
            InputStream is = c.getAssets().open(filename);
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

        try
        {
            String JSON = readJSONFromAsset("events.json");

            JSONObject jo = new JSONObject(JSON);
            Iterator<String> keys = jo.keys();

            while(keys.hasNext() )
            {
                String key = keys.next();

                if ( jo.get(key) instanceof JSONObject )
                {
                    AL.add(new EventHolder((JSONObject)jo.get(key)));
                }
                else
                {
                    Log.wtf("WTF", "Not instance of JSOBObject");
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    public static String getFullForm(String shortForm)
    {
        shortForm = shortForm.toLowerCase();
        switch (shortForm)
        {
            case "ce" : return "Computer \nEngineering";
            case "it" : return "Information \nTechnology";
            case "ec" : return "Electronics and \nCommunication";
            case "me" : return "Mechanical \nEngineering";
            case "ee" : return "Electrical \nEngineering";
            case "cl" : return "Civil \nEngineering";
            case "nt":  return "Non-Tech \nFun";
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
