package model.dao;



//import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.FatalBeanException;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import config.test.TestSpringCallBackConfiguration;
import model.entity.Member;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestSpringCallBackConfiguration.class)
@ActiveProfiles("test")
public class MemberDaoImpTest {
	
	@Autowired
	MemberDao memberDao;
	
	private Member member;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}
	
	@Before
	public void setUp() throws Exception {
		member = new Member();
	}
	
	@After
	public void tearDown() throws Exception {
		member = null;
	}
	
	@Test(expected = IllegalArgumentException.class)
	@Transactional
	@Rollback(false)
	public void insertNull(){
		memberDao.insert(null);
	}
	
	@Test()
	@Transactional
	@Rollback(false)
	public void insertWithId() {
		Member member = new Member();
		Long id = 111L;
		member.setId(id);
		member.setEmail("email");
		member.setUsername("username");
		member.setPassword("password");
		Member result = memberDao.insert(member);
		System.out.println("member: "+member.getId());
		assertEquals(member.getId(), result.getId());
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void insertSuccess() {
		Member member = new Member();
		member.setEmail("email");
		member.setUsername("username");
		member.setPassword("password");
		memberDao.insert(member);
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void insertExist() {
		Member member = new Member();
		try {
			member.setId(8L);
			member.setEmail("ggggg");
			member.setUsername("ggggg");
			member.setPassword("ggggg");
			memberDao.insert(member);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			System.out.println("insertExist memeber: "+member);
		}
	}

	@Test
	@Transactional
	@Rollback(false)
	public void selectNotFound() {
		member.setId(0L);
		Member result = memberDao.select(member);
		assertNull(result);
	}
	
	@Test(expected = NullPointerException.class)
	@Transactional
	@Rollback(false)
	public void selectNull() {
		member = null;
		Member result = memberDao.select(member);
		assertNull(result);
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void selectExists() {
		member.setId(8L);
		Member result = memberDao.select(member);
		assertNotNull(result);
	}
	
	@Test(expected = NullPointerException.class)
	@Transactional
	@Rollback(false)
	public void updateNull() {
		member =null;
		memberDao.update(member);
	}
	
	@Test(expected = FatalBeanException.class)
	@Transactional
	@Rollback(false)
	public void updateNotFound() {
		member.setId(113L);
		member.setPassword("ooooo");
		memberDao.update(member);
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void updateExists() {
		member.setId(10L);
		member.setPassword("ooooo");
		memberDao.update(member);
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void deleteNotFound() {
		member.setId(113L);
		memberDao.delete(member);
	}
	
	@Test(expected = IllegalArgumentException.class)
	@Transactional
	@Rollback(false)
	public void deleteNull() {
		member = null;
		memberDao.delete(member);
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void deleteExists() {
		member.setId(8L);
		Member result = memberDao.delete(member);
		assertNotNull(result);
	}
}
