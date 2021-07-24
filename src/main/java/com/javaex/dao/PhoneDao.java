package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;

@Repository
public class PhoneDao {

	@Autowired
	private SqlSession sqlSession;

	// 전체리스트 가져오기
	public List<PersonVo> getPersonList() {
		System.out.println("[PhoneDao.getPersonList]");
		List<PersonVo> personList = sqlSession.selectList("phonebook.selectList");
		//System.out.println(personList);
		
		return personList;
	}
	
	// 저장
	public void personInsert(PersonVo personVo) {
		System.out.println("[PhoneDao.personInsert]");
		sqlSession.insert("phonebook.personInsert", personVo);
	}
	
	// 유저1명 가져오기
	public PersonVo getPersonListOne(PersonVo personVo) {
		System.out.println("[PhoneDao.getPersonListOne]");
		PersonVo personListOne = sqlSession.selectOne("phonebook.selectListOne", personVo);
		
		
		return personListOne;
	}
	
	// 수정
	public void personUpdate(PersonVo personVo) {
		System.out.println("[PhoneDao.personUpdate]");
		sqlSession.update("phonebook.personUpdate", personVo);
	}
	
	// 삭제
	public void personDelete(PersonVo personVo) {
		System.out.println("[PhoneDao.personDelete]");
		sqlSession.delete("phonebook.personDelete", personVo);
	}

}
