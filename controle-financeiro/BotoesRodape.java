import javax.swing.*;
import java.awt.*;

public class BotoesRodape {
    JLabel logo = new JLabel();
    private JButton voltar = new JButton("Voltar");
    private JButton inicio = new JButton("Início");
    private JPanel rodape = new JPanel();

    public BotoesRodape(){
        montarRodape();
    }

    public void montarRodape(){
        Font fonteBotao = new Font("SansSerif", Font.BOLD, 12);
        Color bcgColor = new Color(253,187,45);
        Color bordColor = new Color(202, 139, 2);

        voltar.setBackground(bcgColor);
        voltar.setFont(fonteBotao);
        ButtonActionRodape actionVoltar = new ButtonActionRodape("Voltar");
        voltar.addActionListener(actionVoltar);
        voltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/voltar.png"))); 
        voltar.setBorder(BorderFactory.createLineBorder(bordColor));

        inicio.setBackground(bcgColor);
        inicio.setFont(fonteBotao);
        ButtonActionRodape actionInicio = new ButtonActionRodape("Início");
        inicio.addActionListener(actionInicio);
        inicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/inicio.png"))); 
        inicio.setBorder(BorderFactory.createLineBorder(bordColor));

        JPanel marginTop = new JPanel();
        marginTop.setPreferredSize(new Dimension(0,50));

        rodape.add(marginTop, BorderLayout.PAGE_START);
        rodape.add(voltar, BorderLayout.PAGE_END);
        rodape.add(inicio, BorderLayout.PAGE_END);
    }

    public JPanel getRodape(){
        return rodape;
    }
}
