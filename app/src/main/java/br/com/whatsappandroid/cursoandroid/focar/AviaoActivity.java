package br.com.whatsappandroid.cursoandroid.focar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class AviaoActivity extends AppCompatActivity {

    private SensorManager sm;
    private Sensor gyro, accel;
    private SensorEventListener gyroEListener, accelEListener;
    private Switch s;
    private Vibrator v;
    private int count;

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
                    initializeSensors();
                }
            }
        });

    }

    public void initializeSensors() {

//        v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        gyro = sm.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        accel = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        if(accel == null) {
            Toast.makeText(this, "The device has no Accelerometer !", Toast.LENGTH_SHORT).show();
            finish();
        }

        if(gyro == null) {
            Toast.makeText(this, "The device has no Gyroscope !", Toast.LENGTH_SHORT).show();
            finish();
        }

        sm.registerListener((SensorEventListener) this, accel, SensorManager.SENSOR_DELAY_NORMAL);

        accelEListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                v.vibrate(500);
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {
            }
        };

        gyroEListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                if(sensorEvent.values[2] > 0.5f || sensorEvent.values[1] > 0.5f || sensorEvent.values[3] > 0.5f) {
                    getWindow().getDecorView().setBackgroundColor(Color.BLUE);
                    v.vibrate(500);
//                    Log.w("GYRO", "HERE");

                }else if(sensorEvent.values[2] < -0.5f || sensorEvent.values[1] < -0.5f || sensorEvent.values[3] < -0.5f) {
                    getWindow().getDecorView().setBackgroundColor(Color.YELLOW);
                    v.vibrate(500);
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
