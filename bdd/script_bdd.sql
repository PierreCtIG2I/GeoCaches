drop schema if exists geocaches;
create schema geocaches;
use geocaches;

set FOREIGN_KEY_CHECKS = 0;

drop table if exists utilisateur;
create table utilisateur
(
	utilisateur_id varchar(50) primary key not null,
    pseudo varchar(30) unique not null,
    description varchar(200),
    photo varchar(20)
);

drop table if exists lieu;
create table lieu 
(
	lieu_id varchar(50) primary key not null,
    description varchar(200) unique
);

drop table if exists cache;
create table cache
(
	cache_id varchar(50) primary key not null,
    coordonnees varchar(150) not null,
    description varchar(500) not null,
    type varchar(50) not null,
    nature enum('PHYSIQUE', 'VIRTUELLE') not null,
    etat enum('ACTIVEE', 'EN_COURS_ACTIVATION', 'FERMEE', 'SUSPENDUE') not null,
    id_utilisateur varchar(50),
    id_lieu varchar(50)
);

drop table if exists visite;
create table visite
(
	visite_id varchar(50) primary key not null,
    date datetime not null,
    commentaire varchar(250),
    photo varchar(20),
    id_cache varchar(50),
    id_utilisateur varchar(50)
);

alter table cache 
add foreign key (id_utilisateur) references utilisateur (utilisateur_id),
add foreign key (id_lieu) references lieu (lieu_id);

alter table visite
add foreign key (id_cache) references cache (cache_id),
add foreign key (id_utilisateur) references utilisateur (utilisateur_id);

set FOREIGN_KEY_CHECKS = 1;