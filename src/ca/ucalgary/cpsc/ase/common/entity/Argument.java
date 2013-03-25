package ca.ucalgary.cpsc.ase.common.entity;

import javax.persistence.*;


/**
 * The persistent class for the Argument database table.
 * 
 */
@Entity
@Table(name="Argument")
public class Argument implements CodeEntity {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne(fetch=FetchType.LAZY)
	private Method method;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="class_id")
	private Clazz clazz;
	
	@Column(name="_order")
	private Integer order;
	
    public Argument() {
    }

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Method getMethod() {
		return method;
	}

	public void setMethod(Method method) {
		this.method = method;
	}

	public Clazz getClazz() {
		return clazz;
	}

	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return clazz.getFqn();
	}	
		
}