package web.carranza.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.carranza.models.clienteModel;
import web.carranza.repositories.clienteRepository;

import java.util.List;

@Service
public class clienteService {

    //inyeccion del repositorio
    @Autowired
    private clienteRepository repositorio_cliente;

    //método para listar todos los clientes
    public List<clienteModel> listarClientes() {
        return (List<clienteModel>) repositorio_cliente.findAll();
    }

    //metodo para guardar un cliente
    public void guardarCliente(clienteModel cliente){
        repositorio_cliente.save(cliente);
    }

    //metodo para mostrar un cliente por el id
    public clienteModel obtenerClientePorId(Long id){
        return repositorio_cliente.findById(id).get();
    }

    //metodo para eliminar un cliente (por id)
    public void eliminarCliente(Long id){
        repositorio_cliente.deleteById(id);
    }
}
