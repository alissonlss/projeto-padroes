package com.controleFinanceiro;

public class DataEntradaSQL extends DataInterpret{

    @Override
    public String data_formatada(String date){
        return ano(date)+mes(date)+dia(date);
    }

    @Override
    public  String dia(String data){
        return data.substring(0, 2);
    }

    @Override
    public  String mes(String data){
        return data.substring(3, 5);
    }
    
    @Override
    public String ano(String data){
        return data.substring(6, 10);
    }
}
