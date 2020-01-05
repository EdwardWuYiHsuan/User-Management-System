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
@Table(name = "account")
public class Account implements Serializable {

	private static final long serialVersionUID = -4519098024323305930L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "account_id")
	@Getter @Setter
	private Long accountId;
	
	@NotNull
	@Column(name = "account", unique = true)
	@Getter @Setter
	private String account;
	
	@NotNull
	@Column(name = "name")
	@Getter @Setter
	private String name;
	
	@NotNull
	@Column(name = "sex")
	@Getter @Setter
	private Character sex;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
	@Getter @Setter
	private Set<AccountRole> accountRole = new HashSet<AccountRole>(0);
	
	public Account(Account.Builder builder) {
		this.account = builder.account;
		this.name = builder.name;
		this.sex = builder.sex;
	}
	
	public static Account.Builder builder() {
		return new Account.Builder();
	}
	
	public static final class Builder {
		
		private String account;
		private String name;
		private Character sex;
		
		public Account.Builder account(String account) {
			this.account = account;
			return this;
		}
		
		public Account.Builder name(String name) {
			this.name = name;
			return this;
		}
		
		public Account.Builder sex(Character sex) {
			this.sex = sex;
			return this;
		}
		
		public Account build() {
			return new Account(this);
		}
	}
	
}
