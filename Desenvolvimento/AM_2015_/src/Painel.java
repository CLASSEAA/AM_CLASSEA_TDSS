import br.com.tdss.am.classea.dao.DaoFactory;
import br.com.tdss.am.classea.entity.Reserva;

public class Painel {
	public static void main(String[] args) {

		Reserva reserva = new Reserva();
		reserva.setIdReserva(6);

		reserva = DaoFactory.getReservaDAO().buscarReservar(reserva);
		String dataHora = DaoFactory.getReservaDAO().buscarDataAtual();
		System.out.println("ID Reserva: " + reserva.getIdReserva()+" Cliente: " + reserva.getCliente().getNome()+" Data de solicitação: "+reserva.getDataSolicitacao()+ " Status: "+reserva.isStatusReserva());
		
		for (int i = 0; i < reserva.getQuartos().size(); i++) {
			System.out.println("Quarto numero: "+reserva.getQuartos().get(i).getNumero()+" Andar do quarto: "+reserva.getQuartos().get(i).getAndar()+" Descrição quarto: "+reserva.getQuartos().get(i).getDescricaoQuarto());
		}
		System.out.println("ID funcionário: "+reserva.getFuncionario().getIdPessoa()+" Funcionario: " + reserva.getFuncionario().getNome());
		System.out.println("Data e hora atual"+dataHora);
	}
}
