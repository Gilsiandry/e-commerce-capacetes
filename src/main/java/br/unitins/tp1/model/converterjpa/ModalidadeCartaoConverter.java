package br.unitins.tp1.model.converterjpa;

import br.unitins.tp1.model.pagamento.ModalidadeCartao;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class ModalidadeCartaoConverter implements AttributeConverter<ModalidadeCartao, Integer> {

    @Override
    public Integer convertToDatabaseColumn(ModalidadeCartao modalidadeCartao) {
        return modalidadeCartao == null ? null : modalidadeCartao.getId().intValue();
    }

    @Override
    public ModalidadeCartao convertToEntityAttribute(Integer idModalidadeCartao) {
        return ModalidadeCartao.fromId(idModalidadeCartao);
    }
    
}