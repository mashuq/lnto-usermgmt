package o.lnt.util;

import javax.validation.ConstraintViolation;
import java.util.Collection;
import java.util.stream.Collectors;

public class Util {

    public static final String EMPTY_STRING = "";

    private Util(){
        // Should not initialize static helper class
    }

    public static String getViolationMessages(Collection<? extends ConstraintViolation<?>> violations){
        if(null == violations || violations.isEmpty())return EMPTY_STRING;
        return violations.stream().map(cv -> cv.getMessage()).collect(Collectors.joining(", "));
    }
}
