package ca.ucalgary.cpsc.ase.common.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the Control database table.
 * 
 */
@Entity
@Table(name="control")
public class Control implements Serializable, CodeEntity {
	private static final long serialVersionUID = 1L;

//	@Version
//	private Integer version;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String type;

	//bi-directional many-to-one association to ControlFlow
	@OneToMany(mappedBy="control")
	private Set<ControlFlow> controlFlows;

    public Control() {
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

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

//	public Set<ControlFlow> getControlFlows() {
//		return this.controlFlows;
//	}
//
//	public void setControlFlows(Set<ControlFlow> controlFlows) {
//		this.controlFlows = controlFlows;
//	}
	
}