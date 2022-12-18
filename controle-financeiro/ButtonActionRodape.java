import java.awt.event.*;

public class ButtonActionRodape implements ActionListener {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ButtonActionRodape(String nome){
        name = nome;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Janela janela = Janela.getInstancia();

        if (getName() == "Voltar"){
            janela.voltarConteudo();
        }
        else if (getName() =="Início"){
            Tela inicio = new TelaInicial();
            janela.resetStack();
            inicio.defineConteudoTela();
        }
        else{
            System.out.println("Opção não encontrada!");
        }
    }
    
}
