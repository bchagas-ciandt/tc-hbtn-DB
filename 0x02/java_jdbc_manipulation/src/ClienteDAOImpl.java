import java.sql.*;

public class ClienteDAOImpl implements ClienteDAO{

    Connection conn = null;

    @Override
    public Connection connect(String urlConexao) {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(urlConexao);
                return conn;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

    @Override
    public void createTable(String urlConexao) {
        conn = connect(urlConexao);
        StringBuffer sql = new StringBuffer();
        sql.append("CREATE TABLE IF NOT EXISTS cliente (");
        sql.append("id integer PRIMARY KEY AUTOINCREMENT , ");
        sql.append("nome text NOT NULL, ");
        sql.append("idade integer, ");
        sql.append("cpf text NOT NULL, ");
        sql.append("rg text ");
        sql.append(")");
        Statement st;
        try {
            st = conn.createStatement();
            st.execute(sql.toString());
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert(String url_conexao, Cliente cliente) {
        conn = connect(url_conexao);
        String sql = "insert into cliente (nome, idade, cpf, rg) values (?, ?, ?, ?)";
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, cliente.getNome());
            pstmt.setInt(2, cliente.getIdade());
            pstmt.setString(3, cliente.getCpf());
            pstmt.setString(4, cliente.getRg());
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void selectAll(String urlConexao) {
        conn = connect(urlConexao);
        String sql = "SELECT id, nome, idade, cpf, rg From cliente";
        Statement stmt;
        ResultSet rs;
        try  {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" + rs.getString("nome") + "\t" + rs.getInt("idade") + "\t" + rs.getString("cpf") + "\t" + rs.getString("rg"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(String urlConexao, int id, String name, Integer idade) {
        conn = connect(urlConexao);
        String sql = "update cliente set nome = ?, idade = ? where id = ?";
        PreparedStatement pstmt;
        try  {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setInt(2, idade);
            pstmt.setInt(3, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String urlConexao, int id) {
        conn = connect(urlConexao);
        String sql = "delete from cliente where id = ?";
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
