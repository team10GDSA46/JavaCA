package edu.iss.ca.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.iss.ca.models.Role;
import edu.iss.ca.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Resource
	private RoleRepository roleRepository;

	@Override
	@Transactional
	public ArrayList<Role> findAllRoles() {
		ArrayList<Role> ul = (ArrayList<Role>) roleRepository.findAll();
		return ul;
	}

	@Override
	@Transactional
	public Role findRole(String roleId) {
		return roleRepository.findOne(roleId);
	}

	@Override
	@Transactional
	public Role createRole(Role role) {
		return roleRepository.saveAndFlush(role);
	}

	@Override
	@Transactional
	public Role changeRole(Role role) {
		return roleRepository.saveAndFlush(role);
	}

	@Override
	@Transactional
	public void removeRole(Role role) {
		roleRepository.delete(role);
		
	}

	@Override
	@Transactional
	public ArrayList<String> findAllRolesNames() {
		return roleRepository.findAllRolesNames();
	}

	@Override
	@Transactional
	public ArrayList<Role> findRoleByName(String name) {
		return roleRepository.findRoleByName(name);
	}

	

}
