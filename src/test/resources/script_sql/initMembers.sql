delete from member_has_role; 
delete from member;
ALTER TABLE member_has_role AUTO_INCREMENT=0;
ALTER TABLE member AUTO_INCREMENT=0;

insert into member 
(date_inscription, 	email,			 		nom,	 	prenom,	 	user_name,	 	encode_pass) value
("2020-12-16", 		"admin@site.com", 		"admin", 	"Sylvain",	"admin1", 		"admin1"),
("2020-12-15", 		"modo1@site.com", 		"modo1", 	"frank",	"modo1", 		"modo1"),
("2020-12-14", 		"modo2@site.com", 		"modo2", 	"john",		"modo2", 		"modo2"),
("2020-12-13", 		"user1@gmail.com", 		"user1", 	"mickey",	"user1", 		"user1"),
("2020-12-12", 		"user2@gmail.com", 		"user2", 	"boby",		"user2", 		"user2");

insert into member_has_role(role_id,member_id)value
(1,1),
(2,2),
(2,3),
(3,4),
(3,5);
