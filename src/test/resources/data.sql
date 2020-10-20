INSERT INTO conditionnement (emballage,nombre_piece,poids_piece,unite) VALUES 
('PAQUET', 10, 100, 'GRAMME'),
('FILLET', 1, 2.5, 'KILOGRAME'),
('PIECE', 1, 1, 'KILOGRAME'),
('BRIQUE', 4, 250, 'CENTILITRE'),
('PAQUET', 1, 200, 'GRAMME'),
('BOUTEILLE', 1, 1, 'LITRE'),
('CONSERVE', 1, 200, 'GRAMME');





INSERT INTO produit (categorie,libelle,magasin,prix,prix_kg,conditionnement_id) VALUES 
('LEGUME',			'boite haricot marque repere', 	'INTERMARCHE', 	'1.26', '4.52', '7'),
('MATIERE_GRASSE', 	'huile de tournesol', 			'CARREFOUR', 	'0.82', '0.82', '6'),
('VIANDE', 			'steak hache charal x10', 		'CARREFOUR', 	'0.82', '0.82', '1'),
('FECULENT', 		'pomme de terre 2.5kg', 		'SYSTEM_U', 	'3.20', '1.52', '2'),
('VIANDE', 			'roti de porc', 				'LIDL',			'4.86', '4.86', '3'),
('POISSON',			'thon a la thomate', 			'LIDL',		 	'1.25', '1.25', '7'),
('PRODUIT_LAITIER',	'creme liquide', 				'CARREFOUR', 	'0.99', '0.99', '4'),
('LEGUME', 			'boite azeaze marque repere', 	'INTERMARCHE',	'1', 	'1', 	'1');