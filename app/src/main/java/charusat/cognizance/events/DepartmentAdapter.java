package charusat.cognizance.events;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

import charusat.cognizance.Activity_Main;
import charusat.cognizance.R;
import charusat.cognizance.events.listview.EventsListViewDepartmentFragment;

/**
 * Created by Yash on 8/14/2017.
 */

public class DepartmentAdapter extends RecyclerView.Adapter<DepartmentAdapter.MyViewHolder>
{
    private Context mContext;
    private List<DepartmentHolder> deptList;
    private Activity_Main am;
    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        public TextView title;
        public ImageView thumbnail;
        public LinearLayout mll;

        public MyViewHolder(View view)
        {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            mll = (LinearLayout) view.findViewById(R.id.main_linear_layout);
        }
    }


    public DepartmentAdapter(Context mContext, List<DepartmentHolder> deptList, Activity_Main am)
    {
        this.mContext = mContext;
        this.deptList = deptList;
        this.am = am;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.department_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position)
    {
        DepartmentHolder department = deptList.get(position);
        holder.title.setText(department.dept);

        holder.mll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                EventsListViewDepartmentFragment ff = new EventsListViewDepartmentFragment();
                ff.setDept(deptList.get(position).sf);
                am.setFragment(ff);
            }
        });
        picasso_load(department.drawable_id, holder.thumbnail);
    }
    private void picasso_load(int drawable, final ImageView into)
    {

        Picasso.with(mContext).load(drawable).into(into, new Callback() {
            @Override
            public void onSuccess() {
                //animate(into);
            }
            @Override
            public void onError() {
                Log.wtf("Error loading Image", "Error");
            }
        });

    }

    /*/**
     * Showing popup menu when tapping on 3 dots

    private void showPopupMenu(View view) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_album, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
    }*/

    /**
     * Click listener for popup menu items
     */
    /*class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_add_favourite:
                    Toast.makeText(mContext, "Add to favourite", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_play_next:
                    Toast.makeText(mContext, "Play next", Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }
    }*/

    @Override
    public int getItemCount() {
        return deptList.size();
    }
}
