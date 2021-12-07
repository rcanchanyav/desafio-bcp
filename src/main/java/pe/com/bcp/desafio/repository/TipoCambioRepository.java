package pe.com.bcp.desafio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.bcp.desafio.entity.Moneda;
import pe.com.bcp.desafio.entity.TipoCambio;

@Repository
public interface TipoCambioRepository extends JpaRepository<TipoCambio, String>{
	
	public Optional<TipoCambio> findByMonedaOrigenAndMonedaDestino(Moneda monedaOrigen, Moneda monedaDestino);
	
} 