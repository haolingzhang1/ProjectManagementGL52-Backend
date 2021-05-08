package fr.utbm.gl52.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.mapping.PrimaryKey;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Data
@Entity
@Table(name = "PROJECT")
@DynamicUpdate
public class ProjectEntity implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROJECT_ID", nullable = false)
    private Long projectId;

    @Column(name = "PROJECT_TITLE")
    private String projectTitle;

    @Column(name = "PROJECT_GRADE")
    private Long projectGrade;

    @Column(name = "PROJECT_COMMENTS")
    private String projectComments;

    @Column(name = "SUBJECT_ID")
    private Long subjectId;

    @Column(name = "SUPERVISOR_ID")
    private Long supervisorId;

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public Long getProjectGrade() {
        return projectGrade;
    }

    public void setProjectGrade(Long projectGrade) {
        this.projectGrade = projectGrade;
    }

    public String getProjectComments() {
        return projectComments;
    }

    public void setProjectComments(String projectComments) {
        this.projectComments = projectComments;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public Long getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(Long supervisorId) {
        this.supervisorId = supervisorId;
    }

//    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
//    @JoinColumn(name="SUPERVISOR_ID")//only when the user type is teacher
//    private UserEntity supervisor;
//
//
//    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
//    @JoinColumn(name="SUBJECT_ID")
//    private SubjectEntity subject;
//
//    @OneToMany(mappedBy = "meetingId",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
//    private List<MeetingEntity> meetingList;
//
//    @OneToMany(mappedBy = "documentId",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
//    private List<DocumentEntity> documentList;

//    @Override
//    public String toString() {
//        return "project id is: "+projectId+"title: "+projectTitle;
//    }
    }
