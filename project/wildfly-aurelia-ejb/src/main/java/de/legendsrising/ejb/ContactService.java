package de.legendsrising.ejb;

import de.legendsrising.model.Contact;
import org.slf4j.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless(name = "ContactService")
@LocalBean
public class ContactService
{
  @PersistenceContext
  private EntityManager entityManager;

  @Inject
  private Logger logger;

  public Contact create(Contact entity)
  {
    this.entityManager.persist(entity);
    this.logger.info("Creating Task: " + entity.toString() + " (id " + entity.getId() + ")");

    return entity;
  }
}
