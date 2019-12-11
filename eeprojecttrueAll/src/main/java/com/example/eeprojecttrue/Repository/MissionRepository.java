package com.example.eeprojecttrue.Repository;

import com.example.eeprojecttrue.Entity.Mission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MissionRepository extends CrudRepository<Mission,Integer> {
    //CrudRepository
    Mission findByMid(int mid);
    List<Mission> findByGid(int gid);
    List<Mission> findByRid(int rid);
    List<Mission> findAll();
    Page<Mission> findAll(Pageable pageable);//这里实现分页的
}
