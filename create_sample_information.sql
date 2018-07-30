-- Table: sample_information

-- DROP TABLE sample_information;
-- DROP SEQUENCE sample_information_informationnumber_seq;
-- DROP INDEX sample_information_ind01;

CREATE TABLE sample_information
(
  informationnumber bigint NOT NULL,
  title  character varying(200),
  content text,
  fromdate timestamp without time zone,
  informationlevel character varying(2),
  createdat timestamp without time zone,
  createdby character varying(75),
  modifiedat timestamp without time zone,
  modifiedby character varying(75),
  CONSTRAINT sample_information_pkey PRIMARY KEY (informationnumber)
)
WITH (
  OIDS=FALSE
);
CREATE SEQUENCE sample_information_informationnumber_seq;
ALTER TABLE public.sample_information ALTER COLUMN informationnumber SET DEFAULT nextval('sample_information_informationnumber_seq');
CREATE INDEX sample_information_ind01 ON public.sample_information(fromdate);

COMMENT ON TABLE sample_information
  IS 'お知らせ情報テーブル';
COMMENT ON COLUMN sample_information.informationnumber IS 'お知らせ番号';
COMMENT ON COLUMN sample_information.title IS 'タイトル';
COMMENT ON COLUMN sample_information.content IS '内容';
COMMENT ON COLUMN sample_information.fromdate IS '掲載開始日時';
COMMENT ON COLUMN sample_information.informationlevel IS 'お知らせ情報レベル';
COMMENT ON COLUMN sample_information.createdat IS '作成日';
COMMENT ON COLUMN sample_information.createdby IS '作成者';
COMMENT ON COLUMN sample_information.modifiedat IS '更新日';
COMMENT ON COLUMN sample_information.modifiedby IS '更新者';
