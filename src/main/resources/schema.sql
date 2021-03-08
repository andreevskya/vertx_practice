CREATE TABLE houses
(
  id bigint NOT NULL,
  name TEXT,
  CONSTRAINT houses_pkey PRIMARY KEY (id)
);
COMMENT ON TABLE houses IS 'Дома. Всякий персонаж принадлежит какому-либо дому.';
COMMENT ON COLUMN houses.id IS 'Идентификатор дома.';
COMMENT ON COLUMN houses.name IS 'Назание дома';
------------------------------------------------------------------------------------------------------------------------
CREATE TABLE characters
(
  id bigint NOT NULL PRIMARY KEY,
  first_name TEXT,
  last_name TEXT,
  house_id bigint
);
ALTER TABLE characters ADD CONSTRAINT house_id_constraint FOREIGN KEY (house_id) REFERENCES houses (id);
COMMENT ON TABLE characters IS 'Справочник персонажей.';
COMMENT ON COLUMN characters.id IS 'Идентификатор персонажа.';
COMMENT ON COLUMN characters.first_name IS 'Имя персонажа.';
COMMENT ON COLUMN characters.last_name IS 'Фамилия персонажа.';
COMMENT ON COLUMN characters.house_id IS 'Дом, которому принадлежит персонаж.';
------------------------------------------------------------------------------------------------------------------------
CREATE TABLE character_movements
(
  id bigint NOT NULL PRIMARY KEY,
  delay_millis bigint,
  x real,
  y real,
  character_id bigint
);
ALTER TABLE character_movements ADD CONSTRAINT character_id_constraint FOREIGN KEY (character_id) REFERENCES characters (id);
COMMENT ON TABLE character_movements IS 'Перемещения персонажей.';
COMMENT ON COLUMN character_movements.id IS 'Идентификатор перемещения.';
COMMENT ON COLUMN character_movements.delay_millis IS 'Количество миллисекунд, который следует выждать перед отправкой перемещения клиенту.';
COMMENT ON COLUMN character_movements.x IS 'X координата перемещения.';
COMMENT ON COLUMN character_movements.y IS 'Y координата перемещения.';
COMMENT ON COLUMN character_movements.character_id IS 'Идентификатор персонажа, над которым выполняется перемещение.';
------------------------------------------------------------------------------------------------------------------------