package br.com.whatsappandroid.cursoandroid.focar;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by gabrielscalici on 01/12/17.
 * Classe responsável pelo armazenamento de informacoes
 */

public class BancoDeDados extends SQLiteOpenHelper {

    //Definicoes do que sera usado no banco de dados
    public static final String NOME_BANCO = "banco.db";
    public static final String TABELA = "usuarios";
    public static final String NOME_USER = "nome_usuario";
    public static final String P_FOCOS = "perda_focos";

    //Versao do software
    private static final int VERSAO = 1;


    //CONSTRUTOR
    public BancoDeDados (Context context){
        super(context, NOME_BANCO,null, VERSAO);
    }

    public void onCreate(SQLiteDatabase db) {

        //Criacao da tabela quando rodar o app (Usa as definicoes das veriavies)
        String sql = "CREATE TABLE usuarios ("
                + NOME_USER + "text,"
                + P_FOCOS + "integer,"
                +")";
        db.execSQL(sql);


    }

    //Metodo que apaga a tabela e cria novamente com as alteracoes feitas (upgrade de dados)
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Comando para destruir a tabela
        db.execSQL("DROP TABLE IF EXISTS usuarios");
        //Manda de novo para onCrate para construir com as alteracoes feitas
        onCreate(db);
    }

}






/*
    //definindo o tipo como texto para ficar mais facil de mexer
    private static final String TEXT_TYPE = "TEXT";

    private static final String COMMA_SEP = ",";

    private static final String SQL_CREATE_POSTS =
            "CREATE TABLE " + PostEntry.TABLE_NAME + " (" +
                    PostEntry._ID + " INTEGER PRIMARY KEY," +
                    PostEntry.COLUMN_NAME_TITLE + TEXT_TYPE + COMMA_SEP +
                    PostEntry.COLUMN_NAME_SUBTITLE + TEXT_TYPE + " )";

    private static final String SQL_DELETE_POSTS =
            "DROP TABLE IF EXISTS " + PostEntry.TABLE_NAME;

    //Dando uma versao para o banco de dados
    public static final int DATABASE_VERSION = 1;

    //Dando nome ao banco de dados
    public static final String DATABASE_NAME = "Banco_de_dados.db";

    public BancoDeDados(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    */