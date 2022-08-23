package curso.spring.rest.api.springrestapi.repository;

import curso.spring.rest.api.springrestapi.model.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario,Long> {

}
