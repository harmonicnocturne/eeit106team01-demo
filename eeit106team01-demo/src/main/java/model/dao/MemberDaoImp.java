package model.dao;

import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.entity.Member;

@Repository
public class MemberDaoImp implements MemberDao {

	@Override
	public Member getById(Long id) {
		return getSession().get(Member.class, id);
	}

	@Override
	public Collection<Member> findByBean(Member bean) {
		
		
		return null;
	}


	@Override
	public Member findAnUnique(Member bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteByIdList(Collection<Long> ids) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertMany(Collection<Member> beans) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Member updateNotNull(Member bean) {
		return null;
	}


	@Override
	public Member saveIgnoreId(Member bean) {
		return null;
	}

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
