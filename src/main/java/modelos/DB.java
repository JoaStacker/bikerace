package modelos;
import modelos.DB;
import modelos.Participante;
import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;

public class DB {
    private String url = "jdbc:mysql://localhost/bikerace";
    private String usr = "root";
    private String clave = "root1234";
    
    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url,usr,clave);
    }
    
    private void ejecutar(String sql){
        try {
            Connection c = getConnection();
            Statement s = c.createStatement();
            s.execute(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }  
    
    public ArrayList<Participante> getAllParticipantes(){
        ArrayList<Participante> participantes = new ArrayList<>();
        try{
            Connection c = getConnection();
            ResultSet res = 
                    c.createStatement()
                            .executeQuery("select * from participantes");
            while (res.next()){
                Participante p = new Participante();
                p.setPlaca(res.getInt("placa"));
                p.setCategoria(res.getInt("categoria"));
                p.setDistancia(res.getInt("distancia"));
                p.setTiempo(res.getLong("tiempo"));                
                p.setEnCarrera(res.getBoolean("en_carrera"));
                p.setTiempoInicio(res.getTime("hora_inicio").toLocalTime());
                participantes.add(p);
            }
            System.out.println(participantes.toString());

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return participantes;
    }
   
    
    public void agregarParticipante(int placa,int categoria, int distancia){
        String sql = "INSERT INTO participantes(placa,categoria,distancia) values ('%1','%2','%3')";      
        sql = sql.replace("%1", Integer.toString(placa));
        sql = sql.replace("%2", Integer.toString(categoria));
        sql = sql.replace("%3", Integer.toString(distancia));
        ejecutar(sql);
    }
    
    public void agregarParticipante(Participante p){
        agregarParticipante(p.getPlaca(),p.getCategoria(),p.getDistancia());
    }
   
    public void modificarParticipante(int placa, long tiempo){
        String sql = "UPDATE participantes set tiempo='%1' where placa='%2'";
        sql = sql.replace("%2", Integer.toString(placa));
        sql = sql.replace("%1", Long.toString(tiempo));            
        ejecutar(sql);
    }
    
    public void modificarParticipante(Participante p){
        modificarParticipante(p.getPlaca(),p.getTiempo());    
    }
    
    public void eliminarAuto(int placa){
        String sql = "DELETE FROM participantes WHERE placa= '%1'";
        sql = sql.replace("%1", Integer.toString(placa));
        ejecutar(sql);    
    }
    
    public void iniciarParticipantes(LocalTime hora_actual){
        String sql = "UPDATE participantes set tiempo='0', en_carrera='1', hora_inicio='%1'";
        sql = sql.replace("%1", hora_actual.toString());
        ejecutar(sql);
    }
    
    public int obtenerPlacaGanador(){
        String sql = "SELECT placa from participantes where tiempo=( SELECT MIN(tiempo) FROM participantes )";
        int placa = 0;
        try{
            Connection c = getConnection();
            ResultSet res = 
                    c.createStatement()
                            .executeQuery(sql);
            while(res.next()){
                if(!res.wasNull()){
                    placa = res.getInt("placa");
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return placa;
    }    
}
