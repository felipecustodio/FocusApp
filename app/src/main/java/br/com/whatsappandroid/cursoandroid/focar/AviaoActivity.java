package br.com.whatsappandroid.cursoandroid.focar;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class AviaoActivity extends AppCompatActivity {

    private SensorManager sm;
    private Sensor gyro;
    private SensorEventListener gyroEListener;
    private Switch s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aviao);

        createCircle();

        s = (Switch) findViewById(R.id.onOff);

        Boolean sState = s.isChecked();

        s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            TextView sText = findViewById(R.id.switchText);
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b == false){
                    sText.setText("Desativado");
                }else{
                    sText.setText("Ativado");
                    initializeGyro();
                }
            }
        });

    }

    public void initializeGyro() {
        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        gyro = sm.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        if(gyro == null) {
            Toast.makeText(this, "The device has no Gyroscope !", Toast.LENGTH_SHORT).show();
            finish();
        }

        gyroEListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                if(sensorEvent.values[2] > 0.5f) {
                    getWindow().getDecorView().setBackgroundColor(Color.BLUE);
                }else if(sensorEvent.values[2] < - 0.5f) {
                    getWindow().getDecorView().setBackgroundColor(Color.YELLOW);
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        sm.registerListener(gyroEListener, gyro, SensorManager.SENSOR_DELAY_FASTEST);
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        sm.unregisterListener(gyroEListener);
//    }

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
