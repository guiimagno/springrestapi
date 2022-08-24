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

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Usuario> buscarUsuarioPorId(@PathVariable(value = "id") Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);

        return new ResponseEntity(usuario.get(), HttpStatus.OK);
    }

    @GetMapping(value = "/", produces = "application/json")
    public ResponseEntity<List<Usuario>> buscarTodosUsuarios() {
        List<Usuario> list = (List<Usuario>) usuarioRepository.findAll();
        return new ResponseEntity<List<Usuario>>(list, HttpStatus.OK);
    }

    @PostMapping(value = "/", produces = "application/json")
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario) {

        for (int pos = 0; pos < usuario.getTelefones().size(); pos++) {
            usuario.getTelefones().get(pos).setUsuario(usuario);
        }

        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        return new ResponseEntity<Usuario>(usuarioSalvo, HttpStatus.OK);
    }


    @PutMapping(value = "/", produces = "application/json")
    public ResponseEntity<Usuario> atualizarUsuario(@RequestBody Usuario usuario) {

        for (int pos = 0; pos < usuario.getTelefones().size(); pos++) {
            usuario.getTelefones().get(pos).setUsuario(usuario);
        }

        Usuario usuarioAtualizado = usuarioRepository.save(usuario);

        return new ResponseEntity<>(usuarioAtualizado, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = "application/text")
    public String deletarUsuario(@PathVariable("id") Long id) {
        usuarioRepository.deleteById(id);
        return "OK";
    }

   /*  @PutMapping(value = "/{iduser}/idvenda/{idvenda}", produces = "application/json")
    public ResponseEntity atualizarVenda(@PathVariable Long iduser, @PathVariable Long idvenda) {
//        Usuario usuarioSalvo = usuarioRepository.save(usuario);

        return new ResponseEntity("Venda atualizada", HttpStatus.OK);
    }

    @PostMapping(value = "/{iduser}/idvenda/{idvenda}", produces = "application/json")
    public ResponseEntity cadastrarVenda(@PathVariable Long iduser, @PathVariable Long idvenda) {

        // Usuario usuarioSalvo = usuarioRepository.save(usuario);

        return new ResponseEntity("iduser: " + iduser + "idvenda: " + idvenda, HttpStatus.OK);
    }
    */
}
