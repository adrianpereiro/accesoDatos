package modelo.Entidades;

import java.util.ArrayList;

import vista.Presentacion.AsignaturaVO;

public class AsignaturaVOMapping {
	public AsignaturaVO crearAsignaturaVO(Asignatura asignatura) {
		AsignaturaVO asignaturaVO = new AsignaturaVO(asignatura.getNombre(), asignatura.getHorasSemanales(), asignatura.getIdCiclo());
		return asignaturaVO;
	}
	
	public ArrayList<AsignaturaVO> crearListaAsignaturaVO(ArrayList<Asignatura> listaAsignaturas) {
		ArrayList<AsignaturaVO> listaAsignaturasVO = new ArrayList<>();
		for(Asignatura asignatura : listaAsignaturas) {
			AsignaturaVO asignaturaVO = new AsignaturaVO(asignatura.getNombre(), asignatura.getHorasSemanales(), asignatura.getIdCiclo());
			listaAsignaturasVO.add(asignaturaVO);
		}
		return listaAsignaturasVO;
	}
	
	public Asignatura crearAsignatura(AsignaturaVO asignaturaVO) {
		Asignatura asignatura = new Asignatura(0, asignaturaVO.getNombre(), asignaturaVO.getHorasSemanales(), asignaturaVO.getIdCiclo());
		return asignatura;
	}
	
	public ArrayList<Asignatura> crearListaAsignaturas(ArrayList<AsignaturaVO> listaAsignaturasVO){
		ArrayList<Asignatura> listaAsignaturas = new ArrayList<>();
		for(AsignaturaVO asignaturaVO : listaAsignaturasVO) {
			Asignatura asignatura = new Asignatura(0, asignaturaVO.getNombre(), asignaturaVO.getHorasSemanales(), asignaturaVO.getIdCiclo());
			listaAsignaturas.add(asignatura);
		}
		return listaAsignaturas;
	}
}
