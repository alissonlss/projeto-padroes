package com.controleFinanceiro;

import javax.swing.*;

public abstract class Tela {
    //metodo template
    final public void defineConteudoTela(){
        defineConteudo();
        Janela janela = Janela.getInstancia();
        janela.setConteudoJanela(getPanel());
    }

    protected abstract void defineConteudo();
    protected abstract  JPanel getPanel();
}
