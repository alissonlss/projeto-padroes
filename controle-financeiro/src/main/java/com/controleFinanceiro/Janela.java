package com.controleFinanceiro;

import javax.swing.*;
import java.util.*;
import java.awt.*;

public class Janela{
    private JFrame janela = new JFrame("Controle Financeiro");
    private JPanel panelAtual = new JPanel();
    private int tamanho_borda;
    // utiliza o memento
    private Deque<JPanel> stack = new ArrayDeque<JPanel>();

    // uso do padrão singleton
    private static Janela instancia;

    private Janela() {
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.pack();
        janela.setSize(600,400);
        janela.setLocation(350, 150);
        java.net.URL url = janela.getClass().getResource("/com/controleFinanceiro/imagens/logo.png");
		java.awt.Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        janela.setIconImage(imagemTitulo);
        janela.setVisible(true);

        tamanho_borda = 10;
        
        JPanel borderNorth = new JPanel();
        borderNorth.setPreferredSize(new Dimension(tamanho_borda,tamanho_borda));
       
        JPanel borderEast = new JPanel();
        borderEast.setPreferredSize(new Dimension(tamanho_borda,tamanho_borda));
       
        JPanel borderWest = new JPanel();
        borderWest.setPreferredSize(new Dimension(tamanho_borda,tamanho_borda));
       
        JPanel borderSouth = new JPanel();
        borderSouth.setPreferredSize(new Dimension(tamanho_borda,tamanho_borda));

        janela.add(borderNorth, BorderLayout.NORTH);
        janela.add(borderSouth, BorderLayout.SOUTH);
        janela.add(borderEast, BorderLayout.EAST);
        janela.add(borderWest, BorderLayout.WEST);
    }

    public static Janela getInstancia() {
        if (instancia == null)
            instancia = new Janela();
        return instancia;
    }

    public void setConteudoJanela(JPanel panel){
        janela.remove(panelAtual);
        this.panelAtual = panel;
        stack.push(panel);
        addConteudo();
        janela.repaint();
        janela.validate();
    }

    public void addConteudo(){
        janela.add(peekStack());
        janela.setVisible(true);
    }

    public void voltarConteudo(){
        popStack();
        setConteudoJanela(popStack());
    }

    public JPanel peekStack(){
        return stack.peek();
    }

    public void pushStack(JPanel panel){
        stack.push(panel);
    }

    public JPanel popStack(){
        return stack.pop();
    }

    public void resetStack(){
        this.stack = new ArrayDeque<JPanel>();
    }
}