//une addition binaire sur 8 bits avec gestion des retenues et modification du CCR
package TestProj2;

public class Somme {

	public static String somme(String a,String v2) {

		char[] result=new char[8];
		char[] retenu= {Execution.CCR[7] ,'0'};
		for(int i=7;i>=0;i--) {
			retenu[1]=retenu[0];
			if(a.charAt(i)+v2.charAt(i)+retenu[1]=='1'+'1'+'1') {
				retenu[0]='1';
				result[i]='1';
			}
			else if(a.charAt(i)+v2.charAt(i)+retenu[1]=='1'+'1'+'0') {
				retenu[0]='1';
				result[i]='0';	
			}
			else if((a.charAt(i)+v2.charAt(i)+retenu[1])=='1'+'0'+'0') {
				retenu[0]='0';
				result[i]='1';	
			}
			else if(a.charAt(i)+v2.charAt(i)+retenu[1]=='0'+'0'+'0'){
				retenu[0]='0';
				result[i]='0';	
			}
		}
		if(retenu[1]!=retenu[0]) 
			Execution.CCR[6]='1';
		Execution.CCR[4]=result[0];
		Execution.CCR[7]=retenu[0];
		return new String(result);
	}
		public static void main(String []a) {
			System.out.println("result  "+somme("10000000","11111111"));
			System.out.println(new String(Execution.CCR));
		}
}
