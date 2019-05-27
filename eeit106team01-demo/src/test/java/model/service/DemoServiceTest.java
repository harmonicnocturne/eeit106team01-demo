package model.service;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import model.entity.Demo;
import net.ddns.eeitdemo.eeit106team01.Eeit106team01Application;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Eeit106team01Application.class)
@ActiveProfiles("test")
public class DemoServiceTest {

	@Autowired
	DemoService service;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsert() {
		Demo demo = new Demo();
		demo.setDemo("test03");
		service.insert(demo);
	}
	
	@Test
	public void testUpdate() {
		Demo demo = new Demo();
		demo.setId(1);
		demo.setDemo("dome");
		service.update(demo);
		System.out.println(demo);
	}

}
