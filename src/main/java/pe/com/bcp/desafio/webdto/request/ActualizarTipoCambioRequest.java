package pe.com.bcp.desafio.webdto.request;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class ActualizarTipoCambioRequest {
	private String monedaOrigen;
	private String monedaDestino;
}
