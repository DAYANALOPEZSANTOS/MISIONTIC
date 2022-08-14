package reto4.view;

import reto4.controller.ReportesController;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.awt.*;



import reto4.model.vo.*;


public class ReportesView extends JFrame implements ActionListener{
        private ReportesController controller;
        private JMenuBar menuBar;
        private JMenu menu;
        private JMenuItem primerInf,segunsdoInf,tercerInf;
        private JTable tabla;
        private DefaultTableModel modelo;
        private JLabel lblTitulo, lblConsulta;
        


        public ReportesView(){
            controller = new ReportesController();
            menu();
            etiqueta1();
            etiqueta2();
            tabla();
        }
        public void tabla(){
            tabla = new JTable(modelo);
            tabla.setPreferredScrollableViewportSize(new Dimension(500,200));
            add(tabla);
            JScrollPane pane =new JScrollPane(tabla);

            add(pane);

        }
        public void etiqueta1(){
            lblTitulo=new JLabel("REPORTS OF CHALLENGE 5");
            lblTitulo.setPreferredSize(new Dimension(500, 30));
            lblTitulo.setFont(new Font("Arial", Font.BOLD, 20 ));
            add(lblTitulo);

        }
        public void etiqueta2(){
            lblConsulta=new JLabel();
            lblConsulta.setPreferredSize(new Dimension(500, 30));
            lblConsulta.setFont(new Font("Arial", Font.BOLD, 10 ));
            add(lblConsulta);

        }
        public void menu (){
            menuBar=new JMenuBar();
            setJMenuBar(menuBar);
            menu=new JMenu("REPORTS");
            menuBar.add(menu);
            primerInf=new JMenuItem("Primer informe");
            segunsdoInf=new JMenuItem("Segundo informe");
            tercerInf=new JMenuItem("Tercer informe");
            menu.add(primerInf);
            menu.add(segunsdoInf);
            menu.add(tercerInf);
            primerInf.addActionListener(this);
            segunsdoInf.addActionListener(this);
            tercerInf.addActionListener(this);

        }
        public void segundoInforme() {

                try{
                    List<ProyectoVo> proyectos = controller.listarProyectos();
                    modelo=new DefaultTableModel();
                    modelo.addColumn("id proyecto");
                    modelo.addColumn("Constructura");
                    modelo.addColumn("Habitaciones");
                    modelo.addColumn("Ciudad");
    
                    for(ProyectoVo proyecto: proyectos){
                    Object[] fila=new Object[4];
                    fila[0]=proyecto.getId();
                    fila[1]=proyecto.getConstructora();
                    fila[2]=proyecto.getHabitaciones();
                    fila[3]=proyecto.getCiudad(); 
                    modelo.addRow(fila); 
    
                    }
                    tabla.setModel(modelo);
                    modelo.fireTableDataChanged();
                    }
                
                catch(Exception e){
                    System.out.println("Error: " + e.getMessage());
                }     
        }
        public void tercerInforme() {
        
                try{
                    List<ComprasVo> deudas = controller.listarCompras();
                    modelo=new DefaultTableModel();
                    modelo.addColumn("id");
                    modelo.addColumn("Constructora");
                    modelo.addColumn("Banco");
                   
    
                    for(ComprasVo deuda: deudas){
                    Object[] fila=new Object[3];
                    fila[0]=deuda.getId();
                    fila[1]=deuda.getConstructora();
                    fila[2]=deuda.getBanco();

                    modelo.addRow(fila); 
    
                    }
                    tabla.setModel(modelo);
                    modelo.fireTableDataChanged();
                }
                catch(Exception e){
                    System.out.println("Error: " + e.getMessage());
                }

            
        }
        public void primerInforme() {
            
            try{
                List<ListaLideresVo> lideres = controller.listarLideres();
                modelo=new DefaultTableModel();
                modelo.addColumn("id Lider");
                modelo.addColumn("Nombre");
                modelo.addColumn("Apellido");
                modelo.addColumn("Ciudad");

                for(ListaLideresVo lider: lideres){
                Object[] fila=new Object[4];
                fila[0]=lider.getId();
                fila[1]=lider.getNombre();
                fila[2]=lider.getApellido();
                fila[3]=lider.getCiudad(); 
                modelo.addRow(fila); 

                }
                tabla.setModel(modelo);
                modelo.fireTableDataChanged();
            }
            catch(Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            if(e.getSource() == primerInf){
                primerInforme();
                lblConsulta.setText("Informe de lideres");
            }
            if(e.getSource() == segunsdoInf){
                segundoInforme();
                lblConsulta.setText("Informe de proyectos de casas campestres en Cartagena, Barranquilla y Santa Marta");
            }
            if(e.getSource() == tercerInf){
                tercerInforme();
                lblConsulta.setText("Informe de compras realizadas por proyectos en la ciudad de Salento y provedor Homecenter");
            }
        }

}
