package com.airhacks.workshops.business.registrations.boundary;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author airhacks.com
 */
public class RegistrationsBoundaryIT {

    private static final String RUT_URI = "http://localhost:8080/workshops/resources/registrations";

    //Resource Under Test
    private WebTarget rut;

    @Before
    public void initClient() {
        Client client = ClientBuilder.newBuilder().
                build();
        this.rut = client.target(RUT_URI);
    }

    @Test
    public void dummy() {
        long originId = 42;
        Registration actual = this.rut.path("/{id}/dummy").
                resolveTemplate("id", originId).
                request().
                accept(MediaType.APPLICATION_XML).
                get(Registration.class);
        assertNotNull(actual);
        long actualId = actual.getId();
        assertThat(actualId, is(originId));
    }

}
