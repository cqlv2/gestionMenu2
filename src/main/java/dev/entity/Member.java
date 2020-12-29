//package dev.entity;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
//import javax.persistence.OneToMany;
//import javax.persistence.UniqueConstraint;
//
//@Entity
//public class Member {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer id;
//	private String nom;
//	private String prenom;
//	private String userName;
//	private String email;
//	private String encodePass;
//	private LocalDate dateInscription;
//	@ManyToMany(cascade = { CascadeType.ALL })
//	@JoinTable(name = "member_has_role", joinColumns = @JoinColumn(name = "member_id"), inverseJoinColumns = @JoinColumn(name = "role_id"), uniqueConstraints = @UniqueConstraint(columnNames = {
//			"member_id", "role_id" }))
//	private List<Role> roles = new ArrayList<Role>();
//	@OneToMany(targetEntity = Menu.class, mappedBy = "member")
//	private List<Menu> commands = new ArrayList<Menu>();
//
//	// getteur setteur
//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	public String getNom() {
//		return nom;
//	}
//
//	public void setNom(String nom) {
//		this.nom = nom;
//	}
//
//	public String getPrenom() {
//		return prenom;
//	}
//
//	public void setPrenom(String prenom) {
//		this.prenom = prenom;
//	}
//
//	public String getUserName() {
//		return userName;
//	}
//
//	public void setUserName(String userName) {
//		this.userName = userName;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getEncodePass() {
//		return encodePass;
//	}
//
//	public void setEncodePass(String encodePass) {
//		this.encodePass = encodePass;
//	}
//
//	public LocalDate getDateInscription() {
//		return dateInscription;
//	}
//
//	public void setDateInscription(LocalDate dateInscription) {
//		this.dateInscription = dateInscription;
//	}
//
//	public List<Role> getRoles() {
//		return roles;
//	}
//
//	public void setRoles(List<Role> roles) {
//		this.roles = roles;
//	}
//
//	public List<Menu> getCommands() {
//		return commands;
//	}
//
//	public void setCommands(List<Menu> commands) {
//		this.commands = commands;
//	}
//
//}
