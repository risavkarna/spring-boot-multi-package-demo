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
	id bigint default nextval('xres.type_id_seq'::regclass) not null
		constraint metatype_id_pk
			primary key,
	title varchar(50) not null
)
;

create unique index metatype_title_uindex
	on meta_type (title)
;

create table meta_audit
(
	id bigint default nextval('xres.id_seq'::regclass) not null
		constraint temporal_audit_id_pk
			primary key,
	created_by bigint not null,
	updated_by bigint not null,
	created_at timestamp not null,
	updated_at timestamp not null
)
;

create table meta_group
(
	id bigint default nextval('xres.type_id_seq'::regclass) not null
		constraint group_id_pk
			primary key,
	hierarchy integer default 1 not null,
	title varchar(50) not null
)
;

create table entity
(
	id bigint default nextval('xres.entity_id_seq'::regclass) not null
		constraint entity_id_pk
			primary key,
	metatype bigint not null
		constraint entity_metatype_fk
			references meta_type
				on update cascade on delete cascade,
	metagroup bigint
		constraint entity_metagroup_fk
			references meta_group
				on update cascade on delete cascade,
	audit bigint
		constraint entity_audit_fk
			references meta_audit
				on update cascade on delete cascade
)
;

create table entity_cruise
(
	id bigint default nextval('xres.entity_id_seq'::regclass) not null
		constraint entity_cruise_id_pk
			primary key,
	meta_id bigint not null
		constraint entity_cruise_meta_fk
			references entity
				on update cascade on delete cascade,
	cruise_id varchar(100),
	start_date timestamp,
	end_date timestamp
)
;

create table archetype
(
	id bigint default nextval('xres.template_id_seq'::regclass) not null
		constraint archetype_id_pk
			primary key,
	meta_id bigint not null
		constraint archetype_entity_fk
			references entity
				on update cascade on delete cascade,
	cruise_id bigint
		constraint archetype_cruise_fk
			references entity_cruise
)
;

create table archetype_restaurant
(
	id bigint default nextval('xres.template_id_seq'::regclass) not null
		constraint archetype_restaurant_id_pk
			primary key,
	meta_id bigint not null
		constraint archetype_restaurant_archetype_fk
			references archetype
				on update cascade on delete cascade
)
;

create table archetype_event
(
	id bigint default nextval('xres.template_id_seq'::regclass) not null
		constraint archetype_event_id_pk
			primary key,
	meta_id bigint not null
		constraint archetype_event_archetype_fk
			references archetype
				on update cascade on delete cascade
)
;

create unique index metagroup_title_uindex
	on meta_group (title)
;

create unique index metagroup_hierarchy_uindex
	on meta_group (hierarchy)
;

create table entity_user
(
	id bigint default nextval('xres.entity_id_seq'::regclass) not null
		constraint entity_user_pkey
			primary key,
	meta_id bigint not null
		constraint entity_user_entity_fk
			references entity
				on update cascade on delete cascade,
	folio varchar(50) not null,
	cabin varchar(100),
	last_name varchar(100),
	first_name varchar(100)
)
;

create table entity_manager
(
	id bigint default nextval('xres.entity_id_seq'::regclass) not null
		constraint entity_manager_id_pk
			primary key,
	meta_id bigint not null
		constraint entity_manager_meta_fk
			references entity_user
				on update cascade on delete cascade
)
;

alter table meta_audit
	add constraint temporal_audit_creator_user_fk
		foreign key (created_by) references entity_user
;

alter table meta_audit
	add constraint temporal_audit_updater_user_fk
		foreign key (updated_by) references entity_user
;

create table entity_booker
(
	id bigint default nextval('xres.entity_id_seq'::regclass) not null
		constraint entity_booker_id_pk
			primary key,
	meta_id bigint not null
		constraint entity_booker_meta_fk
			references entity_user
				on update cascade on delete cascade
)
;

create table concept
(
	id bigint default nextval('xres.concept_id_seq'::regclass) not null
		constraint concept_pkey
			primary key,
	meta_id bigint not null
		constraint concept_meta_id_fk
			references entity
				on update cascade on delete cascade,
	culture varchar(10) default 'en_US'::text not null,
	sailor bigint not null
		constraint concept_user_fk
			references entity_user
)
;

create table concept_configuration
(
	id bigint default nextval('xres.concept_id_seq'::regclass) not null
		constraint concept_configuration_id_pk
			primary key,
	meta_id bigint not null
		constraint concept_configuration_concept_fk
			references concept
				on update cascade on delete cascade
)
;

create table concept_management
(
	id bigint default nextval('xres.concept_id_seq'::regclass) not null
		constraint concept_management_id_pk
			primary key,
	meta_id bigint not null
		constraint concept_management_concept_fk
			references concept
				on update cascade on delete cascade
)
;

create unique index entity_user_user_id_uindex
	on entity_user (folio)
;

create table entity_coordinates
(
	id bigint not null
		constraint location_pkey
			primary key,
	meta_id bigint not null
		constraint location_entity_fk
			references entity
				on update cascade on delete cascade,
	x_coordinate double precision,
	y_coordinate double precision,
	z_coordinate integer
)
;

create table entity_event
(
	id bigint default nextval('xres.entity_id_seq'::regclass) not null
		constraint entity_event_id_pk
			primary key,
	meta_id bigint not null
		constraint entity_event_meta_fk
			references entity
				on update cascade on delete cascade,
	coordinates bigint not null
		constraint entity_event_coordinates_fk
			references entity_coordinates
)
;

create table entity_restaurant
(
	id bigint default nextval('xres.entity_id_seq'::regclass) not null
		constraint entity_restaurant_id_pk
			primary key,
	meta_id bigint not null
		constraint entity_restaurant_meta_fk
			references entity
				on update cascade on delete cascade,
	full_name varchar(255) not null,
	image varchar(255),
	teaser varchar(500),
	coordinates bigint not null
		constraint entity_restaurant_coordinates_fk
			references entity_coordinates,
	code varchar(50) not null
)
;

create table concept_booking
(
	id bigint default nextval('xres.concept_id_seq'::regclass) not null
		constraint concept_booking_id_pk
			primary key,
	meta_id bigint not null
		constraint concept_booking_concept_fk
			references concept
				on update cascade on delete cascade,
	pseudo_delete boolean default false not null,
	guests bigint not null,
	restaurant bigint not null
		constraint concept_booking_entity_restaurant_fk
			references entity_restaurant,
	datetime timestamp not null,
	requests varchar(500),
	shareable boolean default true
)
;

create table entity_booking
(
	id bigint default nextval('xres.entity_id_seq'::regclass) not null
		constraint entity_booking_id_pk
			primary key,
	meta_id bigint not null
		constraint entity_booking_meta_fk
			references entity_booker
				on update cascade on delete cascade,
	meta_concept bigint not null
		constraint entity_booking_concept_booking_fk
			references concept_booking
)
;

create unique index entity_restaurant_code_uindex
	on entity_restaurant (code)
;

create table entity_availability
(
	id bigint default nextval('xres.entity_id_seq'::regclass) not null
		constraint entity_availabilities_pkey
			primary key,
	meta_id bigint not null
		constraint entity_availabilities_entity_fk
			references entity
				on update cascade on delete cascade,
	cruise bigint not null
		constraint entity_availability_cruise_fk
			references entity_cruise,
	date_res timestamp not null,
	time_res time
)
;

create table entity_seat
(
	id bigint default nextval('xres.entity_id_seq'::regclass) not null
		constraint entity_seat_pkey
			primary key,
	meta_id bigint not null,
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

create table rel
(
	id bigint default nextval('xres.type_id_seq'::regclass) not null
		constraint rel_id_pk
			primary key,
	node_one_id bigint not null,
	node_two_id bigint not null,
	meta_id bigint not null
		constraint rel_entity_fk
			references entity
)
;

create table rel_booking_user
(
	id bigint not null
		constraint rel_booking_user_pkey
			primary key,
	meta_id bigint not null
		constraint rel_booking_user_rel_fk
			references rel,
	entity_booking bigint
		constraint rel_booking_user_entity_booking_fk
			references entity_booking
				on update cascade on delete cascade,
	entity_user bigint not null
		constraint rel_booking_user_user_fk
			references entity_user
)
;

create unique index rel_booking_user_meta_id_uindex
	on rel_booking_user (meta_id)
;

create unique index rel_id_uindex
	on rel (id)
;

create table rel_booking_mgmt
(
	id bigint default nextval('xres.rel_id_seq'::regclass) not null
		constraint concept_booking_mgmt_pkey
			primary key,
	meta_id bigint not null
		constraint concept_booking_mgmt_concept_booking_fk
			references concept_booking
				on update cascade on delete cascade,
	concept_management bigint not null
		constraint concept_booking_mgmt_concept_management_fk
			references concept_management
				on update cascade on delete cascade
)
;

create table concept_system
(
	id bigint default nextval('xres.entity_id_seq'::regclass) not null
		constraint concept_system_pkey
			primary key,
	meta_id bigint not null
		constraint concept_system_concept_fk
			references concept
				on update cascade on delete cascade,
	config_key bigserial not null,
	config_value varchar(500)
)
;

create unique index concept_system_config_key_uindex
	on concept_system (config_key)
;

create table rel_system_configuration
(
	id bigint default nextval('xres.type_id_seq'::regclass) not null
		constraint concept_system_configuration_pkey
			primary key,
	meta_id bigint not null
		constraint concept_system_configuration_system_fk
			references concept_system
				on update cascade on delete cascade,
	concept_configuration bigint not null
		constraint concept_system_configuration_concept_configuration_fk
			references concept_configuration
				on update cascade on delete cascade
)
;

create table rel_booking_system
(
	id bigint default nextval('xres.type_id_seq'::regclass) not null
		constraint rel_booking_system_pkey
			primary key,
	entity_booking bigint not null
		constraint rel_booking_system_booking_fk
			references entity_booking
				on update cascade on delete cascade,
	concept_system bigint not null
		constraint rel_booking_system_system_fk
			references concept_system
				on update cascade on delete cascade,
	meta_id bigint not null
		constraint rel_booking_system_rel_fk
			references rel
				on update cascade on delete cascade
)
;

