package com.controleFinanceiro;

public class DataSaidaSQL extends DataInterpret{

    @Override
    public String data_formatada(String date){
        return dia(date)+"/"+mes(date)+"/"+ano(date);
    }

    @Override
    public  String dia(String data){
        return data.substring(8, 10);
    }

    @Override
    public  String mes(String data){
        return data.substring(5, 7);
    }
    
    @Override
    public String ano(String data){
        return data.substring(0, 4);
    }
}

