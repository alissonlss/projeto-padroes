package com.SQLManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import java.awt.*;

import com.controleFinanceiro.BotoesRodape;
import com.controleFinanceiro.DataInterpret;
import com.controleFinanceiro.DataSaidaSQL;
import com.controleFinanceiro.Janela;

public class SQLManager {
    private Connection conexao = null;
    private static SQLManager Manager;
    private JPanel apresentacaoConsulta;

    private SQLManager(){
        System.out.println("SQLManager Iniciado!");
    }

    //Cadastros
    public Boolean cadastrarCliente(String cod, String Nome, String Tipo){
        boolean retorno = false;
        bancoConnect();
        String querry = ("INSERT INTO clientes_fornecedores VALUES ('" + cod + "', '" +  Nome + "', 'C', '" + Tipo+"');");
        try {
            int rsPesquisa = this.conexao.createStatement().executeUpdate(querry);
            System.out.println("Cadastrado com sucesso!");
            retorno = true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        bancoClose();
        return retorno;
    }

    public Boolean cadastrarFornecedor(String cod, String Nome, String Tipo){
        boolean retorno = false;
        bancoConnect();
        String querry = ("INSERT INTO clientes_fornecedores VALUES ('" + cod + "', '" +  Nome + "', 'F', '" + Tipo+"');");
        try {
            int rsPesquisa = this.conexao.createStatement().executeUpdate(querry);
            System.out.println("Cadastrado com sucesso!");
            retorno = true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        bancoClose();
        return retorno;
    }

    public Boolean cadastrarProduto(String Nome, float preco){
        boolean retorno = false;
        bancoConnect();
        String querry = ("" +
                "INSERT INTO produtos SELECT MAX(ID_Produto)+1, '" +  Nome + "', " + preco +" FROM produtos;");
        try {
            int rsPesquisa = this.conexao.createStatement().executeUpdate(querry);
            System.out.println("Cadastrado com sucesso!");
            retorno = true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        bancoClose();
        return retorno;
    }

    public Boolean cadastrarTransacao(String cv, String Tipo, float Valor, String data){
        boolean retorno = false;
        bancoConnect();
        try {
           ResultSet rsTeste = this.conexao.createStatement().executeQuery("SELECT CPF_CNPJ FROM clientes_fornecedores WHERE CPF_CNPJ LIKE "+cv+";");
            String querry = ("INSERT INTO transacoes SELECT MAX(ID_transacao) + 1, '" +  cv + "', '" + Tipo + "', " + Valor + ", " + data + " FROM transacoes;");
            int rsPesquisa = this.conexao.createStatement().executeUpdate(querry);
            System.out.println("Cadastrado com sucesso!");
            retorno = true;
        } catch (SQLException e) {
            System.out.println("Cliente/Fornecedor não cadastrado!");
            throw new RuntimeException(e);
        }
        bancoClose();

        return retorno;
    }

    public Boolean cadastrarCompra(int codCompra, int codT, int codP, int quant, float valor){
        boolean retorno = false;
        bancoConnect();
        String querry = ("INSERT INTO compras VALUES ('" + codCompra + "', '" +  codT + "', '" +  codP + "', '" + quant +"', '" + valor +"');");
        try {
            int rsPesquisa = this.conexao.createStatement().executeUpdate(querry);
            System.out.println("Cadastrado com sucesso!");
            retorno = true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        bancoClose();
        return retorno;
    }

    //Remover
    public boolean removerCliente_fornecedor(String cod){
        boolean retorno = false;
        bancoConnect();
        String querry = ("DELETE FROM clientes_fornecedores WHERE CPF_CNPJ = "+cod+";");
        try {
            int rsPesquisa = this.conexao.createStatement().executeUpdate(querry);
            System.out.println("Removido com sucesso!");
            retorno = true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        bancoClose();
        
        return retorno;
    }

    public Boolean removerProduto(int ID){
        boolean retorno = false;
        bancoConnect();
        String querry = ("DELETE FROM produtos WHERE ID_Produto = "+ID+";");
        try {
            int rsPesquisa = this.conexao.createStatement().executeUpdate(querry);
            System.out.println("Removido com sucesso!");
            retorno = true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        bancoClose();

        return retorno;
    }

    public Boolean removerTransacao(int ID){
        boolean retorno = false;
        bancoConnect();
        String querry = ("DELETE FROM transacoes WHERE ID_transacao = "+ID+";");
        try {
            int rsPesquisa = this.conexao.createStatement().executeUpdate(querry);
            System.out.println("Removido com sucesso!");
            retorno = true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        bancoClose();

        return retorno;
    }

    public Boolean removerCompra(int idCompra, String coluna){
        boolean retorno = false;
        bancoConnect();
        String querry = ("DELETE FROM compras WHERE"+ coluna + " = "+ idCompra+";");
        try {
            int rsPesquisa = this.conexao.createStatement().executeUpdate(querry);
            System.out.println("Removido com sucesso!");
            retorno = true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        bancoClose();

        return retorno;
    }

    //Pesquisas gerais
    public void mostrarTransacoes(){
        bancoConnect();
        try {
            ResultSet rsPesquisa = this.conexao.createStatement().executeQuery("SELECT t.ID_transacao, cf.Nome, t.Valor_total, t.Data, t.Tipo FROM transacoes AS t INNER JOIN clientes_fornecedores AS cf ON t.Comprador_Vendedor = cf.CPF_CNPJ ORDER BY t.Data");
            System.out.println("     Transações");

            String [] colunas = {"ID", "Nome", "Tipo", "Valor", "Data"};
            int cont = 0;
            Object [][] dados = new Object [25][5];

            while (rsPesquisa.next()){
                DataInterpret dataConv = new DataSaidaSQL();
                System.out.println("ID: " + rsPesquisa.getString("ID_transacao") + " || Nome: " + rsPesquisa.getString("Nome") + " Tipo: " + rsPesquisa.getString("Tipo") + " || Valor: " + rsPesquisa.getString("Valor_total") + " R$ || Data: " + dataConv.data_formatada(rsPesquisa.getString("Data")));
            
                String id = rsPesquisa.getString("ID_transacao");
                String nome = rsPesquisa.getString("Nome");
                String tipo =  rsPesquisa.getString("Tipo");
                String valor = "R$ " + rsPesquisa.getString("Valor_total");
                String data = dataConv.data_formatada(rsPesquisa.getString("Data"));
                Object [] aux = {id, nome, tipo, valor, data};

                dados[cont] = aux;

                cont++;
            }
            apresentarConsulta(colunas, dados, "Lista de Produtos");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        bancoClose();
    }
    public void mostrarProdutos(){
        bancoConnect();
        try {
            ResultSet rsPesquisa = this.conexao.createStatement().executeQuery("SELECT * FROM PRODUTOS");
            System.out.println("     Produtos");

            String [] colunas = {"ID", "Nome", "Preço"};
            int cont = 0;
            Object [][] dados = new Object [25][3];

            while (rsPesquisa.next()){
                System.out.println("ID: "+rsPesquisa.getString("ID_Produto")+" Nome: " + rsPesquisa.getString("Nome") + " Preço: " + rsPesquisa.getString("Preco") + " R$");

                String id = rsPesquisa.getString("ID_Produto");
                String nome = rsPesquisa.getString("Nome");
                String preco = "R$ " + rsPesquisa.getString("Preco");
                Object [] aux = {id, nome, preco};

                dados[cont] = aux;

                cont++;
            }
            apresentarConsulta(colunas, dados, "Lista de Produtos");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        bancoClose();
    }

    public void mostrarClientes(){
        bancoConnect();
        try {
            ResultSet rsPesquisa = this.conexao.createStatement().executeQuery("SELECT * FROM clientes_fornecedores WHERE Tipo LIKE 'C' ORDER BY Nome");
            System.out.println("     Clientes");

            String [] colunas = {"CPF_CNPJ", "Nome"};
            int cont = 0;
            Object [][] dados = new Object [25][2];

            while (rsPesquisa.next()){
                System.out.println(rsPesquisa.getString("Tipo_chave") +": " + rsPesquisa.getString("CPF_CNPJ") + " || Nome: " + rsPesquisa.getString("Nome"));

                String cpf_cnpj = rsPesquisa.getString("CPF_CNPJ");
                String nome = rsPesquisa.getString("Nome");
                Object [] aux = {cpf_cnpj, nome};

                dados[cont] = aux;

                cont++;
            }
            apresentarConsulta(colunas, dados, "Lista de Clientes");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        bancoClose();
    }

    public void mostrarFornecedores(){
        bancoConnect();
        try {
            ResultSet rsPesquisa = this.conexao.createStatement().executeQuery("SELECT * FROM clientes_fornecedores WHERE Tipo LIKE 'F' ORDER BY Nome");
            System.out.println("     Fornecedores");

            String [] colunas = {"CPF_CNPJ", "Nome"};
            int cont = 0;
            Object [][] dados = new Object [25][2];

            while (rsPesquisa.next()){
                System.out.println(rsPesquisa.getString("Tipo_chave") +": " + rsPesquisa.getString("CPF_CNPJ") + " || Nome: " + rsPesquisa.getString("Nome"));
                
                String cpf_cnpj = rsPesquisa.getString("CPF_CNPJ");
                String nome = rsPesquisa.getString("Nome");
                Object [] aux = {cpf_cnpj, nome};

                dados[cont] = aux;

                cont++;
            }
            apresentarConsulta(colunas, dados, "Lista de Fornecedores");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        bancoClose();
    }

    //Pesquisas específicas
    public void pesquisarTransacao(String coluna, String pesquisa){
        bancoConnect();
        try {
            String querry = "SELECT * FROM Transacoes WHERE " + coluna +" LIKE '%" + pesquisa + "%' ORDER BY Date;";
            ResultSet rsPesquisa = this.conexao.createStatement().executeQuery("SELECT t.ID_transacao, cf.Nome, t.Valor_total, t.Data, t.Tipo FROM transacoes AS t INNER JOIN clientes_fornecedores AS cf ON t.Comprador_Vendedor = cf.CPF_CNPJ WHERE " + coluna +" LIKE '%" + pesquisa + "%' ORDER BY t.Data");
            System.out.println("     Resultado da pesuisa");
            while (rsPesquisa.next()){
                System.out.println("ID: " + rsPesquisa.getString("ID_transacao") + " || Nome: " + rsPesquisa.getString("Nome") + " Tipo: " +rsPesquisa.getString("Tipo")+" || Valor: " + rsPesquisa.getString("Valor_total") + " R$ || Data: " + rsPesquisa.getString("Data"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        bancoClose();

    }
    public void pesquisarCliente(String coluna, String pesquisa){
        bancoConnect();
        try {
            String querry = "SELECT * FROM clientes_fornecedores WHERE " + coluna +" LIKE '%" + pesquisa + "%' AND Tipo LIKE 'C' ORDER BY Nome;";
            ResultSet rsPesquisa = this.conexao.createStatement().executeQuery(querry);
            System.out.println("     Resultado da pesquisa");
            while (rsPesquisa.next()){
                System.out.println(rsPesquisa.getString("Tipo_chave") +": " + rsPesquisa.getString("CPF_CNPJ") + " || Nome: " + rsPesquisa.getString("Nome"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        bancoClose();
    }
    public void pesquisarFornecedor(String coluna, String pesquisa){
        bancoConnect();
        try {
            String querry = "SELECT * FROM clientes_fornecedores WHERE " + coluna +" LIKE '%" + pesquisa + "%' AND Tipo LIKE 'F' ORDER BY Nome;";
            ResultSet rsPesquisa = this.conexao.createStatement().executeQuery(querry);
            System.out.println("     Resultado da pesquisa");
            while (rsPesquisa.next()){
                System.out.println(rsPesquisa.getString("Tipo_chave") +": " + rsPesquisa.getString("CPF_CNPJ") + " || Nome: " + rsPesquisa.getString("Nome"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        bancoClose();
    }
    public void pesquisarProduto(String coluna, String pesquisa){
        bancoConnect();
        try {
            String querry = "SELECT * FROM produtos WHERE " + coluna +" LIKE '%" + pesquisa + "%' ORDER BY Nome;";
            ResultSet rsPesquisa = this.conexao.createStatement().executeQuery(querry);
            System.out.println("     Produtos");
            while (rsPesquisa.next()){
                System.out.println("ID: "+rsPesquisa.getString("ID_Produto")+" Nome: " + rsPesquisa.getString("Nome") + " Preço: " + rsPesquisa.getString("Preco") + " R$");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        bancoClose();
    }

    //Conectar/Desconectar o banco
    private void bancoClose() {
        if (this.conexao != null){
            try {
                this.conexao.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar o banco de dados: " + e.getMessage());
            }
        }
    }
    private void bancoConnect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conexao = DriverManager.getConnection("jdbc:mysql://localhost/banco_tintas", "root", "");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver do banco não localizado");
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco: " + e.getMessage());
        }
    }

    // apresentação gráfica
    public void apresentarConsulta(String[] colunas, Object[][] dados, String titulo){
        this.apresentacaoConsulta = new JPanel();
        apresentacaoConsulta.setLayout(new GridLayout(0,1));
        
        JLabel nomeTitulo = new JLabel(titulo);
        nomeTitulo.setFont(new Font("Serif", Font.BOLD, 30));
        BotoesRodape rodape = new BotoesRodape();

        JPanel cabecalho = new JPanel();
        cabecalho.add(nomeTitulo);

        JTable tabela = new JTable(dados, colunas);
        JScrollPane barraRolagem = new JScrollPane(tabela);
        JScrollPane consulta = new JScrollPane(barraRolagem);

       apresentacaoConsulta.add(cabecalho);
        apresentacaoConsulta.add(consulta);
        apresentacaoConsulta.add(rodape.getRodape());

        Janela janela = Janela.getInstancia();
        janela.setConteudoJanela(apresentacaoConsulta);
    }

    //Singleton
    public static SQLManager getInstance(){
        if (Manager == null)
            Manager = new SQLManager();
        return Manager;
    }
}
