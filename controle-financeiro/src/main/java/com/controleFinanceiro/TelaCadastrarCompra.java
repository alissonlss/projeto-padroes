package com.controleFinanceiro;

import javax.swing.*;

import com.SQLManager.SQLManager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCadastrarCompra extends Tela{

    private JPanel panelCadastrarCompra = new JPanel();

    @Override
    protected void defineConteudo() {

        JLabel titulo = new JLabel("Cadastrar Compra");
        titulo.setFont(new Font("Serif", Font.BOLD, 30));

        JLabel img = new JLabel();
        img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/controleFinanceiro/imagens/cadastrarCompra.png")));

        JPanel panelTitulo = new JPanel();
        JPanel panelCorpo = new JPanel();
        JPanel panelCorpo1 = new JPanel();
        JPanel panelCorpo2 = new JPanel();
        JPanel panelBotao = new JPanel();

        panelCadastrarCompra.setLayout(new GridLayout(0,1));
        panelCorpo.setLayout(new GridLayout(0, 1, 0, 1));
        panelCorpo.setPreferredSize(new Dimension(10, 200));

        JLabel idT = new JLabel("Código Transação:");
        final JTextField idTransacao = new JTextField(8);

        JLabel idP = new JLabel("Código Produto:");
        final JTextField idProduto = new JTextField(8);

        JLabel compra = new JLabel("Código Compra:");
        final JTextField idCompra = new JTextField(12);

        JLabel quantidade = new JLabel("Quantidade:");
        final JTextField quantidadeProduto = new JTextField(4);

        JLabel preco = new JLabel("Preço Únitario:");
        final JTextField precoProduto = new JTextField(4);

        JButton botao = new JButton("Cadastrar");
        botao.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                if (idCompra.getText().equals("") || idTransacao.getText().equals("")  || idProduto.getText().equals("")  || precoProduto.getText().equals("") || quantidadeProduto.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Todos campo deve ser preenchido!");
                }
                else {
                    
                    SQLManager sql = SQLManager.getInstance();

                    Boolean tentativa = sql.cadastrarCompra(new Integer(idCompra.getText()), new Integer(idTransacao.getText()), new Integer(idProduto.getText()), new Integer(quantidadeProduto.getText()), new Float(precoProduto.getText()));
                    
                    if (tentativa){
                        JOptionPane.showMessageDialog(null, "A compra foi cadastrada com sucesso!");
                        idCompra.setText("");
                        idTransacao.setText("");
                        idProduto.setText("");
                        precoProduto.setText("");
                        quantidadeProduto.setText("");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Ocorreu algum problema ao cadastar a compra!","Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }});

        panelTitulo.add(img);
        panelTitulo.add(titulo);

        panelCorpo1.add(idT);
        panelCorpo1.add(idTransacao);
        panelCorpo1.add(idP);
        panelCorpo1.add(idProduto);

        panelCorpo2.add(compra);
        panelCorpo2.add(idCompra);
        panelCorpo2.add(quantidade);
        panelCorpo2.add(quantidadeProduto);
        panelCorpo2.add(preco);
        panelCorpo2.add(precoProduto);

        panelBotao.add(botao);

        panelCorpo.add(panelCorpo1);
        panelCorpo.add(panelCorpo2);
        panelCorpo.add(panelBotao);

        panelCadastrarCompra.add(panelTitulo);
        panelCadastrarCompra.add(panelCorpo);

        BotoesRodape rodape = new BotoesRodape();
        panelCadastrarCompra.add(rodape.getRodape());
        
    }

    @Override
    protected JPanel getPanel() {
        return panelCadastrarCompra;
    }
    
}
