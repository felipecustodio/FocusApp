package br.com.whatsappandroid.cursoandroid.focar;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by gabrielscalici on 01/12/17.
 * Classe responsável pelo armazenamento de informacoes
 */

public class BancoDeDados extends SQLiteOpenHelper {

    //Definicoes do que sera usado no banco de dados
    private static final String NOME_BANCO = "banco.db";
    private static final String TABELA = "usuarios";
    private static final String NOME_USER = "nome_usuario";
    private static final String P_FOCOS = "perda_focos";

    //Versao do software
    private static final int VERSAO = 1;
    private SQLiteDatabase db;

    //CONSTRUTOR
    public BancoDeDados (Context context){
        super(context, NOME_BANCO,null, VERSAO);
    }

    //Controle de inserir dados no banco
    public void insereDado(String nome, int focos){
        ContentValues valores;

        long resultado;

        //Para escrever no banco de dados
        db = getWritableDatabase();
/*        valores = new ContentValues();

        //Valores para serem escritos
        valores.put(BancoDeDados.NOME_USER, nome);
        valores.put(BancoDeDados.P_FOCOS, focos);
*/
        db.execSQL("INSERT INTO "+ TABELA +" values ("+NOME_USER+", 0)");

        //resultado = db.insert(BancoDeDados.TABELA, null, valores);
        db.close();
/*
        if (resultado ==-1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";
*/

    }



    public void onCreate(SQLiteDatabase db) {

        //Criacao da tabela quando rodar o app (Usa as definicoes das veriavies)
        String sql = "CREATE TABLE IF NOT EXISTS "+ TABELA +" ("
                + NOME_USER + "text,"
                + P_FOCOS + "integer,"
                +")";
        db.execSQL(sql);


    }

    //Metodo que apaga a tabela e cria novamente com as alteracoes feitas (upgrade de dados)
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Comando para destruir a tabela
        //db.execSQL("DROP TABLE IF EXISTS "+ TABELA +"");
        //Manda de novo para onCrate para construir com as alteracoes feitas
        //onCreate(db);
    }

}


