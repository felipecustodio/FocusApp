package br.com.whatsappandroid.cursoandroid.focar;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;



public class FocoActivity extends AppCompatActivity {

    private ImageView circle;
    private TextView counter;
    static boolean isCircleCreated = false;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foco);

        createCircle();
        counter = (TextView) findViewById(R.id.counter);
        counter.setText(Integer.toString(count));

        if(isCircleCreated) {
            circle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    addToCount(1);
                    counter.setText(Integer.toString(count));
                }
            });
        }
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return this.count;
    }

    public void addToCount(int value) {
        this.count += value;
    }

    public void createCircle(){
        circle = (ImageView) findViewById(R.id.circle);
        int radius = 200;
        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#3ba6d8"));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(4);
        Bitmap bmp = Bitmap.createBitmap(500, 500, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bmp);
        canvas.drawCircle(bmp.getWidth()/2, bmp.getHeight()/2, radius, paint);
        circle.setImageBitmap(bmp);
        isCircleCreated = true;
        setCount(0);
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


/*
public class FocoActivity extends AppCompatActivity {

    private ImageView circle;
    private TextView counter;
    private Button salvar_focos;
    static boolean isCircleCreated = false;
    private int count = 0;

    //String para saber qual nome alterar no banco de dados
    //LEMBRAR DE COLOCAR TUDO MAIUSCULO PARA O BANCO DE DADOS
    String nomeUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foco);



        createCircle();
        counter = (TextView) findViewById(R.id.counter);
        counter.setText(Integer.toString(count));

        if(isCircleCreated) {
            circle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    addToCount(1);
                    counter.setText(Integer.toString(count));
                }
            });
        }




        //Botao salvar
        salvar_focos = (Button) findViewById(R.id.btnSalvarFoco);

/*
        //Pegando informacao de qual usuario esta tentando modificar o bd
        Intent intent = getIntent();
        if(intent != null){
            Bundle bundle = intent.getExtras();

            if(bundle != null){
                nomeUsuario = bundle.getString("nomeUser");
            }

        }



    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return this.count;
    }

    public void addToCount(int value) {
        this.count += value;
    }

    public void createCircle(){
        circle = (ImageView) findViewById(R.id.circle);
        int radius = 200;
        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#3ba6d8"));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(4);
        Bitmap bmp = Bitmap.createBitmap(500, 500, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bmp);
        canvas.drawCircle(bmp.getWidth()/2, bmp.getHeight()/2, radius, paint);
        circle.setImageBitmap(bmp);
        isCircleCreated = true;
        setCount(0);
    }


}
*/