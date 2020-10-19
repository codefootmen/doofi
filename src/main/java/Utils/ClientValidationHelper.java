package Utils;
import Model.Client;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientValidationHelper implements IClientValidationHelper {

    public boolean ValidateClient(Client client)
    {
        SizeValidate(client.getName(), 8);
        SizeValidate(client.getCpf(), 11,11);
        SizeValidate(client.getLogin(), 12,4);
        SizeValidate(client.getPassword(), 10);

        ValidateNameCharacters(client.getName());
        ValidateCpfCharacters(client.getCpf());
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
