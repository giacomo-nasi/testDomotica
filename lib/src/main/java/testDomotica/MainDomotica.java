package testDomotica;

import java.io.IOException;
import java.util.Scanner; 

public class MainDomotica {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);
			//riscaldamento		   	
		    System.out.println("Inserire il nome di rete dell' attuatore del riscaldamento");
		    MobiusAPI heating = new MobiusAPI(reader.nextLine().trim());
		    Integer heatingStatus = heating.getLatestContentInstance();
		    
		    //temperatura
		    System.out.println("Inserire il nome di rete del termometro");
		    MobiusAPI temp = new MobiusAPI(reader.nextLine().trim());
		    int LastMeasurementTemp = temp.getLatestContentInstance();
		    
		    //sensore di presenza		   	
		    System.out.println("Inserire il nome di rete del sensore di presenza");
		    MobiusAPI presenceSensor = new MobiusAPI(reader.nextLine().trim());
		    Integer presenceStatus = presenceSensor.getLatestContentInstance();	
		    
		    //luci e gruppo luci
		    System.out.println("Inserire il numero di luci presenti nella stanza (gruppo luci)");
		    int ligthsNumber = Integer.parseInt(reader.nextLine().trim());
		    String[] ligthsNames = new String [ligthsNumber];
		    for(int i = 0; i < ligthsNumber; i++)	{
		    	System.out.println("Inserire il nome di rete della " + (i + 1) + "° luce");
		    	ligthsNames[i] = reader.nextLine().trim();
		    }
		    System.out.println("Inserire l'identificativo rete del gruppo luci");
		    String ligthsGroupName = reader.nextLine().trim();
		    MobiusAPI lightsGroup = new MobiusAPI(ligthsGroupName);
		    lightsGroup.groupCreate(ligthsNames);
		    
		    //preparo un membro del gruppo luci e le relative MobiusAPI a disposizione: serviranno per la
		    //gestione della chiamta del metodo groupHandling
		    MobiusAPI groupMember = new MobiusAPI(ligthsNames[0]);
		    
		    //chiusura reader
		    reader.close();
		    
		    //check primo valore del riscaldamento (heating) e relativo setting
		    if(LastMeasurementTemp < 19 && heatingStatus == 0)	{
		    	heating.setInitialStatus(1);
		    	heatingStatus = 1;
		    }	else	{
		    	if(LastMeasurementTemp > 22 && heatingStatus == 1)	{
		    		heating.setInitialStatus(0);
			    	heatingStatus = 0;
		    	}
		    }
		    
		    //primo setaggio del gruppo luci per "uniformare" i valori di tutte le lampadine
		    lightsGroup.groupHandling(presenceStatus);

		    
	    	//racchiudere tutto nel while 	
		    while(true)	{
		    	
		    	System.out.println("Check ultime misurazioni dei sensori e relativa gestione degli attuatori");
		    	//gestione luci
		    	if(groupMember.getLatestContentInstance() == 1 && presenceStatus == 1)	{
		    		System.out.println("Qualcuno è nella stanza e le luci sono già accese,"
		    				+ " non occorre invocare il metodo per la gestione delle luci");
		    	}	else	{
		    		if(groupMember.getLatestContentInstance() == 0 && presenceStatus == 0) {
			    		System.out.println("Nella stanza non vi è nessuno e le luci sono spente,"
			    				+ " non occorre invocare il metodo per la gestione delle luci");
		    		}	else	{
		    			if((groupMember.getLatestContentInstance() == 0 && presenceStatus == 1) ||
		    					(groupMember.getLatestContentInstance() == 1 && presenceStatus == 0))	{
		    			    lightsGroup.groupHandling(presenceStatus);
		    			}
		    		}
		    	}			    
			    //gestione attuatore in base alla temperatura
			    if(19 <= LastMeasurementTemp && LastMeasurementTemp <= 22)	{
			    	System.out.println("Temperatura ottimale, non è necessario cambiare stato al riscaldamento");
			    }	else	{
			    	if(LastMeasurementTemp < 19 && heatingStatus == 1)	{
			    		System.out.println("Temperatura ancora bassa ma riscaldamento già acceso,"
			    				+ " non occorre invocare il metodo per la gestione del riscaldamento");
			    	}	else	{
			    		if (LastMeasurementTemp > 22 && heatingStatus == 0)	{
			    			System.out.println("Temperatura ancora alta ma riscaldamento già spento,"
				    				+ " non occorre invocare il metodo per la gestione del riscaldamento");
			    		}	else	{
			    			if((LastMeasurementTemp < 19 && heatingStatus == 0) ||
			    					(LastMeasurementTemp > 22 && heatingStatus == 1))	{
							    heatingStatus = heating.heatingHandling(LastMeasurementTemp, heatingStatus);
			    			}
			    		}
			    	}
			    }
			    
			    //outputs per controllo
			    System.out.println("La temperatura nella stanza è: " + LastMeasurementTemp);
			    System.out.println("Stato del riscaldamento: "+ heatingStatus);
			    System.out.println();
			    
			    Thread.sleep(5000);
			    
			    LastMeasurementTemp = temp.getLatestContentInstance();
			    presenceStatus = presenceSensor.getLatestContentInstance();
		    }	    
	}

}
