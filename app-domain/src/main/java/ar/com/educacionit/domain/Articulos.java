package ar.com.educacionit.domain;

import java.util.Date;

public class Articulos implements Entity{

	private Long id;
	private String titulo;
	private Date fechaCreacion;
	private String codigo;
	private double precio;
	private Long stock;//ctrl+f
	private Long marcasId;//alt + shift+r
	private Marcas marca;
	private Long categoriasId;
	private Categorias categoria;
	
	//hacia la db
	public Articulos(String titulo, Date fechaCreacion, String codigo, Long precio, Long stock, Long marcasId,
			Long categoriasId) {
		this.titulo = titulo;
		this.fechaCreacion = fechaCreacion;
		this.codigo = codigo;
		this.precio = precio;
		this.stock = stock;
		this.marcasId = marcasId;
		this.categoriasId = categoriasId;
	}

	// desde la db
	public Articulos(Long id, String titulo, Date fechaCreacion, String codigo, Long precio, Long stock,
			Long marcasId, Long categoriasId) {
		this.id = id;
		this.titulo = titulo;
		this.fechaCreacion = fechaCreacion;
		this.codigo = codigo;
		this.precio = precio;
		this.stock = stock;
		this.marcasId = marcasId;
		this.categoriasId = categoriasId;
	}
	//constructor
	//alt+shift+s
	
	public Articulos(Long id, String titulo, double d) {
		this.id = id;
		this.titulo = titulo;
		this.precio = d;
	}

	public Articulos() {
		
	}

	public double getPrecio() {
		return this.precio;
	}
	
	/*public String getPrecio(String pattern) {
		//##,###.00
		return this.precio.toString();
	}*/

	public String getTitulo() {
		return titulo;
	}

	public String getTitulo(boolean isUpperCase) {
		if(isUpperCase) {
			return this.titulo.toUpperCase();
		}else {
			return this.titulo;
		}
	}
	
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Long getStock() {
		return stock;
	}

	public Categorias getCategoria() {
		return categoria;
	}

	public Marcas getMarca() {
		return marca;
	}

	public void setMarca(Marcas marca) {
		this.marca = marca;
	}

	public void setCategoria(Categorias categoria) {
		this.categoria = categoria;
	}

	public void setStock(Long stock) {
		this.stock = stock;
	}

	public Long getMarcasId() {
		return marcasId;
	}

	public void setMarcasId(Long marcasId) {
		this.marcasId = marcasId;
	}

	public Long getCategoriasId() {
		return categoriasId;
	}

	public void setCategoriasId(Long categoriasId) {
		this.categoriasId = categoriasId;
	}

	
	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	
	
	
	public String toString() {
		return "Articulo [id=" + id + ", titulo=" + titulo + ", fechaCreacion=" + fechaCreacion + ", codigo=" + codigo
				+ ", precio=" + precio + ", stock=" + stock + ", marcaId=" + marcasId + ", categoriaId=" + categoriasId
				+ "]";
	}

	public void setPrecio(Double valorD) {
		// TODO Auto-generated method stub
		this.precio = valorD;
	}
	
	//get/set
	//toString
	
}
