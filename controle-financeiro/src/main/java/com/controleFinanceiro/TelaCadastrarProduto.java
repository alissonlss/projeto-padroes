package com.controleFinanceiro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.SQLManager.*;

public class TelaCadastrarProduto  extends Tela{

    private JPanel panelCadastrarProduto = new JPanel();

    @Override
    protected void defineConteudo() {
        JLabel titulo = new JLabel("Cadastrar Produto");
        titulo.setFont(new Font("Serif", Font.BOLD, 30));

        JLabel img = new JLabel();
        img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/controleFinanceiro/imagens/cadastrarProduto.png")));

        JPanel panelTitulo = new JPanel();
        JPanel panelCorpo = new JPanel();
        JPanel panelCorpo1 = new JPanel();
        JPanel panelCorpo2 = new JPanel();
        JPanel panelBotao = new JPanel();

        panelCadastrarProduto.setLayout(new GridLayout(0,1));
        panelCorpo.setLayout(new GridLayout(0, 1, 0, 1));
        panelCorpo.setPreferredSize(new Dimension(10, 200));

        JLabel nome = new JLabel("Nome:");
        final JTextField nomeProduto = new JTextField(20);

        JLabel id = new JLabel("Código:");
        final JTextField idProduto = new JTextField(12);

        JLabel preco = new JLabel("Preço:");
        final JTextField precoProduto = new JTextField(12);

        JButton botao = new JButton("Cadastrar");
        botao.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            
                if (nomeProduto.getText().equals("") || idProduto.getText().equals("")  || precoProduto.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Todos campo deve ser preenchido!");
                }
                else {
                    SQLManager sql = SQLManager.getInstance();
                    Boolean tentativa = sql.cadastrarProduto(nomeProduto.getText(), new Float(precoProduto.getText()));
                    if (tentativa){
                        JOptionPane.showMessageDialog(null, "O produto foi cadastrado com sucesso!");
                        nomeProduto.setText("");
                        idProduto.setText("");
                        precoProduto.setText("");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Ocorreu algum problema ao cadastar o protudo!","Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }});

        panelTitulo.add(img);
        panelTitulo.add(titulo);
        
        panelCorpo1.add(nome);
        panelCorpo1.add(nomeProduto);
        panelCorpo2.add(id);
        panelCorpo2.add(idProduto);
        panelCorpo2.add(preco);
        panelCorpo2.add(precoProduto);

        panelBotao.add(botao);

        panelCorpo.add(panelCorpo1);
        panelCorpo.add(panelCorpo2);
        panelCorpo.add(panelBotao);

        panelCadastrarProduto.add(panelTitulo);
        panelCadastrarProduto.add(panelCorpo);

        BotoesRodape rodape = new BotoesRodape();
        panelCadastrarProduto.add(rodape.getRodape());   
    }

    @Override
    protected JPanel getPanel() {
        return panelCadastrarProduto;
    }
    
}