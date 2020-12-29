//package dev.entity;
//
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
//import javax.persistence.UniqueConstraint;
//
//@Entity
//public class Role {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer id;
//	private String Label;
//
//	@ManyToMany(cascade = { CascadeType.ALL })
//	@JoinTable(name = "role_has_permit", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "permit_id"), uniqueConstraints = @UniqueConstraint(columnNames = {
//			"role_id", "permit_id" }))
//	private List<Permition> permit = new ArrayList<Permition>();
//
//	@ManyToMany(cascade = { CascadeType.ALL })
//	@JoinTable(name = "member_has_role", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "member_id"), uniqueConstraints = @UniqueConstraint(columnNames = {
//			"member_id", "role_id" }))
//	private List<Member> users = new ArrayList<Member>();
//}
