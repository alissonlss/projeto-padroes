package com.controleFinanceiro;

// aplicando o padrão Interpreter

public abstract class DataInterpret {

    public String interpretar(String date) {
        if (date.length() == 0) {
            return "Erro";
        }
        if (date.length()<10) { return "Erro";
        } 
        else {
            return data_formatada(date);
        }
    }
    public abstract String data_formatada(String date);
 
    public abstract String dia( String date);
 
    public abstract String mes(String date);
 
    public abstract String ano(String date);
 
}

