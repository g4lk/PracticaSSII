package PracticaURJC.SSII;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader {

    @Autowired
    private UserRepository repositorioUsuarios;
    
    @Autowired
    private RequestRepository repositorioSolicitudes;
    
    @Autowired
    private ServiceRepository repositorioServicios;

    @PostConstruct
    private void initDatabase() {
    	
    	Usuario parla = new Usuario("pd.parla@alumnos.urjc.es", "1234","CUSTOMER");
    	Usuario raquel = new Usuario("r.rodriguezrec@alumnos.urjc.es", "1234","PROFESSIONAL");
    	Usuario chemita = new Usuario("chemita@urjc.es", "1234","ANALYST");
        Servicio s1 = new Servicio("Reparación de ordenadores","Informática","Arreglo todo tipo de ordenadores",2.,30.,raquel);
        Servicio s2 = new Servicio("Instalo antivirus","Software","Instalo panda antivirus gratis",1.,50.,raquel);
        Solicitud sol1 = new Solicitud(parla,s1,new java.sql.Date(1),new java.sql.Date(2), 60., "Calle del pepino, 5, fuenlabrada");
        List<Servicio> servicios = new ArrayList<Servicio>();
        List<Solicitud> solicitudes = new ArrayList<Solicitud>();
        repositorioUsuarios.save(parla);
        repositorioUsuarios.save(raquel);
        repositorioUsuarios.save(chemita);
        repositorioServicios.save(s1);
        repositorioServicios.save(s2);
        repositorioSolicitudes.save(sol1);
        
        
        solicitudes.add(sol1);
        s1.setSolicitudes(solicitudes);
        servicios.add(s1);
        servicios.add(s2);
        
        sol1.setCliente(parla);
        
     
        raquel.setServicios(servicios);
        
        parla.setSolicitudes(solicitudes);
        // Nuevos usuarios
        repositorioUsuarios.save(parla);
        repositorioUsuarios.save(raquel);
        repositorioUsuarios.save(chemita);
        repositorioServicios.save(s1);
        repositorioServicios.save(s2);
        repositorioSolicitudes.save(sol1);
    }


}
