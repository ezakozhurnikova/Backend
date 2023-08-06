package de.ait.timepad.repositories;


import de.ait.timepad.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TasksRepository extends JpaRepository<Task, Long> {

//    List<Task> findAllByDate(Integer year, Integer month, Integer day);
}
