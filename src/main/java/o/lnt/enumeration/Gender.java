package o.lnt.enumeration;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum Gender {
    MALE, FEMALE
}
