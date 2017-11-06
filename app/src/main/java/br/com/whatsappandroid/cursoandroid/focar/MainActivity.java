package br.com.whatsappandroid.cursoandroid.focar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView foco = (ImageView) findViewById(R.id.focoBtn);
        foco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Log.d(TAG, "TESTE");
                Intent intent = new Intent(MainActivity.this, FocoActivity.class);
                startActivity(intent);
            }
        });

        ImageView aviao = (ImageView) findViewById(R.id.aviaoBtn);
        aviao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AviaoActivity.class);
                startActivity(intent);
            }
        });

        ImageView respire = (ImageView) findViewById(R.id.respireBtn);
        respire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RespireActivity.class);
                startActivity(intent);
            }
        });

        ImageView stat = (ImageView) findViewById(R.id.estatBtn);
        stat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, StatActivity.class);
                startActivity(intent);
            }
        });
    }

}
