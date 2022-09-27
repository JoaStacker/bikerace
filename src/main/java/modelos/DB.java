package modelos;
import modelos.DB;
import modelos.Participante;
import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;

public class DB {
    private String url = "jdbc:mariadb://127.0.0.1/participantes";
    private String usr = "root";
    private String clave = "root";
    
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
        System.out.println(sql);               
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
/*    
    public void modificarParticipante(int placa,LocalTime tiempo){
        String sql = "UPDATE participantes set tiempo='%1' where placa='%2'";
        sql = sql.replace("%2", Integer.toString(placa));
        sql = sql.replace("%1", ); // ARREGLAR ASIGNACION DE TIEMPO                 
        ejecutar(sql);
    }
    public void modificarParticipante(Participante p){
        modificarAuto(p.getPlaca(),p.getTiempo);    
    }*/
    
    public void eliminarAuto(int placa){
        String sql = "DELETE FROM participantes WHERE placa= '%1'";
        sql = sql.replace("%1", Integer.toString(placa));
        ejecutar(sql);    
    }
  /*  
    public Participante buscar(int placa){
         Participante p = new Participante();
        try{
            Connection c = getConnection();
            String sql = "SELECT * from pariticipantes where placa= '%1'";
            sql = sql.replace("%1", Integer.toString(placa));
            ResultSet res = c.createStatement().executeQuery(sql);            
            if (res.next()){
                p.setPlaca(placa);
                p.setCategoria(res.getInt("categoria"));
                p.setDistancia(res.getInt("distancia"));
                p.setTiempo(res.getTime("tiempo")); //ARREGLAAAR
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return p;
    }
    
      
    public ArrayList<Participante> getParticipante(){
        ArrayList<Participante> participante = new ArrayList<>();
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
                p.setTiempo(res.getTime("tiempo")); //ARREGLAAAR
                participante.add(p);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return participante;
    }
          */  
}
