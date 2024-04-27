/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Model.Mamifero;
import Model.Sector;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Matias
 */
public class SectorJpaController implements Serializable {

    public SectorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
     public SectorJpaController() {
        this.emf = Persistence.createEntityManagerFactory("ZoologicoJPA-PU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Sector sector) {
        if (sector.getMamiferos() == null) {
            sector.setMamiferos(new ArrayList<Mamifero>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ArrayList<Mamifero> attachedMamiferos = new ArrayList<Mamifero>();
            for (Mamifero mamiferosMamiferoToAttach : sector.getMamiferos()) {
                mamiferosMamiferoToAttach = em.getReference(mamiferosMamiferoToAttach.getClass(), mamiferosMamiferoToAttach.getCodigo());
                attachedMamiferos.add(mamiferosMamiferoToAttach);
            }
            sector.setMamiferos(attachedMamiferos);
            em.persist(sector);
            for (Mamifero mamiferosMamifero : sector.getMamiferos()) {
                Sector oldSectorOfMamiferosMamifero = mamiferosMamifero.getSector();
                mamiferosMamifero.setSector(sector);
                mamiferosMamifero = em.merge(mamiferosMamifero);
                if (oldSectorOfMamiferosMamifero != null) {
                    oldSectorOfMamiferosMamifero.getMamiferos().remove(mamiferosMamifero);
                    oldSectorOfMamiferosMamifero = em.merge(oldSectorOfMamiferosMamifero);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Sector sector) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Sector persistentSector = em.find(Sector.class, sector.getId());
            ArrayList<Mamifero> mamiferosOld = persistentSector.getMamiferos();
            ArrayList<Mamifero> mamiferosNew = sector.getMamiferos();
            ArrayList<Mamifero> attachedMamiferosNew = new ArrayList<Mamifero>();
            for (Mamifero mamiferosNewMamiferoToAttach : mamiferosNew) {
                mamiferosNewMamiferoToAttach = em.getReference(mamiferosNewMamiferoToAttach.getClass(), mamiferosNewMamiferoToAttach.getCodigo());
                attachedMamiferosNew.add(mamiferosNewMamiferoToAttach);
            }
            mamiferosNew = attachedMamiferosNew;
            sector.setMamiferos(mamiferosNew);
            sector = em.merge(sector);
            for (Mamifero mamiferosOldMamifero : mamiferosOld) {
                if (!mamiferosNew.contains(mamiferosOldMamifero)) {
                    mamiferosOldMamifero.setSector(null);
                    mamiferosOldMamifero = em.merge(mamiferosOldMamifero);
                }
            }
            for (Mamifero mamiferosNewMamifero : mamiferosNew) {
                if (!mamiferosOld.contains(mamiferosNewMamifero)) {
                    Sector oldSectorOfMamiferosNewMamifero = mamiferosNewMamifero.getSector();
                    mamiferosNewMamifero.setSector(sector);
                    mamiferosNewMamifero = em.merge(mamiferosNewMamifero);
                    if (oldSectorOfMamiferosNewMamifero != null && !oldSectorOfMamiferosNewMamifero.equals(sector)) {
                        oldSectorOfMamiferosNewMamifero.getMamiferos().remove(mamiferosNewMamifero);
                        oldSectorOfMamiferosNewMamifero = em.merge(oldSectorOfMamiferosNewMamifero);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = sector.getId();
                if (findSector(id) == null) {
                    throw new NonexistentEntityException("The sector with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Sector sector;
            try {
                sector = em.getReference(Sector.class, id);
                sector.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The sector with id " + id + " no longer exists.", enfe);
            }
            ArrayList<Mamifero> mamiferos = sector.getMamiferos();
            for (Mamifero mamiferosMamifero : mamiferos) {
                mamiferosMamifero.setSector(null);
                mamiferosMamifero = em.merge(mamiferosMamifero);
            }
            em.remove(sector);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Sector> findSectorEntities() {
        return findSectorEntities(true, -1, -1);
    }

    public List<Sector> findSectorEntities(int maxResults, int firstResult) {
        return findSectorEntities(false, maxResults, firstResult);
    }

    private List<Sector> findSectorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Sector.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Sector findSector(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Sector.class, id);
        } finally {
            em.close();
        }
    }

    public int getSectorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Sector> rt = cq.from(Sector.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
