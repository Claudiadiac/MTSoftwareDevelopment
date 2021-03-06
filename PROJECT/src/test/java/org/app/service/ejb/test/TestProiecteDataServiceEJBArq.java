package org.app.service.ejb.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import javax.ejb.EJB;

import org.app.service.ejb.ProiecteService;
import org.app.service.ejb.ProiecteServiceEJB;
import org.app.service.entities.Proiecte;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.logging.Logger;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

@RunWith(Arquillian.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestProiecteDataServiceEJBArq {
	private static Logger logger = Logger.getLogger(TestProiecteDataServiceEJBArq.class.getName());
	
	@EJB
	private static ProiecteService service;

	@Deployment
	public static Archive<?> createDeployment(){
		return ShrinkWrap
				.create(WebArchive.class, "SCRUM-S3-test.war")
				.addPackage(Proiecte.class.getPackage())
				.addClass(ProiecteService.class)
				.addClass(ProiecteServiceEJB.class)
				.addAsResource("META-INF/persistence.xml")
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}
	
	@Test
	public void test1_GetMessage(){
		logger.info("DEBUG: Junit TESTING: getMessage ...");
		String response = service.getMessage();
		assertNotNull("Data Service Failed!", response);
		logger.info("DEBUG: EJB Response ..." + response);
	}
	
	@Test
	public void test4_GetPoiecte(){
		logger.info("DEBUG: Junit ESTING: testGetProiecte ...");
		
		Collection<Proiecte> proiect = service.getProiect();
		assertTrue("Fail to read proiecte!", proiect.size() > 0);
	}
	
	@Test 
	public void test3_AddProiecte(){
		logger.info("DEBUG: Jnuit TESTING: testAddProiect ...");
		
//		Integer proiectToAdd = 3;
//		for(int i=1; i <= proiectToAdd; i++){
			service.addProiecte(new Proiecte(3000, "Modelling Data Base", 30, "Sandu Oana", null));
			service.addProiecte(new Proiecte(3001, "New Softaware Testing", 31, "Cazacu Alina", null));
			service.addProiecte(new Proiecte(3002, "Testing Interface for bugs", 32, "Onofrei George", null));
			service.addProiecte(new Proiecte(3003, "Develop the Application", 33, "Arsenei Andrei", null));
			service.addProiecte(new Proiecte(3004, "Testing Application", 34, "Cernea Ionut", null));
//		}
		Collection<Proiecte> proiect = service.getProiect();
//		assertTrue("Fail to add proiect!", proiect.size() == proiectToAdd);
	}
	
	@Test
	public void test2_DeleteProiect(){
		logger.info("DEBUG: Junit TESTING: testDeleteProiect ...");
		
		Collection<Proiecte> proiect = service.getProiect();
		for(Proiecte p: proiect)
			service.removeProiecte(p);
		Collection<Proiecte> proiectAfterDelete = service.getProiect();
		assertTrue("Fail to read proiecte!", proiectAfterDelete.size() == 0);
	}
}
