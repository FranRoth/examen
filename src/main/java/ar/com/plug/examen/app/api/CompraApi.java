package ar.com.plug.examen.app.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import ar.com.plug.examen.domain.model.Cliente;
import ar.com.plug.examen.domain.model.Producto;
import ar.com.plug.examen.domain.model.Vendedor;

public class CompraApi {
	
	@JsonProperty
	private Long id;
	@JsonProperty
	private String description;
	@JsonProperty
	private Long value;
	@JsonProperty
	private Cliente cliente;
	@JsonProperty
	private Producto produco;
	@JsonProperty
	private Vendedor vendedor;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getValue() {
		return value;
	}
	public void setValue(Long value) {
		this.value = value;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Producto getProduco() {
		return produco;
	}
	public void setProduco(Producto produco) {
		this.produco = produco;
	}
	public Vendedor getVendedor() {
		return vendedor;
	}
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

}
