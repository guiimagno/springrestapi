package curso.spring.rest.api.springrestapi.controller;

import curso.spring.rest.api.springrestapi.model.Usuario;
import curso.spring.rest.api.springrestapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/usuario")
public class IndexController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping(value = "/{id}/relatoriopdf", produces = "application/json")
    public ResponseEntity<Usuario> relatorio(@PathVariable(value = "id") Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);

        return new ResponseEntity(usuario.get(), HttpStatus.OK);
    }

    @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        List<Usuario> list = (List<Usuario>) usuarioRepository.findAll();
        return new ResponseEntity<List<Usuario>>(list, HttpStatus.OK);
    }

    @PostMapping(value = "/", produces = "application/json")
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        return new ResponseEntity<Usuario>(usuarioSalvo, HttpStatus.OK);
    }

    @PostMapping(value = "/{iduser}/idvenda/{idvenda}", produces = "application/json")
    public ResponseEntity cadastrarVenda(@PathVariable Long iduser, @PathVariable Long idvenda) {
//        Usuario usuarioSalvo = usuarioRepository.save(usuario);


        return new ResponseEntity("iduser: " + iduser + "idvenda: " + idvenda, HttpStatus.OK);
    }

    @PutMapping(value = "/", produces = "application/json")
    public ResponseEntity<Usuario> updateUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioAtualizado = usuarioRepository.save(usuario);

        return new ResponseEntity<>(usuarioAtualizado, HttpStatus.OK);
    }

    @PutMapping(value = "/{iduser}/idvenda/{idvenda}", produces = "application/json")
    public ResponseEntity update(@PathVariable Long iduser, @PathVariable Long idvenda) {
//        Usuario usuarioSalvo = usuarioRepository.save(usuario);

        return new ResponseEntity("Venda atualizada", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = "application/text")
    public String deleteUsuario(@PathVariable("id") Long id) {
        usuarioRepository.deleteById(id);
        return "OK";
    }
}
