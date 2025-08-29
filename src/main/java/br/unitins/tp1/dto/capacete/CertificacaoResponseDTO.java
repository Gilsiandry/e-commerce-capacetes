package br.unitins.tp1.dto.capacete;

import br.unitins.tp1.model.capacete.Certificacao;


public record CertificacaoResponseDTO(
    Long id,
    String nome,
    String pais,
    String descricao) {

    public static CertificacaoResponseDTO valueOf(Certificacao certificacao) {
        if (certificacao == null)
            return null;
        return new CertificacaoResponseDTO(certificacao.getId(), certificacao.getNome(), certificacao.getPais(), certificacao.getDescricao());
    }
}