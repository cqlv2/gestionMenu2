package dev.dto.member;

import dev.dto.SuperDto;
import dev.entity.Member;
/**
 * data transfer object between the persistence layer and the service layer.
 * Ignore the product list to avoid redundancies
 * 
 * @author cql-v2
 * @version 1.0
 */
public class MemberDtoResponse extends SuperDto{

	private String username;
	private String email;

	// constructeurs

	public MemberDtoResponse() {

	}

	public MemberDtoResponse(Member entity) {
		this.id = entity.getId();
		this.username = entity.getUsername();
		this.email = entity.getEmail();
	}

	// getteur setteur


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
