//convertir des nombres entre différentes bases et à gérer le complément à 4 bits.

package TestProj2;


public class convertion2bitethexa {
	public static String BaseConvertion(String baseIn,String baseFi,String val) {
		int baseI=Integer.parseInt(baseIn);
		int baseF=Integer.parseInt(baseFi);
		char[] Ver = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		boolean check = false;
		 val = val.toUpperCase();
		for (int i = 0; i < val.length(); i++) {
			check = false;
			for (int j = 0; j < baseI; j++) {
				if (val.charAt(i) == Ver[j]) {
					check = true;
					break;
				}
			}
			if (!check) {
				return "Erreur: votre nombre ne correspond pas à la base spécifiée.";
			}
		}

		int dic = 0;
		for (int i = 0; i < val.length(); i++) {
			for (int j = 0; j < baseI; j++) {
				if (val.charAt(i) == Ver[j]) {
					dic += j * Math.pow(baseI, val.length() - i - 1);
					break;
				}
			}
		}
		if(baseF==10)
			return String.valueOf(dic);
		if(dic==0)
			return "0";
		StringBuilder result = new StringBuilder();
		while (dic > 0) {
			int rest = dic % baseF;
			result.insert(0, Ver[rest]);
			dic /= baseF;
		}
		return result.toString();
	}
	
	public static String Complement_4(String val) {
		if(val.charAt(0)=='-') {
			val=val.substring(1);
		String Bin=BaseConvertion("10","2",val);
		while(Bin.length()<4) {
			Bin="0"+Bin;	
		}
		char[] caractResulta = Bin.toCharArray();
		for (int i = 3; i >= 0; i--) {
			if (caractResulta[i] == '1') {
				for (int j = i - 1; j >= 0; j--) {
					caractResulta[j]=caractResulta[j]=='0'?'1':'0';
				}
				break;
			}
		}
		return new String(caractResulta);
		}
		else {
			String Bin=BaseConvertion("10","2",val);;
			while(Bin.length()<4) {
				Bin="0"+Bin;	
			}
			return Bin;
		}
	}
	public static String hexaConver_4(char val) {
		switch(val) {
		 case '0':
			 return "0000";
		 case '1':
			  return "0001";
		 case '2':
			  return "0010";
		 case '3':
			  return "0011";
		 case '4':
			 return "0100";
		 case '5':
			  return "0101";
		 case '6':
			  return "0110";
		 case '7':
			  return "0111";
		 case '8':
			 return "1000";
		 case '9':
			  return "1001";
		 case 'A':
			  return "1010";
		 case 'B':
			  return "1011";
		 case 'C':
			 return "1100";
		 case 'D':
			  return "1101";
		 case 'E':
			  return "1110";
		 case 'F':
			  return "1111";
		}
		return null;
		
	}
	
}

