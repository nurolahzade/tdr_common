package ca.ucalgary.cpsc.ase.common.entity;

import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the MethodInvocation database table.
 * 
 */
@Entity
@Table(name="MethodInvocation")
@NamedQueries({
	@NamedQuery(name="MethodToMethodDataFlowPath", 
			query="SELECT DISTINCT f.testMethod.clazz FROM MethodInvocation f, IN(f.flowsTo) t WHERE f.method.id IN :list1 AND t.method.id IN :list2"),
	@NamedQuery(name="MethodToAssertionDataFlowPath", 
			query="SELECT DISTINCT f.testMethod.clazz FROM MethodInvocation f, IN(f.flowsTo) t WHERE f.method.id IN :list AND t.assertion = :assertion")
})
public class MethodInvocation implements CodeEntity {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	//bi-directional many-to-one association to ControlFlow
	@ManyToOne
	@JoinColumn(name="control_flow_id")
	private ControlFlow controlFlow;

	//bi-directional many-to-one association to self
	@ManyToMany(mappedBy="flowsTo")
	private Set<MethodInvocation> flowsFrom;

	//bi-directional many-to-one association to self
	@ManyToMany
	@JoinTable(name="DataFlow",
			joinColumns={@JoinColumn(name="from_method_invocation_id")},
			inverseJoinColumns={@JoinColumn(name="to_method_invocation_id")}
	) 
	private Set<MethodInvocation> flowsTo;

	//bi-directional many-to-one association to TestMethod
    @ManyToOne
	@JoinColumn(name="test_method_id")
	private TestMethod testMethod;

	//bi-directional many-to-one association to Method
    @ManyToOne
	private Method method;

	//bi-directional many-to-one association to Position
    @ManyToOne
	private Position position;

	//bi-directional many-to-one association to Assertion
    @ManyToOne
	private Assertion assertion;

    public MethodInvocation() {
    }

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ControlFlow getControlFlow() {
		return this.controlFlow;
	}

	public void setControlFlow(ControlFlow controlFlow) {
		this.controlFlow = controlFlow;
	}
	
	public Set<MethodInvocation> getDataFlowsFrom() {
		return this.flowsFrom;
	}

	public void setDataFlowsFrom(Set<MethodInvocation> dataFlows) {
		this.flowsFrom = dataFlows;
	}
	
	public Set<MethodInvocation> getDataFlowsTo() {
		return this.flowsTo;
	}

	public void setDataflowssTo(Set<MethodInvocation> dataFlows) {
		this.flowsTo = dataFlows;
	}
	
	public TestMethod getTestmethod() {
		return this.testMethod;
	}

	public void setTestmethod(TestMethod testMethod) {
		this.testMethod = testMethod;
	}
	
	public Method getMethod() {
		return this.method;
	}

	public void setMethod(Method method) {
		this.method = method;
	}
	
	public Position getPosition() {
		return this.position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
	
	public Assertion getAssertion() {
		return this.assertion;
	}

	public void setAssertion(Assertion assertion) {
		this.assertion = assertion;
	}
	
}