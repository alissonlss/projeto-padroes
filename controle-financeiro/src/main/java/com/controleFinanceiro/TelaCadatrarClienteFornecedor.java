package com.controleFinanceiro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.SQLManager.*;

public class TelaCadatrarClienteFornecedor  extends Tela{

    private JPanel panelCadastrarCF = new JPanel();

    @Override
    protected void defineConteudo() {
        
        JLabel titulo = new JLabel("Cadastrar Cliente/Fornecedor");
        titulo.setFont(new Font("Serif", Font.BOLD, 30));

        JLabel img = new JLabel();
        img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/controleFinanceiro/imagens/cadastrarPessoa.png")));

        JPanel panelTitulo = new JPanel();
        JPanel panelCorpo = new JPanel();
        JPanel panelCorpo1 = new JPanel();
        JPanel panelCorpo2 = new JPanel();
        JPanel panelBotao = new JPanel();

        panelCadastrarCF.setLayout(new GridLayout(0,1));
        panelCorpo.setLayout(new GridLayout(0, 1, 0, 1));
        panelCorpo.setPreferredSize(new Dimension(10, 200));

        JLabel nome = new JLabel("Nome:");
        final JTextField nomeCadastar = new JTextField(20);

        JLabel tipo = new JLabel("Tipo:");
        final String tipos[] = {"CPF", "CNPJ"};
        final JComboBox cbTipo = new JComboBox(tipos);
        final JtextFieldOnlyNumber cpf_cnpj = new JtextFieldOnlyNumber(9, 14);

        String tipoPessoa[] = {"C", "F"};
        final JComboBox cbTipoPessoa = new JComboBox(tipoPessoa);

        JButton botao = new JButton("Cadastrar");
        botao.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                if (cpf_cnpj.getText().equals("") || nomeCadastar.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Todos campo deve ser preenchido!");
                }
                else{ 
                    SQLManager sql = SQLManager.getInstance();
                    Boolean tentativa;
                    if (cbTipoPessoa.getSelectedItem().equals("C")){
                        tentativa = sql.cadastrarCliente(cpf_cnpj.getText(), nomeCadastar.getText(), tipos[cbTipo.getSelectedIndex()]);
                    }
                    else{
                        tentativa = sql.cadastrarFornecedor(cpf_cnpj.getText(), nomeCadastar.getText(), tipos[cbTipo.getSelectedIndex()]);
                    }
                    
                    if (tentativa){
                        JOptionPane.showMessageDialog(null, "O cliente/fornecedor foi cadastrado com sucesso!");
                        cpf_cnpj.setText("");
                        nomeCadastar.setText("");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Ocorreu algum problema ao cadastar o cliente/fornecedor!","Erro", JOptionPane.ERROR_MESSAGE);
                    }
                 }
            }});

        panelTitulo.add(img);
        panelTitulo.add(titulo);
        
        panelCorpo1.add(nome);
        panelCorpo1.add(nomeCadastar);
        panelCorpo2.add(cbTipo);
        panelCorpo2.add(cpf_cnpj);
        panelCorpo2.add(tipo);
        panelCorpo2.add(cbTipoPessoa);

        panelBotao.add(botao);

        panelCorpo.add(panelCorpo1);
        panelCorpo.add(panelCorpo2);
        panelCorpo.add(panelBotao);

        panelCadastrarCF.add(panelTitulo);
        panelCadastrarCF.add(panelCorpo);

        BotoesRodape rodape = new BotoesRodape();
        panelCadastrarCF.add(rodape.getRodape());
    }

    @Override
    protected JPanel getPanel() {
        return panelCadastrarCF;
    }
    
}
