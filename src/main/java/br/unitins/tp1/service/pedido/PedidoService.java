
package br.unitins.tp1.service.pedido;

import java.util.List;
import br.unitins.tp1.dto.pedido.PedidoDTO;
import br.unitins.tp1.dto.pedido.PedidoResponseDTO;

public interface PedidoService {

    List<PedidoResponseDTO> findByUsername(String username);
    PedidoResponseDTO findById(long idPedido, String username); 
    PedidoResponseDTO create(PedidoDTO pedido, String username);
    
}