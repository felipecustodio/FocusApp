package br.com.whatsappandroid.cursoandroid.focar;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by gabrielscalici on 01/12/17.
 */

public class Read extends SQLiteOpenHelper {

    //Variaveis para encurtar o numero de parametros
    private static final String NOME_BD = "MEU_DB";
    private static final int VERSAO = 1;
    private static final String NOME_TABELA = "USUARIOS";
    private static final String NOME_USER = "nome_usuario";
    private static final String PATH_BD = "/data/user/0/br.com.whatsappandroid.cursoandroid.focar/database/MEU_DB";

    //Declaracoes
    private Context mContext;
    private SQLiteDatabase db;


    public Read(Context context) {
        super(context, NOME_BD, null, VERSAO );
        this.mContext = context;
        //Usar para ler
        db = getReadableDatabase();
    }


    //Metodo para retornar o nome
    public String getUser(String name){
        openDB();

        String getUser = "SELECT * FROM " + NOME_TABELA + " WHERE " + NOME_USER + "'" + name + "'";

        try{
            Pessoa p = new Pessoa();
            Cursor c = db.rawQuery(getUser, null);

            //Se existe algum registro na primeira posicao
            if(c.moveToFirst()){
                //Pegando os valores encontrados no banco de dados

                p.setNome(c.getString(0));
                p.setFocos(c.getInt(1));
                p.setCelular(c.getInt(2));
            }

            c.close();

            return p.getNome();

        }catch(Exception e){

            e.printStackTrace();
            return "ERROR";

        }finally{
            db.close();
        }


    }

    //Funcao para saber se o usuario existe
    public int UserExists(String name){
        openDB();

        String getUser = "SELECT * FROM " + NOME_TABELA + " WHERE " + NOME_USER +" = '" + name + "'";


        try{
            Cursor c = db.rawQuery(getUser, null);

            //Se existe algum registro na primeira posicao
            if(c.moveToFirst()){
                c.close();
                return 1;

            }else{
                c.close();
                return 0;
            }

        }catch(Exception e){

            e.printStackTrace();
            return 0;

        }finally{
            db.close();
        }


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





    public void openDB(){
        //Sempre abrir o banco de dados para mexer quando nao tiver aberto

        //Verificando se esta aberto, para dessa forma abrir
        if(!db.isOpen()){
            db = mContext.openOrCreateDatabase(PATH_BD, SQLiteDatabase.OPEN_READWRITE, null);
        }
    }
}
