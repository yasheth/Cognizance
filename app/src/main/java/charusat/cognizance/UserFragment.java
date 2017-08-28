package charusat.cognizance;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import charusat.cognizance.events.EventHolder;
import charusat.cognizance.events.listview.EventsAdapterDepartment;
import charusat.cognizance.events.listview.EventsListViewDepartmentFragment;
import charusat.cognizance.helpers.events.GetEvents;


/**
 * A simple {@link Fragment} subclass.
 */
public class UserFragment extends Fragment {

    final String TAG = "Firebase";
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = database.getReference();
    DatabaseReference participantRefer;
    EditText czid;
    EditText mobile;
    Button status;
    EventsAdapterDepartment adapter;

    static String ccc_id = "";
    static String ccc_mobile = "";
    View v;
    ArrayList<EventHolder> eventDetails;

    public UserFragment()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        v = view;
        czid = (EditText) view.findViewById(R.id.et_czid);
        mobile = (EditText) view.findViewById(R.id.et_cz_mobile);
        status = (Button) view.findViewById(R.id.bt_status);

        if(!ccc_id.equals(""))
        {
            czid.setText(ccc_id);
        }
        if(!ccc_mobile.equals(""))
        {
            mobile.setText(ccc_mobile);
        }

        status.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                String eventStr = "Events";

                ccc_id = czid.getText().toString();
                ccc_mobile = mobile.getText().toString();

                final String participant = ccc_id + "_" + ccc_mobile;
                final String participantLowerCase = participant.toLowerCase();
                Log.d(TAG, participant);

                participantRefer = databaseReference.child("participant").child(participantLowerCase).child(eventStr);

                ValueEventListener Listener = new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot)
                    {
                        if(dataSnapshot.getValue() == null){

                            Toast.makeText(getContext(),"Invalid CZ ID / Password is Invalid",Toast.LENGTH_LONG).show();

                        } else{
                            String re = dataSnapshot.getValue().toString();
                            String[] regEvents = re.split(",");
                            Log.i("Events", Arrays.toString(regEvents));
                            ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(regEvents));
                            eventDetails = GetEvents.getByID(arrayList);

                            UserFragmentEvent ufe = new UserFragmentEvent();

                            ufe.aaa = eventDetails;


                            Activity_Main am = (Activity_Main)getActivity();
                            if(am!=null)
                                am.setFragment(ufe);

                            Log.d(TAG, eventDetails.toString());
                        }


                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError)
                    {

                    }
                };
                participantRefer.addValueEventListener(Listener);

            }


        });

    }

}
