package gr.publicsoft.springbootcrud;

import gr.publicsoft.springbootcrud.model.Supplier;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SupplierTest {

    @Autowired
    TestRestTemplate restTemplate;

    private static final String suppliersPath = "/api/suppliers";

    @Test
    public void contextLoad() {

    }

    @Test
    public void testCreateSupplierAndGet() {

        Supplier supplier = new Supplier();
        supplier.setFirstName("jim");
        supplier.setLastName("morrison");
        supplier.setCompanyName("Empodio Life");
        supplier.setAddress("test");
        supplier.setCity("test");
        supplier.setCountry("test");
        supplier.setIrsOffice("test");
        supplier.setVatNumber("test");
        supplier.setIrsOffice("test");
        //Check if Supplier REST endpoints are exposed
        ResponseEntity response = restTemplate.getForEntity(suppliersPath, Object.class);
        System.out.println(response.getBody().toString());

        //Check if post Supplier is Posted
        response = restTemplate.postForEntity(suppliersPath, supplier, Supplier.class);
        Supplier created = (Supplier) response.getBody();
        System.out.println(created);
        assertEquals(201, response.getStatusCodeValue());

        //Check if posted Supplier entry is the same with the initial entry
        response = restTemplate.getForEntity(suppliersPath + "/" + created.getId(), Supplier.class);
        Supplier read = (Supplier) response.getBody();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(supplier.getFirstName(), read.getFirstName());
        assertEquals(supplier.getCompanyName(), read.getCompanyName());
    }

    @Test
    public void testDeleteSupplierAndCheckNullErroneousCase() {

        Supplier supplier = new Supplier();
        supplier.setFirstName("Solo");
        supplier.setLastName("Mun");
        supplier.setCompanyName("Empodio Life");
        supplier.setAddress("test");
        supplier.setCity("test");
        supplier.setCountry("test");
        supplier.setIrsOffice("test");
        supplier.setVatNumber("test");
        supplier.setIrsOffice("test");

        ResponseEntity response = restTemplate.getForEntity(suppliersPath, Object.class);
        response = restTemplate.postForEntity(suppliersPath, supplier, Supplier.class);

        Supplier created = (Supplier) response.getBody();
        System.out.println(created);
        assertEquals(201, response.getStatusCodeValue());
        restTemplate.delete(suppliersPath, created.getId());
        ResponseEntity<Supplier> deleteResponce = restTemplate.exchange(suppliersPath, HttpMethod.DELETE, HttpEntity.EMPTY,Supplier.class,created.getId());
        assertEquals(404, deleteResponce.getStatusCodeValue());
    }
}