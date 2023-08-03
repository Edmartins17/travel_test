package com.travelex.imc.names;

import java.util.Objects;

public class BasicPerson {

    protected String nome;

    public String getNome() {
        validing(nome);
        var firstName = nome.substring(0, nome.indexOf(" "));
        var lastName = nome.substring(nome.lastIndexOf(" "));
        int numberOfWords = nome.trim().split(" ").length;
        if (numberOfWords>2){
            return (firstName
                    + nome.trim().split(" ")[1].substring(0,1)
                    + ". "
                    + lastName).toUpperCase();
        }
        else{
            return nome.trim().toUpperCase();
        }
    }

    public void setNome(String nome) throws Exception {
        if (nome!=null && !"".equals(nome.trim())){
            throw new Exception("Coloque um valor ao setar o campo Nome");
        }
        this.nome = nome.trim();
    }

    public String getLastName(){
        if (validing(this.nome)){
            return nome.substring(nome.lastIndexOf(" ")).toUpperCase();
        }
        return null;
    }

    public String getFirstName(){
        if (validing(this.nome)){
            return nome.substring(0, nome.indexOf(" ")-1).toUpperCase();
        }
        return null;
    }

    public  boolean validing(String nome){
        if (nome==null || "".equals(nome.trim())){
            return false;
        }
        if (nome.length()!=nome.trim().length()){
            return false;
        }
        return true;
    }
}
