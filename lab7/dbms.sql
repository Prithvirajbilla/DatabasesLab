--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: castings; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE castings (
    moviename character varying(225),
    actor character varying(225)
);


ALTER TABLE public.castings OWNER TO postgres;

--
-- Name: movie; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE movie (
    moviename character varying(225) NOT NULL,
    yearofrelease integer,
    producer character varying(225),
    director character varying(225)
);


ALTER TABLE public.movie OWNER TO postgres;

--
-- Name: movieawards; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE movieawards (
    moviename character varying(225),
    yearofaward integer,
    awardname character varying(225)
);


ALTER TABLE public.movieawards OWNER TO postgres;

--
-- Name: movieperson; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE movieperson (
    name character varying(225) NOT NULL,
    address character varying(225),
    phonenumber character varying(225),
    emailid character varying(225)
);


ALTER TABLE public.movieperson OWNER TO postgres;

--
-- Name: users; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE users (
    username character varying(20) NOT NULL,
    password character varying(20) NOT NULL,
    role character varying(6) NOT NULL
);


ALTER TABLE public.users OWNER TO postgres;

--
-- Data for Name: castings; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY castings (moviename, actor) FROM stdin;
Dead Mans Chest	Johnny Depp
Dead Mans Chest	Orlando Bloom
Dead Mans Chest	Keira Knightley
The Da vinci code	Tom Hanks
The Da vinci code	Audrey TautouIan
The Da vinci code	McKellen
Mission Impossible II	Tom Cruise
Mission Impossible II	Dougray Scott
Mission Impossible II	Thandie Newton
The Meltdown	Ray Romano
The Meltdown	John Leguizamo
The Meltdown	Denis Leary
Casino Royale	Daniel Craig
Casino Royale	Eva Green
Casino Royale	Mads Mikkelsen
Harry Potter and the Goblet of Fire	Daniel Radcliffe
Harry Potter and the Goblet of Fire	Rupert Grint
Harry Potter and the Goblet of Fire	Emma Watson
Night at the museum	Ben Stiller
Night at the museum	Owen Wilson
Night at the museum	Carla Gugino
Gladiator	Russell Crowe
Gladiator	Joaquin Phoenix
Revenge of the Sith	Ewan McGregor
Revenge of the Sith	Natalie Portman
Revenge of the Sith	Hayden Christensen
Revenge of the Sith	Ian McDiarmid
Revenge of the Sith	Samuel L. Jackson
Revenge of the Sith	Christopher Lee
Revenge of the Sith	Anthony Daniels
Revenge of the Sith	Kenny Baker
Revenge of the Sith	Frank Oz
Cast Away	Tom Hanks
Cast Away	Helen Hunt
Cars	Owen Wilson
Cars	Paul Newman
Cars	Bonnie Hunt
The Witch and the Wardrobe	William Moseley
The Witch and the Wardrobe	Anna Popplewell
The Witch and the Wardrobe	Skandar Keynes
The last stand	Hugh Jackman
The last stand	Halle BerryIan
The last stand	McKellen
War of the Worlds	Tom Cruise
War of the Worlds	Dakota Fanning
War of the Worlds	Justin Chatwin
MI3	Tom Cruise
MI3	Philip Seymour Hoffman
MI3	Ving Rhames
King Kong	Naomi Watts
King Kong	Jack Black
King Kong	Adrien Brody
What Women Want	Mel Gibson
What Women Want	Helen Hunt
Superman Returns	Brandon Routh
Superman Returns	Kate Bosworth
Superman Returns	James Marsden
Madagascar	Ben Stiller
Madagascar	Chris Rock
Madagascar	David Schwimmer
Happy feet	Brittany Murphy
Happy feet	Hugh Jackman
Happy feet	Nicole Kidman
Mr. & Mrs. Smith	Angelina Jolie
Mr. & Mrs. Smith	Brad Pitt
Mr. & Mrs. Smith	Vince Vaughn
Charlie and the Chocolate Factory	Johnny Depp
Charlie and the Chocolate Factory	Freddie Highmore
Charlie and the Chocolate Factory	David Kelly
Dinosaur	D. B. Sweeney
Dinosaur	Ossie Davis
Batman Begins	Christian Bale
Batman Begins	Michael Caine
Batman Begins	Liam Neeson
Hitch	Will Smith
Hitch	Eva Mendes
Hitch	Kevin James
Meet the Parents	Robert De Niro
Meet the Parents	Ben Stiller
Harry Potter and the Philosophers Stone	Daniel Radcliffe
Harry Potter and the Philosophers Stone	Rupert Grint
Harry Potter and the Philosophers Stone	Emma Watson
The Perfect Storm	George Clooney
The Perfect Storm	Mark Wahlberg
X-Men	Patrick Stewart
X-Men	Hugh Jackman
The Fellowship of the Ring	Elijah wood
The Fellowship of the Ring	Sean Bean
The Fellowship of the Ring	Orlando Bloom
What Lies Beneath	Harrison Ford
What Lies Beneath	Michelle Pfeiffer
What Lies Beneath	Diana Scarwid
Toy Story 2	Tom Hanks
Toy Story 2	Tim Allen
Monsters Inc	John Goodman
Monsters Inc	Billy Crystal
Shrek	Mike Myers
Shrek	Eddie Murphy
Shrek	Cameron Diaz
X-Men 2	patrick stewart
X-Men 2	hugh Jackman
X-Men 2	halle belly
Oceans Eleven	George Clooney
Oceans Eleven	Brad Pitt
Oceans Eleven	Matt Damon
Return of the king	Elijah Wood
Return of the king	Viggo Mortensen
Return of the king	Ian McKellen
The Curse of the Black Pearl	Johnny Depp
The Curse of the Black Pearl	Geoffrey Rush
The Curse of the Black Pearl	Orlando Bloom
Pearl Harbor	Ben Affleck
Pearl Harbor	Alec Baldwin
Pearl Harbor	Kate Beckinsale
The Italian Job	Donald Sutherland
The Italian Job	Mark Wahlberg
The Italian Job	Edward Norton
\.


--
-- Data for Name: movie; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY movie (moviename, yearofrelease, producer, director) FROM stdin;
Dead Mans Chest	2006	Jerry Bruckheimer	Gore Verbinski
The Da vinci code	2006	Brian Grazer	Ron Howard
Mission Impossible II	2000	Tom Cruise	John Woo
The Meltdown	2006	Lori Forte	Carlos Saldanha
Casino Royale	2006	Barbara Broccoli	Martin Campbell
Harry Potter and the Goblet of Fire	2005	David Heyman	Mike Newell
Night at the museum	2006	Shawn Levy	Shawn Levy
Gladiator	2000	Douglas Wick	Ridley Scott
Revenge of the Sith	2005	Rick McCallum	George Lucas
Cast Away	2000	Jack Rapke	Robert Zemeckis
Cars	2006	Darla K. Anderson	John Lasseter
The Witch and the Wardrobe	2005	Mark Johnson	Andrew Adamson
The last stand	2006	Lauren Shuler Donner	Brett Ratner
War of the Worlds	2005	Kathleen Kennedy	Steven Spielberg
MI3	2006	Tom Cruise	J. J. Abrams
King Kong	2005	Jan Blenkin	Peter Jackson
What Women Want	2000	Susan Cartsonis	Nancy Meyers
Superman Returns	2006	Jon Peters	Bryan Singer
Madagascar	2005	Mireille Soria	Eric Darnell:Tom McGrath
Happy feet	2006	Bill Miller	George Miller
Mr. & Mrs. Smith	2005	Akiva Goldsman	Doug Liman
Charlie and the Chocolate Factory	2005	Brad Grey	Tim Burton
Dinosaur	2000	Pam Marsden	Eric Leighton
Batman Begins	2005	Charles Roven	Christopher Nolan
Hitch	2005	James Lassiter	Andy Tennant
Meet the Parents	2000	Robert De Niro	Jay Roach
Harry Potter and the Philosophers Stone	2001	David Heyman	Chris columbus
The Perfect Storm	2000	Gail Katz	Wolfgang Petersen
X-Men	2000	Lauren Shuler Donner	Bryan Singer
The Fellowship of the Ring	2001	Peter Jackson	Peter Jackson
What Lies Beneath	2000	Steve Starkey	Robert Zemeckis
Toy Story 2	2000	Helene Plotkin	John Lasseter
Monsters Inc	2001	Darla K. Anderson	Pete Doctor
Shrek	2001	Aron Warner	Andrew Adamson
X-Men 2	2003	Ralph Winter	Bryan Singer
Oceans Eleven	2001	Jerry Weintraub	Steven Soderbergh
Return of the king	2003	Peter Jackson	Peter Jackson
The Curse of the Black Pearl	2003	Jerry Bruckheimer	Gore Verbinski
Pearl Harbor	2001	Jerry Bruckheimer	Michael Bay
The Italian Job	2003	Donald De Line	F. Gary Gray
\.


--
-- Data for Name: movieawards; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY movieawards (moviename, yearofaward, awardname) FROM stdin;
Dead Mans Chest	2006	Best Actor
The Da vinci code	2006	Best Actor
Mission Impossible II	2000	Best Actor
The Meltdown	2006	Best Actor
Casino Royale	2006	Best Movie
Harry Potter and the Goblet of Fire	2005	Best Actor
Night at the museum	2006	Best Actor
Gladiator	2000	Best Actor
Revenge of the Sith	2005	Best Actor
Cast Away	2000	Best Actor
Cars	2006	Best Movie
The Witch and the Wardrobe	2005	Best Director
The last stand	2006	Best Director
War of the Worlds	2005	Best Director
MI3	2006	Best Director
King Kong	2005	Best Director
What Women Want	2000	Best Director
Superman Returns	2006	Best Director
Madagascar	2005	Best Director
Happy feet	2006	Best Director
Mr. & Mrs. Smith	2005	Best Director
Charlie and the Chocolate Factory	2005	Best Director
Dinosaur	2000	Best Director
Batman Begins	2005	Best Director
Hitch	2005	Best Movie
Meet the Parents	2000	Best Movie
Harry Potter and the Philosophers Stone	2001	Best Movie
The Perfect Storm	2000	Best Movie
X-Men	2000	Best Movie
The Fellowship of the Ring	2001	Best Movie
What Lies Beneath	2000	Best Movie
Toy Story 2	2000	Best Movie
Monsters Inc	2001	Best Movie
Shrek	2001	Best Movie
X-Men 2	2003	Best Movie
Oceans Eleven	2001	Best Movie
Return of the king	2003	Best Movie
The Curse of the Black Pearl	2003	Best Movie
Pearl Harbor	2001	Best Movie
The Italian Job	2003	Best Movie
\.


--
-- Data for Name: movieperson; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY movieperson (name, address, phonenumber, emailid) FROM stdin;
Donald Sutherland	31 New Jersey USA	9000	donaldsutherland@yahoo.com
Cameron Diaz	40 New Jersey USA	9001	camerondiaz@gmail.com
Tim Burton	13 Monster State USA	9002	timburton@rediff.com
Kevin James	41 New Jersey USA	9003	kevinjames@yahoo.com
Patrick Stewart	3 Charlies Town USA	9004	patrickstewart@gmail.com
Russell Crowe	190 New Jersey USA	9005	russellcrowe@rediff.com
Keira Knightley	27 New Jersey USA	9006	keiraknightley@yahoo.com
Akiva Goldsman	MI6 HQ London UK	9007	akivagoldsman@gmail.com
Kate Bosworth	53 New Jersey USA	9008	katebosworth@rediff.com
Steve Starkey	Washignton CA 16-17 USA	9009	stevestarkey@yahoo.com
Angelina Jolie	Washignton CA 13-14 USA	9010	angelinajolie@gmail.com
Matt Damon	26 New Jersey USA	9011	mattdamon@rediff.com
Tim Allen	319 New Jersey USA	9012	timallen@yahoo.com
Ossie Davis	43 Descendant Town USA	9013	ossiedavis@gmail.com
Thandie Newton	Flinstones New york USA	9014	thandienewton@rediff.com
William Moseley	Washignton CA 23-24 USA	9015	williammoseley@yahoo.com
Adrien Brody	Abs Beverly Hills CA 90210-3604 USA	9016	adrienbrody@gmail.com
Gore Verbinski	Washignton CA 20-21 USA	9017	goreverbinski@rediff.com
David Heyman	Washignton CA 19-20 USA	9018	davidheyman@yahoo.com
Michael Caine	Washignton CA 15-16 USA	9019	michaelcaine@gmail.com
Audrey TautouIan	Pirates Inn Beverly Hills CA 90210-3604 USA	9020	audreytautouian@rediff.com
Andrew Adamson	Washignton 16 USA	9021	andrewadamson@yahoo.com
Jon Peters	87 Paulo Alto USA	9022	jonpeters@gmail.com
David Kelly	89 New Jersey USA	9023	davidkelly@rediff.com
Jack Black	16 New Jersey	9024	jackblack@yahoo.com
Joaquin Phoenix	219 New Jersey USA	9025	joaquinphoenix@gmail.com
Eddie Murphy	113 New Jersey USA	9026	eddiemurphy@rediff.com
Brad Grey	15 New Jersey	9027	bradgrey@yahoo.com
Philip Seymour Hoffman	45 Penn State Ohio USA	9028	philipseymourhoffman@gmail.com
David Schwimmer	28 New Jersey USA	9029	davidschwimmer@rediff.com
Rupert Grint	25 New Jersey USA	9030	rupertgrint@yahoo.com
Nicole Kidman	Washignton CA 17-18 USA	9031	nicolekidman@gmail.com
Charles Roven	29 New Jersey USA	9032	charlesroven@rediff.com
Mark Wahlberg	Washignton CA 21-22 USA	9033	markwahlberg@yahoo.com
Diana Scarwid	23 Beverly Hills USA	9034	dianascarwid@gmail.com
Natalie Portman	Washignton 21-32 USA	9035	natalieportman@rediff.com
Brandon Routh	Washignton CA 18-19 USA	9036	brandonrouth@yahoo.com
Edward Norton	14 New Jersey USA	9037	edwardnorton@gmail.com
Darla K. Anderson	Washignton CA 14-15 USA	9038	darlak.anderson@rediff.com
Jerry Bruckheimer	115 New Jersey USA	9039	jerrybruckheimer@yahoo.com
Dakota Fanning	Washignton 12-13 USA	9040	dakotafanning@gmail.com
Carla Gugino	Forrest Beverly Hills CA 90210-2204 USA	9041	carlagugino@rediff.com
D. B. Sweeney	43 bon temps usa	9042	d.b.sweeney@yahoo.com
Pete Doctor	23 Isle Verna Jurrasic	9043	petedoctor@gmail.com
Skandar Keynes	Cell 23 Azkaban Prison	9044	skandarkeynes@rediff.com
Halle BerryIan	32 Princeton Avenue New jersey USA	9045	halleberryian@yahoo.com
Denis Leary	Mirfield Yorkshire England UK	9046	denisleary@gmail.com
Ralph Winter	Cedar Rapids Iowa USA	9047	ralphwinter@rediff.com
Liam Neeson	Manhattan New York City New York USA	9048	liamneeson@yahoo.com
Mike Newell	Dorchester Boston Massachusetts USA	9049	mikenewell@gmail.com
patrick stewart	Boston Massachusetts USA	9050	patrickstewart@rediff.com
Naomi Watts	Melbourne Victoria Australia	9051	naomiwatts@yahoo.com
John Leguizamo	Catskill Mountains New York USA	9052	johnleguizamo@gmail.com
Doug Liman	London England UK	9053	dougliman@rediff.com
Michelle Pfeiffer	Boston Massachusetts USA	9054	michellepfeiffer@yahoo.com
Christian Bale	Grass Valley California USA	9055	christianbale@gmail.com
Ian McKellen	Villey USA	9056	ianmckellen@rediff.com
Robert Zemeckis	New Jersey USA	9057	robertzemeckis@yahoo.com
Paul Newman	MC Hill USA	9058	paulnewman@gmail.com
George Lucas	Old Palace London	9059	georgelucas@rediff.com
Ron Howard	A.S Church London	9060	ronhoward@yahoo.com
Eric Leighton	Bernado USA	9061	ericleighton@gmail.com
Elijah wood	Nahrin Point NewYork	9062	elijahwood@rediff.com
Nancy Meyers	Dwayne Church France	9063	nancymeyers@yahoo.com
Pam Marsden	George tub Germony	9064	pammarsden@gmail.com
Susan Cartsonis	31 New Jersey USA	9065	susancartsonis@rediff.com
Bonnie Hunt	40 New Jersey USA	9066	bonniehunt@yahoo.com
Harrison Ford	13 Monster State USA	9067	harrisonford@gmail.com
Douglas Wick	41 New Jersey USA	9068	douglaswick@rediff.com
Jerry Weintraub	3 Charlies Town USA	9069	jerryweintraub@yahoo.com
Alec Baldwin	190 New Jersey USA	9070	alecbaldwin@gmail.com
Eva Green	27 New Jersey USA	9071	evagreen@rediff.com
halle belly	MI6 HQ London UK	9072	hallebelly@yahoo.com
Ewan McGregor	53 New Jersey USA	9073	ewanmcgregor@gmail.com
Ben Affleck	Washignton CA 16-17 USA	9074	benaffleck@rediff.com
Tom Cruise	Washignton CA 13-14 USA	9075	tomcruise@yahoo.com
Samuel L. Jackson	26 New Jersey USA	9076	samuell.jackson@gmail.com
Michael Bay	319 New Jersey USA	9077	michaelbay@rediff.com
Chris columbus	43 Descendant Town USA	9078	chriscolumbus@yahoo.com
Geoffrey Rush	Flinstones New york USA	9079	geoffreyrush@gmail.com
Mark Johnson	Washignton CA 23-24 USA	9080	markjohnson@rediff.com
Anthony Daniels	Abs Beverly Hills CA 90210-3604 USA	9081	anthonydaniels@yahoo.com
Robert De Niro	Washignton CA 20-21 USA	9082	robertdeniro@gmail.com
Anna Popplewell	Washignton CA 19-20 USA	9083	annapopplewell@rediff.com
Will Smith	Washignton CA 15-16 USA	9084	willsmith@yahoo.com
Kathleen Kennedy	Pirates Inn Beverly Hills CA 90210-3604 USA	9085	kathleenkennedy@gmail.com
John Lasseter	Washignton 16 USA	9086	johnlasseter@rediff.com
Freddie Highmore	87 Paulo Alto USA	9087	freddiehighmore@yahoo.com
Bryan Singer	89 New Jersey USA	9088	bryansinger@gmail.com
Dougray Scott	16 New Jersey	9089	dougrayscott@rediff.com
Christopher Lee	219 New Jersey USA	9090	christopherlee@yahoo.com
Ian McDiarmid	113 New Jersey USA	9091	ianmcdiarmid@gmail.com
Hayden Christensen	15 New Jersey	9092	haydenchristensen@rediff.com
Daniel Radcliffe	45 Penn State Ohio USA	9093	danielradcliffe@yahoo.com
George Clooney	28 New Jersey USA	9094	georgeclooney@gmail.com
Steven Soderbergh	25 New Jersey USA	9095	stevensoderbergh@rediff.com
Ridley Scott	Washignton CA 17-18 USA	9096	ridleyscott@yahoo.com
Chris Rock	29 New Jersey USA	9097	chrisrock@gmail.com
Rick McCallum	Washignton CA 21-22 USA	9098	rickmccallum@rediff.com
Daniel Craig	23 Beverly Hills USA	9099	danielcraig@yahoo.com
Brett Ratner	Washignton 21-32 USA	9100	brettratner@gmail.com
Brittany Murphy	Washignton CA 18-19 USA	9101	brittanymurphy@rediff.com
Jay Roach	14 New Jersey USA	9102	jayroach@yahoo.com
Lori Forte	Washignton CA 14-15 USA	9103	loriforte@gmail.com
Gail Katz	115 New Jersey USA	9104	gailkatz@rediff.com
Johnny Depp	Washignton 12-13 USA	9105	johnnydepp@yahoo.com
Frank Oz	Forrest Beverly Hills CA 90210-2204 USA	9106	frankoz@gmail.com
Helene Plotkin	43 bon temps usa	9107	heleneplotkin@rediff.com
Mads Mikkelsen	23 Isle Verna Jurrasic	9108	madsmikkelsen@yahoo.com
Orlando Bloom	Cell 23 Azkaban Prison	9109	orlandobloom@gmail.com
Shawn Levy	32 Princeton Avenue New jersey USA	9110	shawnlevy@rediff.com
Brad Pitt	Mirfield Yorkshire England UK	9111	bradpitt@yahoo.com
George Miller	Cedar Rapids Iowa USA	9112	georgemiller@gmail.com
John Goodman	Manhattan New York City New York USA	9113	johngoodman@rediff.com
Eva Mendes	Dorchester Boston Massachusetts USA	9114	evamendes@yahoo.com
Barbara Broccoli	Boston Massachusetts USA	9115	barbarabroccoli@gmail.com
Elijah Wood	Melbourne Victoria Australia	9116	elijahwood@rediff.com
Vince Vaughn	Catskill Mountains New York USA	9117	vincevaughn@yahoo.com
Mel Gibson	London England UK	9118	melgibson@gmail.com
Kate Beckinsale	Boston Massachusetts USA	9119	katebeckinsale@rediff.com
John Woo	Grass Valley California USA	9120	johnwoo@yahoo.com
Steven Spielberg	Villey USA 	9121	stevenspielberg@gmail.com
Sean Bean	New Jersey USA	9122	seanbean@rediff.com
Owen Wilson	MC Hill USA	9123	owenwilson@yahoo.com
Carlos Saldanha	Old Palace London	9124	carlossaldanha@gmail.com
Kenny Baker	A.S Church London	9125	kennybaker@rediff.com
James Marsden	Bernado USA	9126	jamesmarsden@yahoo.com
Brian Grazer	Nahrin Point NewYork	9127	briangrazer@gmail.com
McKellen	Dwayne Church France	9128	mckellen@rediff.com
Wolfgang Petersen	George tub Germony	9129	wolfgangpetersen@yahoo.com
Ving Rhames	14 New Jersey USA	9130	vingrhames@gmail.com
Donald De Line	Washignton CA 14-15 USA	9131	donalddeline@rediff.com
J. J. Abrams	115 New Jersey USA	9132	j.j.abrams@yahoo.com
Justin Chatwin	Washignton 12-13 USA	9133	justinchatwin@gmail.com
Ben Stiller	Forrest Beverly Hills CA 90210-2204 USA	9134	benstiller@rediff.com
Peter Jackson	43 bon temps usa	9135	peterjackson@yahoo.com
Mireille Soria	23 Isle Verna Jurrasic	9136	mireillesoria@gmail.com
Jan Blenkin	Cell 23 Azkaban Prison	9137	janblenkin@rediff.com
Martin Campbell	32 Princeton Avenue New jersey USA	9138	martincampbell@yahoo.com
F. Gary Gray	Mirfield Yorkshire England UK	9139	f.garygray@gmail.com
Aron Warner	Cedar Rapids Iowa USA	9140	aronwarner@rediff.com
Mike Myers	Manhattan New York City New York USA	9141	mikemyers@yahoo.com
Lauren Shuler Donner	Dorchester Boston Massachusetts USA	9142	laurenshulerdonner@gmail.com
Billy Crystal	Boston Massachusetts USA	9143	billycrystal@rediff.com
hugh Jackman	Melbourne Victoria Australia	9144	hughjackman@yahoo.com
Andy Tennant	Catskill Mountains New York USA	9145	andytennant@gmail.com
Tom Hanks	London England UK	9146	tomhanks@rediff.com
Helen Hunt	Boston Massachusetts USA	9147	helenhunt@yahoo.com
Bill Miller	Grass Valley California USA	9148	billmiller@gmail.com
Christopher Nolan	Villey USA	9149	christophernolan@rediff.com
Jack Rapke	New Jersey USA	9150	jackrapke@yahoo.com
Emma Watson	MC Hill USA	9151	emmawatson@gmail.com
Hugh Jackman	Old Palace London	9152	hughjackman@rediff.com
Eric Darnell:Tom McGrath	A.S Church London	9153	ericdarnell:tommcgrath@yahoo.com
Ray Romano	Bernado USA	9154	rayromano@gmail.com
James Lassiter	Nahrin Point NewYork	9155	jameslassiter@rediff.com
Viggo Mortensen	Dwayne Church France	9156	viggomortensen@yahoo.com
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY users (username, password, role) FROM stdin;
user1	pass1	reader
user2	pass2	writer
user3	pass3	reader
user4	pass4	writer
\.


--
-- Name: movie_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY movie
    ADD CONSTRAINT movie_pkey PRIMARY KEY (moviename);


--
-- Name: movieperson_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY movieperson
    ADD CONSTRAINT movieperson_pkey PRIMARY KEY (name);


--
-- Name: users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (username);


--
-- Name: castings_actor_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY castings
    ADD CONSTRAINT castings_actor_fkey FOREIGN KEY (actor) REFERENCES movieperson(name);


--
-- Name: castings_moviename_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY castings
    ADD CONSTRAINT castings_moviename_fkey FOREIGN KEY (moviename) REFERENCES movie(moviename);


--
-- Name: movieawards_moviename_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY movieawards
    ADD CONSTRAINT movieawards_moviename_fkey FOREIGN KEY (moviename) REFERENCES movie(moviename);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

