package system;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author emsi
 * @version 1.0
 * @created 02-janvier 2023
 */
public class Client {

	private String NomClient;
	private int NumClient;
	private String PrenomClient;
	private List<Compte> mCompte=new ArrayList<>();

	public List<Compte> getMCompte() { return mCompte;}
	public void setMCompte(List<Compte> mCompte) {
		this.mCompte = mCompte; }
	
	
	public Client(String nomClient, int numClient, String prenomClient) {
		NomClient = nomClient;
		NumClient = numClient;
		PrenomClient = prenomClient;
	}
	public Client(){

	}

	public void finalize() throws Throwable {

	}

	public void afficherClient() {
		logger.addHandler(fileHandler);
		if (logger.isLoggable(Level.INFO)) {
			logger.info(" nom du client:"+getNomClient());
			logger.info("le nom du client:"+getNomClient());
			logger.info("le prenom du client:"+getPrenomClient());
			logger.info("-- Les comptes bancaires associes : ------");
			for(var i=0;i<getMCompte().size();i++) {
				logger.info(getMCompte().get(i).toString()); }
		}
	}

	public String getNomClient(){
		return NomClient;
	}

	public int getNumClient(){
		return NumClient;
	}

	public String getPrenomClient(){
		return PrenomClient;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNomClient(String newVal){
		NomClient = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setNumClient(int newVal){
		NumClient = newVal;
	}

	/**
	 * 
	 * @param newVal
	 */
	public void setPrenomClient(String newVal){
		PrenomClient = newVal;
	}

	Logger logger = Logger.getLogger(Client.class.getName());
	FileHandler fileHandler;

	public void initialiseFileHandler() throws
			SecurityException, IOException {
		fileHandler = new FileHandler("app.log");}
}