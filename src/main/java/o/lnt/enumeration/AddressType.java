package o.lnt.enumeration;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum AddressType {
    HOME, OFFICE, PERSONAL, BUSINESS;
}
