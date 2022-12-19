package com.controleFinanceiro;

import java.awt.event.*;

public class ButtonActionTPrincipal implements ActionListener{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ButtonActionTPrincipal(String nome){
        this.name = nome;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (getName() == "Cadastrar"){
            Tela telaCadastar = new TelaCadastrar();
            telaCadastar.defineConteudoTela();
        }
        else if (getName() == "Consultar"){
            Tela telaConsulta = new TelaConsultar();
            telaConsulta.defineConteudoTela();
        }
        else if (getName() == "Remover"){
            Tela telaRemover = new TelaRemover();
            telaRemover.defineConteudoTela();
        }
        else{
            System.out.println("Opção não encontrada!");
        }
    }
    
}
