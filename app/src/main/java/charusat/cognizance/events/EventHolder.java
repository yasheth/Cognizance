package charusat.cognizance.events;

import org.json.JSONObject;

/**
 * Created by Yash on 8/10/2017.
 */

public class EventHolder
{
    public String name;
    public String dept;
    public String one_line_description;
    public String detail_description;
    public String date_time;
    public String venue;
    public String rules;
    public String number_of_participants;
    public String fees;
    public String eventID;

    JSONObject c;
    //String photo;

    public EventHolder(JSONObject cc)
    {
        this.c = cc;

        this.name = ggg("name");
        this.dept = ggg("dept");
        this.one_line_description = ggg("one_line_description");
        this.detail_description = ggg("detail_description");
        this.date_time = ggg("date_time");
        this.venue = ggg("venue");
        this.rules = ggg("rules");
        this.number_of_participants = ggg("number_of_participants") + " Participants";
        this.fees = ggg("fees");
        this.eventID = ggg("eventid");
    }
    private String ggg(String ss)
    {
        String str = "";
        if(c.has(ss))
        {
            try
            {
                str = c.getString(ss);
            }
            catch (Exception ignored)
            {

            }
        }
        return str;
    }

}
