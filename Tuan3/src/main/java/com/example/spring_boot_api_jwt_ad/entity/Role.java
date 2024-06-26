package com.example.spring_boot_api_jwt_ad.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "t_role")
@Getter
@Setter
public class Role extends BaseEntity {

	    private String roleName;
	
	    public Role(Long id, String deleted, Date createdAt, Date updatedAt, Long createdBy, Long updatedBy,
				String roleName, String roleKey, Set<Permission> permissions) {
			super(id, deleted, createdAt, updatedAt, createdBy, updatedBy);
			this.roleName = roleName;
			this.roleKey = roleKey;
			this.permissions = permissions;
		}

		public Role() {
			super();
			// TODO Auto-generated constructor stub
		}
	
		public Role(Long id, String deleted, Date createdAt, Date updatedAt, Long createdBy, Long updatedBy) {
			super(id, deleted, createdAt, updatedAt, createdBy, updatedBy);
			// TODO Auto-generated constructor stub
		}
	
		public String getRoleName() {
			return roleName;
		}
	
		public void setRoleName(String roleName) {
			this.roleName = roleName;
		}
	
		public String getRoleKey() {
			return roleKey;
		}
	
		public void setRoleKey(String roleKey) {
			this.roleKey = roleKey;
		}
	
		public Set<Permission> getPermissions() {
			return permissions;
		}
	
		public void setPermissions(Set<Permission> permissions) {
			this.permissions = permissions;
		}
	
		private String roleKey;

    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinTable(name = "t_role_permission", joinColumns = {@JoinColumn(name = "role_id")}, inverseJoinColumns = {@JoinColumn(name = "permission_id")})
    private Set<Permission> permissions = new HashSet<>();
}
