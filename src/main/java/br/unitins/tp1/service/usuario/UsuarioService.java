
package br.unitins.tp1.service.usuario;

import br.unitins.tp1.dto.usuario.UsuarioResponseDTO;

public interface UsuarioService {

    // UsuarioResponseDTO create(UsuarioDTO usuario);
    // void update(long id, UsuarioDTO usuario);
    // void delete(long id);
    // UsuarioResponseDTO findById(long id);
    // List<UsuarioResponseDTO> findAll();
    UsuarioResponseDTO findByUsernameAndSenha(String username, String senha);
    UsuarioResponseDTO findByUsername(String username);  
}