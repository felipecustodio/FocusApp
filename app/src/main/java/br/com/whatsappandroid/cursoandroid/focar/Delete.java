package br.com.whatsappandroid.cursoandroid.focar;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by gabrielscalici on 01/12/17.
 */

public class Delete extends SQLiteOpenHelper {

    //Variaveis para encurtar o numero de parametros
    private static final String NOME_BD = "MEU_DB";
    private static final int VERSAO = 1;
    private static final String NOME_TABELA = "USUARIOS";
    private static final String PATH_BD = "/data/user/0/br.com.whatsappandroid.cursoandroid.focar/database/MEU_DB";

    //Declaracoes
    private Context mContext;
    private SQLiteDatabase db;


    public Delete(Context context) {
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



    public boolean deleteTable(){
        openDB();
        String deletar = " DROP TABLE IF EXISTS " + NOME_TABELA;
        try{
            db.execSQL(deletar);


            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally {
            db.close();
        }


    }

    public boolean deletePessoa(Pessoa p){
        openDB();
        String deletar = "NOME =  '"+ p.getNome()+ "'";
        try{
            //Deletar a pessoa
            db.delete(NOME_TABELA, deletar, null);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally {
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
