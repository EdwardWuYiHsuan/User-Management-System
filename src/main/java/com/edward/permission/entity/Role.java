package com.edward.permission.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "role")
public class Role implements Serializable {

	private static final long serialVersionUID = -8311644940199065457L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "role_id")
	@Getter @Setter
	private Long roleId;
	
	@NotNull
	@Column(name = "name", unique = true)
	@Getter @Setter
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
	@Getter @Setter
	private Set<AccountRole> accountRole = new HashSet<AccountRole>(0);
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
	@Getter @Setter
	private Set<Menu> menus = new HashSet<>(0);
	
}
