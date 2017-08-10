package charusat.cognizance.helpers;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;

/**
 * Created by Yash on 7/23/2017.
 */

public class ConstraintLayoutOutlined extends ConstraintLayout
{
    Paint paint;

    public ConstraintLayoutOutlined(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
        setWillNotDraw(false) ;
        paint = new Paint();
    }
    public ConstraintLayoutOutlined(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
        setWillNotDraw(false) ;
        paint = new Paint();
    }
    @Override
    protected void onDraw(Canvas canvas) {
        /*
        Paint fillPaint = paint;
        fillPaint.setARGB(255, 0, 255, 0);
        fillPaint.setStyle(Paint.Style.FILL);
        canvas.drawPaint(fillPaint) ;
        */

        Paint strokePaint = paint;
        strokePaint.setARGB(255, 255, 0, 0);
        strokePaint.setStyle(Paint.Style.STROKE);
        strokePaint.setStrokeWidth(2);
        Rect r = canvas.getClipBounds() ;
        Rect outline = new Rect( 1,1,r.right-1, r.bottom-1) ;
        canvas.drawRect(outline, strokePaint) ;
    }

}
