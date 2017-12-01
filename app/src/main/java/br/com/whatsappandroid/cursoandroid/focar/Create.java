package br.com.whatsappandroid.cursoandroid.focar;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by gabrielscalici on 01/12/17.
 */

public class Create extends SQLiteOpenHelper {

    //Variaveis para encurtar o numero de parametros
    private static final String NOME_BD = "MEU_DB";
    private static final int VERSAO = 1;
    private static final String NOME_TABELA = "USUARIOS";
    private static final String PATH_BD = "/data/user/0/br.com.whatsappandroid.cursoandroid.focar/database/MEU_DB";

    //Declaracoes
    private Context mContext;
    private SQLiteDatabase db;


    public Create(Context context) {
        super(context, NOME_BD, null, VERSAO );
        this.mContext = context;
        //Usar para escrever
        db = getWritableDatabase();

    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //Logica para atualizar db
        //Quando ja tiver rodando em algum disposito
        //Chamado automaticamente quando muda alguma versao do banco de dados
    }



    public boolean createTable(){
        //Abrindo o banco de dados
        openDB();
        String createTable = "CREATE TABLE IF NOT EXISTS " + NOME_TABELA + " ("
                + " NOME TEXT,"
                + " FOCOS INTEGER,"
                + " CELULAR INTEGER)";

        //TRATAMETO DE ERROS COM O RETORNO DEPENDENDO DA OPERACAO
        try{
            db.execSQL(createTable);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            //Obrigatorio fechar, mesmo dando certo ou errado
            db.close();
        }

    }


    public void openDB(){
        //Sempre abrir o banco de dados para mexer quando nao tiver aberto

        //Verificando se esta aberto, para dessa forma abrir
        if(!db.isOpen()){
            db = mContext.openOrCreateDatabase(PATH_BD, SQLiteDatabase.OPEN_READWRITE, null);
        }
    }
}
