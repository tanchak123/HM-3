## FINAL script of created table
*      CREATE PROCEDURE Save_On_Db(texter varchar(255))
       	LANGUAGE SQL
        AS $$
            INSERT INTO text_processor (text) values (texter);
        $$;
       create domain clob as text;     
       CREATE TABLE IF NOT EXISTS text_processor (
                   text_id serial PRIMARY KEY,
                   text clob
             );
## Some Description
* Create connection with our db.
* Create class PostgreTestProcessor with save and get method.
* Create package connection with ConnectionUtil class.
* Load dependency postgresql on our pom.xml.
* On our Connection class make static block with load our "org.postgresql.Driver" on System.
* Test connection with our psvm with method on ConnectionUtill class get connection.
* Create our table:
*     CREATE TABLE IF NOT EXISTS text_processor (
      	text_id serial PRIMARY KEY,
      	name varchar(255)
      );
* Rename our column:
*     ALTER TABLE "text_processor" rename column "name" to "text";
* Now let's work with our method on PostgreTextProcessor class
* Let's create refresh void for our table(for myself):
*     DELETE FROM text_processor
*     ALTER SEQUENCE text_processor_text_id_seq RESTART WITH 1
* Save fuction:
*     "INSERT INTO text_processor(text) values (?)"
* Get fuction:
*     "SELECT * FROM text_processor WHERE text_id = ?"
### CLOB task:
* The clob data type is unsupported in Postgres. However, it can be easily defined as a synonym.
* Just create domain and mark type clob:
*     create domain clob as text;
* now we can create clob type as synonym to 'text'
###Stored procedure task:
* We need save text by stored procedure
* Let's create our procedure
*     CREATE PROCEDURE Save_On_Db(texter varchar(255))
      	LANGUAGE SQL
       AS $$
           INSERT INTO text_processor (text) values (texter);
     	 $$;
* On our method call we should call our procedure:
*     "CALL save_on_db(?)"