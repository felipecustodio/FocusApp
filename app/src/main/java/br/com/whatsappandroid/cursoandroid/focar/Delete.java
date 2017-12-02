package br.com.whatsappandroid.cursoandroid.focar;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by gabrielscalici on 01/12/17.
 */

public class Delete {

    public void removerTabela() {

        SQLiteDatabase db = BancoDeDados.getInstancia().getWritableDatabase();
        String query = "DROP TABLE IF EXISTS " + BancoDeDados.TABELA_PESSOA;
        db.execSQL(query);

    }

    public boolean removerPessoa(Pessoa pessoa) {

        SQLiteDatabase db = BancoDeDados.getInstancia().getWritableDatabase();
        String query = "NAME = '" + pessoa.getNome() + "'";
        return db.delete(BancoDeDados.TABELA_PESSOA, query, null) > 0;

    }

}
