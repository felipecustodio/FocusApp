package br.com.whatsappandroid.cursoandroid.focar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class FocoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foco);

        createCircle();
    }

    public void createCircle(){
        ImageView circle = (ImageView) findViewById(R.id.circle);
        int radius = 200;
        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#3ba6d8"));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(4);
        Bitmap bmp = Bitmap.createBitmap(500, 500, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bmp);
        canvas.drawCircle(bmp.getWidth()/2, bmp.getHeight()/2, radius, paint);
        circle.setImageBitmap(bmp);
    }

//    public class Circle extends View{
//
//        Paint paint;
//        public Circle(Context context) {
//            super(context);
//            paint = new Paint();
//        }
//
//        @Override
//        protected void onDraw(Canvas canvas){
//            super.onDraw(canvas);
//            int x = getWidth();
//            int y = getHeight();
//            int radius = 100;
//            paint.setStyle(Paint.Style.STROKE);
//            paint.setColor(Color.parseColor("#277397"));
//            canvas.drawPaint(paint);
//            paint.setColor(Color.parseColor("#277397"));
//            canvas.drawCircle(x/2, y/2, radius, paint);
//        }
//    }

}
