package ca.ucalgary.cpsc.ase.common.entity;

import javax.persistence.*;

//import java.util.Set;


/**
 * The persistent class for the Assertion database table.
 * 
 */
@Entity
@Table(name="assertion")
@NamedQueries({
	@NamedQuery(name="findByType", query="SELECT a FROM Assertion a " +
			"WHERE a.type = :type"),
	
	@NamedQuery(name="FindMatchingAssertions", query="SELECT DISTINCT i.assertion " +
			"FROM TestMethod tm, IN(tm.invocations) i " +
			"WHERE tm.clazz.id = :id AND i.assertion.id IN :list")
})

public class Assertion implements CodeEntity, Invocation {
	private static final long serialVersionUID = 1L;

//	@Version
//	private Integer version;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Enumerated(EnumType.STRING)
	private AssertionType type;

//	//bi-directional one-to-many association to TestMethodHasAssertion
//	@OneToMany(mappedBy="assertion")
//	private Set<TestMethodHasAssertion> testMethods;
	
    public Assertion() {
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

	public AssertionType getType() {
		return type;
	}

	public void setType(AssertionType type) {
		this.type = type;
	}
	
//	public Set<TestMethodHasAssertion> getTestMethods() {
//		return this.testMethods;
//	}
//
//	public void setTestMethods(Set<TestMethodHasAssertion> testMethods) {
//		this.testMethods = testMethods;
//	}

	@Override
	public String toString() {
		return type.getName();
	}	
	
}