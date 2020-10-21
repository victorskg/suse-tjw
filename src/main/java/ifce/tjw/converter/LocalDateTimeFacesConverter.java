package ifce.tjw.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

import static java.time.ZoneId.systemDefault;
import static java.time.format.DateTimeFormatter.ofPattern;
import static java.util.Objects.isNull;
import static java.util.Optional.ofNullable;

@FacesConverter("localDateTimeFacesConverter")
public class LocalDateTimeFacesConverter implements Converter<LocalDateTime> {

    @Override
    public LocalDateTime getAsObject(FacesContext context, UIComponent component, String stringValue) {
        if (isNull(stringValue) || stringValue.isEmpty()) {
            return null;
        }

        LocalDateTime localDateTime;

        try {
            localDateTime = LocalDateTime.parse(stringValue.trim(), ofPattern("dd/MM/yyyy HH:mm:ss").withZone(systemDefault()));

        } catch (DateTimeParseException e) {
            throw new ConverterException("O formato da data e hora deve ser dd/MM/yyyy HH:mm:ss.");
        }

        return localDateTime;

    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, LocalDateTime localDateTime) {
        return ofNullable(localDateTime)
                .map(obj -> localDateTime)
                .map(dateTime -> dateTime.format(ofPattern("dd/MM/yyyy HH:mm:ss").withZone(systemDefault())))
                .orElse("");
    }
}
