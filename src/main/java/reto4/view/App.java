package reto4.view;

import java.awt.*;

import javax.swing.JFrame;

public class App 
{
    public static void main( String[] args )
    {
        var reportesView = new ReportesView();
        reportesView.setLayout(new FlowLayout());
        reportesView.setSize(600, 400);
        reportesView.setVisible(true);
        reportesView.setResizable(false);
        reportesView.setTitle("Challenge 5");
        reportesView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        reportesView.setLocationRelativeTo(null);

    }
}
