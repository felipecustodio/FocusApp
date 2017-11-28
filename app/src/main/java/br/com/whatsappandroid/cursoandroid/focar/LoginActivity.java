package br.com.whatsappandroid.cursoandroid.focar;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.database.Cursor;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

public class LoginActivity extends AppCompatActivity {

    private Button logIn;
    private EditText logUser;
    private SignInButton gLogIn;
    private Integer teste_carac = 1;
    private GoogleSignInClient mGSIClient;
    private static final int RC_SIGN_IN = 1234;

    //Definindo o banco de dados
    SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        logIn = (Button) findViewById(R.id.btnLogIn);

        logUser = (EditText) findViewById(R.id.userName);

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Verificando se o nome ja existe no banco de dados
                //Criando um novo usuario ou selecionando o existente

                //Checando se está vazio ou se é muito pequeno
                if(logUser.getText().toString().toUpperCase().length() == 0){
                    Toast.makeText(LoginActivity.this, "Insira um Login", Toast.LENGTH_SHORT).show();
                    teste_carac = 1; //Nao deixar seguir para a proxima tela
                }else if(logUser.getText().toString().toUpperCase().length() <= 3){
                    Toast.makeText(LoginActivity.this, "Login muito curto", Toast.LENGTH_SHORT).show();
                    teste_carac = 1;
                }else if(logUser.getText().toString().toUpperCase().length() > 18){
                    Toast.makeText(LoginActivity.this, "Login muito longo", Toast.LENGTH_SHORT).show();
                    teste_carac = 1;
                }else{
                    teste_carac = 0;
                    //Tenta buscar primeiro para ver se existe
                    Cursor valido = db.rawQuery("SELECT * FROM usuarios WHERE Nome_login = '"+ logUser.getText().toString().toUpperCase() +"'", null);

                    if(valido == null) {
                        //Após checar se e um login valido, criar no bd ou buscar usuario
                        db.execSQL("INSERT  INTO usuarios VALUES('" + logUser.getText().toString().toUpperCase() + "', '0)");
                    }

                    //entrar no Login recem criado, ou ja presente no banco de dados'

                }



                if(teste_carac == 0) {
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                }
            }
        });

        // Configure sign in request
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();

        mGSIClient = GoogleSignIn.getClient(this, gso);

        gLogIn = (SignInButton) findViewById(R.id.gLogIn);

        gLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();
            }
        });


        //Criando o banco de dados

        db = openOrCreateDatabase("UsuarioDB", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS usuarios (Nome_login VARCHAR, Quant_foco DOUBLE)");




    }

    public void onStart() {
        super.onStart();
        GoogleSignInAccount account =  GoogleSignIn.getLastSignedInAccount(this);
    }

    protected void signIn() {
        Intent signIntent = mGSIClient.getSignInIntent();
        startActivityForResult(signIntent, RC_SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    protected void handleSignInResult(Task<GoogleSignInAccount> task) {
        try {
            GoogleSignInAccount account = task.getResult(ApiException.class);
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);
        } catch(ApiException e) {
            Log.w("API_ERROR", "SignInResult: failed code = "  + e.getStatusCode());
        }
    }
}
