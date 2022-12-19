package com.controleFinanceiro;

import javax.swing.*;

// Baseado no DevMedia
public class JtextFieldOnlyNumber extends JTextField{

    private int maximoCaracteres = -1;
    private void jTextFieldKeyTyped(java.awt.event.KeyEvent evt) {
    
        String caracteres = "0987654321";
        if(!caracteres.contains(evt.getKeyChar()+"")){
            evt.consume();
        }
        if((getText().length() >= getMaximoCaracteres()) && (getMaximoCaracteres() != -1)){
            evt.consume();
            setText(getText().substring(0,getMaximoCaracteres()));
        }
    }

    public JtextFieldOnlyNumber() {
        super();
        addKeyListener(new java.awt.event.KeyAdapter() {
        
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldKeyTyped(evt);
            }
        });
    }

    public JtextFieldOnlyNumber(int colummns) {
        super();
        setColumns(colummns);
        addKeyListener(new java.awt.event.KeyAdapter() {
        
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldKeyTyped(evt);
            }
        });
    }

    public JtextFieldOnlyNumber(int colummns, int tam) {
        super();
        setColumns(colummns);
        setDocument(new TextDocument(tam));
        addKeyListener(new java.awt.event.KeyAdapter() {
        
            @Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldKeyTyped(evt);
            }
        });
    }
    
    public int getMaximoCaracteres() {
        return maximoCaracteres;
    }
    public void setMaximoCaracteres(int maximoCaracteres) {
        this.maximoCaracteres = maximoCaracteres;
    }
}
