/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Eleitor;
/**
 *
 * @author Aluno
 */
public class EleitorDAO extends ExecuteSQL {
    public EleitorDAO(Connection con){
        super(con);
    }
    
    public String salvar(Eleitor eleitor){
        String sql = "INSERT INTO ELEITOR VALUES(0,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);            
            ps.setInt(1, eleitor.getMatricula());
            ps.setString(1, eleitor.getNome());
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
 
  
