/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Candidato;

/**
 *
 * @author Aluno
 */
public class CandidatoDAO extends ExecuteSQL {
    public CandidatoDAO(Connection con){
        super(con);
    }
    
    public String salvar(Candidato candidato){
        String sql = "INSERT INTO CANDIDATO VALUES(0,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);            
            ps.setInt(1, candidato.getNumero());
            ps.setString(1, candidato.getNome());
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
