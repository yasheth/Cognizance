package charusat.cognizance;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class QueryFragment extends Fragment
{
    Button sub;

    public QueryFragment()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_query, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        sub = (Button) view.findViewById(R.id.send_query);
        final EditText et_subject = (EditText) view.findViewById(R.id.et_subject);
        final EditText et_query = (EditText) view.findViewById(R.id.et_query);

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);


                Intent send = new Intent(Intent.ACTION_SENDTO);
                String uriText = "mailto:" + Uri.encode("cognizanceteam@gmail.com") +
                        "?subject=" + Uri.encode(et_subject.getText().toString()) +
                        "&body=" + Uri.encode(et_query.getText().toString());
                Uri uri = Uri.parse(uriText);

                send.setData(uri);
                startActivity(Intent.createChooser(send, "Send mail..."));


                /*String aEmailList[] = { "cognizanceteam@gmail.com"};
                //String aEmailCCList[] = { "",""};
                //String aEmailBCCList[] = { "" };

                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, aEmailList);
                //emailIntent.putExtra(android.content.Intent.EXTRA_CC, aEmailCCList);
                //emailIntent.putExtra(android.content.Intent.EXTRA_BCC, aEmailBCCList);
                emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, et_subject.getText().toString());

                emailIntent.setType("message/rfc822");

                //emailIntent.setType("plain/text");
                emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, et_query.getText().toString());

                startActivity(emailIntent);*/

            }
        });
    }
}
