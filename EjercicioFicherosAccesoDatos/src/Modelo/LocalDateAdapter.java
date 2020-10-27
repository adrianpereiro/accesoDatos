package Modelo;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.xml.bind.annotation.adapters.XmlAdapter;


public class LocalDateAdapter extends XmlAdapter<String, LocalDate>{
    public LocalDate unmarshal(String v) throws Exception {
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    	LocalDate fechaPublicacion= LocalDate.parse(v, formatter);
        return fechaPublicacion;
    }

    public String marshal(LocalDate v) throws Exception {
        return v.toString();
    }

}
	
	