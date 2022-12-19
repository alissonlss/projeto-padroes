package com.controleFinanceiro;

//utilizando o padrão facade

public class Sistema {

    public void inicializar() {
        Tela inicio = new TelaInicial();
        inicio.defineConteudoTela();
    }

    public void encerrar(){
        System.exit(0);
    }
}
