package com.example.eeprojecttrue.Entity;

import javax.persistence.*;

@Entity
@Table(name = "Mission")
public class Mission {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    //这里声明了主键的是m_id
    private Integer mid;
    private Integer gid;
    private Integer rid=0;
    private String comment;
    private String title;

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString()
    {
        return "Mission{" +
                "mid=" + mid +
                ", gid=" + gid +
                ", rid=" + rid +
                ", comment='" + comment + '\'' +
                ", title='" + title + '\'' +
                '}';
    }


}