package br.com.whatsappandroid.cursoandroid.focar;


import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by gabrielscalici on 01/12/17.
 * Classe responsável pelo armazenamento de informacoes
 */

public class BancoDeDados extends SQLiteOpenHelper {

    private static String NOME_DB = "DB";
    private static int VERSAO_DB = 1;
    public static String TABELA_PESSOA = "USUARIOS";


    private static BancoDeDados instancia;


    public static BancoDeDados getInstancia(){
        if (instancia == null) instancia = new BancoDeDados();
        return instancia;

    }



    private BancoDeDados() {
        super(MyApp.getContext(), NOME_DB, null, VERSAO_DB);
    }



    public void onCreate(SQLiteDatabase db) {



    }

    //Metodo que apaga a tabela e cria novamente com as alteracoes feitas (upgrade de dados)
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}


