package fr.utbm.gl52.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.mapping.PrimaryKey;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "MEEETING")
@IdClass(PrimaryKeyMeetingClass.class)
@EqualsAndHashCode(callSuper = true)
@DynamicUpdate
public class MeetingEntity implements Serializable {

    @Id
    @Column(name = "MEETING_START", nullable = false)
    private Date meetingStart ;

    @Id
    @Column(name = "MEETING_END", nullable = false)
    private Date meetingEnd ;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name="PROJECT_ID")
    private ProjectEntity project;

    @Override
    public String toString(){
        return "meeting starts at: "+meetingStart+" end at: "+meetingEnd;
    }
}
