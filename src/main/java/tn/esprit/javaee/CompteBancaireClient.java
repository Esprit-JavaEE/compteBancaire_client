package tn.esprit.javaee;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javaee.ejb.CompteBancaireRemote;



public class CompteBancaireClient {

	public static void main(String[] args) throws  InterruptedException, NamingException {
		
		//Deux executions signifie 2 clients differents !
		String jndiName="compteBancaire_serveur/CompteBancaire!javaee.ejb.CompteBancaireRemote";

		Context context = new InitialContext();
		CompteBancaireRemote proxy=(CompteBancaireRemote) context.lookup(jndiName);
		System.out.println(proxy.versement("Walid_YAICH", 20)); //Le client demande un versement
		System.out.println(proxy.retrait("Walid_YAICH", 10));    //Le client demande un retrait
		System.out.println(proxy.versement("Walid_YAICH", 10));  //Le client demande un versement
		System.out.println(proxy.retrait("Walid_YAICH", 10));    //Le client demande un retrait

		//EXIT
	}
}

