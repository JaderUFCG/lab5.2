package lab52;

public class Validacao {

	public void removeProduto2(String nome, String descricao) {
		if(nome == null || "".equals(nome)) {
			throw new IllegalArgumentException("Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
		}
		else if(descricao == null || "".equals(descricao)) {
			throw new IllegalArgumentException("Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
		}
		
	}
	public void consultaProduto(String fornecedor, String nome, String descricao) {
		if(fornecedor == null || "".equals(fornecedor)) {
			throw new IllegalArgumentException("Erro na exibicao de produto: fornecedor nao pode ser vazio ou nulo.");
		}else if(nome == null || "".equals(nome)) {
			throw new IllegalArgumentException("Erro na exibicao de produto: nome nao pode ser vazio ou nulo.");
		}
		else if(descricao == null || "".equals(descricao)) {
			throw new IllegalArgumentException("Erro na exibicao de produto: descricao nao pode ser vazia ou nula.");
		}
		
	}
	public void editaProduto(String nome, String descricao, String fornecedor, double novoPreco) {
		if(fornecedor == null || "".equals(fornecedor)) {
			throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao pode ser vazio ou nulo.");
		}else if(nome == null || "".equals(nome)) {
			throw new IllegalArgumentException("Erro na edicao de produto: nome nao pode ser vazio ou nulo.");
		}
		else if(descricao == null || "".equals(descricao)) {
			throw new IllegalArgumentException("Erro na edicao de produto: descricao nao pode ser vazia ou nula.");
		}else if(novoPreco<0.0) {
			throw new IllegalArgumentException("Erro na edicao de produto: preco invalido.");
		}
	}
	public void adicionaProduto(String fornecedor, String nome, String descricao, double preco){
		if(fornecedor == null || "".equals(fornecedor)) {
			throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao pode ser vazio ou nulo.");
		}else if(nome == null || "".equals(nome)) {
			throw new IllegalArgumentException("Erro no cadastro de produto: nome nao pode ser vazio ou nulo.");
		}
		else if(descricao == null || "".equals(descricao)) {
			throw new IllegalArgumentException("Erro no cadastro de produto: descricao nao pode ser vazia ou nula.");
		}else if(preco<0.0) {
			throw new IllegalArgumentException("Erro no cadastro de produto: preco invalido.");
		}
	}
	
}
