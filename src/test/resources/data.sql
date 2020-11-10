INSERT INTO conditionnement 
(emballage, 	 	poids,		 unite) VALUES 
('PAQUET', 			'1', 		'KILOGRAMME'), 
('POT', 			'250', 		'GRAMME'), 
('BOITE', 			'1', 		'KILOGRAMME'), 
('POT', 			'250', 		'CENTILITRE'), 
('FILET', 			'50', 		'GRAMME'), 
('BARQUETTE', 		'200', 		'GRAMME'), 
('PAQUET', 			'80', 		'GRAMME'), 
('PAQUET', 			'100', 		'GRAMME'), 
('PIECE', 			'50', 		'GRAMME'), 
('BARQUETTE', 		'100', 		'GRAMME'), 
('PAQUET', 			'1', 		'KILOGRAMME'), 
('PAQUET', 			'1', 		'LITRE');

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

INSERT INTO menu 
(couvert_midi1, couvert_midi2, couvert_soir1, couvert_soir2, date, midi_1, midi_2, soir_1, soir_2) VALUES 
('2', '3', 	'5', NULL, '2020-10-22', '1', '2', 	'3', NULL),
('2', NULL, '5', NULL, '2020-10-23', '4', NULL, '1', NULL),
('2', NULL, '5', NULL, '2020-10-24', '1', NULL, '2', NULL),
('2', NULL, '5', NULL, '2020-10-25', '2', NULL, '3', NULL),
('2', NULL, '5', NULL, '2020-10-26', '3', NULL, '4', NULL),
('2', '3', 	'5', NULL, '2020-10-27', '2', '4', 	'1', NULL),
('2', NULL, '5', NULL, '2020-10-28', '3', NULL, '2', NULL),
('2', NULL, '5', NULL, '2020-10-29', '1', NULL, '3', NULL);