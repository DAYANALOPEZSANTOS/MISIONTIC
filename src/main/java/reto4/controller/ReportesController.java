package reto4.controller;
import reto4.model.dao.*;
import reto4.model.vo.*;

import java.sql.SQLException;
import java.util.List;

public class ReportesController {
    private ListaLideresDao listadelideresDao;
    private ComprasDao comprasDao;
    private ProyectoDao proyectoDao;

    public ReportesController(){
        proyectoDao = new ProyectoDao();
        comprasDao = new ComprasDao();
        listadelideresDao = new ListaLideresDao();
    }

    public List<ProyectoVo> listarProyectos() throws SQLException{
        return proyectoDao.listar();
    }
    public List<ComprasVo> listarCompras() throws SQLException{
        return comprasDao.listar();
    }
    public List<ListaLideresVo> listarLideres() throws SQLException{
        return listadelideresDao.listar();
    }


}
