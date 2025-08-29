
package br.unitins.tp1.service.pedido;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import br.unitins.tp1.dto.pedido.ItemPedidoDTO;
import br.unitins.tp1.dto.pedido.PedidoDTO;
import br.unitins.tp1.dto.pedido.PedidoResponseDTO;
import br.unitins.tp1.model.capacete.Capacete;
import br.unitins.tp1.model.pedido.ItemPedido;
import br.unitins.tp1.model.pedido.Pedido;
import br.unitins.tp1.model.usuario.Usuario;
import br.unitins.tp1.repository.capacete.CapaceteRepository;
import br.unitins.tp1.repository.PedidoRepository;
import br.unitins.tp1.repository.usuario.UsuarioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class PedidoServiceImpl implements PedidoService {

    @Inject
    PedidoRepository pedidoRepository;

    @Inject
    UsuarioRepository usuarioRepository;

    @Inject
    CapaceteRepository capaceteRepository;

    @Override
    public List<PedidoResponseDTO> findByUsername(String username) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByUsername'");
    }

    @Override
    public PedidoResponseDTO findById(long idPedido, String username) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    @Transactional
    public PedidoResponseDTO create(PedidoDTO pedidoDTO, String username) {
        // obter o usuario pelo username
        Usuario usuario = usuarioRepository.findByUsername(username);

        Pedido pedido = new Pedido();
        pedido.setDataHora(LocalDateTime.now());
        // calcular o total e verificar se eh igual ao dto
        
        pedido.setTotalPedido(pedidoDTO.total());
        pedido.setUsuario(usuario);

        List<ItemPedido> listaItem = new ArrayList<ItemPedido>();
        for (ItemPedidoDTO  itemDTO : pedidoDTO.itens()) {
            Capacete capacete = capaceteRepository.findById(itemDTO.idProduto());

            ItemPedido item = new ItemPedido();
            item.setPedido(pedido);
            item.setCapacete(capacete);
            // verificar se o preco do dto eh o mesmo do produto
            item.setPreco(item.getCapacete().getPreco());
            item.setQuantidade(itemDTO.qtd());

            listaItem.add(item);

            // alterando o estoque 
            //capacete.setEstoque(capacete.getEstoque() - itemDTO.qtd());

        }

        pedido.setItens(listaItem);

        // salvando o pedido no banco de dados
        pedidoRepository.persist(pedido);

        return PedidoResponseDTO.valueOf(pedido);
    } 
}