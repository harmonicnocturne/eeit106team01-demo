package model.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.entity.Member;

@Repository
public class MemberDaoImp implements MemberDao {

	@Autowired
	SessionFactory factory;
	
	@Autowired
	DaoUtils daoUtils;
	
	private Session getSession() {
		return factory.getCurrentSession();
	}
	
	
	@Override
	public Member insert(Member member){
		getSession().save(member);
		return member;
	}

	@Override
	public Member delete(Member member) {
		getSession().remove(member);
		return member;
	}

	@Override
	public Member update(Member member) {
		Member temp = getSession().load(member.getClass(), member.getId());
		daoUtils.notNullCopyProperties(member,temp);
		return temp;
	}

	@Override
	public Member select(Member member) {
		return getSession().get(member.getClass(), member.getId());
	}

}
