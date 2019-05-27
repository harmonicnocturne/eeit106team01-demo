package model.dao;

import java.util.Objects;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.entity.Demo;

@Repository
public class DemoDao {
	
	@Autowired
	SessionFactory factory;
	
	public Demo select(Demo demo) {
		return factory.getCurrentSession().get(Demo.class,demo.getId());
	}
	
	public Demo update(Demo demo) {
		Demo temp = factory.getCurrentSession().load(Demo.class, demo.getId());
		if(Objects.equals(demo.getDemo(), null)) {
			demo.setDemo(temp.getDemo());
		}
		factory.getCurrentSession().update(demo);
		return demo;
	}
	
	public Demo delete(Demo demo) {
		factory.getCurrentSession().delete(demo);
		return demo;
	}
	
	public Demo insert(Demo demo) {
		factory.getCurrentSession().save(demo);
		return demo;
		
	}
}
