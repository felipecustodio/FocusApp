package br.com.whatsappandroid.cursoandroid.focar;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by gabrielscalici on 01/12/17.
 */

public class Update{

    public boolean addPessoa(Pessoa pessoa) {

        SQLiteDatabase db = BancoDeDados.getInstancia().getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("NAME", pessoa.getNome());
        cv.put("FOCOS", pessoa.getFocos());
        cv.put("CELULAR", pessoa.getCelular());

        return db.insert(BancoDeDados.TABELA_PESSOA, null, cv) != -1;

    }

    public boolean updatePessoa(Pessoa pessoa) {

        SQLiteDatabase db = BancoDeDados.getInstancia().getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("NAME", pessoa.getNome());
        cv.put("FOCOS", pessoa.getFocos());
        cv.put("CELULAR", pessoa.getCelular());

        String where = "NAME = '" + pessoa.getNome() + "'";

        return db.update(BancoDeDados.TABELA_PESSOA, cv, where , null) > 0;

    }
}
