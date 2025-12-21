//simulation du microprocesseur

package TestProj2;


public class Execution {
		 static char mode='0';
	   static int address=0;
	   static char[] A=new char[2];
	   static char[] B=new char[2];
	   static char[] PC=new char[4];
	   static char[] S=new char[4];
	   static char[] X=new char[4];
	   static char[] U=new char[4];
	   static char[] Y=new char[4];
	   static char[] DP=new char[2];
	   static char[] CCR=new char[8];
	static String[][] RAM=new String[6000][2];
	public static void init_Ram(){
		Execution.A[0] = '0';
		Execution.A[1] = '0';
		Execution.B[0] = '0';
		Execution.B[1] = '0';
		Execution.PC[0] = '0';
		Execution.PC[1] = '0';
		Execution.PC[2] = '0';
		Execution.PC[3] = '0';
		Execution.S[0] = '0';
		Execution.S[1] = '0';
		Execution.S[2] = '0';
		Execution.S[3] = '0';
		Execution.X[0] = '0';
		Execution.X[1] = '0';
		Execution.X[2] = '0';
		Execution.X[3] = '0';
		Execution.U[0] = '0';
		Execution.U[1] = '0';
		Execution.U[2] = '0';
		Execution.U[3] = '0';
		Execution.Y[0] = '0';
		Execution.Y[1] = '0';
		Execution.Y[2] = '0';
		Execution.Y[3] = '0';
		Execution.DP[0] = '0';
		Execution.DP[1] = '0';
		Execution.CCR[0] = '0';
		Execution.CCR[1] = '0';
		Execution.CCR[2] = '0';
		Execution.CCR[3] = '0';
		Execution.CCR[4] = '0';
		Execution.CCR[5] = '0';
		Execution.CCR[6] = '0';
		Execution.CCR[7] = '0';
		address=0;
		for(int i=0;i<6000;i++) {
			  if(i<16) {
				  RAM[i][0]="000"+convertion2bitethexa.BaseConvertion("10", "16", String.valueOf(i));
				  }
				  else if(i<256) {
					  RAM[i][0]="00"+convertion2bitethexa.BaseConvertion("10", "16", String.valueOf(i));
					  }
				  else if(i<4096) {
					  RAM[i][0]="0"+convertion2bitethexa.BaseConvertion("10", "16", String.valueOf(i));
					  }
				  else 
					  RAM[i][0]=convertion2bitethexa.BaseConvertion("10", "16", String.valueOf(i)); 
			RAM[i][1]="00";
		}
	}
	public static boolean detectMode() {
		String code=Compilation.Rom[address][1];
		address++;
		if(code.equals("3F")) {
			INTERFACE.valide=false;
			return false;
			}
		else if(code.equals("10")) {
				code=code+Compilation.Rom[address][1];
		        address++;
		        }
		appelExecution(code);
		return true;
	}
	public static boolean testInderect() {
		String code=Compilation.Rom[address][1];
		address++;
		if(code.equals("9F")) {
			return true;
			}
		else {
			address--;
			return false;
			}
		
	}
	public static void appelExecution(String code) {
		switch (code){
		case "49":
			inherent.ROLA();
			break;
		case "59":
			inherent.ROLB();
		case "48":
			inherent.LSLA();
			break;
		case "58":
			inherent.LSLB();
			break;
		case "44":
			inherent.LSRA();
			break;
		case "54":
			inherent.LSRB();
			break;
		case "4C":
			inherent.INCA();
			break;
		case "5C":
			inherent.INCB();
			break;
		case "4A":
			inherent.DECA();
			break;
		case "5A":
			inherent.DECB();
			break;
		case "86":
			Imidiat.LDA();
			break;
		case "C6":
			Imidiat.LDB();
			break;
		case "CC":
			Imidiat.LDD();
			break;
		case "10CE":
			Imidiat.LDS();
			break;
		case "CE":
			Imidiat.LDU();
			break;
		case "8E":
			Imidiat.LDX();
			break;
		case "108E":
			Imidiat.LDY();
			break;
		case "89":
			Imidiat.ADCA();
			break;
		case "C9":
			Imidiat.ADCB();
			break;
		case "96":
			direct.LDA();
			break;
		case "D6":
			direct.LDB();
			break;
		case "DC":
			direct.LDD();
			break;
		case "10DE":
			direct.LDS();
			break;
		case "DE":
			direct.LDU();
			break;
		case "9E":
			direct.LDX();
			break;
		case "109E":
			direct.LDY();
			break;
		case "97":
			direct.STA();
			break;
		case "D7":
			direct.STB();
			break;
		case "DD":
			direct.STD();
			break;
		case "10DF":
			direct.STS();
			break;
		case "DF":
			direct.STU();
			break;
		case "9F":
			direct.STX();
			break;
		case "99":
			direct.ADCA();
			break;
		case "D9":
			direct.ADCB();
			break;
		case "109F":
			direct.STY();
			break;
		case "B6":
			Etendu.LDA();
			break;
		case "F6":
			Etendu.LDB();
			break;
		case "FC":
			Etendu.LDD();
			break;
		case "10FE":
			Etendu.LDS();
			break;
		case "FE":
			Etendu.LDU();
			break;
		case "BE":
			Etendu.LDX();
			break;
		case "10BE":
			Etendu.LDY();
			break;
		case "B7":
			Etendu.STA();
			break;
		case "F7":
			Etendu.STB();
			break;
		case "FD":
			Etendu.STD();
			break;
		case "10FF":
			Etendu.STS();
			break;
		case "FF":
			Etendu.STU();
			break;
		case "BF":
			Etendu.STX();
			break;
		case "10BF":
			Etendu.STY();
			break;
		case "B9":
			Etendu.ADCA();
			break;
		case "F9":
			Etendu.ADCB();
			break;
		case "A6":
			if(testInderect())
				Etendu.LDA_Inderict();
			else {
				indexe.LDA();
			}
			break;
		case "E6":
			if(testInderect())
				Etendu.LDB_Inderict();
			else {
				indexe.LDB();
			}
			break;
		case "EC":
			if(testInderect())
				Etendu.LDD_Inderict();
			else {
				indexe.LDD();
			}
			break;
		case "10EE":
			if(testInderect())
				Etendu.LDS_Inderict();
			else {
				indexe.LDS();
			}
			break;
		case "EE":
			if(testInderect())
				Etendu.LDU_Inderict();
			else {
				indexe.LDU();
			}
			break;
		case "AE":
			if(testInderect())
				Etendu.LDX_Inderict();
			else {
				indexe.LDX();
			}
			break;
		case "10AE":
			if(testInderect())
				Etendu.LDY_Inderict();
			else {
				indexe.LDY();
			}
			break;
		case "A9":
			if(testInderect())
				Etendu.ADCA_Inde();
			else {
				indexe.ADCA();
			}
			break;
		case "E9":
			if(testInderect()) {
				System.out.println("IN");
				Etendu.ADCB_Inde();
				}
			else {
				indexe.ADCB();
			}
			break;
			
		case "A7":
			if(testInderect())
				Etendu.STA_Ind();
			else {
				indexe.STA();
			}
			break;
		case "E7":
			if(testInderect())
				Etendu.STB_Ind();
			else {
				indexe.STB();
			}

			break;
		case "ED":
			if(testInderect())
				Etendu.STD_Ind();
			else {
				indexe.STD();
			}
			break;
		case "10EF":
			if(testInderect())
				Etendu.STS_ind();
			else {
				indexe.STS();
			}
			break;
		case "EF":
			if(testInderect())
				Etendu.STU_Ind();
			else {
				indexe.STU();
			}
			break;
		case "AF":
			if(testInderect())
				Etendu.STX_ind();
			else {
				indexe.STX();
			}
			break;
		case "10AF":
			if(testInderect())
				Etendu.STY_ind();
			else {
				indexe.STY();
			}
			break;
		}
	} 
	public static void Mise_Ajour_Flag(String Val) {
			CCR[4]=(Val.charAt(0)<'8')?'0':'1';
			if(Val.equals("00")||Val.equals("0000"))	
				CCR[5]='1';	
	}
public static class inherent{
	 public static void ROLA() {
		 char[] a=(convertion2bitethexa.hexaConver_4(A[0])+convertion2bitethexa.hexaConver_4(A[1])).toCharArray();
		 CCR[7]=a[0];
		 for(int i=0;i<7;i++)
			 a[i]=a[i+1];
		 a[7]=CCR[7];	
		 A=convertion2bitethexa.BaseConvertion("2", "16", new String(a)).toCharArray();
		 Mise_Ajour_Flag(new String(A));
	 }
	 public static void ROLB() {
		 char[] a=(convertion2bitethexa.hexaConver_4(B[0])+convertion2bitethexa.hexaConver_4(B[1])).toCharArray();
		 CCR[7]=a[0];
		 for(int i=0;i<7;i++)
			 a[i]=a[i+1];
		 a[7]=CCR[7];
		 B=convertion2bitethexa.BaseConvertion("2", "16", new String(a)).toCharArray();
		 Mise_Ajour_Flag(new String(B));
	 }
	 public static void LSLA() {
		 char[] a=(convertion2bitethexa.hexaConver_4(A[0])+convertion2bitethexa.hexaConver_4(A[1])).toCharArray();
		 CCR[7]=a[0];
		 for(int i=0;i<7;i++)
			 a[i]=a[i+1];
		 a[7]='0';
		 int val=Integer.parseInt(new String(a),2);
 		 if(val<16)
		   A=("0"+convertion2bitethexa.BaseConvertion("2", "16", new String(a))).toCharArray();
 		 else
 			A=(convertion2bitethexa.BaseConvertion("2", "16", new String(a))).toCharArray();
		 Mise_Ajour_Flag(new String(A));
	 }
	 public static void LSLB() {
		 char[] a=(convertion2bitethexa.hexaConver_4(B[0])+convertion2bitethexa.hexaConver_4(B[1])).toCharArray();
		 CCR[7]=a[0];
		 for(int i=0;i<7;i++)
			 a[i]=a[i+1];
		 a[7]='0';
		 int val=Integer.parseInt(new String(a),2);
 		 if(val<16)
		   B=("0"+convertion2bitethexa.BaseConvertion("2", "16", new String(a))).toCharArray();
 		 else
 			B=(convertion2bitethexa.BaseConvertion("2", "16", new String(a))).toCharArray();
		 Mise_Ajour_Flag(new String(B));
	 }
	 public static void LSRA() {
		 char[] a=(convertion2bitethexa.hexaConver_4(A[0])+convertion2bitethexa.hexaConver_4(A[1])).toCharArray();
		 CCR[7]=a[7];
		 for(int i=0;i<7;i++)
			 a[i+1]=a[i];
		 a[0]='0';	
		 int val=Integer.parseInt(new String(a),2);
 		 if(val<16)
		   A=("0"+convertion2bitethexa.BaseConvertion("2", "16", new String(a))).toCharArray();
 		 else
 			A=(convertion2bitethexa.BaseConvertion("2", "16", new String(a))).toCharArray();
		 Mise_Ajour_Flag(new String(A));
	 }
	 public static void LSRB() {
		 char[] a=(convertion2bitethexa.hexaConver_4(B[0])+convertion2bitethexa.hexaConver_4(B[1])).toCharArray();
		 CCR[7]=a[7];
		 for(int i=0;i<7;i++)
			 a[i+1]=a[i];
		 a[0]='0';	
		 int val=Integer.parseInt(new String(a),2);
 		 if(val<16)
		   B=("0"+convertion2bitethexa.BaseConvertion("2", "16", new String(a))).toCharArray();
 		 else
 			B=(convertion2bitethexa.BaseConvertion("2", "16", new String(a))).toCharArray();
		 Mise_Ajour_Flag(new String(B));
	 }
	 public static void INCA() {
		 CCR[7]='0';
		 String A_binair=(convertion2bitethexa.hexaConver_4(A[0])+convertion2bitethexa.hexaConver_4(A[1]));
		 String S=Somme.somme(A_binair, "00000001");
		 int val=Integer.parseInt(convertion2bitethexa.BaseConvertion("2", "10", S));
		 if(val<16)
			 A=("0"+convertion2bitethexa.BaseConvertion("2", "16", S)).toCharArray();
		 else
			 A=(convertion2bitethexa.BaseConvertion("2", "16", S)).toCharArray(); 
	 }
	 public static void INCB() {
		 CCR[7]='0';
		 String B_binair=(convertion2bitethexa.hexaConver_4(B[0])+convertion2bitethexa.hexaConver_4(B[1]));
		 String S=Somme.somme(B_binair, "00000001");
		 int val=Integer.parseInt(convertion2bitethexa.BaseConvertion("2", "10", S));
		 if(val<16)
			 B=("0"+convertion2bitethexa.BaseConvertion("2", "16", S)).toCharArray();
		 else
			 B=(convertion2bitethexa.BaseConvertion("2", "16", S)).toCharArray(); 
	 }
	 public static void DECA() {
		 char retenu=CCR[7];
		 CCR[7]='0';
		 String A_binair=(convertion2bitethexa.hexaConver_4(A[0])+convertion2bitethexa.hexaConver_4(A[1]));
		 String S=Somme.somme(A_binair, "11111111");
		 int val=Integer.parseInt(convertion2bitethexa.BaseConvertion("2", "10", S));
		 if(val<16)
			 A=("0"+convertion2bitethexa.BaseConvertion("2", "16", S)).toCharArray();
		 else
			 A=(convertion2bitethexa.BaseConvertion("2", "16", S)).toCharArray(); 
		 CCR[7]=retenu;
	 }
	 public static void DECB() {
		 char retenu=CCR[7];
		 CCR[7]='0';
		 String B_binair=(convertion2bitethexa.hexaConver_4(B[0])+convertion2bitethexa.hexaConver_4(B[1]));
		 String S=Somme.somme(B_binair, "11111111");
		 int val=Integer.parseInt(convertion2bitethexa.BaseConvertion("2", "10", S));
		 if(val<16)
			 B=("0"+convertion2bitethexa.BaseConvertion("2", "16", S)).toCharArray();
		 else
			 B=(convertion2bitethexa.BaseConvertion("2", "16", S)).toCharArray(); 
		 CCR[7]=retenu;
	 }
}
public static class  Imidiat{
	public static void ADCA() {
 	    String mem=Compilation.Rom[address][1];
 	    String mem_bin=convertion2bitethexa.hexaConver_4(mem.charAt(0))+convertion2bitethexa.hexaConver_4(mem.charAt(1));
 		 String A_BINAIR=(convertion2bitethexa.hexaConver_4(A[0])+convertion2bitethexa.hexaConver_4(A[1]));
 		 String S_bin=Somme.somme(A_BINAIR, mem_bin);
 		 int val=Integer.parseInt(S_bin,2);
 		 if(val<16)
		   A=("0"+convertion2bitethexa.BaseConvertion("2", "16", S_bin)).toCharArray();
 		 else
 			A=(convertion2bitethexa.BaseConvertion("2", "16", S_bin)).toCharArray();
		 address ++;
	}
	public static void ADCB() {
 	    String mem=Compilation.Rom[address][1];
 	    String mem_bin=convertion2bitethexa.hexaConver_4(mem.charAt(0))+convertion2bitethexa.hexaConver_4(mem.charAt(1));
 		 String B_BINAIR=(convertion2bitethexa.hexaConver_4(B[0])+convertion2bitethexa.hexaConver_4(B[1]));
 		 String S=Somme.somme(B_BINAIR, mem_bin);
 		 int val=Integer.parseInt(S,2);
 		 if(val<16)
		   B=("0"+convertion2bitethexa.BaseConvertion("2", "16", S)).toCharArray();
 		 else
 			B=(convertion2bitethexa.BaseConvertion("2", "16", S)).toCharArray();
		 address ++;
	}
    public static void LDA() {
 	  A=Compilation.Rom[address][1].toCharArray();
 	  Execution.Mise_Ajour_Flag(new String(A));
 	  address ++;
    }
    public static void LDB() {
      B=Compilation.Rom[address][1].toCharArray();
	  Execution.Mise_Ajour_Flag(new String(B));
	  address ++;
	  }
    public   static void LDY() {  
 	   String s=Compilation.Rom[address][1];
 	   address ++;
 	   s=s+Compilation.Rom[address][1];
 	   Y=s.toCharArray();
 	   Execution.Mise_Ajour_Flag(new String(Y));
 	   address ++;
    }
    public static void LDX() {  
 	   String s=Compilation.Rom[address][1];
 	   address ++;
 	   s=s+Compilation.Rom[address][1];
 	   X=s.toCharArray();
 	   Execution.Mise_Ajour_Flag(new String(X));
 	   address ++;
    }
           
    public static void LDU() {
 	   String s=Compilation.Rom[address][1];
 	   address ++;
 	   s+=Compilation.Rom[address][1];
 	   U=s.toCharArray();
 	   Execution.Mise_Ajour_Flag(new String(U));
 	   address ++;
    }
    public static void LDD() {
 	   String s=Compilation.Rom[address][1];
 	   address ++;
 	   A=s.toCharArray();
 	   s=Compilation.Rom[address][1];
 	   B=s.toCharArray();
 	   Execution.Mise_Ajour_Flag(new String(A)+new String(B));
 	   address ++;
    }
   public static  void LDS () {
 	   String s=Compilation.Rom[address][1];
 	   address ++;
 	   s=s+Compilation.Rom[address][1];
 	   S=s.toCharArray();
 	   Execution.Mise_Ajour_Flag(new String(S));
 	   address ++;
    }
 }
public static class  direct{
	public static void STA() {
		String addHex=new String(DP)+ Compilation.Rom[address][1];
		int addInt=Integer.parseInt(addHex,16);
		RAM[addInt][1]=new String(A);
		address ++;
	}
	public static void STB() {
		String addHex=new String(DP)+ Compilation.Rom[address][1];
		int addInt=Integer.parseInt(addHex,16);
		RAM[addInt][1]=new String(B);
		address ++;
	}
	public static void STD() {
		String addHex=new String(DP)+ Compilation.Rom[address][1];
		int addInt=Integer.parseInt(addHex,16);
		RAM[addInt][1]=new String(A);
		RAM[addInt+1][1]=new String(B);
		address ++;
	}
	public static void STU() {
		String addHex=new String(DP)+ Compilation.Rom[address][1];
		int addInt=Integer.parseInt(addHex,16);
		char[]pas=new char[2];
		pas[0]=U[0];
		pas[1]=U[1];
		RAM[addInt][1]=new String(pas);
		pas[0]=U[2];
		pas[1]=U[3];
		RAM[addInt+1][1]=new String(pas);
		address ++;;
	}
	public static void STX() {
		String addHex=new String(DP)+ Compilation.Rom[address][1];
		int addInt=Integer.parseInt(addHex,16);
		char[]pas=new char[2];
		pas[0]=X[0];
		pas[1]=X[1];
		RAM[addInt][1]=new String(pas);
		pas[0]=X[2];
		pas[1]=X[3];
		RAM[addInt+1][1]=new String(pas);
		address ++;;
	}
	public static void STY() {
		String addHex=new String(DP)+ Compilation.Rom[address][1];
		int addInt=Integer.parseInt(addHex,16);
		char[]pas=new char[2];
		pas[0]=Y[0];
		pas[1]=Y[1];
		RAM[addInt][1]=new String(pas);
		pas[0]=Y[2];
		pas[1]=Y[3];
		RAM[addInt+1][1]=new String(pas);
		address ++;;
	}
	public static void STS() {
		String addHex=new String(DP)+ Compilation.Rom[address][1];
		int addInt=Integer.parseInt(addHex,16);
		char[]pas=new char[2];
		pas[0]=S[0];
		pas[1]=S[1];
		RAM[addInt][1]=new String(pas);
		pas[0]=S[2];
		pas[1]=S[3];
		RAM[addInt+1][1]=new String(pas);
		address ++;;
	}
	public static void ADCA() {
		String addHex=new String(DP)+ Compilation.Rom[address][1];
    	int addInt=Integer.parseInt(addHex,16);
 	    String mem=RAM[addInt][1];
 	    String mem_bin=convertion2bitethexa.hexaConver_4(mem.charAt(0))+convertion2bitethexa.hexaConver_4(mem.charAt(1));
 		 String A_BINAIR=(convertion2bitethexa.hexaConver_4(A[0])+convertion2bitethexa.hexaConver_4(A[1]));
 		 String S_bin=Somme.somme(A_BINAIR, mem_bin);
 		 int val=Integer.parseInt(S_bin,2);
 		 if(val<16)
		   A=("0"+convertion2bitethexa.BaseConvertion("2", "16", S_bin)).toCharArray();
 		 else
 			A=(convertion2bitethexa.BaseConvertion("2", "16", S_bin)).toCharArray();
		 address ++;
	}
	public static void ADCB() {
		String addHex=new String(DP)+ Compilation.Rom[address][1];
    	int addInt=Integer.parseInt(addHex,16);
 	    String mem=RAM[addInt][1];
 	    String mem_bin=convertion2bitethexa.hexaConver_4(mem.charAt(0))+convertion2bitethexa.hexaConver_4(mem.charAt(1));
 		 String B_BINAIR=(convertion2bitethexa.hexaConver_4(B[0])+convertion2bitethexa.hexaConver_4(B[1]));
 		 String S_bin=Somme.somme(B_BINAIR, mem_bin);
 		 int val=Integer.parseInt(S_bin,2);
		 if(val<16)
		   B=("0"+convertion2bitethexa.BaseConvertion("2", "16",S_bin)).toCharArray();
		 else
			B=(convertion2bitethexa.BaseConvertion("2", "16", S_bin)).toCharArray(); 
		 address ++;
	}
    public static void LDA() {
 	    String addHex=new String(DP)+ Compilation.Rom[address][1];
    	int addInt=Integer.parseInt(addHex,16);
 	    A=RAM[addInt][1].toCharArray();
 	    Execution.Mise_Ajour_Flag(new String(A));
	    address ++;
    }
    public static void LDB() {
   	    String addHex=new String(DP)+ Compilation.Rom[address][1];
    	int addInt=Integer.parseInt(addHex,16);
 	    B=RAM[addInt][1].toCharArray();
 	    Execution.Mise_Ajour_Flag(new String(B));
	    address ++;
    }
    public static void LDS() {
   	   String addHex=new String(DP)+Compilation.Rom[address][1];
       int addInt=Integer.parseInt(addHex,16);
	   String Result=RAM[addInt][1]+RAM[addInt+1][1];
	   S=Result.toCharArray();
	   Execution.Mise_Ajour_Flag(new String(S));
	   address++;
      }
    public static void LDD() {
	   String addHex=new String(DP)+ Compilation.Rom[address][1];
       int addInt=Integer.parseInt(addHex,16);
	   A=RAM[addInt][1].toCharArray();
 	   B=RAM[addInt+1][1].toCharArray();
 	   Execution.Mise_Ajour_Flag(new String(A)+new String(B));
 	   address++;
       }
    public static void LDU() {
       String addHex=new String(DP)+ Compilation.Rom[address][1];
       int addInt=Integer.parseInt(addHex,16);
 	   String Result=RAM[addInt][1]+RAM[addInt+1][1];
 	   U=Result.toCharArray();
 	   Execution.Mise_Ajour_Flag(new String(U));
 	   address++;
       }
    public static void LDY() {
       String addHex=new String(DP)+ Compilation.Rom[address][1];
       int addInt=Integer.parseInt(addHex,16);  
   	   String Result=RAM[addInt][1]+RAM[addInt+1][1];
 	   Y=Result.toCharArray();
 	   Execution.Mise_Ajour_Flag(new String(Y));
 	   address++;
       }
    public static void LDX() {
   	   String addHex=new String(DP)+ Compilation.Rom[address][1];
       int addInt=Integer.parseInt(addHex,16);
 	   String Result=RAM[addInt][1]+RAM[addInt+1][1];
 	   X=Result.toCharArray();
 	   Execution.Mise_Ajour_Flag(new String(X));
 	   address++;
       }
}
public static class Etendu{
	public static void STA() {
		String addHex=Compilation.Rom[address][1];
  	    address++;
  	    addHex=addHex+Compilation.Rom[address][1];
  	    System.out.println(addHex);
  	    int addInt=Integer.parseInt(addHex,16);
  	    System.out.println(addInt);
  	    System.out.println(new String(A));
		RAM[addInt][1]=new String(A);
		address ++;
	}
	public static void STB() {
		String addHex=Compilation.Rom[address][1];
  	    address++;
  	    addHex=addHex+Compilation.Rom[address][1];
  	    int addInt=Integer.parseInt(addHex,16);
		RAM[addInt][1]=new String(B);
		address ++;
	}
	public static void STD() {
		String addHex=Compilation.Rom[address][1];
  	    address++;
  	    addHex=addHex+Compilation.Rom[address][1];
  	    int addInt=Integer.parseInt(addHex,16);
		char[]pas=new char[2];
		pas[0]=A[0];
		pas[1]=A[1];
		RAM[addInt][1]=new String(pas);
		pas[0]=B[0];
		pas[1]=B[1];
		RAM[addInt+1][1]=new String(pas);
		address ++;;
	}
	public static void STU() {
		String addHex=Compilation.Rom[address][1];
  	    address++;
  	    addHex=addHex+Compilation.Rom[address][1];
  	    int addInt=Integer.parseInt(addHex,16);
		char[]pas=new char[2];
		pas[0]=U[0];
		pas[1]=U[1];
		RAM[addInt][1]=new String(pas);
		pas[0]=U[2];
		pas[1]=U[3];
		RAM[addInt+1][1]=new String(pas);
		address ++;;
	}
	public static void STX() {
		String addHex=Compilation.Rom[address][1];
  	    address++;
  	    addHex=addHex+Compilation.Rom[address][1];
  	    int addInt=Integer.parseInt(addHex,16);
		char[]pas=new char[2];
		pas[0]=X[0];
		pas[1]=X[1];
		RAM[addInt][1]=new String(pas);
		pas[0]=X[2];
		pas[1]=X[3];
		RAM[addInt+1][1]=new String(pas);
		address ++;;
	}
	public static void STY() {
		String addHex=Compilation.Rom[address][1];
  	    address++;
  	    addHex=addHex+Compilation.Rom[address][1];
  	    int addInt=Integer.parseInt(addHex,16);
		char[]pas=new char[2];
		pas[0]=Y[0];
		pas[1]=Y[1];
		RAM[addInt][1]=new String(pas);
		pas[0]=Y[2];
		pas[1]=Y[3];
		RAM[addInt+1][1]=new String(pas);
		address ++;;
	}
	public static void STS() {
		String addHex=Compilation.Rom[address][1];
  	    address++;
  	    addHex=addHex+Compilation.Rom[address][1];
  	    int addInt=Integer.parseInt(addHex,16);
		char[]pas=new char[2];
		pas[0]=S[0];
		pas[1]=S[1];
		RAM[addInt][1]=new String(pas);
		pas[0]=S[2];
		pas[1]=S[3];
		RAM[addInt+1][1]=new String(pas);
		address ++;;
	}
	public static void ADCA() {
	     String addHex=Compilation.Rom[address][1];
   	     address++;
   	     addHex=addHex+Compilation.Rom[address][1];
   	     int addInt=Integer.parseInt(addHex,16);
 	     String mem=RAM[addInt][1];
 	    String mem_bin=convertion2bitethexa.hexaConver_4(mem.charAt(0))+convertion2bitethexa.hexaConver_4(mem.charAt(1));
 	 	String A_BINAIR=(convertion2bitethexa.hexaConver_4(A[0])+convertion2bitethexa.hexaConver_4(A[1]));
 	 	String S_bin=Somme.somme(A_BINAIR, mem_bin);
 	 	int val=Integer.parseInt(S_bin,2);
		 if(val<16)
		   A=("0"+convertion2bitethexa.BaseConvertion("2", "16", S_bin)).toCharArray();
		 else
			A=(convertion2bitethexa.BaseConvertion("2", "16", S_bin)).toCharArray(); 
		 address ++;
	}
	public static void ADCB() {
	     String addHex=Compilation.Rom[address][1];
  	     address++;
  	     addHex=addHex+Compilation.Rom[address][1];
  	     int addInt=Integer.parseInt(addHex,16);
	     String mem=RAM[addInt][1];
	     String mem_bin=convertion2bitethexa.hexaConver_4(mem.charAt(0))+convertion2bitethexa.hexaConver_4(mem.charAt(1));
	 	 String B_BINAIR=(convertion2bitethexa.hexaConver_4(A[0])+convertion2bitethexa.hexaConver_4(A[1]));
	     String S_bin=Somme.somme(B_BINAIR, mem_bin);
	 	 int val=Integer.parseInt(S_bin,2);
 		 if(val<16)
		   B=("0"+convertion2bitethexa.BaseConvertion("2", "16", S_bin)).toCharArray();
 		 else
 			B=(convertion2bitethexa.BaseConvertion("2", "16", S_bin)).toCharArray(); 
		 address ++;
	}
    public static void LDX() {
    	   String addHex=Compilation.Rom[address][1];
    	   address++;
    	   addHex=addHex+Compilation.Rom[address][1];
    	   int addInt=Integer.parseInt(addHex,16);
    	   String Result=RAM[addInt][1]+RAM[addInt+1][1];
    	   X=Result.toCharArray();
    	   Execution.Mise_Ajour_Flag(new String(X));
    	   address++;
        }
    public static void LDA() {
 	    String addHex=Compilation.Rom[address][1];
 	    address++;
 	    addHex=addHex+Compilation.Rom[address][1];
    	int addInt=Integer.parseInt(addHex,16);
 	    A=RAM[addInt][1].toCharArray();
 	    Execution.Mise_Ajour_Flag(new String(A));
	    address ++;
    }
    public static void LDB() {
 	    String addHex=Compilation.Rom[address][1];
 	    address++;
 	    addHex=addHex+Compilation.Rom[address][1];
    	int addInt=Integer.parseInt(addHex,16);
 	    B=RAM[addInt][1].toCharArray();
 	    Execution.Mise_Ajour_Flag(new String(B));
	    address ++;
    }
    public static void LDS() {
 	   String addHex=Compilation.Rom[address][1];
 	   address++;
 	   addHex=addHex+Compilation.Rom[address][1];
       int addInt=Integer.parseInt(addHex,16);
	   String Result=RAM[addInt][1]+RAM[addInt+1][1];
	   S=Result.toCharArray();
	   Execution.Mise_Ajour_Flag(new String(S));
	   address++;
      }
    public static void LDD() {
 	   String addHex=Compilation.Rom[address][1];
 	   address++;
 	   addHex=addHex+Compilation.Rom[address][1];
       int addInt=Integer.parseInt(addHex,16);
	   A=RAM[addInt][1].toCharArray();
 	   B=RAM[addInt+1][1].toCharArray();
 	   Execution.Mise_Ajour_Flag(new String(A)+new String(B));
 	   address++;
       }
    public static void LDU() {
 	   String addHex=Compilation.Rom[address][1];
 	   address++;
 	   addHex=addHex+Compilation.Rom[address][1];
       int addInt=Integer.parseInt(addHex,16);
 	   String Result=RAM[addInt][1]+RAM[addInt+1][1];
 	   U=Result.toCharArray();
 	   Execution.Mise_Ajour_Flag(new String(U));
 	   address++;
       }
    public static void LDY() {
 	   String addHex=Compilation.Rom[address][1];
 	   address++;
 	   addHex=addHex+Compilation.Rom[address][1];
       int addInt=Integer.parseInt(addHex,16);  
   	   String Result=RAM[addInt][1]+RAM[addInt+1][1];
 	   Y=Result.toCharArray();
 	   Execution.Mise_Ajour_Flag(new String(Y));
 	   address++;
       }
//    inderect
	public static void STA_Ind() {
	    String addHex=Compilation.Rom[address][1];
 	    address++;
 	    addHex=addHex+Compilation.Rom[address][1];
 	    int addInt=Integer.parseInt(addHex,16);
 	    String idress=RAM[addInt][1]+RAM[addInt+1][1];
 	    int addEff=Integer.parseInt(idress,16);
		char[]pas=new char[2];
		pas[0]=A[0];
		pas[1]=A[1];
		RAM[addEff][1]=new String(pas);
		address ++;
}
	public static void STB_Ind() {
	    String addHex=Compilation.Rom[address][1];
 	    address++;
 	    addHex=addHex+Compilation.Rom[address][1];
 	    int addInt=Integer.parseInt(addHex,16);
 	    String idress=RAM[addInt][1]+RAM[addInt+1][1];
 	    int addEff=Integer.parseInt(idress,16);
		char[]pas=new char[2];
		pas[0]=B[0];
		pas[1]=B[1];
		RAM[addEff][1]=new String(pas);
		address ++;
}
	public static void STD_Ind() {
	    String addHex=Compilation.Rom[address][1];
 	    address++;
 	    addHex=addHex+Compilation.Rom[address][1];
 	    int addInt=Integer.parseInt(addHex,16);
 	    String idress=RAM[addInt][1]+RAM[addInt+1][1];
 	    int addEff=Integer.parseInt(idress,16);
		char[]pas=new char[2];
		pas[0]=A[0];
		pas[1]=B[1];
		RAM[addEff][1]=new String(pas);
		pas[0]=B[0];
		pas[1]=B[1];
		RAM[addEff+1][1]=new String(pas);
		address ++;
}
	public static void STU_Ind() {
		    String addHex=Compilation.Rom[address][1];
	 	    address++;
	 	    addHex=addHex+Compilation.Rom[address][1];
	 	    int addInt=Integer.parseInt(addHex,16);
	 	    String idress=RAM[addInt][1]+RAM[addInt+1][1];
	 	    int addEff=Integer.parseInt(idress,16);
			char[]pas=new char[2];
			pas[0]=U[0];
			pas[1]=U[1];
			RAM[addEff][1]=new String(pas);
			pas[0]=U[2];
			pas[1]=U[3];
			RAM[addEff+1][1]=new String(pas);
			address ++;
	}
	public static void STX_ind() {
		String addHex=Compilation.Rom[address][1];
	    address++;
	    addHex=addHex+Compilation.Rom[address][1];
	 	int addInt=Integer.parseInt(addHex,16);
	    String idress=RAM[addInt][1]+RAM[addInt+1][1];
	    int addEff=Integer.parseInt(idress,16);
		char[]pas=new char[2];
		pas[0]=X[0];
		pas[1]=X[1];
		RAM[addEff][1]=new String(pas);
		pas[0]=X[2];
		pas[1]=X[3];
		RAM[addEff+1][1]=new String(pas);
		address ++;;
	}
	public static void STY_ind() {
		String addHex=Compilation.Rom[address][1];
	    address++;
	    addHex=addHex+Compilation.Rom[address][1];
	 	int addInt=Integer.parseInt(addHex,16);
	    String idress=RAM[addInt][1]+RAM[addInt+1][1];
	    int addEff=Integer.parseInt(idress,16);
		char[]pas=new char[2];
		pas[0]=Y[0];
		pas[1]=Y[1];
		RAM[addEff][1]=new String(pas);
		pas[0]=Y[2];
		pas[1]=Y[3];
		RAM[addEff+1][1]=new String(pas);
		address ++;;
	}
	public static void STS_ind() {
		String addHex=Compilation.Rom[address][1];
	 	address++;
	    addHex=addHex+Compilation.Rom[address][1];
	 	int addInt=Integer.parseInt(addHex,16);
	 	String idress=RAM[addInt][1]+RAM[addInt+1][1];
	 	int addEff=Integer.parseInt(idress,16);
		char[]pas=new char[2];
		pas[0]=S[0];
		pas[1]=S[1];
		RAM[addEff][1]=new String(pas);
		pas[0]=S[2];
		pas[1]=S[3];
		RAM[addEff+1][1]=new String(pas);
		address ++;;
	}
	public static void ADCA_Inde() {
	 	   String addHex=Compilation.Rom[address][1];
	 	   address++;
	 	   addHex=addHex+Compilation.Rom[address][1];
	 	   int addInt=Integer.parseInt(addHex,16);
	 	   String idress=RAM[addInt][1]+RAM[addInt+1][1];
	 	   int addEff=Integer.parseInt(idress,16);
	       String mem=RAM[addEff][1];
	       String mem_bin=convertion2bitethexa.hexaConver_4(mem.charAt(0))+convertion2bitethexa.hexaConver_4(mem.charAt(1));
		   String A_BINAIR=(convertion2bitethexa.hexaConver_4(A[0])+convertion2bitethexa.hexaConver_4(A[1]));
		   String S_bin=Somme.somme(A_BINAIR, mem_bin);
		 int val=Integer.parseInt(S_bin,2);
	 		 if(val<16)
			   A=("0"+convertion2bitethexa.BaseConvertion("2", "16", S_bin)).toCharArray();
	 		 else
	 			A=(convertion2bitethexa.BaseConvertion("2", "16", S_bin)).toCharArray(); 
	       address ++;
	}
	public static void ADCB_Inde() {
		   String addHex=Compilation.Rom[address][1];
	 	   address++;
	 	   addHex=addHex+Compilation.Rom[address][1];
	 	   int addInt=Integer.parseInt(addHex,16);
	 	   String idress=RAM[addInt][1]+RAM[addInt+1][1];
	 	   System.out.println(idress);
	 	   int addEff=Integer.parseInt(idress,16);
	 	    String mem=RAM[addEff][1];
		    String mem_bin=convertion2bitethexa.hexaConver_4(mem.charAt(0))+convertion2bitethexa.hexaConver_4(mem.charAt(1));
			String B_BINAIR=(convertion2bitethexa.hexaConver_4(B[0])+convertion2bitethexa.hexaConver_4(B[1]));
			String S_bin=Somme.somme(B_BINAIR, mem_bin);
			 int val=Integer.parseInt(S_bin,2);
	 		 if(val<16)
			   B=("0"+convertion2bitethexa.BaseConvertion("2", "16", S_bin)).toCharArray();
	 		 else
	 			B=(convertion2bitethexa.BaseConvertion("2", "16", S_bin)).toCharArray(); 
	       address ++;
	}
    public static void LDX_Inderict() {
 	   String addHex=Compilation.Rom[address][1];
 	   address++;
 	   addHex=addHex+Compilation.Rom[address][1];
 	   int addInt=Integer.parseInt(addHex,16);
 	   String idress=RAM[addInt][1]+RAM[addInt+1][1];
 	   int addEff=Integer.parseInt(idress,16);
 	   String Result=RAM[addEff][1]+RAM[addEff+1][1];
 	   X=Result.toCharArray();
 	   Execution.Mise_Ajour_Flag(new String(X));
 	   address++;
     }
    public static void LDA_Inderict() {
 	   String addHex=Compilation.Rom[address][1];
 	   address++;
 	   addHex=addHex+Compilation.Rom[address][1];
 	   int addInt=Integer.parseInt(addHex,16);
 	   String idress=RAM[addInt][1]+RAM[addInt+1][1];
 	   int addEff=Integer.parseInt(idress,16);
	   A=RAM[addEff][1].toCharArray();
	   Execution.Mise_Ajour_Flag(new String(A));
	   address ++;
   }
   public static void LDB_Inderict() {
 	   String addHex=Compilation.Rom[address][1];
 	   ++address;
 	   addHex=addHex+Compilation.Rom[address][1];
 	   int addInt=Integer.parseInt(addHex,16);
 	   String idress=RAM[addInt][1]+RAM[addInt+1][1];
 	   int addEff=Integer.parseInt(idress,16);
	   B=RAM[addEff][1].toCharArray();
	   Execution.Mise_Ajour_Flag(new String(B));
	   address ++;
   }
   public static void LDS_Inderict() {
 	   String addHex=Compilation.Rom[address][1];
 	   address++;
 	   addHex=addHex+Compilation.Rom[address][1];
 	   int addInt=Integer.parseInt(addHex,16);
 	   String idress=RAM[addInt][1]+RAM[addInt+1][1];
 	   int addEff=Integer.parseInt(idress,16);
 	   String Result=RAM[addEff][1]+RAM[addEff+1][1];
	   S=Result.toCharArray();
	   Execution.Mise_Ajour_Flag(new String(S));
	   address++;
   }
   public static void LDD_Inderict() {
 	   String addHex=Compilation.Rom[address][1];
 	   address++;
 	   addHex=addHex+Compilation.Rom[address][1];
 	   int addInt=Integer.parseInt(addHex,16);
 	   String idress=RAM[addInt][1]+RAM[addInt+1][1];
 	   int addEff=Integer.parseInt(idress,16);
	   A=RAM[addEff][1].toCharArray();
	   B=RAM[addEff+1][1].toCharArray();
	   Execution.Mise_Ajour_Flag(new String(A)+new String(B));
	   address++;
    }
   public static void LDU_Inderict() {
 	   String addHex=Compilation.Rom[address][1];
 	   address++;
 	   addHex=addHex+Compilation.Rom[address][1];
 	   int addInt=Integer.parseInt(addHex,16);
 	   String idress=RAM[addInt][1]+RAM[addInt+1][1];
 	   int addEff=Integer.parseInt(idress,16);
 	   String Result=RAM[addEff][1]+RAM[addEff+1][1];
	   U=Result.toCharArray();
	   Execution.Mise_Ajour_Flag(new String(U));
	   address++;
    }
 public static void LDY_Inderict() {
 	   String addHex=Compilation.Rom[address][1];
 	   address++;
 	   addHex=addHex+Compilation.Rom[address][1];
 	   int addInt=Integer.parseInt(addHex,16);
 	   String idress=RAM[addInt][1]+RAM[addInt+1][1];
 	   int addEff=Integer.parseInt(idress,16);
 	   String Result=RAM[addEff][1]+RAM[addEff+1][1];
	   Y=Result.toCharArray();
	   Execution.Mise_Ajour_Flag(new String(Y));
	   address++;
    }
}
public static class indexe{
	public static void STA() {
		int addInt=getAdress_Indexe(Compilation.Rom[address][1]);;
	 	   int addEff;
	 	  if(mode=='0')
	 		  addEff=addInt;
	 	   else {
	 		  addEff= Integer.parseInt(RAM[addInt][1]+RAM[addInt+1][1], 16);
	 		  System.out.println(addEff);}
		char[]pas=new char[2];
		pas[0]=A[0];
		pas[1]=A[1];
		RAM[addEff][1]=new String(pas);
		address ++;
}
	public static void STB() {
		int addInt=getAdress_Indexe(Compilation.Rom[address][1]);;
	 	   int addEff;
	 	  if(mode=='0')
	 		  addEff=addInt;
	 	   else
	 		  addEff= Integer.parseInt(RAM[addInt][1]+RAM[addInt+1][1], 16);
		char[]pas=new char[2];
		pas[0]=B[0];
		pas[1]=B[1];
		RAM[addEff][1]=new String(pas);
		address ++;
}
	public static void STD() {
		int addInt=getAdress_Indexe(Compilation.Rom[address][1]);;
	 	   int addEff;
	 	   if(mode=='0')
	 		  addEff=addInt;
	 	   else
	 		  addEff= Integer.parseInt(RAM[addInt][1]+RAM[addInt+1][1], 16); 
		char[]pas=new char[2];
		pas[0]=A[0];
		pas[1]=B[1];
		RAM[addEff][1]=new String(pas);
		pas[0]=B[0];
		pas[1]=B[1];
		RAM[addEff+1][1]=new String(pas);
		address ++;
}
	public static void STU() {
		int addInt=getAdress_Indexe(Compilation.Rom[address][1]);;
	 	   int addEff;
	 	   if(mode=='0')
	 		  addEff=addInt;
	 	   else
	 		  addEff= Integer.parseInt(RAM[addInt][1]+RAM[addInt+1][1], 16);  
			char[]pas=new char[2];
			pas[0]=U[0];
			pas[1]=U[1];
			RAM[addEff][1]=new String(pas);
			pas[0]=U[2];
			pas[1]=U[3];
			RAM[addEff+1][1]=new String(pas);
			address ++;
	}
	public static void STX() {
		int addInt=getAdress_Indexe(Compilation.Rom[address][1]);;
	 	   int addEff;
	 	   if(mode=='0')
	 		  addEff=addInt;
	 	   else
	 		  addEff= Integer.parseInt(RAM[addInt][1]+RAM[addInt+1][1], 16);  
		char[]pas=new char[2];
		pas[0]=X[0];
		pas[1]=X[1];
		RAM[addEff][1]=new String(pas);
		pas[0]=X[2];
		pas[1]=X[3];
		RAM[addEff+1][1]=new String(pas);
		address ++;;
	}
	public static void STY() {
		int addInt=getAdress_Indexe(Compilation.Rom[address][1]);;
	 	   int addEff;
	 	   if(mode=='0')
	 		  addEff=addInt;
	 	   else
	 		  addEff= Integer.parseInt(RAM[addInt][1]+RAM[addInt+1][1], 16); 
		char[]pas=new char[2];
		pas[0]=Y[0];
		pas[1]=Y[1];
		RAM[addEff][1]=new String(pas);
		pas[0]=Y[2];
		pas[1]=Y[3];
		RAM[addEff+1][1]=new String(pas);
		address ++;;
	}
	public static void STS() {
		int addInt=getAdress_Indexe(Compilation.Rom[address][1]);;
	 	   int addEff;
	 	   if(mode=='0')
	 		  addEff=addInt;
	 	   else
	 		  addEff= Integer.parseInt(RAM[addInt][1]+RAM[addInt+1][1], 16); 
		char[]pas=new char[2];
		pas[0]=S[0];
		pas[1]=S[1];
		RAM[addEff][1]=new String(pas);
		pas[0]=S[2];
		pas[1]=S[3];
		RAM[addEff+1][1]=new String(pas);
	}
	public static void ADCA() {
		   int addInt=getAdress_Indexe(Compilation.Rom[address][1]);;
	 	   int addEff;
	 	   if(mode=='0')
	 		  addEff=addInt;
	 	   else
	 		  addEff= Integer.parseInt(RAM[addInt][1]+RAM[addInt+1][1], 16); 
	       String mem=RAM[addEff][1];
	       String bin=convertion2bitethexa.hexaConver_4(mem.charAt(0))+convertion2bitethexa.hexaConver_4(mem.charAt(1));
	       String a=(convertion2bitethexa.hexaConver_4(A[0])+convertion2bitethexa.hexaConver_4(A[1]));
	       String S=convertion2bitethexa.BaseConvertion("2", "16", Somme.somme(a, bin));
	       int val=Integer.parseInt(S,16);
	 		 if(val<16)
			   A=("0"+S).toCharArray();
	 		 else
	 			A=S.toCharArray(); 
	       address ++;
	}
	public static void ADCB() {
	 	   int addInt=getAdress_Indexe(Compilation.Rom[address][1]);;
	 	   int addEff;
	 	  if(mode=='0')
	 		  addEff=addInt;
	 	   else
	 		  addEff= Integer.parseInt(RAM[addInt][1]+RAM[addInt+1][1], 16); 
	       String mem=RAM[addEff][1];
	       String bin=convertion2bitethexa.hexaConver_4(mem.charAt(0))+convertion2bitethexa.hexaConver_4(mem.charAt(1));
	       String a=(convertion2bitethexa.hexaConver_4(B[0])+convertion2bitethexa.hexaConver_4(B[1]));
	       String S=convertion2bitethexa.BaseConvertion("2", "16", Somme.somme(a, bin));
	       int val=Integer.parseInt(S,16);
	 		 if(val<16)
			   B=("0"+S).toCharArray();
	 		 else
	 			B=S.toCharArray(); 
	       address ++;
	}
    public static void LDA() {
    	int addInt=getAdress_Indexe(Compilation.Rom[address][1]);
    	if(mode=='0')
 	    A=RAM[addInt][1].toCharArray();
    	else {
    		A=RAM[Integer.parseInt(RAM[addInt][1]+RAM[addInt+1][1], 16)][1].toCharArray();	
    	}
 	    Execution.Mise_Ajour_Flag(new String(A));
	    address ++;
    }
    public static void LDB() {
    	int addInt=getAdress_Indexe(Compilation.Rom[address][1]);
    	System.out.println(addInt);
    	if(mode=='0')
    		B=RAM[addInt][1].toCharArray();
    	else {
    		B=RAM[Integer.parseInt(RAM[addInt][1]+RAM[addInt+1][1], 16)][1].toCharArray();		
    	}
 	    Execution.Mise_Ajour_Flag(new String(A));
	    address ++;
    }
    public static void LDS() {
    	int addeff=getAdress_Indexe(Compilation.Rom[address][1]);
    	int addInt;
    	if(mode=='0')
    		addInt=addeff;
    	else {
    		addInt=Integer.parseInt(RAM[addeff][1]+RAM[addeff+1], 16);	
    	}
	   String Result=RAM[addInt][1]+RAM[addInt+1][1];
	   S=Result.toCharArray();
	   Execution.Mise_Ajour_Flag(new String(S));
	   address++;
      }
    public static void LDD() {
    	int addeff=getAdress_Indexe(Compilation.Rom[address][1]);
    	int addInt;
    	if(mode=='0')
    		addInt=addeff;
    	else {
    		addInt=Integer.parseInt(RAM[addeff][1]+RAM[addeff+1][1], 16);	
    	}
	   A=RAM[addInt][1].toCharArray();
 	   B=RAM[addInt+1][1].toCharArray();
 	   Execution.Mise_Ajour_Flag(new String(A)+new String(B));
 	   address++;
       }
    public static void LDU() {
    	int addeff=getAdress_Indexe(Compilation.Rom[address][1]);
    	int addInt;
    	if(mode=='0')
    		addInt=addeff;
    	else {
    		addInt=Integer.parseInt(RAM[addeff][1]+RAM[addeff+1][1], 16);	
    	}
 	   String Result=RAM[addInt][1]+RAM[addInt+1][1];
 	   U=Result.toCharArray();
 	   Execution.Mise_Ajour_Flag(new String(U));
 	   address++;
       }
    public static void LDY() {
    	int addeff=getAdress_Indexe(Compilation.Rom[address][1]);
    	int addInt;
    	if(mode=='0')
    		addInt=addeff;
    	else {
    		addInt=Integer.parseInt(RAM[addeff][1]+RAM[addeff+1][1], 16);		
    	} 
   	   String Result=RAM[addInt][1]+RAM[addInt+1][1];
 	   Y=Result.toCharArray();
 	   Execution.Mise_Ajour_Flag(new String(Y));
 	   address++;
       }
    public static void LDX() {
    	int addeff=getAdress_Indexe(Compilation.Rom[address][1]);
    	int addInt;
    	if(mode=='0')
    		addInt=addeff;
    	else {
    		addInt=Integer.parseInt(RAM[addeff][1]+RAM[addeff+1][1], 16);		
    	}
 	   String Result=RAM[addInt][1]+RAM[addInt+1][1];
 	   X=Result.toCharArray();
 	   Execution.Mise_Ajour_Flag(new String(X));
 	   address++;
       }

}
 public static String getRegester(String bit6_5) {
	 if(bit6_5.equals("00"))
		 return "1"+new String(X);
	 else if(bit6_5.equals("01")) {
		 return "2"+new String(Y);
		 }
	 else if(bit6_5.equals("10"))
		 return "3"+new String(U);
	 else 
		 return "4"+new String(S);
 }
 public static void IncRegester(char register,int inc,int val) {
	 int new_Val=val+inc;
	 if(new_Val<0||new_Val>60000)
		  INTERFACE.ERROR("cette address n'exist pas");
	 String bi;
	 if(new_Val<16)
		 bi = "000" ;
	 else if(new_Val<256)
		 bi="00";
	 else if(new_Val<4096)
		 bi="0";
	 else
		 bi="";
	 switch(register) {
	 case '1':
		 X=(bi+convertion2bitethexa.BaseConvertion("10", "16", String.valueOf(new_Val))).toCharArray();
		 break;
	 case '2':
		 Y=(bi+convertion2bitethexa.BaseConvertion("10", "16", String.valueOf(new_Val))).toCharArray();
		 break;
	 case '3':
		 U=(bi+convertion2bitethexa.BaseConvertion("10", "16", String.valueOf(new_Val))).toCharArray();
		 break;
	 case '4':
		 S=(bi+convertion2bitethexa.BaseConvertion("10", "16", String.valueOf(new_Val))).toCharArray();
		 break;
	 }
 }
 
 public static  int getAdress_Indexe(String code) {
	  String binair= convertion2bitethexa.hexaConver_4(code.charAt(0))+convertion2bitethexa.hexaConver_4(code.charAt(1));
	  char regester =getRegester(binair.substring(1, 3)).charAt(0);
	  String AddrBase=getRegester(binair.substring(1, 3)).substring(1).trim();
	  int base=Integer.parseInt(AddrBase,16);
	  if(binair.startsWith("0")) {
		  if(binair.charAt(3)=='0') {
			  String inc=valsigneetcomp.VSver_base_10(binair.substring(4, 8));
			  int icr_decr=Integer.parseInt(inc);
			  return base+icr_decr;
		  }
		  else {
			  String inc=valsigneetcomp.CmpA_2_ver_base_10(binair.substring(3, 8));
			  int icr_decr=Integer.parseInt(inc);
			  if((base+icr_decr)<0) 
				  INTERFACE.ERROR("cette address n'exist pas");
			  else
				  return base+icr_decr;
		  }
	  }
	  else {
		  	  mode=binair.charAt(3);
			  if(code.endsWith("0")) {
				  IncRegester(regester,1,base);
				  return base;
			  }
			  else if(code.endsWith("1")) {
				  IncRegester(regester,2,base);
			      return base;
			  }
			  else if(code.endsWith("2")) {
				  if((base-1)<0)
					  INTERFACE.ERROR("cette address n'exist pas");
				  IncRegester(regester,-1,base);
			      return base-1;
			  }
			  else if(code.endsWith("3")) {
				  if((base-2)<0)
					  INTERFACE.ERROR("cette address n'exist pas");
				  IncRegester(regester,-2,base);
			      return base-2;
			  }
			  else if(code.endsWith("4")) {
			      return base;
			  }
			  else if(code.endsWith("5")) {
				  if((base+Integer.parseInt(new String(B), 16))>6000)
					  INTERFACE.ERROR("cette address n'exist pas");
			      return base+Integer.parseInt(new String(B), 16);
			  }
			  else if(code.endsWith("6")) {
				  if((base+Integer.parseInt(new String(A), 16))>6000)
					  INTERFACE.ERROR("cette address n'exist pas");
			      return base+Integer.parseInt(new String(A), 16);
			  }
			  else if(code.endsWith("8")) {
				  address++;
				  if((base+Integer.parseInt(Compilation.Rom[address][1], 16))>6000)
					  INTERFACE.ERROR("cette address n'exist pas");
			      return base+Integer.parseInt(Compilation.Rom[address][1], 16);
			  }
			  else if(code.endsWith("9")) {
				  address++;
				  address++;
				  if((base+Integer.parseInt(Compilation.Rom[address-1][1]+Compilation.Rom[address][1], 16))>6000)
					  INTERFACE.ERROR("cette address n'exist pas");
			      return base+Integer.parseInt(Compilation.Rom[address-1][1]+Compilation.Rom[address][1], 16);
			  }
			  else if(code.endsWith("B")) {
				  if((base+Integer.parseInt(new String(A)+new String(B), 16))>6000)
					  INTERFACE.ERROR("cette address n'exist pas");
			      return base+Integer.parseInt(new String(A)+new String(B), 16);
			  }
			  else if(code.endsWith("C")) {
				  address++;
				  if((address-3+Integer.parseInt(Compilation.Rom[address][1], 16))>6000)
					  INTERFACE.ERROR("cette address n'exist pas");
			      return address-3+Integer.parseInt(Compilation.Rom[address][1], 16);
			  }
			  else  {
				  address++;
				  address++;
				  if((address-4+Integer.parseInt(Compilation.Rom[address-1][1]+Compilation.Rom[address][1], 16))>6000)
					  INTERFACE.ERROR("cette address n'exist pas");
			      return address-4+Integer.parseInt(Compilation.Rom[address-1][1]+Compilation.Rom[address][1], 16);
			  }
	  }
	return base;
 }
 
}
