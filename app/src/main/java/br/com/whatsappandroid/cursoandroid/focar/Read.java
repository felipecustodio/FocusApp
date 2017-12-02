package br.com.whatsappandroid.cursoandroid.focar;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


/**
 * Created by gabrielscalici on 01/12/17.
 */

public class Read {

    public ArrayList<Pessoa> getPessoas() {

        SQLiteDatabase db = BancoDeDados.getInstancia().getReadableDatabase();
        String query = "SELECT * FROM " + BancoDeDados.TABELA_PESSOA;
        ArrayList<Pessoa> pessoas = new ArrayList<>();
        Cursor c = db.rawQuery(query, null);

        if (c.moveToFirst()) {

            do {
                Pessoa pessoa = new Pessoa();
                pessoa.setNome(c.getString(1));
                pessoa.setFocos(c.getInt(2));
                pessoa.setCelular(c.getInt(3));
            } while (c.moveToNext());
        }

        c.close();
        return pessoas;
    }

   public boolean getExists(String name){
       SQLiteDatabase db = BancoDeDados.getInstancia().getReadableDatabase();
       String query = "SELECT * FROM " + BancoDeDados.TABELA_PESSOA + " WHERE NAME = '"+ name +"'";
       ArrayList<Pessoa> pessoas = new ArrayList<>();
       Cursor c = db.rawQuery(query, null);

       if (c.moveToFirst()) {
           c.close();
           return true;
       }

       c.close();
       return false;
   }

}
