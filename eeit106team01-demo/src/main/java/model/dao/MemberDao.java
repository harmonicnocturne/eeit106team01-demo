package model.dao;

import model.entity.Member;

public interface MemberDao {
	
	public Member insert(Member member);
	public Member delete(Member member);
	public Member update(Member member);
	public Member select(Member member);
	
}
