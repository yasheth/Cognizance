package charusat.cognizance.helpers.events;

import android.app.usage.UsageEvents;

import java.util.ArrayList;

import charusat.cognizance.events.EventHolder;

/**
 * Created by Yash on 8/14/2017.
 */

public class GetEvents
{
    static ArrayList<EventHolder> AL;

    public static ArrayList<EventHolder> get(String dept)
    {
        if(AL==null) init();
        ArrayList<EventHolder> TEMP = new ArrayList<>();
        for (EventHolder eh:
             AL)
        {
            if(eh.dept.equals(dept)) TEMP.add(eh);
        }
        return TEMP;
    }
    public static void init()
    {
        AL = new ArrayList<>();

        /* ALL CE EVENTS */
        EventHolder e1 = new EventHolder();
        e1.name = "C++ Coding Event";
        e1.one_line_description = "Here, participants will have to code and code and code whole day";
        e1.detail_description = "Here is a more detailed description for this event e1. Thank you for reanding this full desription. I hope i have not bored you.";
        e1.dept = "ce";
        e1.fees = "100";
        e1.number_of_participants = "2";
        e1.rules = "Internet access not allowed";
        e1.date_time = "14th September 2016";
        e1.venue = "CE Building, 306";
        AL.add(e1);


        e1 = new EventHolder();
        e1.name = "Debugify";
        e1.one_line_description = "Debug code and remove errors from code.";
        e1.detail_description = "Here is a more detailed description for this event e1. Thank you for reanding this full desription. I hope i have not bored you.";
        e1.dept = "ce";
        e1.fees = "100";
        e1.number_of_participants = "2";
        e1.rules = "Internet access not allowed";
        e1.date_time = "14th September 2016";
        e1.venue = "CE Building, 306";
        AL.add(e1);

        e1 = new EventHolder();
        e1.name = "Make Website";
        e1.one_line_description = "What language do you code on? HTML. Seriously ? Think once again :P.";
        e1.detail_description = "Here is a more detailed description for this event e1. Thank you for reanding this full desription. I hope i have not bored you.";
        e1.dept = "ce";
        e1.fees = "100";
        e1.number_of_participants = "2";
        e1.rules = "Internet access not allowed";
        e1.date_time = "14th September 2016";
        e1.venue = "CE Building, 306";
        AL.add(e1);

        /* ALL CE EVENTS END */


        /* ALL IT EVENTS */
        EventHolder e2 = new EventHolder();
        e2.name = "Information Technology Event 1";
        e2.one_line_description = "Here, participants will have to code and code and code whole day";
        e2.detail_description = "Here is a more detailed description for this event e1. Thank you for reanding this full desription. I hope i have not bored you.";
        e2.dept = "it";
        e2.fees = "100";
        e2.number_of_participants = "2";
        e2.rules = "Internet access not allowed";
        e2.date_time = "14th September 2016";
        e2.venue = "CE Building, 306";
        AL.add(e2);


        e1 = new EventHolder();
        e1.name = "Information Technology Event 2";
        e1.one_line_description = "Here, participants will have to code and code and code whole day";
        e1.detail_description = "Here is a more detailed description for this event e1. Thank you for reanding this full desription. I hope i have not bored you.";
        e1.dept = "it";
        e1.fees = "100";
        e1.number_of_participants = "2";
        e1.rules = "Internet access not allowed";
        e1.date_time = "14th September 2016";
        e1.venue = "CE Building, 306";
        AL.add(e1);

        e1 = new EventHolder();
        e1.name = "Information Technology Event 3";
        e1.one_line_description = "Here, participants will have to code and code and code whole day";
        e1.detail_description = "Here is a more detailed description for this event e1. Thank you for reanding this full desription. I hope i have not bored you.";
        e1.dept = "it";
        e1.fees = "100";
        e1.number_of_participants = "2";
        e1.rules = "Internet access not allowed";
        e1.date_time = "14th September 2016";
        e1.venue = "CE Building, 306";
        AL.add(e1);

        /* ALL IT EVENTS END */



        /* ALL EC EVENTS */
        EventHolder e3 = new EventHolder();
        e3.name = "EC Event 1";
        e3.one_line_description = "Here, participants will have to code and code and code whole day";
        e3.detail_description = "Here is a more detailed description for this event e1. Thank you for reanding this full desription. I hope i have not bored you.";
        e3.dept = "ec";
        e3.fees = "100";
        e3.number_of_participants = "2";
        e3.rules = "Internet access not allowed";
        e3.date_time = "14th September 2016";
        e3.venue = "CE Building, 306";
        AL.add(e3);


        e3 = new EventHolder();
        e3.name = "EC Event 2";
        e3.one_line_description = "Here, participants will have to code and code and code whole day";
        e3.detail_description = "Here is a more detailed description for this event e1. Thank you for reanding this full desription. I hope i have not bored you.";
        e3.dept = "ec";
        e3.fees = "100";
        e3.number_of_participants = "2";
        e3.rules = "Internet access not allowed";
        e3.date_time = "14th September 2016";
        e3.venue = "CE Building, 306";
        AL.add(e3);

        e3 = new EventHolder();
        e3.name = "EC Event 3";
        e3.one_line_description = "Here, participants will have to code and code and code whole day";
        e3.detail_description = "Here is a more detailed description for this event e1. Thank you for reanding this full desription. I hope i have not bored you.";
        e3.dept = "ec";
        e3.fees = "100";
        e3.number_of_participants = "2";
        e3.rules = "Internet access not allowed";
        e3.date_time = "14th September 2016";
        e3.venue = "CE Building, 306";
        AL.add(e3);

        /* ALL EC EVENTS END */



        /* ALL ME EVENTS */
        EventHolder e4 = new EventHolder();
        e4.name = "Mechanical Event 1";
        e4.one_line_description = "Here, participants will have to code and code and code whole day";
        e4.detail_description = "Here is a more detailed description for this event e1. Thank you for reanding this full desription. I hope i have not bored you.";
        e4.dept = "me";
        e4.fees = "100";
        e4.number_of_participants = "2";
        e4.rules = "Internet access not allowed";
        e4.date_time = "14th September 2016";
        e4.venue = "CE Building, 306";
        AL.add(e4);

        e4 = new EventHolder();
        e4.name = "Mechanical Event 2";
        e4.one_line_description = "Here, participants will have to code and code and code whole day";
        e4.detail_description = "Here is a more detailed description for this event e1. Thank you for reanding this full desription. I hope i have not bored you.";
        e4.dept = "me";
        e4.fees = "100";
        e4.number_of_participants = "2";
        e4.rules = "Internet access not allowed";
        e4.date_time = "14th September 2016";
        e4.venue = "CE Building, 306";
        AL.add(e4);

        e4 = new EventHolder();
        e4.name = "Mechanical Event 2";
        e4.one_line_description = "Here, participants will have to code and code and code whole day";
        e4.detail_description = "Here is a more detailed description for this event e1. Thank you for reanding this full desription. I hope i have not bored you.";
        e4.dept = "me";
        e4.fees = "100";
        e4.number_of_participants = "2";
        e4.rules = "Internet access not allowed";
        e4.date_time = "14th September 2016";
        e4.venue = "CE Building, 306";
        AL.add(e4);
        /* ALL ME EVENTS END */



        /* ALL CIVIL EVENTS */
        EventHolder e5 = new EventHolder();
        e5.name = "Civil Event 1";
        e5.one_line_description = "Here, participants will have to code and code and code whole day";
        e5.detail_description = "Here is a more detailed description for this event e1. Thank you for reanding this full desription. I hope i have not bored you.";
        e5.dept = "cl";
        e5.fees = "100";
        e5.number_of_participants = "2";
        e5.rules = "Internet access not allowed";
        e5.date_time = "14th September 2016";
        e5.venue = "CE Building, 306";
        AL.add(e5);


        e5 = new EventHolder();
        e5.name = "Civil Event 1";
        e5.one_line_description = "Here, participants will have to code and code and code whole day";
        e5.detail_description = "Here is a more detailed description for this event e1. Thank you for reanding this full desription. I hope i have not bored you.";
        e5.dept = "cl";
        e5.fees = "100";
        e5.number_of_participants = "2";
        e5.rules = "Internet access not allowed";
        e5.date_time = "14th September 2016";
        e5.venue = "CE Building, 306";
        AL.add(e5);

        e5 = new EventHolder();
        e5.name = "Civil Event 1";
        e5.one_line_description = "Here, participants will have to code and code and code whole day";
        e5.detail_description = "Here is a more detailed description for this event e1. Thank you for reanding this full desription. I hope i have not bored you.";
        e5.dept = "cl";
        e5.fees = "100";
        e5.number_of_participants = "2";
        e5.rules = "Internet access not allowed";
        e5.date_time = "14th September 2016";
        e5.venue = "CE Building, 306";
        AL.add(e5);

        /* ALL CIVIL EVENTS END */


        /* ALL EE EVENTS */
        EventHolder e6 = new EventHolder();
        e6.name = "C++ Coding Event";
        e6.one_line_description = "Here, participants will have to code and code and code whole day";
        e6.detail_description = "Here is a more detailed description for this event e1. Thank you for reanding this full desription. I hope i have not bored you.";
        e6.dept = "ee";
        e6.fees = "100";
        e6.number_of_participants = "2";
        e6.rules = "Internet access not allowed";
        e6.date_time = "14th September 2016";
        e6.venue = "CE Building, 306";
        AL.add(e6);

        e6 = new EventHolder();
        e6.name = "C++ Coding Event";
        e6.one_line_description = "Here, participants will have to code and code and code whole day";
        e6.detail_description = "Here is a more detailed description for this event e1. Thank you for reanding this full desription. I hope i have not bored you.";
        e6.dept = "ee";
        e6.fees = "100";
        e6.number_of_participants = "2";
        e6.rules = "Internet access not allowed";
        e6.date_time = "14th September 2016";
        e6.venue = "CE Building, 306";
        AL.add(e6);


        e6 = new EventHolder();
        e6.name = "C++ Coding Event";
        e6.one_line_description = "Here, participants will have to code and code and code whole day";
        e6.detail_description = "Here is a more detailed description for this event e1. Thank you for reanding this full desription. I hope i have not bored you.";
        e6.dept = "ee";
        e6.fees = "100";
        e6.number_of_participants = "2";
        e6.rules = "Internet access not allowed";
        e6.date_time = "14th September 2016";
        e6.venue = "CE Building, 306";
        AL.add(e6);

        /* ALL EE EVENTS END */


        /* ALL NON-TECH EVENTS */
        EventHolder e7 = new EventHolder();
        e7.name = "C++ Coding Event";
        e7.one_line_description = "Here, participants will have to code and code and code whole day";
        e7.detail_description = "Here is a more detailed description for this event e1. Thank you for reanding this full desription. I hope i have not bored you.";
        e7.dept = "nt";
        e7.fees = "100";
        e7.number_of_participants = "2";
        e7.rules = "Internet access not allowed";
        e7.date_time = "14th September 2016";
        e7.venue = "CE Building, 306";
        AL.add(e7);


        e7 = new EventHolder();
        e7.name = "C++ Coding Event";
        e7.one_line_description = "Here, participants will have to code and code and code whole day";
        e7.detail_description = "Here is a more detailed description for this event e1. Thank you for reanding this full desription. I hope i have not bored you.";
        e7.dept = "nt";
        e7.fees = "100";
        e7.number_of_participants = "2";
        e7.rules = "Internet access not allowed";
        e7.date_time = "14th September 2016";
        e7.venue = "CE Building, 306";
        AL.add(e7);

        e7 = new EventHolder();
        e7.name = "C++ Coding Event";
        e7.one_line_description = "Here, participants will have to code and code and code whole day";
        e7.detail_description = "Here is a more detailed description for this event e1. Thank you for reanding this full desription. I hope i have not bored you.";
        e7.dept = "nt";
        e7.fees = "100";
        e7.number_of_participants = "2";
        e7.rules = "Internet access not allowed";
        e7.date_time = "14th September 2016";
        e7.venue = "CE Building, 306";
        AL.add(e7);

        /* ALL NON-TECH EVENTS END */

        /* ALL GUEST LECTURES START */
        EventHolder e8 = new EventHolder();
        e8.name = "Elon Musk";
        e8.one_line_description = "Elon Musk will personally share with you his journey.";
        e8.detail_description = "Here is a more detailed description for this Guest Lecture. Thank you for reanding this full desription. I hope i have not bored you.";
        e8.dept = "gl";
        e8.fees = "100";
        e8.number_of_participants = "2";
        e8.rules = "Internet access not allowed";
        e8.date_time = "14th September 2016";
        e8.venue = "CE Building, 306";
        AL.add(e8);


        e8 = new EventHolder();
        e8.name = "Sandeep Maheshwari";
        e8.one_line_description = "Finally, somebody here to motivate us Engineers to do something productive in life";
        e8.detail_description = "Here is a more detailed description for this Guest Lecture. Thank you for reanding this full desription. I hope i have not bored you.";
        e8.dept = "gl";
        e8.fees = "100";
        e8.number_of_participants = "2";
        e8.rules = "Internet access not allowed";
        e8.date_time = "14th September 2016";
        e8.venue = "CE Building, 306";
        AL.add(e8);

        e8 = new EventHolder();
        e8.name = "Technical Guruji";
        e8.one_line_description = "Aapka swagat hai is Guest Lecture me. Chaliye shuru karte hain";
        e8.detail_description = "Here is a more detailed description for this event e1. Thank you for reanding this full desription. I hope i have not bored you.";
        e8.dept = "gl";
        e8.fees = "100";
        e8.number_of_participants = "2";
        e8.rules = "Internet access not allowed";
        e8.date_time = "14th September 2016";
        e8.venue = "CE Building, 306";
        AL.add(e8);

        /* ALL GUEST LECTURES END */

    }
    public static String getFullForm(String shortForm)
    {
        switch (shortForm)
        {
            case "ce" : return "Computer Engineering";
            case "it" : return "Information Technology";
            case "ec" : return "Electronics and Communication";
            case "me" : return "Mechanical Engineering";
            case "ee" : return "Electrical Engineering";
            case "cl" : return "Civil Engineering";
            case "nt" : return "Non-Tech";
            case "gl" : return "Guest Lectures";
        }
        return "Events";
    }
}
