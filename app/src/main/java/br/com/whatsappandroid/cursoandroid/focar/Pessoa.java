package br.com.whatsappandroid.cursoandroid.focar;

import java.util.Random;

/**
 * Created by gabrielscalici on 01/12/17.
 */

public class Pessoa {



    private String nome;
    private int focos;
    private int celular;



    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public int getFocos(){
        return focos;
    }

    public void setFocos(int focos){
        this.focos = focos;
    }

    public int getCelular(){
        return celular;
    }

    public void setCelular(int celular){
        this.celular = celular;
    }



}
