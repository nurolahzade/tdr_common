package ca.ucalgary.cpsc.ase.common.entity;

import javax.persistence.*;

import java.util.Set;


/**
 * The persistent class for the Exception database table.
 * 
 */
@Entity
@Table(name="exception")
@NamedQueries({
	@NamedQuery(name="FindByClazz", query="SELECT e FROM Xception e WHERE e.clazz = :clazz")
})
public class Xception implements CodeEntity {
	private static final long serialVersionUID = 1L;

//	@Version
//	private Integer version;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	//uni-directional many-to-one association to Class
    @ManyToOne
	@JoinColumn(name="class_id")
	private Clazz clazz;

	//bi-directional many-to-many association to TestMethod
	@ManyToMany
	@JoinTable(
		name="TestMethod_has_Exception"
		, joinColumns={
			@JoinColumn(name="exception_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="test_method_id")
			}
		)
	private Set<TestMethod> testMethods;

    public Xception() {
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

	public Clazz getClazz() {
		return this.clazz;
	}

	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}
	
	public Set<TestMethod> getTestMethods() {
		return this.testMethods;
	}

	public void setTestMethods(Set<TestMethod> testMethods) {
		this.testMethods = testMethods;
	}
	
}