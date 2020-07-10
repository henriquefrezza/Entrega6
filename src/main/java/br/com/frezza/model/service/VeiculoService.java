package br.com.frezza.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.frezza.model.beans.Veiculo;
import br.com.frezza.model.repository.VeiculoRepository;
import br.com.frezza.model.utils.Calculadora;

@Service
public class VeiculoService {
	
	@Autowired
	private VeiculoRepository veiculoRepo;
	
	@Autowired
	private Calculadora calculadora;
	
	public void salvar (Veiculo veiculo) {
		veiculoRepo.save(veiculo);
	}
	
	public List<Veiculo> listarTodos() {
		List<Veiculo> lista = veiculoRepo.findAll();
		for (Veiculo veiculo: lista) {
			veiculo.setAutonomia(calculadora.calculaMedia(veiculo.getCapacidadeTanque(), veiculo.getKml()));
		}
		return lista;
	}
}