package br.com.whatsappandroid.cursoandroid.focar;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.UpdateAppearance;
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

import java.util.ArrayList;


//Banco de dados

public class LoginActivity extends AppCompatActivity {

    private Button logIn;
    private Button register;

    private EditText logUser;
    private SignInButton gLogIn;
    private Integer teste_carac = 1;
    private GoogleSignInClient mGSIClient;
    private static final int RC_SIGN_IN = 1234;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //ELEMENTOS
        logIn = (Button) findViewById(R.id.btnLogIn);
        register = (Button) findViewById(R.id.btnRegister);
        logUser = (EditText) findViewById(R.id.userName);


        //Criando a tabela se ela nao existir
        new Create().createTable();



        //FUNCAO DO BOTAO DE REGISTRO
        register.setOnClickListener(new View.OnClickListener() {

            //Criando mensagem de alerta
            private AlertDialog alerta;

            @Override
            public void onClick(View view) {

                if (logUser.getText().toString().toUpperCase().length() == 0) {
                    Toast.makeText(LoginActivity.this, "Insira um Login", Toast.LENGTH_SHORT).show();
                    teste_carac = 1; //Nao deixar seguir para a proxima tela
                } else if (logUser.getText().toString().toUpperCase().length() <= 3) {
                    Toast.makeText(LoginActivity.this, "Login muito curto", Toast.LENGTH_SHORT).show();
                    teste_carac = 1;
                } else if (logUser.getText().toString().toUpperCase().length() > 18) {
                    Toast.makeText(LoginActivity.this, "Login muito longo", Toast.LENGTH_SHORT).show();
                    teste_carac = 1;
                } else {
                    teste_carac = 0;

                    //CODIGO PARA VERIFICAR SE DESEJA CRIAR OUTRO E APAGAR O ANTIGO COM O MESMO NOME

                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);//Cria o gerador do AlertDialog
                    builder.setTitle("Criar novo login?");//define o titulo
                    builder.setMessage("O Login antigo com o mesmo nome será apagado!");//define a mensagem

                    //BOTAO POSITIVO
                    builder.setPositiveButton("CRIAR NOVO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface arg0, int arg1) {

                            //Funcionalidade para criar um novo usuario
                            Pessoa p = new Pessoa();

                            p.setNome(logUser.getText().toString().toUpperCase());
                            p.setFocos(0);
                            p.setCelular(0);

                            Update u = new Update();

                            if (u.addPessoa(p)) {
                                Toast.makeText(LoginActivity.this, "Parabéns, você criou um novo Login", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(LoginActivity.this, "Erro ao inserir", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });

                    //BOTAO NEGATIVO
                    builder.setNegativeButton("MANTENHA ANTIGO", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface arg0, int arg1) {

                            //NÃO FAZ NADA, POIS O USUARIO CANCELOU A OPERACAO DE CRIAR COM O MEMSO USUARIO

                            Toast.makeText(LoginActivity.this, "Mantendo login antigo", Toast.LENGTH_SHORT).show();
                        }
                    });
                    alerta = builder.create();
                    alerta.show();

                }
            }
        });

        //FUNCAO DO BOTAO DE LOGIN
        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nome_para_proxima = logUser.getText().toString();

                if(new Read().getExists(logUser.getText().toString().toUpperCase())){
                    Toast.makeText(LoginActivity.this, "Usuario Válido!", Toast.LENGTH_SHORT).show();
                    //transferindo informacao de nome
                    Intent i = new Intent(LoginActivity.this, MainActivity.class);
                    //Enviando a informacao para outra activity
                    Bundle info = new Bundle();
                    info.putString("nomeUser", nome_para_proxima);
                    i.putExtras(info);
                    startActivityForResult(i, 1);
                }else{
                    Toast.makeText(LoginActivity.this, "Usuário Inválido!", Toast.LENGTH_SHORT).show();
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
