package lab52;

import easyaccept.EasyAccept;

/**
 * Classe que representa uma fachada dos controles de fornecedores e Clientes;
 * Classe Principal.
 * @author Jader Franca Souza Figuiredo;
 */
public class Facade {
	 
	/**
	 * Funcao Main para rodar os "easyTest's" propostos.
	 * @param args
	 */
	public static void main(String[] args){
		args = new String[] {"lab52.Facade", "cases/use_case_1.txt","cases/use_case_2.txt", "cases/use_case_3.txt",
				 "cases/use_case_4.txt",  "cases/use_case_5.txt",  "cases/use_case_6.txt"};
		EasyAccept.main(args);
	}
	/** controleClientes. Eh um controle de clientes no padrao Grud.*/
	private ControleClientes controleClientes; 
	/** controleFornecedores. Eh um controle de forncedores no padrao Grud*/
	private ControleFornecedores controleFornecedores;
	
	/**
	 * Constroi uma Facade sem sr passado nenhum parametro.
	 */
	public Facade() {
		this.controleClientes = new ControleClientes();
		this.controleFornecedores = new ControleFornecedores();
	}
	/**
	 * Metodo para adicionar Clientes no Sistema.
	 * @param cpf Representa identificacao do Cliente.
	 * @param nome Respresenta o nome do cliente.
	 * @param email Representa o email do Cliente.
	 * @param localizacao
	 * @return Uma String sobre o possivel sucesso na adicao do Cliente.
	 */
	public String adicionaCliente(String cpf, String nome, String email, String localizacao) {
		return this.controleClientes.cadastraCliente(nome, localizacao, email, cpf);
	}
	/**
	 * Metodo para remocao de um Cliente do Sistema.
	 * @param cpf Representa identificacao do Cliente..
	 * @return Uma String sobre o possivel sucesso na remocao do Cliente.
	 */
	public String removeCliente(String cpf) {
		return this.controleClientes.removeCliente(cpf); 
	}
	/**
	 * Metodo para edicao do atributo que eh passado de um Cliente.
	 * @param cpf Representa identificacao do Cliente.
	 * @param atributo Representa o atributo a ser Editado.
	 * @param novoValor Representa o novo Valor do Atributo.
	 */
	public void editaCliente(String cpf, String atributo, String novoValor) {
		controleClientes.editaCliente(cpf, atributo, novoValor);
	}
	/**
	 * Metodo para consulta dos dados de um Cliente.
	 * @param cpf Representa a identificacao de um Cliente.
	 * @return Reotorna a representacao em String de um cliente.
	 */
	public String exibeCliente(String cpf) {
		return this.controleClientes.consultaCliente(cpf);
	}
	/**
	 * @return Retorna a representacao em String de todos os Clientes cadastrados.
	 */
	public String imprimeTodosClientes() {
		return this.controleClientes.retornaTodos(); 
	}
	
	/* aqui comeca a parte responsavel pelos fornecedores*/
	
	/**
	 * Metodo para cadastro de Fornecedores no sistema.
	 * @param nome Representa o nome do fornecedor.
	 * @param email Representa o email do fornecedor.
	 * @param telefone Representa o telefone do fornecedor.
	 * @return Retorna uma String sobre o possivel sucesso no cadastro.
	 */
	public String adicionaFornecedor(String nome, String email, String telefone) {
		return this.controleFornecedores.cadastraFornecedor(nome, email, telefone);
	}
	/**
	 * Metodo para remocao de Fornecedores no sistema.
	 * @param nome Representa o nome do fornecedor.
	 * @param email Representa o email do fornecedor.
	 * @param telefone Representa o telefone do fornecedor.
	 * @return Retorna uma String sobre o possivel sucesso na remocao.
	 */
	public void removeFornecedor(String nome) {
		this.controleFornecedores.removeFornecedor(nome);
	}
	/**
	 * Metodo para edicao do email de um fornecedor.
	 * @param nome Representa o nome de um Fornecedor.
	 * @param email Representa o novo email de um Fornecedor.
	 * @return 
	 * @return Retorna uma String sobre o possivel sucesso na edicao do email.
	 */
	public void editaFornecedor(String nome, String atributo, String novoValor) {
		this.controleFornecedores.editaFornecedor(nome, atributo, novoValor);
	}
	/**
	 * @return Retorna a representacao em String de todos os Fornecedores cadastrados no sistema.
	 */
	public String imprimeTodosFornecedores() {
		return this.controleFornecedores.todosFornecedores();
	}
	public String exibeFornecedor(String nome) {
		return this.controleFornecedores.consultaFornecedor(nome);
	}
		
	/* aqui comeca a parte responsavel pelos produtos*/
	
	public void adicionaProduto(String fornecedor, String nome, String descricao, double preco) {
		this.controleFornecedores.adicionaProduto(fornecedor, nome, descricao, preco);
	}
	public void removeProduto(String nomeFornecedor, String nomeProduto, String descricao) {
		this.controleFornecedores.removeProduto(nomeFornecedor, nomeProduto, descricao);
	}
	public String exibeProduto(String nome, String descricao, String fornecedor) {
		return this.controleFornecedores.consultaProduto(fornecedor, nome, descricao);
	}
	public String imprimeTodosProdutos(String nomeFornecedor) {
		return this.controleFornecedores.todosProdutos(nomeFornecedor);
	}
	public void editaProduto(String nome, String descricao, String fornecedor, double novoPreco) {
		this.controleFornecedores.editaProduto(nome, descricao, fornecedor, novoPreco);
	}
}


