package fr.utbm.gl52.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Data
@Entity
@Table(name = "DOCUMENT")
//@EqualsAndHashCode(callSuper = true)
@DynamicUpdate
@DynamicInsert
@EntityListeners(AuditingEntityListener.class)
public class DocumentEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DOCUMENT_ID", nullable = false)
    private Long documentId;

    @Column(name = "DOCUEMENT_TITLE", nullable = false)
    private String documentTitle;

    @Column(name = "DOCUMENT_TYPE")
    private String documentType;

    @Column(name = "DOCUMENT_CONTENT")
    private byte[] documentContent;

    @CreatedDate
    @Column(name = "DOCUMENT_CREATION", nullable = false)
    private Date documentCreation;

    @LastModifiedDate
    @Column(name = "DOCUMENT_MODIFICATION", nullable = false)
    private Date documentModification;

    @Column(name = "PROJECT_ID", nullable = false)
    private Long projectId;

    public DocumentEntity(String documentTitle, byte[] documentContent,Long projectId) {
        this.documentTitle = documentTitle;
        this.documentContent = documentContent;
        this.projectId = projectId;
    }

    public Long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }

    public String getDocumentTitle() {
        return documentTitle;
    }

    public void setDocumentTitle(String documentTitle) {
        this.documentTitle = documentTitle;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public byte[] getDocumentContent() {
        return documentContent;
    }

    public void setDocumentContent(byte[] documentContent) {
        this.documentContent = documentContent;
    }

    public Date getDocumentCreation() {
        return documentCreation;
    }

    public void setDocumentCreation(Date documentCreation) {
        this.documentCreation = documentCreation;
    }

    public Date getDocumentModification() {
        return documentModification;
    }

    public void setDocumentModification(Date documentModification) {
        this.documentModification = documentModification;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
//    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},optional=false)
//    @JoinColumn(name="PROJECT_ID")
//    private ProjectEntity project;
//
//    @Override
//    public String toString(){
//        return "document id is : "+documentId+" title:"+documentTitle+" type: "+documentType
//                +" create at: "+documentCreation+" modify at :"+documentModification;
//    }

}
