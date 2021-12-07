package pe.com.bcp.desafio.service;

import java.util.List;

import io.reactivex.Single;
import pe.com.bcp.desafio.entity.TipoCambio;
import pe.com.bcp.desafio.webdto.request.TipoCambioRequest;
import pe.com.bcp.desafio.webdto.response.TipoCambioResponse;

public interface TipoCambioService {
	
    Single<String> addExchangeRate(TipoCambioRequest request);

	Single<TipoCambioResponse> calculateExchangeRate(TipoCambioRequest request);
	
    Single<List<TipoCambio>> getAllExchangeRate();
}
