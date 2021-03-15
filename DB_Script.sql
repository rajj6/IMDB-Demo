create table actors (
       id int8 not null,
        dob date,
        bio text,
        name varchar(255),
        sex varchar(255),
        primary key (id)
    );
	
create table producers (
       id int8 not null,
        dob date,
        bio text,
        name varchar(255),
        sex varchar(255),
        primary key (id)
    );
	
create table movies (
       id int8 not null,
        img_type varchar(255),
        name varchar(255),
        plot text,
        poster bytea,
        year_of_release int4,
        producer_id int8,
        primary key (id),
		CONSTRAINT fk_producer
      		FOREIGN KEY(producer_id) 
	  			REFERENCES producers(id)
    );
    
create table movies_actors (
       movies_id int8 not null,
       actors_id int8 not null,
       primary key (movies_id, actors_id),
	 CONSTRAINT fk_movie
      		FOREIGN KEY(movies_id) 
	  			REFERENCES movies(id),
	CONSTRAINT fk_actor
      		FOREIGN KEY(actors_id) 
	  			REFERENCES actors(id)
    );