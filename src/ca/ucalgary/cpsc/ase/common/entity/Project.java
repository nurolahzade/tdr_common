package ca.ucalgary.cpsc.ase.common.entity;

import javax.persistence.*;

import java.util.Set;


/**
 * The persistent class for the Project database table.
 * 
 */
@Entity
@Table(name="Project")

public class Project implements CodeEntity {
	private static final long serialVersionUID = 1L;

//	@Version
//	private Integer version;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	//bi-directional many-to-one association to SourceFile
	@OneToMany(mappedBy="project")
	private Set<SourceFile> sourceFiles;

	@Column(name="name")
	String name;
	
    public Project() {
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

	public Set<SourceFile> getSourceFiles() {
		return this.sourceFiles;
	}

	public void setSourceFiles(Set<SourceFile> sourceFiles) {
		this.sourceFiles = sourceFiles;
	}		
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.getClass().getName() + "[id=" + id + "]";
	}
		
	
}