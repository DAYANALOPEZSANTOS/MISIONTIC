package reto4.model.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import reto4.model.vo.ProyectoVo;
import reto4.util.JDBCUtilities;

public class ProyectoDao {
    public List<ProyectoVo> listar() throws SQLException{
        ArrayList<ProyectoVo> respuesta = new ArrayList<ProyectoVo>(); 
        Connection conn = JDBCUtilities.getConnection();
        Statement stm = null;
        ResultSet rs = null;
        String consulta = "SELECT ID_Proyecto as id, Constructora, Numero_Habitaciones as habitaciones, Ciudad from Proyecto p WHERE  Clasificacion ='Casa Campestre' AND Ciudad in ('Barranquilla', 'Santa Marta', 'Cartagena')";
        try{
            stm = conn.createStatement();

            rs = stm.executeQuery(consulta);
            while (rs.next()){
                ProyectoVo vo = new ProyectoVo();
                vo.setId(rs.getInt("id"));
                vo.setConstructora(rs.getString("constructora"));
                vo.setCiudad(rs.getString("ciudad"));
                vo.setHabitaciones(rs.getInt("habitaciones"));
            
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
