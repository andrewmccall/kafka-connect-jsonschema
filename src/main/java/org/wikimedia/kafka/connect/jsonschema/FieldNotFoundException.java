package org.wikimedia.kafka.connect.jsonschema;

import org.apache.kafka.connect.errors.DataException;

public class FieldNotFoundException extends DataException {

    private final String field;


    public FieldNotFoundException(String field) {
        super("");
        this.field = field;
    }

    public FieldNotFoundException(String field, FieldNotFoundException parent) {
        super(parent);
        this.field = field;
    }

    public String getPath() {
        return field + '.' + ((FieldNotFoundException)getCause()).getPath();
    }

    @Override
    public String getMessage() {
        return "Field " + getPath() + " was not found in the schema.";
    }
}
