package charusat.cognizance;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import charusat.cognizance.events.EventHolder;
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

    public UserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        czid = (EditText) view.findViewById(R.id.et_czid);
        mobile = (EditText) view.findViewById(R.id.et_cz_mobile);
        status = (Button) view.findViewById(R.id.bt_status);

        status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cz_id;
                String cz_mobile;
                String eventStr = "Events";
                cz_id = czid.getText().toString();
                cz_mobile = mobile.getText().toString();
                final String participant = cz_id+"_"+cz_mobile;
                Log.d(TAG, participant);

                participantRefer = databaseReference.child("participant").child(participant).child(eventStr);;
                ValueEventListener Listener = new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String re = dataSnapshot.getValue().toString();
                        String[] regEvents = re.split(",");
                        ArrayList<EventHolder> eventDetails = GetEvents.getByID((ArrayList<String>) Arrays.asList(regEvents));
                        Log.d(TAG, eventDetails.toString());
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                };
                participantRefer.addValueEventListener(Listener);

            }
        });

    }
}
