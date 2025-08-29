package br.unitins.tp1.service.capacete;

import java.util.List;

import br.unitins.tp1.dto.capacete.CapaceteDTO;
import br.unitins.tp1.dto.capacete.CapaceteResponseDTO;

public interface CapaceteService {
    CapaceteResponseDTO create(CapaceteDTO capacete);
    void update(long id, CapaceteDTO capacete);
    void delete(long id);

    CapaceteResponseDTO findById(long id);

    List<CapaceteResponseDTO> findByMarca(String marca);
    List<CapaceteResponseDTO> findByCategoria(String categoria);
    List<CapaceteResponseDTO> findByModelo(String modelo);
    List<CapaceteResponseDTO> findByCor(String cor);
    List<CapaceteResponseDTO> findByTamanho(int tamanho);
    List<CapaceteResponseDTO> findByPreco(Double min, Double max);
    List<CapaceteResponseDTO> findAll();
}