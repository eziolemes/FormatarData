package utilitarios;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

import bean.ParametroBean;

public class FormataData {
	
	static DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public static String padraoUS(String data){
		StringTokenizer st = new StringTokenizer(data, "/");
		
		String dia = st.nextToken();
		String mes = st.nextToken();
		String ano = st.nextToken();
		
		return ano + "-" + mes + "-" + dia;
	}
	public static String padraoBR(String data){
		StringTokenizer st = new StringTokenizer(data, "-");
		
		String ano = st.nextToken();
		String mes = st.nextToken();
		String dia = st.nextToken();
		
		return dia + "/" + mes + "/" + ano;
	}
	
	public static Date padraoUs(String dataBR){
		String dataUs = padraoUS(dataBR);
		Date data = new Date();
		try {
			data = sdf.parse(dataUs);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Erro ao converter data!\n" + e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
		return data;
	}
	
	public static Date padraoBr(String dataUS){
		String dataBr = padraoBR(dataUS);
		Date data = new Date();
		try {
			data = sdf.parse(dataBr);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Erro ao converter data!\n" + e.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
		return data;
	}
	
	public static Integer calculaIntervalo(Date data){
		Integer diasRestantes = 0;
		
		Date hoje = new Date();

		while(data.before(hoje)){      // enquanto data for antes de hoje
			Calendar calendar = Calendar.getInstance(); // contar quantos dias ainda restam
			calendar.setTime(data);
			int d = 1;
			calendar.add(Calendar.DAY_OF_MONTH, d);
			data = calendar.getTime();

			diasRestantes++;
		}
		
		return diasRestantes;
	}
}