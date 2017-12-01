package br.com.whatsappandroid.cursoandroid.focar;

/**
 * Created by gabrielscalici on 01/12/17.
 */

public class Pessoa {


    public Pessoa(){

    }

    private String nome;
    private int focos;
    private int celular;


    //Metodos get e set para o usuario
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
