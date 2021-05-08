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
@Table(name = "MEEETING")
public class MeetingEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEETING_ID", nullable = false)
    private Long meetingId;

    @Column(name = "MEETING_START", nullable = false)
    private Date meetingStart ;

    @Column(name = "MEETING_END", nullable = false)
    private Date meetingEnd ;

    @Column(name = "PROJECT_ID", nullable = false)
    private Long projectId;


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
