/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import javax.swing.table.DefaultTableModel;
import vista.*;
import modelos.*;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author joaquin
 */
public class MainController {
    static DB db = new DB();
    static Main viewMain = new Main();
    static Participante SelectedParticipante = new Participante();
    static ViewWinner viewWinner = new ViewWinner();
            
    public static void showView(){
        viewMain.setVisible(true);
        cargarParticipantes();
    }
    
    public static void cargarParticipantes(){
        DefaultTableModel data = (DefaultTableModel) viewMain.getjTableParticipants().getModel();
        data.setNumRows(0);
        for (Participante p : db.getAllParticipantes() ) {
            Object[] row = new Object[6];
            row[0] = p.getPlaca();
            row[1] = p.getCategoria();
            row[2] = p.getDistancia();
            row[3] = p.getTiempo();
            row[4] = p.getEnCarrera() ? "Si" : "No";
            row[5] = p.getTiempoInicio();
            data.addRow(row);
            
        }
    }
    
    public static void crearParticipante(){
        Participante p = new Participante(
            Integer.parseInt(viewMain.getjTextFieldPlaca().getText()),
            Integer.parseInt(viewMain.getjTextFieldCategoria().getText()),
            Integer.parseInt(viewMain.getjTextFieldDistancia().getText())
        );
        
        db.agregarParticipante(p);
        
        cargarParticipantes();
    }
    
    public static void actualizarParticipante(){
        
    }
    
    public static void iniciarCarrera () {
        LocalTime hora_actual = LocalTime.now();
        db.iniciarParticipantes(hora_actual);
        cargarParticipantes();
    }
    
    public static void terminarCarrera() {
        int placa = db.obtenerPlacaGanador();
        viewWinner.setVisible(true);
        viewWinner.getjLabelGanador().setText(placa != 0 ? Integer.toString(placa) : "Sin ganador");
    }
    
    public static void finalizarParticipante() {
        LocalTime hora_llegada = LocalTime.now();
        
        DefaultTableModel tm = (DefaultTableModel) viewMain.getjTableParticipants().getModel();
        int row = viewMain.getjTableParticipants().getSelectedRow();
        int placa = Integer.parseInt(tm.getValueAt(row, 0).toString());
        LocalTime hora_inicio = LocalTime.parse(tm.getValueAt(row, 5).toString());
       
        long milis = hora_inicio.until(hora_llegada,ChronoUnit.MILLIS);
        
        SelectedParticipante.setPlaca(placa);
        SelectedParticipante.setTiempo(milis);
        
        db.modificarParticipante(SelectedParticipante);
        cargarParticipantes();
    }
    
}
