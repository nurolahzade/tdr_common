package ca.ucalgary.cpsc.ase.common.entity;

import javax.persistence.*;

import java.util.Set;


/**
 * The persistent class for the SourceFile database table.
 * 
 */
@Entity
@Table(name="sourcefile")
	
public class SourceFile implements CodeEntity {
	private static final long serialVersionUID = 1L;

//	@Version
//	private Integer version;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	//bi-directional many-to-one association to Class
	@OneToMany(mappedBy="sourceFile")
	private Set<Clazz> clazzs;

	//bi-directional many-to-one association to Project
    @ManyToOne(fetch=FetchType.LAZY)
	private Project project;
    
    
    @Column(name="path")
	private String path;

    public SourceFile() {
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

	public Set<Clazz> getClazzs() {
		return this.clazzs;
	}

	public void setClazzs(Set<Clazz> clazzs) {
		this.clazzs = clazzs;
	}
	
	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
		
}