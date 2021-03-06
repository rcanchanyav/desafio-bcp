package pe.com.bcp.desafio.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import lombok.extern.slf4j.Slf4j;
import pe.com.bcp.desafio.entity.TipoCambio;
import pe.com.bcp.desafio.service.TipoCambioService;
import pe.com.bcp.desafio.webdto.request.ActualizarTipoCambioRequest;
import pe.com.bcp.desafio.webdto.request.TipoCambioRequest;
import pe.com.bcp.desafio.webdto.response.ActualizarTipoCambioResponse;
import pe.com.bcp.desafio.webdto.response.TipoCambioResponse;

@Slf4j
@Transactional
@RequestMapping("/api/tipo-cambio")
@RestController
public class TipoCambioController {
	
	@Autowired
	private TipoCambioService service;
	
	@PostMapping(value = "/calculate", 
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
	public Single<TipoCambioResponse> calcular(@RequestBody TipoCambioRequest request) {
		log.info("Calcular Tipo Cambio");
		return service.calculateExchangeRate(request).subscribeOn(Schedulers.io());
	} 
	
	@PutMapping(value = "/update/{exchangeRate}", 
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
	public Single<ActualizarTipoCambioResponse> actualizarTipoCambio(@PathVariable("exchangeRate") Double exchangeRate,
			@RequestBody ActualizarTipoCambioRequest  updateRq) {
		log.info("Actualizar Tipo Cambio");
		return service.updateExchangeRate(exchangeRate, updateRq).subscribeOn(Schedulers.io());		
	}
	
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public Single<List<TipoCambio>> obtenerLista() {
		log.info("Devolver Lista");
		return service.getAllExchangeRate();
	} 
}
