CREATE TABLE IF NOT EXISTS public.users (
	id              varchar         NOT NULL,
	first_name      varchar(100)    NOT NULL,
	last_name       varchar(100)    NOT NULL,
	middle_name     varchar(100)    NULL,
	phone           varchar(30)     NULL,
	CONSTRAINT users_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.organizations (
	id                  varchar(36)     NOT NULL,
	"name"              varchar(256)    NOT NULL,
	image               varchar(1024)   NULL,
	contact_person_id   varchar(36)     NULL,
	director            varchar(128)    NULL,
	inn                 varchar(50)     NOT NULL,
	ogrn                varchar(50)     NULL,
	kpp                 varchar(50)     NULL,
	okved               varchar(50)     NULL,
	okpo                varchar(50)     NULL,
	bank                varchar(256)    NULL,
	bik                 varchar(50)     NULL,
	phone               varchar(11)     NULL,
	email               varchar(50)     NULL,
	employees_count     int4            NULL,
	address             varchar(1024)   NULL,
	creation_date timestamptz NOT NULL DEFAULT now(),
	update_date timestamptz NOT NULL DEFAULT now(),
	description         text            NULL,
	CONSTRAINT organizations_inn_key UNIQUE (inn),
	CONSTRAINT organizations_pkey PRIMARY KEY (id),
	CONSTRAINT organizations_contact_person_id_fkey FOREIGN KEY (contact_person_id) REFERENCES public.users(id) ON DELETE CASCADE
);