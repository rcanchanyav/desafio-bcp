package pe.com.bcp.desafio.entity;

import javax.persistence.*;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Entity
@Table(name = "exchangeRate")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TipoCambio {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private String id;
    @Enumerated(EnumType.ORDINAL)
	private Moneda monedaOrigen;
    @Enumerated(EnumType.ORDINAL)
	private Moneda monedaDestino;
	private double tipoCambio;
}



