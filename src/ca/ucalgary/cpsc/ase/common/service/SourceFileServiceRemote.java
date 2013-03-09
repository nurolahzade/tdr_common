package ca.ucalgary.cpsc.ase.common.service;

import javax.ejb.Remote;

import ca.ucalgary.cpsc.ase.common.entity.Project;
import ca.ucalgary.cpsc.ase.common.entity.SourceFile;

@Remote
public interface SourceFileServiceRemote {

	public SourceFile create(Project project, String path);

}
