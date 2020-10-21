INSERT INTO conditionnement 
(emballage, 	nombre_piece, 	poids_piece, unite) VALUES 
('PAQUET', 		'1', 			'1', 		'KILOGRAMME'), 
('POT', 		'1', 			'250', 		'GRAMME'), 
('BOITE', 		'1', 			'1', 		'KILOGRAMME'), 
('POT', 		'1', 			'250', 		'CENTILITRE'), 
('FILET', 		'10', 			'50', 		'GRAMME'), 
('BARQUETTE', 	'2', 			'200', 		'GRAMME'), 
('PAQUET', 		'15', 			'80', 		'GRAMME'), 
('PAQUET', 		'5', 			'100', 		'GRAMME'), 
('PIECE', 		'1', 			'50', 		'GRAMME'), 
('BARQUETTE', 	'10', 			'100', 		'GRAMME'), 
('PAQUET', 		'1', 			'1', 		'KILOGRAMME'), 
('PAQUET', 		'6', 			'1', 		'LITRE');

INSERT INTO produit 
(categorie, 		libelle, 			magasin, 	prix, 	prix_kg, 	conditionnement_id,	quantite_par_personne, 	unite) VALUES 
('FECULENT', 		'Spaguetti', 		'LIDL', 	'0.86', '0.86',		'1', 				80, 					'GRAMME'), 
('PLAT_PREPARE',	'sauce boloniaise', 'LIDL', 	'1.20',	'4.80',		'2', 				50, 					'GRAMME'), 
('VIANDE', 			'boulette', 		'LIDL', 	'5.80',	'5.80',		'3', 				100, 					'GRAMME'),
('FECULENT', 		'penne', 			'LIDL', 	'0.84', '0.84', 	'1', 				80, 					'GRAMME'),
('MATIERE_GRASSE', 	'creme fraiche', 	'LIDL', 	'1.10', '4.40', 	'4', 				30, 					'CENTILITRE'),
('LEGUME', 			'oignon', 			'LIDL', 	'1.10', '2.20', 	'5', 				30, 					'GRAMME'),
('VIANDE', 			'lardon', 			'LIDL', 	'1.12', '2.80', 	'6', 				80, 					'GRAMME'),
('POISSON', 		'poisson panne', 	'LIDL', 	'1.10', '1.10', 	'7', 				150, 					'GRAMME'),
('FECULENT', 		'riz', 				'LIDL', 	'1.10', '1.10', 	'8', 				80, 					'GRAMME'),
('FRUIT', 			'citron', 			'LIDL', 	'1.10', '1.10', 	'9', 				10, 					'GRAMME'),
('VIANDE', 			'cordon bleu', 		'LIDL', 	'1.10', '1.10', 	'10', 				100, 					'GRAMME'),
('FECULENT', 		'purée en poudre', 	'LIDL', 	'1.10', '1.10', 	'11', 				150, 					'GRAMME'),
('PRODUIT_LAITIER', 'lait', 			'LIDL', 	'1.10', '1.10', 	'12', 				25, 					'CENTILITRE');

INSERT INTO plat 
(nom, 													note) VALUES 
('Spaguetti bolognaise boulette', 						'2'), 
('Penne a la carbonara', 								'3'),
('Poisson panne riz sauce citron',						'1'),
('cordon bleu purée', 	 								'3');

INSERT INTO fk_plat_produit 
(plat_id, 	produit_id) VALUES 
('1', 		'1'), 
('1', 		'2'), 
('1', 		'3'), 
('2', 		'4'), 
('2', 		'5'), 
('2', 		'6'), 
('2', 		'7'),
('3', 		'8'), 
('3', 		'9'), 
('3', 		'10'), 
('3', 		'5'), 
('4', 		'11'), 
('4', 		'12'), 
('4', 		'13');
