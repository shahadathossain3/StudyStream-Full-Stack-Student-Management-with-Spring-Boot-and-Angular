--
-- PostgreSQL database dump
--

-- Dumped from database version 15.4 (Ubuntu 15.4-1.pgdg20.04+1)
-- Dumped by pg_dump version 15.4 (Ubuntu 15.4-1.pgdg20.04+1)

-- Started on 2023-09-23 00:38:33 +06

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

DROP DATABASE "student-management";
--
-- TOC entry 3453 (class 1262 OID 37076)
-- Name: student-management; Type: DATABASE; Schema: -; Owner: testuser
--

CREATE DATABASE "student-management" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'en_US.UTF-8';


ALTER DATABASE "student-management" OWNER TO testuser;

\connect -reuse-previous=on "dbname='student-management'"

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
-- TOC entry 3425 (class 0 OID 38068)
-- Dependencies: 215
-- Data for Name: attendance; Type: TABLE DATA; Schema: public; Owner: testuser
--



--
-- TOC entry 3427 (class 0 OID 38074)
-- Dependencies: 217
-- Data for Name: classroom; Type: TABLE DATA; Schema: public; Owner: testuser
--

INSERT INTO public.classroom (id, room_number) VALUES (1, '101') ON CONFLICT DO NOTHING;
INSERT INTO public.classroom (id, room_number) VALUES (2, '102') ON CONFLICT DO NOTHING;
INSERT INTO public.classroom (id, room_number) VALUES (3, '103') ON CONFLICT DO NOTHING;
INSERT INTO public.classroom (id, room_number) VALUES (4, '104') ON CONFLICT DO NOTHING;
INSERT INTO public.classroom (id, room_number) VALUES (5, '105') ON CONFLICT DO NOTHING;


--
-- TOC entry 3429 (class 0 OID 38080)
-- Dependencies: 219
-- Data for Name: enrollment; Type: TABLE DATA; Schema: public; Owner: testuser
--

INSERT INTO public.enrollment (id, sections_id, students_id, teacher_id) VALUES (1, 5, 2, NULL) ON CONFLICT DO NOTHING;
INSERT INTO public.enrollment (id, sections_id, students_id, teacher_id) VALUES (2, 6, 2, NULL) ON CONFLICT DO NOTHING;
INSERT INTO public.enrollment (id, sections_id, students_id, teacher_id) VALUES (3, 7, 2, NULL) ON CONFLICT DO NOTHING;
INSERT INTO public.enrollment (id, sections_id, students_id, teacher_id) VALUES (4, 5, NULL, 3) ON CONFLICT DO NOTHING;


--
-- TOC entry 3431 (class 0 OID 38086)
-- Dependencies: 221
-- Data for Name: examination; Type: TABLE DATA; Schema: public; Owner: testuser
--

INSERT INTO public.examination (id, date, name, "time", type, classroom_id, subjects_id) VALUES (1, '2022-11-09 06:00:00', 'Year 2022', '09:59:00', 'final_term', 1, 1) ON CONFLICT DO NOTHING;
INSERT INTO public.examination (id, date, name, "time", type, classroom_id, subjects_id) VALUES (2, '2022-11-09 06:00:00', 'Year 2022', '10:00:00', 'final_term', 2, 2) ON CONFLICT DO NOTHING;
INSERT INTO public.examination (id, date, name, "time", type, classroom_id, subjects_id) VALUES (3, '2022-11-09 06:00:00', 'Year 2022', '10:00:00', 'final_term', 2, 3) ON CONFLICT DO NOTHING;


--
-- TOC entry 3433 (class 0 OID 38094)
-- Dependencies: 223
-- Data for Name: notices; Type: TABLE DATA; Schema: public; Owner: testuser
--



--
-- TOC entry 3435 (class 0 OID 38100)
-- Dependencies: 225
-- Data for Name: result; Type: TABLE DATA; Schema: public; Owner: testuser
--



--
-- TOC entry 3437 (class 0 OID 38106)
-- Dependencies: 227
-- Data for Name: roles; Type: TABLE DATA; Schema: public; Owner: testuser
--

INSERT INTO public.roles (id, name) VALUES (1, 'ROLE_ADMIN') ON CONFLICT DO NOTHING;


--
-- TOC entry 3439 (class 0 OID 38112)
-- Dependencies: 229
-- Data for Name: sections; Type: TABLE DATA; Schema: public; Owner: testuser
--

INSERT INTO public.sections (id, day, name, "time", classroom_id, subjects_id) VALUES (5, 0, 'Day', '11:00:00', 1, 1) ON CONFLICT DO NOTHING;
INSERT INTO public.sections (id, day, name, "time", classroom_id, subjects_id) VALUES (6, 0, 'Day', '12:00:00', 2, 2) ON CONFLICT DO NOTHING;
INSERT INTO public.sections (id, day, name, "time", classroom_id, subjects_id) VALUES (7, 1, 'Day', '10:00:00', 4, 3) ON CONFLICT DO NOTHING;


--
-- TOC entry 3440 (class 0 OID 38117)
-- Dependencies: 230
-- Data for Name: students; Type: TABLE DATA; Schema: public; Owner: testuser
--

INSERT INTO public.students (address, date_of_birth, date_of_join, father_name, first_name, gender, last_name, mother_name, phone, studentid, id) VALUES ('Address Example', '1998-09-22 06:00:00', '2022-02-22 06:00:00', 'Student Father', 'Mr', NULL, 'Student', 'Student Mother', '123457890', 'student123', 2) ON CONFLICT DO NOTHING;


--
-- TOC entry 3442 (class 0 OID 38125)
-- Dependencies: 232
-- Data for Name: subjects; Type: TABLE DATA; Schema: public; Owner: testuser
--

INSERT INTO public.subjects (id, code, name) VALUES (1, 'Bangla123', 'Bangla') ON CONFLICT DO NOTHING;
INSERT INTO public.subjects (id, code, name) VALUES (2, 'English123', 'English') ON CONFLICT DO NOTHING;
INSERT INTO public.subjects (id, code, name) VALUES (3, 'Mathematics123', 'Mathematics') ON CONFLICT DO NOTHING;


--
-- TOC entry 3443 (class 0 OID 38132)
-- Dependencies: 233
-- Data for Name: teachers; Type: TABLE DATA; Schema: public; Owner: testuser
--

INSERT INTO public.teachers (address, date_of_join, first_name, gender, last_name, mobile, teacherid, id) VALUES ('Address Example', '2010-07-08 06:00:00', 'Mr', 'male', 'Teacher', NULL, 'teacher123', 3) ON CONFLICT DO NOTHING;


--
-- TOC entry 3445 (class 0 OID 38140)
-- Dependencies: 235
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: testuser
--

INSERT INTO public.users (id, password, username) VALUES (1, '$2y$10$/EkiGyZ.MkQN47ZR/Q.Wn.CQEn/I1Uq5Spl8SQkayJz...mWppVjC', 'admin123') ON CONFLICT DO NOTHING;
INSERT INTO public.users (id, password, username) VALUES (2, '$2a$10$7ncaIVOlycfSF2Ew5CIl8OXAcUGF8GVOWgeMz.axJJvunmkHxd23W', 'student123') ON CONFLICT DO NOTHING;
INSERT INTO public.users (id, password, username) VALUES (3, '$2a$10$8glRWfeZnDmBKxvqgQsob.ylZPMliMxeTMmEab.C3VnahHWk9W.IW', 'teacher123') ON CONFLICT DO NOTHING;


--
-- TOC entry 3447 (class 0 OID 38148)
-- Dependencies: 237
-- Data for Name: users_roles; Type: TABLE DATA; Schema: public; Owner: testuser
--

INSERT INTO public.users_roles (id, name, users_id, roles_id) VALUES (1, '', 1, 1) ON CONFLICT DO NOTHING;


--
-- TOC entry 3454 (class 0 OID 0)
-- Dependencies: 214
-- Name: attendance_id_seq; Type: SEQUENCE SET; Schema: public; Owner: testuser
--

SELECT pg_catalog.setval('public.attendance_id_seq', 1, false);


--
-- TOC entry 3455 (class 0 OID 0)
-- Dependencies: 216
-- Name: classroom_id_seq; Type: SEQUENCE SET; Schema: public; Owner: testuser
--

SELECT pg_catalog.setval('public.classroom_id_seq', 5, true);


--
-- TOC entry 3456 (class 0 OID 0)
-- Dependencies: 218
-- Name: enrollment_id_seq; Type: SEQUENCE SET; Schema: public; Owner: testuser
--

SELECT pg_catalog.setval('public.enrollment_id_seq', 4, true);


--
-- TOC entry 3457 (class 0 OID 0)
-- Dependencies: 220
-- Name: examination_id_seq; Type: SEQUENCE SET; Schema: public; Owner: testuser
--

SELECT pg_catalog.setval('public.examination_id_seq', 3, true);


--
-- TOC entry 3458 (class 0 OID 0)
-- Dependencies: 222
-- Name: notices_id_seq; Type: SEQUENCE SET; Schema: public; Owner: testuser
--

SELECT pg_catalog.setval('public.notices_id_seq', 1, false);


--
-- TOC entry 3459 (class 0 OID 0)
-- Dependencies: 224
-- Name: result_id_seq; Type: SEQUENCE SET; Schema: public; Owner: testuser
--

SELECT pg_catalog.setval('public.result_id_seq', 1, false);


--
-- TOC entry 3460 (class 0 OID 0)
-- Dependencies: 226
-- Name: roles_id_seq; Type: SEQUENCE SET; Schema: public; Owner: testuser
--

SELECT pg_catalog.setval('public.roles_id_seq', 1, false);


--
-- TOC entry 3461 (class 0 OID 0)
-- Dependencies: 228
-- Name: sections_id_seq; Type: SEQUENCE SET; Schema: public; Owner: testuser
--

SELECT pg_catalog.setval('public.sections_id_seq', 7, true);


--
-- TOC entry 3462 (class 0 OID 0)
-- Dependencies: 231
-- Name: subjects_id_seq; Type: SEQUENCE SET; Schema: public; Owner: testuser
--

SELECT pg_catalog.setval('public.subjects_id_seq', 3, true);


--
-- TOC entry 3463 (class 0 OID 0)
-- Dependencies: 234
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: testuser
--

SELECT pg_catalog.setval('public.users_id_seq', 3, true);


--
-- TOC entry 3464 (class 0 OID 0)
-- Dependencies: 236
-- Name: users_roles_id_seq; Type: SEQUENCE SET; Schema: public; Owner: testuser
--

SELECT pg_catalog.setval('public.users_roles_id_seq', 1, false);


-- Completed on 2023-09-23 00:38:33 +06

--
-- PostgreSQL database dump complete
--

