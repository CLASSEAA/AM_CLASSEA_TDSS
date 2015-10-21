package br.com.tdss.am.classea.dao.interfaces;

import br.com.tdss.am.classea.entity.Reserva;

public interface ReservaDAO {
	
	public Reserva buscarReservar(Reserva reserva);
	
	public String buscarDataAtual();
}
