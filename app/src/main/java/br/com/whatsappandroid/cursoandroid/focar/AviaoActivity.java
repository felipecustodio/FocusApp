package br.com.whatsappandroid.cursoandroid.focar;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

public class AviaoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aviao);

        createCircle();

        Switch s = (Switch) findViewById(R.id.onOff);

        Boolean sState = s.isChecked();

        s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            TextView sText = findViewById(R.id.switchText);
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b == false){
                    sText.setText("Desativado");
                }else{
                    sText.setText("Ativado");
                }
            }
        });

    }

    public void createCircle(){
        ImageView circle = (ImageView) findViewById(R.id.rCircle);
        int radius = 200;
        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#ff0000"));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(4);
        Bitmap bmp = Bitmap.createBitmap(500, 500, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bmp);
        canvas.drawCircle(bmp.getWidth()/2, bmp.getHeight()/2, radius, paint);
        circle.setImageBitmap(bmp);
    }


}
