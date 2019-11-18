--
-- PostgreSQL database dump
--

-- Dumped from database version 11.6 (Debian 11.6-1.pgdg100+1)
-- Dumped by pg_dump version 12.1 (Debian 12.1-1.pgdg100+1)

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

SET default_tablespace = '';

--
-- Name: calendario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.calendario (
    idcalendario integer NOT NULL,
    fecha date NOT NULL
);


ALTER TABLE public.calendario OWNER TO postgres;

--
-- Name: herramientas; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.herramientas (
    idherramienta integer NOT NULL,
    nombre character varying(100) NOT NULL,
    cantidad integer NOT NULL
);


ALTER TABLE public.herramientas OWNER TO postgres;

--
-- Name: herramientasprocedimiento; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.herramientasprocedimiento (
    idprocedimiento integer NOT NULL,
    idherramienta integer NOT NULL
);


ALTER TABLE public.herramientasprocedimiento OWNER TO postgres;

--
-- Name: inventario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.inventario (
    codinventario character varying(10) NOT NULL,
    nombre character varying(150) NOT NULL,
    descripcion character varying(250),
    modelo character varying(100),
    numeroserie character varying(100),
    ano integer,
    condicion character varying(60),
    ubicacion character varying(100),
    vidautil integer,
    garantia bit(1) NOT NULL
);


ALTER TABLE public.inventario OWNER TO postgres;

--
-- Name: materiales; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.materiales (
    codmaterial character varying(10) NOT NULL,
    nombre character varying(50) NOT NULL,
    descripcion character varying(150),
    idproveedor character varying(10) NOT NULL,
    cantidad integer NOT NULL,
    costo numeric(10,0) NOT NULL
);


ALTER TABLE public.materiales OWNER TO postgres;

--
-- Name: materialesprocedimiento; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.materialesprocedimiento (
    idprocedimiento integer NOT NULL,
    codmaterial character varying(10) NOT NULL
);


ALTER TABLE public.materialesprocedimiento OWNER TO postgres;

--
-- Name: ordencompra; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.ordencompra (
    idcompra character varying(10) NOT NULL,
    codmaterial character varying(10) NOT NULL,
    cantidad integer NOT NULL,
    idstatus integer NOT NULL,
    fecha date NOT NULL
);


ALTER TABLE public.ordencompra OWNER TO postgres;

--
-- Name: ordentrabajo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.ordentrabajo (
    idordentrabajo character varying(10) NOT NULL,
    idsolicitud character varying(10) NOT NULL,
    idcalendario integer NOT NULL,
    idstatus integer NOT NULL,
    idpem integer NOT NULL,
    fechafin date
);


ALTER TABLE public.ordentrabajo OWNER TO postgres;

--
-- Name: pasos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pasos (
    idpaso integer NOT NULL,
    paso character varying(500) NOT NULL
);


ALTER TABLE public.pasos OWNER TO postgres;

--
-- Name: pasos_idpaso_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.pasos_idpaso_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.pasos_idpaso_seq OWNER TO postgres;

--
-- Name: pasos_idpaso_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.pasos_idpaso_seq OWNED BY public.pasos.idpaso;


--
-- Name: pasosprocedimientos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pasosprocedimientos (
    idprocedimiento integer NOT NULL,
    idpaso integer NOT NULL
);


ALTER TABLE public.pasosprocedimientos OWNER TO postgres;

--
-- Name: pem; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pem (
    idpem integer NOT NULL,
    idusuario integer NOT NULL,
    idprocedimiento integer NOT NULL
);


ALTER TABLE public.pem OWNER TO postgres;

--
-- Name: pem_idpem_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.pem_idpem_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.pem_idpem_seq OWNER TO postgres;

--
-- Name: pem_idpem_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.pem_idpem_seq OWNED BY public.pem.idpem;


--
-- Name: procedimiento; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.procedimiento (
    idprocedimiento integer NOT NULL,
    procedimiento character varying(250) NOT NULL
);


ALTER TABLE public.procedimiento OWNER TO postgres;

--
-- Name: procedimiento_idprocedimiento_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.procedimiento_idprocedimiento_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.procedimiento_idprocedimiento_seq OWNER TO postgres;

--
-- Name: procedimiento_idprocedimiento_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.procedimiento_idprocedimiento_seq OWNED BY public.procedimiento.idprocedimiento;


--
-- Name: procedimientosmantenimiento; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.procedimientosmantenimiento (
    idpromant character varying(10) NOT NULL,
    descripcion character varying(100) NOT NULL
);


ALTER TABLE public.procedimientosmantenimiento OWNER TO postgres;

--
-- Name: proveedores; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.proveedores (
    idproveedor character varying(10) NOT NULL,
    nombre character varying(100) NOT NULL,
    telefono character varying(8)
);


ALTER TABLE public.proveedores OWNER TO postgres;

--
-- Name: rol; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.rol (
    idrol integer NOT NULL,
    rol character varying(100) NOT NULL
);


ALTER TABLE public.rol OWNER TO postgres;

--
-- Name: rol_idrol_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.rol_idrol_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.rol_idrol_seq OWNER TO postgres;

--
-- Name: rol_idrol_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.rol_idrol_seq OWNED BY public.rol.idrol;


--
-- Name: solicitudordentrabajo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.solicitudordentrabajo (
    idsolicitud character varying(10) NOT NULL,
    idusuario integer NOT NULL,
    codinventario character varying(10) NOT NULL,
    idpromant character varying(10) NOT NULL,
    numero integer,
    fechasolicitud date NOT NULL,
    tipofalla numeric(10,0) NOT NULL,
    descripcion integer NOT NULL
);


ALTER TABLE public.solicitudordentrabajo OWNER TO postgres;

--
-- Name: status; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.status (
    idstatus integer NOT NULL,
    estado character varying(50) NOT NULL
);


ALTER TABLE public.status OWNER TO postgres;

--
-- Name: status_idstatus_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.status_idstatus_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.status_idstatus_seq OWNER TO postgres;

--
-- Name: status_idstatus_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.status_idstatus_seq OWNED BY public.status.idstatus;


--
-- Name: usuarios; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuarios (
    idusuario integer NOT NULL,
    username character varying(20) NOT NULL,
    nombres character varying(100) NOT NULL,
    apellidos character varying(250) NOT NULL,
    idrol integer NOT NULL
);


ALTER TABLE public.usuarios OWNER TO postgres;

--
-- Name: usuarios_idusuario_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.usuarios_idusuario_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.usuarios_idusuario_seq OWNER TO postgres;

--
-- Name: usuarios_idusuario_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.usuarios_idusuario_seq OWNED BY public.usuarios.idusuario;


--
-- Name: pasos idpaso; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pasos ALTER COLUMN idpaso SET DEFAULT nextval('public.pasos_idpaso_seq'::regclass);


--
-- Name: pem idpem; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pem ALTER COLUMN idpem SET DEFAULT nextval('public.pem_idpem_seq'::regclass);


--
-- Name: procedimiento idprocedimiento; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.procedimiento ALTER COLUMN idprocedimiento SET DEFAULT nextval('public.procedimiento_idprocedimiento_seq'::regclass);


--
-- Name: rol idrol; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rol ALTER COLUMN idrol SET DEFAULT nextval('public.rol_idrol_seq'::regclass);


--
-- Name: status idstatus; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.status ALTER COLUMN idstatus SET DEFAULT nextval('public.status_idstatus_seq'::regclass);


--
-- Name: usuarios idusuario; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuarios ALTER COLUMN idusuario SET DEFAULT nextval('public.usuarios_idusuario_seq'::regclass);


--
-- Data for Name: calendario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.calendario (idcalendario, fecha) FROM stdin;
\.


--
-- Data for Name: herramientas; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.herramientas (idherramienta, nombre, cantidad) FROM stdin;
\.


--
-- Data for Name: herramientasprocedimiento; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.herramientasprocedimiento (idprocedimiento, idherramienta) FROM stdin;
\.


--
-- Data for Name: inventario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.inventario (codinventario, nombre, descripcion, modelo, numeroserie, ano, condicion, ubicacion, vidautil, garantia) FROM stdin;
\.


--
-- Data for Name: materiales; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.materiales (codmaterial, nombre, descripcion, idproveedor, cantidad, costo) FROM stdin;
\.


--
-- Data for Name: materialesprocedimiento; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.materialesprocedimiento (idprocedimiento, codmaterial) FROM stdin;
\.


--
-- Data for Name: ordencompra; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.ordencompra (idcompra, codmaterial, cantidad, idstatus, fecha) FROM stdin;
\.


--
-- Data for Name: ordentrabajo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.ordentrabajo (idordentrabajo, idsolicitud, idcalendario, idstatus, idpem, fechafin) FROM stdin;
\.


--
-- Data for Name: pasos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.pasos (idpaso, paso) FROM stdin;
\.


--
-- Data for Name: pasosprocedimientos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.pasosprocedimientos (idprocedimiento, idpaso) FROM stdin;
\.


--
-- Data for Name: pem; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.pem (idpem, idusuario, idprocedimiento) FROM stdin;
\.


--
-- Data for Name: procedimiento; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.procedimiento (idprocedimiento, procedimiento) FROM stdin;
\.


--
-- Data for Name: procedimientosmantenimiento; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.procedimientosmantenimiento (idpromant, descripcion) FROM stdin;
\.


--
-- Data for Name: proveedores; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.proveedores (idproveedor, nombre, telefono) FROM stdin;
\.


--
-- Data for Name: rol; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.rol (idrol, rol) FROM stdin;
\.


--
-- Data for Name: solicitudordentrabajo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.solicitudordentrabajo (idsolicitud, idusuario, codinventario, idpromant, numero, fechasolicitud, tipofalla, descripcion) FROM stdin;
\.


--
-- Data for Name: status; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.status (idstatus, estado) FROM stdin;
\.


--
-- Data for Name: usuarios; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.usuarios (idusuario, username, nombres, apellidos, idrol) FROM stdin;
\.


--
-- Name: pasos_idpaso_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.pasos_idpaso_seq', 1, false);


--
-- Name: pem_idpem_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.pem_idpem_seq', 1, false);


--
-- Name: procedimiento_idprocedimiento_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.procedimiento_idprocedimiento_seq', 1, false);


--
-- Name: rol_idrol_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.rol_idrol_seq', 1, false);


--
-- Name: status_idstatus_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.status_idstatus_seq', 1, false);


--
-- Name: usuarios_idusuario_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.usuarios_idusuario_seq', 1, false);


--
-- Name: calendario calendario_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.calendario
    ADD CONSTRAINT calendario_pk PRIMARY KEY (idcalendario);


--
-- Name: herramientas herramientas_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.herramientas
    ADD CONSTRAINT herramientas_pk PRIMARY KEY (idherramienta);


--
-- Name: herramientasprocedimiento herramientasprocedimiento_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.herramientasprocedimiento
    ADD CONSTRAINT herramientasprocedimiento_pk PRIMARY KEY (idprocedimiento, idherramienta);


--
-- Name: inventario inventario_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.inventario
    ADD CONSTRAINT inventario_pk PRIMARY KEY (codinventario);


--
-- Name: materiales materiales_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.materiales
    ADD CONSTRAINT materiales_pk PRIMARY KEY (codmaterial);


--
-- Name: materialesprocedimiento materialesprocedimiento_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.materialesprocedimiento
    ADD CONSTRAINT materialesprocedimiento_pk PRIMARY KEY (idprocedimiento, codmaterial);


--
-- Name: ordencompra ordencompra_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ordencompra
    ADD CONSTRAINT ordencompra_pk PRIMARY KEY (idcompra);


--
-- Name: ordentrabajo ordentrabajo_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ordentrabajo
    ADD CONSTRAINT ordentrabajo_pk PRIMARY KEY (idordentrabajo);


--
-- Name: pasos pasos_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pasos
    ADD CONSTRAINT pasos_pk PRIMARY KEY (idpaso);


--
-- Name: pasosprocedimientos pasosprocedimientos_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pasosprocedimientos
    ADD CONSTRAINT pasosprocedimientos_pk PRIMARY KEY (idprocedimiento, idpaso);


--
-- Name: pem pem_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pem
    ADD CONSTRAINT pem_pk PRIMARY KEY (idpem);


--
-- Name: procedimiento procedimiento_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.procedimiento
    ADD CONSTRAINT procedimiento_pk PRIMARY KEY (idprocedimiento);


--
-- Name: procedimientosmantenimiento procedimientosmantenimiento_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.procedimientosmantenimiento
    ADD CONSTRAINT procedimientosmantenimiento_pk PRIMARY KEY (idpromant);


--
-- Name: proveedores proveedores_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.proveedores
    ADD CONSTRAINT proveedores_pk PRIMARY KEY (idproveedor);


--
-- Name: rol rol_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.rol
    ADD CONSTRAINT rol_pk PRIMARY KEY (idrol);


--
-- Name: solicitudordentrabajo solicitudordentrabajo_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.solicitudordentrabajo
    ADD CONSTRAINT solicitudordentrabajo_pk PRIMARY KEY (idsolicitud);


--
-- Name: status status_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.status
    ADD CONSTRAINT status_pk PRIMARY KEY (idstatus);


--
-- Name: usuarios usuarios_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT usuarios_pk PRIMARY KEY (idusuario);


--
-- Name: codinventario; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX codinventario ON public.solicitudordentrabajo USING btree (codinventario);


--
-- Name: codmaterial; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX codmaterial ON public.ordencompra USING btree (codmaterial);


--
-- Name: idcalendario; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX idcalendario ON public.ordentrabajo USING btree (idcalendario);


--
-- Name: idherramienta; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX idherramienta ON public.herramientasprocedimiento USING btree (idherramienta);


--
-- Name: idpaso; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX idpaso ON public.pasosprocedimientos USING btree (idpaso);


--
-- Name: idpem; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX idpem ON public.ordentrabajo USING btree (idpem);


--
-- Name: idprocedimiento; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX idprocedimiento ON public.pem USING btree (idprocedimiento);


--
-- Name: idpromant; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX idpromant ON public.solicitudordentrabajo USING btree (idpromant);


--
-- Name: idproveedor; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX idproveedor ON public.materiales USING btree (idproveedor);


--
-- Name: idresponsable; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX idresponsable ON public.pem USING btree (idusuario);


--
-- Name: idrol; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX idrol ON public.usuarios USING btree (idrol);


--
-- Name: idsolicitud; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX idsolicitud ON public.ordentrabajo USING btree (idsolicitud);


--
-- Name: idstatus; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX idstatus ON public.ordencompra USING btree (idstatus);


--
-- Name: idusuario; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX idusuario ON public.solicitudordentrabajo USING btree (idusuario);


--
-- Name: herramientasprocedimiento herramientasprocedimiento_ibfk_1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.herramientasprocedimiento
    ADD CONSTRAINT herramientasprocedimiento_ibfk_1 FOREIGN KEY (idherramienta) REFERENCES public.herramientas(idherramienta);


--
-- Name: herramientasprocedimiento herramientasprocedimiento_ibfk_2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.herramientasprocedimiento
    ADD CONSTRAINT herramientasprocedimiento_ibfk_2 FOREIGN KEY (idprocedimiento) REFERENCES public.procedimiento(idprocedimiento);


--
-- Name: materiales materiales_ibfk_1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.materiales
    ADD CONSTRAINT materiales_ibfk_1 FOREIGN KEY (idproveedor) REFERENCES public.proveedores(idproveedor);


--
-- Name: materialesprocedimiento materialesprocedimiento_ibfk_1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.materialesprocedimiento
    ADD CONSTRAINT materialesprocedimiento_ibfk_1 FOREIGN KEY (codmaterial) REFERENCES public.materiales(codmaterial);


--
-- Name: materialesprocedimiento materialesprocedimiento_ibfk_2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.materialesprocedimiento
    ADD CONSTRAINT materialesprocedimiento_ibfk_2 FOREIGN KEY (idprocedimiento) REFERENCES public.procedimiento(idprocedimiento) NOT VALID;


--
-- Name: ordencompra ordencompra_ibfk_1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ordencompra
    ADD CONSTRAINT ordencompra_ibfk_1 FOREIGN KEY (codmaterial) REFERENCES public.materiales(codmaterial);


--
-- Name: ordencompra ordencompra_ibfk_2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ordencompra
    ADD CONSTRAINT ordencompra_ibfk_2 FOREIGN KEY (idstatus) REFERENCES public.status(idstatus);


--
-- Name: ordentrabajo ordentrabajo_ibfk_1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ordentrabajo
    ADD CONSTRAINT ordentrabajo_ibfk_1 FOREIGN KEY (idsolicitud) REFERENCES public.solicitudordentrabajo(idsolicitud);


--
-- Name: ordentrabajo ordentrabajo_ibfk_2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ordentrabajo
    ADD CONSTRAINT ordentrabajo_ibfk_2 FOREIGN KEY (idcalendario) REFERENCES public.calendario(idcalendario);


--
-- Name: ordentrabajo ordentrabajo_ibfk_3; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ordentrabajo
    ADD CONSTRAINT ordentrabajo_ibfk_3 FOREIGN KEY (idstatus) REFERENCES public.status(idstatus) NOT VALID;


--
-- Name: ordentrabajo ordentrabajo_ibfk_4; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ordentrabajo
    ADD CONSTRAINT ordentrabajo_ibfk_4 FOREIGN KEY (idpem) REFERENCES public.pem(idpem);


--
-- Name: pasosprocedimientos pasosprocedimientos_ibfk_1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pasosprocedimientos
    ADD CONSTRAINT pasosprocedimientos_ibfk_1 FOREIGN KEY (idpaso) REFERENCES public.pasos(idpaso);


--
-- Name: pasosprocedimientos pasosprocedimientos_ibfk_2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pasosprocedimientos
    ADD CONSTRAINT pasosprocedimientos_ibfk_2 FOREIGN KEY (idprocedimiento) REFERENCES public.procedimiento(idprocedimiento) NOT VALID;


--
-- Name: pem pem_ibfk_1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pem
    ADD CONSTRAINT pem_ibfk_1 FOREIGN KEY (idprocedimiento) REFERENCES public.procedimiento(idprocedimiento) NOT VALID;


--
-- Name: pem pem_ibfk_2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pem
    ADD CONSTRAINT pem_ibfk_2 FOREIGN KEY (idusuario) REFERENCES public.usuarios(idusuario);


--
-- Name: solicitudordentrabajo solicitudordentrabajo_ibfk_1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.solicitudordentrabajo
    ADD CONSTRAINT solicitudordentrabajo_ibfk_1 FOREIGN KEY (idusuario) REFERENCES public.usuarios(idusuario) NOT VALID;


--
-- Name: solicitudordentrabajo solicitudordentrabajo_ibfk_2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.solicitudordentrabajo
    ADD CONSTRAINT solicitudordentrabajo_ibfk_2 FOREIGN KEY (codinventario) REFERENCES public.inventario(codinventario);


--
-- Name: solicitudordentrabajo solicitudordentrabajo_ibfk_3; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.solicitudordentrabajo
    ADD CONSTRAINT solicitudordentrabajo_ibfk_3 FOREIGN KEY (idpromant) REFERENCES public.procedimientosmantenimiento(idpromant);


--
-- Name: usuarios usuarios_ibfk_1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT usuarios_ibfk_1 FOREIGN KEY (idrol) REFERENCES public.rol(idrol);


--
-- PostgreSQL database dump complete
--

