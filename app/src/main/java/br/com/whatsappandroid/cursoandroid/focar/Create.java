package br.com.whatsappandroid.cursoandroid.focar;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by gabrielscalici on 01/12/17.
 */

public class Create {

    public void createTable() {

        SQLiteDatabase db = BancoDeDados.getInstancia().getWritableDatabase();
        String colunas = "(NAME TEXT, FOCOS INTEGER, CELULAR INTEGER )";
        String query = "CREATE TABLE IF NOT EXISTS " + BancoDeDados.TABELA_PESSOA + colunas;
        db.execSQL(query);

    }
}
