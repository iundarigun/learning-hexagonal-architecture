INSERT INTO bank (id, name, iban, version, created_at, updated_at) VALUES
    (1, 'Santander', 'IB12345678', 0, now(), now()),
    (2, 'Sabadell',  'IB87654321', 0, now(), now());

select nextval('bank_id_seq');
select nextval('bank_id_seq');

INSERT INTO customer (id, name, national_identifier, version, created_at, updated_at) VALUES
    (1, 'John Smith',   '12345678',    0, now(), now()), -- User with restrictions
    (2, 'Michael Bird', '37789444711', 0, now(), now()),
    (3, 'Joseph Wells', '123445566',   0, now(), now());

select nextval('customer_id_seq');
select nextval('customer_id_seq');
select nextval('customer_id_seq');

INSERT INTO account (id, amount, owner_id, bank_id, version, created_at, updated_at) VALUES
    (1, 16190.00, 1, 1, 0, now(), now()),
    (2,  2899.00, 1, 2, 0, now(), now()),
    (3, 25890.00, 2, 2, 0, now(), now()),
    (4,     0.00, 3, 1, 0, now(), now());

select nextval('account_id_seq');
select nextval('account_id_seq');
select nextval('account_id_seq');
select nextval('account_id_seq');
