package work.student_dashboard.backend.entity;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public abstract class UserDateAudit extends AuditModel {

	@CreatedBy
	@Column(name = "a_created_by", nullable = false, updatable = false)
	private Long acreatedBy;

	@LastModifiedBy
	@Column(name = "a_updated_by", nullable = false)
	private Long aupdatedBy;

	public Long getAcreatedBy() {
		return acreatedBy;
	}

	public void setAcreatedBy(Long acreatedBy) {
		this.acreatedBy = acreatedBy;
	}

	public Long getAupdatedBy() {
		return aupdatedBy;
	}

	public void setAupdatedBy(Long aupdatedBy) {
		this.aupdatedBy = aupdatedBy;
	}	
}
