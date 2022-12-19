package com.controleFinanceiro;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class TelaConsultar extends Tela{

    private JPanel panelConsultar = new JPanel();

    @Override
    protected void defineConteudo() {

        JLabel img = new JLabel();
        img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/controleFinanceiro/imagens/consultar.png")));

        JPanel panelTitulo = new JPanel();
        JPanel panelTransacoes = new JPanel();
        JPanel panelListaCompleta = new JPanel();
        JPanel panelEspecifico = new JPanel();

        panelConsultar.setLayout(new GridLayout(0,1));

        Font fonteBotao = new Font("SansSerif", Font.CENTER_BASELINE, 12);
        Font fonteBorda = new Font("Serif", Font.BOLD, 18);
        Color bordColor = new Color(202, 139, 2);

        // Busca especifica
        JLabel tabela = new JLabel("Tabela:");
        String tabelas[] = {"Cliente", "Compras", "Fornecedor", "Produto", "Transação"};        
        JComboBox cbTabelas = new JComboBox(tabelas); 
        JLabel coluna = new JLabel("Coluna:");
        String colunas[] = {"CPF", "CNPJ", "Data", "Nome", "Preço"};        
        JComboBox cbColunas = new JComboBox(colunas); 
        JLabel dado = new JLabel("Dado:");
        final JTextField dadoBusca = new JTextField(10);

        // Botões para as transações
        JButton b1 = new JButton("Última Semana");
        b1.addActionListener(new ButtonActionConsulta("Última Semana"));
        JButton b2 = new JButton("Último Mês");
        b2.addActionListener(new ButtonActionConsulta("Último Mês"));
        JButton b3 = new JButton("Último Ano");
        b3.addActionListener(new ButtonActionConsulta("Último Ano"));

        // Botões para as listas completas
        JButton b4 = new JButton("Clientes");
        b4.addActionListener(new ButtonActionConsulta("Clientes"));
        JButton b5 = new JButton("Fornecedores");
        b5.addActionListener(new ButtonActionConsulta("Fornecedores"));
        JButton b6 = new JButton("Produtos");
        b6.addActionListener(new ButtonActionConsulta("Produtos"));
        JButton b7 = new JButton("Transações");
        b7.addActionListener(new ButtonActionConsulta("Transações"));

        // Botão para consulta especifica
        JButton b8 = new JButton("Buscar");
        b8.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Boolean tentativa = false;
                if (dadoBusca.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "O campo deve ser preenchido!");
                }
                else if (tentativa){
                    // Apresenta o resultado da Busca
                }
                else{
                    JOptionPane.showMessageDialog(null, "Ocorreu algum problema na tentativa de busca!","Erro", JOptionPane.ERROR_MESSAGE);
                }
            }});

        b1.setFont(fonteBotao);
        b2.setFont(fonteBotao);
        b3.setFont(fonteBotao);
        b4.setFont(fonteBotao);
        b5.setFont(fonteBotao);
        b6.setFont(fonteBotao);
        b7.setFont(fonteBotao);
        b8.setFont(fonteBotao);

        panelTransacoes.setBorder(BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(5, 5,
        5, 5, bordColor), "Transações", TitledBorder.ABOVE_BOTTOM, TitledBorder.DEFAULT_POSITION, fonteBorda));
        panelListaCompleta.setBorder(BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(5, 5,
        5, 5, bordColor), "Lista Completa", TitledBorder.ABOVE_BOTTOM, TitledBorder.DEFAULT_POSITION, fonteBorda));
        panelEspecifico.setBorder(BorderFactory.createTitledBorder(BorderFactory.createMatteBorder(5, 5,
        5, 5, bordColor), "Buscar Dado Específico", TitledBorder.ABOVE_BOTTOM, TitledBorder.DEFAULT_POSITION, fonteBorda));
        
        JLabel titulo = new JLabel("Consultar");
        titulo.setFont(new Font("Serif", Font.BOLD, 30));

        panelTitulo.add(img);
        panelTitulo.add(titulo);

        panelTransacoes.add(b1);
        panelTransacoes.add(b2);
        panelTransacoes.add(b3);

        panelListaCompleta.add(b4);
        panelListaCompleta.add(b5);
        panelListaCompleta.add(b6);
        panelListaCompleta.add(b7);

        panelEspecifico.add(tabela);
        panelEspecifico.add(cbTabelas);
        panelEspecifico.add(coluna);
        panelEspecifico.add(cbColunas);
        panelEspecifico.add(dado);
        panelEspecifico.add(dadoBusca);
        panelEspecifico.add(b8);

        panelConsultar.add(panelTitulo);
        panelConsultar.add(panelTransacoes);
        panelConsultar.add(panelListaCompleta);
        panelConsultar.add(panelEspecifico);


        BotoesRodape rodape = new BotoesRodape();
        panelConsultar.add(rodape.getRodape());
    }

    @Override
    protected JPanel getPanel() {
        return panelConsultar;
    }
    
}
