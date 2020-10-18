package ifce.tjw.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;

import static java.util.Objects.isNull;

@FacesConverter("localDateTimeFacesConverter")
public class LocalDateTimeFacesConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String stringValue) {

        if (isNull(stringValue) || stringValue.isEmpty()) {
            return null;
        }

        LocalDateTime localDateTime;

        try {
            localDateTime = LocalDateTime.parse(
                    stringValue.trim(),
                    DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").withZone(ZoneId.systemDefault()));

        } catch (DateTimeParseException e) {
            throw new ConverterException("O formato da data e hora deve ser dd/MM/yyyy HH:mm:ss.");
        }

        return localDateTime;

    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object localDateTimeValue) {
        return Optional.ofNullable(localDateTimeValue)
                .map(obj -> (LocalDateTime) localDateTimeValue)
                .map(dateTime -> dateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").withZone(ZoneId.systemDefault())))
                .orElse("");
    }
}
