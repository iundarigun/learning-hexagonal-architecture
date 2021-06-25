/******************************************************************/
/*************************     Bank              ******************/
/******************************************************************/
CREATE TABLE bank(
     id                    BIGSERIAL PRIMARY KEY,
     "name"                character varying(255)       NOT NULL,
     iban                  character varying(100)       NOT NULL,
     version               bigint                       NOT NULL DEFAULT 1,
     created_at            timestamp without time zone  NOT NULL,
     updated_at            timestamp without time zone  NOT NULL
);

ALTER TABLE ONLY bank
    ADD CONSTRAINT bank_unique01 UNIQUE (iban);

/******************************************************************/
/*************************     Customer          ******************/
/******************************************************************/
CREATE TABLE customer(
     id                    BIGSERIAL PRIMARY KEY,
     "name"                character varying(255)       NOT NULL,
     national_identifier   character varying(100)       NOT NULL,
     version               bigint                       NOT NULL DEFAULT 1,
     created_at            timestamp without time zone  NOT NULL,
     updated_at            timestamp without time zone  NOT NULL
);

ALTER TABLE ONLY customer
    ADD CONSTRAINT customer_unique01 UNIQUE (national_identifier);


/******************************************************************/
/*************************     Account          *******************/
/******************************************************************/
CREATE TABLE account(
     id                    BIGSERIAL PRIMARY KEY,
     amount                numeric(15,2)                NOT NULL,
     owner_id              bigint                       NOT NULL,
     bank_id               bigint                       NOT NULL,
     version               bigint                       NOT NULL DEFAULT 1,
     created_at            timestamp without time zone  NOT NULL,
     updated_at            timestamp without time zone  NOT NULL
);

ALTER TABLE ONLY account
    ADD CONSTRAINT account_unique01 UNIQUE (bank_id, owner_id);

/******************************************************************/
/*************************     Transfer         *******************/
/******************************************************************/
CREATE TABLE transfer(
    id                    BIGSERIAL PRIMARY KEY,
    amount                numeric(15,2)                NOT NULL,
    tax                   numeric(15,2)                NOT NULL,
    origin_id             bigint                       NOT NULL,
    destination_id        bigint                       NOT NULL,
    transfer_at           timestamp without time zone  NOT NULL,
    version               bigint                       NOT NULL DEFAULT 1,
    created_at            timestamp without time zone  NOT NULL,
    updated_at            timestamp without time zone  NOT NULL
);

ALTER TABLE ONLY transfer
    ADD CONSTRAINT transfer_unique01 UNIQUE (origin_id, destination_id, transfer_at);

/************************************************/
/**               Foreign Key                  **/
/************************************************/
ALTER TABLE ONLY account
    ADD CONSTRAINT fk_account_bank_id
    FOREIGN KEY (bank_id)
    REFERENCES bank(id);

ALTER TABLE ONLY account
    ADD CONSTRAINT fk_account_owner_id
    FOREIGN KEY (owner_id)
    REFERENCES customer(id);

ALTER TABLE ONLY transfer
    ADD CONSTRAINT fk_transfer_origin_id
    FOREIGN KEY (origin_id)
    REFERENCES account(id);

ALTER TABLE ONLY transfer
    ADD CONSTRAINT fk_transfer_destination_id
    FOREIGN KEY (destination_id)
    REFERENCES account(id);
