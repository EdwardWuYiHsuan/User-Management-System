package com.edward.permission.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "account_role")
public class AccountRole implements Serializable {

	private static final long serialVersionUID = 444017419379757204L;

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_id")
	@Getter @Setter
	private Account account;
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id")
	@Getter @Setter
	private Role role;
	
	@Override
	public int hashCode() {
		return 0;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (null == obj) return false;
		if (this.getClass() != obj.getClass()) return false;
		final AccountRole ar = (AccountRole) obj;
		return this.getAccount().getAccountId().longValue() == ar.getAccount().getAccountId().longValue() &&
			   this.getRole().getRoleId().longValue() == ar.getRole().getRoleId().longValue();
	}
	
}
