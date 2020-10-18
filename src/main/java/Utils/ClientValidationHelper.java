package Utils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientValidationHelper implements IClientValidationHelper {

    public boolean ValidateClient(String name, String cpf, String login, String password)
    {
        SizeValidate(name, 8);
        SizeValidate(cpf,11,11);
        SizeValidate(login, 12,4);
        SizeValidate(password, 10);

        ValidateNameCharacters(name);
        ValidateCpfCharacters(cpf);
        return true;
    }


    private boolean SizeValidate(String field, int maxSize)
    {
        return field.length() <= maxSize;
    }

    private boolean SizeValidate(String field, int maxSize, int minSize)
    {
        return field.length() <= maxSize && field.length() >= minSize;
    }

    private boolean ValidateNameCharacters(String name) {

        // regex that finds everything that is not a letter
        final String regexName = "[^a-z]+";
        final Pattern pattern = Pattern.compile(regexName);
        final Matcher matcher = pattern.matcher(name);

        return !matcher.find();

    }

    private boolean ValidateCpfCharacters(String cpf) {
        final String regexCpf = "[^0-9]+";
        final Pattern pattern = Pattern.compile(regexCpf);
        final Matcher matcher = pattern.matcher(cpf);

        return !matcher.find();
    }

}
