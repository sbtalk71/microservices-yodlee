package com.demo.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.spring.entity.Emp;

public interface EmpRepository extends JpaRepository<Emp, Integer> {

	@Query(value = "insert into EMP values(?1,?2,?3,?4)",nativeQuery = true)
	public Emp saveEmp(int id,String name,String city,double sal);
}
