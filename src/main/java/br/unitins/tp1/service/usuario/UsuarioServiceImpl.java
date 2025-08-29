
package br.unitins.tp1.service.usuario;

import br.unitins.tp1.dto.usuario.UsuarioResponseDTO;
import br.unitins.tp1.repository.usuario.UsuarioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class UsuarioServiceImpl implements UsuarioService {

    @Inject
    UsuarioRepository repository;

    @Override
    public UsuarioResponseDTO findByUsernameAndSenha(String username, String senha) {
        return UsuarioResponseDTO.valueOf(
                repository.findByUsernameAndSenha(username, senha)
            );

    }

    @Override
    public UsuarioResponseDTO findByUsername(String username) {
        return UsuarioResponseDTO.valueOf(
            repository.findByUsername(username)
        );
    } 
}