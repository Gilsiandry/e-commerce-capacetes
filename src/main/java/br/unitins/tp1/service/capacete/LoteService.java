package br.unitins.tp1.service.capacete;

import java.time.LocalDate;
import java.util.List;

import br.unitins.tp1.dto.capacete.LoteDTO;
import br.unitins.tp1.dto.capacete.LoteResponseDTO;

public interface LoteService {
    LoteResponseDTO create(LoteDTO lote);
    void update(long id, LoteDTO lote);
    void delete(long id);

    LoteResponseDTO findById(long id);

    List<LoteResponseDTO> findByCodigo(String codigo);
    List<LoteResponseDTO> findByDataFabricacao(LocalDate datafabricacao);
    List<LoteResponseDTO> findAll();
}