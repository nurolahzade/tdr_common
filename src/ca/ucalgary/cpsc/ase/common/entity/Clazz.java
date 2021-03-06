package ca.ucalgary.cpsc.ase.common.entity;

import javax.persistence.*;

import java.util.Set;


/**
 * The persistent class for the Class database table.
 * 
 */
@Entity
@Table(name="class")
@NamedQueries({
	@NamedQuery(name="findByFQN", query="SELECT c FROM Clazz c WHERE c.fqn = :fqn"),
	
	@NamedQuery(name="MatchReference", query="SELECT c, COUNT(DISTINCT r.clazz) " +
			"FROM Clazz c, TestMethod tm, IN(tm.references) r " +
			"WHERE c.type IN :types AND tm.clazz = c AND r.clazz.fqn IN :fqns " +
			"GROUP BY c " +
			"ORDER BY COUNT(DISTINCT r.clazz) DESC"),
			
	@NamedQuery(name="MatchSimpleCall", query="SELECT c, COUNT(DISTINCT i.method) " +
			"FROM Clazz c, TestMethod tm, IN(tm.invocations) i " +
			"WHERE c.type IN :types AND tm.clazz = c AND i.method.id IN :list " +
			"GROUP BY c " +
			"ORDER BY COUNT(DISTINCT i.method) DESC"),
			
	@NamedQuery(name="TotalMethodsInTestClass", query="SELECT COUNT(DISTINCT i) " +
			"FROM TestMethod tm, IN(tm.invocations) i " +
			"WHERE tm.clazz = :clazz"),
			
	@NamedQuery(name="MatchAssertion", query="SELECT c, COUNT(DISTINCT i.assertion) " +
			"FROM Clazz c, TestMethod tm, IN(tm.invocations) i " +
			"WHERE c.type IN :types AND tm.clazz = c AND i.assertion.id IN :list " +
			"GROUP BY c " +
			"ORDER BY COUNT(DISTINCT i.assertion) DESC")//,
			
//	@NamedQuery(name="MatchAssertionParameter", query="SELECT aom.testMethod.clazz, COUNT(DISTINCT aom.method) " +
//			"FROM AssertionOnMethod aom " +
//			"WHERE aom.testMethod.clazz.type IN :types AND aom.method.id IN :list " +
//			"GROUP BY aom.testMethod.clazz " +
//			"ORDER BY COUNT(DISTINCT aom.method) DESC")
})
			
public class Clazz implements CodeEntity {
	private static final long serialVersionUID = 1L;

//	@Version
//	private Integer version;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="class_name")
	private String className;

	private String fqn;

	//bi-directional many-to-one association to Package
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="package_id")
    private Pakage pakage;

	//bi-directional many-to-one association to SourceFile
    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="source_file_id")
	private SourceFile sourceFile;
    
    @Column(name="type")
    @Enumerated(EnumType.ORDINAL)
    private ObjectType type;

	//bi-directional many-to-one association to Method
	@OneToMany(mappedBy="clazz")
	private Set<Method> methods;

	//bi-directional many-to-one association to TestMethod
	@OneToMany(mappedBy="clazz")
	private Set<TestMethod> testMethods;

    public Clazz() {
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

	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getFqn() {
		return this.fqn;
	}

	public void setFqn(String fqn) {
		this.fqn = fqn;
	}

	public SourceFile getSourceFile() {
		return this.sourceFile;
	}

	public void setSourceFile(SourceFile sourceFile) {
		this.sourceFile = sourceFile;
	}		
	
	public Pakage getPackage() {
		return pakage;
	}

	public void setPackage(Pakage pakage) {
		this.pakage = pakage;
	}

	public ObjectType getType() {
		return type;
	}

	public void setType(ObjectType type) {
		this.type = type;
	}

	public Set<Method> getMethods() {
		return this.methods;
	}

	public void setMethods(Set<Method> methods) {
		this.methods = methods;
	}
	
	public Set<TestMethod> getTestMethods() {
		return this.testMethods;
	}

	public void setTestMethods(Set<TestMethod> testMethods) {
		this.testMethods = testMethods;
	}
	
}
