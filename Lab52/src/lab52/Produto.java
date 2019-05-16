package lab52;
/**
 * Classe que representa um Produto.
 * Todo produto possui um nome, descricao e seu preco. Eh identificado unicamente seu nome e descricao.
 * @author Jader Fran�a Souza Figuiredo;
 *
 */
public class Produto {
	/** nome. Eh uma String que representa o nome de um produto.*/
	private String nome;
	/** descricao. String que representa a descricao de um produto.*/
	private String descricao;
	/** preco. Valor double referente ao preco de um produto.*/
	private double preco;
	
	/**
	 * Constroi um Produto a partir de seu nome, descricao e preco.
	 * @param nome para o nome do Produto a ser criado.
	 * @param descricao as caracteristicas de um produto..
	 * @param preco para o preco do produto.
	 */
	public Produto(String nome, String descricao, double preco) {
		if("".equals(nome)) {
			throw new NullPointerException("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		}if("".equals(nome.trim())|| "".equals(descricao.trim())) {
			throw new IllegalArgumentException("Algum atributo vazio");
		}
		if(preco == 0.0) {
			throw new IllegalArgumentException("Preco invalido: 0,0 - Quer ganhar dinheiro nn eh?");
		}
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
	}
	
	
	/**
	 * Metodo que permite a alteracao do preco de um produto.
	 * @return void.
	 */
	public void setPreco(double preco) {
		this.preco = preco;
	}

	/**
	 * Altera o hashCode do object da classe.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		long temp;
		temp = Double.doubleToLongBits(preco);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/**
	 * Altera o equals do object da classe.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (Double.doubleToLongBits(preco) != Double.doubleToLongBits(other.preco))
			return false;
		return true;
	}

	/**
	 * Retorna a representacao em String do Produto, contendo seu nome + descricao + preco.
	 * @return Uma String que repreenta os dados de um produto.
	 */
	public String toString() {
		return (this.nome + " - " +  this.descricao + " - " + "R$" + String.format("%.2f", preco));
	}
}
