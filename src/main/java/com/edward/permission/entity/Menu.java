package com.edward.permission.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "menu")
public class Menu implements Serializable {

	private static final long serialVersionUID = -5763803724270587247L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "menu_id")
	@Getter @Setter
	private Long menuId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id")
	@Getter @Setter
	private Role role;
	
	@NotNull
	@Column(name = "detail")
	@Getter @Setter
	private String detail;
	
	@Override
	public int hashCode() {
		return 0;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (null == obj) return false;
		if (this.getClass() != obj.getClass()) return false;
		final Menu menu = (Menu) obj;
		return this.menuId.longValue() == menu.getMenuId().longValue();
	}
	
}
