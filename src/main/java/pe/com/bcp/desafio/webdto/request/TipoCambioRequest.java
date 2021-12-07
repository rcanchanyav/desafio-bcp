package pe.com.bcp.desafio.webdto.request;


import lombok.Builder;
import lombok.Data;
import pe.com.bcp.desafio.entity.Moneda;

@Data
@Builder
public class TipoCambioRequest {
	private Double monto;
	private Moneda monedaOrigen;
	private Moneda monedaDestino;
}
