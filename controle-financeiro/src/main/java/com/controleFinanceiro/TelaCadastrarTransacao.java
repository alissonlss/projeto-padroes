package com.controleFinanceiro;

import javax.swing.*;
import javax.swing.text.MaskFormatter;

import com.SQLManager.SQLManager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class TelaCadastrarTransacao  extends Tela{

    private JPanel panelCadastrarTransacao = new JPanel();

    @Override
    protected void defineConteudo(){

        JLabel titulo = new JLabel("Cadastrar Transação");
        titulo.setFont(new Font("Serif", Font.BOLD, 30));

        JLabel img = new JLabel();
        img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/controleFinanceiro/imagens/cadastrarTransacao.png")));

        JPanel panelTitulo = new JPanel();
        JPanel panelCorpo = new JPanel();
        JPanel panelCorpo1 = new JPanel();
        JPanel panelCorpo2 = new JPanel();
        JPanel panelBotao = new JPanel();

        panelCadastrarTransacao.setLayout(new GridLayout(0,1));
        panelCorpo.setLayout(new GridLayout(0, 1, 0, 1));
        panelCorpo.setPreferredSize(new Dimension(10, 200));

        JLabel  cpf_cnpj = new JLabel("CPF/CNPJ:");
        final JtextFieldOnlyNumber dado_cpf_cnpj = new JtextFieldOnlyNumber(9, 14);

        JLabel idT = new JLabel("Código Transação:");
        final JTextField idTransacao = new JTextField(8);

        JLabel tipo = new JLabel("Tipo:");
        final String tipoPessoa[] = {"C", "F"};
        final JComboBox cbTipoPessoa = new JComboBox(tipoPessoa);

        MaskFormatter formatoData;
        try {
            formatoData = new MaskFormatter("##/##/####");
        } catch (ParseException e) {
            e.printStackTrace();
            formatoData = new MaskFormatter();
        }

        JLabel data = new JLabel("Data:");
        final JFormattedTextField dataTransacao = new JFormattedTextField(formatoData);
        dataTransacao.setColumns(6);

        JLabel valor = new JLabel("Valor Total:");
        final JTextField valorTotal = new JTextField(6);

        JButton botao = new JButton("Cadastrar");
        botao.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                if (idTransacao.getText().equals("") || dado_cpf_cnpj.getText().equals("") || valorTotal.getText().equals("") || dataTransacao.getText().equals("  /  /    ")){
                    JOptionPane.showMessageDialog(null, "Todos campo deve ser preenchido!");
                }
                else{ 
                    DataInterpret dataConv = new DataEntradaSQL();
                    SQLManager sql = SQLManager.getInstance();

                    Boolean tentativa = sql.cadastrarTransacao(dado_cpf_cnpj.getText(), tipoPessoa[cbTipoPessoa.getSelectedIndex()], new Float(valorTotal.getText()), dataConv.data_formatada(dataTransacao.getText()));

                    if (tentativa){
                    JOptionPane.showMessageDialog(null, "A transação foi cadastrada com sucesso!");
                        idTransacao.setText("");
                        dado_cpf_cnpj.setText("");
                        valorTotal.setText(""); 
                        dataTransacao.setText("");
                    }
                    else{
                     JOptionPane.showMessageDialog(null, "Ocorreu algum problema ao cadastar a transação!","Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }});

        panelTitulo.add(img);
        panelTitulo.add(titulo);
        
        panelCorpo1.add(cpf_cnpj);
        panelCorpo1.add(dado_cpf_cnpj);
        panelCorpo1.add(idT);
        panelCorpo1.add(idTransacao);

        panelCorpo2.add(tipo);
        panelCorpo2.add(cbTipoPessoa);
        panelCorpo2.add(data);
        panelCorpo2.add(dataTransacao);
        panelCorpo2.add(valor);
        panelCorpo2.add(valorTotal);

        panelBotao.add(botao);

        panelCorpo.add(panelCorpo1);
        panelCorpo.add(panelCorpo2);
        panelCorpo.add(panelBotao);

        panelCadastrarTransacao.add(panelTitulo);
        panelCadastrarTransacao.add(panelCorpo);

        BotoesRodape rodape = new BotoesRodape();
        panelCadastrarTransacao.add(rodape.getRodape());
    }

    @Override
    protected JPanel getPanel() {
        return panelCadastrarTransacao;
    }
    
}
