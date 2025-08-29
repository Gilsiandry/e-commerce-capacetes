
package br.unitins.tp1.service.usuario;

import java.util.List;
import br.unitins.tp1.dto.usuario.PessoaFisicaDTO;
import br.unitins.tp1.dto.usuario.PessoaFisicaResponseDTO;

public interface PessoaFisicaService {

    PessoaFisicaResponseDTO create(PessoaFisicaDTO pessoafisica);
    void update(long id, PessoaFisicaDTO pessoafisica);
    void delete(long id);
    PessoaFisicaResponseDTO findById(long id);
    List<PessoaFisicaResponseDTO> findByNome(String nome);
    PessoaFisicaResponseDTO findByCpf(String cpf);
    List<PessoaFisicaResponseDTO> findAll();
    
}