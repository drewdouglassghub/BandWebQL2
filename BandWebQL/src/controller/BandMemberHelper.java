package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Band;
import model.BandMember;

public class BandMemberHelper {

	static	EntityManagerFactory emfactory	=	
			Persistence.createEntityManagerFactory("BandSQL");
	
	public void insertMember(BandMember bm) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(bm);
		em.getTransaction().commit();
		em.close();
		
	}
		
		public List<BandMember> showAllMembers() {
			EntityManager em = emfactory.createEntityManager();
			List<BandMember> allMusicians = em.createQuery("SELECT i FROM BandMember i").getResultList();
			System.out.println("");
			return allMusicians;
		}

		public void deleteMember(BandMember toDelete) {
			// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<BandMember> typedQuery = em.createQuery(
					"select bm from BandMember bm where bm.firstName = :selectedFirstName and bm.lastName = :selectedLastName and bm.instrument = :selectedInstrument",
					BandMember.class);
			// Substitute parameter with actual data from the toDelete item
			typedQuery.setParameter("selectedFirstName", toDelete.getFirstName());
			typedQuery.setParameter("selectedLastName", toDelete.getLastName());
			typedQuery.setParameter("selectedInstrument", toDelete.getInstrument());

			// we only want one result
			typedQuery.setMaxResults(1);

			// get the result and save it into a new list item
			BandMember result = typedQuery.getSingleResult();

			// remove it
			em.remove(result);
			em.getTransaction().commit();
			em.close();

		}

		public void updateMember(BandMember toEdit) {
			// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			
			em.merge(toEdit);
			em.getTransaction().commit();
			em.close();
		}
		
		public BandMember searchForMemberById(int idToEdit) {
			// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			BandMember found = em.find(BandMember.class, idToEdit);
			em.close();
			return found;
		}

		public List<BandMember> searchForMemberByName(String firstName, String lastName) {
			// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<BandMember> typedQuery = em.createQuery("select bm from BandMember bm where bm.firstName = :selectedFirstName and bm.lastName = :selectedLastName", BandMember.class);
			typedQuery.setParameter("selectedFirstName", firstName);
			typedQuery.setParameter("selectedLastName", lastName);

			List<BandMember> foundMembers = typedQuery.getResultList();
			em.close();
			return foundMembers;
		}

		public List<BandMember> searchForMemberByInstrument(String instrumentName) {
			// TODO Auto-generated method stub
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<BandMember> typedQuery = em.createQuery("select bm from BandMember bm where bm.instrument = :selectedInstrument", BandMember.class);
			typedQuery.setParameter("selectedInstrument", instrumentName);

			List<BandMember> foundItems = typedQuery.getResultList();
			em.close();
			return foundItems;
		}
		
		public void cleanUp(){
			emfactory.close();
		
	}

	
	
	
}
