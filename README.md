# byblios_150
# Small application for managing books and authors, using the Spring MVC framework and Java Server Pages (2)
A small web application for managing books and titles, using the Spring MVC framework, a small MySQL database, and Java Server Pages for the front end.

The data model consists of seven tables: books, collections, authors, publishers, a short list of novel types, and two tables for the access authoring schema. The RDBM-ORM mapping is implemented with the Hibernate persistence framework, using adnotations. There should be Many2Many bi-directional dependency type between these objects, but this particular model only uses one-direction ManyToMany

A first enhancement would be to add JUnit tests
