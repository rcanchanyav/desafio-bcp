package pe.com.bcp.desafio.webdto.response;


import lombok.Builder;
import lombok.Data;
import pe.com.bcp.desafio.entity.Moneda;

@Data
@Builder
public class TipoCambioResponse {
	private Double montoResultado;
	private Moneda monedaOrigen;
	private Moneda monedaDestino;
	private Double tipoCambio;
}
