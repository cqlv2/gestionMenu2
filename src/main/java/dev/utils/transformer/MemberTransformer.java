package dev.utils.transformer;

import dev.dto.member.MemberDtoQuery;
import dev.dto.member.MemberDtoResponse;
import dev.entity.Member;
import dev.entity.Packaging;

public class MemberTransformer {

	public static MemberDtoResponse entityToDtoResponse(Member entity) {
		MemberDtoResponse memberDto = new MemberDtoResponse(entity);
		return memberDto;
	}

	public static Member dtoToEntity(MemberDtoQuery dtoRequete) {
		Member m=new Member();
		m.setId(dtoRequete.getId()!=null?dtoRequete.getId():null);
		m.setEmail(dtoRequete.getEmail());
		m.setPassword(dtoRequete.getPassword());
		m.setUsername(dtoRequete.getUsername());
		return m;
	}

}
