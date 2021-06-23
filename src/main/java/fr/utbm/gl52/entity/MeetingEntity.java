package fr.utbm.gl52.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.mapping.PrimaryKey;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Data
@Entity
@Table(name = "MEETING")
public class MeetingEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEETING_ID", nullable = false)
    private Long meetingId;

    @Column(name = "MEETING_START", nullable = false)
    private Date meetingStart ;

    @Column(name = "MEETING_END", nullable = false)
    private Date meetingEnd ;

    @Column(name = "PROJECT_ID")
    private Long projectId;

    @Column(name = "SUPERVISOR_ID")
    private Long supervisorId;

    public Long getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(Long supervisorId) {
        this.supervisorId = supervisorId;
    }

    public Long getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(Long meetingId) {
        this.meetingId = meetingId;
    }

    public Date getMeetingStart() {
        return meetingStart;
    }

    public void setMeetingStart(Date meetingStart) {
        this.meetingStart = meetingStart;
    }

    public Date getMeetingEnd() {
        return meetingEnd;
    }

    public void setMeetingEnd(Date meetingEnd) {
        this.meetingEnd = meetingEnd;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

//
//    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
//    @JoinColumn(name="PROJECT_ID")
//    private ProjectEntity project;
//
//    @Override
//    public String toString(){
//        return "meeting starts at: "+meetingStart+" end at: "+meetingEnd;
//    }
}
