import javax.swing.*;
import java.awt.*;

public class TelaCadastrar extends Tela{

    private JPanel panelCadastar = new JPanel();

    @Override
    protected void defineConteudo() {

        JLabel img = new JLabel();
        img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cadastrar.png")));

        JPanel panelTitulo = new JPanel();
        JPanel panelCorpo = new JPanel();

        //panelCorpo.setLayout(new GridLayout(2, 2, 5, 5));
        panelCorpo.setLayout(new GridLayout(0, 1, 0, 5));
        panelCorpo.setPreferredSize(new Dimension(10, 100));

        panelCadastar.setLayout(new GridLayout(0,1));

        Font fonteBotao = new Font("SansSerif", Font.CENTER_BASELINE, 15);

        JButton b1 = new JButton("Cliente/Fornecedor");
        JButton b2 = new JButton("Compra");
        JButton b3 = new JButton("Produto");
        JButton b4 = new JButton("Transação");

        b1.setFont(fonteBotao);
        b2.setFont(fonteBotao);
        b3.setFont(fonteBotao);
        b4.setFont(fonteBotao);

        ButtonActionTCadastrar action1 = new ButtonActionTCadastrar("Cliente/Fornecedor");
        b1.addActionListener(action1);
        ButtonActionTCadastrar action2 = new ButtonActionTCadastrar("Compra");
        b2.addActionListener(action2);
        ButtonActionTCadastrar action3 = new ButtonActionTCadastrar("Produto");
        b3.addActionListener(action3);
        ButtonActionTCadastrar action4 = new ButtonActionTCadastrar("Transação");
        b4.addActionListener(action4);
        
        JLabel titulo = new JLabel("Cadastrar");
        titulo.setFont(new Font("Serif", Font.BOLD, 30));

        panelTitulo.add(img);
        panelTitulo.add(titulo);

        panelCorpo.add(b1);
        panelCorpo.add(b2);
        panelCorpo.add(b3);
        panelCorpo.add(b4);

        panelCadastar.add(panelTitulo);
        panelCadastar.add(panelCorpo);

        BotoesRodape rodape = new BotoesRodape();
        panelCadastar.add(rodape.getRodape());
    }

    @Override
    protected JPanel getPanel() {
        return panelCadastar;
    }
    
}
