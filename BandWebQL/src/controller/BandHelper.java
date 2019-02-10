package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Band;
import model.BandMember;

public class BandHelper {

	static	EntityManagerFactory emfactory	=	
			Persistence.createEntityManagerFactory("BandWebQL");
	
	public void insertBand(Band b) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(b);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public Band searchForBandById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Band found = em.find(Band.class, idToEdit);
		em.close();
		return found;
	}
	
	public List<Band> showAllBands() {
		EntityManager em = emfactory.createEntityManager();
		List<Band> allBands = em.createQuery("SELECT i FROM Band i").getResultList();
		System.out.println("");
		return allBands;
	}

	public void deleteBand(Band toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Band> typedQuery = em.createQuery(
				"select b from Band b where b.bandName = :selectedName and b.musicStyle = :selectedStyle",
				Band.class);
		// Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedName", toDelete.getBandName());
		typedQuery.setParameter("selectedStyle", toDelete.getMusicStyle());

		// we only want one result
		typedQuery.setMaxResults(1);

		// get the result and save it into a new list item
		Band result = typedQuery.getSingleResult();

		// remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();

	}


	public void updateBand(Band toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public List<Band> searchForBandByName(String bandName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Band> typedQuery = em.createQuery("select b from Band b where b.bandName = :selectedName", Band.class);
		typedQuery.setParameter("selectedName", bandName);

		List<Band> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public List<Band> searchForBandByStyle(String style) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Band> typedQuery = em.createQuery("select b from Band b where b.musicStyle = :selectedStyle", Band.class);
		typedQuery.setParameter("selectedStyle", style);

		List<Band> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	public void cleanUp(){
		emfactory.close();
	
}

	
	
}
