package TestProj2;


public class DetectError {
	public static boolean ImediatError(String instruction) {
		if(instruction.indexOf('#')!=(instruction.indexOf(' ')+1))
			return false;
		String[][] tab = Compilation.map.get(instruction.substring(0, instruction.indexOf(' ')));
		if (tab == null)
			return false;
		else if (tab[0][0] == null)
			return false;
		String Valeur = instruction.substring(instruction.indexOf(' ') + 2, instruction.length());
		if (Valeur.charAt(0) == '$')
			Valeur = Valeur.substring(1, Valeur.length());
		if (convertion2bitethexa.BaseConvertion("16", "10", Valeur).startsWith("Erreur"))
			return false;
		if (Valeur.length() > 4 || Valeur.isBlank())
			return false;
		instruction = instruction.substring(0, instruction.indexOf(' ')) + " " + Valeur;
		Compilation.AppelImed(tab[1][0], instruction);
		return true;
	}

	public static boolean DirectError(String instruction) {
		String[][] tab = Compilation.map.get(instruction.substring(0, instruction.indexOf(' ')));
		if (tab == null)
			return false;
		else if (tab[0][1] == null)
			return false;
		if(instruction.indexOf('<')!=(instruction.indexOf(' ')+1))
			return false;
		String Valeur = instruction.substring(instruction.indexOf(' ') + 3, instruction.length());
		if (convertion2bitethexa.BaseConvertion("16", "10", Valeur).startsWith("Erreur"))
			return false;
		if (Valeur.length() == 4) {
			instruction = instruction.replace('<', '>');
			return EtenduDirectError(instruction);
		} else if (Valeur.isBlank() || Valeur.length() != 2)
			return false;
		instruction = instruction.substring(0, instruction.indexOf(' ')) + " " + Valeur;
		Compilation.AppelDirect(tab[1][1], instruction);
		return true;
	}

	public static boolean EtenduDirectError(String instruction) {
		String[][] tab = Compilation.map.get(instruction.substring(0, instruction.indexOf(' ')));
		if (tab == null)
			return false;
		else if (tab[0][3] == null)
			return false;
		if(instruction.indexOf('>')!=(instruction.indexOf(' ')+1))
			return false;
		String Valeur = instruction.substring(instruction.indexOf(' ') + 3, instruction.length()).trim();
		if (convertion2bitethexa.BaseConvertion("16", "10", Valeur).startsWith("Erreur"))
			return false;
		if (Valeur.length() == 2 && (!Valeur.isBlank())) {
			instruction = instruction.replace('>', '<');
			DirectError(instruction);
		} else if (Valeur.isBlank() || Valeur.length() != 4)
			return false;
		instruction = instruction.substring(0, instruction.indexOf(' ')) + " " + Valeur;
		Compilation.AppelEtenduDirect(tab[1][3], instruction);
		return true;

	}

	public static boolean EtenduInDirectError(String instruction) {
		int direct_test1=instruction.indexOf('[');
		int direct_test2=instruction.indexOf(']');	
		if(direct_test1!=-1&&direct_test2!=-1&&(direct_test1<direct_test2)) {
			if((direct_test1==instruction.indexOf(' ')+2)&&(direct_test2==instruction.length()-1)) {
			instruction=instruction.replace("[", "").replace("]", "");
			}
			else
				return false;
			}
		if(direct_test1==-1||direct_test2==-1)
			return false;
		String[][] tab = Compilation.map.get(instruction.substring(0, instruction.indexOf(' ')));
		if (tab == null)
			return false;
		else if (tab[0][3] == null)
			return false;
		if(instruction.indexOf('>')!=(instruction.indexOf(' ')+1))
			return false;
		String Valeur = instruction.substring(instruction.indexOf(' ') + 3, instruction.length()).trim();
		if (convertion2bitethexa.BaseConvertion("16", "10", Valeur).startsWith("Erreur"))
			return false;
		if(Valeur.length()==2&&(!Valeur.isBlank())) {
			instruction=instruction.replace('>', '<');
			DirectError(instruction);
		}
		else if (Valeur.isBlank() || Valeur.length() != 4)
			return false;
		instruction = instruction.substring(0, instruction.indexOf(' ')).trim() + " " + Valeur;
		Compilation.AppelEtenduInDirect(tab[1][3], instruction);
		return true;
	}

	public static boolean IndexeDetectionError(String instruction) {
	    int index_Ouvrant = instruction.indexOf('[');
	    int index_Fermant = instruction.indexOf(']');
	    String mode = null;

	    if (index_Ouvrant == index_Fermant) { 
	        mode = "0";
	    } else if (index_Ouvrant != -1 && index_Fermant != -1 && index_Ouvrant < index_Fermant) { 

			if((index_Ouvrant==(instruction.indexOf(' ')+1))&&(index_Fermant==(instruction.length()-1))) {
				instruction=instruction.replace("[", "").replace("]", "");
				mode = "1";
			}
			else
				return false;
	    } else {
	        return false; 
	    }
	    String mnemonic = instruction.substring(0, instruction.indexOf(' ')).trim();
	    String[][] tab = Compilation.map.get(mnemonic);
	    if (tab == null || tab[0][3] == null) {
	        return false; 
	    }
	    String incre = instruction.substring(instruction.indexOf(' ')+1, instruction.indexOf(',')).trim();
	    String regestre = instruction.substring(instruction.indexOf(',') + 1).trim();

	    if (incre.isBlank()) {
	        if (regestre.startsWith("-")) { 
	        		if (regestre.startsWith("--")) {
	        			String regesterValid = regestre.substring(2);
	        			if (Compilation.Bit5_6.containsKey(regesterValid)) {
	        				Compilation.Indexe2_Inc_Dec(instruction, mode);
	        		 		return true;
	        			}
	        		}	
	        		else {
	        			String regesterValid = regestre.substring(1);
	        			if (Compilation.Bit5_6.containsKey(regesterValid)) {
	        				Compilation.Indexe2_Inc_Dec(instruction, mode);
	        				return true;
	        		    }
	        		}
	        } else if (regestre.endsWith("+")) { 
	        		if (regestre.endsWith("++")) {
		            String regesterValid = regestre.substring(0, regestre.length() - 2);
		            if (Compilation.Bit5_6.containsKey(regesterValid)) {
		                Compilation.Indexe2_Inc_Dec(instruction, mode);
		                return true;
		            }
	        	}
	        		else {
			            String regesterValid = regestre.substring(0, regestre.length() - 1);
			            if (Compilation.Bit5_6.containsKey(regesterValid)) {
			                Compilation.Indexe2_Inc_Dec(instruction, mode);
			                return true;
			            }
		        	
	        			
	        		}
	        } else if (Compilation.Bit5_6.containsKey(regestre)) {
	            Compilation.Indexe2_Inc_Dec(instruction, mode);
	            return true;
	        }
	    } else { 
	        try {
	        	int hexValue ;
	            if (incre.startsWith("$")&&Compilation.Bit5_6.containsKey(regestre)) { 
	            	instruction=instruction.replace("$", "");
	            	incre=incre.replace("$", "");
	            	 hexValue = Integer.parseInt(incre, 16);
	            	if(incre.charAt(0)=='-'||incre.charAt(0)=='+'||incre.length()==1) {
	            		if(incre.length()<4&&hexValue>-17&&hexValue<0){
		                    Compilation.IndexeDirect_4Bit(instruction,"1");
		                    return true;
		                }
	            		else if(incre.length()<2&&hexValue<16) {
		                    Compilation.IndexeDirect_4Bit(instruction,"0");
		                    return true;
	            		}
	            		else
	            			return false;
	            		}
	            	else if(incre.length()==2&&hexValue>15) {
	                    Compilation.IndexeDirect_7BitRgester(instruction, mode);
	                    return true;
	                }
	                else if(incre.length()==4&&hexValue>0) {
	                    Compilation.Indexe_15BitRgester(instruction, mode);
	                    return true;
	                }
	                else
	                	return false;
	            } 
	            else if(incre.equals("A")||incre.equals("B")||incre.equals("D")) {
	            	Compilation.Indexe_Acumilateur(instruction, mode);
	            	return true;
	            }
	            else  
	             return false;
	            
	        } catch (NumberFormatException e) {
	            return false; 
	        }
	    }
		return false;
	}
	public static boolean InherentDetectionError(String instruction) {
		String[][] tab = Compilation.map.get(instruction.trim());
		if (tab == null||tab[0][4]==null)
			return false;
		else {
			Compilation.AppelInherent(instruction.trim());
			return true;
		}
	}

}
