package ej2;

public class Libro {
	
	private String titulo;
	private String autor;
	private int nroPaginas;
	private String isbn;
	
	public Libro(String titulo,String autor, int nroPaginas,String isbn) {
		setTitulo(titulo);
		setAutor(autor);
		setNroPaginas(nroPaginas);
		setIsbn(isbn);
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getNroPaginas() {
		return nroPaginas;
	}

	public void setNroPaginas(int nroPaginas) {
		this.nroPaginas = nroPaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", autor=" + autor + ", nroPaginas=" + nroPaginas + ", isbn=" + isbn + "]";
	}
	
	

}
