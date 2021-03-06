package charusat.cognizance.home;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.AppCompatImageView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;
import charusat.cognizance.R;

/**
 * Created by Mit Patel on 8/18/2017.
 */

class CustomPagerAdapter extends PagerAdapter
{

    Context mContext;
    LayoutInflater mLayoutInflater;

    int[] mResources = {
            R.drawable.ss3,
            R.drawable.ss1,
            R.drawable.ss4,
            R.drawable.ss0,

    };

    public CustomPagerAdapter(Context context) {
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mResources.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position)
    {
        View itemView = mLayoutInflater.inflate(R.layout.pager_item, container, false);
        ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);
        Picasso.with(mContext).load(mResources[position]).into(imageView);
        //imageView.setImageResource(mResources[position]);
        Log.wtf("Setting Resource", "Pos " + position);
        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((AppCompatImageView) object);
    }
}