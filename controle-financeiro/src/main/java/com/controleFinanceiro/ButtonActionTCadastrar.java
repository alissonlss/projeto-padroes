package com.controleFinanceiro;

import java.awt.event.*;

public class ButtonActionTCadastrar implements ActionListener {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ButtonActionTCadastrar(String nome){
        this.name = nome;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (getName() == "Cliente/Fornecedor"){
            Tela telaCadastrarCF = new TelaCadatrarClienteFornecedor();
            telaCadastrarCF.defineConteudoTela();
        }
        else if(getName() == "Compra"){
            Tela telaCadastrarCompra = new TelaCadastrarCompra();
            telaCadastrarCompra.defineConteudoTela();
        }
        else if(getName() == "Produto"){
            Tela telaCadastrarProduto = new TelaCadastrarProduto();
            telaCadastrarProduto.defineConteudoTela();
        }
        else if(getName() == "Transação"){
            Tela telaCadastrarTransacao = new TelaCadastrarTransacao();
            telaCadastrarTransacao.defineConteudoTela();
        }
        else{
            System.out.println("Opção não encontrada!");
        }
    }
    
}
