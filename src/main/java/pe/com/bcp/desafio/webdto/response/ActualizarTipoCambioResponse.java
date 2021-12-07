package pe.com.bcp.desafio.webdto.response;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Builder
@ToString
@Data
public class ActualizarTipoCambioResponse {
	private String codigo;
	private String mensaje;
}
