package com.tcc.tccapi.controladores;

import com.tcc.tccapi.entidades.Usuario;
import com.tcc.tccapi.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController


@RequestMapping("/api/usuarios")
@CrossOrigin(origins="*")
public class UsuarioControlador {

    @Autowired
    UsuarioServicio usuarioServicio;

    //Crear
    @PostMapping
    public ResponseEntity<?> crear (@RequestBody Usuario usuario){

       try{
           return ResponseEntity
                   .status(HttpStatus.CREATED)
                   .body(usuarioServicio.guardarUsuario(usuario));
       }catch(Exception error){
           return ResponseEntity
                   .status(HttpStatus.BAD_REQUEST)
                   .body("{error:"+error+"}");
       }

    }

    @GetMapping
    public List<Usuario> buscarTodos(){
        List<Usuario> usuarios =StreamSupport
                .stream(usuarioServicio.buscarUsuarios().spliterator(),false)
                .collect(Collectors.toList());
        return usuarios;

    }

    //Buscar
    @GetMapping("/{id}")
    public ResponseEntity<?> leer(@PathVariable Integer id){

            Optional<Usuario> usuario= usuarioServicio.buscarUsuarioPorId(id);

            if(usuario.isPresent()){

                return ResponseEntity
                        .status(HttpStatus.OK)
                        .body(usuario);
            }else{
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body("{error: usuario no encontrado en BD}");
            }
    }

    //BuscarTODOS
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@RequestBody Usuario usuarioDatos, @PathVariable Integer id){

        Optional<Usuario> usuarioBuscado=usuarioServicio.buscarUsuarioPorId(id);

        if(usuarioBuscado.isPresent()){

            usuarioBuscado.get().setNombre(usuarioDatos.getNombre());

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(usuarioServicio.guardarUsuario(usuarioBuscado.get()));

        }else{

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("{error: usuario no encontrado en BD}");

        }

    }

}
