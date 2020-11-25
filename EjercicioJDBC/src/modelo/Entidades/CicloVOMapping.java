package modelo.Entidades;

import java.util.ArrayList;

import vista.Presentacion.CicloVO;

public class CicloVOMapping {
	public CicloVO crearAsignaturaVO(Ciclo ciclo) {
		CicloVO cicloVO = new CicloVO(ciclo.getNombre(), ciclo.getGrado());
		return cicloVO;
	}
	
	public ArrayList<CicloVO> crearListaCiclosVO(ArrayList<Ciclo> listaCiclos) {
		ArrayList<CicloVO> listaCiclosVO = new ArrayList<>();
		for(Ciclo ciclo : listaCiclos) {
			CicloVO cicloVO = new CicloVO(ciclo.getNombre(), ciclo.getGrado());
			listaCiclosVO.add(cicloVO);
		}
		return listaCiclosVO;
	}
	
	public Ciclo crearAsignatura(CicloVO cicloVO) {
		Ciclo ciclo = new Ciclo(0, cicloVO.getNombre(), cicloVO.getGrado());
		return ciclo;
	}
	
	public ArrayList<Ciclo> crearListaCiclos(ArrayList<CicloVO> listaCiclosVO) {
		ArrayList<Ciclo> listaCiclos = new ArrayList<>();
		for(CicloVO cicloVO : listaCiclosVO) {
			Ciclo ciclo = new Ciclo(0, cicloVO.getNombre(), cicloVO.getGrado());
			listaCiclos.add(ciclo);
		}
		return listaCiclos;
	}
}
