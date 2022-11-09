package andre.com.apirest.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import andre.com.apirest.entities.Usuario;
import andre.com.apirest.repositories.UsuarioRepo;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioRepo usuarioRepository;

	@GetMapping
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	@PostMapping
	public Usuario insert(@RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@DeleteMapping(value = "/{idUser}")
	public ResponseEntity<String> delete(@PathVariable Long idUser) {
		usuarioRepository.deleteById(idUser);
		return new ResponseEntity<String>("usuario deletado", HttpStatus.OK);

	}

	@GetMapping(value = "/{idUser}")
	public Usuario findbyId(@PathVariable Long idUser) {

		Optional<Usuario> usuario = usuarioRepository.findById(idUser);
		if (usuario.isEmpty()) {
			return null;
		} else {

			return usuario.get();
		}

	}
}
