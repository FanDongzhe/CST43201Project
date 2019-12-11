package com.example.eeprojecttrue.Service.Cluster;

import com.example.eeprojecttrue.Entity.Mission;
import com.example.eeprojecttrue.Repository.MissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissionService {
    @Autowired
    MissionRepository missionRepository;

    public boolean Save(Mission mission)//这里是将任务存到数据库中
    {
        this.missionRepository.save(mission);//
        return true;
    }
    //查询对应的所有的任务
    public Mission findByM_id(int mid)
    {
        return this.missionRepository.findByMid(mid);
    }
    public List<Mission> findByGid(int gid)
    {
        return this.missionRepository.findByGid(gid);
    }
    public List<Mission> findByRid(int rid)
    {
        return this.missionRepository.findByRid(rid);
    }
    public List<Mission> findAll()
    {
        return this.missionRepository.findAll();
    }
    //按照发布人id查询==============
    public List<Mission> findMyPublishMission(int gid)
    {
        return this.findByGid(gid);
    }
    //按照接受人id查询==============
    public List<Mission> findMySolveMission(int rid)
    {
        return this.findByRid(rid);
    }

    public Page<Mission> findByPage(Integer page)
    {
        if(page==null)
        {
            page=0;//查询最后一页
        }
        Integer pagesize=4;
        //这里是说的是
        PageRequest pageable = PageRequest.of(page, pagesize, Sort.Direction.ASC, "mid");
        return missionRepository.findAll(pageable);
    }
}