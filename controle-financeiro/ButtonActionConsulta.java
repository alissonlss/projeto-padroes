import java.awt.event.*;
import javax.swing.*;

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
        System.out.println(getName());
        if (getName() == "Última Semana"){
            // Apresenta a busca ou apresenta mensagem
        }
        else if (getName() == "Último Mês"){
            // Apresenta a busca ou apresenta mensagem
        }
        else if (getName() == "Último Ano"){
            // Apresenta a busca ou apresenta mensagem
        }
        else if (getName() == "Clientes"){
            // Apresenta a busca ou apresenta mensagem
        }
        else if (getName() == "Fornecedores"){
            // Apresenta a busca ou apresenta mensagem
        }
        else if (getName() == "Produtos"){
            // Apresenta a busca ou apresenta mensagem
        }
        else if (getName() == "Transações"){
            // Apresenta a busca ou apresenta mensagem
        }
        else{
            JOptionPane.showMessageDialog(null, "Ocorreu algum problema na tentativa de busca!","Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
