package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.enity.Bebidas;
import model.enity.Pratos;

public class MetodosDAO {

    private static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/siri_kaskudo?verifyServerCertificate=false&useSSL=true";
    private static final String USUARIO = "root";
    private static final String SENHA = "";//insira sua senha do MYSQLWORKBENCH ou outro banco em que você usa

    private static Connection CONEXAO = null;
    private static ResultSet RESULTADO = null;
    private static Statement STMT = null;
    private static PreparedStatement PDST = null;

    //comando da tabela pratos
    private static final String MYSQL_SELELECT_CARDAPIO = "SELECT idPrato, nome_prato, descricao_prato,valor_prato FROM pratos;";
    private static final String MYSQL_SELECT_NOMEPRATOS = "SELECT idPrato, nome_prato FROM pratos";
    private static final String MYSQL_SELECT_PEDIDO_PRATO = "SELECT * FROM pratos where idPrato = ?";

    //comando da tabela bebidas
    private static final String MYSQL_SELECT_BEBIDAS = "SELECT * FROM bebidas";
    private static final String MYSQL_SELECT_PEDIDO_BEBIDA = "SELECT * FROM bebidas where idBebidas = ?";

    private Connection getConexao() {

        try {

            Class.forName(MYSQL_DRIVER);
            CONEXAO = DriverManager.getConnection(URL, USUARIO, SENHA);

        } catch (SQLException e) {
            System.out.println(e.getCause());

        } catch (ClassNotFoundException e) {
            System.out.println("Não foi possivel se conectar");
            System.out.println("Driver de conexao, não foi encontrado.");

        } catch (NullPointerException e) {
            System.out.println("Nenhum banco com esse nome foi encontrado.");

        }

        return CONEXAO;
    }

    public void exibirCardapaio() {
        try {
            STMT = getConexao().createStatement();

            System.out.println("\n\t\tBem-Vindo ao Siri-Cascudo");
            System.out.println("________________________________________________________________________________");
            System.out.println("\n\t\tVeja nosso cardapio e aproveite!\n");

            RESULTADO = STMT.executeQuery(MYSQL_SELELECT_CARDAPIO);

            while (RESULTADO.next()) {
                System.out.printf("Prato %d: %s. \n%s. \nPreco: %.2f\n\n", RESULTADO.getInt("idPrato"),
                        RESULTADO.getString("nome_prato"), RESULTADO.getString("descricao_prato"),
                        RESULTADO.getDouble("valor_prato"));
            }
            System.out.println("________________________________________________________________________________\n");

        } catch (SQLException e) {
            System.out.println("Ocorreu uma execao. " + e.getMessage());
        } finally {
            try {
                CONEXAO.close();
                STMT.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void escolherPrato() {

        try {
            STMT = getConexao().createStatement();
            RESULTADO = STMT.executeQuery(MYSQL_SELECT_NOMEPRATOS);

            while (RESULTADO.next()) {
                System.out.printf("%d: %s\n", RESULTADO.getInt("idPrato"), RESULTADO.getString("nome_prato"));
            }

        } catch (SQLException e) {
            System.out.println("Não foi possivel realizar essa operação " + e.getMessage());
        } finally {
            try {
                CONEXAO.close();
                STMT.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public Pratos finalizarPedido(int id) {

        Pratos prato = new Pratos();

        try {
            PDST = getConexao().prepareStatement(MYSQL_SELECT_PEDIDO_PRATO);

            PDST.setInt(1, id);
            RESULTADO = PDST.executeQuery();

            while (RESULTADO.next()) {
                int codigo = RESULTADO.getInt("idPrato");
                String nome = RESULTADO.getString("nome_prato");
                String desc = RESULTADO.getString("descricao_prato");
                double preco = RESULTADO.getDouble("valor_prato");
                prato = new Pratos(codigo, nome, desc, preco);
            }

        } catch (SQLException e) {
            System.out.println("Ocorreu uma exeção " + e.getMessage());
        } finally {
            try {
                CONEXAO.close();
                STMT.close();
            } catch (SQLException ex) {
                Logger.getLogger(MetodosDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return prato;
    }

    public void escolherBebida() {

        try {
            STMT = getConexao().createStatement();

            RESULTADO = STMT.executeQuery(MYSQL_SELECT_BEBIDAS);

            while (RESULTADO.next()) {
                System.out.printf("%d: %s, Preco: %.2f\n", RESULTADO.getInt("idBebidas"),
                        RESULTADO.getString("nomeBebida"), RESULTADO.getDouble("valor"));
            }

        } catch (SQLException e) {
            System.out.println("Não foi possivel realizar essa operação " + e.getMessage());
        } finally {
            try {
                CONEXAO.close();
                STMT.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage() + "\nConexao fechada.");
            }
        }
    }

    public Bebidas finalizarBebida(int id) {
        Bebidas bebida = new Bebidas();

        try {
            PDST = getConexao().prepareStatement(MYSQL_SELECT_PEDIDO_BEBIDA);

            PDST.setInt(1, id);
            RESULTADO = PDST.executeQuery();

            while (RESULTADO.next()) {
                int codigo = RESULTADO.getInt("idBebidas");
                String nome = RESULTADO.getString("nomeBebida");
                double preco = RESULTADO.getDouble("valor");
                bebida = new Bebidas(codigo, nome, preco);
            }

        } catch (SQLException e) {
            System.out.println("Ocorreu uma exeção " + e.getMessage());
        } finally {
            try {
                CONEXAO.close();
                STMT.close();
            } catch (SQLException ex) {
                Logger.getLogger(MetodosDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return bebida;
    }

}
