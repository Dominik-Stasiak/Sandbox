package pl.dstasiak.fs1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dstasiak.fs1.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
