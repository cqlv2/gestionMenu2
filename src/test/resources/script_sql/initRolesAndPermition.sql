delete from role_has_permit; 
delete from role;
delete from permition;
ALTER TABLE role_has_permit AUTO_INCREMENT=0;
ALTER TABLE role AUTO_INCREMENT=0;
ALTER TABLE permition AUTO_INCREMENT=0;

insert into role (label) value 
("ADMIN"),
("MODERATEUR"),
("USER");

insert into permition (label) value
("CREATE_PRODUIT"),
("UPDATE_PRODUIT"),
("READ_PRODUIT"),
("DELETE_PRODUIT"),
("CREATE_RECETTE"),
("UPDATE_RECETTE"),
("READ_RECETTE"),
("DELETE_RECETTE"),
("CREATE_MENU"),
("UPDATE_MENU"),
("READ_MENU"),
("DELETE_MENU");

insert into role_has_permit (role_id, permit_id)value
(1,1),
(1,2),
(1,3),
(1,4),
(1,5),
(1,6),
(1,7),
(1,8),
(1,9),
(1,10),
(1,11),
(1,12),
(2,2),
(2,3),
(2,6),
(2,7),
(2,10),
(2,11),
(3,3),
(3,7),
(3,11);

