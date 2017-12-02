package br.com.whatsappandroid.cursoandroid.focar;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    //Texto de Olá para o usuario especifico
    //private TextView nome_conta;

    private static final String TAG = "MyActivity";
    String nomeUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        //Exibir o nome que foi passado e salvar o nome para futuras mudanças
        final TextView nome_conta = (TextView) findViewById(R.id.txtNomeUser);
        Intent intent = getIntent();
        if(intent != null){
            Bundle bundle = intent.getExtras();

            if(bundle != null){
                nomeUsuario = bundle.getString("nomeUser");
                nome_conta.setText("VAMOS FOCAR," + nomeUsuario.toUpperCase()+ ".");

            }

        }




        ImageView foco = (ImageView) findViewById(R.id.focoBtn);
        foco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Log.d(TAG, "TESTE");
                Intent intent = new Intent(MainActivity.this, FocoActivity.class);
/*
                //Passando informacoes para alterar o banco de dados
                Bundle info = new Bundle();
                info.putString("nome", nomeUsuario);
                intent.putExtras(info);
                startActivityForResult(intent, 2);
*/

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
