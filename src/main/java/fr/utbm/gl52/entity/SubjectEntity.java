package fr.utbm.gl52.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

public class SubjectEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SUBJECT_ID", nullable = false)
    private Long subjectId;

    @Column(name = "SUBJECT_NAME", nullable = false)
    private String subjectName;

    @Column(name = "SUBJECT_DESCRIPTION", nullable = false)
    private String subjectDescription;


    @OneToMany(mappedBy = "PROJECT",cascade= CascadeType.ALL,fetch= FetchType.LAZY)
    private List<ProjectEntity> projectList;

}
