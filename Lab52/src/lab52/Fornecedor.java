package lab52;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Classe que representa um Fornecedor.
 * Todo fornecedor possui um nome, email e telefone; porem eh identificado unicamente
 *  por seu nome.
 *  Todo fornecedor possui um controle para gerenciar os seus produtos;
 * @author Jader Fran�a Souza Figuiredo;
 *
 */
public class Fornecedor {
	/** nome. Eh uma String que representa o nome de um Fornecedor.*/
	private String nome; 
	/** email. String que representa o email do fornecedor.*/
	private String email;
	/** telefone. Eh uma String que representa telefone para contato de um fornecedor.*/
	private String telefone;
	/** controProdutos. Representa o controle de produtos de um fornecedor.*/
	private Validacao valida;
	private Map<String, Produto> mapaProdutos;
	
	/**
	 * Constroi um Fornecdor a partir de seu nome, email e telefone..
	 * @param nome para o nome do Fornecedor a ser criado.
	 * @param Email para o email do fornecedor.
	 */
	public Fornecedor(String nome, String email, String telefone) {
		if(nome ==null || "".equals(nome.trim()) ) {
			throw new NullPointerException("Erro no cadastro do fornecedor: nome nao pode ser vazio ou nulo.");
		}
		if(email ==null || "".equals(email.trim()) ) {
			throw new NullPointerException("Erro no cadastro do fornecedor: email nao pode ser vazio ou nulo.");
		}
		if(telefone ==null || "".equals(telefone.trim()) ) {
			throw new NullPointerException("Erro no cadastro do fornecedor: telefone nao pode ser vazio ou nulo.");
		}
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.valida = new Validacao();
		this.mapaProdutos = new HashMap<>();
	}

	/**
	 * Altera o hashCode do object da classe.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		return result;
	}

	/**
	 * Altera o equals do object da classe.
	 * @param obj. para o objeto a ser comparado.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fornecedor other = (Fornecedor) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}
	
	/**
	 * Metodo que permite a alteracao do telefone de um fornecedor.
	 * @param telefone. para o numero do telefone de um fornecedor a ser alterado.
	 * @return void.
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	/**
	 * Metodo que permite a alteracao do email de um fornecedor.
	 * @param email. para o email de um fornecedor a ser alterado.
	 * @return void.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Retorna a representacao em String do Fornecedor, contendo seu nome + email + telefone.
	 * @return Uma String que repreenta os dados de um fornecedor.
	 */
	public String toString() {
		return nome + " - " + email + " - " + telefone;
	}
	
	/**
	 * Metodo para cadastro de um produto a partir do controle de produtos que todo fornecedor possui
	 * Retorna a representacao em String sobre o cadastro do produto.
	 * @param nome. Para o nome do produto a ser cadastrado.
	 * @param descricao. Para a descricao do produto a ser cadastrado.
	 * @return Uma String que repreenta uma confirmacao do cadastro do produto.
	 */
	public void cadastraProduto(String nome, String descricao, 
			double preco) {
		if (!this.mapaProdutos.containsKey(nome + " " + descricao)) {
			Produto prod = new Produto(nome,descricao,preco);
			this.mapaProdutos.put(nome + " " + descricao, prod);
		}else {
			throw new NoSuchElementException("Erro no cadastro de produto: produto ja existe.");
		}
	}
	
	/**
	 * Metodo para remocao de um produto a partir do controle de produtos que todo fornecedor possui
	 * Retorna a representacao em String sobre a remocao do produto.
	 * @param nome. Para o nome do produto a ser removido.
	 * @param descricao. Para a descricao do produto a ser removido.
	 * @return Uma String que repreenta uma confirmacao do remocao do produto.
	 */
	public void removeProduto(String nome, String descricao) {
		if (!this.mapaProdutos.containsKey(nome + " " + descricao)) {
			throw new IllegalArgumentException("Erro na remocao de produto: produto nao existe.");
		}else {
			this.mapaProdutos.remove(nome + " " + descricao);
		}
	}
	/**
	 * Retorna a representacao em String do produto ao ser passado seu nome e descricao.Isto a partir
	 * do controle de Produtos que todo fornecedor possui.
	 * @param nome. Para o nome do produto a ser consultado.
	 * @param descricao. Para a descricao do produto a ser consultado.
	 * @return A String que repreenta o produto a ser consultado.*/
	public String consultaProduto(String nome, String descricao) {
		if(!this.mapaProdutos.containsKey(nome + " " + descricao)) {
			throw new NoSuchElementException("Erro na exibicao de produto: produto nao existe."); 
		}else {
			return this.mapaProdutos.get(nome + " " + descricao).toString();
		}
	}
	
	/**
	 * Retorna a representacao em String de todos os produtos que o fornecedor possui cadastrado
	 * do controle de Produtos que todo fornecedor possui.
	 * @return A String que repreenta todos os produtos do fornecedor**/
	public String todosProdutos() {
		ArrayList<String> produtos = new ArrayList<>();
		for(Produto p: this.mapaProdutos.values()) {
			produtos.add(p.toString());
		}
		return "Produtos:" + System.lineSeparator() + String.join(" | ", produtos);
	}
	/**
	 * Metodo para alteracao do preco de um produtos a partir do cotrole de Produtos que todo 
	 * fornecedor possui
	 * @param nome. Para o nome do produto que vai ser alterado.
	 * @param descricao. Para a descricao do produto que vai ser alterado.
	 * @return Uma string de confirmacao sobre a alteracao
	 */
	public String alteraPrecoProduto(String nome, String descricao, double preco) {
		if(!this.mapaProdutos.containsKey(nome + " " + descricao)) {
			throw new NoSuchElementException(); 
		}else {
			this.mapaProdutos.get(nome + " " + descricao).setPreco(preco);
			return "Preco do produto alterado com sucesso!";
		}
	}
}
