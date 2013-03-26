package ca.ucalgary.cpsc.ase.common.entity;

import javax.persistence.*;


/**
 * The persistent class for the RepositoryFile database table.
 * 
 */
@Entity
@Table(name="RepositoryFile")
@NamedQuery(name="FindRepositoryFileByState", query="SELECT rf FROM RepositoryFile rf WHERE rf.state = :state")

public class RepositoryFile implements CodeEntity {
	private static final long serialVersionUID = 1L;

//	@Version
//	private Integer version;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String path;

    @Enumerated(EnumType.ORDINAL)	
	private VisitState state;

    public RepositoryFile() {
    }

//    public Integer getVersion() {
//    	return this.version;
//    }

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public VisitState getState() {
		return this.state;
	}

	public void setState(VisitState state) {
		this.state = state;
	}
	
}