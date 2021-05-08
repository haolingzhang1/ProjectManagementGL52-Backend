package fr.utbm.gl52.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Data
@Entity
@Table(name = "SUBJECT")
public class SubjectEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SUBJECT_ID", nullable = false)
    private Long subjectId;

    @Column(name = "SUBJECT_NAME", nullable = false)
    private String subjectName;

    @Column(name = "SUBJECT_DESCRIPTION", nullable = false)
    private String subjectDescription;



//    @OneToMany(mappedBy = "projectId",cascade= CascadeType.ALL,fetch= FetchType.LAZY)
//    private List<ProjectEntity> projectList;
//
//    @Override
//    public String toString(){
//        return "subject id is: "+subjectId+" name is: "+subjectName+" description: "+subjectDescription;
//    }
}
