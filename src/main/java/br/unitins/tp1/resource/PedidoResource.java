package br.unitins.tp1.resource;

import org.eclipse.microprofile.jwt.JsonWebToken;

import br.unitins.tp1.dto.pedido.PedidoDTO;
import br.unitins.tp1.dto.pedido.PedidoResponseDTO;
import br.unitins.tp1.service.pedido.PedidoService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("pedido")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PedidoResource {

    @Inject
    JsonWebToken jwt;

    @Inject
    PedidoService pedidoService;
    
    @POST
    @RolesAllowed({"User"})
    @Path("/criarpedido")
    public Response criarPedido(PedidoDTO dto) { 

        // obtendo o username do token
        String username = jwt.getSubject();

        // criando no bd o pedido 
        PedidoResponseDTO pedido = pedidoService.create(dto, username);

        return Response.ok().entity(pedido).build();
    }
}