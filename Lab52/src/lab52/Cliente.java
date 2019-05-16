package lab52;
/**
 * Classe que representa um Cliente.
 * Todo cliente possui um nome, cpf, email, local de trabalho; porem eh identificado unicamente
 *  por seu cpf.
 * @author Jader Fran�a Souza Figuiredo;
 *
 */
public class Cliente {
	/** nome. Eh uma String que representa o nome de um cliente.*/
	private String nome;
	/** cpf. Eh uma String que representa o cpf de um cliente.*/
	private String cpf;
	/** email. Eh uma String que representa o email de um cliente.*/
	private String email;
	/** localTrabalho. Eh uma String que representa o lugar de trablaho de um cliente.*/
	private String localTrabalho;
	
	/**
	 * Constroi um Cliente a partir de seu nome, local de trabalho, email e cpf.
	 * @param nome para o nome do Cliente a ser criado.
	 * @param localTrabalho para o lugar onde o cliente trabalha.
	 * @param email para o email do cliente.
	 * @param cpf para o cpf do cliente;
	 */
	public Cliente(String nome, String localTrabalho, String email, String cpf) {
		if(nome == null || "".equals(nome.trim())) {
			throw new NullPointerException("Erro no cadastro do cliente: nome nao pode ser vazio ou nulo.");
		}
		if(email == null || "".equals(email.trim())) {
			throw new NullPointerException("Erro no cadastro do cliente: email nao pode ser vazio ou nulo.");
		}
		if(cpf== null || "".equals(cpf.trim()) ){
			throw new NullPointerException("Erro no cadastro do cliente: cpf invalido.");
		}
		if(cpf.length() != 11) {
			throw new IllegalArgumentException("Erro no cadastro do cliente: cpf invalido.");
		}
		if(localTrabalho == null|| "".equals(localTrabalho.trim())){ 
			throw new NullPointerException("Erro no cadastro do cliente: localizacao nao pode ser vazia ou nula.");
		}
		
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.localTrabalho = localTrabalho;
	}
	
	/**
	 * Altera o hashCode do object da classe.
	 * @return um inteiro que representa o codigo hash
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}

	/**
	 * Altera o equals do Object.
	 * @return um valor booleano das comparacoes.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false; 
		return true;
	}
	/**
	 * Retorna a representacao em String de um cliente, contendo seu nome + local de trabalho + email.
	 * @return Uma String que repreenta os dados de um cliente.
	 */
	public String toString() {
		return(nome + " - " + localTrabalho + " - " + email);
	}

	/**
	 * Metodo que permite a alteracao do nome de um cliente.
	 * @param nome. Para o nome a ser alterado neste set.
	 * @return vazio.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Metodo que permite a alteracao do email de um cliente.
	 * @param email. Para o email a ser alterado neste set.
	 * @return vazio.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Metodo que permite a alteracao do local de trabalho de um cliente.
	 *  @param localTrabalho. Para o locald e trabalho a ser alterado neste set.
	 * @return void.
	 */
	public void setLocalTrabalho(String localTrabalho) {
		this.localTrabalho = localTrabalho;
	}
	
	
	
}
