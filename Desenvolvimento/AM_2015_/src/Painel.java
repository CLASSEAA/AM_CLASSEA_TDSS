import br.com.tdss.am.classea.dao.DaoFactory;
import br.com.tdss.am.classea.entity.Reserva;

public class Painel {
	public static void main(String[] args) {
		
		Reserva reserva = new Reserva();
		reserva.setIdReserva(6);
		
		reserva = DaoFactory.getReservaDAO().buscarReservar(reserva);
		System.out.println(reserva.getCliente().getNome());
	}
}
