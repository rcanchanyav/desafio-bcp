package pe.com.bcp.desafio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.reactivex.Single;
import pe.com.bcp.desafio.entity.Moneda;
import pe.com.bcp.desafio.entity.TipoCambio;
import pe.com.bcp.desafio.repository.TipoCambioRepository;
import pe.com.bcp.desafio.webdto.request.TipoCambioRequest;
import pe.com.bcp.desafio.webdto.response.TipoCambioResponse;

@Service
public class TipoCambioServiceImpl implements TipoCambioService {

	@Autowired
	private TipoCambioRepository repository;

	@Override
	public Single<TipoCambioResponse> calculateExchangeRate(TipoCambioRequest request) {
		double tipoCambio = obtenerTipoCambio(getAllExchangeRate().blockingGet(), 
				request.getMonedaOrigen(), request.getMonedaDestino());
		double montoResultado = request.getMonto() * tipoCambio;
		TipoCambioResponse rs= TipoCambioResponse.builder()
		.tipoCambio(tipoCambio)
		.montoResultado(montoResultado)
		.monedaOrigen(request.getMonedaOrigen())
		.monedaDestino(request.getMonedaDestino())
		.build();
		return Single.just(rs);
	}

	@Override
	public Single<String> addExchangeRate(TipoCambioRequest request) {
		return Single.create(singleSubscriber -> {
			String addedBookId = repository.save(toExchangeRate(request)).getId();
			singleSubscriber.onSuccess(addedBookId);

		});
	}

	@Override
	public Single<List<TipoCambio>> getAllExchangeRate() {
		return Single.just(repository.findAll());
	}

	public double obtenerTipoCambio(List<TipoCambio> lst, Moneda monedaOrigen, Moneda monedaDestino) {
		return lst.stream()
				.filter(x -> x.getMonedaOrigen().equals(monedaOrigen) && x.getMonedaDestino().equals(monedaDestino))
				.findFirst().map(TipoCambio::getTipoCambio).orElse(0.0);
	}

	private TipoCambio toExchangeRate(TipoCambioRequest tpRq) {
		TipoCambio tipoCambio = new TipoCambio();
		tipoCambio.setMonedaDestino(tpRq.getMonedaDestino());
		tipoCambio.setMonedaOrigen(tpRq.getMonedaOrigen());
		return tipoCambio;
	}

}
