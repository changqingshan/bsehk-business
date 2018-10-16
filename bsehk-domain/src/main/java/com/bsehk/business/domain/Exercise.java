package com.bsehk.business.domain;

import java.util.Date;

public class Exercise {
    private Long id;

    private Long coachId;

    private Long venueId;

    private String exerciseName;

    private Byte week;

    private Date exerciseStart;

    private Date exercieseEnd;

    private Date gmtCreate;

    private Date gmtModified;

    private Byte isDelete;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCoachId() {
        return coachId;
    }

    public void setCoachId(Long coachId) {
        this.coachId = coachId;
    }

    public Long getVenueId() {
        return venueId;
    }

    public void setVenueId(Long venueId) {
        this.venueId = venueId;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public Byte getWeek() {
        return week;
    }

    public void setWeek(Byte week) {
        this.week = week;
    }

    public Date getExerciseStart() {
        return exerciseStart;
    }

    public void setExerciseStart(Date exerciseStart) {
        this.exerciseStart = exerciseStart;
    }

    public Date getExercieseEnd() {
        return exercieseEnd;
    }

    public void setExercieseEnd(Date exercieseEnd) {
        this.exercieseEnd = exercieseEnd;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }
}