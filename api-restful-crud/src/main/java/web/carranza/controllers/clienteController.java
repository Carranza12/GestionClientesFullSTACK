package web.carranza.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.carranza.models.clienteModel;
import web.carranza.services.clienteService;

import java.util.List;

@RestController
@RequestMapping("/api_clientes/")
@CrossOrigin(origins = "http://localhost:4200/")
public class clienteController {

    //inyectar el servicio
    @Autowired
    private clienteService servicio_cliente;

    //mapear cada peticion con su metodo correspiente
    @GetMapping("/clientes")
    public List<clienteModel> listarClientes(){
        return servicio_cliente.listarClientes();
    }
    @GetMapping("/clientes/{id}")
    public ResponseEntity<clienteModel> obtenerCliente(@PathVariable Long id){
        try {
            clienteModel cliente = servicio_cliente.obtenerClientePorId(id);
            return new ResponseEntity<clienteModel>(cliente, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<clienteModel>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/clientes")
    public void guardarCliente(@RequestBody clienteModel cliente){
        servicio_cliente.guardarCliente(cliente);
    }
    
    @PutMapping("/clientes/{id}")
    public ResponseEntity<?> actualizarCliente(@RequestBody clienteModel clienteActualizado,@PathVariable Long id){
            try {
               clienteModel clienteActual= servicio_cliente.obtenerClientePorId(id);
               clienteActual.setNombre(clienteActualizado.getNombre());
               clienteActual.setEmail(clienteActualizado.getEmail());
               clienteActual.setTelefono(clienteActualizado.getTelefono());
               servicio_cliente.guardarCliente(clienteActual); 
               return new ResponseEntity<clienteModel>(HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<clienteModel>(HttpStatus.NOT_FOUND);
            }
        }

    @DeleteMapping("/clientes/{id}")
    public void eliminarCliente(@PathVariable Long id){
        servicio_cliente.eliminarCliente(id);
    }

}
