import com.mcserby.training.refactoring.Helper;
import com.mcserby.training.refactoring.InternationalValues;
import com.mcserby.training.refactoring.Locale;
import com.mcserby.training.refactoring.Translation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.mcserby.training.refactoring.Helper.invokeMethod;

public class Mapper {
    private static Translation getTranslation(String name, String language) {
        return new Translation(Collections.singletonList(name), new Locale(language));
    }

    private static List<Translation> mapNames(List<InternationalValues> values) {
        List<Translation> translations = new ArrayList<>();
        for (Map.Entry<String, String> country : Helper.countries.entrySet()) {
            String name = values
                    .stream()
                    .map(iv -> invokeMethod(country.getKey()).getName())
                    .distinct()
                    .collect(Collectors.joining(" "));
            translations.add(getTranslation(name, country.getValue()));
        }
        return translations;
    }

    private static List<Translation> mapDescriptions(List<InternationalValues> values) {
        List<Translation> translations = new ArrayList<>();
        translations.add(getTranslation(values
                        .stream()
                        .map(iv -> iv.getUk().getDescription())
                        .findFirst()
                        .orElse("")
                , "en_uk"));
        String description;

        for (Map.Entry<String, String> country : Helper.countries.entrySet()) {
            if ("getUk".equals(country.getKey())) {
                continue;
            } else {
                description = values
                        .stream()
                        .map(r -> invokeMethod(country.getKey())
                                        .getDescription()
                                        .substring(0, Math.min(invokeMethod(country.getKey())
                                                .getDescription().length(), 253))
                                        .trim())
                        .findFirst().orElse("<NONE>");
            }
            translations.add(getTranslation(description, country.getValue()));
        }
        return translations;
    }
}
