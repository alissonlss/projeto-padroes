package com.controleFinanceiro;

import java.awt.event.*;
import javax.swing.*;

import com.SQLManager.*;

public class ButtonActionConsulta implements ActionListener {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ButtonActionConsulta(String nome){
        name = nome;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        SQLManager sql = SQLManager.getInstance();

        if (getName() == "Última Semana"){
            // Apresenta a busca ou apresenta mensagem
            JOptionPane.showMessageDialog(null, "Ocorreu algum problema na tentativa de busca!","Erro", JOptionPane.ERROR_MESSAGE);
        }
        else if (getName() == "Último Mês"){
            // Apresenta a busca ou apresenta mensagem
            JOptionPane.showMessageDialog(null, "Ocorreu algum problema na tentativa de busca!","Erro", JOptionPane.ERROR_MESSAGE);
        }
        else if (getName() == "Último Ano"){
            // Apresenta a busca ou apresenta mensagem
            JOptionPane.showMessageDialog(null, "Ocorreu algum problema na tentativa de busca!","Erro", JOptionPane.ERROR_MESSAGE);
        }
        else if (getName() == "Clientes"){
            sql.mostrarClientes();
        }
        else if (getName() == "Fornecedores"){
            sql.mostrarFornecedores();
        }
        else if (getName() == "Produtos"){
            sql.mostrarProdutos();
        }
        else if (getName() == "Transações"){
            sql.mostrarTransacoes();
        }
        else{
            JOptionPane.showMessageDialog(null, "Ocorreu algum problema na tentativa de busca!","Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
