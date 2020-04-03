package rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ServeurRmi {

	
	
	public static void main(String[] args) {
		try {
			// creation l'objet distant
			BanqueServiceImpl banqueServiceImpl = new BanqueServiceImpl();
			System.out.println(banqueServiceImpl.toString());
			// l'annuaire doit etre demarre/ initilise:
			LocateRegistry.createRegistry(1099);			
			// Publier la reference de l'objet distant
			// Doit etre declarer comme ci-dessous avec l'adresse compos�e de
			// "rmi://adresse ip
			// l'annuaire utilise generalement le port 1099
			// suivi du nom de l'objet ici BANQUE, par exemple
			// publier ca reference ===> banqueServiceImpl
			Naming.rebind("rmi://localhost:1099/BANQUE", banqueServiceImpl);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
