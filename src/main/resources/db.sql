CREATE PROCEDURE Save_On_Db(texter varchar(255))
    LANGUAGE SQL
AS $$
INSERT INTO text_processor (text) values (texter);
$$;
create domain clob as text;
CREATE TABLE IF NOT EXISTS text_processor (
                                              text_id serial PRIMARY KEY,
                                              text clob
);