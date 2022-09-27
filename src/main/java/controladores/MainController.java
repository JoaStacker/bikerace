/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import javax.swing.table.DefaultTableModel;
import vista.*;

/**
 *
 * @author joaquin
 */
public class MainController {
    static Main viewMain = new Main();
            
    public static void showView(){
        viewMain.setVisible(true);
        cargarParticipantes();
    }
    
    public static void cargarParticipantes(){
        DefaultTableModel data = (DefaultTableModel) viewMain.getjTableParticipants().getModel();
        data.setNumRows(0);
        for (Participant w : db.getParticipants() ) {
            Object[] row = new Object[6];
            row[0] = w.getId();
            row[1] = w.getCoinName();
            row[2] = w.getSymbol();
            row[3] = w.getBalance();
            row[4] = w.getValue_usd();
            row[5] = w.getTotal_usd();
            data.addRow(row);
        }
        getTotal();
    }
    
    public static void createSetForCreate(){
    }
    
    public static void createSetForUpdate(){
        
    }
    
    public static void crearParticipante(){
        
    }
    
    public static void actualizarParticipante(){
        
    }
    
    public static void obtenerGanador () {
        
    }
    
}
