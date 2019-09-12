--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.5
-- Dumped by pg_dump version 11.3

-- Started on 2019-09-12 16:22:49

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 5 (class 2615 OID 16480)
-- Name: horisoes_peliculas; Type: SCHEMA; Schema: -; Owner: horisoes
--

CREATE SCHEMA horisoes_peliculas;


ALTER SCHEMA horisoes_peliculas OWNER TO horisoes;

--
-- TOC entry 203 (class 1259 OID 24707)
-- Name: secuence_menu; Type: SEQUENCE; Schema: horisoes_peliculas; Owner: horisoes
--

CREATE SEQUENCE horisoes_peliculas.secuence_menu
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 99999999
    CACHE 1;


ALTER TABLE horisoes_peliculas.secuence_menu OWNER TO horisoes;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 201 (class 1259 OID 24684)
-- Name: menu; Type: TABLE; Schema: horisoes_peliculas; Owner: horisoes
--

CREATE TABLE horisoes_peliculas.menu (
    id_menu integer DEFAULT nextval('horisoes_peliculas.secuence_menu'::regclass) NOT NULL,
    comand_menu character varying NOT NULL,
    text_menu character varying NOT NULL
);


ALTER TABLE horisoes_peliculas.menu OWNER TO horisoes;

--
-- TOC entry 197 (class 1259 OID 16481)
-- Name: secuence_movie; Type: SEQUENCE; Schema: horisoes_peliculas; Owner: horisoes
--

CREATE SEQUENCE horisoes_peliculas.secuence_movie
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 99999999
    CACHE 1;


ALTER TABLE horisoes_peliculas.secuence_movie OWNER TO horisoes;

--
-- TOC entry 198 (class 1259 OID 16483)
-- Name: movie; Type: TABLE; Schema: horisoes_peliculas; Owner: horisoes
--

CREATE TABLE horisoes_peliculas.movie (
    id_movie integer DEFAULT nextval('horisoes_peliculas.secuence_movie'::regclass) NOT NULL,
    name_movie character varying NOT NULL,
    description_movie character varying NOT NULL,
    starring_movie character varying NOT NULL,
    manager_movie character varying NOT NULL,
    photo_movie bytea,
    view_movie integer DEFAULT 0,
    rating_movie integer DEFAULT 0,
    type_movie character varying
);


ALTER TABLE horisoes_peliculas.movie OWNER TO horisoes;

--
-- TOC entry 204 (class 1259 OID 24710)
-- Name: secuence_rol; Type: SEQUENCE; Schema: horisoes_peliculas; Owner: horisoes
--

CREATE SEQUENCE horisoes_peliculas.secuence_rol
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 9999999
    CACHE 1;


ALTER TABLE horisoes_peliculas.secuence_rol OWNER TO horisoes;

--
-- TOC entry 200 (class 1259 OID 16500)
-- Name: rol; Type: TABLE; Schema: horisoes_peliculas; Owner: horisoes
--

CREATE TABLE horisoes_peliculas.rol (
    id_rol integer DEFAULT nextval('horisoes_peliculas.secuence_rol'::regclass) NOT NULL,
    rol character varying NOT NULL
);


ALTER TABLE horisoes_peliculas.rol OWNER TO horisoes;

--
-- TOC entry 202 (class 1259 OID 24692)
-- Name: rol_menu; Type: TABLE; Schema: horisoes_peliculas; Owner: horisoes
--

CREATE TABLE horisoes_peliculas.rol_menu (
    id_rol integer NOT NULL,
    id_menu integer NOT NULL
);


ALTER TABLE horisoes_peliculas.rol_menu OWNER TO horisoes;

--
-- TOC entry 199 (class 1259 OID 16492)
-- Name: user; Type: TABLE; Schema: horisoes_peliculas; Owner: horisoes
--

CREATE TABLE horisoes_peliculas."user" (
    identification_user integer NOT NULL,
    password_user character varying NOT NULL,
    name_user character varying NOT NULL,
    id_rol integer
);


ALTER TABLE horisoes_peliculas."user" OWNER TO horisoes;

--
-- TOC entry 2196 (class 0 OID 24684)
-- Dependencies: 201
-- Data for Name: menu; Type: TABLE DATA; Schema: horisoes_peliculas; Owner: horisoes
--

COPY horisoes_peliculas.menu (id_menu, comand_menu, text_menu) FROM stdin;
1	#{directionBean.redirection('user')}	Usuario
3	#{directionBean.redirection('tvShow')}	Series
2	#{directionBean.redirection('movie')}	Películas y Series
\.


--
-- TOC entry 2193 (class 0 OID 16483)
-- Dependencies: 198
-- Data for Name: movie; Type: TABLE DATA; Schema: horisoes_peliculas; Owner: horisoes
--

COPY horisoes_peliculas.movie (id_movie, name_movie, description_movie, starring_movie, manager_movie, photo_movie, view_movie, rating_movie, type_movie) FROM stdin;
\.


--
-- TOC entry 2195 (class 0 OID 16500)
-- Dependencies: 200
-- Data for Name: rol; Type: TABLE DATA; Schema: horisoes_peliculas; Owner: horisoes
--

COPY horisoes_peliculas.rol (id_rol, rol) FROM stdin;
1	Admin
2	User
\.


--
-- TOC entry 2197 (class 0 OID 24692)
-- Dependencies: 202
-- Data for Name: rol_menu; Type: TABLE DATA; Schema: horisoes_peliculas; Owner: horisoes
--

COPY horisoes_peliculas.rol_menu (id_rol, id_menu) FROM stdin;
1	1
1	2
2	2
\.


--
-- TOC entry 2194 (class 0 OID 16492)
-- Dependencies: 199
-- Data for Name: user; Type: TABLE DATA; Schema: horisoes_peliculas; Owner: horisoes
--

COPY horisoes_peliculas."user" (identification_user, password_user, name_user, id_rol) FROM stdin;
1	1	prueba	2
123	123	Ricardo Zambrano	1
\.


--
-- TOC entry 2205 (class 0 OID 0)
-- Dependencies: 203
-- Name: secuence_menu; Type: SEQUENCE SET; Schema: horisoes_peliculas; Owner: horisoes
--

SELECT pg_catalog.setval('horisoes_peliculas.secuence_menu', 3, true);


--
-- TOC entry 2206 (class 0 OID 0)
-- Dependencies: 197
-- Name: secuence_movie; Type: SEQUENCE SET; Schema: horisoes_peliculas; Owner: horisoes
--

SELECT pg_catalog.setval('horisoes_peliculas.secuence_movie', 21, true);


--
-- TOC entry 2207 (class 0 OID 0)
-- Dependencies: 204
-- Name: secuence_rol; Type: SEQUENCE SET; Schema: horisoes_peliculas; Owner: horisoes
--

SELECT pg_catalog.setval('horisoes_peliculas.secuence_rol', 1, false);


--
-- TOC entry 2069 (class 2606 OID 24691)
-- Name: menu menu_pkey; Type: CONSTRAINT; Schema: horisoes_peliculas; Owner: horisoes
--

ALTER TABLE ONLY horisoes_peliculas.menu
    ADD CONSTRAINT menu_pkey PRIMARY KEY (id_menu);


--
-- TOC entry 2063 (class 2606 OID 16490)
-- Name: movie movie_pkey; Type: CONSTRAINT; Schema: horisoes_peliculas; Owner: horisoes
--

ALTER TABLE ONLY horisoes_peliculas.movie
    ADD CONSTRAINT movie_pkey PRIMARY KEY (id_movie);


--
-- TOC entry 2071 (class 2606 OID 24696)
-- Name: rol_menu rol_menu_pkey; Type: CONSTRAINT; Schema: horisoes_peliculas; Owner: horisoes
--

ALTER TABLE ONLY horisoes_peliculas.rol_menu
    ADD CONSTRAINT rol_menu_pkey PRIMARY KEY (id_rol, id_menu);


--
-- TOC entry 2067 (class 2606 OID 16507)
-- Name: rol rol_pkey; Type: CONSTRAINT; Schema: horisoes_peliculas; Owner: horisoes
--

ALTER TABLE ONLY horisoes_peliculas.rol
    ADD CONSTRAINT rol_pkey PRIMARY KEY (id_rol);


--
-- TOC entry 2065 (class 2606 OID 16499)
-- Name: user user_pkey; Type: CONSTRAINT; Schema: horisoes_peliculas; Owner: horisoes
--

ALTER TABLE ONLY horisoes_peliculas."user"
    ADD CONSTRAINT user_pkey PRIMARY KEY (identification_user);


--
-- TOC entry 2074 (class 2606 OID 24702)
-- Name: rol_menu id_menu; Type: FK CONSTRAINT; Schema: horisoes_peliculas; Owner: horisoes
--

ALTER TABLE ONLY horisoes_peliculas.rol_menu
    ADD CONSTRAINT id_menu FOREIGN KEY (id_rol) REFERENCES horisoes_peliculas.menu(id_menu);


--
-- TOC entry 2072 (class 2606 OID 16508)
-- Name: user id_rol; Type: FK CONSTRAINT; Schema: horisoes_peliculas; Owner: horisoes
--

ALTER TABLE ONLY horisoes_peliculas."user"
    ADD CONSTRAINT id_rol FOREIGN KEY (id_rol) REFERENCES horisoes_peliculas.rol(id_rol);


--
-- TOC entry 2073 (class 2606 OID 24697)
-- Name: rol_menu id_rol; Type: FK CONSTRAINT; Schema: horisoes_peliculas; Owner: horisoes
--

ALTER TABLE ONLY horisoes_peliculas.rol_menu
    ADD CONSTRAINT id_rol FOREIGN KEY (id_rol) REFERENCES horisoes_peliculas.rol(id_rol);


-- Completed on 2019-09-12 16:22:49

--
-- PostgreSQL database dump complete
--

