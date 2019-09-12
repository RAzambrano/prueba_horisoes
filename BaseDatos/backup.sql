PGDMP     "    1                w            postgres    9.6.5    11.3     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false            �           1262    12401    postgres    DATABASE     �   CREATE DATABASE postgres WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Spanish_Spain.1252' LC_CTYPE = 'Spanish_Spain.1252';
    DROP DATABASE postgres;
             postgres    false            �           0    0    DATABASE postgres    COMMENT     N   COMMENT ON DATABASE postgres IS 'default administrative connection database';
                  postgres    false    2205                        2615    16480    horisoes_peliculas    SCHEMA     "   CREATE SCHEMA horisoes_peliculas;
     DROP SCHEMA horisoes_peliculas;
             horisoes    false            �            1259    24707    secuence_menu    SEQUENCE     �   CREATE SEQUENCE horisoes_peliculas.secuence_menu
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 99999999
    CACHE 1;
 0   DROP SEQUENCE horisoes_peliculas.secuence_menu;
       horisoes_peliculas       horisoes    false    5            �            1259    24684    menu    TABLE     �   CREATE TABLE horisoes_peliculas.menu (
    id_menu integer DEFAULT nextval('horisoes_peliculas.secuence_menu'::regclass) NOT NULL,
    comand_menu character varying NOT NULL,
    text_menu character varying NOT NULL
);
 $   DROP TABLE horisoes_peliculas.menu;
       horisoes_peliculas         horisoes    false    203    5            �            1259    16481    secuence_movie    SEQUENCE     �   CREATE SEQUENCE horisoes_peliculas.secuence_movie
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 99999999
    CACHE 1;
 1   DROP SEQUENCE horisoes_peliculas.secuence_movie;
       horisoes_peliculas       horisoes    false    5            �            1259    16483    movie    TABLE     �  CREATE TABLE horisoes_peliculas.movie (
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
 %   DROP TABLE horisoes_peliculas.movie;
       horisoes_peliculas         horisoes    false    197    5            �            1259    24710    secuence_rol    SEQUENCE     �   CREATE SEQUENCE horisoes_peliculas.secuence_rol
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 9999999
    CACHE 1;
 /   DROP SEQUENCE horisoes_peliculas.secuence_rol;
       horisoes_peliculas       horisoes    false    5            �            1259    16500    rol    TABLE     �   CREATE TABLE horisoes_peliculas.rol (
    id_rol integer DEFAULT nextval('horisoes_peliculas.secuence_rol'::regclass) NOT NULL,
    rol character varying NOT NULL
);
 #   DROP TABLE horisoes_peliculas.rol;
       horisoes_peliculas         horisoes    false    204    5            �            1259    24692    rol_menu    TABLE     h   CREATE TABLE horisoes_peliculas.rol_menu (
    id_rol integer NOT NULL,
    id_menu integer NOT NULL
);
 (   DROP TABLE horisoes_peliculas.rol_menu;
       horisoes_peliculas         horisoes    false    5            �            1259    16492    user    TABLE     �   CREATE TABLE horisoes_peliculas."user" (
    identification_user integer NOT NULL,
    password_user character varying NOT NULL,
    name_user character varying NOT NULL,
    id_rol integer
);
 &   DROP TABLE horisoes_peliculas."user";
       horisoes_peliculas         horisoes    false    5            �          0    24684    menu 
   TABLE DATA               K   COPY horisoes_peliculas.menu (id_menu, comand_menu, text_menu) FROM stdin;
    horisoes_peliculas       horisoes    false    201   �"       �          0    16483    movie 
   TABLE DATA               �   COPY horisoes_peliculas.movie (id_movie, name_movie, description_movie, starring_movie, manager_movie, photo_movie, view_movie, rating_movie, type_movie) FROM stdin;
    horisoes_peliculas       horisoes    false    198   1#       �          0    16500    rol 
   TABLE DATA               6   COPY horisoes_peliculas.rol (id_rol, rol) FROM stdin;
    horisoes_peliculas       horisoes    false    200   N#       �          0    24692    rol_menu 
   TABLE DATA               ?   COPY horisoes_peliculas.rol_menu (id_rol, id_menu) FROM stdin;
    horisoes_peliculas       horisoes    false    202   z#       �          0    16492    user 
   TABLE DATA               c   COPY horisoes_peliculas."user" (identification_user, password_user, name_user, id_rol) FROM stdin;
    horisoes_peliculas       horisoes    false    199   �#       �           0    0    secuence_menu    SEQUENCE SET     G   SELECT pg_catalog.setval('horisoes_peliculas.secuence_menu', 3, true);
            horisoes_peliculas       horisoes    false    203            �           0    0    secuence_movie    SEQUENCE SET     I   SELECT pg_catalog.setval('horisoes_peliculas.secuence_movie', 21, true);
            horisoes_peliculas       horisoes    false    197            �           0    0    secuence_rol    SEQUENCE SET     G   SELECT pg_catalog.setval('horisoes_peliculas.secuence_rol', 1, false);
            horisoes_peliculas       horisoes    false    204                       2606    24691    menu menu_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY horisoes_peliculas.menu
    ADD CONSTRAINT menu_pkey PRIMARY KEY (id_menu);
 D   ALTER TABLE ONLY horisoes_peliculas.menu DROP CONSTRAINT menu_pkey;
       horisoes_peliculas         horisoes    false    201                       2606    16490    movie movie_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY horisoes_peliculas.movie
    ADD CONSTRAINT movie_pkey PRIMARY KEY (id_movie);
 F   ALTER TABLE ONLY horisoes_peliculas.movie DROP CONSTRAINT movie_pkey;
       horisoes_peliculas         horisoes    false    198                       2606    24696    rol_menu rol_menu_pkey 
   CONSTRAINT     m   ALTER TABLE ONLY horisoes_peliculas.rol_menu
    ADD CONSTRAINT rol_menu_pkey PRIMARY KEY (id_rol, id_menu);
 L   ALTER TABLE ONLY horisoes_peliculas.rol_menu DROP CONSTRAINT rol_menu_pkey;
       horisoes_peliculas         horisoes    false    202    202                       2606    16507    rol rol_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY horisoes_peliculas.rol
    ADD CONSTRAINT rol_pkey PRIMARY KEY (id_rol);
 B   ALTER TABLE ONLY horisoes_peliculas.rol DROP CONSTRAINT rol_pkey;
       horisoes_peliculas         horisoes    false    200                       2606    16499    user user_pkey 
   CONSTRAINT     k   ALTER TABLE ONLY horisoes_peliculas."user"
    ADD CONSTRAINT user_pkey PRIMARY KEY (identification_user);
 F   ALTER TABLE ONLY horisoes_peliculas."user" DROP CONSTRAINT user_pkey;
       horisoes_peliculas         horisoes    false    199                       2606    24702    rol_menu id_menu    FK CONSTRAINT     �   ALTER TABLE ONLY horisoes_peliculas.rol_menu
    ADD CONSTRAINT id_menu FOREIGN KEY (id_rol) REFERENCES horisoes_peliculas.menu(id_menu);
 F   ALTER TABLE ONLY horisoes_peliculas.rol_menu DROP CONSTRAINT id_menu;
       horisoes_peliculas       horisoes    false    202    2069    201                       2606    16508    user id_rol    FK CONSTRAINT     �   ALTER TABLE ONLY horisoes_peliculas."user"
    ADD CONSTRAINT id_rol FOREIGN KEY (id_rol) REFERENCES horisoes_peliculas.rol(id_rol);
 C   ALTER TABLE ONLY horisoes_peliculas."user" DROP CONSTRAINT id_rol;
       horisoes_peliculas       horisoes    false    200    2067    199                       2606    24697    rol_menu id_rol    FK CONSTRAINT     �   ALTER TABLE ONLY horisoes_peliculas.rol_menu
    ADD CONSTRAINT id_rol FOREIGN KEY (id_rol) REFERENCES horisoes_peliculas.rol(id_rol);
 E   ALTER TABLE ONLY horisoes_peliculas.rol_menu DROP CONSTRAINT id_rol;
       horisoes_peliculas       horisoes    false    2067    200    202            �   `   x�3�T�N�,JM.���sJM��+J��5�K�S��5k9C�K�2��+/)��/iN-�L-�2¯>7�,3�< 5����Ҝ�b�J��=... �]8B      �      x������ � �      �      x�3�tL����2�-N-����� 6��      �      x�3�4�2�4�2�=... $      �   2   x�3�4�,(*MMJ�4�242����Ģ�|���ܤ�ļ|NC�=... 	��     