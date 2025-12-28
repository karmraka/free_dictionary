CREATE DATABASE freedictionary;

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    login_id VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
    );
    
CREATE TABLE dictionaries (
    id INTEGER NOT NULL REFERENCES users(id),
    dictionary_id SERIAL PRIMARY KEY,
    dictionary_name VARCHAR(50) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,CONSTRAINT user_dict_unique UNIQUE (id, dictionary_name)
    );

CREATE TABLE words (
    dictionary_id INTEGER NOT NULL REFERENCES dictionaries(dictionary_id),
    word_id SERIAL PRIMARY KEY,
    word_name VARCHAR(50) NOT NULL,
    word_definition TEXT,
    word_reference TEXT,
    word_tag VARCHAR(50),
    pos_x INTEGER DEFAULT 0,
    pos_y INTEGER DEFAULT 0,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT dict_word_unique UNIQUE (dictionary_id, word_name)
    );  