package lab52;
/**
 * Classe que representa um Controle de fornecedores.
 * No controle eh possivel cadastrar, remover, alterar dados e exibir fornecedores.
 * @author Jader Fran�a Souza Figuiredo;
 *
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;

public class ControleFornecedores {
	/** mapaFornecedores. Eh um mapa que tem uma String(nome de um Fornecedor) como Chave de um Fornecedor.*/
	private HashMap<String, Fornecedor> mapaFornecedores;
	private Validacao valida;
	
	/**
	 * Constr�i um controle de Fornecedores sem ser passado nenhum parametro.
	 */
	public ControleFornecedores(){
		this.mapaFornecedores = new HashMap<>();
		this.valida = new Validacao();
	}
	
	/**
	 * Metodo para cadastro de um Fornecdor no sistema.
	 * @param nome  Representa o nome do fornecedor.
	 * @param email Representa o email do fornecedor.
	 * @param telefone Representa o numero do telefone do fornecedor.
	 * @return Uma String sobre o possivel sucesso do cadastro.
	 */
	public String cadastraFornecedor(String nome, String email, String telefone) {
		if(!this.mapaFornecedores.containsKey(nome)) {
			Fornecedor fornecedorNovo = new Fornecedor(nome, email, telefone);
			this.mapaFornecedores.put(nome, fornecedorNovo);
			return nome;
		}else {
			throw new NoSuchElementException("Erro no cadastro de fornecedor: fornecedor ja existe.");
		}
	}
	/**
	 * Metodo para remocao de um Fornecedor do sistema.
	 * @param nome Representa o nome do fornecedor.
	 */
	public void removeFornecedor(String nome){
		if("".equals(nome) || nome == null) {
			throw new IllegalArgumentException("Erro na remocao do fornecedor: nome do fornecedor nao pode ser vazio.");
		}else {
			this.mapaFornecedores.remove(nome);
		}
	}
	public void editaFornecedor(String nome, String atributo, String novoValor) {
		if("nome".equals(atributo)) {
			throw new IllegalArgumentException("Erro na edicao do fornecedor: nome nao pode ser editado.");
		}
		if(novoValor==null || "".equals(novoValor) ){
			throw new IllegalArgumentException("Erro na edicao do fornecedor: novo valor nao pode ser vazio ou nulo.");
		}else if(atributo == null || "".equals(atributo) ){
			throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao pode ser vazio ou nulo.");
		}else if(!(("email").equals(atributo)||"telefone".equals(atributo))){
			throw new IllegalArgumentException("Erro na edicao do fornecedor: atributo nao existe.");
		}
		else if(this.mapaFornecedores.containsKey(nome)) {
			if (mapaFornecedores.containsKey(nome)) {
				if("email".equals(atributo)) {
					this.mapaFornecedores.get(nome).setEmail(novoValor);
				}
				else if("telefone".contentEquals(atributo)) {
					this.mapaFornecedores.get(nome).setTelefone(novoValor);
				}
			}
		}
	}
	/**
	 * Metodo para Consulta dos dados de um fornecedor.
	 * @param nome Representa o nome do fornecedor.
	 * @return A representacao em String de um fornecedor.
	 */
	public String consultaFornecedor(String nome) {
		if(this.mapaFornecedores.containsKey(nome)) {
			return this.mapaFornecedores.get(nome).toString();
		}else {
			throw new NoSuchElementException("Erro na exibicao do fornecedor: fornecedor nao existe.");
		}
	}
	/**
	 * @return Retorna a representacao em String de todos os fornecedores cadastrados.
	 */
	public String todosFornecedores() {
		ArrayList<String>listaFornecedores = new ArrayList<>();
		String fornecedores = "Fornecedores:" + System.lineSeparator();
		for(Fornecedor f: this.mapaFornecedores.values()) {
			listaFornecedores.add(f.toString());
		}
		fornecedores += String.join(" | ", listaFornecedores);
		
		return fornecedores;
	}
	/**
	 * O controle de fornecedor tambem gerencia os seus produtos.
	 * Metodo para o cadastro de fornecedores no Sistema.
	 * @param nomeFornecedor Representa o nome do fornecedor.
	 * @param nomeProduto Representa o nome do produto.
	 * @param descricao Representa a descricao do Produto.
	 * @param preco Representa o preco do Produto.
	 * @return Uma String sobre o possivel sucesso do cadastro.
	 */
	public void adicionaProduto(String fornecedor, String nome, String descricao, double preco) {
		this.valida.adicionaProduto(fornecedor, nome, descricao, preco);
		if(!this.mapaFornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro no cadastro de produto: fornecedor nao existe.");
		}else {
				this.mapaFornecedores.get(fornecedor).cadastraProduto(nome, descricao, preco);
			}
		}
	/**
	 * Metodo para remocao de um produto do fornecedor.
	 * @param nomeFornecedor Representa o nome do fornecedor.
	 * @param nomeProduto Representa o nome do produto.
	 * @param descricao Representa a descricao do produto
	 * @return Retorna uma String sobre o possivel sucesso na remocao do produto.
	 */
	public void removeProduto(String nome, String descricao, String fornecedor){
		if(nome==null ||"".equals(nome)) {
			throw new IllegalArgumentException("Erro na remocao de produto: nome nao pode ser vazio ou nulo.");
		}else if(descricao==null ||"".equals(descricao)) {
			throw new IllegalArgumentException("Erro na remocao de produto: descricao nao pode ser vazia ou nula.");
		}else if(fornecedor==null ||"".equals(fornecedor)) {
			throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao pode ser vazio ou nulo.");
		}
		if(!this.mapaFornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro na remocao de produto: fornecedor nao existe.");
		}this.mapaFornecedores.get(fornecedor).removeProduto(nome, descricao);
		
	}
	
	/**
	 * Metodo para consulta de um  produtos de um fornecedor.
	 * @param nomeFornecedor Representa o nome do fornecedor.
	 * @param nomeProduto Representa o nome do produto.
	 * @param descricao Representa a descricao do produto
	 * @return A representacao em String de um produto.
	 */
	public String consultaProduto(String nomeFornecedor, String nomeProduto, String descricao) {
		this.valida.consultaProduto(nomeFornecedor, nomeProduto, descricao);
		if(this.mapaFornecedores.containsKey(nomeFornecedor)) {
			return this.mapaFornecedores.get(nomeFornecedor).consultaProduto(nomeProduto, descricao);
		}else {
			throw new NoSuchElementException("Erro na exibicao de produto: fornecedor nao existe.");
		}
	}
	public String todosProdutos(String nomeFornecedor) {
		if(this.mapaFornecedores.containsKey(nomeFornecedor)) {
			return this.mapaFornecedores.get(nomeFornecedor).todosProdutos();
		}else {
			throw new NoSuchElementException("Erro na exibicao de produto: fornecedor nao existe.");
		}
	}
	public void editaProduto(String nome, String descricao, String fornecedor, double novoPreco) {
		this.valida.editaProduto(nome,descricao, fornecedor, novoPreco);
		if(!this.mapaFornecedores.containsKey(fornecedor)) {
			throw new IllegalArgumentException("Erro na edicao de produto: fornecedor nao existe.");
		}
		this.mapaFornecedores.get(fornecedor).alteraPrecoProduto(nome, descricao, novoPreco);
	}
	public String alteraPreco(String nomeFornecedor, String nomeProduto, String descricao, double preco) {
		if(this.mapaFornecedores.containsKey(nomeFornecedor)) {
			return this.mapaFornecedores.get(nomeFornecedor).alteraPrecoProduto
					(nomeProduto, descricao, preco);
	}else {
		throw new NoSuchElementException("Erro na edicao de produto: fornecedor nao existe.");
		}
	}
}
