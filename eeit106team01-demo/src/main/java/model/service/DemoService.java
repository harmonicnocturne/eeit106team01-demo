package model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.dao.DemoDao;
import model.entity.Demo;

@Service
@Transactional(rollbackFor = Exception.class)
public class DemoService {
	
	@Autowired
	DemoDao dao;
	
	public Demo select(Demo demo) {
		return dao.select(demo);
	}
	
	public Demo update(Demo demo) {
		return dao.update(demo);
	}
	
	public Demo insert(Demo demo) {
		return dao.insert(demo);
	}
	
	public Demo delete(Demo demo) {
		return dao.delete(demo);
	}
}
