package com.jw.demo.Repository;

import com.jw.demo.Model.Entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
repository를 사용하면 따로 쿼리문을 작성하지 않아도 기본적인
 //create, read(select), update, delete 사용 가능.
 */
@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> { //<entity, primary key 의 타입>


}
