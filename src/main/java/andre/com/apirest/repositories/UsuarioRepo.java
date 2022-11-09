package andre.com.apirest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import andre.com.apirest.entities.Usuario;

public interface UsuarioRepo extends JpaRepository<Usuario, Long> {

}
