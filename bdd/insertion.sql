use geocaches;

insert into utilisateur (utilisateur_id, pseudo, description, photo) values 
	('1', 'Milahiyah', 'On est sur Tinder pour avoir une description ?', 'superbePhoto.png'),
    ('2', 'JeanLou', 'Je recherche des caches pour avoir du cash.... T as vu la bête de phrase ?', 'UneBonneBinouse.png'),
    ('3', 'CacheCache', 'Je suis cachée', 'cache.png'),
    ('4', 'LaRafale', 'Checkez moi ça, la rafale !', 'LePickUp.png'),
    ('5', 'Diams', 'Mademoiselle recherche un mec mortel', 'LaBoulette.png');
    
insert into lieu (lieu_id, description) values
	('1', 'Stade Bollaert'),
    ('2', 'Tour Eiffel'),
    ('3', 'Quand tu sors de la mairie de Lens, tu prends la rue en face, tu fais à peu près 200 mètres et arriver au petit carré d herbe bah c est là'),
    ('4', 'Colisée de Rome mdr bon courage'),
    ('5', 'A 500 mètres de chez nous !');
    
insert into cache (cache_id, coordonnees, description, type, nature, etat, id_utilisateur, id_lieu) values
	('1', '50.432777;2.815000', 'Dans la tribune A, place 128', 'cache traditionnelle', 'PHYSIQUE', 'FERMEE', '2', '1'),
    ('2', '48.858370;2.294481', 'Au pied le plus au sud-ouest', 'cache traditionnelle', 'PHYSIQUE', 'FERMEE', '2', '2'),
    ('3', '41.890210;12.492231', 'Sous le banc le plus proche de l entrée principale', 'cache objet', 'PHYSIQUE', 'SUSPENDUE', '2','4'),
    ('4', '50.43095955297533;2.831890254865258', 'Au pied de la statue', 'cache traditionnelle', 'PHYSIQUE', 'FERMEE', '1', '3'),
    ('5', 'https://www.youtube.com/watch?v=k_kKz9VcVfQ', 'A l arrière du pick up', 'cache jeu de piste', 'VIRTUELLE', 'EN_COURS_ACTIVATION', '4', '5');
    
insert into visite (visite_id, date, commentaire, photo, id_cache, id_utilisateur) values
	('1', '2020-01-15 16:03:47', 'Superbe endroit, Lens est vraiment une ville incroyable !', 'photo1.png', '1', '3'),
    ('2', '2021-01-31 23:59:59', 'jélaref', 'photo2.png', '5', '1'),
    ('3', '2021-02-01 21:35:12', 'Superbe endroit même si j ai failli me faire arrêter par la police lol', 'photo3.png', '2', '4');