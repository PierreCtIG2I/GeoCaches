use geocaches;

set FOREIGN_KEY_CHECKS = 0;

drop table if exists utilisateur;
create table utilisateur
(
	utilisateur_id int primary key auto_increment not null,
    pseudo varchar(30) unique not null,
    description varchar(200)
);

drop table if exists lieu;
create table lieu 
(
	lieu_id int primary key auto_increment not null,
    description varchar(200) unique
);

drop table if exists cache;
create table cache
(
	cache_id int primary key auto_increment not null,
    coordonnees point not null,
    description varchar(500) not null,
    type varchar(50) not null,
    nature enum('physique', 'virtuelle') not null,
    etat enum('activée', 'en cours d activation', 'fermée', 'suspendue') not null,
    id_utilisateur int,
    id_lieu int
);

drop table if exists visite;
create table visite
(
	visite_id int primary key auto_increment not null,
    date date not null,
    commentaire varchar(250),
    id_cache int
);

alter table cache 
add foreign key (id_utilisateur) references utilisateur (utilisateur_id),
add foreign key (id_lieu) references lieu (lieu_id);

alter table visite
add foreign key (id_cache) references cache (cache_id);

set FOREIGN_KEY_CHECKS = 1;