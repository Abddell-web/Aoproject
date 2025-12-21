package TestProj2;

import java.util.HashMap;


public class Compilation {
	static String [][] Rom=new String[600][2];
	public static int adress;
	   static final HashMap<String,String[][]> map=new HashMap<String,String[][]>();
	   
	   static final String []idexTab= {"0","1","2","3","4","5","6","8","9","B","C","D"};
	   static final HashMap<String,String> Bit5_6=new HashMap<String,String>();
	   public static void init_Rom() {
		   	  adress=0;
			  for(int i=0;i<600;i++ ) {
				  if(i<16) {
				  Rom[i][0]="000"+convertion2bitethexa.BaseConvertion("10", "16", String.valueOf(i));
				  }
				  else if(i<256) {
					  Rom[i][0]="00"+convertion2bitethexa.BaseConvertion("10", "16", String.valueOf(i));
					  }
				  else if(i<4096) {
					  Rom[i][0]="0"+convertion2bitethexa.BaseConvertion("10", "16", String.valueOf(i));
					  }
				  else
					  Rom[i][0]=convertion2bitethexa.BaseConvertion("10", "16", String.valueOf(i));  
				  Rom[i][1]="FF";
			  }
	   }
	  static {
		Bit5_6.put("X","00");
		Bit5_6.put("Y","01");
		Bit5_6.put("U","10");
		Bit5_6.put("S","11");
		Bit5_6.put("PC","00");
	    map.put("LDA", new String[][]{{"86","96","A6","B6",null},{"2","2","2","3",null}});
	    map.put("LDB", new String[][]{{"C6","D6","E6","F6",null},{"2","2","2","3",null}});
	    map.put("LDD", new String[][]{{"CC","DC","EC","FC",null},{"3","2","2","3",null}});
	    map.put("LDS", new String[][]{{"10CE","10DE","10EE","10FE",null},{"4","3","3","4",null}});
	    map.put("LDU", new String[][]{{"CE","DE","EE","FE",null},{"3","2","2","3",null}});
	    map.put("LDX", new String[][]{{"8E","9E","AE","BE",null},{"3","2","2","3",null}});
	    map.put("LDY", new String[][]{{"108E","109E","10AE","10BE",null},{"4","3","3","4",null}});
	    map.put("ABX", new String[][]{{null,null,null,null,"3A"},{null,null,null,null,"1"}});
	    map.put("STA", new String[][]{{null,"97","A7","B7",null},{null,"2","2","3",null}});
	    map.put("STB", new String[][]{{null,"D7","E7","F7",null},{null,"2","2","3",null}});
	    map.put("STD", new String[][]{{null,"DD","ED","FD",null},{null,"2","2","3",null}});
	    map.put("STS", new String[][]{{null,"10DF","10EF","10FF",null},{null,"3","3","4",null}});
	    map.put("STU", new String[][]{{null,"DF","EF","FF",null},{null,"2","2","3",null}});
	    map.put("STX", new String[][]{{null,"9F","AF","BF",null},{null,"2","2","3",null}});
	    map.put("STY", new String[][]{{null,"109F","10AE","10BE",null},{null,"3","3","4",null}});
	    map.put("LSLA", new String[][]{{null,null,null,null,"48"},{null,null,null,null,"1"}});
	    map.put("LSLB", new String[][]{{null,null,null,null,"58"},{null,null,null,null,"1"}});
	    map.put("LSRA", new String[][]{{null,null,null,null,"44"},{null,null,null,null,"1"}});
	    map.put("LSRB", new String[][]{{null,null,null,null,"54"},{null,null,null,null,"1"}});
	    map.put("INCA", new String[][]{{null,null,null,null,"4C"},{null,null,null,null,"1"}});
	    map.put("INCB", new String[][]{{null,null,null,null,"5C"},{null,null,null,null,"1"}});
	    map.put("DECA", new String[][]{{null,null,null,null,"4A"},{null,null,null,null,"1"}});
	    map.put("DECB", new String[][]{{null,null,null,null,"5A"},{null,null,null,null,"1"}});
	    map.put("ROLA", new String[][]{{null,null,null,null,"49"},{null,null,null,null,"1"}});
	    map.put("ROLB", new String[][]{{null,null,null,null,"59"},{null,null,null,null,"1"}});
	    map.put("ADCA", new String[][]{{"89","99","A9","B9",null},{"2","2","2","3",null}});
	    map.put("ADCB", new String[][]{{"C9","D9","E9","F9",null},{"2","2","2","3",null}});
	    }
	  // MODE ADRESSGE indexe direct
	   static void IndexeDirect_4Bit(String valeur,String signe){
		   String[][] Tab=map.get(valeur.substring(0, valeur.indexOf(' ')));
		   if(Tab[0][2].length()==2) 
			   Rom[adress][1]=Tab[0][2];
		   else {
			   Rom[adress][1]=Tab[0][2].substring(0, 2);
			   adress++;
			   Rom[adress][1]=Tab[0][2].substring(2, 4);
		   }
		   adress++;
           String bit6_5=Bit5_6.get(valeur.substring(valeur.indexOf(',')+1,valeur.length()));
           String valInsert;
           String incVal=String.valueOf(Integer.parseInt(valeur.substring(valeur.indexOf(' '),valeur.indexOf(',')).trim(), 16));
           if(incVal.equals("-16"))
        	   signe="";
           valInsert="0"+bit6_5+signe+convertion2bitethexa.Complement_4(incVal);
           Rom[adress][1]=convertion2bitethexa.BaseConvertion("2", "16", valInsert);
           adress++;
      
	   }
	   static void IndexeDirect_7BitRgester(String valeur,String type){
		   String[][] Tab=map.get(valeur.substring(0, valeur.indexOf(' ')));
		   if(Tab[0][2].length()==2) 
			   Rom[adress][1]=Tab[0][2] ;
		   else {
			   Rom[adress][1]=Tab[0][2].substring(0, 2) ;
			   adress++;
			   Rom[adress][1]=Tab[0][2].substring(2, 4);
		   }
		   adress++;
           String bit6_5=Bit5_6.get(valeur.substring(valeur.indexOf(',')+1,valeur.length()));
           String increentatio=valeur.substring(valeur.indexOf(' ')+1,valeur.indexOf(','));
           String valInsert;
           if(valeur.substring(valeur.indexOf(',')+1).equalsIgnoreCase("pc")) {
        	   valInsert="1"+bit6_5+type+"1100"; }
           else {
        	   valInsert="1"+bit6_5+type+"1000";
        	   }
           Rom[adress][1]=convertion2bitethexa.BaseConvertion("2", "16", valInsert);
           adress++;
           Rom[adress][1]=increentatio;
           adress++;
	   }
	   static void Indexe_15BitRgester(String valeur,String type){
		   String[][] Tab=map.get(valeur.substring(0, valeur.indexOf(' ')));
		   if(Tab[0][2].length()==2) 
			   Rom[adress][1]=Tab[0][2] ;
		   else {
			   Rom[adress][1]=Tab[0][2].substring(0, 2) ;
			   adress++;
			   Rom[adress][1]=Tab[0][2].substring(2, 4);
		   }
		   adress++;
           String bit6_5=Bit5_6.get(valeur.substring(valeur.indexOf(',')+1,valeur.length()));
           String increentatio=valeur.substring(valeur.indexOf(' ')+1,valeur.indexOf(','));
           String valInsert=null;
           if(valeur.substring(valeur.indexOf(',')+1).equalsIgnoreCase("pc")) {
        	   valInsert="1"+bit6_5+type+"1101"; }
           else {
        	   valInsert="1"+bit6_5+type+"1001";}
           Rom[adress][1]=convertion2bitethexa.BaseConvertion("2", "16", valInsert);
           adress++;
           Rom[adress][1]=increentatio.substring(0, 2);
           adress++;
           Rom[adress][1]=increentatio.substring(2, 4);
           adress++;
	   }
	   static void Indexe_Acumilateur(String valeur,String type){
		   String[][] Tab=map.get(valeur.substring(0, valeur.indexOf(' ')));
		   if(Tab[0][2].length()==2) 
			   Rom[adress][1]=Tab[0][2] ;
		   else {
			   Rom[adress][1]=Tab[0][2].substring(0, 2);
			   adress++;
			   Rom[adress][1]=Tab[0][2].substring(2, 4);
		   }
		   adress++;
		   String acumlaeur_code;
		   String acumlaeur;
		   acumlaeur=valeur.substring(valeur.indexOf(' ')+1, valeur.indexOf(',')).trim();
		   if(acumlaeur.equals("A"))
			   acumlaeur_code="0110";
		   else if(acumlaeur.equals("B"))
			   acumlaeur_code="0101";
		   else
			   acumlaeur_code="1011";
           String bit6_5=Bit5_6.get(valeur.substring(valeur.indexOf(',')+1,valeur.length()));
           String valInsert;
           valInsert="1"+bit6_5+type+acumlaeur_code;
           Rom[adress][1]=convertion2bitethexa.BaseConvertion("2", "16", valInsert);
           adress++;
	   }
	   static void Indexe2_Inc_Dec(String valeur,String type){
		   String[][] Tab=map.get(valeur.substring(0, valeur.indexOf(' ')));
		   if(Tab[0][2].length()==2) 
			   Rom[adress][1]=Tab[0][2] ;
		   else {
			   Rom[adress][1]=Tab[0][2].substring(0, 2) ;
			   adress++;
			   Rom[adress][1]=Tab[0][2].substring(2, 4);
		   }
		   adress++;  
		   String Inc_Dec_code = null;
		   String type_inc=valeur.substring(valeur.indexOf(',')+1, valeur.length());
		   String bit6_5 = null;
		   if(valeur.substring(valeur.indexOf(' '), valeur.indexOf(',')).isBlank())
			   Inc_Dec_code="0100";
		   if(type_inc.startsWith("-")) {
			   if(type_inc.startsWith("--")) {
    				Inc_Dec_code="0011";
		            bit6_5=Bit5_6.get(type_inc.substring(2,type_inc.trim().length()));

				   }
			   else {
				   Inc_Dec_code="0010";
				   bit6_5=Bit5_6.get(type_inc.substring(1,type_inc.trim().length()));
				   }
		   }
		   else if(type_inc.endsWith("+")) {
			   bit6_5=Bit5_6.get(valeur.substring(valeur.indexOf(',')+1,valeur.indexOf(',')+2));
			   if(type_inc.endsWith("++")) {
				   Inc_Dec_code="0001";
				   }
			   else {
				   Inc_Dec_code="0000";
				   }
		   }
		   else
			   bit6_5=Bit5_6.get(type_inc.substring(0,1)) ;
           String valInsert;
           valInsert="1"+bit6_5+type+Inc_Dec_code;
           Rom[adress][1]=convertion2bitethexa.BaseConvertion("2", "16", valInsert);
           adress++;
		   }
	   
	   //MODE ADRESSGE DIRECT
	   static void Direct2(String valeur){
		   String[][] Tab=map.get(valeur.substring(0, valeur.indexOf(' ')));
		   Rom[adress][1]=Tab[0][1] ;
		   adress++;
		   Rom[adress][1]= valeur.substring(valeur.indexOf(' ')+1,valeur.length());
		   adress++;
	   }
	   static void Direct3(String valeur){
		   String[][] Tab=map.get(valeur.substring(0, valeur.indexOf(' ')));
		   String Code=Tab[0][1];
		   Rom[adress][1]=Code.substring(0, 2);
		   adress++;
		   Rom[adress][1]=Code.substring(2, 4);
		   adress++;
		   Rom[adress][1]= valeur.substring(valeur.indexOf(' ')+1, valeur.length());
		   adress++;
	   }

	   //MODE ADRESSGE ETENDU
	   static void Etendu3Direct(String valeur){
		   String[][] Tab=map.get(valeur.substring(0, valeur.indexOf(' ')));
		   Rom[adress][1]=Tab[0][3] ;
		   adress++;
		   Rom[adress][1]= valeur.substring(valeur.indexOf(' ')+1, valeur.indexOf(' ')+3);
		   adress++;
		   Rom[adress][1]= valeur.substring(valeur.indexOf(' ')+3, valeur.length());
		   adress++;
	   }
	   static void Etendu4Direct(String valeur){
		   String[][] Tab=map.get(valeur.substring(0, valeur.indexOf(' ')));
		   String Code=Tab[0][3];
		   Rom[adress][1]=Code.substring(0, 2);
		   adress++;
		   Rom[adress][1]=Code.substring(2, 4);
		   adress++;
		   Rom[adress][1]= valeur.substring(valeur.indexOf(' ')+1, valeur.indexOf(' ')+3);
		   adress++;
		   Rom[adress][1]= valeur.substring(valeur.indexOf(' ')+3, valeur.length());
		   adress++;
	   }
	   //MODE ADRESSGE ETENDUINDERICT
	   static void Etendu3InDirect(String valeur){
		   String[][] Tab=map.get(valeur.substring(0, valeur.indexOf(' ')));
		   Rom[adress][1]=Tab[0][2] ;
		   adress++;
		   Rom[adress][1]="9F";
		   adress++;
		   Rom[adress][1]= valeur.substring(valeur.indexOf(' ')+1, valeur.indexOf(' ')+3);
		   adress++;
		   Rom[adress][1]= valeur.substring(valeur.indexOf(' ')+3, valeur.length());
		   adress++;
	   }
	   static void Etendu4InDirect(String valeur){
		   String[][] Tab=map.get(valeur.substring(0, valeur.indexOf(' ')));
		   String Code=Tab[0][2];
		   Rom[adress][1]=Code.substring(0, 2);
		   adress++;
		   Rom[adress][1]=Code.substring(2, 4);
		   adress++;
		   Rom[adress][1]="9F";
		   adress++;
		   Rom[adress][1]= valeur.substring(valeur.indexOf(' ')+1, valeur.indexOf(' ')+3);
		   adress++;
		   Rom[adress][1]= valeur.substring(valeur.indexOf(' ')+3, valeur.length());
		   adress++;
	   }
	   static void AppelImed(String choix,String valeur) {
		   switch(choix) {
		   case "2":
			   Imed2(valeur);
			break;
		   case "3":
			   Imed3(valeur);
			break;
		   case "4":
			   Imed4(valeur);
			break;

		   }
	   }
	   static void AppelEtenduDirect(String choix,String valeur) {
		   switch(choix) {
		   case "3":
			   Etendu3Direct(valeur);
			break;
		   case "4":
			   Etendu4Direct(valeur);
			break;
		   }
	   }
	   static void AppelEtenduInDirect(String choix,String valeur) {
		   switch(choix) {
		   case "3":
			   Etendu3InDirect(valeur);
			break;
		   case "4":
			   Etendu4InDirect(valeur);
			break;
		   }
	   }
	   static void AppelDirect(String choix,String valeur) {
		   switch(choix) {
		   case "2":
			   Direct2(valeur);
			break;
		   case "3":
			   Direct3(valeur);
			break;
		   }
	   }
	   static void AppelInherent(String instruction) {
		   String[][] Tab=map.get(instruction);
		   Rom[adress][1]=Tab[0][4]; 
		   adress++;
	   }
	   static void Imed2(String valeur){
		   String Test_Taille=valeur.substring(valeur.indexOf(' ')+1,valeur.length()).trim();
		   if(Test_Taille.length()!=2) {
			   INTERFACE.ERROR("taille invalid");
			   return;
			   }
		   String[][] Tab=map.get(valeur.substring(0, valeur.indexOf(' ')));
		   Rom[adress][1]=Tab[0][0];
		   adress++;
		   Rom[adress][1]=valeur.substring(valeur.indexOf(' ')+1,valeur.length()).trim();
		   adress++;
	   }
	   static void Imed3(String valeur){
		   String Test_Taille=valeur.substring(valeur.indexOf(' ')+1, valeur.indexOf(' ')+3).trim();
		   String Test_Taille2=valeur.substring(valeur.indexOf(' ')+3, valeur.length()).trim();
		   if(Test_Taille.length()!=2||Test_Taille2.length()!=2) {
			   INTERFACE.ERROR("taille invalid");
			   return;
			   }
		   String[][] Tab=map.get(valeur.substring(0, valeur.indexOf(' ')));
		   Rom[adress][1]=Tab[0][0] ;
		   adress++;
		   Rom[adress][1]= valeur.substring(valeur.indexOf(' ')+1, valeur.indexOf(' ')+3);
		   adress++;
		   Rom[adress][1]= valeur.substring(valeur.indexOf(' ')+3, valeur.length());
		   adress++;
	   }
	   static void Imed4(String valeur){
		   String Test_Taille=valeur.substring(valeur.indexOf(' ')+1, valeur.indexOf(' ')+3).trim();
		   String Test_Taille2=valeur.substring(valeur.indexOf(' ')+3, valeur.length()).trim();
		   if(Test_Taille.length()!=2||Test_Taille2.length()!=2) {
			   INTERFACE.ERROR("taille invalid");
			   return;
			   }
		   String[][] Tab=map.get(valeur.substring(0, valeur.indexOf(' ')));
		   String Code=Tab[0][0];
		   Rom[adress][1]=Code.substring(0, 2);
		   adress++;
		   Rom[adress][1]=Code.substring(2, 4);
		   adress++;
		   Rom[adress][1]= valeur.substring(valeur.indexOf(' ')+1, valeur.indexOf(' ')+3);
		   adress++;
		   Rom[adress][1]= valeur.substring(valeur.indexOf(' ')+3, valeur.length());
		   adress++;
	   }
	   
	   
}
