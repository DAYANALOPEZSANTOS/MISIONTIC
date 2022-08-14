package reto4.model.dao;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import reto4.util.*;
import java.util.List;
import java.util.ArrayList;
import reto4.model.vo.ComprasVo;

public class ComprasDao {
    public List<ComprasVo> listar() throws SQLException{
        ArrayList<ComprasVo> respuesta = new ArrayList<ComprasVo>();
        Connection conn = JDBCUtilities.getConnection();
        Statement stm = null;
        ResultSet rs = null;
        String consulta = "SELECT ID_Compra as id,  p.Constructora, p.Banco_Vinculado from Compra c join Proyecto p ON c.ID_Proyecto = p.ID_Proyecto where Proveedor = ('Homecenter') and p.Ciudad = ('Salento')";

        try{
            stm = conn.createStatement();
            rs = stm.executeQuery(consulta);
            while(rs.next()){
                ComprasVo vo = new ComprasVo();
                vo.setId(rs.getInt("id"));
                vo.setConstructora(rs.getString("Constructora"));
                vo.setBanco(rs.getString("Banco_vinculado"));
                respuesta.add(vo);
            }
        }
        finally{
            if (rs != null){
                rs.close();
            }
            if (stm != null){
                stm.close();
            }
            if(conn != null){
                conn.close();
            }
        }
        return respuesta;
    }

}