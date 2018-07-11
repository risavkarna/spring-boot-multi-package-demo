create schema xres
;

create sequence entity_id_seq
;

create sequence type_id_seq
;

create sequence template_id_seq
;

create sequence concept_id_seq
;

create sequence id_seq
;

create sequence rel_id_seq
	minvalue 1000
;

create sequence concept_system_config_key_seq
	as integer
	maxvalue 2147483647
;

create table meta_type
(
	id integer default nextval('xres.type_id_seq'::regclass) not null
		constraint metatype_id_pk
			primary key,
	title varchar(50) not null
)
;

create unique index metatype_title_uindex
	on xres.meta_type (title)
;

create table xres.meta_audit
(
	id integer default nextval('xres.id_seq'::regclass) not null
		constraint temporal_audit_id_pk
			primary key,
	created_by integer not null,
	updated_by integer not null,
	created_at timestamp not null,
	updated_at timestamp not null
)
;

create table xres.meta_group
(
	id integer default nextval('xres.type_id_seq'::regclass) not null
		constraint group_id_pk
			primary key,
	hierarchy integer default 0 not null,
	title varchar(50) not null
)
;

create table xres.entity
(
	id integer default nextval('xres.entity_id_seq'::regclass) not null
		constraint entity_id_pk
			primary key,
	metatype integer not null
		constraint entity_metatype_fk
			references meta_type
				on update cascade on delete cascade,
	metagroup integer
		constraint entity_metagroup_fk
			references meta_group
				on update cascade on delete cascade,
	audit integer
		constraint entity_audit_fk
			references meta_audit
				on update cascade on delete cascade
)
;

create table xres.entity_cruise
(
	id integer default nextval('xres.entity_id_seq'::regclass) not null
		constraint entity_cruise_id_pk
			primary key,
	meta_id integer not null
		constraint entity_cruise_meta_fk
			references entity
				on update cascade on delete cascade,
	start_date time not null,
	end_date time not null
)
;

create table xres.archetype
(
	id integer default nextval('xres.template_id_seq'::regclass) not null
		constraint archetype_id_pk
			primary key,
	meta_id integer not null
		constraint archetype_entity_fk
			references entity
				on update cascade on delete cascade,
	cruise_id integer
		constraint archetype_cruise_fk
			references entity_cruise
)
;

create table xres.archetype_restaurant
(
	id integer default nextval('xres.template_id_seq'::regclass) not null
		constraint archetype_restaurant_id_pk
			primary key,
	meta_id integer not null
		constraint archetype_restaurant_archetype_fk
			references archetype
				on update cascade on delete cascade
)
;

create table xres.archetype_event
(
	id integer default nextval('xres.template_id_seq'::regclass) not null
		constraint archetype_event_id_pk
			primary key,
	meta_id integer not null
		constraint archetype_event_archetype_fk
			references archetype
				on update cascade on delete cascade
)
;

create unique index metagroup_title_uindex
	on xres.meta_group (title)
;

create unique index metagroup_hierarchy_uindex
	on xres.meta_group (hierarchy)
;

create table xres.entity_user
(
	id integer default nextval('xres.entity_id_seq'::regclass) not null
		constraint entity_user_pkey
			primary key,
	meta_id integer not null
		constraint entity_user_entity_fk
			references entity
				on update cascade on delete cascade,
	user_id varchar(50) not null,
	cabin varchar(100),
	last_name varchar(100),
	first_name varchar(100)
)
;

create table xres.entity_manager
(
	id integer default nextval('xres.entity_id_seq'::regclass) not null
		constraint entity_manager_id_pk
			primary key,
	meta_id integer not null
		constraint entity_manager_meta_fk
			references entity_user
				on update cascade on delete cascade
)
;

alter table xres.meta_audit
	add constraint temporal_audit_creator_user_fk
		foreign key (created_by) references entity_user
;

alter table xres.meta_audit
	add constraint temporal_audit_updater_user_fk
		foreign key (updated_by) references entity_user
;

create table xres.entity_booker
(
	id integer default nextval('xres.entity_id_seq'::regclass) not null
		constraint entity_booker_id_pk
			primary key,
	meta_id integer not null
		constraint entity_booker_meta_fk
			references entity_user
				on update cascade on delete cascade
)
;

create table xres.concept
(
	id integer default nextval('xres.concept_id_seq'::regclass) not null
		constraint concept_pkey
			primary key,
	meta_id integer not null
		constraint concept_meta_id_fk
			references entity
				on update cascade on delete cascade,
	culture varchar(10) default 'en_US'::text not null,
	sailor integer not null
		constraint concept_user_fk
			references entity_user
)
;

create table xres.concept_configuration
(
	id integer default nextval('xres.concept_id_seq'::regclass) not null
		constraint concept_configuration_id_pk
			primary key,
	meta_id integer not null
		constraint concept_configuration_concept_fk
			references concept
				on update cascade on delete cascade
)
;

create table xres.concept_management
(
	id integer default nextval('xres.concept_id_seq'::regclass) not null
		constraint concept_management_id_pk
			primary key,
	meta_id integer not null
		constraint concept_management_concept_fk
			references concept
				on update cascade on delete cascade
)
;

create unique index entity_user_user_id_uindex
	on xres.entity_user (user_id)
;

create table xres.entity_coordinates
(
	id integer not null
		constraint location_pkey
			primary key,
	meta_id integer not null
		constraint location_entity_fk
			references entity
				on update cascade on delete cascade,
	x_coordinate double precision,
	y_coordinate double precision,
	z_coordinate integer
)
;

create table xres.entity_event
(
	id integer default nextval('xres.entity_id_seq'::regclass) not null
		constraint entity_event_id_pk
			primary key,
	meta_id integer not null
		constraint entity_event_meta_fk
			references entity
				on update cascade on delete cascade,
	coordinates integer not null
		constraint entity_event_coordinates_fk
			references entity_coordinates
)
;

create table xres.entity_restaurant
(
	id integer default nextval('xres.entity_id_seq'::regclass) not null
		constraint entity_restaurant_id_pk
			primary key,
	meta_id integer not null
		constraint entity_restaurant_meta_fk
			references entity
				on update cascade on delete cascade,
	full_name varchar(255) not null,
	image varchar(255),
	teaser varchar(500),
	coordinates integer not null
		constraint entity_restaurant_coordinates_fk
			references entity_coordinates,
	code varchar(50) not null
)
;

create table xres.concept_booking
(
	id integer default nextval('xres.concept_id_seq'::regclass) not null
		constraint concept_booking_id_pk
			primary key,
	meta_id integer not null
		constraint concept_booking_concept_fk
			references concept
				on update cascade on delete cascade,
	pseudo_delete boolean default false not null,
	guests integer not null,
	restaurant integer not null
		constraint concept_booking_entity_restaurant_fk
			references entity_restaurant,
	datetime timestamp not null,
	requests varchar(500),
	shareable boolean default true
)
;

create table xres.entity_booking
(
	id integer default nextval('xres.entity_id_seq'::regclass) not null
		constraint entity_booking_id_pk
			primary key,
	meta_id integer not null
		constraint entity_booking_meta_fk
			references entity_booker
				on update cascade on delete cascade,
	meta_concept integer not null
		constraint entity_booking_concept_booking_fk
			references concept_booking
)
;

create unique index entity_restaurant_code_uindex
	on xres.entity_restaurant (code)
;

create table xres.entity_availability
(
	id integer default nextval('xres.entity_id_seq'::regclass) not null
		constraint entity_availabilities_pkey
			primary key,
	meta_id integer not null
		constraint entity_availabilities_entity_fk
			references entity
				on update cascade on delete cascade,
	cruise integer not null,
	date_res timestamp not null,
	time_res time
)
;

create table xres.entity_seat
(
	id integer default nextval('xres.entity_id_seq'::regclass) not null
		constraint entity_seat_pkey
			primary key,
	meta_id integer not null,
	free integer,
	expected integer,
	in_house integer,
	partial_in_house integer,
	finished_uncleared integer,
	avail_id integer not null
		constraint entity_seat_entity_availability_fk
			references entity_availability
				on update cascade on delete cascade
)
;

create table xres.rel
(
	id integer default nextval('xres.type_id_seq'::regclass) not null
		constraint rel_id_pk
			primary key,
	node_one_id integer not null,
	node_two_id integer not null,
	meta_id integer not null
		constraint rel_entity_fk
			references entity
)
;

create table xres.rel_booking_user
(
	id integer not null
		constraint rel_booking_user_pkey
			primary key,
	meta_id integer not null
		constraint rel_booking_user_rel_fk
			references rel,
	entity_booking integer
		constraint rel_booking_user_entity_booking_fk
			references entity_booking
				on update cascade on delete cascade,
	entity_user integer not null
		constraint rel_booking_user_user_fk
			references entity_user
)
;

create unique index rel_booking_user_meta_id_uindex
	on xres.rel_booking_user (meta_id)
;

create unique index rel_id_uindex
	on xres.rel (id)
;

create table xres.concept_booking_mgmt
(
	id integer default nextval('xres.concept_id_seq'::regclass) not null
		constraint concept_booking_mgmt_pkey
			primary key,
	meta_id integer not null
		constraint concept_booking_mgmt_concept_booking_fk
			references concept_booking
				on update cascade on delete cascade,
	concept_management integer not null
		constraint concept_booking_mgmt_concept_management_fk
			references concept_management
				on update cascade on delete cascade
)
;

create table xres.concept_system
(
	id integer default nextval('xres.entity_id_seq'::regclass) not null
		constraint concept_system_pkey
			primary key,
	meta_id integer not null
		constraint concept_system_concept_fk
			references concept
				on update cascade on delete cascade,
	config_key serial not null,
	config_value varchar(500)
)
;

create unique index concept_system_config_key_uindex
	on xres.concept_system (config_key)
;

create table xres.concept_system_configuration
(
	id integer default nextval('xres.concept_id_seq'::regclass) not null
		constraint concept_system_configuration_pkey
			primary key,
	meta_id integer not null
		constraint concept_system_configuration_system_fk
			references concept_system
				on update cascade on delete cascade,
	concept_configuration integer not null
		constraint concept_system_configuration_concept_configuration_fk
			references concept_configuration
				on update cascade on delete cascade
)
;

create table xres.rel_booking_system
(
	id integer default nextval('xres.type_id_seq'::regclass) not null
		constraint rel_booking_system_pkey
			primary key,
	entity_booking integer not null
		constraint rel_booking_system_booking_fk
			references entity_booking
				on update cascade on delete cascade,
	concept_system integer not null
		constraint rel_booking_system_system_fk
			references concept_system
				on update cascade on delete cascade,
	meta_id integer not null
		constraint rel_booking_system_rel_fk
			references rel
				on update cascade on delete cascade
)
;

