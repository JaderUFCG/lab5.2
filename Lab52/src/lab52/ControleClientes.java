package lab52;
/**
 * Classe que representa um Controle de clientes
 * No controle eh possivel cadastrar, remover, alterar dados e exibir clientes.
 * @author Jader Fran�a Souza Figuiredo;
 *
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;

public class ControleClientes implements Comparable{
	/** mapaClientes. Eh um mapa que tem uma String(cpf de um cliente) como Chave de um Cliente.*/
	private HashMap<String, Cliente> mapaClientes;
	
	/**
	 * Constr�i um controle de Clientes sem ser passado nenhum parametro.
	 */
	public ControleClientes(){
		this.mapaClientes = new HashMap<>();
	}	
	/**
	 * Metodo para cadastro de um Cliente no controle.
	 * @param nome para o nome do Cliente, em String.
	 * @param localTrabalho para a localizacao do trabalho do Cliente.
	 * @param email Representando o email do Cliente.
	 * @param cpf Sendo o numero do cpf em String de um Cliente.
	 * @return Uma String sobre o possivel sucesso do cadastro.
	 */
	public String cadastraCliente(String nome, String localTrabalho, String email, String cpf) {
		if (!mapaClientes.containsKey(cpf)) {
			Cliente cliente = new Cliente(nome, localTrabalho,email, cpf);
			this.mapaClientes.put(cpf, cliente);
			return cpf; 
		}else {
			throw new NoSuchElementException("Erro no cadastro do cliente: cliente ja existe.");
		}
	}
	/**
	 * Metodo para remocao de um cliente existente neste controle.
	 * @param cpf para o cpf do cliente que eh a chave de acesso do mapa onde estao cadastrados os clienetes.
	 * @return
	 */
	public String removeCliente(String cpf) {
		if (mapaClientes.containsKey(cpf)) {
			this.mapaClientes.remove(cpf);
			return "Cliente removido!";
		}else {
			throw new NoSuchElementException("Cliente inexistente");
		}
	}
	/**
	 * Edita os dados que podem ser alterados apos um cleinte ser cadastrado.
	 * @param cpf Eh o identificador do cliente.
	 * @param atributo Para o atributo a ser alterado no Cliente.
	 * @param novoValor Para o novo valor do atributo escolhido.
	 */
	public void editaCliente(String cpf, String atributo, String novoValor) {
		if("".equals(cpf)|| "".equals(atributo)|| cpf == null || atributo ==null ) {
			throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao pode ser vazio ou nulo.");
		}else if(novoValor==null || "".equals(novoValor) ){
			throw new IllegalArgumentException("Erro na edicao do cliente: novo valor nao pode ser vazio ou nulo.");
		}
		else if (mapaClientes.containsKey(cpf)) {
			if("nome".contentEquals(atributo)) {
				this.mapaClientes.get(cpf).setNome(novoValor);
			}else if("email".contentEquals(atributo)) {
				this.mapaClientes.get(cpf).setEmail(novoValor);
			}else if("localizacao".contentEquals(atributo)) {
				this.mapaClientes.get(cpf).setLocalTrabalho(novoValor);
			}else {
				throw new IllegalArgumentException("Erro na edicao do cliente: atributo nao existe.");
			}
		}
		else {
			throw new IllegalArgumentException("Erro na edicao do cliente: cliente nao existe.");
			}

		}
	/**
	 * Metodo que permite ser olhao os dados visiveis de um Cliente.
	 * @param cpf Eh o identificador do cliente.
	 * @return
	 */
	public String consultaCliente(String cpf) {
		if (mapaClientes.containsKey(cpf)) {
			return mapaClientes.get(cpf).toString();
		}else {
			throw new NoSuchElementException("Erro na exibicao do cliente: cliente nao existe.");
		}
	}
	
	/**
	 * Representa todos os clientes cadastrados nessse controlador.
	 * @return String de todos os cleintes cadastrados.
	 */
	public String retornaTodos() {
		String todosClientes = "";
		ArrayList<String> listaClientes = new ArrayList<>();
		for (Cliente c: this.mapaClientes.values()) {
			listaClientes.add(c.toString());
		}
		todosClientes += String.join(" | ", listaClientes);
		return todosClientes;
	}
	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
}
