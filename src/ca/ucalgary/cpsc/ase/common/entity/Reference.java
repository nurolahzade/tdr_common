package ca.ucalgary.cpsc.ase.common.entity;

import javax.persistence.*;


/**
 * The persistent class for the Reference database table.
 * 
 */

@Entity
@Table(name="reference")
@NamedQueries({
		@NamedQuery(name="FindReference", query="SELECT r FROM Reference r " +
				"WHERE r.name = :name AND r.clazz = :clazz AND r.declaringClazz = :declaring AND r.testMethod = :method"),
		
		@NamedQuery(name="FindReferenceNullDeclaringClazz", query="SELECT r FROM Reference r " +
				"WHERE r.name = :name AND r.clazz = :clazz AND r.declaringClazz IS NULL AND r.testMethod = :method"),

		@NamedQuery(name="FindMatchingReferences", query="SELECT r " +
				"FROM TestMethod tm, IN(tm.references) r " +
				"WHERE tm.clazz.id = :id AND r.clazz.fqn IN :fqns")

})
public class Reference implements CodeEntity {
	private static final long serialVersionUID = 1L;

//	@Version
//	private Integer version;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String name;

	//bi-directional many-to-one association to Class
    @ManyToOne
	@JoinColumn(name="class_id")
	private Clazz clazz;
    
    //bi-directional many-to-one association to Class
    @ManyToOne
    @JoinColumn(name="declaring_class_id")
    private Clazz declaringClazz;

	//bi-directional many-to-one association to TestMethod
    @ManyToOne
	@JoinColumn(name="test_method_id")
	private TestMethod testMethod;

	@OneToOne(fetch=FetchType.LAZY)
	private Position position;    

	public Reference() {
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Clazz getClazz() {
		return this.clazz;
	}

	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}		
	
	public Clazz getDeclaringClazz() {
		return declaringClazz;
	}

	public void setDeclaringClazz(Clazz declaringClazz) {
		this.declaringClazz = declaringClazz;
	}

	public TestMethod getTestMethod() {
		return this.testMethod;
	}

	public void setTestMethod(TestMethod testMethod) {
		this.testMethod = testMethod;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return (declaringClazz != null ? declaringClazz.getFqn() + "." : "") + name + ":" + clazz.getFqn();
	}
	
}