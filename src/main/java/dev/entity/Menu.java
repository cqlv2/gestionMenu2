//package dev.entity;
//
//import java.time.LocalDate;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//
//@Entity
//public class Menu {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer id;
//	@Column(columnDefinition = "date")
//	private LocalDate date;
//	@ManyToOne
//	@JoinColumn(name = "midi_1")
//	private Plat midi1;
//	private Integer couvertMidi1;
//	@ManyToOne
//	@JoinColumn(name = "midi_2")
//	private Plat midi2;
//	private Integer couvertMidi2;
//	@ManyToOne
//	@JoinColumn(name = "Soir_1")
//	private Plat soir1;
//	private Integer couvertSoir1;
//	@ManyToOne
//	@JoinColumn(name = "soir_2")
//	private Plat soir2;
//	private Integer couvertSoir2;
//
//	@ManyToOne( cascade = CascadeType.REMOVE )
//    @JoinColumn( name="idMember" )
//    private Member member;
//	
//	
//	
//	
//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	public LocalDate getDate() {
//		return date;
//	}
//
//	public void setDate(LocalDate date) {
//		this.date = date;
//	}
//
//	public Plat getMidi1() {
//		return midi1;
//	}
//
//	public void setMidi1(Plat midi1) {
//		this.midi1 = midi1;
//	}
//
//	public Integer getCouvertMidi1() {
//		return couvertMidi1;
//	}
//
//	public void setCouvertMidi1(Integer couvertMidi1) {
//		this.couvertMidi1 = couvertMidi1;
//	}
//
//	public Plat getMidi2() {
//		return midi2;
//	}
//
//	public void setMidi2(Plat midi2) {
//		this.midi2 = midi2;
//	}
//
//	public Integer getCouvertMidi2() {
//		return couvertMidi2;
//	}
//
//	public void setCouvertMidi2(Integer couvertMidi2) {
//		this.couvertMidi2 = couvertMidi2;
//	}
//
//	public Plat getSoir1() {
//		return soir1;
//	}
//
//	public void setSoir1(Plat soir1) {
//		this.soir1 = soir1;
//	}
//
//	public Integer getCouvertSoir1() {
//		return couvertSoir1;
//	}
//
//	public void setCouvertSoir1(Integer couvertSoir1) {
//		this.couvertSoir1 = couvertSoir1;
//	}
//
//	public Plat getSoir2() {
//		return soir2;
//	}
//
//	public void setSoir2(Plat soir2) {
//		this.soir2 = soir2;
//	}
//
//	public Integer getCouvertSoir2() {
//		return couvertSoir2;
//	}
//
//	public void setCouvertSoir2(Integer couvertSoir2) {
//		this.couvertSoir2 = couvertSoir2;
//	}
//
//}
