package com.p3.springboot.rest.test_springboot_fullstack.pedidos.entity;

import java.util.Date;
import java.util.List;

import com.p3.springboot.rest.test_springboot_fullstack.clientes.entity.Cliente;
import com.p3.springboot.rest.test_springboot_fullstack.productospedido.entity.ProductoPedido;
import com.p3.springboot.rest.test_springboot_fullstack.tiendas.entity.Tienda;
import com.p3.springboot.rest.test_springboot_fullstack.vendedores.entity.Vendedor;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="pedido")
public class Pedido {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Date fechaCreacion;
	private Byte statusPedido;
	private String ipCliente;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idTienda",
    referencedColumnName = "id")
	private Tienda tienda;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idCliente",
    referencedColumnName = "id")
	private Cliente cliente;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idVendedor",
    referencedColumnName = "id")
	private Vendedor vendedor;
	
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="idPedido", fetch = FetchType.EAGER)
	private List<ProductoPedido> productosPedido;


	

	public Pedido(Integer id, Date fechaCreacion, Byte statusPedido, String ipCliente, Tienda tienda, Cliente cliente,
			Vendedor vendedor, List<ProductoPedido> productosPedido) {
		super();
		this.id = id;
		this.fechaCreacion = fechaCreacion;
		this.statusPedido = statusPedido;
		this.ipCliente = ipCliente;
		this.tienda = tienda;
		this.cliente = cliente;
		this.vendedor = vendedor;
		this.productosPedido = productosPedido;
	}
	
	



	public Pedido() {
		super();
	}





	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Date getFechaCreacion() {
		return fechaCreacion;
	}



	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}



	public Byte getStatusPedido() {
		return statusPedido;
	}



	public void setStatusPedido(Byte statusPedido) {
		this.statusPedido = statusPedido;
	}



	public String getIpCliente() {
		return ipCliente;
	}



	public void setIpCliente(String ipCliente) {
		this.ipCliente = ipCliente;
	}



	public Tienda getTienda() {
		return tienda;
	}



	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}



	public Cliente getCliente() {
		return cliente;
	}



	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}



	public Vendedor getVendedor() {
		return vendedor;
	}



	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}



	public List<ProductoPedido> getProductosPedido() {
		return productosPedido;
	}



	public void setProductosPedido(List<ProductoPedido> productosPedido) {
		this.productosPedido = productosPedido;
	}
	
	
	
	
	
	

}
