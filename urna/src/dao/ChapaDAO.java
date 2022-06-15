package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Partido;

/**
 *
 * @author Aluno
 */
public class ChapaDAO extends ExecuteSQL {
    public ChapaDAO(Connection con){
        super(con);
    }
    
    public String salvar(Partido chapa){
        String sql = "INSERT INTO CHAPA VALUES(?,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);            
            ps.setInt(1, chapa.getNumero());
            ps.setString(2, chapa.getDescricao());
            if(ps.executeUpdate() > 0){
                return "Produto Inserido com sucesso";
            }else{
                return "Erro ao Inserir";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
}

