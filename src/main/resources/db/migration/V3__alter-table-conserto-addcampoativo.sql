alter table consertos add ativo boolean;

update consertos set ativo = true;

ALTER TABLE consertos ALTER COLUMN ativo SET NOT NULL;