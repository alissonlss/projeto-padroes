package com.controleFinanceiro;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import com.SQLManager.*;

public class TelaRemover extends Tela{

    private JPanel panelRemover = new JPanel();

    @Override
    protected void defineConteudo() {

        JLabel img = new JLabel();
        img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/controleFinanceiro/imagens/remover.png")));

        JPanel panelConteudo = new JPanel();
        JPanel panelTitulo = new JPanel();
        JPanel panelTransacoes = new JPanel();
        JPanel panelPessoaCF = new JPanel();
        JPanel panelCompra = new JPanel();
        JPanel panelProduto = new JPanel();

        panelConteudo.setLayout(new GridLayout(0,1));
        panelRemover.setLayout(new GridLayout(0,1));

        Font fonteBotao = new Font("SansSerif", Font.CENTER_BASELINE, 12);
        Font fonteBorda = new Font("Serif", Font.BOLD, 18);
        Color bordColor = new Color(51, 102, 153);

        JLabel titulo = new JLabel("Remover");
        titulo.setFont(new Font("Serif", Font.BOLD, 30));

        JLabel cpf_cnpj = new JLabel("CPF/CNPJ:");
        final JtextFieldOnlyNumber dadoCpfCnpj = new JtextFieldOnlyNumber(9, 14);

        String codCompras[] = {"ID Compra", "ID Transação"};
        final JComboBox cbCompra = new JComboBox(codCompras);  
        final JTextField idCompra = new JTextField(8);

        JLabel transacao = new JLabel("Código:");
        final JTextField idTransacao = new JTextField(8);

        JLabel produto = new JLabel("Código:");
        final JTextField idProduto = new JTextField(8);


        //Botões para as transações
        JButton b1 = new JButton("Remover Cliente/Fornecedor");
        b1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (dadoCpfCnpj.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "O campo deve ser preenchido!");
                }
                else{ 
                    SQLManager sql = SQLManager.getInstance();
                    Boolean tentativa = sql.removerCliente_fornecedor(dadoCpfCnpj.getText());
                    if (tentativa){
                        JOptionPane.showMessageDialog(null, "O Cliente/Fornecedor foi removido com sucesso!");
                        dadoCpfCnpj.setText("");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Ocorreu algum problema ao remover o cliente/fornecedor!","Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }});
            
        JButton b2 = new JButton("Remover Compra");
        b2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (idCompra.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "O campo deve ser preenchido!");
                }
                else {

                    Boolean tentativa;
                    SQLManager sql = SQLManager.getInstance();

                    if (cbCompra.getSelectedItem().equals("ID Compra")){
                        tentativa = sql.removerCompra(new Integer(idCompra.getText()), "ID");
                    }
                    else{
                        tentativa = sql.removerCompra(new Integer(idCompra.getText()), "ID_transacao");
                    }

                    if (tentativa){
                        JOptionPane.showMessageDialog(null, "A compra foi removido com sucesso!");
                        idCompra.setText("");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Ocorreu algum problema ao remover a compra!","Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }});

        JButton b3 = new JButton("Remover Produto");
        b3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                if (idProduto.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "O campo deve ser preenchido!");
                }
                else{
                    SQLManager sql = SQLManager.getInstance();
                    Boolean tentativa = sql.removerProduto(new Integer(idProduto.getText()));
                    if (tentativa){
                        JOptionPane.showMessageDialog(null, "O produto foi removido com sucesso!");
                        idProduto.setText("");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Ocorreu algum problema ao remover o produto!","Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }});

        JButton b4 = new JButton("Remover Transação");
        b4.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                if (idTransacao.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "O campo deve ser preenchido!");
                }
                else{
                    SQLManager sql = SQLManager.getInstance();
                    Boolean tentativa = sql.removerTransacao(new Integer(idTransacao.getText()));
                    if (tentativa){
                        JOptionPane.showMessageDialog(null, "A transação foi removido com sucesso!");
                        idTransacao.setText("");
                    }
                    else{
                     JOptionPane.showMessageDialog(null, "Ocorreu algum problema ao remover a transação!","Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }});

        b1.setFont(fonteBotao);
        b2.setFont(fonteBotao);
        b3.setFont(fonteBotao);
        b4.setFont(fonteBotao);

        panelPessoaCF.setBorder(BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(5, 5,
        5, 5, bordColor), "Cliente/Fornecedor", TitledBorder.ABOVE_BOTTOM, TitledBorder.DEFAULT_POSITION, fonteBorda));
        panelCompra.setBorder(BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(5, 5,
        5, 5, bordColor), "Compra", TitledBorder.ABOVE_BOTTOM, TitledBorder.DEFAULT_POSITION, fonteBorda));
        panelProduto.setBorder(BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(5, 5,
        5, 5, bordColor), "Produto", TitledBorder.ABOVE_BOTTOM, TitledBorder.DEFAULT_POSITION, fonteBorda));
        panelTransacoes.setBorder(BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(5, 5,
        5, 5, bordColor), "Transações", TitledBorder.ABOVE_BOTTOM, TitledBorder.DEFAULT_POSITION, fonteBorda));

        panelTitulo.add(img);
        panelTitulo.add(titulo);

        panelPessoaCF.add(cpf_cnpj);
        panelPessoaCF.add(dadoCpfCnpj);
        panelPessoaCF.add(b1);

        panelCompra.add(cbCompra);
        panelCompra.add(idCompra);
        panelCompra.add(b2);

        panelProduto.add(produto);
        panelProduto.add(idProduto);
        panelProduto.add(b3);

        panelTransacoes.add(transacao);
        panelTransacoes.add(idTransacao);
        panelTransacoes.add(b4);

        
        panelConteudo.add(panelTitulo);
        panelConteudo.add(panelPessoaCF);
        panelConteudo.add(panelCompra);
        panelConteudo.add(panelProduto);
        panelConteudo.add(panelTransacoes);
        
        BotoesRodape rodape = new BotoesRodape();
        panelConteudo.add(rodape.getRodape());
        
        JScrollPane scroll = new JScrollPane(panelConteudo);
        panelRemover.add(scroll);
    }

    @Override
    protected JPanel getPanel() {
        return panelRemover;
    }
    
}
