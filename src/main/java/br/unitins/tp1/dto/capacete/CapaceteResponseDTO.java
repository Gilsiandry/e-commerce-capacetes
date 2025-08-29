package br.unitins.tp1.dto.capacete;

import br.unitins.tp1.model.capacete.Capacete;

public record CapaceteResponseDTO(
    Long id,
    String nome,
    String marca,
    String categoria,
    String modelo,
    String cor,
    int tamanho,
    Double preco) {

    public static CapaceteResponseDTO valueOf(Capacete capacete) {
        if (capacete == null)
            return null;
        return new CapaceteResponseDTO(capacete.getId(), capacete.getNome(), capacete.getMarca(), capacete.getCategoria(), capacete.getModelo(), capacete.getCor(), capacete.getTamanho(), capacete.getPreco());
    }
}