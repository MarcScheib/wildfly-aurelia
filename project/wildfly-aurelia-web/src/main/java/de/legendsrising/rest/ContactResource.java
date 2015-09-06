package de.legendsrising.rest;

import de.legendsrising.model.Contact;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Stateless
@ApplicationPath("/api/v1")
@Path("contact")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ContactResource {
    @PersistenceContext
    private EntityManager entityManager;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Contact> listContacts() {
        TypedQuery<Contact> query = this.entityManager.createNamedQuery(Contact.FIND_ALL, Contact.class);

        return query.getResultList();
    }

    @GET
    @Path("{id}")
    public Contact getContact(@PathParam("id") Long id) {
        return this.entityManager.find(Contact.class, id);
    }

    @DELETE
    @Path("{id}")
    public void deleteContact(@PathParam("id") Long id) {
        this.entityManager.remove(this.getContact(id));
    }
}
