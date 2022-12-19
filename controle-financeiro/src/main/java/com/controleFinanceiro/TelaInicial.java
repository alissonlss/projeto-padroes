package com.controleFinanceiro;

import javax.swing.*;
import java.awt.*;

public class TelaInicial extends Tela{
    
    @Override
    protected void defineConteudo() {
        JLabel logo = new JLabel();
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/controleFinanceiro/imagens/logo.png"))); //add imagem

        JPanel panelTitulo = new JPanel();
        JPanel panelCorpo = new JPanel();

        panelCorpo.setLayout(new GridLayout(0, 1, 0, 5));
        panelCorpo.setPreferredSize(new Dimension(10, 100));

        panelInicio.setLayout(new GridLayout(0,1));

        Font fonteBotao = new Font("SansSerif", Font.CENTER_BASELINE, 15);

        JButton b1 = new JButton("Cadastrar");
        JButton b2 = new JButton("Consultar");
        JButton b3 = new JButton("Remover");

        b1.setFont(fonteBotao);
        b2.setFont(fonteBotao);
        b3.setFont(fonteBotao);

        ButtonActionTPrincipal actionCadastar = new ButtonActionTPrincipal("Cadastrar");
        b1.addActionListener(actionCadastar);
        ButtonActionTPrincipal actionConsultar = new ButtonActionTPrincipal("Consultar");
        b2.addActionListener(actionConsultar);
        ButtonActionTPrincipal actionRemover = new ButtonActionTPrincipal("Remover");
        b3.addActionListener(actionRemover);
        
        JLabel nomeEmpresa = new JLabel("Empresa de tintas");
        nomeEmpresa.setFont(new Font("Serif", Font.BOLD, 30));

        panelTitulo.add(logo);
        panelTitulo.add(nomeEmpresa);

        panelCorpo.add(b1);
        panelCorpo.add(b2);
        panelCorpo.add(b3);

        panelInicio.add(panelTitulo);
        panelInicio.add(panelCorpo);
        
    }

    @Override
    protected JPanel getPanel() {
        return panelInicio;
    }

    private JPanel panelInicio = new JPanel();
}
