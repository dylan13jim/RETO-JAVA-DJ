package com.tcs.retomicroservices.controller;

import com.tcs.retomicroservices.entity.Client;
import com.tcs.retomicroservices.entity.Person;
import com.tcs.retomicroservices.service.ServiceClient;
import com.tcs.retomicroservices.service.ServicePerson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ClientControllerTest {

    @Mock
    private ServiceClient serviceClient;

    @Mock
    private ServicePerson servicePerson;

    @InjectMocks
    private ClientController clientController;

    private Client client;
    private Person person;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        person = new Person();
        person.setIdperson(1L);

        client = new Client();
        client.setPerson(person);
        client.setPassword("dylan12345");
        client.setEstate(true);
    }

    @Test
    void testPostClient_Success() {
        when(servicePerson.getPersonById(1L)).thenReturn(person);

        ResponseEntity<String> response = clientController.postClient(client);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Cliente agregado correctamente.", response.getBody());
        verify(serviceClient, times(1)).postClient(client);
    }

    @Test
    void testPostClient_MissingPerson() {
        client.setPerson(null);

        ResponseEntity<String> response = clientController.postClient(client);

        assertEquals(400, response.getStatusCodeValue());
        assertEquals("Debe proporcionar una persona válida.", response.getBody());
    }

    @Test
    void testPostClient_PersonNotFound() {
        when(servicePerson.getPersonById(1L)).thenThrow(new RuntimeException());

        ResponseEntity<String> response = clientController.postClient(client);

        assertEquals(400, response.getStatusCodeValue());
        assertEquals("La persona seleccionada no existe.", response.getBody());
    }

    @Test
    void testPostClient_EmptyPassword() {
        client.setPassword("   ");
        when(servicePerson.getPersonById(1L)).thenReturn(person);

        ResponseEntity<String> response = clientController.postClient(client);

        assertEquals(400, response.getStatusCodeValue());
        assertEquals("La contraseña no puede estar vacía.", response.getBody());
    }

    @Test
    void testGetClient() {
        List<Client> clients = Arrays.asList(client);
        when(serviceClient.getClient()).thenReturn(clients);

        List<Client> result = clientController.getClient();

        assertEquals(1, result.size());
        assertEquals(client, result.get(0));
    }

    @Test
    void testDeleteClient_Success() {
        doNothing().when(serviceClient).deleteClient(1L);

        ResponseEntity<String> response = clientController.deleteClient(1L);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Se eliminó el registro del cliente.", response.getBody());
    }

    @Test
    void testDeleteClient_NotFound() {
        doThrow(new RuntimeException()).when(serviceClient).deleteClient(1L);

        ResponseEntity<String> response = clientController.deleteClient(1L);

        assertEquals(400, response.getStatusCodeValue());
        assertEquals("Cliente no encontrado.", response.getBody());
    }

    @Test
    void testPutClient_Success() {
        when(serviceClient.getClientById(1L)).thenReturn(client);

        Client updatedClient = new Client();
        updatedClient.setPassword("newPass");
        updatedClient.setEstate(false);

        ResponseEntity<String> response = clientController.putClient(1L, updatedClient);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Se actualizó el registro del cliente.", response.getBody());
        verify(serviceClient).putClient(1L, updatedClient);
    }

    @Test
    void testPutClient_EmptyPassword() {
        Client updatedClient = new Client();
        updatedClient.setPassword("   ");
        updatedClient.setEstate(true);

        when(serviceClient.getClientById(1L)).thenReturn(client);

        ResponseEntity<String> response = clientController.putClient(1L, updatedClient);

        assertEquals(400, response.getStatusCodeValue());
        assertEquals("La contraseña no puede estar vacía.", response.getBody());
    }

    @Test
    void testPutClient_NotFound() {
        when(serviceClient.getClientById(1L)).thenThrow(new RuntimeException());

        ResponseEntity<String> response = clientController.putClient(1L, client);

        assertEquals(400, response.getStatusCodeValue());
        assertEquals("Cliente no encontrado.", response.getBody());
    }

    @Test
    void testGetClientById_Success() {
        when(serviceClient.getClientById(1L)).thenReturn(client);

        ResponseEntity<?> response = clientController.getClientById(1L);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(client, response.getBody());
    }

    @Test
    void testGetClientById_NotFound() {
        when(serviceClient.getClientById(1L)).thenThrow(new RuntimeException());

        ResponseEntity<?> response = clientController.getClientById(1L);

        assertEquals(400, response.getStatusCodeValue());
        assertEquals("Cliente no encontrado.", response.getBody());
    }
}
