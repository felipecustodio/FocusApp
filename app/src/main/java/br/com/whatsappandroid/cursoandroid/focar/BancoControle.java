package br.com.whatsappandroid.cursoandroid.focar;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by gabrielscalici on 01/12/17.
 */

public class BancoControle {

    private SQLiteDatabase db;
    private BancoDeDados banco;


    //CONSTRUTOR
    public BancoControle(Context context){
        banco = new BancoDeDados(context);
    }

    //Controle de inserir dados no banco
    public String insereDado(String nome, int focos){
        ContentValues valores;

        long resultado;

        //Para escrever no banco de dados
        db = banco.getWritableDatabase();
        valores = new ContentValues();

        //Valores para serem escritos
        valores.put(BancoDeDados.NOME_USER, nome);
        valores.put(BancoDeDados.P_FOCOS, focos);

        resultado = db.insert(BancoDeDados.TABELA, null, valores);
        db.close();

        if (resultado ==-1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";

    }
}
