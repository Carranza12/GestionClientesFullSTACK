package web.carranza.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import web.carranza.models.clienteModel;

@Repository
public interface clienteRepository extends CrudRepository<clienteModel,Long> {
}
