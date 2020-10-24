package dev.dto;

import java.time.LocalDate;

public class MenuDtoRequete {
	private Integer id = null;
	private LocalDate date;
	private Integer midi1Id;
	private Integer couvertMidi1;
	private Integer midi2Id;
	private Integer couvertMidi2;
	private Integer soir1Id;
	private Integer couvertSoir1;
	private Integer soir2Id;
	private Integer couvertSoir2;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Integer getMidi1Id() {
		return midi1Id;
	}

	public void setMidi1Id(Integer midi1Id) {
		this.midi1Id = midi1Id;
	}

	public Integer getCouvertMidi1() {
		return couvertMidi1;
	}

	public void setCouvertMidi1(Integer couvertMidi1) {
		this.couvertMidi1 = couvertMidi1;
	}

	public Integer getMidi2Id() {
		return midi2Id;
	}

	public void setMidi2Id(Integer midi2Id) {
		this.midi2Id = midi2Id;
	}

	public Integer getCouvertMidi2() {
		return couvertMidi2;
	}

	public void setCouvertMidi2(Integer couvertMidi2) {
		this.couvertMidi2 = couvertMidi2;
	}

	public Integer getSoir1Id() {
		return soir1Id;
	}

	public void setSoir1Id(Integer soir1Id) {
		this.soir1Id = soir1Id;
	}

	public Integer getCouvertSoir1() {
		return couvertSoir1;
	}

	public void setCouvertSoir1(Integer couvertSoir1) {
		this.couvertSoir1 = couvertSoir1;
	}

	public Integer getSoir2Id() {
		return soir2Id;
	}

	public void setSoir2Id(Integer soir2Id) {
		this.soir2Id = soir2Id;
	}

	public Integer getCouvertSoir2() {
		return couvertSoir2;
	}

	public void setCouvertSoir2(Integer couvertSoir2) {
		this.couvertSoir2 = couvertSoir2;
	}

}
