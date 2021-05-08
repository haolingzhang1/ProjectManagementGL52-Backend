package fr.utbm.gl52.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.mapping.PrimaryKey;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "PROJECT")
@IdClass(PrimaryKeyMeetingClass.class)
@EqualsAndHashCode(callSuper = true)
@DynamicUpdate
public class ProjectEntity implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROJECT_ID", nullable = false)
    private Long projectId;

    @Column(name = "PROJECT_TITLE", nullable = false)
    private String projectTitle;

    @Column(name = "PROJECT_GRADE", nullable = false)
    private Long projectGrade;

    @Column(name = "PROJECT_COMMENTS", nullable = false)
    private String projectComments;

    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name="SUPERVISOR_ID")//only when the user type is teacher
    private UserEntity supervisor;


    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
    @JoinColumn(name="SUBJECT_ID")
    private SubjectEntity subject;

    @OneToMany(mappedBy = "MEETING",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<MeetingEntity> meetingList;

    @OneToMany(mappedBy = "DOCUMENT",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<DocumentEntity> documentList;

    @Override
    public String toString() {
        return "project id is: "+projectId+"title: "+projectTitle;
    }
}
