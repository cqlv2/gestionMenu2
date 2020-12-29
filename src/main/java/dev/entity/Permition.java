//package dev.entity;
//
//import java.util.List;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.EnumType;
//import javax.persistence.Enumerated;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.ManyToMany;
//import javax.persistence.UniqueConstraint;
//
//@Entity
//public class Permition {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer id;
//	private String label;
//	@ManyToMany(cascade = { CascadeType.ALL })
//	@JoinTable(name = "role_has_permit", joinColumns = @JoinColumn(name = "permit_id"), inverseJoinColumns = @JoinColumn(name = "role_id"), uniqueConstraints = @UniqueConstraint(columnNames = {
//			"role_id", "permit_id" }))
//	private List<Role> roles;
//
//}
