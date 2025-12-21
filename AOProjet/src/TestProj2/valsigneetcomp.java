//valeur signe et complements

package TestProj2;

public class valsigneetcomp {
	public static String NbrSigne(String valeur) {
		char signe = valeur.charAt(0);
		int b = 0;
		if (signe == '-') {
			b = -1;
			valeur = valeur.substring(1, valeur.length());
		}
		if (signe == '+') {
			b = 1;
			valeur = valeur.substring(1, valeur.length());
		}
		try {
			int valeurEntie = Integer.parseInt(valeur);
			StringBuilder result = new StringBuilder();
			if (valeurEntie == 0)
				result.insert(0, '0');
			else {
				while (valeurEntie > 0) {
					char rest = (char) (valeurEntie % 2 + '0');
					result.insert(0, rest);
					valeurEntie /= 2;
				}
			}
			if (b < 0)
				result.insert(0, '1');
			else
				result.insert(0, '0');
			return result.toString();
		} catch (Exception e) {
			return "Erreur: votre nombre ne correspond pas à la base décimal.";
		}

	}

	public static String CompA1(String valeur) {
		String val = NbrSigne(valeur);
		if (val.startsWith("Erreur"))
			return val;
		if (val.charAt(0) == '0')
			return val;
		char[] caractResulta = val.toCharArray();
		for (int i = 1; i < val.length() - 1; i++) {
			caractResulta[i]=caractResulta[i]=='0'?'1':'0';
		}
		return new String(caractResulta);
	}

	public static String CompA2(String valeur) {
		String val = NbrSigne(valeur);
		if (val.startsWith("Erreur"))
			return val;
		if (val.charAt(0) == '0')
			return val;
		char[] caractResulta = val.toCharArray();
		caractResulta[0] = '0';
		for (int i = val.length() - 1; i > 0; i--) {
			if (caractResulta[i] == '1') {
				for (int j = i - 1; j >= 0; j--) {
					caractResulta[j]=caractResulta[j]=='0'?'1':'0';
				}
				break;
			}
		}
		return new String(caractResulta);
	}
	public static boolean check(String nombre) {
		for(int i =0;i<nombre.length();i++) {
			if(nombre.charAt(i)!='0'&&nombre.charAt(i)!='1')
				return false;
		}
		return true;
	}
	public static String VSver_base_10(String nombre) {
		boolean check=check(nombre);
		if(!check)
			return "Erreur: votre nombre ne correspond pas à la base Binaire.";
		char signe =nombre.charAt(0);
		nombre=nombre.substring(1, nombre.length());
		String S=convertion2bitethexa.BaseConvertion("2", "10", nombre);
		if(signe=='0')
			return S;
		else
			return "-"+S;
		}
	public static String CmpA_1_ver_base_10(String nombre) {
		boolean check=valsigneetcomp.check(nombre);
		if(!check)
			return "Erreur: votre nombre ne correspond pas à la base Binaire.";
		char signe =nombre.charAt(0);
		nombre=nombre.substring(1, nombre.length());
		char [] nbr_To_Tableau=nombre.toCharArray();
		for(int i=0;i<nbr_To_Tableau.length;i++)
			nbr_To_Tableau[i]=nbr_To_Tableau[i]=='0'?'1':'0';
		return VSver_base_10(signe+new String(nbr_To_Tableau));
		}
	public static String CmpA_2_ver_base_10(String nombre) {
		boolean check=check(nombre);
		if(!check)
			return "Erreur: votre nombre ne correspond pas à la base Binaire.";
		char signe =nombre.charAt(0);
		nombre=nombre.substring(1, nombre.length());
		char [] nbr_To_Tableau=nombre.toCharArray();
		for(int i=nbr_To_Tableau.length-1;i>=0;i--)
			if(nbr_To_Tableau[i]=='1') {
				for(int j=i-1;j>=0;j--)	
					nbr_To_Tableau[j]=nbr_To_Tableau[j]=='0'?'1':'0';
				break;
			}
		return VSver_base_10(signe+new String(nbr_To_Tableau));
		}
	}
